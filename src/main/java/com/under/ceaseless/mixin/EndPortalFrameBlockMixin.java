package com.under.ceaseless.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EndPortalFrameBlock.class)
public abstract class EndPortalFrameBlockMixin extends Block {
    public EndPortalFrameBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        ItemStack heldItem = player.getMainHandStack();

        if (heldItem.isOf(Items.DIAMOND_PICKAXE)) {
            return player.getBlockBreakingSpeed(state) / getHardness();
        }

        return 0.0F;
    }

    @Override
    public float getHardness() {
        return 50.0F;
    }

    /*@Override
    public boolean canHarvest(BlockState state, BlockView world, BlockPos pos, PlayerEntity player) {
        // Optional: prevent item drop (vanilla doesn't drop portal frames anyway)
        return false;
    }*/
}