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
                    .icon(() -> new ItemStack(ModBlocks.END_SAND.asItem()))
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
                        entries.add(ModBlocks.INFESTED_END_STONE.asItem());
                        entries.add(ModBlocks.BISMUTH_ORE.asItem());
                        entries.add(ModBlocks.BISMUTH_BLOCK.asItem());
                        entries.add(ModBlocks.WARPED_FACADE.asItem());
                        entries.add(ModBlocks.SALLOW_FACADE.asItem());
                        entries.add(ModBlocks.PURPUR_BULB.asItem());
                        entries.add(ModBlocks.TETHERSTONE.asItem());
                        entries.add(ModItems.BISMUTH);
                        entries.add(ModItems.MITE_GEL);
                        entries.add(ModItems.SANDMITE_SPAWN_EGG);
                    }))
                    .build());

    public static void initialize() {}
}