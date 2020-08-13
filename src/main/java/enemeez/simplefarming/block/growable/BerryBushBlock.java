package enemeez.simplefarming.block.growable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class BerryBushBlock extends GrowableBushBlock implements IGrowable
{
	protected static final VoxelShape SHAPE = VoxelShapes.or(Block.makeCuboidShape(1.0D, 2.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.makeCuboidShape(5.0D, 0.D, 5.0D, 11.0D, 2.0D, 11.0D));
	private final Supplier<Item> itemSupplier;

	public BerryBushBlock(Block.Properties properties, Supplier<Item> itemSupplier) {
		super(properties);
		this.itemSupplier = itemSupplier;
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(itemSupplier.get());
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity) {
			entityIn.setMotionMultiplier(state, new Vec3d(0.8D, 0.75D, 0.8D));
		}
	}

}