package com.under.ceaseless.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.collection.Weighted;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import terrablender.core.TerraBlender;

import java.util.ArrayList;
import java.util.List;

public class ModEndBiomeRegistry {
    private static final List<Weighted.Present<RegistryKey<Biome>>> highlandsBiomes = new ArrayList();
    private static final List<Weighted.Present<RegistryKey<Biome>>> midlandsBiomes = new ArrayList();
    private static final List<Weighted.Present<RegistryKey<Biome>>> edgeBiomes = new ArrayList();
    private static final List<Weighted.Present<RegistryKey<Biome>>> islandBiomes = new ArrayList();

    public ModEndBiomeRegistry() {
    }

    public static void registerHighlandsBiome(RegistryKey<Biome> biome, int weight) {
        highlandsBiomes.add(Weighted.of(biome, weight));
    }

    public static void registerMidlandsBiome(RegistryKey<Biome> biome, int weight) {
        midlandsBiomes.add(Weighted.of(biome, weight));
    }

    public static void registerEdgeBiome(RegistryKey<Biome> biome, int weight) {
        edgeBiomes.add(Weighted.of(biome, weight));
    }

    public static void registerIslandBiome(RegistryKey<Biome> biome, int weight) {
        islandBiomes.add(Weighted.of(biome, weight));
    }

    public static List<Weighted.Present<RegistryKey<Biome>>> getHighlandsBiomes() {
        return ImmutableList.copyOf(highlandsBiomes);
    }

    public static List<Weighted.Present<RegistryKey<Biome>>> getMidlandsBiomes() {
        return ImmutableList.copyOf(midlandsBiomes);
    }

    public static List<Weighted.Present<RegistryKey<Biome>>> getEdgeBiomes() {
        return ImmutableList.copyOf(edgeBiomes);
    }

    public static List<Weighted.Present<RegistryKey<Biome>>> getIslandBiomes() {
        return ImmutableList.copyOf(islandBiomes);
    }

    static {
        registerHighlandsBiome(BiomeKeys.END_HIGHLANDS, TerraBlender.CONFIG.vanillaEndHighlandsWeight);
        registerMidlandsBiome(BiomeKeys.END_MIDLANDS, TerraBlender.CONFIG.vanillaEndMidlandsWeight);
        registerEdgeBiome(BiomeKeys.END_BARRENS, TerraBlender.CONFIG.vanillaEndBarrensWeight);
        registerIslandBiome(BiomeKeys.SMALL_END_ISLANDS, TerraBlender.CONFIG.vanillaSmallEndIslandsWeight);
    }
}