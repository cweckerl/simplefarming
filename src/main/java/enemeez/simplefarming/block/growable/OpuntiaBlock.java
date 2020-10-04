package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;

public class OpuntiaBlock extends GrowableBushBlock
{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	// X axis hit box
	private static final VoxelShape TOP_MIDDLE_X = Block.makeCuboidShape(4.0D, 10.0D, 7.0D, 12.0D, 12.0D, 9.0D);
	private static final VoxelShape MIDDLE_X = Block.makeCuboidShape(2.0D, 4.0D, 7.0D, 14.0D, 10.0D, 9.0D);
	private static final VoxelShape BOT_MIDDLE_X = Block.makeCuboidShape(4.0D, 2.0D, 7.0D, 12.0D, 4.0D, 9.0D);
	private static final VoxelShape BOT_X = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D);
	private static final VoxelShape FRUIT_1_X = Block.makeCuboidShape(12.0D, 10.0D, 7.0D, 14.0D, 12.0D, 9.0D);
	private static final VoxelShape FRUIT_2_X = Block.makeCuboidShape(10.0D, 12.0D, 7.0D, 12.0D, 14.0D, 9.0D);
	private static final VoxelShape FRUIT_3_X = Block.makeCuboidShape(7.0D, 12.0D, 7.0D, 9.0D, 14.0D, 9.0D);
	private static final VoxelShape FRUIT_4_X = Block.makeCuboidShape(4.0D, 12.0D, 7.0D, 6.0D, 14.0D, 9.0D);
	private static final VoxelShape FRUIT_5_X = Block.makeCuboidShape(2.0D, 10.0D, 7.0D, 4.0D, 12.0D, 9.0D);
	private static final VoxelShape UNRIPE_X = VoxelShapes.or(TOP_MIDDLE_X, BOT_MIDDLE_X, MIDDLE_X, BOT_X);
	private static final VoxelShape RIPE_X = VoxelShapes.or(TOP_MIDDLE_X, BOT_MIDDLE_X, MIDDLE_X, BOT_X, FRUIT_1_X, FRUIT_2_X, FRUIT_3_X, FRUIT_4_X, FRUIT_5_X);

	// Z axis hit box
	private static final VoxelShape TOP_MIDDLE_Z = Block.makeCuboidShape(7.0D, 10.0D, 4.0D, 9.0D, 12.0D, 12.0D);
	private static final VoxelShape MIDDLE_Z = Block.makeCuboidShape(7.0D, 4.0D, 2.0D, 9.0D, 10.0D, 14.0D);
	private static final VoxelShape BOT_MIDDLE_Z = Block.makeCuboidShape(7.0D, 2.0D, 4.0D, 9.0D, 4.0D, 12.0D);
	private static final VoxelShape BOT_Z = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D);
	private static final VoxelShape FRUIT_1_Z = Block.makeCuboidShape(7.0D, 10.0D, 12.0D, 9.0D, 12.0D, 14.0D);
	private static final VoxelShape FRUIT_2_Z = Block.makeCuboidShape(7.0D, 12.0D, 10.0D, 9.0D, 14.0D, 12.0D);
	private static final VoxelShape FRUIT_3_Z = Block.makeCuboidShape(7.0D, 12.0D, 7.0D, 9.0D, 14.0D, 9.0D);
	private static final VoxelShape FRUIT_4_Z = Block.makeCuboidShape(7.0D, 12.0D, 4.0D, 9.0D, 14.0D, 6.0D);
	private static final VoxelShape FRUIT_5_Z = Block.makeCuboidShape(7.0D, 10.0D, 2.0D, 9.0D, 12.0D, 4.0D);
	private static final VoxelShape UNRIPE_Z = VoxelShapes.or(TOP_MIDDLE_Z, BOT_MIDDLE_Z, MIDDLE_Z, BOT_Z);
	private static final VoxelShape RIPE_Z = VoxelShapes.or(TOP_MIDDLE_Z, BOT_MIDDLE_Z, MIDDLE_Z, BOT_Z, FRUIT_1_Z, FRUIT_2_Z, FRUIT_3_Z, FRUIT_4_Z, FRUIT_5_Z);

	public OpuntiaBlock(Block.Properties properties) {
		super(properties);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().rotateY());
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(FACING);
		return direction.getAxis() == Direction.Axis.X ? isMaxAge(state) ? RIPE_X : UNRIPE_X : isMaxAge(state) ? RIPE_Z : UNRIPE_Z;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return getShape(state, worldIn, pos, context);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(FACING);
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ModItems.cactus_crop);
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.Desert;
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getBlock().isIn(BlockTags.SAND);
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (isMaxAge(state)) entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
	}
}