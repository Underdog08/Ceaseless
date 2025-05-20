package com.under.ceaseless.content.entity.renderer;

import com.under.ceaseless.Ceaseless;
import com.under.ceaseless.content.entity.SandmiteEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EndermiteEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SandmiteEntityRenderer extends MobEntityRenderer<SandmiteEntity, LivingEntityRenderState, EndermiteEntityModel> {

    private static final Identifier TEXTURE = Identifier.of(Ceaseless.MOD_ID, "textures/entity/sandmite.png");

    public SandmiteEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new EndermiteEntityModel(context.getPart(EntityModelLayers.ENDERMITE)), 0.3F);
    }

    @Override
    protected float method_3919() {
        return 180.0F;
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}