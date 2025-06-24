package com.under.ceaseless.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class GroundReplacerFeature extends Feature<GroundReplacerFeatureConfig> {
    public GroundReplacerFeature(Codec<GroundReplacerFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<GroundReplacerFeatureConfig> context) {
        BlockPos center = context.getOrigin();
        WorldAccess world = context.getWorld();
        Random random = context.getRandom();
        GroundReplacerFeatureConfig config = context.getConfig();

        int radius = config.radius.get(random);
        int rimThickness = config.rimThickness.get(random);
        int totalRadius = radius + rimThickness;

        for (int dx = -totalRadius; dx <= totalRadius; dx++) {
            for (int dz = -totalRadius; dz <= totalRadius; dz++) {
                int distSq = dx * dx + dz * dz;
                double dist = Math.sqrt(distSq);

                if (dist <= totalRadius) {
                    BlockPos surfacePos = findSurface(world, center.add(dx, 0, dz));
                    if (surfacePos == null) continue;

                    BlockState state;
                    if (dist <= radius) {
                        state = config.coreBlock.get(random, surfacePos);
                    } else {
                        state = config.rimBlock.get(random, surfacePos);
                    }

                    this.setBlockState(world, surfacePos, state);
                }
            }
        }

        return true;
    }

    private BlockPos findSurface(WorldAccess world, BlockPos pos) {
        for (int y = pos.getY(); y > world.getBottomY() + 2; y--) {
            BlockPos checkPos = new BlockPos(pos.getX(), y, pos.getZ());
            if (!world.isAir(checkPos) && world.getBlockState(checkPos).isSolid()) {
                return checkPos;
            }
        }
        return null;
    }
}