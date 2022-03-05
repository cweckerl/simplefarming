package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;
import java.util.function.Supplier;

public class FruitLeavesBlock extends LeavesBlock implements BonemealableBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
	private final Supplier<Item> itemSupplier;
	private final Supplier<Item> saplingItemSupplier;

	public FruitLeavesBlock(Properties properties, Supplier<Item> itemSupplier, Supplier<Item> saplingItemSupplier) {
		super(properties);
		this.itemSupplier = itemSupplier;
		this.saplingItemSupplier = saplingItemSupplier;
		registerDefaultState(stateDefinition.any().setValue(AGE, 0).setValue(DISTANCE, 1).setValue(PERSISTENT, Boolean.FALSE));
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(itemSupplier.get());
	}

	public ItemStack getSapling(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(saplingItemSupplier.get());
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(DISTANCE) == 7 && !state.getValue(PERSISTENT) || !isMaxAge(state);
	}

	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
		if (!state.getValue(PERSISTENT) && state.getValue(DISTANCE) == 7) {
			dropResources(state, worldIn, pos);
			worldIn.removeBlock(pos, false);
		} else {
			int age = state.getValue(AGE);
			if (age < 7 && worldIn.getRawBrightness(pos.above(), 0) >= 9
					&& ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
				worldIn.setBlock(pos, state.setValue(AGE, age + 1), Block.UPDATE_ALL);
				ForgeHooks.onCropsGrowPost(worldIn, pos, state);
			}
		}
	}

	private static BlockState updateDistance(BlockState state, LevelAccessor worldIn, BlockPos pos) {
		int i = 7;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (Direction direction : Direction.values()) {
			blockpos$mutable.setWithOffset(pos, direction);
			i = Math.min(i, getDistance(worldIn.getBlockState(blockpos$mutable)) + 1);
			if (i == 1) {
				break;
			}
		}

		return state.setValue(DISTANCE, Integer.valueOf(i));
	}

	private static int getDistance(BlockState neighbor) {
		if (ModBlocks.FRUIT_LOG.get() == neighbor.getBlock()) {
			return 0;
		} else {
			return neighbor.getBlock() instanceof FruitLeavesBlock ? neighbor.getValue(DISTANCE) : 7;
		}
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return updateDistance(this.defaultBlockState().setValue(PERSISTENT, Boolean.TRUE), context.getLevel(),
				context.getClickedPos());
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(AGE);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 7;
	}

	protected int getAge(BlockState state) {
		return state.getValue(this.getAgeProperty());
	}

	public BlockState withAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), age);
	}

	public boolean isMaxAge(BlockState state) {
		return state.getValue(this.getAgeProperty()) >= this.getMaxAge();
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !isMaxAge(state);
	}

	@Override
	public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
		return !isMaxAge(state);
	}

	@Override
	public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
		int newAge = Math.min(7, state.getValue(AGE) + 1);
		worldIn.setBlock(pos, state.setValue(AGE, newAge), Block.UPDATE_ALL);
	}

}