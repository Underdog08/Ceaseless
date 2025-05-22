package com.under.ceaseless.content.item.custom;

import com.under.ceaseless.content.block.ModBlocks;
import com.under.ceaseless.content.component.ModComponentTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class TunedChorusFruitItem extends Item {
    public TunedChorusFruitItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient && user instanceof PlayerEntity player) {
            BlockPos tetherPos = stack.get(ModComponentTypes.TETHERSTONE_POS);

            if (tetherPos != null) {
                BlockState state = world.getBlockState(tetherPos);

                if (state.isOf(ModBlocks.TETHERSTONE)) {
                    teleportNear(player, tetherPos, world);

                    world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
                }
            }
        }
        return super.finishUsing(stack, world, user);
    }

    private void teleportNear(PlayerEntity player, BlockPos tetherPos, World world) {
        Random random = world.getRandom();

        for (int i = 0; i < 16; i++) {
            int dx = random.nextInt(7) - 3;
            int dz = random.nextInt(7) - 3;
            BlockPos target = tetherPos.add(dx, 1, dz);

            if (world.getBlockState(target).isAir() &&
                    world.getBlockState(target.down()).isSideSolidFullSquare(world, target.down(), Direction.UP)) {

                player.requestTeleport(target.getX() + 0.5, target.getY(), target.getZ() + 0.5);
                return;
            }
        }
    }
}
