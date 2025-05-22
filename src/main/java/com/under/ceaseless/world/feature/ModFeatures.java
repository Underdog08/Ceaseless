package com.under.ceaseless.world.feature;

import com.under.ceaseless.Ceaseless;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {
    public static final Feature<BoulderFeatureConfig> BOULDER_FEATURE = new BoulderFeature(BoulderFeatureConfig.CODEC);

    public static void register() {
        Registry.register(Registries.FEATURE,
                Identifier.of(Ceaseless.MOD_ID, "boulder_feature"), BOULDER_FEATURE);
    }
}