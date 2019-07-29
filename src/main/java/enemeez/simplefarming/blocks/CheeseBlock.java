package enemeez.simplefarming.blocks;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class CheeseBlock extends CakeBlock 
{

	   public CheeseBlock(Block.Properties properties) 
	   {
	      super(properties);
	      this.setDefaultState(this.stateContainer.getBaseState().with(BITES, Integer.valueOf(0)));
	   }


	   public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	      if (!worldIn.isRemote) {
	         return this.dropCheese(worldIn, pos, state, player);
	      } else {
	         ItemStack itemstack = player.getHeldItem(handIn);
	         return this.dropCheese(worldIn, pos, state, player) || itemstack.isEmpty();
	      }
	   }

	   private boolean dropCheese(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) 
	   {
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