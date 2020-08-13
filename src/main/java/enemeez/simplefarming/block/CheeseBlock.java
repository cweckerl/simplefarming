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
import net.minecraftforge.common.util.Constants;

public class CheeseBlock extends CakeBlock {

	public CheeseBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(BITES, 0));
	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote) {
			ItemStack itemstack = player.getHeldItem(handIn);
			if (eatBlock(worldIn, pos, state, player) == ActionResultType.SUCCESS) {
				return ActionResultType.SUCCESS;
			}

			if (itemstack.isEmpty()) {
				return ActionResultType.CONSUME;
			}
		}

		return eatBlock(worldIn, pos, state, player);
	}

	private ActionResultType eatBlock(IWorld world, BlockPos pos, BlockState state, PlayerEntity entity) {
		int bites = state.get(BITES);
		world.addEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.cheese_slice, 1)));
		if (bites < 6) {
			world.setBlockState(pos, state.with(BITES, bites + 1), Constants.BlockFlags.DEFAULT);
		} else {
			world.removeBlock(pos, false);
		}

		return ActionResultType.SUCCESS;
	}
}
