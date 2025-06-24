package com.under.ceaseless.content.block.custom;

import com.under.ceaseless.content.entity.ModEntities;
import com.under.ceaseless.content.entity.custom.SandmiteEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InfestedEndStoneBlock extends Block {
    public InfestedEndStoneBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockState newState = super.onBreak(world, pos, state, player);
        if(!player.isCreative() && !player.isSpectator()) {
            SandmiteEntity sandmite = ModEntities.SANDMITE.create(world, SpawnReason.TRIGGERED);
            assert sandmite != null;
            sandmite.refreshPositionAndAngles((double) pos.getX() + 0.5f, pos.getY(), (double) pos.getZ() + 0.5f, 0.0f, 0.0f);
            world.spawnEntity(sandmite);
            sandmite.playSpawnEffects();
        }
        return newState;
    }
}