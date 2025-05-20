package com.under.ceaseless.mixin;

import com.under.ceaseless.Ceaseless;
import com.under.ceaseless.content.effect.ModEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Unique
    private static final Identifier PURPLEXED_HEART_FULL = Identifier.of(Ceaseless.MOD_ID, "purplexed_full");
    @Unique
    private static final Identifier PURPLEXED_HEART_HALF = Identifier.of(Ceaseless.MOD_ID, "purplexed_half");

    @Inject(method = "drawHeart", at = @At("HEAD"), cancellable = true)
    private void entrancement$drawCustomHeart(DrawContext context, InGameHud.HeartType type, int x, int y, boolean hardcore, boolean blinking, boolean half, CallbackInfo ci) {
        if (!blinking && type == InGameHud.HeartType.NORMAL && MinecraftClient.getInstance().cameraEntity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(ModEffects.PURPLEXED)) {
                Identifier texture = half ? PURPLEXED_HEART_HALF : PURPLEXED_HEART_FULL;
                context.drawGuiTexture(RenderLayer::getGuiTextured, texture, x, y, 9, 9);
                ci.cancel();
            }
        }
    }

    @Inject(method = "renderHealthBar", at = @At("HEAD"), cancellable = true)
    private void ceaseless$renderFullHearts(DrawContext context, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking, CallbackInfo ci) {
        if (player.hasStatusEffect(ModEffects.PURPLEXED)) {
            ci.cancel();

            for (int i = 0; i < 10; i++) {
                int heartX = x + (i % 10) * 8;
                int heartY = y - (i / 10) * lines;
                context.drawGuiTexture(
                        RenderLayer::getGuiTextured,
                        Identifier.of(Ceaseless.MOD_ID, "purplexed_full"),
                        heartX,
                        heartY,
                        9,
                        9
                );
            }
        }
    }
}