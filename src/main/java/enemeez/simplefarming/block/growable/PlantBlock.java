package enemeez.simplefarming.block.growable;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

public class PlantBlock extends GrowableBushBlock
{
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	private static final VoxelShape SMALL_SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	private final Supplier<Item> itemSupplier;
	private final boolean isCropyPlant;

	public PlantBlock(Block.Properties properties, boolean isCropyPlant, Supplier<Item> itemSupplier) {
		super(properties);
		this.isCropyPlant = isCropyPlant;
		this.itemSupplier = itemSupplier;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Vector3d vec = state.getOffset(worldIn, pos);
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

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return isCropyPlant ? PlantType.CROP : super.getPlantType(world, pos);
	}
}