package enemeez.simplefarming.blocks;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CheeseBlock extends CakeBlock {

	public CheeseBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(BITES, Integer.valueOf(0)));
	}

	@Override
	public ActionResultType func_225533_a_(BlockState state, World world, BlockPos pos, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
	      if (p_225533_2_.isRemote) {
	         ItemStack itemstack = p_225533_4_.getHeldItem(p_225533_5_);
	         if (this.func_226911_a_(p_225533_2_, p_225533_3_, p_225533_1_, p_225533_4_) == ActionResultType.SUCCESS) {
	            return ActionResultType.SUCCESS;
	         }

	         if (itemstack.isEmpty()) {
	            return ActionResultType.CONSUME;
	         }
	      }

	      return this.func_226911_a_(p_225533_2_, p_225533_3_, p_225533_1_, p_225533_4_);
	   }

	@Override
	   private ActionResultType func_226911_a_(IWorld p_226911_1_, BlockPos p_226911_2_, BlockState p_226911_3_, PlayerEntity p_226911_4_) {
	      if (!p_226911_4_.canEat(false)) {
	         return ActionResultType.PASS;
	      } else {
	         p_226911_4_.addStat(Stats.EAT_CAKE_SLICE);
	         p_226911_4_.getFoodStats().addStats(2, 0.1F);
	         int i = p_226911_3_.get(BITES);
	         if (i < 6) {
	            p_226911_1_.setBlockState(p_226911_2_, p_226911_3_.with(BITES, Integer.valueOf(i + 1)), 3);
	         } else {
	            p_226911_1_.removeBlock(p_226911_2_, false);
	         }

	         return ActionResultType.SUCCESS;
	      }
	   }
	private boolean dropCheese(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		spawnAsEntity(worldIn, pos, new ItemStack(ModItems.cheese_slice, 1));
		int i = state.get(BITES);
		if (i < 6) {
			worldIn.setBlockState(pos, state.with(BITES, Integer.valueOf(i + 1)), 3);
		} else {
			worldIn.removeBlock(pos, false);
		}

		return true;
	}

}