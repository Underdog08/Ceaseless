package com.under.ceaseless.content.events;

import com.under.ceaseless.content.block.ModBlocks;
import com.under.ceaseless.content.component.ModComponentTypes;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CeaselessEvents {
    public static void register() {
        UseBlockCallback.EVENT.register(CeaselessEvents::onUseBlock);
    }

    private static ActionResult onUseBlock(PlayerEntity player, World world, Hand hand, net.minecraft.util.hit.BlockHitResult hit) {
        if (world.isClient) return ActionResult.PASS;

        ItemStack stack = player.getStackInHand(hand);
        BlockPos pos = hit.getBlockPos();

        // Check block is Lodestone and item is Chorus Fruit
        if (stack.isOf(Items.CHORUS_FRUIT) && world.getBlockState(pos).isOf(ModBlocks.TETHERSTONE)) {
            if (stack.getCount() > 1) {
                ItemStack tuned = stack.copy();
                tuned.setCount(1);
                tuneChorusFruit(tuned, pos);

                stack.decrement(1);
                if (!player.getInventory().insertStack(tuned)) {
                    player.dropItem(tuned, false);
                }
            } else {
                tuneChorusFruit(stack, pos);
            }

            world.playSound(null, pos, SoundEvents.BLOCK_CHORUS_FLOWER_GROW, SoundCategory.PLAYERS);
            player.sendMessage(Text.literal("Chorus Fruit tuned to Lodestone!").formatted(Formatting.LIGHT_PURPLE), true);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    private static void tuneChorusFruit(ItemStack stack, BlockPos lodestonePos) {
        stack.set(ModComponentTypes.TETHERSTONE_POS, lodestonePos);

        stack.set(DataComponentTypes.ITEM_NAME,
                Text.literal("Tuned Chorus Fruit"));

        stack.set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, Boolean.TRUE);
    }
}
