package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class WildPlant extends BushBlock implements IGrowable {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	private String name;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

	public WildPlant(Block.Properties p_i49971_1_, String name) {
		super(p_i49971_1_);
		this.name = name;
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		if (name.equals("cumin"))
			return new ItemStack(ModItems.cumin_seeds);
		if (name.equals("sunflower"))
			return new ItemStack(ModItems.sunflower_seeds);
		if (name.equals("marshmallow"))
			return new ItemStack(ModItems.marshmallow_root);
		if (name.equals("chicory"))
			return new ItemStack(ModItems.chicory_root);
		else
			return new ItemStack(ModItems.quinoa_seeds);

	}

	public boolean isMaxAge(BlockState state) {
		return state.get(AGE) == 3;
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		super.tick(state, worldIn, pos, random);
		int i = state.get(AGE);
		if (i < 3 && random.nextInt(5) == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
		}

	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(AGE) < 3;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(3, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}

	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}

}