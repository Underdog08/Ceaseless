package com.under.ceaseless.mixin;

import com.under.ceaseless.content.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.ChorusPlantFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.world.gen.feature.ChorusPlantFeature.class)
public class ChorusPlantFeatureMixin {

    @Inject(method = "generate", at = @At("HEAD"), cancellable = true)
    private void onGenerate(FeatureContext<?> context, CallbackInfoReturnable<Boolean> cir) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();

        if (world.isAir(pos) && (world.getBlockState(pos.down()).isOf(Blocks.END_STONE)
                || world.getBlockState(pos.down()).isOf(ModBlocks.SALLOW_FACADE))) {
            ChorusFlowerBlock.generate(world, pos, random, 8);
            cir.setReturnValue(true);
        }
    }
}