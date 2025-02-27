package mekanism.common.content.tank;

import mekanism.api.gas.GasStack;
import mekanism.common.multiblock.MultiblockCache;
import mekanism.common.util.FluidContainerUtils.ContainerEditMode;
import mekanism.common.util.NonNullListSynchronized;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fluids.FluidStack;

public class TankCache extends MultiblockCache<SynchronizedTankData> {

    public NonNullList<ItemStack> inventory = NonNullListSynchronized.withSize(2, ItemStack.EMPTY);

    public FluidStack fluid;

    public GasStack gas;

    public ContainerEditMode editMode = ContainerEditMode.BOTH;

    @Override
    public void apply(SynchronizedTankData data) {
        data.inventory = inventory;
        data.fluidStored = fluid;
        data.gasstored = gas;
        data.editMode = editMode;
    }

    @Override
    public void sync(SynchronizedTankData data) {
        inventory = data.inventory;
        fluid = data.fluidStored;
        gas = data.gasstored;
        editMode = data.editMode;
    }

    @Override
    public void load(NBTTagCompound nbtTags) {
        editMode = ContainerEditMode.values()[nbtTags.getInteger("editMode")];
        NBTTagList tagList = nbtTags.getTagList("Items", NBT.TAG_COMPOUND);
        inventory = NonNullListSynchronized.withSize(2, ItemStack.EMPTY);

        for (int tagCount = 0; tagCount < tagList.tagCount(); tagCount++) {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(tagCount);
            byte slotID = tagCompound.getByte("Slot");
            if (slotID >= 0 && slotID < 2) {
                inventory.set(slotID, new ItemStack(tagCompound));
            }
        }
        if (nbtTags.hasKey("cachedFluid")) {
            fluid = FluidStack.loadFluidStackFromNBT(nbtTags.getCompoundTag("cachedFluid"));
        }
        if (nbtTags.hasKey("cachedGas")){
            gas = GasStack.readFromNBT(nbtTags.getCompoundTag("cachedGas"));
        }
    }

    @Override
    public void save(NBTTagCompound nbtTags) {
        nbtTags.setInteger("editMode", editMode.ordinal());
        NBTTagList tagList = new NBTTagList();
        for (int slotCount = 0; slotCount < 2; slotCount++) {
            if (!inventory.get(slotCount).isEmpty()) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) slotCount);
                inventory.get(slotCount).writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTags.setTag("Items", tagList);
        if (fluid != null) {
            nbtTags.setTag("cachedFluid", fluid.writeToNBT(new NBTTagCompound()));
        }
        if (gas !=null){
            nbtTags.setTag("cachedGas",gas.write(new NBTTagCompound()));
        }
    }
}
