package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomCrop extends CropsBlock
{ 
	private Item seeds;
	private int verify;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
	
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

	         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 0);
	                return true;
	             } else {
	                return false;
	             }
	          }
	return false;
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	   return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	   return state.getBlock() == Blocks.FARMLAND;
	}
	
	public IntegerProperty getAgeProperty() {
	   return AGE;
	}
	
	public int getMaxAge() {
	   return 7;
	}
	
	protected int getAge(BlockState state) {
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
	      if (i < this.getMaxAge()) {
	         float f = getGrowthChance(this, worldIn, pos);
	         if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
	            worldIn.setBlockState(pos, this.withAge(i + 1), 2);
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
	
	protected int getBonemealAgeIncrease(World worldIn) 
	{
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
	
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
	   return (worldIn.getLightSubtracted(pos, 0) >= 8 || worldIn.func_217337_f(pos)) && super.isValidPosition(state, worldIn, pos);
	}
	
	   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		      if (entityIn instanceof RavagerEntity && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(worldIn, entityIn)) {
		         worldIn.destroyBlock(pos, true);
		      }
	
	   super.onEntityCollision(state, worldIn, pos, entityIn);
	}
	
	@OnlyIn(Dist.CLIENT)
	protected IItemProvider getSeedsItem() {
	   return seeds;
	}
	
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
	   return new ItemStack(this.getSeedsItem());
	}
	   

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
}