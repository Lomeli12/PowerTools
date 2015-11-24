package net.lomeli.power.item;

import net.minecraft.item.Item;

import net.lomeli.power.PowerTools;
import net.lomeli.power.core.CreativePowerTools;

public class ItemPTBase extends Item {

    public ItemPTBase(String unlocalName) {
        super();
        this.setCreativeTab(CreativePowerTools.modTab);
        this.setUnlocalizedName(unlocalName);
    }

    @Override
    public Item setUnlocalizedName(String unlocalizedName) {
        return super.setUnlocalizedName(PowerTools.MOD_ID + "." + unlocalizedName);
    }
}
