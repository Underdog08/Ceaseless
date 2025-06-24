package com.under.ceaseless.content.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
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
    protected int getFallDelay() {
        return 12; // Delay before falling (e.g., 12 ticks = 0.6s)
    }

    // Do NOT automatically schedule falling ticks on placement
    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        // Intentionally left empty
    }

    // Do NOT respond to neighbor updates
    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return state;
    }

    // Trigger falling only when stepped on by a player
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity.isPlayer()) {
            world.scheduleBlockTick(pos, this, getFallDelay());
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (canFallThrough(world.getBlockState(pos.down())) && pos.getY() >= world.getBottomY()) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, pos, state);
            this.configureFallingBlockEntity(fallingBlockEntity);
        }
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return createCodec(EndSandBlock::new);
    }

    // Optional: Add falling dust particles to hint that block is unstable
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(12) == 0) {
            BlockPos below = pos.down();
            if (canFallThrough(world.getBlockState(below))) {
                world.addParticle(
                        new BlockStateParticleEffect(ParticleTypes.FALLING_DUST, state),
                        pos.getX() + 0.5,
                        pos.getY() + 0.1,
                        pos.getZ() + 0.5,
                        0.0, 0.03, 0.0
                );
            }
        }
    }
}