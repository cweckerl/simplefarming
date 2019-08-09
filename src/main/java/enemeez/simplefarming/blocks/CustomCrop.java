package enemeez.simplefarming.blocks;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomCrop extends CropsBlock
{ 
	private int verify;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	
	public CustomCrop(Block.Properties builder, int verify) 
	{
	   super(builder);

	   this.verify=verify;

	   this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      return state.getBlock() instanceof FarmlandBlock;
	   }
	
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) 
	{
	 if (!worldIn.isRemote)
	 {
		 if (this.isMaxAge(state))
		 {
	         int random = (int)((Math.random()*4)+1);
	         if (verify==1)
	         {
	        	 spawnAsEntity(worldIn, pos, new ItemStack(ModItems.cucumber, random));
	        	 worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==2)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.eggplant, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==3)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.lettuce, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==4)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.oat, 1));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==5)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.onion, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==6)
	         {
		         if (Math.random()<=0.05)
		        	 spawnAsEntity(worldIn, pos, new ItemStack(ModItems.habanero, 1));
		         else 
		        	 spawnAsEntity(worldIn, pos, new ItemStack(ModItems.pepper, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==7)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.radish, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==8)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.rice, 1));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==9)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.rye, 1));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==10)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.soybean, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==11)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.spinach, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==12)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.tomato, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==13)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.yam, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==14)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(Items.CARROT, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==15)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(Items.POTATO, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }

	         if (verify==18)
	         {
	        	 spawnAsEntity(worldIn, pos, new ItemStack(ModBlocks.squash_block, 1));
	        	 worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==19)
	         {
	        	 spawnAsEntity(worldIn, pos, new ItemStack(ModBlocks.cantaloupe_block, 1));
	        	 worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==20)
	         {
	        	 spawnAsEntity(worldIn, pos, new ItemStack(ModItems.cassava, random));
	        	 worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==21)
	         {
	        	 spawnAsEntity(worldIn, pos, new ItemStack(ModBlocks.honeydew_block, 1));
	        	 worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==22)
	         {
	        	 spawnAsEntity(worldIn, pos, new ItemStack(ModItems.ginger, random));
	        	 worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }

	         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
	                return true;
	             } else {
	                return false;
	             }
	          }
	return false;
	}
	
	@OnlyIn(Dist.CLIENT)
	   protected IItemProvider getSeedsItem() 
	   {
		 if (verify==1)
        	 return ModItems.cucumber_seeds;	 
         if (verify==2)
        	 return ModItems.eggplant_seeds;
         if (verify==3)
        	 return ModItems.lettuce_seeds;
         if (verify==4)
	         return ModItems.oat_seeds;
         if (verify==5)
        	 return ModItems.onion_seeds;
         if (verify==6)
        	 return ModItems.pepper_seeds;
         if (verify==7)
        	 return ModItems.radish_seeds;
         if (verify==8)
        	 return ModItems.rice_seeds;
         if (verify==9)
        	 return ModItems.rye_seeds;
         if (verify==10)
        	 return ModItems.soybean_seeds;
         if (verify==11)
	         return ModItems.spinach_seeds;
         if (verify==12)
	         return ModItems.tomato_seeds;
         if (verify==13)
	         return ModItems.yam_seeds;
         if (verify==14)
	         return ModItems.carrot_seeds;
         if (verify==15)
	         return ModItems.potato_seeds;
         if (verify==18)
	         return ModItems.squash_seeds;
         if (verify==19)
	         return ModItems.cantaloupe_seeds;
         if (verify==20)
	         return ModItems.cassava_seeds;
         if (verify==21)
	         return ModItems.honeydew_seeds;
         else
        	 return ModItems.ginger_seeds;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) 
	   {
		   if (verify==1)
	        	 return new ItemStack(ModItems.cucumber);	 
	         if (verify==2)
	        	 return new ItemStack(ModItems.eggplant);
	         if (verify==3)
	        	 return new ItemStack(ModItems.lettuce);
	         if (verify==4)
		         return new ItemStack(ModItems.oat);
	         if (verify==5)
	        	 return new ItemStack(ModItems.onion);
	         if (verify==6)
	        	 return new ItemStack(ModItems.pepper);
	         if (verify==7)
	        	 return new ItemStack(ModItems.radish);
	         if (verify==8)
	        	 return new ItemStack(ModItems.rice);
	         if (verify==9)
	        	 return new ItemStack(ModItems.rye);
	         if (verify==10)
	        	 return new ItemStack(ModItems.soybean);
	         if (verify==11)
		         return new ItemStack(ModItems.spinach);
	         if (verify==12)
		         return new ItemStack(ModItems.tomato);
	         if (verify==13)
		         return new ItemStack(ModItems.yam);
	         if (verify==14)
		         return new ItemStack(Items.CARROT);
	         if (verify==15)
		         return new ItemStack(Items.POTATO);
	         if (verify==18)
		         return new ItemStack(ModItems.squash_block);
	         if (verify==19)
		         return new ItemStack(ModItems.cantaloupe_block);
	         if (verify==20)
		         return new ItemStack(ModItems.cassava);
	         if (verify==21)
		         return new ItemStack(ModItems.honeydew_block);
	         else
		         return new ItemStack(ModItems.ginger);
	   }
	


}