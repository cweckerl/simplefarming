package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

public class OpuntiaBlock extends GrowableBushBlock
{
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	// X axis hit box
	private static final VoxelShape TOP_MIDDLE_X = Block.box(4.0D, 10.0D, 7.0D, 12.0D, 12.0D, 9.0D);
	private static final VoxelShape MIDDLE_X = Block.box(2.0D, 4.0D, 7.0D, 14.0D, 10.0D, 9.0D);
	private static final VoxelShape BOT_MIDDLE_X = Block.box(4.0D, 2.0D, 7.0D, 12.0D, 4.0D, 9.0D);
	private static final VoxelShape BOT_X = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D);
	private static final VoxelShape FRUIT_1_X = Block.box(12.0D, 10.0D, 7.0D, 14.0D, 12.0D, 9.0D);
	private static final VoxelShape FRUIT_2_X = Block.box(10.0D, 12.0D, 7.0D, 12.0D, 14.0D, 9.0D);
	private static final VoxelShape FRUIT_3_X = Block.box(7.0D, 12.0D, 7.0D, 9.0D, 14.0D, 9.0D);
	private static final VoxelShape FRUIT_4_X = Block.box(4.0D, 12.0D, 7.0D, 6.0D, 14.0D, 9.0D);
	private static final VoxelShape FRUIT_5_X = Block.box(2.0D, 10.0D, 7.0D, 4.0D, 12.0D, 9.0D);
	private static final VoxelShape UNRIPE_X = Shapes.or(TOP_MIDDLE_X, BOT_MIDDLE_X, MIDDLE_X, BOT_X);
	private static final VoxelShape RIPE_X = Shapes.or(TOP_MIDDLE_X, BOT_MIDDLE_X, MIDDLE_X, BOT_X, FRUIT_1_X, FRUIT_2_X, FRUIT_3_X, FRUIT_4_X, FRUIT_5_X);

	// Z axis hit box
	private static final VoxelShape TOP_MIDDLE_Z = Block.box(7.0D, 10.0D, 4.0D, 9.0D, 12.0D, 12.0D);
	private static final VoxelShape MIDDLE_Z = Block.box(7.0D, 4.0D, 2.0D, 9.0D, 10.0D, 14.0D);
	private static final VoxelShape BOT_MIDDLE_Z = Block.box(7.0D, 2.0D, 4.0D, 9.0D, 4.0D, 12.0D);
	private static final VoxelShape BOT_Z = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D);
	private static final VoxelShape FRUIT_1_Z = Block.box(7.0D, 10.0D, 12.0D, 9.0D, 12.0D, 14.0D);
	private static final VoxelShape FRUIT_2_Z = Block.box(7.0D, 12.0D, 10.0D, 9.0D, 14.0D, 12.0D);
	private static final VoxelShape FRUIT_3_Z = Block.box(7.0D, 12.0D, 7.0D, 9.0D, 14.0D, 9.0D);
	private static final VoxelShape FRUIT_4_Z = Block.box(7.0D, 12.0D, 4.0D, 9.0D, 14.0D, 6.0D);
	private static final VoxelShape FRUIT_5_Z = Block.box(7.0D, 10.0D, 2.0D, 9.0D, 12.0D, 4.0D);
	private static final VoxelShape UNRIPE_Z = Shapes.or(TOP_MIDDLE_Z, BOT_MIDDLE_Z, MIDDLE_Z, BOT_Z);
	private static final VoxelShape RIPE_Z = Shapes.or(TOP_MIDDLE_Z, BOT_MIDDLE_Z, MIDDLE_Z, BOT_Z, FRUIT_1_Z, FRUIT_2_Z, FRUIT_3_Z, FRUIT_4_Z, FRUIT_5_Z);

	public OpuntiaBlock(Block.Properties properties) {
		super(properties);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getClockWise());
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(FACING);
		return direction.getAxis() == Direction.Axis.X ? isMaxAge(state) ? RIPE_X : UNRIPE_X : isMaxAge(state) ? RIPE_Z : UNRIPE_Z;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return getShape(state, worldIn, pos, context);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ModItems.CACTUS_CROP.get());
	}

	@Override
	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		return false;
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.DESERT;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.below()).is(BlockTags.SAND);
	}

	@Override
	public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
		if (isMaxAge(state)) entityIn.hurt(DamageSource.CACTUS, 1.0F);
	}
}