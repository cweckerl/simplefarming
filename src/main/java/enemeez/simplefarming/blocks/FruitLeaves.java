package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FruitLeaves extends BushBlock implements IGrowable 
{
	private int verify;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;

	public FruitLeaves(Block.Properties p_i49971_1_, int verify) 
	 {
	    super(p_i49971_1_);
	    this.verify=verify;
	    this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	 }

	   @OnlyIn(Dist.CLIENT)
	   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) 
	   {
		   if (verify==1)
			   return new ItemStack(Items.APPLE);
		   if (verify==2)
		       return new ItemStack(ModItems.apricot);
		   if (verify==3)
		       return new ItemStack(ModItems.banana);
		   if (verify==4)
		       return new ItemStack(ModItems.plum);
		   if (verify==5)
		       return new ItemStack(ModItems.orange);
		   if (verify==6)
			   return new ItemStack(ModItems.pear);
		   if (verify==7)
			   return new ItemStack(ModItems.cherries);
		   else
			   return new ItemStack(ModItems.mango);
	   }


	   @SuppressWarnings("deprecation")
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
	      super.tick(state, worldIn, pos, random);
	      int i = state.get(AGE);
	      if (i < 7 && random.nextInt(5) == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9) {
	         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
	      }

	   }
	   
	   @OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	      if (worldIn.isRainingAt(pos.up())) {
	         if (rand.nextInt(15) == 1) {
	            BlockPos blockpos = pos.down();
	            BlockState blockstate = worldIn.getBlockState(blockpos);
	            if (!blockstate.isSolid() || !Block.hasSolidSide(blockstate, worldIn, blockpos, Direction.UP)) {
	               double d0 = (double)((float)pos.getX() + rand.nextFloat());
	               double d1 = (double)pos.getY() - 0.05D;
	               double d2 = (double)((float)pos.getZ() + rand.nextFloat());
	               worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	            }
	         }
	      }
	   }
	   
	   public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) 
	   {
		   if (!FeatureConfig.right_click_harvest.get()) return false;
			   if (!worldIn.isRemote)
				 {
					 if (state.get(AGE) == 7) 
					 {
						 if (verify==1)
							 spawnAsEntity(worldIn, pos, new ItemStack(Items.APPLE));
						   if (verify==2)
							   spawnAsEntity(worldIn, pos, new ItemStack(ModItems.apricot));
						   if (verify==3)
							   spawnAsEntity(worldIn, pos, new ItemStack(ModItems.banana));
						   if (verify==4)
							   spawnAsEntity(worldIn, pos, new ItemStack(ModItems.plum));
						   if (verify==5)
							   spawnAsEntity(worldIn, pos, new ItemStack(ModItems.orange));
						   if (verify==6)
							   spawnAsEntity(worldIn, pos, new ItemStack(ModItems.pear));
						   if (verify==7)
							   spawnAsEntity(worldIn, pos, new ItemStack(ModItems.cherries));
						   if (verify==8)
							   spawnAsEntity(worldIn, pos, new ItemStack(ModItems.mango));
						 worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_LILY_PAD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
						 worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
		                return true;
		             } 
				 else 
				 {
	                return false;
	             }
					 
				 }
		   
		   return false;
	}

	   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) 
	   {
	      if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX) 
	      {
	         entityIn.setMotionMultiplier(state, new Vec3d((double)0.8F, 0.75D, (double)0.8F));
	       }
	   }
	   
	   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		      Block block = state.getBlock();
		      return block == Blocks.AIR || block == ModBlocks.fruit_log;
		   }
	   
	   public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		   
		      BlockPos down = pos.down();
		      BlockPos up = pos.up();
		      BlockPos north = pos.north();
		      BlockPos south = pos.south();
		      BlockPos east = pos.east();
		      BlockPos west = pos.west();
		      
		      BlockPos southeast = pos.south().east();
		      BlockPos southwest = pos.south().west();
		      
		      BlockPos northeast = pos.north().east();
		      BlockPos northwest = pos.north().west();
		      
		      if (world.getBlockState(down).equals(ModBlocks.fruit_log.getDefaultState())
		    		  || world.getBlockState(up).equals(ModBlocks.fruit_log.getDefaultState())
    				  || world.getBlockState(north).equals(ModBlocks.fruit_log.getDefaultState())
					  || world.getBlockState(south).equals(ModBlocks.fruit_log.getDefaultState())
					  || world.getBlockState(east).equals(ModBlocks.fruit_log.getDefaultState())
					  || world.getBlockState(west).equals(ModBlocks.fruit_log.getDefaultState())
					  || world.getBlockState(southeast).equals(ModBlocks.fruit_log.getDefaultState())
					  || world.getBlockState(southwest).equals(ModBlocks.fruit_log.getDefaultState())
					  || world.getBlockState(northeast).equals(ModBlocks.fruit_log.getDefaultState())
					  || world.getBlockState(northwest).equals(ModBlocks.fruit_log.getDefaultState()))
		    																		
					return true;
					
		      return false;
		   }


	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(AGE);
	   }

	   public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
	      return state.get(AGE) < 7;
	   }

	   public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
	      return true;
	   }

	   public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) 
	   {
	      int i = Math.min(7, state.get(AGE) + 1);
	      worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	   }

	  
	   
	}	