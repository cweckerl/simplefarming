package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WildPlant extends BushBlock implements IGrowable 
{
		private int verify;
		public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
		public WildPlant(Block.Properties p_i49971_1_, int verify) 
		 {
		    super(p_i49971_1_);
		    this.verify=verify;
		    this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
		 }

		   @OnlyIn(Dist.CLIENT)
		   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) 
		   {//TODO
			   	 if (verify==1)
			   		  return new ItemStack(ModItems.cumin_seeds);
			   	 else
		        	  return new ItemStack(ModItems.quinoa_seeds);
		   }
		   
		   public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) 
			{
			 if (!worldIn.isRemote)
			 {
				 if (state.get(AGE)==3)
				 {
			         int random = (int)((Math.random()*4)+1);
			         spawnAsEntity(worldIn, pos, new ItemStack(getItem(worldIn, pos, state).getItem(), random));
			         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
			         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
			                return true;
			             } else {
			                return false;
			             }
			          }
			 	return false;
			}



		   @SuppressWarnings("deprecation")
		public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		      super.tick(state, worldIn, pos, random);
		      int i = state.get(AGE);
		      if (i < 3 && random.nextInt(5) == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9) {
		         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
		      }

		   }
		   

		   
		   public static void generateBush(IWorld world, BlockPos pos, Random random, int verify) 
		   {
			   if (verify==1)
				   world.setBlockState(pos, ModBlocks.cumin.getDefaultState().with(AGE, Integer.valueOf(3)), 3);
			   if (verify==2)
				   world.setBlockState(pos, ModBlocks.quinoa.getDefaultState().with(AGE, Integer.valueOf(3)), 3);
		   }
		   
		

		   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		      builder.add(AGE);
		   }

		   public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		      return state.get(AGE) < 3;
		   }

		   public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		      return true;
		   }

		   public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		      int i = Math.min(3, state.get(AGE) + 1);
		      worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
		   }
		   
		   public Block.OffsetType getOffsetType() {
			      return Block.OffsetType.XZ;
			   }
		
		   
}	


