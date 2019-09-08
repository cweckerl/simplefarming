package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

	public class CustomBush extends BushBlock implements IGrowable 
	{
		private String name;
		public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
		protected static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 2.0D, 1.0D, 15.0D, 16.0D, 15.0D);

		public CustomBush(Block.Properties p_i49971_1_, String name) 
		 {
		    super(p_i49971_1_);
		    this.name=name;
		    this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
		 }
		
		   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) 
		   {
			   if (name.equals("blackberries"))
			   		return new ItemStack(ModItems.blackberry_bush);
			   if (name.equals("blueberries"))
			   		return new ItemStack(ModItems.blueberry_bush);
			   if (name.equals("raspberries"))
			   		return new ItemStack(ModItems.raspberry_bush);
			   else
			   		return new ItemStack(ModItems.strawberry_bush);
		   }
		   

		   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
		   {
			   return SHAPE;
		   }

		   @SuppressWarnings("deprecation")
		public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		      super.tick(state, worldIn, pos, random);
		      int i = state.get(AGE);
		      if (i < 3 && random.nextInt(5) == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9) {
		         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
		      }

		   }
		   
		   public boolean isMaxAge(BlockState state) 
		   	   {
			      return state.get(AGE)==3;
			   }
		   

		   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) 
		   {
		      if (entityIn instanceof LivingEntity) 
		      {
		         entityIn.setMotionMultiplier(state, new Vec3d((double)0.8F, 0.75D, (double)0.8F));
		       }
		   }
		   
		   public static void generateBush(IWorld world, BlockPos pos, Random random, int type) 
		   {
			   if (type==1)
				   world.setBlockState(pos, ModBlocks.blackberry_bush.getDefaultState().with(AGE, Integer.valueOf(3)), 3);
			   if (type==2)
				   world.setBlockState(pos, ModBlocks.blueberry_bush.getDefaultState().with(AGE, Integer.valueOf(3)), 3);
			   if (type==3)
				   world.setBlockState(pos, ModBlocks.raspberry_bush.getDefaultState().with(AGE, Integer.valueOf(3)), 3);
			   if (type==4)
				   world.setBlockState(pos, ModBlocks.strawberry_bush.getDefaultState().with(AGE, Integer.valueOf(3)), 3);
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