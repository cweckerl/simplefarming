package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IGrowable;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GrapeLeaves extends BushBlock implements IGrowable {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public GrapeLeaves(Block.Properties p_i49971_1_) {
		super(p_i49971_1_);
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ModItems.grapes);
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		super.tick(state, worldIn, pos, random);
		int i = state.get(AGE);
		if (i < 7 && random.nextInt(5) == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
		}

		if (i == 7 && state.getBlock() == ModBlocks.grape_leaves
				&& worldIn.getBlockState(pos.down()).getMaterial().isReplaceable() && random.nextInt(35) == 0) {
			worldIn.setBlockState(pos.down(), ModBlocks.grape_block.getDefaultState(), 2);
		}

		if (i == 7
				&& (worldIn.getBlockState(pos.east()) == ModBlocks.trellising_rope.getDefaultState()
						.with(TrellisingRope.FACING, Direction.NORTH)
						|| worldIn.getBlockState(pos.east()) == ModBlocks.trellising_rope.getDefaultState()
								.with(TrellisingRope.FACING, Direction.SOUTH))
				&& worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
			worldIn.setBlockState(pos.east(), Blocks.AIR.getDefaultState(), 2);
			worldIn.setBlockState(pos.east(),
					ModBlocks.grape_leaves.getDefaultState().with(AGE, Integer.valueOf(0)).with(FACING, Direction.WEST),
					2);
		}

		if (i == 7
				&& (worldIn.getBlockState(pos.west()) == ModBlocks.trellising_rope.getDefaultState()
						.with(TrellisingRope.FACING, Direction.SOUTH)
						|| worldIn.getBlockState(pos.west()) == ModBlocks.trellising_rope.getDefaultState()
								.with(TrellisingRope.FACING, Direction.NORTH))
				&& worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
			worldIn.setBlockState(pos.west(), Blocks.AIR.getDefaultState(), 2);
			worldIn.setBlockState(pos.west(),
					ModBlocks.grape_leaves.getDefaultState().with(AGE, Integer.valueOf(0)).with(FACING, Direction.WEST),
					2);
		}

		if (i == 7
				&& (worldIn.getBlockState(pos.north()) == ModBlocks.trellising_rope.getDefaultState()
						.with(TrellisingRope.FACING, Direction.WEST)
						|| worldIn.getBlockState(pos.north()) == ModBlocks.trellising_rope.getDefaultState()
								.with(TrellisingRope.FACING, Direction.EAST))
				&& worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
			worldIn.setBlockState(pos.north(), Blocks.AIR.getDefaultState(), 2);
			worldIn.setBlockState(pos.north(), ModBlocks.grape_leaves.getDefaultState().with(AGE, Integer.valueOf(0))
					.with(FACING, Direction.NORTH), 2);
		}

		if (i == 7
				&& (worldIn.getBlockState(pos.south()) == ModBlocks.trellising_rope.getDefaultState()
						.with(TrellisingRope.FACING, Direction.EAST)
						|| worldIn.getBlockState(pos.south()) == ModBlocks.trellising_rope.getDefaultState()
								.with(TrellisingRope.FACING, Direction.WEST))
				&& worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
			worldIn.setBlockState(pos.south(), Blocks.AIR.getDefaultState(), 2);
			worldIn.setBlockState(pos.south(), ModBlocks.grape_leaves.getDefaultState().with(AGE, Integer.valueOf(0))
					.with(FACING, Direction.NORTH), 2);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (worldIn.isRainingAt(pos.up())) {
			if (rand.nextInt(15) == 1) {
				BlockPos blockpos = pos.down();
				BlockState blockstate = worldIn.getBlockState(blockpos);
				if (!blockstate.isSolid() || !Block.hasSolidSide(blockstate, worldIn, blockpos, Direction.UP)) {
					double d0 = (double) ((float) pos.getX() + rand.nextFloat());
					double d1 = (double) pos.getY() - 0.05D;
					double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
					worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == ModBlocks.grape_plant;
	}

	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {

		if (state.getBlock() == ModBlocks.grape_leaves_base
				&& world.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant)
			return true;

		if (state.getBlock() == ModBlocks.grape_leaves
				&& (world.getBlockState(pos.east()).getBlock() == ModBlocks.grape_leaves_base

				|| world.getBlockState(pos.west()).getBlock() == ModBlocks.grape_leaves_base

				|| world.getBlockState(pos.north()).getBlock() == ModBlocks.grape_leaves_base

				|| world.getBlockState(pos.south()).getBlock() == ModBlocks.grape_leaves_base)

		)
			return true;

		return false;

	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().rotateY());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE).add(FACING);
	}

	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(AGE) < 7;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(7, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}
}