package net.lomeli.power.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import net.lomeli.lomlib.client.BasicItemMesh;

import net.lomeli.power.core.Proxy;
import net.lomeli.power.item.ModItems;

public class ClientProxy extends Proxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
        registerModel(ModItems.powerArmorFrame, new BasicItemMesh("powertools:armor_frame"));
        registerModel(ModItems.fusionCore, new BasicItemMesh("powertools:fusion_core"));
    }

    @Override
    public void postInit() {
        super.postInit();
    }

    private void registerMetadataModel(Item item, String... files) {
        ModelBakery.addVariantName(item, files);
    }

    private void registerModel(Item item, int metaData, String name) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, metaData, new ModelResourceLocation(name, "inventory"));
    }

    private void registerModel(Item item, ItemMeshDefinition mesh) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, mesh);
    }
}
