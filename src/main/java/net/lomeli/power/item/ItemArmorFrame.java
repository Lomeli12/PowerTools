package net.lomeli.power.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemArmorFrame extends ItemPTBase {

    public ItemArmorFrame() {
        super("armorframe");
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote)
            return true;
        else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
            return false;
        else {
            return false;
        }
    }
}
