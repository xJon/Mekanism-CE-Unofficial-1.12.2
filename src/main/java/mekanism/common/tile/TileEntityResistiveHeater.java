package mekanism.common.tile;

import io.netty.buffer.ByteBuf;
import mekanism.api.Coord4D;
import mekanism.api.IHeatTransfer;
import mekanism.api.TileNetworkList;
import mekanism.common.Mekanism;
import mekanism.common.base.IRedstoneControl;
import mekanism.common.block.states.BlockStateMachine.MachineType;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.config.MekanismConfig;
import mekanism.common.integration.computer.IComputerIntegration;
import mekanism.common.security.ISecurityTile;
import mekanism.common.tile.component.TileComponentSecurity;
import mekanism.common.tile.prefab.TileEntityEffectsBlock;
import mekanism.common.util.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nonnull;

public class TileEntityResistiveHeater extends TileEntityEffectsBlock implements IHeatTransfer, IComputerIntegration, IRedstoneControl, ISecurityTile {

    private static final int[] SLOTS = {0};

    private static final String[] methods = new String[]{"getEnergy", "getMaxEnergy", "getTemperature", "setEnergyUsage"};
    public double energyUsage = 100;
    public double temperature;
    public double heatToAbsorb = 0;
    /**
     * Whether or not this machine is in it's active state.
     */
    public boolean isActive;
    /**
     * The client's current active state.
     */
    public boolean clientActive;
    /**
     * How many ticks must pass until this block's active state can sync with the client.
     */
    public int updateDelay;
    public float soundScale = 1;
    public double lastEnvironmentLoss;
    public RedstoneControl controlType = RedstoneControl.DISABLED;
    public TileComponentSecurity securityComponent = new TileComponentSecurity(this);

    public TileEntityResistiveHeater() {
        super("machine.resistiveheater", "ResistiveHeater", MachineType.RESISTIVE_HEATER.getStorage());
        inventory = NonNullListSynchronized.withSize(SLOTS.length, ItemStack.EMPTY);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (world.isRemote && updateDelay > 0) {
            updateDelay--;
            if (updateDelay == 0 && clientActive != isActive) {
                isActive = clientActive;
                MekanismUtils.updateBlock(world, getPos());
            }
        }

        if (!world.isRemote) {
            boolean packet = false;
            if (updateDelay > 0) {
                updateDelay--;
                if (updateDelay == 0 && clientActive != isActive) {
                    packet = true;
                }
            }

            ChargeUtils.discharge(0, this);
            double toUse = 0;
            if (MekanismUtils.canFunction(this)) {
                toUse = Math.min(getEnergy(), energyUsage);
                heatToAbsorb += toUse / MekanismConfig.current().general.energyPerHeat.val();
                setEnergy(getEnergy() - toUse);
            }

            setActive(toUse > 0);
            double[] loss = simulateHeat();
            applyTemperatureChange();
            lastEnvironmentLoss = loss[1];
            float newSoundScale = (float) Math.max(0, toUse / 1E5);
            if (Math.abs(newSoundScale - soundScale) > 0.01) {
                packet = true;
            }

            soundScale = newSoundScale;
            if (packet) {
                Mekanism.packetHandler.sendUpdatePacket(this);
            }
        }
    }

    @Override
    public boolean sideIsConsumer(EnumFacing side) {
        return side == MekanismUtils.getLeft(facing) || side == MekanismUtils.getRight(facing);
    }

    @Override
    public boolean canSetFacing(@Nonnull EnumFacing facing) {
        return facing != EnumFacing.DOWN && facing != EnumFacing.UP;
    }

    @Override
    public void readCustomNBT(NBTTagCompound nbtTags) {
        super.readCustomNBT(nbtTags);
        energyUsage = nbtTags.getDouble("energyUsage");
        temperature = nbtTags.getDouble("temperature");
        clientActive = isActive = nbtTags.getBoolean("isActive");
        controlType = RedstoneControl.values()[nbtTags.getInteger("controlType")];
        maxEnergy = energyUsage * 400;
    }


    @Override
   public void writeCustomNBT(NBTTagCompound nbtTags) {
        super.writeCustomNBT(nbtTags);
        nbtTags.setDouble("energyUsage", energyUsage);
        nbtTags.setDouble("temperature", temperature);
        nbtTags.setBoolean("isActive", isActive);
        nbtTags.setInteger("controlType", controlType.ordinal());
    }

