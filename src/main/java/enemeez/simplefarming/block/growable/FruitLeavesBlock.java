package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.Constants;

import java.util.Random;
import java.util.function.Supplier;

public class FruitLeavesBlock extends LeavesBlock implements IGrowable {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	private final Supplier<Item> itemSupplier;
	private final Supplier<Item> saplingItemSupplier;

	public FruitLeavesBlock(Properties properties, Supplier<Item> itemSupplier, Supplier<Item> saplingItemSupplier) {
		super(properties);
		this.itemSupplier = itemSupplier;
		this.saplingItemSupplier = saplingItemSupplier;
		setDefaultState(stateContainer.getBaseState().with(AGE, 0).with(DISTANCE, 1).with(PERSISTENT, Boolean.FALSE));
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(itemSupplier.get());
	}

	public ItemStack getSapling(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(saplingItemSupplier.get());
	}

	@Override
	public boolean ticksRandomly(BlockState state) {
		return state.get(DISTANCE) == 7 && !state.get(PERSISTENT) || !isMaxAge(state);
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (!state.get(PERSISTENT) && state.get(DISTANCE) == 7) {
			spawnDrops(state, worldIn, pos);
			worldIn.removeBlock(pos, false);
		} else {
			int age = state.get(AGE);
			if (age < 7 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
				worldIn.setBlockState(pos, state.with(AGE, age + 1), Constants.BlockFlags.BLOCK_UPDATE);
				ForgeHooks.onCropsGrowPost(worldIn, pos, state);
			}
		}
	}

	private static BlockState updateDistance(BlockState state, IWorld worldIn, BlockPos pos) {
		int dist = 7;

		try (BlockPos.PooledMutable mutablePos = BlockPos.PooledMutable.retain()) {
			for (Direction direction : Direction.values()) {
				mutablePos.setPos(pos).move(direction);
				dist = Math.min(dist, getDistance(worldIn.getBlockState(mutablePos)) + 1);
				if (dist == 1) {
					break;
				}
			}
		}
		return state.with(DISTANCE, dist);
	}

	private static int getDistance(BlockState neighbor) {
		if (ModBlocks.fruit_log == neighbor.getBlock()) {
			return 0;
		} else {
			return neighbor.getBlock() instanceof FruitLeavesBlock ? neighbor.get(DISTANCE) : 7;
		}
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return updateDistance(this.getDefaultState().with(PERSISTENT, Boolean.TRUE), context.getWorld(), context.getPos());
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
		return this.getDefaultState().with(this.getAgeProperty(), age);
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
		int newAge = Math.min(7, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, newAge), Constants.BlockFlags.BLOCK_UPDATE);
	}

}