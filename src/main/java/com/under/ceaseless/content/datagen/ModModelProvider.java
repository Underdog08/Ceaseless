package com.under.ceaseless.content.datagen;

import com.under.ceaseless.content.block.ModBlocks;
import com.under.ceaseless.content.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool polishedNullstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_NULLSTONE);
        BlockStateModelGenerator.BlockTexturePool cutNullstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_NULLSTONE);
        BlockStateModelGenerator.BlockTexturePool polishedEndSandPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_END_SAND);
        BlockStateModelGenerator.BlockTexturePool endSandBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.END_SAND_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polishedEndStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_END_STONE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_END_SAND);
        polishedEndSandPool.wall(ModBlocks.POLISHED_END_SAND_WALL);
        polishedEndSandPool.stairs(ModBlocks.POLISHED_END_SAND_STAIRS);
        polishedEndSandPool.slab(ModBlocks.POLISHED_END_SAND_SLAB);
        endSandBricksPool.wall(ModBlocks.END_SAND_BRICKS_WALL);
        endSandBricksPool.stairs(ModBlocks.END_SAND_BRICKS_STAIRS);
        endSandBricksPool.slab(ModBlocks.END_SAND_BRICKS_SLAB);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NULLSTONE);
        blockStateModelGenerator.registerSingleton(ModBlocks.CHISELED_NULLSTONE, TexturedModel.CUBE_BOTTOM_TOP);
        polishedNullstonePool.wall(ModBlocks.POLISHED_NULLSTONE_WALL);
        polishedNullstonePool.stairs(ModBlocks.POLISHED_NULLSTONE_STAIRS);
        polishedNullstonePool.slab(ModBlocks.POLISHED_NULLSTONE_SLAB);
        cutNullstonePool.stairs(ModBlocks.CUT_NULLSTONE_STAIRS);
        cutNullstonePool.slab(ModBlocks.CUT_NULLSTONE_SLAB);


        blockStateModelGenerator.registerSingleton(ModBlocks.WARPED_FACADE, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.END_STONE_PILLAR, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.SALLOW_FACADE, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SALLOW_BRAMBLE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerSingleton(ModBlocks.TETHERSTONE, TexturedModel.CUBE_BOTTOM_TOP);

        polishedEndStonePool.wall(ModBlocks.POLISHED_END_STONE_WALL);
        polishedEndStonePool.stairs(ModBlocks.POLISHED_END_STONE_STAIRS);
        polishedEndStonePool.slab(ModBlocks.POLISHED_END_STONE_SLAB);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_END_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INFESTED_END_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MITE_GEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH, Models.GENERATED);
    }
}
