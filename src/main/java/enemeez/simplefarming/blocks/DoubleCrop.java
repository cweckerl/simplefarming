package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class DoubleCrop extends CropsBlock 
{
	   public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	   private String name;
	   
	   public DoubleCrop(Block.Properties builder, String name) 
	   {
	      super(builder);
	      this.name=name;
	      this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	   }


	   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) 
	   {
		   return state.getBlock() instanceof FarmlandBlock;
	      
	   }

	   public int getMaxAge() 
	   {
	      return 6; 
	   }
	   
	   public int getAge(BlockState state) 
	   {
		  return state.get(this.getAgeProperty());
	   }


	   public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
	      super.tick(state, worldIn, pos, random);
	      if (!worldIn.isAreaLoaded(pos, 1)) return; 
	      if (worldIn.getLightSubtracted(pos, 0) >= 9) {
	         int i = this.getAge(state);
	         if (i < 7) { 
	            float f = getGrowthChance(this, worldIn, pos);
	            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) 
	            {
	            	if (i==6)
	            	{
	            		if (worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState())
	            		worldIn.setBlockState(pos.up(), this.withAge(7), 2); 
	            	}
	            	else
	            		worldIn.setBlockState(pos, this.withAge(i + 1), 2);
	               net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
	            }
	         }
	      }

	   }


	   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) 
	   	{
		   return (worldIn.getLightSubtracted(pos, 0) >= 8 || worldIn.isSkyLightMax(pos)) && checker(state, worldIn, pos);
		}
	   

	   public boolean checker(BlockState state, IWorldReader worldIn, BlockPos pos)
	   {
		   BlockState block = worldIn.getBlockState(pos.down());
		   
		   if (block.getBlock() == Blocks.FARMLAND)
			   return true;
		   if (block == this.withAge(6) && !worldIn.getBlockState(pos.down(3)).getBlock().equals(Blocks.FARMLAND))
		         return true; 
		   else 
			   return false;
	   }


	   protected IItemProvider getSeedsItem() 
	   {
		   if (name.equals("corn"))
			   return ModItems.corn_seeds;
		   if (name.equals("kenaf"))
			   return ModItems.kenaf_seeds;
		   else
			   return ModItems.sorghum_seeds;
	   }

	   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) 
	   {
		   if (name.equals("corn"))
			   return new ItemStack(ModItems.corn);
		   if (name.equals("kenaf"))
			   return new ItemStack(ModItems.kenaf_fiber);
		   else
			   return new ItemStack(ModItems.sorghum);
	   }
}