package enemeez.simplefarming.block.growable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.Constants;

import java.util.Random;

public abstract class GrowableBushBlock extends BushBlock implements IGrowable
{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

    protected GrowableBushBlock(Properties properties) {
        super(properties);
        setDefaultState(stateContainer.getBaseState().with(getAgeProperty(), 0));
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public BlockState withAge(int age) {
        return getDefaultState().with(getAgeProperty(), age);
    }

    public BlockState withMaxAge() {
        return getDefaultState().with(getAgeProperty(), getMaxAge());
    }

    public boolean isMaxAge(BlockState state) {
        return state.get(getAgeProperty()) == getMaxAge();
    }

    public int getMaxAge() {
        return 3;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        int age = state.get(getAgeProperty());
        if (age < getMaxAge() && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
            worldIn.setBlockState(pos, state.with(getAgeProperty(), age + 1), Constants.BlockFlags.BLOCK_UPDATE);
            ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(getAgeProperty());
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(getAgeProperty()) < getMaxAge();
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    // grow method called by bone meal
    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        int newAge = Math.min(getMaxAge(), state.get(getAgeProperty()) + 1);
        worldIn.setBlockState(pos, state.with(getAgeProperty(), newAge), Constants.BlockFlags.BLOCK_UPDATE);
    }
}
