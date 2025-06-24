package com.under.ceaseless.world.feature;

import com.under.ceaseless.Ceaseless;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {
    public static final Feature<BoulderFeatureConfig> BOULDER_FEATURE = new BoulderFeature(BoulderFeatureConfig.CODEC);
    public static final Feature<PinchedColumnFeatureConfig> PINCHED_COLUMN_FEATURE = new PinchedColumnFeature(PinchedColumnFeatureConfig.CODEC);
    public static final Feature<GroundReplacerFeatureConfig> GROUND_REPLACER_FEATURE = new GroundReplacerFeature(GroundReplacerFeatureConfig.CODEC);

    public static void register() {
        Registry.register(Registries.FEATURE,
                Identifier.of(Ceaseless.MOD_ID, "boulder_feature"), BOULDER_FEATURE);
        Registry.register(Registries.FEATURE,
                Identifier.of(Ceaseless.MOD_ID, "pinched_column_feature"), PINCHED_COLUMN_FEATURE);
        Registry.register(Registries.FEATURE,
                Identifier.of(Ceaseless.MOD_ID, "ground_replacer_feature"), GROUND_REPLACER_FEATURE);
    }
}