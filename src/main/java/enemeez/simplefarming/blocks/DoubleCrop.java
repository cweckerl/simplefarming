package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
	   

	   public IntegerProperty getAgeProperty() {
	      return AGE;
	   }

	   public int getMaxAge() {
	      return 5; 
	   }

	   public int getAge(BlockState state) {
	      return state.get(this.getAgeProperty());
	   }

	   public BlockState withAge(int age) {
	      return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
	   }

	   public boolean isMaxAge(BlockState state) {
	      return state.get(this.getAgeProperty()) >= this.getMaxAge();
	   }
	   
	   


	   public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
	      super.tick(state, worldIn, pos, random);
	      if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
	      if (worldIn.getLightSubtracted(pos, 0) >= 9) {
	         int i = this.getAge(state);
	         if (i < 6) { //4
	            float f = getGrowthChance(this, worldIn, pos);
	            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) 
	            {
	            	if (i==5)//3
	            	{
	            		worldIn.setBlockState(pos, this.withAge(6), 3); //4
	            		if (worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState())
	            		worldIn.setBlockState(pos.up(), this.withAge(7), 3); //5
	            		
	            	}
	            	else
	            		worldIn.setBlockState(pos, this.withAge(i + 1), 3);
	               net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
	            }
	         }
	      }

	   }

	   public void grow(World worldIn, BlockPos pos, BlockState state) {
	      int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
	      int j = this.getMaxAge();
	      if (i > j) {
	         i = j;
	      }

	      worldIn.setBlockState(pos, this.withAge(i), 2);
	   }

	   protected int getBonemealAgeIncrease(World worldIn) {
	      return MathHelper.nextInt(worldIn.rand, 2, 5);
	   }

	   protected static float getGrowthChance(Block blockIn, IBlockReader worldIn, BlockPos pos) {
	      float f = 1.0F;
	      BlockPos blockpos = pos.down();

	      for(int i = -1; i <= 1; ++i) {
	         for(int j = -1; j <= 1; ++j) {
	            float f1 = 0.0F;
	            BlockState blockstate = worldIn.getBlockState(blockpos.add(i, 0, j));
	            if (blockstate.canSustainPlant(worldIn, blockpos.add(i, 0, j), net.minecraft.util.Direction.UP, (net.minecraftforge.common.IPlantable)blockIn)) {
	               f1 = 1.0F;
	               if (blockstate.isFertile(worldIn, blockpos.add(i, 0, j))) {
	                  f1 = 3.0F;
	               }
	            }

	            if (i != 0 || j != 0) {
	               f1 /= 4.0F;
	            }

	            f += f1;
	         }
	      }

	      BlockPos blockpos1 = pos.north();
	      BlockPos blockpos2 = pos.south();
	      BlockPos blockpos3 = pos.west();
	      BlockPos blockpos4 = pos.east();
	      boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock() || blockIn == worldIn.getBlockState(blockpos4).getBlock();
	      boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock() || blockIn == worldIn.getBlockState(blockpos2).getBlock();
	      if (flag && flag1) {
	         f /= 2.0F;
	      } else {
	         boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();
	         if (flag2) {
	            f /= 2.0F;
	         }
	      }

	      return f;
	   }
	   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) 
	   {
			   
		   if (this.getAge(state) == 6 && worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState()) //4
		   return false;
		   else
		   return (worldIn.getLightSubtracted(pos, 0) >= 8 || worldIn.isSkyLightMax(pos)) && checker(state, worldIn, pos);
		}
	   

	   public boolean checker(BlockState state, IWorldReader worldIn, BlockPos pos)
	   {
		   Block block = worldIn.getBlockState(pos.down()).getBlock();
		   
		   if (block == Blocks.FARMLAND)
			   return true;
		   if (block == this && !worldIn.getBlockState(pos.down(3)).getBlock().equals(Blocks.FARMLAND) && worldIn.getBlockState(pos.down()) == this.withAge(6)) //4
		         return true; 
		   else return false;
	   }

	   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
	      if (entityIn instanceof RavagerEntity && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(worldIn, entityIn)) {
	         worldIn.destroyBlock(pos, true);
	      }

	      super.onEntityCollision(state, worldIn, pos, entityIn);
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

	   /**
	    * Whether this IGrowable can grow
	    */
	   public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
	      return !this.isMaxAge(state);
	   }

	   public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
	      return true;
	   }

	   public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
	      this.grow(worldIn, pos, state);
	   }

	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(AGE);
	   }

	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		 BlockState state = world.getBlockState(pos);
	      if (state.getBlock() != this) return getDefaultState();
	      return state;
	}
	
	public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.CUTOUT;
	   }
	}