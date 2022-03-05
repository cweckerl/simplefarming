package enemeez.simplefarming.block;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CheeseBlock extends CakeBlock {

	public CheeseBlock(Block.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
	}

	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (worldIn.isClientSide) {
			ItemStack itemstack = player.getItemInHand(handIn);
			if (eatBlock(worldIn, pos, state, player) == InteractionResult.SUCCESS) {
				return InteractionResult.SUCCESS;
			}

			if (itemstack.isEmpty()) {
				return InteractionResult.CONSUME;
			}
		}

		return eatBlock(worldIn, pos, state, player);
	}

	private InteractionResult eatBlock(LevelAccessor world, BlockPos pos, BlockState state, Player entity) {
		int bites = state.getValue(BITES);
		world.addFreshEntity(new ItemEntity((Level) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.CHEESE_SLICE.get(), 1)));
		if (bites < 6) {
			world.setBlock(pos, state.setValue(BITES, bites + 1), Block.UPDATE_ALL);
		} else {
			world.removeBlock(pos, false);
		}

		return InteractionResult.SUCCESS;
	}
}
