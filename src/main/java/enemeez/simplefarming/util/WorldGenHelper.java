package enemeez.simplefarming.util;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class WorldGenHelper {

	public static boolean checkConditions(LevelAccessor world, BlockPos pos) {
		if (isValidGround(world.getBlockState(pos.below()), world, pos) && world.getBlockState(pos).getMaterial().isReplaceable() && world.getBlockState(pos) != Blocks.WATER.defaultBlockState()
				&& world.getBlockState(pos) != Blocks.LAVA.defaultBlockState())
			return true;
		else
			return false;
	}

	public static boolean checkDryConditions(LevelAccessor world, BlockPos pos) {
		if (world.getBlockState(pos.below()).is(BlockTags.SAND) && world.getBlockState(pos).getMaterial().isReplaceable() && world.getBlockState(pos) != Blocks.WATER.defaultBlockState()
				&& world.getBlockState(pos) != Blocks.LAVA.defaultBlockState())
			return true;
		else
			return false;
	}

	public static boolean isValidGround(BlockState state, BlockGetter worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL;
	}

}
