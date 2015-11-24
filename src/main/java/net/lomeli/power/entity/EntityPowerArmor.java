package net.lomeli.power.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rotations;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityPowerArmor extends EntityLivingBase {
    private static final Rotations DEFAULT_HEAD_ROTATION = new Rotations(0.0F, 0.0F, 0.0F);
    private static final Rotations DEFAULT_BODY_ROTATION = new Rotations(0.0F, 0.0F, 0.0F);
    private static final Rotations DEFAULT_LEFTARM_ROTATION = new Rotations(-10.0F, 0.0F, -10.0F);
    private static final Rotations DEFAULT_RIGHTARM_ROTATION = new Rotations(-15.0F, 0.0F, 10.0F);
    private static final Rotations DEFAULT_LEFTLEG_ROTATION = new Rotations(-1.0F, 0.0F, -1.0F);
    private static final Rotations DEFAULT_RIGHTLEG_ROTATION = new Rotations(1.0F, 0.0F, 1.0F);
    private Rotations headRotation;
    private Rotations bodyRotation;
    private Rotations leftArmRotation;
    private Rotations rightArmRotation;
    private Rotations leftLegRotation;
    private Rotations rightLegRotation;
    private final ItemStack[] inventory;

    public EntityPowerArmor(World world) {
        super(world);
        this.inventory = new ItemStack[7];
        this.headRotation = DEFAULT_HEAD_ROTATION;
        this.bodyRotation = DEFAULT_BODY_ROTATION;
        this.leftArmRotation = DEFAULT_LEFTARM_ROTATION;
        this.rightArmRotation = DEFAULT_RIGHTARM_ROTATION;
        this.leftLegRotation = DEFAULT_LEFTLEG_ROTATION;
        this.rightLegRotation = DEFAULT_RIGHTLEG_ROTATION;
        this.setSilent(true);
        this.setSize(0.5F, 1.975F);
    }

    public EntityPowerArmor(World worldIn, double posX, double posY, double posZ) {
        this(worldIn);
        this.setPosition(posX, posY, posZ);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(11, DEFAULT_HEAD_ROTATION);
        this.dataWatcher.addObject(12, DEFAULT_BODY_ROTATION);
        this.dataWatcher.addObject(13, DEFAULT_LEFTARM_ROTATION);
        this.dataWatcher.addObject(14, DEFAULT_RIGHTARM_ROTATION);
        this.dataWatcher.addObject(15, DEFAULT_LEFTLEG_ROTATION);
        this.dataWatcher.addObject(16, DEFAULT_RIGHTLEG_ROTATION);
    }

    @Override
    public ItemStack getHeldItem() {
        return null;
    }

    @Override
    public ItemStack getEquipmentInSlot(int slot) {
        return slot < inventory.length ? inventory[slot] : null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getCurrentArmor(int slot) {
        return getEquipmentInSlot(slot + 1);
    }

    @Override
    public void setCurrentItemOrArmor(int slot, ItemStack stack) {
        if (slot < inventory.length)
            inventory[slot] = stack;
    }

    @Override
    public ItemStack[] getInventory() {
        return inventory;
    }
}
