package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GrapeLeaves extends BushBlock implements IGrowable {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;

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

		if (i == 7 && worldIn.getBlockState(pos.down()).getMaterial().isReplaceable() && random.nextInt(35) == 0) {
			worldIn.setBlockState(pos.down(), ModBlocks.grape_block.getDefaultState(), 2);
		}

		if (i == 7 && worldIn.getBlockState(pos.east()).getBlock() instanceof FenceBlock
				&& worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
			worldIn.setBlockState(pos.east(), Blocks.AIR.getDefaultState(), 2);
			worldIn.setBlockState(pos.east(),
					ModBlocks.grape_trellising_we.getDefaultState().with(AGE, Integer.valueOf(0)), 2);
		}

		if (i == 7 && worldIn.getBlockState(pos.west()).getBlock() instanceof FenceBlock
				&& worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
			worldIn.setBlockState(pos.west(), Blocks.AIR.getDefaultState(), 2);
			worldIn.setBlockState(pos.west(),
					ModBlocks.grape_trellising_we.getDefaultState().with(AGE, Integer.valueOf(0)), 2);
		}

		if (i == 7 && worldIn.getBlockState(pos.north()).getBlock() instanceof FenceBlock
				&& worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
			worldIn.setBlockState(pos.north(), Blocks.AIR.getDefaultState(), 2);
			worldIn.setBlockState(pos.north(),
					ModBlocks.grape_trellising_ns.getDefaultState().with(AGE, Integer.valueOf(0)), 2);
		}

		if (i == 7 && worldIn.getBlockState(pos.south()).getBlock() instanceof FenceBlock
				&& worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant) {
			worldIn.setBlockState(pos.south(), Blocks.AIR.getDefaultState(), 2);
			worldIn.setBlockState(pos.south(),
					ModBlocks.grape_trellising_ns.getDefaultState().with(AGE, Integer.valueOf(0)), 2);
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

		if (state.getBlock() == ModBlocks.grape_leaves
				&& world.getBlockState(pos.down()).getBlock() == ModBlocks.grape_plant)
			return true;

		else if (world.getBlockState(pos.east()).getBlock() == ModBlocks.grape_leaves

				|| world.getBlockState(pos.west()).getBlock() == ModBlocks.grape_leaves

				|| world.getBlockState(pos.north()).getBlock() == ModBlocks.grape_leaves

				|| world.getBlockState(pos.south()).getBlock() == ModBlocks.grape_leaves

		)
			return true;

		return false;

	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
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