package enemeez.simplefarming.blocks;

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

	public ActionResultType func_225533_a_(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand,
			BlockRayTraceResult blockTrace) {
		if (world.isRemote) {
			ItemStack itemstack = entity.getHeldItem(hand);
			if (this.func_226911_a_(world, pos, state, entity) == ActionResultType.SUCCESS) {
				return ActionResultType.SUCCESS;
			}

			if (itemstack.isEmpty()) {
				return ActionResultType.CONSUME;
			}
		}

		return this.func_226911_a_(world, pos, state, entity);
	}

	private ActionResultType func_226911_a_(IWorld world, BlockPos pos, BlockState state, PlayerEntity entity) {
		if (!entity.canEat(false)) {
			return ActionResultType.PASS;
		} else {
			world.addEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(),
					new ItemStack(ModItems.cheese_slice, 1)));
			int i = state.get(BITES);
			if (i < 6) {
				world.setBlockState(pos, state.with(BITES, Integer.valueOf(i + 1)), 3);
			} else {
				world.removeBlock(pos, false);
			}

			return ActionResultType.SUCCESS;
		}
	}

}