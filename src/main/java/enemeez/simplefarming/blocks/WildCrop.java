package enemeez.simplefarming.blocks;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class WildCrop extends BushBlock 
{
	   protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	   public WildCrop(Block.Properties properties) 
	   {
	      super(properties);
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return SHAPE;
	   }

	   public Block.OffsetType getOffsetType() {
	      return Block.OffsetType.XZ;
	   }
	   
	   
	   public static void generateBush(IWorld world, BlockPos pos, Random random) 
	   {
			   world.setBlockState(pos, ModBlocks.wild_crop.getDefaultState(), 3);
	   }
	   
	}