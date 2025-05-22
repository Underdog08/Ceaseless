package com.under.ceaseless.content.block.custom;

import com.under.ceaseless.content.component.ModComponentTypes;
import com.under.ceaseless.content.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TetherstoneBlock extends Block {
    public TetherstoneBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos,
                                 PlayerEntity player, BlockHitResult hit) {
        ItemStack stack = player.getMainHandStack();

        if (stack.isOf(Items.CHORUS_FRUIT)) {
            if (!world.isClient) {
                ItemStack tuned = new ItemStack(ModItems.TUNED_CHORUS_FRUIT);
                tuned.set(ModComponentTypes.TETHERSTONE_POS, pos);

                stack.decrement(1);
                if (!player.getInventory().insertStack(tuned)) {
                    player.dropItem(tuned, false);
                }

                world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}