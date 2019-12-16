package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.blocks.WildPlant;
import enemeez.simplefarming.config.DimensionConfig;
import enemeez.simplefarming.config.GenConfig;
import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class WildPlantFeature extends Feature<NoFeatureConfig> {
	public WildPlantFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactory) {
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

		if (random.nextInt(GenConfig.wild_plant_chance.get()) != 0
				|| DimensionConfig.blacklist.get().contains(world.getDimension().getType().getId())
				|| !DimensionConfig.whitelist.get().contains(world.getDimension().getType().getId()))
			return false;
		int type = (int) ((Math.random() * 4) + 1);
		int rolls = (int) ((Math.random() * 3) + 1);
		for (int i = 0; i < rolls; i++) {
			if (i == 0) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (check(world, pos.north(initial).west(offset)))
					generatePlant(world, pos.north(initial).west(offset), random, type);
			}
			if (i == 1) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (check(world, pos.south(initial).east(offset)))
					generatePlant(world, pos.south(initial).east(offset), random, type);
			}
			if (i == 2) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (check(world, pos.north(initial).east(offset)))
					generatePlant(world, pos.north(initial).east(offset), random, type);
			} else {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (check(world, pos.south(initial).west(offset)))
					generatePlant(world, pos.south(initial).west(offset), random, type);
			}
		}
		return true;
	}

	public void generatePlant(IWorld world, BlockPos pos, Random random, int type) {

		world.setBlockState(pos, getPlant(type), 2);

	}

	public BlockState getPlant(int type) {
		switch (type) {
		case 1:
			return ModBlocks.cumin.getDefaultState().with(WildPlant.AGE, Integer.valueOf(3));
		case 2:
			return ModBlocks.quinoa.getDefaultState().with(WildPlant.AGE, Integer.valueOf(3));
		case 3:
			return ModBlocks.marshmallow.getDefaultState().with(WildPlant.AGE, Integer.valueOf(3));
		default:
			return ModBlocks.chicory.getDefaultState().with(WildPlant.AGE, Integer.valueOf(3));

		}
	}
}