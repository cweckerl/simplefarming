package enemeez.simplefarming.block;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class CheeseBlock extends CakeBlock {

	public CheeseBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(BITES, Integer.valueOf(0)));
	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote) {
			ItemStack itemstack = player.getHeldItem(handIn);
			if (this.func_226911_a_(worldIn, pos, state, player) == ActionResultType.SUCCESS) {
				return ActionResultType.SUCCESS;
			}

			if (itemstack.isEmpty()) {
				return ActionResultType.CONSUME;
			}
		}

		return this.func_226911_a_(worldIn, pos, state, player);
	}

	private ActionResultType func_226911_a_(IWorld world, BlockPos pos, BlockState state, PlayerEntity entity) {
		int i = state.get(BITES);
		world.addEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(),
				new ItemStack(ModItems.cheese_slice, 1)));
		if (i < 6) {
			world.setBlockState(pos, state.with(BITES, Integer.valueOf(i + 1)), 3);
		} else {
			world.removeBlock(pos, false);
		}

		return ActionResultType.SUCCESS;
	}
}
