package net.lomeli.power.item;

import java.text.DecimalFormat;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.lomeli.lomlib.util.LangUtil;
import net.lomeli.lomlib.util.NBTUtil;

import net.lomeli.power.lib.Config;
import net.lomeli.power.lib.ModNBT;

import cofh.api.energy.IEnergyContainerItem;

public class ItemFusionCore extends ItemPTBase implements IEnergyContainerItem {
    private final DecimalFormat formater = new DecimalFormat("###,###,###,###,###.###");

    public ItemFusionCore() {
        super("fusioncore");
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        if (stack != null)
            tooltip.add(LangUtil.translate("item.powertools.fusioncore.energy", formater.format(getEnergyStored(stack)), formater.format(getMaxEnergyStored(stack))));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        ItemStack empty = new ItemStack(itemIn);
        NBTUtil.setInteger(empty, ModNBT.STORED_ENERGY, 0);
        subItems.add(empty);
        ItemStack full = new ItemStack(itemIn);
        NBTUtil.setInteger(full, ModNBT.STORED_ENERGY, Config.fusionCoreCapacity);
        subItems.add(full);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        if (stack != null && stack.getItem() instanceof IEnergyContainerItem)
            return ((double) getMaxEnergyStored(stack) - (double) getEnergyStored(stack)) / (double) getMaxEnergyStored(stack);
        return 1d;
    }

    @Override
    public int receiveEnergy(ItemStack stack, int max, boolean simulate) {
        if (stack == null) return 0;
        int energy = NBTUtil.getInt(stack, ModNBT.STORED_ENERGY);
        int added = Math.min(Config.fusionCoreCapacity - energy, max);
        if (!simulate)
            NBTUtil.setInteger(stack, ModNBT.STORED_ENERGY, energy + added);
        return added;
    }

    @Override
    public int extractEnergy(ItemStack stack, int max, boolean simulate) {
        if (stack == null) return 0;
        int energy = getEnergyStored(stack);
        int loss = Math.min(energy, max);
        if (!simulate)
            NBTUtil.setInteger(stack, ModNBT.STORED_ENERGY, energy - loss);
        return loss;
    }

    @Override
    public int getEnergyStored(ItemStack stack) {
        if (stack == null) return 0;
        return NBTUtil.getInt(stack, ModNBT.STORED_ENERGY);
    }

    @Override
    public int getMaxEnergyStored(ItemStack stack) {
        return Config.fusionCoreCapacity;
    }
}
