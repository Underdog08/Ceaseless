package com.under.ceaseless.content.block;

import com.under.ceaseless.Ceaseless;
import com.under.ceaseless.content.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block END_SAND = register("end_sand",
            settings -> new EndSandBlock(settings
                    .sounds(BlockSoundGroup.SOUL_SAND)
                    .solid()
                    .strength(0.4f, 0.4f)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block PACKED_END_SAND = register("packed_end_sand",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.STONE)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block END_SAND_BRICKS = register("end_sand_bricks",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block END_SAND_BRICKS_WALL = register("end_sand_bricks_wall",
            settings -> new WallBlock(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block END_SAND_BRICKS_STAIRS = register("end_sand_bricks_stairs",
            settings -> new StairsBlock(ModBlocks.END_SAND_BRICKS.getDefaultState(), settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block END_SAND_BRICKS_SLAB = register("end_sand_bricks_slab",
            settings -> new SlabBlock(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_END_SAND = register("polished_end_sand",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_END_SAND_WALL = register("polished_end_sand_wall",
            settings -> new WallBlock(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_END_SAND_STAIRS = register("polished_end_sand_stairs",
            settings -> new StairsBlock(ModBlocks.POLISHED_END_SAND.getDefaultState(), settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_END_SAND_SLAB = register("polished_end_sand_slab",
            settings -> new SlabBlock(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block NULLSTONE = register("nullstone",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(5, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_NULLSTONE = register("polished_nullstone",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(2, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_NULLSTONE_WALL = register("polished_nullstone_wall",
            settings -> new WallBlock(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(2, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_NULLSTONE_STAIRS = register("polished_nullstone_stairs",
            settings -> new StairsBlock(ModBlocks.POLISHED_NULLSTONE.getDefaultState(), settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(2, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_NULLSTONE_SLAB = register("polished_nullstone_slab",
            settings -> new SlabBlock(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(2, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block CUT_NULLSTONE = register("cut_nullstone",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(2, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block CUT_NULLSTONE_STAIRS = register("cut_nullstone_stairs",
            settings -> new StairsBlock(ModBlocks.CUT_NULLSTONE.getDefaultState(), settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(2, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block CUT_NULLSTONE_SLAB = register("cut_nullstone_slab",
            settings -> new SlabBlock(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(2, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block CHISELED_NULLSTONE = register("chiseled_nullstone",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.BASALT)
                    .solid()
                    .requiresTool()
                    .strength(2, 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block WARPED_FACADE = register("warped_facade",
            settings -> new FacadeBlock(settings
                    .sounds(BlockSoundGroup.NYLIUM)
                    .solid()
                    .strength(0.2f, 0.2f)
                    .ticksRandomly()),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_END_STONE = register("polished_end_stone",
            settings -> new Block(settings
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_END_STONE_WALL = register("polished_end_stone_wall",
            settings -> new WallBlock(settings
                    .sounds(BlockSoundGroup.STONE)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_END_STONE_STAIRS = register("polished_end_stone_stairs",
            settings -> new StairsBlock(ModBlocks.POLISHED_NULLSTONE.getDefaultState(), settings
                    .sounds(BlockSoundGroup.STONE)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block POLISHED_END_STONE_SLAB = register("polished_end_stone_slab",
            settings -> new SlabBlock(settings
                    .sounds(BlockSoundGroup.STONE)
                    .solid()
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block END_STONE_PILLAR = register("end_stone_pillar",
            settings -> new PillarBlock(settings
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block CHISELED_END_STONE = register("chiseled_end_stone",
            settings -> new Block(settings
                    .requiresTool()
                    .strength(Blocks.END_STONE.getHardness(), Blocks.END_STONE.getBlastResistance())),
            AbstractBlock.Settings.create(),
            true);

    public static final Block INFESTED_END_STONE = register("infested_end_stone",
            settings -> new InfestedEndStoneBlock(settings
                    .sounds(BlockSoundGroup.HONEY)
                    .solid()
                    .strength(0.3f, 0.3f)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block SALLOW_FACADE = register("sallow_facade",
            settings -> new FacadeBlock(settings
                    .sounds(BlockSoundGroup.ROOTED_DIRT)
                    .solid()
                    .strength(0.2f, 0.2f)
                    .ticksRandomly()),
            AbstractBlock.Settings.create(),
            true);

    public static final Block SALLOW_BRAMBLE = register("sallow_bramble",
            settings -> new BrambleBlock(settings
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0, 0)
                    .nonOpaque()
                    .noCollision()
                    .offset(AbstractBlock.OffsetType.XZ)
                    .dynamicBounds()),
            AbstractBlock.Settings.create(),
            true);

    public static final Block BISMUTH_ORE = register("bismuth_ore",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.NETHERITE)
                    .solid()
                    .strength(1, 4)
                    .requiresTool()),
            AbstractBlock.Settings.create(),
            true);

    public static final Block TETHERSTONE = register("tetherstone",
            settings -> new TetherstoneBlock(settings
                    .sounds(BlockSoundGroup.NETHERITE)
                    .solid()
                    .strength(2, 8)
                    .requiresTool()
                    .luminance(state -> 9)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block PURPUR_BULB = register("purpur_bulb",
            settings -> new PurpurBulbBlock(settings
                    .sounds(BlockSoundGroup.STONE)
                    .solid()
                    .strength(Blocks.PURPUR_BLOCK.getHardness(), Blocks.PURPUR_BLOCK.getBlastResistance())
                    .requiresTool()),
            AbstractBlock.Settings.create(),
            true);

    public static final Block BISMUTH_BLOCK = register("bismuth_block",
            settings -> new Block(settings
                    .sounds(BlockSoundGroup.NETHERITE)
                    .solid()
                    .strength(Blocks.DIAMOND_BLOCK.getHardness(), Blocks.DIAMOND_BLOCK.getBlastResistance())
                    .requiresTool()),
            AbstractBlock.Settings.create(),
            true);






    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Ceaseless.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Ceaseless.MOD_ID, name));
    }

    public static void initialize() {
    }
}
