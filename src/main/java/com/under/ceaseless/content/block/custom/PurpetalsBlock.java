package com.under.ceaseless.content.block.custom;

import com.mojang.serialization.MapCodec;
import com.under.ceaseless.content.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PurpetalsBlock extends PlantBlock {
    public PurpetalsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0, 0, 0, 16, 0, 16);
    }
}
