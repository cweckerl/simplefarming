package enemeez.simplefarming.block.growable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class PlantBlock extends GrowableBushBlock
{
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	private static final VoxelShape SMALL_SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	private final Supplier<Item> itemSupplier;

	public PlantBlock(Block.Properties properties, Supplier<Item> itemSupplier) {
		super(properties);
		this.itemSupplier = itemSupplier;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Vec3d vec = state.getOffset(worldIn, pos);
		return state.get(AGE) < getMaxAge() ? SMALL_SHAPE.withOffset(vec.x, vec.y, vec.z) : SHAPE.withOffset(vec.x, vec.y, vec.z);
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(itemSupplier.get());
	}

	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}

}