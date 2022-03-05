package enemeez.simplefarming.block.growable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class BerryBushBlock extends GrowableBushBlock implements BonemealableBlock
{
	protected static final VoxelShape SHAPE = Shapes.or(Block.box(1.0D, 2.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.box(5.0D, 0.D, 5.0D, 11.0D, 2.0D, 11.0D));
	private final Supplier<Item> itemSupplier;

	public BerryBushBlock(Block.Properties properties, Supplier<Item> itemSupplier) {
		super(properties);
		this.itemSupplier = itemSupplier;
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(itemSupplier.get());
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity) {
			entityIn.makeStuckInBlock(state, new Vec3(0.8D, 0.75D, 0.8D));
		}
	}

}