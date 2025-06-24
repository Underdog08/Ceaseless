package com.under.ceaseless.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class GroundReplacerFeatureConfig implements FeatureConfig {
    public static final Codec<GroundReplacerFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.VALUE_CODEC.fieldOf("radius").forGetter(config -> config.radius),
            IntProvider.VALUE_CODEC.fieldOf("rim_thickness").forGetter(config -> config.rimThickness),
            BlockStateProvider.TYPE_CODEC.fieldOf("core_block").forGetter(config -> config.coreBlock),
            BlockStateProvider.TYPE_CODEC.fieldOf("rim_block").forGetter(config -> config.rimBlock)
    ).apply(instance, GroundReplacerFeatureConfig::new));

    public final IntProvider radius;
    public final IntProvider rimThickness;
    public final BlockStateProvider coreBlock;
    public final BlockStateProvider rimBlock;

    public GroundReplacerFeatureConfig(IntProvider radius, IntProvider rimThickness,
                                       BlockStateProvider coreBlock, BlockStateProvider rimBlock) {
        this.radius = radius;
        this.rimThickness = rimThickness;
        this.coreBlock = coreBlock;
        this.rimBlock = rimBlock;
    }
}