package dev.enemeez.simplefarming.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.stream.Stream;

public class GrapevineSourceBlock extends Block {
    private static final BooleanProperty CAN_SPREAD = BooleanProperty.create("can_spread");

    public GrapevineSourceBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(CAN_SPREAD, true));
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(CAN_SPREAD);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CAN_SPREAD);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        // Source can only spread in one direction
        Stream.of(Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST, Direction.UP)
            .filter(tmpDir -> {
                var neighborPos = pPos.relative(tmpDir);
                var neighborState = pLevel.getBlockState(neighborPos);
                return neighborState.getBlock() instanceof TrellisBlock && !neighborState.getValue(TrellisBlock.CAN_GROW);
            })
            .findFirst()
            .ifPresent(tmpDir -> {
                var neighborPos = pPos.relative(tmpDir);
                var neighborState = pLevel.getBlockState(neighborPos);
                pLevel.setBlock(neighborPos, neighborState
                    .setValue(TrellisBlock.CAN_GROW, true)
                    .setValue(TrellisBlock.CAN_SPREAD, true)
                    .setValue(TrellisBlock.DISTANCE_FROM_SOURCE, TrellisBlock.MIN_DISTANCE), 2
                );
                pLevel.setBlock(pPos, pState.setValue(CAN_SPREAD, false), 2);
            });
    }
}
