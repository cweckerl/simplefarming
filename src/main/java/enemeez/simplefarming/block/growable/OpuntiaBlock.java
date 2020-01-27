package enemeez.simplefarming.block.growable;

import java.util.Random;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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
import net.minecraft.world.server.ServerWorld;

public class OpuntiaBlock extends BushBlock implements IGrowable {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape[] SHAPE_BY_AGE_X = new VoxelShape[] {
			VoxelShapes.or(Block.makeCuboidShape(2.0D, 2.0D, 7.0D, 14.0D, 12.0D, 9.0D),
					Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D)),
			VoxelShapes.or(Block.makeCuboidShape(2.0D, 2.0D, 7.0D, 14.0D, 12.0D, 9.0D),
					Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D)),
			VoxelShapes.or(Block.makeCuboidShape(2.0D, 2.0D, 7.0D, 14.0D, 12.0D, 9.0D),
					Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D)),
			VoxelShapes.or(Block.makeCuboidShape(2.0D, 2.0D, 7.0D, 14.0D, 14.0D, 9.0D),
					Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D)) };
	private static final VoxelShape[] SHAPE_BY_AGE_Z = new VoxelShape[] {
			VoxelShapes.or(Block.makeCuboidShape(7.0D, 2.0D, 2.0D, 9.0D, 12.0D, 14.0D),
					Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D)),
			VoxelShapes.or(Block.makeCuboidShape(7.0D, 2.0D, 2.0D, 9.0D, 12.0D, 14.0D),
					Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D)),
			VoxelShapes.or(Block.makeCuboidShape(7.0D, 2.0D, 2.0D, 9.0D, 12.0D, 14.0D),
					Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D)),
			VoxelShapes.or(Block.makeCuboidShape(7.0D, 2.0D, 2.0D, 9.0D, 14.0D, 14.0D),
					Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D)) };

	public OpuntiaBlock(Block.Properties p_i49971_1_) {
		super(p_i49971_1_);
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().rotateY());
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(FACING);
		return direction.getAxis() == Direction.Axis.X ? SHAPE_BY_AGE_X[state.get(this.getAgeProperty())]
				: SHAPE_BY_AGE_Z[state.get(this.getAgeProperty())];
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		return getShape(state, worldIn, pos, context);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE).add(FACING);
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ModItems.cactus_crop);
	}

	public boolean isMaxAge(BlockState state) {
		return state.get(AGE) == 3;
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void func_225534_a_(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		super.func_225534_a_(state, worldIn, pos, random);
		int i = state.get(AGE);
		if (i < 3 && random.nextInt(5) == 0 && worldIn.func_226659_b_(pos.up(), 0) >= 9) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
		}

	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

	@Override
	public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return net.minecraftforge.common.PlantType.Desert;
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getBlock().isIn(BlockTags.SAND);
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (isMaxAge(state))
			entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(AGE) < 3;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void func_225535_a_(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(3, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}

}