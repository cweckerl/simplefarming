package enemeez.simplefarming.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.common.ForgeHooks;

import java.util.function.Supplier;

public class DoubleCropBlock extends SingleCropBlock {
    private final Block TOP_BLOCK;
    public static final BooleanProperty RIPE = BooleanProperty.create("ripe");

    public DoubleCropBlock(Properties pProperties, Supplier<Item> seed, Block topBlock) {
        super(pProperties, seed);
        this.TOP_BLOCK = topBlock;
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(this.getAgeProperty(), 0)
            .setValue(RIPE, false)
        );
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pLevel.isAreaLoaded(pPos, 1)) return;
        if (pLevel.getRawBrightness(pPos, 0) >= 9) {
            final int CURR_AGE = this.getAge(pState);
            if (CURR_AGE < this.getMaxAge()) {
                float f = getGrowthSpeed(this, pLevel, pPos);
                if (ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt((int) (25.0F / f) + 1) == 0)) {
                    pLevel.setBlock(pPos, this.getStateForAge(CURR_AGE + 1), 2);
                    ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                }
            } else {
                if (pLevel.getBlockState(pPos.above()).getBlock() == Blocks.AIR) {
                    pLevel.setBlock(pPos, pState.setValue(RIPE, true), 2);
                    pLevel.setBlock(pPos.above(), TOP_BLOCK.defaultBlockState(), 2);
                }
            }
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return !pState.getValue(RIPE);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE, RIPE);
    }


    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pFacing == Direction.UP) {
            if (pState.getValue(RIPE) && pFacingState.getBlock() != TOP_BLOCK) {
                return Blocks.AIR.defaultBlockState();
            }
        }
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return !pState.getValue(RIPE);
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        if (pState.getValue(AGE) < MAX_AGE) {
            this.growCrops(pLevel, pPos, pState);
        } else {
            if (pLevel.getBlockState(pPos.above()).getBlock() == Blocks.AIR) {
                pLevel.setBlock(pPos, pState.setValue(RIPE, true), 2);
                pLevel.setBlock(pPos.above(), TOP_BLOCK.defaultBlockState(), 2);
            }
        }
    }
}