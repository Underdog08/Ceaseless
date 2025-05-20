package com.under.ceaseless.world;

import com.under.ceaseless.Ceaseless;
import com.under.ceaseless.world.surface.ModMaterialRules;
import net.minecraft.world.biome.BiomeKeys;
import terrablender.api.EndBiomeRegistry;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    private int biome_weight = 30;

    @Override
    public void onTerraBlenderInitialized() {
        EndBiomeRegistry.registerEdgeBiome(ModBiomes.DISTORTED_FOREST_EDGE, biome_weight);
        EndBiomeRegistry.registerEdgeBiome(ModBiomes.END_WASTES_EDGE, biome_weight);
        EndBiomeRegistry.registerEdgeBiome(BiomeKeys.END_BARRENS, biome_weight);
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, Ceaseless.MOD_ID, ModMaterialRules.makeRules());
        EndBiomeRegistry.registerMidlandsBiome(ModBiomes.DISTORTED_FOREST_MIDLANDS, biome_weight);
        EndBiomeRegistry.registerMidlandsBiome(ModBiomes.END_WASTES_MIDLANDS, biome_weight);
        EndBiomeRegistry.registerEdgeBiome(BiomeKeys.END_MIDLANDS, biome_weight);
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, Ceaseless.MOD_ID, ModMaterialRules.makeRules());
        EndBiomeRegistry.registerHighlandsBiome(ModBiomes.DISTORTED_FOREST_HIGHLANDS, biome_weight);
        EndBiomeRegistry.registerHighlandsBiome(ModBiomes.END_WASTES_HIGHLANDS, biome_weight);
        EndBiomeRegistry.registerEdgeBiome(BiomeKeys.END_HIGHLANDS, biome_weight);
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, Ceaseless.MOD_ID, ModMaterialRules.makeRules());
        //EndBiomeRegistry.registerIslandBiome(ModBiomes.DISTORTED_FOREST, biome_weight);
        //EndBiomeRegistry.registerIslandBiome(ModBiomes.END_WASTES, biome_weight);
        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, Ceaseless.MOD_ID, ModMaterialRules.makeRules());
    }
}