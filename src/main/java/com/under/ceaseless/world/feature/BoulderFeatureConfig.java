package com.under.ceaseless.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class BoulderFeatureConfig implements FeatureConfig {
    public static final Codec<BoulderFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.VALUE_CODEC.fieldOf("height").forGetter(config -> config.height),
            IntProvider.VALUE_CODEC.fieldOf("radius").forGetter(config -> config.radius),
            BlockStateProvider.TYPE_CODEC.fieldOf("block_provider").forGetter(config -> config.blockProvider)
    ).apply(instance, BoulderFeatureConfig::new));

    public final IntProvider height;
    public final IntProvider radius;
    public final BlockStateProvider blockProvider;

    public BoulderFeatureConfig(IntProvider height, IntProvider radius, BlockStateProvider blockProvider) {
        this.height = height;
        this.radius = radius;
        this.blockProvider = blockProvider;
    }
}
