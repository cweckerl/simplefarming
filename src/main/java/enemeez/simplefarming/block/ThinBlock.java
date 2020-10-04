package enemeez.simplefarming.block;

import javax.annotation.Nullable;

import net.minecraft.block.*;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class ThinBlock extends LogBlock implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape SHAPE_VERTICAL = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	private static final VoxelShape SHAPE_HORIZONTAL_X = Block.makeCuboidShape(0.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	private static final VoxelShape SHAPE_HORIZONTAL_Z = Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 16.0D);

	public ThinBlock(MaterialColor verticalColorIn, Block.Properties properties) {
		super(verticalColorIn, properties);
		setDefaultState(getDefaultState().with(WATERLOGGED, Boolean.FALSE).with(AXIS, Direction.Axis.Y));
	}

	protected static boolean isInWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(WATERLOGGED)) {
			return true;
		} else {
			for (Direction direction : Direction.values()) {
				if (worldIn.getFluidState(pos.offset(direction)).isTagged(FluidTags.WATER)) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
		return getDefaultState().with(WATERLOGGED, ifluidstate.isTagged(FluidTags.WATER) && ifluidstate.getLevel() == 8)
				.with(AXIS, context.getFace().getAxis());
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return facing == Direction.DOWN && !isValidPosition(stateIn, worldIn, currentPos) ? Blocks.AIR.getDefaultState()
				: super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(WATERLOGGED);
	}

	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction.Axis axis = state.get(AXIS);
		if (axis == Direction.Axis.X)
			return SHAPE_HORIZONTAL_X;
		if (axis == Direction.Axis.Z)
			return SHAPE_HORIZONTAL_Z;
		return SHAPE_VERTICAL;
	}

}
