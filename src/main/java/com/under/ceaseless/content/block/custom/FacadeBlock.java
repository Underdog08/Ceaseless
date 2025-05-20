package com.under.ceaseless.content.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class FacadeBlock extends Block {
    public FacadeBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBlockState(pos.up()).isOpaqueFullCube()) {
            world.setBlockState(pos, Blocks.END_STONE.getDefaultState());
        }
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }
}