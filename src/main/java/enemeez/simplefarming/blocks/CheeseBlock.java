package enemeez.simplefarming.blocks;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CheeseBlock extends Block {
	   public static final IntegerProperty BITES = BlockStateProperties.BITES_0_6;
	   protected static final VoxelShape[] field_196402_b = new VoxelShape[]{Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)};

	   public CheeseBlock(Block.Properties properties) 
	   {
	      super(properties);
	      this.setDefaultState(this.stateContainer.getBaseState().with(BITES, Integer.valueOf(0)));
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return field_196402_b[state.get(BITES)];
	   }

	   public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	      if (!worldIn.isRemote) {
	         return this.dropCheese(worldIn, pos, state, player);
	      } else {
	         ItemStack itemstack = player.getHeldItem(handIn);
	         return this.dropCheese(worldIn, pos, state, player) || itemstack.isEmpty();
	      }
	   }

	   private boolean dropCheese(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) 
	   {
	         //player.addStat(Stats.EAT_CAKE_SLICE);
	         //player.getFoodStats().addStats(2, 0.1F);
	    	  spawnAsEntity(worldIn, pos, new ItemStack(ModItems.cheese_slice, 1));
	         int i = state.get(BITES);
	         if (i < 6) {
	            worldIn.setBlockState(pos, state.with(BITES, Integer.valueOf(i + 1)), 3);
	         } else {
	            worldIn.removeBlock(pos, false);
	         }

	         return true;
	      }

	   @SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
	      return facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	   }

	   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
	      return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
	   }

	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(BITES);
	   }


	   public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
	      return (7 - blockState.get(BITES)) * 2;
	   }

	   /**
	    * @deprecated call via {@link IBlockState#hasComparatorInputOverride()} whenever possible. Implementing/overriding
	    * is fine.
	    */
	   public boolean hasComparatorInputOverride(BlockState state) {
	      return true;
	   }

	   public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
	      return false;
	   }
	}