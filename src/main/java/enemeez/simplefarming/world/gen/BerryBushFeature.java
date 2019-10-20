package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.blocks.CustomBush;
import enemeez.simplefarming.config.DimensionConfig;
import enemeez.simplefarming.config.GenConfig;
import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class BerryBushFeature extends Feature<NoFeatureConfig> {
	public BerryBushFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactory) {
		super(configFactory);
	}

	public boolean check(IWorld world, BlockPos pos) {
		if (world.getBlockState(pos.down()).getBlock().isIn(BlockTags.DIRT_LIKE)
				&& world.getBlockState(pos).getMaterial().isReplaceable()
				&& world.getBlockState(pos) != Blocks.WATER.getDefaultState()
				&& world.getBlockState(pos) != Blocks.LAVA.getDefaultState())
			return true;
		else
			return false;
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random,
			BlockPos pos, NoFeatureConfig config) {

		if (random.nextInt(GenConfig.bush_chance.get()) != 0
				|| DimensionConfig.blacklist.get().contains(world.getDimension().getType().getId())
						|| !DimensionConfig.whitelist.get().contains(world.getDimension().getType().getId()))
			return false;
		int type = (int) ((Math.random() * 4) + 1);
		for (int i = 0; i < type; i++) {
			if (i == 0) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (check(world, pos.north(initial).west(offset)))
					generateBush(world, pos.north(initial).west(offset), random, type);
			}
			if (i == 1) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (check(world, pos.south(initial).east(offset)))
					generateBush(world, pos.south(initial).east(offset), random, type);
			}
			if (i == 2) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (check(world, pos.north(initial).east(offset)))
					generateBush(world, pos.north(initial).east(offset), random, type);
			} else {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (check(world, pos.south(initial).west(offset)))
					generateBush(world, pos.south(initial).west(offset), random, type);
			}
		}
		return true;
	}

	public void generateBush(IWorld world, BlockPos pos, Random random, int type) {
		if (type == 1)
			world.setBlockState(pos,
					ModBlocks.blackberry_bush.getDefaultState().with(CustomBush.AGE, Integer.valueOf(3)), 2);
		if (type == 2)
			world.setBlockState(pos,
					ModBlocks.blueberry_bush.getDefaultState().with(CustomBush.AGE, Integer.valueOf(3)), 2);
		if (type == 3)
			world.setBlockState(pos,
					ModBlocks.raspberry_bush.getDefaultState().with(CustomBush.AGE, Integer.valueOf(3)), 2);
		if (type == 4)
			world.setBlockState(pos,
					ModBlocks.strawberry_bush.getDefaultState().with(CustomBush.AGE, Integer.valueOf(3)), 2);
	}
}