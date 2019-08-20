package enemeez.simplefarming.blocks;

import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class GrapeBlock extends BushBlock
{
	
		 public GrapeBlock(Properties properties) 
		 {
			super(properties);
		 }

	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) 
	      {
		      if (world.getBlockState(pos.up()).getBlock() == ModBlocks.grape_trellising_ns || world.getBlockState(pos.up()).getBlock() == ModBlocks.grape_trellising_we)
					return true;

		      return false;
		   }
	
	 public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) 
		{
		 if (!FeatureConfig.right_click_harvest.get()) return false;
				 if (!worldIn.isRemote)
				 {
				         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.grapes, 1));
				         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
				         worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
			                return true;
				 } 
		
			
			 	return false;
		}
	 
	 public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) 
	   {
	      if (entityIn instanceof LivingEntity) 
	      {
	         entityIn.setMotionMultiplier(state, new Vec3d((double)0.8F, 0.75D, (double)0.8F));
	       }
	   }
	 
	 
	 public BlockRenderLayer getRenderLayer() 
	 {
	      return BlockRenderLayer.CUTOUT;
	   }
	

}
