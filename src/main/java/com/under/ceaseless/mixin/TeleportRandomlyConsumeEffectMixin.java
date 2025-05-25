package com.under.ceaseless.mixin;

import com.under.ceaseless.content.block.ModBlocks;
import com.under.ceaseless.content.component.ModComponentTypes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.TeleportRandomlyConsumeEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TeleportRandomlyConsumeEffect.class)
public class TeleportRandomlyConsumeEffectMixin {

    @Inject(
            method = "onConsume",
            at = @At("HEAD"),
            cancellable = true
    )
    private void teleportToLodestoneIfTuned(World world, ItemStack stack, LivingEntity user, CallbackInfoReturnable<Boolean> cir) {
        if (!(world instanceof ServerWorld serverWorld)) return;

        BlockPos lodestonePos = stack.get(ModComponentTypes.TETHERSTONE_POS);
        if (lodestonePos == null) return;

        // Check if lodestone block still exists
        if (!world.getBlockState(lodestonePos).isOf(ModBlocks.TETHERSTONE)) return;

        boolean teleported = false;
        float diameter = ((TeleportRandomlyConsumeEffect)(Object)this).diameter();

        for (int i = 0; i < 16; ++i) {
            double x = lodestonePos.getX() + 0.5 + (user.getRandom().nextDouble() - 0.5) * diameter;
            double y = lodestonePos.getY() + (user.getRandom().nextDouble() - 0.5) * diameter;
            double z = lodestonePos.getZ() + 0.5 + (user.getRandom().nextDouble() - 0.5) * diameter;

            y = MathHelper.clamp(y, world.getBottomY(), world.getBottomY() + serverWorld.getLogicalHeight() - 1);

            if (user.hasVehicle()) {
                user.stopRiding();
            }

            Vec3d fromPos = user.getPos();
            if (user.teleport(x, y, z, true)) {
                world.emitGameEvent(GameEvent.TELEPORT, fromPos, GameEvent.Emitter.of(user));

                SoundEvent sound = (user instanceof FoxEntity)
                        ? SoundEvents.ENTITY_FOX_TELEPORT
                        : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                SoundCategory category = (user instanceof FoxEntity)
                        ? SoundCategory.NEUTRAL
                        : SoundCategory.PLAYERS;

                world.playSound(null, user.getX(), user.getY(), user.getZ(), sound, category);
                user.onLanding();
                teleported = true;
                break;
            }
        }

        if (teleported && user instanceof PlayerEntity player) {
            player.clearCurrentExplosion();
        }

        cir.setReturnValue(teleported);
    }
}