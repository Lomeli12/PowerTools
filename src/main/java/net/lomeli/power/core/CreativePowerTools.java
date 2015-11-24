package net.lomeli.power.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import net.lomeli.power.PowerTools;
import net.lomeli.power.item.ModItems;

public class CreativePowerTools extends CreativeTabs {

    public static final CreativePowerTools modTab = new CreativePowerTools();

    public CreativePowerTools() {
        super(PowerTools.MOD_ID);
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.powerArmorFrame;
    }
}
