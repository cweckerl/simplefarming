package enemeez.simplefarming.block.growable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class SimpleCropBlock extends CropBlock {
	private final Supplier<Item> itemSupplier;
	private final Supplier<Item> seedItemSupplier;
	private final VoxelShape[] SHAPES;

	public SimpleCropBlock(Block.Properties properties, Supplier<Item> itemSupplier, Supplier<Item> seedItemSupplier) {
		super(properties);
		this.itemSupplier = itemSupplier;
		this.seedItemSupplier = seedItemSupplier;
		SHAPES = null;
	}

	public SimpleCropBlock(Block.Properties properties, Supplier<Item> itemSupplier, Supplier<Item> seedItemSupplier, VoxelShape[] voxelShapes) {
		super(properties);
		this.itemSupplier = itemSupplier;
		this.seedItemSupplier = seedItemSupplier;
		this.SHAPES = voxelShapes;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPES != null ? SHAPES[state.getValue(this.getAgeProperty())] : super.getShape(state, worldIn, pos, context);
	}

	@Override
	public int getAge(BlockState state) {
		return super.getAge(state);
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmBlock;
	}

	@Override
	public ItemLike getBaseSeedId() {
		return seedItemSupplier.get();
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(itemSupplier.get());
	}

}