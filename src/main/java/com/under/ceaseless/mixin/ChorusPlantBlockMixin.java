package com.under.ceaseless.mixin;

import com.under.ceaseless.content.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChorusPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.ConnectingBlock.DOWN;

@Mixin(ChorusPlantBlock.class)
public abstract class ChorusPlantBlockMixin extends Block {
    public ChorusPlantBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "canPlaceAt", at = @At("RETURN"), cancellable = true)
    private void allowPlacementOnSallowFacade(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            BlockState below = world.getBlockState(pos.down());
            if (below.isOf(ModBlocks.SALLOW_FACADE)) {
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(method = "withConnectionProperties", at = @At("RETURN"), cancellable = true)
    private static void allowConnectionsToSallowFacade(BlockView world, BlockPos pos, BlockState state, CallbackInfoReturnable<BlockState> cir) {
        BlockState down = world.getBlockState(pos.down());
        if (down.isOf(ModBlocks.SALLOW_FACADE)) {
            cir.setReturnValue(cir.getReturnValue().with(DOWN, true));
        }
    }
}