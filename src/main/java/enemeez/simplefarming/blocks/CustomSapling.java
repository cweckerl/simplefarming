package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class CustomSapling extends BushBlock implements IGrowable 
{
	   public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	   protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	   private int verify;


	   public CustomSapling(Block.Properties properties, int verify) 
	   {
	      super(properties);
	      this.verify=verify;
	      this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, Integer.valueOf(0)));
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	   {
	      return SHAPE;
	   }

	   @SuppressWarnings("deprecation")
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) 
	   {
	      super.tick(state, worldIn, pos, random);
	      if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
	      if (worldIn.getLight(pos.up()) >= 9 && random.nextInt(7) == 0) {
	         this.grow(worldIn, pos, state, random);
	      }

	   }

	   public void grow(IWorld worldIn, BlockPos pos, BlockState state, Random rand)
	   {
	      if (state.get(STAGE) == 0) {
	         worldIn.setBlockState(pos, state.cycle(STAGE), 4);
	      } else {
	         if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) return;
	         generateTree(worldIn, pos, rand, verify);
	      }

	   }

	   public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) 
	   {
	      return true;
	   }

	   public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) 
	   {
	      return (double)worldIn.rand.nextFloat() < 0.45D;
	   }

	   public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) 
	   {
	      this.grow(worldIn, pos, state, rand);
	   }

	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) 
	   {
	      builder.add(STAGE);
	   }
	   

	   public static void generateTree(IWorld world, BlockPos pos, Random random, int verify) 
	   {
			BlockState trunk = ModBlocks.fruit_log.getDefaultState();
			BlockState leaves = null;
			
			if (verify == 1)
				leaves = ModBlocks.apple_leaves.getDefaultState();
			if (verify == 2)
				leaves = ModBlocks.apricot_leaves.getDefaultState();
			if (verify == 3)
				leaves = ModBlocks.banana_leaves.getDefaultState();
			if (verify == 4)
				leaves = ModBlocks.plum_leaves.getDefaultState();
			if (verify == 5)
				leaves = ModBlocks.orange_leaves.getDefaultState();
			if (verify == 6)
				leaves = ModBlocks.pear_leaves.getDefaultState();
			if (verify == 7)
				leaves = ModBlocks.cherry_leaves.getDefaultState();
			if (verify == 8)
				leaves = ModBlocks.mango_leaves.getDefaultState();
			
			world.setBlockState(pos.up(0), trunk, 3);
			for (int i=1; i<4; i++)
			{
				if(world.getBlockState(pos.up(i)).getMaterial().isReplaceable())
				world.setBlockState(pos.up(i), trunk, 3);
			}
			
			if(world.getBlockState(pos.up(2).north()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(2).north(), leaves, 3);
			if(world.getBlockState(pos.up(2).south()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(2).south(), leaves, 3);
			if(world.getBlockState(pos.up(2).east()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(2).east(), leaves, 3);
			if(world.getBlockState(pos.up(2).west()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(2).west(), leaves, 3);
			
			if(world.getBlockState(pos.up(3).north()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).north(), leaves, 3);
			if( world.getBlockState(pos.up(3).north().west()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).north().west(), leaves, 3);
			if(world.getBlockState(pos.up(3).north().east()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).north().east(), leaves, 3);
			if(world.getBlockState(pos.up(3).south()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).south(), leaves, 3);
			if(world.getBlockState(pos.up(3).south().west()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).south().west(), leaves, 3);
			if(world.getBlockState(pos.up(3).south().east()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).south().east(), leaves, 3);
			if(world.getBlockState(pos.up(3).east()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).east(), leaves, 3);
			if(world.getBlockState(pos.up(3).west()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).west(), leaves, 3);
			if(world.getBlockState(pos.up(4)).getMaterial().isReplaceable())
			world.setBlockState(pos.up(4), leaves, 3);
			
			
	   }
}