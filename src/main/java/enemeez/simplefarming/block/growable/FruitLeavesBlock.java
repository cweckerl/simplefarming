package enemeez.simplefarming.block.growable;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class FruitLeavesBlock extends LeavesBlock implements IGrowable {
	private String name;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;

	public FruitLeavesBlock(Block.Properties properties, String name) {
		super(properties);
		this.name = name;
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0))
				.with(DISTANCE, Integer.valueOf(1)).with(PERSISTENT, Boolean.valueOf(false)));
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		switch (name) {
		case "apple":
			return new ItemStack(Items.APPLE);
		case "apricot":
			return new ItemStack(ModItems.apricot);
		case "banana":
			return new ItemStack(ModItems.banana);
		case "cherries":
			return new ItemStack(ModItems.cherries);
		case "orange":
			return new ItemStack(ModItems.orange);
		case "mango":
			return new ItemStack(ModItems.mango);
		case "pear":
			return new ItemStack(ModItems.pear);
		case "plum":
			return new ItemStack(ModItems.plum);
		default:
			return new ItemStack(ModItems.olives);
		}
	}

	public ItemStack getSapling(IBlockReader worldIn, BlockPos pos, BlockState state) {
		switch (name) {
		case "apple":
			return new ItemStack(ModItems.apple_sapling);
		case "apricot":
			return new ItemStack(ModItems.apricot_sapling);
		case "banana":
			return new ItemStack(ModItems.banana_sapling);
		case "cherries":
			return new ItemStack(ModItems.cherry_sapling);
		case "orange":
			return new ItemStack(ModItems.orange_sapling);
		case "mango":
			return new ItemStack(ModItems.mango_sapling);
		case "pear":
			return new ItemStack(ModItems.pear_sapling);
		case "plum":
			return new ItemStack(ModItems.plum_sapling);
		default:
			return new ItemStack(ModItems.olive_sapling);
		}
	}

	public boolean ticksRandomly(BlockState state) {
		return state.get(DISTANCE) == 7 && !state.get(PERSISTENT) || !isMaxAge(state);
	}

	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (!state.get(PERSISTENT) && state.get(DISTANCE) == 7) {
			spawnDrops(state, worldIn, pos);
			worldIn.removeBlock(pos, false);
		} else {
			super.tick(state, worldIn, pos, random);
			int i = state.get(AGE);
			if (i < 7 && random.nextInt(5) == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9) {
				worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
			}
		}
	}

	private static BlockState updateDistance(BlockState state, IWorld worldIn, BlockPos pos) {
		int i = 7;

		try (BlockPos.PooledMutable blockpos$pooledmutable = BlockPos.PooledMutable.retain()) {
			for (Direction direction : Direction.values()) {
				blockpos$pooledmutable.setPos(pos).move(direction);
				i = Math.min(i, getDistance(worldIn.getBlockState(blockpos$pooledmutable)) + 1);
				if (i == 1) {
					break;
				}
			}
		}

		return state.with(DISTANCE, Integer.valueOf(i));
	}

	private static int getDistance(BlockState neighbor) {
		if (ModBlocks.fruit_log == neighbor.getBlock()) {
			return 0;
		} else {
			return neighbor.getBlock() instanceof FruitLeavesBlock ? neighbor.get(DISTANCE) : 7;
		}
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return updateDistance(this.getDefaultState().with(PERSISTENT, Boolean.valueOf(true)), context.getWorld(),
				context.getPos());
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DISTANCE, PERSISTENT, AGE);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 7;
	}

	protected int getAge(BlockState state) {
		return state.get(this.getAgeProperty());
	}

	public BlockState withAge(int age) {
		return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(BlockState state) {
		return state.get(this.getAgeProperty()) >= this.getMaxAge();
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !isMaxAge(state);
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return !isMaxAge(state);
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		// unused
		int i = Math.min(7, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}

}