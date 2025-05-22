package com.under.ceaseless.mixin;

import com.under.ceaseless.content.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChorusFlowerBlock.class)
public class ChorusFlowerBlockMixin {

    @Inject(method = "canPlaceAt", at = @At("RETURN"), cancellable = true)
    private void allowSallowFacade(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) return;

        BlockState below = world.getBlockState(pos.down());
        if (below.isOf(ModBlocks.SALLOW_FACADE)) {
            cir.setReturnValue(true);
        }
    }
}