    @Override
    public void handlePacketData(ByteBuf dataStream) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            energyUsage = MekanismUtils.convertToJoules(dataStream.readInt());
            maxEnergy = energyUsage * 400;
            return;
        }

        super.handlePacketData(dataStream);
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            energyUsage = dataStream.readDouble();
            temperature = dataStream.readDouble();
            clientActive = dataStream.readBoolean();
            maxEnergy = dataStream.readDouble();
            soundScale = dataStream.readFloat();
            controlType = RedstoneControl.values()[dataStream.readInt()];
            lastEnvironmentLoss = dataStream.readDouble();
            if (updateDelay == 0 && clientActive != isActive) {
                updateDelay = MekanismConfig.current().general.UPDATE_DELAY.val();
                isActive = clientActive;
                MekanismUtils.updateBlock(world, getPos());
            }
        }
    }

    @Override
    public TileNetworkList getNetworkedData(TileNetworkList data) {
        super.getNetworkedData(data);

        data.add(energyUsage);
        data.add(temperature);
        data.add(isActive);
        data.add(maxEnergy);
        data.add(soundScale);
        data.add(controlType.ordinal());

        data.add(lastEnvironmentLoss);
        return data;
    }

    @Override
    public double getTemp() {
        return temperature;
    }

    @Override
    public double getInverseConductionCoefficient() {
        return 5;
    }

    @Override  //Try to fix the render lighting
    public boolean wasActiveRecently() {
        return getActive();
    }

    @Override
    public double getInsulationCoefficient(EnumFacing side) {
        return 1000;
    }

    @Override
    public void transferHeatTo(double heat) {
        heatToAbsorb += heat;
    }

    @Override
    public double[] simulateHeat() {
        return HeatUtils.simulate(this);
    }

    @Override
    public double applyTemperatureChange() {
        temperature += heatToAbsorb;
        heatToAbsorb = 0;
        return temperature;
    }

    @Override
    public boolean canConnectHeat(EnumFacing side) {
        return true;
    }

    @Override
    public IHeatTransfer getAdjacent(EnumFacing side) {
        TileEntity adj = Coord4D.get(this).offset(side).getTileEntity(world);
        if (CapabilityUtils.hasCapability(adj, Capabilities.HEAT_TRANSFER_CAPABILITY, side.getOpposite())) {
            return CapabilityUtils.getCapability(adj, Capabilities.HEAT_TRANSFER_CAPABILITY, side.getOpposite());
        }
        return null;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing side) {
        return capability == Capabilities.HEAT_TRANSFER_CAPABILITY || super.hasCapability(capability, side);
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing side) {
        if (capability == Capabilities.HEAT_TRANSFER_CAPABILITY) {
            return Capabilities.HEAT_TRANSFER_CAPABILITY.cast(this);
        }
        return super.getCapability(capability, side);
    }

    @Override
    public boolean getActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean active) {
        isActive = active;
        if (clientActive != active && updateDelay == 0) {
            Mekanism.packetHandler.sendUpdatePacket(this);
            updateDelay = 10;
            clientActive = active;
        }
    }

    @Override
    public boolean renderUpdate() {
        return false;
    }

    @Override
    public boolean lightUpdate() {
        return true;
    }

    @Override
    public String[] getMethods() {
        return methods;
    }

    @Override
    public Object[] invoke(int method, Object[] arguments) throws NoSuchMethodException {
        switch (method) {
            case 0 -> {
                return new Object[]{getEnergy()};
            }
            case 1 -> {
                return new Object[]{getMaxEnergy()};
            }
            case 2 -> {
                return new Object[]{temperature};
            }
            case 3 -> {
                if (arguments.length == 1) {
                    if (arguments[0] instanceof Double) {
                        energyUsage = (Double) arguments[0];
                        return new Object[]{"Set energy usage."};
                    }
                }
                return new Object[]{"Invalid parameters."};
            }
            default -> throw new NoSuchMethodException();
        }
    }

    @Override
    public RedstoneControl getControlType() {
        return controlType;
    }

    @Override
    public void setControlType(RedstoneControl type) {
        controlType = type;
    }

    @Override
    public boolean canPulse() {
        return false;
    }

    @Override
    public TileComponentSecurity getSecurity() {
        return securityComponent;
    }

    @Nonnull
    @Override
    public int[] getSlotsForFace(@Nonnull EnumFacing side) {
        return SLOTS;
    }

    @Override
    public boolean isItemValidForSlot(int slot, @Nonnull ItemStack stack) {
        return ChargeUtils.canBeDischarged(stack);
    }
}
