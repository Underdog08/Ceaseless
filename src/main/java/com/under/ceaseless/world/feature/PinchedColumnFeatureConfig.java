package com.under.ceaseless.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class PinchedColumnFeatureConfig implements FeatureConfig {
    public static final Codec<PinchedColumnFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.VALUE_CODEC.fieldOf("height").forGetter(config -> config.height),
            IntProvider.VALUE_CODEC.fieldOf("radius").forGetter(config -> config.radius),
            BlockStateProvider.TYPE_CODEC.fieldOf("block_provider").forGetter(config -> config.blockProvider),
            BlockStateProvider.TYPE_CODEC.fieldOf("top_block_provider").forGetter(config -> config.topBlockProvider),
            BlockStateProvider.TYPE_CODEC.fieldOf("near_top_block_provider").forGetter(config -> config.nearTopBlockProvider)
    ).apply(instance, PinchedColumnFeatureConfig::new));

    public final IntProvider height;
    public final IntProvider radius;
    public final BlockStateProvider blockProvider;
    public final BlockStateProvider topBlockProvider;
    public final BlockStateProvider nearTopBlockProvider;

    public PinchedColumnFeatureConfig(IntProvider height, IntProvider radius,
                                      BlockStateProvider blockProvider,
                                      BlockStateProvider topBlockProvider,
                                      BlockStateProvider nearTopBlockProvider) {
        this.height = height;
        this.radius = radius;
        this.blockProvider = blockProvider;
        this.topBlockProvider = topBlockProvider;
        this.nearTopBlockProvider = nearTopBlockProvider;
    }
}