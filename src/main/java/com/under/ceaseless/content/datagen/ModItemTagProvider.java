package com.under.ceaseless.content.datagen;

import com.under.ceaseless.content.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(ModBlocks.CUT_NULLSTONE_STAIRS.asItem())
                .add(ModBlocks.END_SAND_BRICKS_STAIRS.asItem())
                .add(ModBlocks.POLISHED_END_SAND_STAIRS.asItem())
                .add(ModBlocks.POLISHED_END_STONE_SLAB.asItem())
                .add(ModBlocks.POLISHED_NULLSTONE_STAIRS.asItem())
                .add(ModBlocks.DARK_PURPUR_STAIRS.asItem())
                .add(ModBlocks.DARK_PURPUR_BRICK_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(ModBlocks.CUT_NULLSTONE_SLAB.asItem())
                .add(ModBlocks.END_SAND_BRICKS_SLAB.asItem())
                .add(ModBlocks.POLISHED_END_SAND_SLAB.asItem())
                .add(ModBlocks.POLISHED_END_STONE_SLAB.asItem())
                .add(ModBlocks.POLISHED_NULLSTONE_SLAB.asItem())
                .add(ModBlocks.DARK_PURPUR_SLAB.asItem())
                .add(ModBlocks.DARK_PURPUR_BRICK_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBlocks.END_SAND_BRICKS_WALL.asItem())
                .add(ModBlocks.POLISHED_END_SAND_WALL.asItem())
                .add(ModBlocks.POLISHED_END_STONE_WALL.asItem())
                .add(ModBlocks.POLISHED_NULLSTONE_WALL.asItem())
                .add(ModBlocks.DARK_PURPUR_WALL.asItem())
                .add(ModBlocks.DARK_PURPUR_BRICK_WALL.asItem());
    }
}
