package com.under.ceaseless.content.datagen;

import com.under.ceaseless.content.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.CUT_NULLSTONE_STAIRS)
                .add(ModBlocks.END_SAND_BRICKS_STAIRS)
                .add(ModBlocks.POLISHED_END_SAND_STAIRS)
                .add(ModBlocks.POLISHED_END_STONE_SLAB)
                .add(ModBlocks.POLISHED_NULLSTONE_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.CUT_NULLSTONE_SLAB)
                .add(ModBlocks.END_SAND_BRICKS_SLAB)
                .add(ModBlocks.POLISHED_END_SAND_SLAB)
                .add(ModBlocks.POLISHED_END_STONE_SLAB)
                .add(ModBlocks.POLISHED_NULLSTONE_SLAB);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.END_SAND_BRICKS_WALL)
                .add(ModBlocks.POLISHED_END_SAND_WALL)
                .add(ModBlocks.POLISHED_END_STONE_WALL)
                .add(ModBlocks.POLISHED_NULLSTONE_WALL);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.POLISHED_END_STONE)
                .add(ModBlocks.POLISHED_END_STONE_STAIRS)
                .add(ModBlocks.POLISHED_END_STONE_SLAB)
                .add(ModBlocks.POLISHED_END_STONE_WALL)
                .add(ModBlocks.CHISELED_END_STONE)
                .add(ModBlocks.END_STONE_PILLAR)
                .add(ModBlocks.INFESTED_END_STONE)

                .add(ModBlocks.PACKED_END_SAND)
                .add(ModBlocks.POLISHED_END_SAND)
                .add(ModBlocks.POLISHED_END_SAND_STAIRS)
                .add(ModBlocks.POLISHED_END_SAND_SLAB)
                .add(ModBlocks.POLISHED_END_SAND_WALL)
                .add(ModBlocks.END_SAND_BRICKS)
                .add(ModBlocks.END_SAND_BRICKS_STAIRS)
                .add(ModBlocks.END_SAND_BRICKS_SLAB)
                .add(ModBlocks.END_SAND_BRICKS_WALL)

                .add(ModBlocks.NULLSTONE)
                .add(ModBlocks.POLISHED_NULLSTONE)
                .add(ModBlocks.POLISHED_NULLSTONE_STAIRS)
                .add(ModBlocks.POLISHED_NULLSTONE_SLAB)
                .add(ModBlocks.POLISHED_NULLSTONE_WALL)
                .add(ModBlocks.CUT_NULLSTONE)
                .add(ModBlocks.CUT_NULLSTONE_STAIRS)
                .add(ModBlocks.CUT_NULLSTONE_SLAB)
                .add(ModBlocks.CHISELED_NULLSTONE)

                .add(ModBlocks.PURPUR_BULB)

                .add(ModBlocks.BISMUTH_ORE)
                .add(ModBlocks.BISMUTH_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.END_SAND);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.SALLOW_FACADE)
                .add(ModBlocks.WARPED_FACADE);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.BISMUTH_BLOCK);
    }
}
