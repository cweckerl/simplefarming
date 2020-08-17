package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.config.FeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.Constants;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Modified by Elenterius on 15.08.2020
 */
public class DoubleCropBlock extends SimpleCropBlock
{
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public DoubleCropBlock(Block.Properties properties, Supplier<Item> itemSupplier, Supplier<Item> seedItemSupplier) {
        super(properties, itemSupplier, seedItemSupplier);
        setDefaultState(stateContainer.getBaseState().with(getAgeProperty(), 0).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() instanceof FarmlandBlock;
    }

    public DoubleBlockHalf getHalf(BlockState state) {
        return state.get(HALF);
    }

    // Tick function
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1))
            return;
        if (worldIn.getLightSubtracted(pos, 0) >= 9) {
            int age = getAge(state);
            if (age < getMaxAge()) {
                float f = getGrowthChance(this, worldIn, pos);
                if (ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
                    if (age == getMaxAge() - 1) {
                        if (worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState() && worldIn.getBlockState(pos.down()).getBlock() instanceof FarmlandBlock) {
                            worldIn.setBlockState(pos.up(), this.withAge(getMaxAge()).with(HALF, DoubleBlockHalf.UPPER), Constants.BlockFlags.BLOCK_UPDATE);
                            worldIn.setBlockState(pos, this.withAge(getMaxAge()).with(HALF, DoubleBlockHalf.LOWER), Constants.BlockFlags.BLOCK_UPDATE);
                            ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                        }
                    }
                    else {
                        worldIn.setBlockState(pos, this.withAge(age + 1), Constants.BlockFlags.BLOCK_UPDATE);
                    }
                    ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }

    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return (worldIn.getLightSubtracted(pos, 0) >= 8 || worldIn.canSeeSky(pos)) && placementChecker(state, worldIn, pos);
    }

    private boolean placementChecker(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState testState = worldIn.getBlockState(pos.down());
        if (testState.getBlock() instanceof FarmlandBlock)
            return true;
        return testState == this.withAge(getMaxAge()).with(HALF, DoubleBlockHalf.LOWER) && worldIn.getBlockState(pos.down(2)).getBlock() instanceof FarmlandBlock;
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return !isMaxAge(state) && worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState() && worldIn.getBlockState(pos.down()).getBlock() instanceof FarmlandBlock;
    }

    @Override
    public void grow(World worldIn, BlockPos pos, BlockState state) {
        int newAge = getAge(state) + getBonemealAgeIncrease(worldIn);
        int maxAge = getMaxAge() - 1;
        if (newAge >= maxAge && worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState() && worldIn.getBlockState(pos.down()).getBlock() instanceof FarmlandBlock) {
            worldIn.setBlockState(pos, withAge(getMaxAge()), Constants.BlockFlags.BLOCK_UPDATE);
            worldIn.setBlockState(pos.up(), withAge(getMaxAge()).with(DoubleCropBlock.HALF, DoubleBlockHalf.UPPER), Constants.BlockFlags.BLOCK_UPDATE);
            return;
        }

        worldIn.setBlockState(pos, withAge(newAge), Constants.BlockFlags.BLOCK_UPDATE);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!worldIn.isRemote) {
            Block below = worldIn.getBlockState(pos.down()).getBlock();
            if (state.getBlock() == this && below == this) { //make sure the block below is also a double crop block
                DoubleCropBlock crop = (DoubleCropBlock) worldIn.getBlockState(pos).getBlock();
                if (crop.getAge(state) == getMaxAge() && crop.getHalf(state) == DoubleBlockHalf.UPPER) {
                    worldIn.setBlockState(pos.down(), crop.getDefaultState(), Constants.BlockFlags.BLOCK_UPDATE);
                }
            }
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE, HALF);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (FeatureConfig.doubleCropsSlowDownMotion.get() && entityIn instanceof LivingEntity && isMaxAge(state)) {
            entityIn.setMotionMultiplier(state, new Vec3d(0.8D, 0.75D, 0.8D));
        }
    }
}
