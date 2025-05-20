package com.under.ceaseless.mixin;

import com.under.ceaseless.content.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.FungusBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FungusBlock.class)
public abstract class FungusBlockMixin {

    //@Final
    //@Shadow
    //private Block nylium;

    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    private void allowPlantingOnCustomBlock(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (floor.isOf(ModBlocks.WARPED_FACADE)) {
            cir.setReturnValue(true);
        }
    }
}