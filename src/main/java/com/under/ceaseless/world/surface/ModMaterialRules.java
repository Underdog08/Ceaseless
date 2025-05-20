package com.under.ceaseless.world.surface;

import com.under.ceaseless.content.block.ModBlocks;
import com.under.ceaseless.world.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DISTORTED_FOREST_GROUND = makeStateRule(Blocks.END_STONE);
    private static final MaterialRules.MaterialRule DISTORTED_FOREST_SURFACE = makeStateRule(ModBlocks.WARPED_FACADE);
    private static final MaterialRules.MaterialRule END_WASTES_GROUND = makeStateRule(ModBlocks.PACKED_END_SAND);
    private static final MaterialRules.MaterialRule END_WASTES_SURFACE = makeStateRule(ModBlocks.END_SAND);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule distorted_forest_surface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, DISTORTED_FOREST_SURFACE));
        MaterialRules.MaterialRule end_wastes_surface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, END_WASTES_SURFACE));
        MaterialRules.MaterialRule end_wastes_ground = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, END_WASTES_GROUND));

        return MaterialRules.sequence(
                MaterialRules.sequence(
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.DISTORTED_FOREST_HIGHLANDS), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, distorted_forest_surface)),
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.DISTORTED_FOREST_MIDLANDS), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, distorted_forest_surface)),
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.DISTORTED_FOREST_EDGE), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, distorted_forest_surface)),
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.END_WASTES_HIGHLANDS), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, end_wastes_surface)),
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.END_WASTES_HIGHLANDS), MaterialRules.condition(isAtOrAboveWaterLevel, end_wastes_ground)),
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.END_WASTES_MIDLANDS), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, end_wastes_surface)),
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.END_WASTES_MIDLANDS), MaterialRules.condition(isAtOrAboveWaterLevel, end_wastes_ground)),
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.END_WASTES_EDGE), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, end_wastes_surface)),
                        MaterialRules.condition(MaterialRules.biome(ModBiomes.END_WASTES_EDGE), MaterialRules.condition(isAtOrAboveWaterLevel, end_wastes_ground))
                ));

    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
