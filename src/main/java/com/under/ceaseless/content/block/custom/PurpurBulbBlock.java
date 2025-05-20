package com.under.ceaseless.content.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PurpurBulbBlock extends Block {
    public static final BooleanProperty ON = BooleanProperty.of("on");

    public PurpurBulbBlock(Settings settings) {
        super(settings.luminance(state -> state.get(ON) ? 15 : 0));
        setDefaultState(this.getStateManager().getDefaultState().with(ON, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ON);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(ON, false);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            boolean current = state.get(ON);
            world.setBlockState(pos, state.with(ON, !current), Block.NOTIFY_ALL);

            world.playSound(
                    null,
                    pos,
                    SoundEvents.BLOCK_LEVER_CLICK,
                    SoundCategory.BLOCKS,
                    0.5f,
                    current ? 0.5f : 1.0f
            );
        }
        return ActionResult.SUCCESS;
    }
}