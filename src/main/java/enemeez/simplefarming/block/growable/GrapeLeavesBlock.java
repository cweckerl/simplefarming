package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.Constants;

import java.util.Random;

public class GrapeLeavesBlock extends BushBlock implements IGrowable {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public GrapeLeavesBlock(Block.Properties properties) {
		super(properties);
		setDefaultState(stateContainer.getBaseState().with(AGE, 0));
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ModItems.grapes);
	}

	// Tick method
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		int age = state.get(AGE);
		if (age < 7 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
			worldIn.setBlockState(pos, state.with(AGE, age + 1), Constants.BlockFlags.BLOCK_UPDATE);
			ForgeHooks.onCropsGrowPost(worldIn, pos, state);
		}

		//we fire the forge crop growth event here to allow other mods to cancel the growing of grapes/leaves (e.g. serene seasons)
		if (age == 7 && ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {

			if (state.getBlock() == ModBlocks.grape_leaves) {
				BlockState stateBelow = worldIn.getBlockState(pos.down());
				if (stateBelow.getMaterial().isReplaceable() && random.nextInt(35) == 0) {
					worldIn.setBlockState(pos.down(), ModBlocks.grape_block.getDefaultState(), Constants.BlockFlags.BLOCK_UPDATE);
				}
			}

			if (worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
				if (worldIn.getBlockState(pos.east()).getBlock() instanceof FenceBlock) {
					worldIn.setBlockState(pos.east(), ModBlocks.grape_leaves.getDefaultState().with(AGE, 0).with(FACING, Direction.NORTH), Constants.BlockFlags.BLOCK_UPDATE);
				}

				if (worldIn.getBlockState(pos.west()).getBlock() instanceof FenceBlock) {
					worldIn.setBlockState(pos.west(), ModBlocks.grape_leaves.getDefaultState().with(AGE, 0).with(FACING, Direction.NORTH), Constants.BlockFlags.BLOCK_UPDATE);
				}

				if (worldIn.getBlockState(pos.north()).getBlock() instanceof FenceBlock) {
					worldIn.setBlockState(pos.north(), ModBlocks.grape_leaves.getDefaultState().with(AGE, 0).with(FACING, Direction.EAST), Constants.BlockFlags.BLOCK_UPDATE);
				}

				if (worldIn.getBlockState(pos.south()).getBlock() instanceof FenceBlock) {
					worldIn.setBlockState(pos.south(), ModBlocks.grape_leaves.getDefaultState().with(AGE, 0).with(FACING, Direction.EAST), Constants.BlockFlags.BLOCK_UPDATE);
				}
			}

			ForgeHooks.onCropsGrowPost(worldIn, pos, state); //TODO: fire the event for each new grape/leave?
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (worldIn.isRainingAt(pos.up())) {
			if (rand.nextInt(15) == 1) {
				BlockPos blockpos = pos.down();
				BlockState blockstate = worldIn.getBlockState(blockpos);
				if (!blockstate.isSolid() || !Block.hasSolidSide(blockstate, worldIn, blockpos, Direction.UP)) {
					double d0 = (float) pos.getX() + rand.nextFloat();
					double d1 = (double) pos.getY() - 0.05D;
					double d2 = (float) pos.getZ() + rand.nextFloat();
					worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == ModBlocks.grape_plant;
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		if (state.getBlock() == ModBlocks.grape_leaves_base && world.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant)
			return true;
		return state.getBlock() == ModBlocks.grape_leaves
				&& (world.getBlockState(pos.east()).getBlock() == ModBlocks.grape_leaves_base || world.getBlockState(pos.west()).getBlock() == ModBlocks.grape_leaves_base
				|| world.getBlockState(pos.north()).getBlock() == ModBlocks.grape_leaves_base || world.getBlockState(pos.south()).getBlock() == ModBlocks.grape_leaves_base);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().rotateY());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE).add(FACING);
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(AGE) < 7;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	// bone meal grow method
	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		int newAge = Math.min(7, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, newAge), Constants.BlockFlags.BLOCK_UPDATE);
	}
}