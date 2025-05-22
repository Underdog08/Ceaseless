package com.under.ceaseless.world;

import com.under.ceaseless.Ceaseless;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;

public class ModBiomes {
    public static final RegistryKey<Biome> DISTORTED_FOREST_HIGHLANDS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "distorted_forest_highlands"));

    public static final RegistryKey<Biome> DISTORTED_FOREST_MIDLANDS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "distorted_forest_midlands"));

    public static final RegistryKey<Biome> DISTORTED_FOREST_EDGE = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "distorted_forest_edge"));

    public static final RegistryKey<Biome> END_WASTES_HIGHLANDS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "end_wastes_highlands"));

    public static final RegistryKey<Biome> END_WASTES_MIDLANDS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "end_wastes_midlands"));

    public static final RegistryKey<Biome> END_WASTES_EDGE = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "end_wastes_edge"));

    public static final RegistryKey<Biome> SALLOW_FIELDS_HIGHLANDS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "sallow_fields_highlands"));

    public static final RegistryKey<Biome> SALLOW_FIELDS_MIDLANDS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "sallow_fields_midlands"));

    public static final RegistryKey<Biome> SALLOW_FIELDS_EDGE = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Ceaseless.MOD_ID, "sallow_fields_edge"));

    public static void bootstrap(Registerable<Biome> context) {
        //context.register(DISTORTED_FOREST, distortedForest(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
    }

    /*public static Biome distortedForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMITE, 2, 1, 3));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 50, 5, 10));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);

        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, DISTORTED_TREE);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(0.0f)
                .temperature(0.2f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x000000)
                        .waterFogColor(0x000000)
                        .skyColor(0x000000)
                        .grassColor(0x000000)
                        .foliageColor(0x000000)
                        .fogColor(0x000000)
                        .moodSound(BiomeMoodSound.CAVE)
                        /*.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.TWILIGHT_DISC))).build())
                .build();
    }*/
}