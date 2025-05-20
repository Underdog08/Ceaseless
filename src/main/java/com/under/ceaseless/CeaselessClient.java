package com.under.ceaseless;

import com.under.ceaseless.content.entity.ModEntities;
import com.under.ceaseless.content.entity.renderer.SandmiteEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CeaselessClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SANDMITE, SandmiteEntityRenderer::new);
    }
}