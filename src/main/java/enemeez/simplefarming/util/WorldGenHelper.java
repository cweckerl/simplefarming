package enemeez.simplefarming.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class WorldGenHelper {

	public static boolean checkConditions(IWorld world, BlockPos pos) {
		if (isValidGround(world.getBlockState(pos.down()), world, pos) && world.getBlockState(pos).getMaterial().isReplaceable() && world.getBlockState(pos) != Blocks.WATER.getDefaultState()
				&& world.getBlockState(pos) != Blocks.LAVA.getDefaultState())
			return true;
		else
			return false;
	}

	public static boolean checkDryConditions(IWorld world, BlockPos pos) {
		if (world.getBlockState(pos.down()).getBlock().isIn(BlockTags.SAND) && world.getBlockState(pos).getMaterial().isReplaceable() && world.getBlockState(pos) != Blocks.WATER.getDefaultState()
				&& world.getBlockState(pos) != Blocks.LAVA.getDefaultState())
			return true;
		else
			return false;
	}

	public static boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL;
	}

}
