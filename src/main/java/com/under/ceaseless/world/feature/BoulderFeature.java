package com.under.ceaseless.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BoulderFeature extends Feature<BoulderFeatureConfig> {
    public BoulderFeature(Codec<BoulderFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<BoulderFeatureConfig> context) {
        BlockPos origin = context.getOrigin();
        WorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BoulderFeatureConfig config = context.getConfig();

        while (world.isAir(origin) && origin.getY() > world.getBottomY() + 2) {
            origin = origin.down();
        }
        while (!world.getBlockState(origin).isSolidBlock(world, origin) && origin.getY() > world.getBottomY() + 2) {
            origin = origin.down();
        }

        origin = origin.down(random.nextInt(2) + 1);

        int height = config.height.get(random);
        int radius = config.radius.get(random);

        int bottomExtra = 3;

        for (int y = -bottomExtra; y < height; y++) {
            float normalizedY;
            float r;

            if (y < 0) {
                normalizedY = (float)(y + bottomExtra) / bottomExtra; // 0 to 1
                r = normalizedY * radius;
            } else {
                normalizedY = (float) y / height;
                r = (1.0f - normalizedY * normalizedY) * radius;
            }

            int ir = MathHelper.ceil(r);

            for (int dx = -ir; dx <= ir; dx++) {
                float fx = MathHelper.abs(dx) - 0.25f;

                for (int dz = -ir; dz <= ir; dz++) {
                    float fz = MathHelper.abs(dz) - 0.25f;

                    if ((dx == 0 && dz == 0 || fx * fx + fz * fz <= r * r) &&
                            (dx != -ir && dx != ir && dz != -ir && dz != ir || random.nextFloat() <= 0.75f)) {
                        if (r > 0.3f) {
                            BlockPos pos = origin.add(dx, y, dz);
                            this.setBlockState(world, pos, config.blockProvider.get(random, pos));
                        }
                    }
                }
            }
        }

        return true;
    }
}