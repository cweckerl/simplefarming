package enemeez.simplefarming.block.growable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

public abstract class GrowableBushBlock extends BushBlock implements BonemealableBlock
{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    protected GrowableBushBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(getAgeProperty(), 0));
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public BlockState withAge(int age) {
        return defaultBlockState().setValue(getAgeProperty(), age);
    }

    public BlockState withMaxAge() {
        return defaultBlockState().setValue(getAgeProperty(), getMaxAge());
    }

    public boolean isMaxAge(BlockState state) {
        return state.getValue(getAgeProperty()) == getMaxAge();
    }

    public int getMaxAge() {
        return 3;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        int age = state.getValue(getAgeProperty());
        if (age < getMaxAge() && worldIn.getRawBrightness(pos.above(), 0) >= 9 && ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
            worldIn.setBlock(pos, state.setValue(getAgeProperty(), age + 1), Block.UPDATE_ALL);
            ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(getAgeProperty());
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.getValue(getAgeProperty()) < getMaxAge();
    }

    @Override
    public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    // grow method called by bone meal
    @Override
    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
        int newAge = Math.min(getMaxAge(), state.getValue(getAgeProperty()) + 1);
        worldIn.setBlock(pos, state.setValue(getAgeProperty(), newAge), Block.UPDATE_ALL);
    }
}
