package com.under.ceaseless.content.item;

import com.under.ceaseless.Ceaseless;
import com.under.ceaseless.content.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CEASELESS = Registry.register(Registries.ITEM_GROUP, Identifier.of(Ceaseless.MOD_ID, "ceaseless"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.BISMUTH))
                    .displayName(Text.literal("Ceaseless"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.END_SAND.asItem());
                        entries.add(ModBlocks.PACKED_END_SAND.asItem());
                        entries.add(ModBlocks.POLISHED_END_SAND.asItem());
                        entries.add(ModBlocks.POLISHED_END_SAND_STAIRS.asItem());
                        entries.add(ModBlocks.POLISHED_END_SAND_SLAB.asItem());
                        entries.add(ModBlocks.POLISHED_END_SAND_WALL.asItem());
                        entries.add(ModBlocks.END_SAND_BRICKS.asItem());
                        entries.add(ModBlocks.END_SAND_BRICKS_STAIRS.asItem());
                        entries.add(ModBlocks.END_SAND_BRICKS_SLAB.asItem());
                        entries.add(ModBlocks.END_SAND_BRICKS_WALL.asItem());
                        entries.add(ModBlocks.NULLSTONE.asItem());
                        entries.add(ModBlocks.POLISHED_NULLSTONE.asItem());
                        entries.add(ModBlocks.POLISHED_NULLSTONE_STAIRS.asItem());
                        entries.add(ModBlocks.POLISHED_NULLSTONE_SLAB.asItem());
                        entries.add(ModBlocks.POLISHED_NULLSTONE_WALL.asItem());
                        entries.add(ModBlocks.CUT_NULLSTONE.asItem());
                        entries.add(ModBlocks.CUT_NULLSTONE_STAIRS.asItem());
                        entries.add(ModBlocks.CUT_NULLSTONE_SLAB.asItem());
                        entries.add(ModBlocks.CHISELED_NULLSTONE.asItem());
                        entries.add(ModBlocks.POLISHED_END_STONE.asItem());
                        entries.add(ModBlocks.POLISHED_END_STONE_STAIRS.asItem());
                        entries.add(ModBlocks.POLISHED_END_STONE_SLAB.asItem());
                        entries.add(ModBlocks.POLISHED_END_STONE_WALL.asItem());
                        entries.add(ModBlocks.CHISELED_END_STONE.asItem());
                        entries.add(ModBlocks.END_STONE_PILLAR.asItem());
                        entries.add(ModBlocks.INFESTED_END_STONE.asItem());
                        entries.add(ModBlocks.BISMUTH_ORE.asItem());
                        entries.add(ModBlocks.BISMUTH_BLOCK.asItem());
                        entries.add(ModBlocks.WARPED_FACADE.asItem());
                        entries.add(ModBlocks.SALLOW_FACADE.asItem());
                        entries.add(ModBlocks.PURPUR_BULB.asItem());
                        entries.add(ModBlocks.TETHERSTONE.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_BLOCK.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_STAIRS.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_SLAB.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_WALL.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_BRICK.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_BRICK_STAIRS.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_BRICK_SLAB.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_BRICK_WALL.asItem());
                        entries.add(ModBlocks.DARK_PURPUR_PILLAR.asItem());
                        entries.add(ModItems.BISMUTH);
                        entries.add(ModItems.MITE_GEL);
                        entries.add(ModItems.SANDMITE_SPAWN_EGG);
                        entries.add(ModItems.CITY_KEY);
                        entries.add(ModItems.SHIP_KEY);
                    }))
                    .build());

    public static void initialize() {}
}