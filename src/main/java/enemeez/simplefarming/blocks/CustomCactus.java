package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomCactus extends BushBlock implements IGrowable 
{
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
	private static final VoxelShape BOX = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public CustomCactus(Block.Properties p_i49971_1_) 
	 {
	    super(p_i49971_1_);
	    this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	 }

	   @OnlyIn(Dist.CLIENT)
	   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) 
	   {
		   	return new ItemStack(ModItems.cactus_crop);
	   }

 
	   @SuppressWarnings("deprecation")
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
	      super.tick(state, worldIn, pos, random);
	      int i = state.get(AGE);
	      if (i < 3 && random.nextInt(5) == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9) {
	         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
	      }

	   }
	   
	   public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	   {
		      return BOX;
		  }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	   {
	      return BOX;
	   }

	   public boolean isSolid(BlockState state) 
	   {
	      return false;
	   }
	   
	   @Override
	   public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) 
	   {
	      return net.minecraftforge.common.PlantType.Desert;
	   }
		   
		   
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) 
	{
		   return worldIn.getBlockState(pos.down()).getBlock().isIn(BlockTags.SAND);
		}
	   
	   public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) 
		{
		   if (!FeatureConfig.right_click_harvest.get()) return false;
			 if (!worldIn.isRemote)
			 {
				 if (state.get(AGE)==3)
				 {
			         int random = (int)((Math.random()*4)+1);
				     spawnAsEntity(worldIn, pos, new ItemStack(ModItems.cactus_fruit, random));
			         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
			         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
			         return true;
	             } else {
	                return false;
	             }
	          }
		   
		 return false;
     }	

	   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) 
	   		{
		      entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
	   		}
	   
	   public static void generateCactus(IWorld world, BlockPos pos, Random random) 
	   {
			  world.setBlockState(pos, ModBlocks.cactus_crop.getDefaultState().with(AGE, Integer.valueOf(3)), 3);
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
	}	