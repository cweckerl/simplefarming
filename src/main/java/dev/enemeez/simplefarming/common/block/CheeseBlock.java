package dev.enemeez.simplefarming.common.block;

import dev.enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class CheeseBlock extends CakeBlock {
    public CheeseBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            if (slice(pLevel, pPos, pState, pPlayer).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (pPlayer.getItemInHand(pHand).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return slice(pLevel, pPos, pState, pPlayer);
    }

    private InteractionResult slice(LevelAccessor pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        int bites = pState.getValue(BITES);
        pLevel.addFreshEntity(new ItemEntity(
            (Level) pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), new ItemStack(ModItems.CHEESE_SLICE.get())
        ));

        if (bites < MAX_BITES) {
            pLevel.setBlock(pPos, pState.setValue(BITES, bites + 1), 3);
        } else {
            pLevel.removeBlock(pPos, false);
            pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);
        }

        return InteractionResult.SUCCESS;
    }
}
