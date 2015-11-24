package net.lomeli.power.item;

import net.minecraft.item.Item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static Item powerArmorFrame, armorPart, fusionCore;

    public static void initItems() {
        powerArmorFrame = new ItemArmorFrame();
        fusionCore = new ItemFusionCore();

        GameRegistry.registerItem(powerArmorFrame, "armor_frame");
        GameRegistry.registerItem(fusionCore, "fusion_core");
    }
}
