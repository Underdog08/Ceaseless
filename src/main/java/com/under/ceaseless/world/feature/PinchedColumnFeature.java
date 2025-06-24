package com.under.ceaseless.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PinchedColumnFeature extends Feature<PinchedColumnFeatureConfig> {
    public PinchedColumnFeature(Codec<PinchedColumnFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<PinchedColumnFeatureConfig> context) {
        BlockPos origin = context.getOrigin();
        WorldAccess world = context.getWorld();
        Random random = context.getRandom();
        PinchedColumnFeatureConfig config = context.getConfig();

        // Step 1: Adjust origin down to ground level
        while (world.isAir(origin) && origin.getY() > world.getBottomY() + 2) {
            origin = origin.down();
        }
        while (!world.getBlockState(origin).isSolidBlock(world, origin) && origin.getY() > world.getBottomY() + 2) {
            origin = origin.down();
        }

        origin = origin.up(); // Move one block up to start building

        int height = config.height.get(random);
        int baseRadius = config.radius.get(random);

        // Step 2: Loop over all dx/dz positions within the base radius
        for (int dx = -baseRadius; dx <= baseRadius; dx++) {
            for (int dz = -baseRadius; dz <= baseRadius; dz++) {
                List<BlockPos> columnBlocks = new ArrayList<>();

                // Step 3: Build the shape vertically
                for (int y = 0; y <= height; y++) {
                    float t = (float) y / height;

                    // Create a pinched curve: narrow in the middle, wider at ends
                    float pinchFactor = (float) Math.cos(t * Math.PI);
                    pinchFactor = 0.5f + 0.5f * pinchFactor;
                    float radius = MathHelper.lerp(pinchFactor, baseRadius * 0.6f, baseRadius);

                    int ir = MathHelper.ceil(radius);
                    float fx = MathHelper.abs(dx) - 0.25f;
                    float fz = MathHelper.abs(dz) - 0.25f;

                    if ((dx == 0 && dz == 0 || fx * fx + fz * fz <= radius * radius) &&
                            (dx != -ir && dx != ir && dz != -ir && dz != ir || random.nextFloat() <= 0.75f)) {
                        if (radius > 0.3f) {
                            columnBlocks.add(origin.add(dx, y, dz));
                        }
                    }
                }

                if (!columnBlocks.isEmpty()) {
                    // Step 4: Get base of column and shift it down to terrain
                    columnBlocks.sort(Comparator.comparingInt(BlockPos::getY));
                    BlockPos lowest = columnBlocks.get(0);

                    BlockPos shiftCheck = new BlockPos(lowest.getX(), lowest.getY(), lowest.getZ());
                    while (world.isAir(shiftCheck.down()) && shiftCheck.getY() > world.getBottomY() + 2) {
                        shiftCheck = shiftCheck.down();
                    }

                    int yOffset = shiftCheck.getY() - 2 - lowest.getY(); // Bury slightly

                    // *** Step 4.5: Cancel if column would fall below world bottom ***
                    int finalBottomY = lowest.getY() + yOffset;
                    if (finalBottomY < world.getBottomY()) {
                        continue; // Skip placing this column entirely
                    }

                    // Step 5: Place blocks, choosing provider by Y offset from top
                    int maxY = columnBlocks.get(columnBlocks.size() - 1).getY();
                    for (BlockPos pos : columnBlocks) {
                        int relativeToTop = maxY - pos.getY();
                        BlockPos shiftedPos = pos.down(-yOffset);

                        BlockState blockState;
                        if (relativeToTop == 0) {
                            blockState = config.topBlockProvider.get(random, shiftedPos);
                        } else if (relativeToTop <= 2) {
                            blockState = config.nearTopBlockProvider.get(random, shiftedPos);
                        } else {
                            blockState = config.blockProvider.get(random, shiftedPos);
                        }

                        this.setBlockState(world, shiftedPos, blockState);
                    }
                }
            }
        }

        return true;
    }
}