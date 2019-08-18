package enemeez.simplefarming.blocks;

import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.item.ItemEntity;
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
import net.minecraftforge.common.util.FakePlayer;

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
		if (FeatureConfig.right_click_harvest.get())
		{
		 if (!worldIn.isRemote)
		 {
			 if (this.isMaxAge(state))
			 {
				 Item fruit = ModItems.cucumber;
				 Block fruitBlock = ModBlocks.squash_block;
				 boolean isBlock = false;
				 int itemCount = (int)((Math.random()*4)+1);

				 if (verify==1)
				 {
					 fruit = ModItems.cucumber;
				 }
				 if (verify==2)
				 {
					 fruit = ModItems.eggplant;
				 }
				 if (verify==3)
				 {
					 fruit = ModItems.lettuce;
				 }
				 if (verify==4)
				 {
					 fruit = ModItems.oat;
					 itemCount = 1;
				 }
				 if (verify==5)
				 {
					 fruit = ModItems.onion;
				 }
				 if (verify==6)
				 {
					 if (Math.random()<=0.05) {
						 fruit = ModItems.habanero;
						 itemCount = 1;
					 }
					 else {
						 fruit = ModItems.pepper;
					 }
				 }
				 if (verify==7)
				 {
					 fruit = ModItems.radish;
				 }
				 if (verify==8)
				 {
					 fruit = ModItems.rice;
					 itemCount = 1;
				 }
				 if (verify==9)
				 {
					 fruit = ModItems.rye;
					 itemCount = 1;
				 }
				 if (verify==10)
				 {
					 fruit = ModItems.soybean;
				 }
				 if (verify==11)
				 {
					 fruit = ModItems.spinach;
				 }
				 if (verify==12)
				 {
					 fruit = ModItems.tomato;
				 }
				 if (verify==13)
				 {
					 fruit = ModItems.yam;
				 }
				 if (verify==14)
				 {
					 fruit = Items.CARROT;
				 }
				 if (verify==15)
				 {
					 fruit = Items.POTATO;
				 }
				 if (verify==18)
				 {
					 isBlock = true;
					 fruitBlock = ModBlocks.squash_block;
					 itemCount = 1;
				 }
				 if (verify==19)
				 {
					 isBlock = true;
					 fruitBlock = ModBlocks.cantaloupe_block;
					 itemCount = 1;
				 }
				 if (verify==20)
				 {
					 fruit = ModItems.cassava;
				 }
				 if (verify==21)
				 {
					 isBlock = true;
					 fruitBlock = ModBlocks.honeydew_block;
					 itemCount = 1;
				 }
				 if (verify==22)
				 {
					 fruit = ModItems.ginger;
				 }
				 if (verify==23)
				 {
					 fruit = ModItems.peanut;
				 }

				 ItemStack fruitStack;
				 if(!isBlock){
					 fruitStack = new ItemStack(fruit, itemCount);
				 } else {
					 fruitStack = new ItemStack(fruitBlock, itemCount);
				 }
				 ItemEntity fruitItem = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), fruitStack);
				 worldIn.addEntity(fruitItem);
				 if(!(player instanceof FakePlayer)) {
					 fruitItem.onCollideWithPlayer(player);
				 }

				 worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);

				 worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
		                return true;
		             } else {
		                return false;
		             }
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
         if (verify==22)
        	 return ModItems.ginger_seeds;
         else
        	 return ModItems.peanut_seeds;
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
	         if (verify==22)
		         return new ItemStack(ModItems.ginger);
	         else
	        	 return new ItemStack(ModItems.peanut);
	   }
	


}