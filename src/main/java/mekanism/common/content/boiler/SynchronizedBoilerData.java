package mekanism.common.content.boiler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import mekanism.api.Coord4D;
import mekanism.api.IHeatTransfer;
import mekanism.api.gas.GasStack;
import mekanism.common.config.MekanismConfig;
import mekanism.common.content.tank.SynchronizedTankData.ValveData;
import mekanism.common.multiblock.SynchronizedData;
import mekanism.common.util.NonNullListSynchronized;
import mekanism.common.util.UnitDisplayUtils.TemperatureUnit;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;

import java.util.Map;
import java.util.Set;

public class SynchronizedBoilerData extends SynchronizedData<SynchronizedBoilerData> implements IHeatTransfer {

    public static Map<String, Boolean> clientHotMap = new Object2ObjectOpenHashMap<>();

    public static double CASING_INSULATION_COEFFICIENT = 1;
    public static double CASING_INVERSE_CONDUCTION_COEFFICIENT = 1;
    public static double BASE_BOIL_TEMP = 100 - (TemperatureUnit.AMBIENT.zeroOffset - TemperatureUnit.CELSIUS.zeroOffset);

    public FluidStack waterStored;
    public FluidStack prevWater;
    public FluidStack steamStored;
    public FluidStack prevSteam;
    public GasStack InputGas;
    public GasStack prevInputGas;
    public GasStack OutputGas;
    public GasStack prevOutputGas;

    public double lastEnvironmentLoss;
    public int lastBoilRate;
    public int lastMaxBoil;

    public boolean clientHot;

    public double temperature;

    public double heatToAbsorb;

    public double heatCapacity = 1000;

    public int superheatingElements;

    public int waterVolume;

    public int steamVolume;

    public NonNullList<ItemStack> inventory = NonNullListSynchronized.withSize(2, ItemStack.EMPTY);

    public Coord4D upperRenderLocation;

    public Set<ValveData> valves = new ObjectOpenHashSet<>();

    /**
     * @return how much heat energy is needed to convert one unit of water into steam
     */
    public static double getHeatEnthalpy() {
        return MekanismConfig.current().general.maxEnergyPerSteam.val() / MekanismConfig.current().general.energyPerHeat.val();
    }

    public double getHeatAvailable() {
        double heatAvailable = (temperature - BASE_BOIL_TEMP) * locations.size();
        return Math.min(heatAvailable, superheatingElements * MekanismConfig.current().general.superheatingHeatTransfer.val());
    }

    public boolean needsRenderUpdate() {
        if ((waterStored == null && prevWater != null) || (waterStored != null && prevWater == null)) {
            return true;
        }
        if (waterStored != null) {
            return ((waterStored.getFluid() != prevWater.getFluid()) || (waterStored.amount != prevWater.amount));
        }
        if ((steamStored == null && prevSteam != null) || (steamStored != null && prevSteam == null)) {
            return true;
        }
        if (steamStored != null) {
            return (steamStored.getFluid() != prevSteam.getFluid()) || (steamStored.amount != prevSteam.amount);
        }

        if ((InputGas == null && prevInputGas != null) || (InputGas != null && prevInputGas == null)) {
            return true;
        }
        if (InputGas != null) {
            return ((InputGas.getGas() != prevInputGas.getGas()) || (InputGas.amount != prevInputGas.amount));
        }

        if ((OutputGas== null && prevOutputGas != null) || (OutputGas != null && prevOutputGas == null)) {
            return true;
        }
        if (OutputGas != null) {
            return ((OutputGas.getGas() != prevOutputGas.getGas()) || (OutputGas.amount != prevOutputGas.amount));
        }
        return false;
    }

    @Override
    public NonNullList<ItemStack> getInventory() {
        return inventory;
    }

    @Override
    public double getTemp() {
        return temperature;
    }



    @Override
    public double getInverseConductionCoefficient() {
        return CASING_INVERSE_CONDUCTION_COEFFICIENT * locations.size();
    }

    @Override
    public double getInsulationCoefficient(EnumFacing side) {
        return CASING_INSULATION_COEFFICIENT * locations.size();
    }

    @Override
    public void transferHeatTo(double heat) {
        heatToAbsorb += heat;
    }

    @Override
    public double[] simulateHeat() {
        double invConduction = IHeatTransfer.AIR_INVERSE_COEFFICIENT + (CASING_INSULATION_COEFFICIENT + CASING_INVERSE_CONDUCTION_COEFFICIENT) * locations.size();
        double heatToTransfer = temperature / invConduction;
        transferHeatTo(-heatToTransfer);
        return new double[]{0, heatToTransfer};
    }

    @Override
    public double applyTemperatureChange() {
        temperature += heatToAbsorb / locations.size();
        heatToAbsorb = 0;
        return temperature;
    }

    @Override
    public boolean canConnectHeat(EnumFacing side) {
        return false;
    }

    @Override
    public IHeatTransfer getAdjacent(EnumFacing side) {
        return null;
    }
}
