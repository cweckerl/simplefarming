package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.block.growable.BerryBushBlock;
import enemeez.simplefarming.config.DimensionConfig;
import enemeez.simplefarming.config.GenConfig;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.util.WorldGenHelper;
import net.minecraft.block.BlockState;
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

	private BlockState getBush(int type) {
		switch (type) {
		case 1:
			return ModBlocks.blackberry_bush.getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3));
		case 2:
			return ModBlocks.blueberry_bush.getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3));
		case 3:
			return ModBlocks.raspberry_bush.getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3));
		default:
			return ModBlocks.strawberry_bush.getDefaultState().with(BerryBushBlock.AGE, Integer.valueOf(3));
		}
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos pos, NoFeatureConfig config) {
		if (random.nextInt(GenConfig.bush_chance.get()) != 0 || DimensionConfig.blacklist.get().contains(world.getDimension().getType().getId())
				|| !DimensionConfig.whitelist.get().contains(world.getDimension().getType().getId()))
			return false;
		int type = random.nextInt(4) + 1;
		for (int i = 0; i < type; i++) {
			if (i == 0) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(world, pos.north(initial).west(offset)))
					generateBush(world, pos.north(initial).west(offset), random, type);
			}
			if (i == 1) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(world, pos.south(initial).east(offset)))
					generateBush(world, pos.south(initial).east(offset), random, type);
			}
			if (i == 2) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(world, pos.north(initial).east(offset)))
					generateBush(world, pos.north(initial).east(offset), random, type);
			} else {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(world, pos.south(initial).west(offset)))
					generateBush(world, pos.south(initial).west(offset), random, type);
			}
		}
		return true;
	}

	public void generateBush(IWorld world, BlockPos pos, Random random, int type) {
		world.setBlockState(pos, getBush(type), 2);
	}

}