package com.under.ceaseless.mixin;

import com.under.ceaseless.content.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.RootsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RootsBlock.class)
public abstract class RootsBlockMixin extends PlantBlock {

    protected RootsBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    private void allowPlantingOnCustomBlock(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (floor.isOf(ModBlocks.WARPED_FACADE)) {
            cir.setReturnValue(true);
        }
    }
}