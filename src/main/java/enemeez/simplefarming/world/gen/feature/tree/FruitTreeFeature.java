package enemeez.simplefarming.world.gen.feature.tree;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.config.DimensionConfig;
import enemeez.simplefarming.config.GenConfig;
import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FruitTreeFeature extends Feature<NoFeatureConfig> {
	public FruitTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random,
			BlockPos pos, NoFeatureConfig config) {
		if (random.nextInt(GenConfig.tree_chance.get()) != 0
				|| DimensionConfig.blacklist.get().contains(world.getDimension().getType().getId())
				|| !DimensionConfig.whitelist.get().contains(world.getDimension().getType().getId()))
			return false;

		if (world.getBlockState(pos.down()).getBlock().isIn(BlockTags.DIRT_LIKE)
				&& world.getBlockState(pos).getMaterial().isReplaceable()) {
			int type = (int) ((Math.random() * 9) + 1);
			generateTree(world, pos, random, type);
			return true;
		}
		return false;
	}

	public static void generateTree(IWorld world, BlockPos pos, Random random, int verify) {
		BlockState trunk = ModBlocks.fruit_log.getDefaultState();
		BlockState leaves = getLeaves(verify);

		world.setBlockState(pos.up(0), trunk, 3);
		for (int i = 1; i < 4; i++) {
			if (world.getBlockState(pos.up(i)).getMaterial().isReplaceable())
				world.setBlockState(pos.up(i), trunk, 3);
		}
		if (world.getBlockState(pos.up(2).north()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(2).north(), leaves, 3);
		if (world.getBlockState(pos.up(2).south()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(2).south(), leaves, 3);
		if (world.getBlockState(pos.up(2).east()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(2).east(), leaves, 3);
		if (world.getBlockState(pos.up(2).west()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(2).west(), leaves, 3);

		if (world.getBlockState(pos.up(3).north()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).north(), leaves, 3);
		if (world.getBlockState(pos.up(3).north().west()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).north().west(), leaves, 3);
		if (world.getBlockState(pos.up(3).north().east()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).north().east(), leaves, 3);
		if (world.getBlockState(pos.up(3).south()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).south(), leaves, 3);
		if (world.getBlockState(pos.up(3).south().west()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).south().west(), leaves, 3);
		if (world.getBlockState(pos.up(3).south().east()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).south().east(), leaves, 3);
		if (world.getBlockState(pos.up(3).east()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).east(), leaves, 3);
		if (world.getBlockState(pos.up(3).west()).getMaterial().isReplaceable())
			world.setBlockState(pos.up(3).west(), leaves, 3);
		if (world.getBlockState(pos.up(4)).getMaterial().isReplaceable())
			world.setBlockState(pos.up(4), leaves, 3);

	}
	
	private static BlockState getLeaves(int verify)
	{
		switch (verify) {
		case 1:
			return ModBlocks.apple_leaves.getDefaultState();
		case 2:
			return ModBlocks.apricot_leaves.getDefaultState();
		case 3:
			return ModBlocks.banana_leaves.getDefaultState();
		case 4:
			return ModBlocks.plum_leaves.getDefaultState();
		case 5:
			return ModBlocks.orange_leaves.getDefaultState();
		case 6:
			return ModBlocks.pear_leaves.getDefaultState();
		case 7:
			return ModBlocks.cherry_leaves.getDefaultState();
		case 8:
			return ModBlocks.mango_leaves.getDefaultState();
		default:
			return ModBlocks.olive_leaves.getDefaultState();
		}
	}
}