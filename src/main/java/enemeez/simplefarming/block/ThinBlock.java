package enemeez.simplefarming.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ThinBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape SHAPE_VERTICAL = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	private static final VoxelShape SHAPE_HORIZONTAL_X = Block.box(0.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	private static final VoxelShape SHAPE_HORIZONTAL_Z = Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 16.0D);

	public ThinBlock(MaterialColor verticalColorIn, Block.Properties properties) {
		super(properties); // remove verticalColorIn
		registerDefaultState(defaultBlockState().setValue(WATERLOGGED, Boolean.FALSE).setValue(AXIS, Direction.Axis.Y));
	}

	protected static boolean isInWater(BlockState state, BlockGetter worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED)) {
			return true;
		} else {
			for (Direction direction : Direction.values()) {
				if (worldIn.getFluidState(pos.relative(direction)).is(FluidTags.WATER)) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return defaultBlockState().setValue(WATERLOGGED, ifluidstate.is(FluidTags.WATER) && ifluidstate.getAmount() == 8)
				.setValue(AXIS, context.getClickedFace().getAxis());
	}

	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		return facing == Direction.DOWN && !canSurvive(stateIn, worldIn, currentPos) ? Blocks.AIR.defaultBlockState()
				: super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(WATERLOGGED);
	}

	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction.Axis axis = state.getValue(AXIS);
		if (axis == Direction.Axis.X)
			return SHAPE_HORIZONTAL_X;
		if (axis == Direction.Axis.Z)
			return SHAPE_HORIZONTAL_Z;
		return SHAPE_VERTICAL;
	}

}
