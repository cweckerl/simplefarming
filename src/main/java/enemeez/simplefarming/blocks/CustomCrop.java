package enemeez.simplefarming.blocks;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
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
	private Item seeds;
	private int verify;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	
	public CustomCrop(Block.Properties builder, Item seeds, int verify) 
	{
	   super(builder);
	   this.seeds=seeds;
	   this.verify=verify;

	   this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
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
	         if (verify==16)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.corn, random));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         }
	         if (verify==17)
	         {
		         spawnAsEntity(worldIn, pos, new ItemStack(ModItems.kenaf_fiber, random));
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

	         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
	                return true;
	             } else {
	                return false;
	             }
	          }
	return false;
	}
	
	@OnlyIn(Dist.CLIENT)
	protected IItemProvider getSeedsItem() {
	   return seeds;
	}
	
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
	   return new ItemStack(this.getSeedsItem());
	}

}