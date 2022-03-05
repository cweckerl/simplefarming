package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

public class GrapeLeavesBlock extends BushBlock implements BonemealableBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public GrapeLeavesBlock(Block.Properties properties) {
		super(properties);
		registerDefaultState(stateDefinition.any().setValue(AGE, 0));
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ModItems.GRAPES.get());
	}

	// Tick method
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
		int age = state.getValue(AGE);
		if (age < 7 && worldIn.getRawBrightness(pos.above(), 0) >= 9 && ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
			worldIn.setBlock(pos, state.setValue(AGE, age + 1), Block.UPDATE_ALL);
			ForgeHooks.onCropsGrowPost(worldIn, pos, state);
		}

		//we fire the forge crop growth event here to allow other mods to cancel the growing of grapes/leaves (e.g. serene seasons)
		if (age == 7 && ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {

			if (state.getBlock() == ModBlocks.GRAPE_LEAVES.get()) {
				BlockState stateBelow = worldIn.getBlockState(pos.below());
				if (stateBelow.getMaterial().isReplaceable() && random.nextInt(35) == 0) {
					worldIn.setBlock(pos.below(), ModBlocks.GRAPE_BLOCK.get().defaultBlockState(), Block.UPDATE_ALL);
				}
			}

			if (worldIn.getBlockState(pos.below()).getBlock() == ModBlocks.GRAPE_PLANT.get()) {
				if (worldIn.getBlockState(pos.east()).getBlock() instanceof FenceBlock) {
					worldIn.setBlock(pos.east(), ModBlocks.GRAPE_LEAVES.get().defaultBlockState().setValue(AGE, 0).setValue(FACING, Direction.NORTH), Block.UPDATE_ALL);
				}

				if (worldIn.getBlockState(pos.west()).getBlock() instanceof FenceBlock) {
					worldIn.setBlock(pos.west(), ModBlocks.GRAPE_LEAVES.get().defaultBlockState().setValue(AGE, 0).setValue(FACING, Direction.NORTH), Block.UPDATE_ALL);
				}

				if (worldIn.getBlockState(pos.north()).getBlock() instanceof FenceBlock) {
					worldIn.setBlock(pos.north(), ModBlocks.GRAPE_LEAVES.get().defaultBlockState().setValue(AGE, 0).setValue(FACING, Direction.EAST), Block.UPDATE_ALL);
				}

				if (worldIn.getBlockState(pos.south()).getBlock() instanceof FenceBlock) {
					worldIn.setBlock(pos.south(), ModBlocks.GRAPE_LEAVES.get().defaultBlockState().setValue(AGE, 0).setValue(FACING, Direction.EAST), Block.UPDATE_ALL);
				}
			}

			ForgeHooks.onCropsGrowPost(worldIn, pos, state); //TODO: fire the event for each new grape/leave?
		}
	}

	   @OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
	      if (worldIn.isRainingAt(pos.above())) {
	         if (rand.nextInt(15) == 1) {
	            BlockPos blockpos = pos.below();
	            BlockState blockstate = worldIn.getBlockState(blockpos);
	            if (!blockstate.canOcclude() || !blockstate.isFaceSturdy(worldIn, blockpos, Direction.UP)) {
	               double d0 = (double)pos.getX() + rand.nextDouble();
	               double d1 = (double)pos.getY() - 0.05D;
	               double d2 = (double)pos.getZ() + rand.nextDouble();
	               worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	            }
	         }
	      }
	   }
	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == ModBlocks.GRAPE_PLANT.get();
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		if (state.getBlock() == ModBlocks.GRAPE_LEAVES_BASE.get() && world.getBlockState(pos.below()).getBlock() == ModBlocks.GRAPE_PLANT.get())
			return true;
		return state.getBlock() == ModBlocks.GRAPE_LEAVES.get()
				&& (world.getBlockState(pos.east()).getBlock() == ModBlocks.GRAPE_LEAVES_BASE.get() || world.getBlockState(pos.west()).getBlock() == ModBlocks.GRAPE_LEAVES_BASE.get()
				|| world.getBlockState(pos.north()).getBlock() == ModBlocks.GRAPE_LEAVES_BASE.get() || world.getBlockState(pos.south()).getBlock() == ModBlocks.GRAPE_LEAVES_BASE.get());
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getClockWise());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE).add(FACING);
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.getValue(AGE) < 7;
	}

	@Override
	public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	// bone meal grow method
	@Override
	public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
		int newAge = Math.min(7, state.getValue(AGE) + 1);
		worldIn.setBlock(pos, state.setValue(AGE, newAge), Block.UPDATE_ALL);
	}
}