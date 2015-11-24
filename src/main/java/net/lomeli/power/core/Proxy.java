package net.lomeli.power.core;

import net.minecraftforge.fml.common.registry.EntityRegistry;

import net.lomeli.power.PowerTools;
import net.lomeli.power.entity.EntityPowerArmor;
import net.lomeli.power.item.ModItems;

public class Proxy {

    public void preInit() {
        ModItems.initItems();
    }

    public void init() {
        EntityRegistry.registerModEntity(EntityPowerArmor.class, "", 0, PowerTools.modInstance, 64, 3, true);
    }

    public void postInit() {

    }
}
