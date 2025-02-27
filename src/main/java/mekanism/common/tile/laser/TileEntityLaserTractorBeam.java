package mekanism.common.tile.laser;

import io.netty.buffer.ByteBuf;
import mekanism.api.Coord4D;
import mekanism.api.TileNetworkList;
import mekanism.api.lasers.ILaserReceptor;
import mekanism.common.LaserManager;
import mekanism.common.LaserManager.LaserInfo;
import mekanism.common.Mekanism;
import mekanism.common.base.IComparatorSupport;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.config.MekanismConfig;
import mekanism.common.security.ISecurityTile;
import mekanism.common.tile.component.TileComponentSecurity;
import mekanism.common.tile.prefab.TileEntityContainerBlock;
import mekanism.common.util.InventoryUtils;
import mekanism.common.util.NonNullListSynchronized;
import mekanism.common.util.StackUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nonnull;
import java.util.List;

public class TileEntityLaserTractorBeam extends TileEntityContainerBlock implements ILaserReceptor, ISecurityTile, IComparatorSupport {

    public static final double MAX_ENERGY = 5E9;
    public static int[] availableSlotIDs = InventoryUtils.getIntRange(0, 26);
    public double collectedEnergy = 0;
    public double lastFired = 0;
    public boolean on = false;
    public Coord4D digging;
    public double diggingProgress;
    public TileComponentSecurity securityComponent = new TileComponentSecurity(this);

    public TileEntityLaserTractorBeam() {
        super("LaserTractorBeam");
        inventory = NonNullListSynchronized.withSize(27, ItemStack.EMPTY);
    }

    @Override
    public void receiveLaserEnergy(double energy, EnumFacing side) {
        setEnergy(getEnergy() + energy);
    }

    @Override
    public boolean canLasersDig() {
        return false;
    }

    @Override
    public void onUpdate() {
        if (world.isRemote) {
            if (on) {
                RayTraceResult mop = LaserManager.fireLaserClient(this, facing, lastFired, world);
                Coord4D hitCoord = mop == null ? null : new Coord4D(mop, world);
                if (hitCoord == null || !hitCoord.equals(digging)) {
                    digging = hitCoord;
                    diggingProgress = 0;
                }

                if (hitCoord != null) {
                    IBlockState blockHit = hitCoord.getBlockState(world);
                    TileEntity tileHit = hitCoord.getTileEntity(world);
                    float hardness = blockHit.getBlockHardness(world, hitCoord.getPos());
                    if (!(hardness < 0 || (LaserManager.isReceptor(tileHit, mop.sideHit) && !LaserManager.getReceptor(tileHit, mop.sideHit).canLasersDig()))) {
                        diggingProgress += lastFired;
                        if (diggingProgress < hardness * MekanismConfig.current().general.laserEnergyNeededPerHardness.val()) {
                            Mekanism.proxy.addHitEffects(hitCoord, mop);
                        }
                    }
                }

            }
        } else if (collectedEnergy > 0) {
            double firing = collectedEnergy;
            if (!on || firing != lastFired) {
                on = true;
                lastFired = firing;
                Mekanism.packetHandler.sendUpdatePacket(this);
            }

            LaserInfo info = LaserManager.fireLaser(this, facing, firing, world);
            Coord4D hitCoord = info.movingPos == null ? null : new Coord4D(info.movingPos, world);

            if (hitCoord == null || !hitCoord.equals(digging)) {
                digging = hitCoord;
                diggingProgress = 0;
            }

            if (hitCoord != null) {
                IBlockState blockHit = hitCoord.getBlockState(world);
                TileEntity tileHit = hitCoord.getTileEntity(world);
                float hardness = blockHit.getBlockHardness(world, hitCoord.getPos());

                if (!(hardness < 0 || (LaserManager.isReceptor(tileHit, info.movingPos.sideHit) && !LaserManager.getReceptor(tileHit, info.movingPos.sideHit).canLasersDig()))) {
                    diggingProgress += firing;
                    if (diggingProgress >= hardness * MekanismConfig.current().general.laserEnergyNeededPerHardness.val()) {
                        List<ItemStack> drops = LaserManager.breakBlock(hitCoord, false, world, pos);
                        if (drops != null) {
                            receiveDrops(drops);
                        }
                        diggingProgress = 0;
                    }
                }
            }
            setEnergy(getEnergy() - firing);
        } else if (on) {
            on = false;
            diggingProgress = 0;
            Mekanism.packetHandler.sendUpdatePacket(this);
        }
    }

    @Override
    public boolean supportsAsync() {
        return false;
    }

    public double getEnergy() {
        return collectedEnergy;
    }

    public void setEnergy(double energy) {
        collectedEnergy = Math.max(0, Math.min(energy, MAX_ENERGY));
    }

    public void receiveDrops(List<ItemStack> drops) {
        outer:
        for (ItemStack drop : drops) {
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).isEmpty()) {
                    inventory.set(i, drop);
                    continue outer;
                }
                ItemStack slot = inventory.get(i);
                if (StackUtils.equalsWildcardWithNBT(slot, drop)) {
                    int change = Math.min(drop.getCount(), slot.getMaxStackSize() - slot.getCount());
                    slot.grow(change);
                    drop.shrink(change);
                    if (drop.getCount() <= 0) {
                        continue outer;
                    }
                }
            }
            Block.spawnAsEntity(world, pos, drop);
        }
    }

    @Override
    public boolean canInsertItem(int i, @Nonnull ItemStack itemStack, @Nonnull EnumFacing side) {
        return false;
    }

    @Nonnull
    @Override
    public int[] getSlotsForFace(@Nonnull EnumFacing side) {
        return availableSlotIDs;
    }

    @Override
    public TileNetworkList getNetworkedData(TileNetworkList data) {
        super.getNetworkedData(data);
        data.add(on);
        data.add(collectedEnergy);
        data.add(lastFired);
        return data;
    }

    @Override
    public void handlePacketData(ByteBuf dataStream) {
        super.handlePacketData(dataStream);
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            on = dataStream.readBoolean();
            collectedEnergy = dataStream.readDouble();
            lastFired = dataStream.readDouble();
        }
    }

    @Override
    public TileComponentSecurity getSecurity() {
        return securityComponent;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing side) {
        return capability == Capabilities.LASER_RECEPTOR_CAPABILITY || super.hasCapability(capability, side);
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing side) {
        if (capability == Capabilities.LASER_RECEPTOR_CAPABILITY) {
            return Capabilities.LASER_RECEPTOR_CAPABILITY.cast(this);
        }
        return super.getCapability(capability, side);
    }

    @Override
    public int getRedstoneLevel() {
        return Container.calcRedstoneFromInventory(this);
    }
}
