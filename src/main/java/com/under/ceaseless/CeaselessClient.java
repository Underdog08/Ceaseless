package com.under.ceaseless;

import com.under.ceaseless.content.block.ModBlocks;
import com.under.ceaseless.content.entity.ModEntities;
import com.under.ceaseless.content.entity.renderer.SandmiteEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class CeaselessClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SANDMITE, SandmiteEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SALLOW_BRAMBLE, RenderLayer.getCutout());
    }
}