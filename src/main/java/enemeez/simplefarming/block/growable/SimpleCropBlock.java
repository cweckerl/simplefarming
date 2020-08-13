package enemeez.simplefarming.block.growable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class SimpleCropBlock extends CropsBlock {
	private final Supplier<Item> itemSupplier;
	private final Supplier<Item> seedItemSupplier;

	public SimpleCropBlock(Block.Properties properties, Supplier<Item> itemSupplier, Supplier<Item> seedItemSupplier) {
		super(properties);
		this.itemSupplier = itemSupplier;
		this.seedItemSupplier = seedItemSupplier;
	}

	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmlandBlock;
	}

	protected IItemProvider getSeedsItem() {
		return seedItemSupplier.get();
	}

	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(itemSupplier.get());
	}

}