package com.under.ceaseless.content.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class EndSandBlock extends FallingBlock {

    public EndSandBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return state;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity.isPlayer()) {
            // Trigger scheduled tick immediately
            this.scheduledTick(state, (ServerWorld) world, pos, world.getRandom());
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return createCodec(EndSandBlock::new);
    }
}