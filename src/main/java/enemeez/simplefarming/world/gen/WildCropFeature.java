package enemeez.simplefarming.world.gen;

import com.mojang.serialization.Codec;
import enemeez.simplefarming.config.WorldGenChances;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.util.WorldGenHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class WildCropFeature extends Feature<NoneFeatureConfiguration> {
	public WildCropFeature(Codec<NoneFeatureConfiguration> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		var random = context.random();
		if (random.nextInt(WorldGenChances.wild_crop_chance.get()) != 0)
			return false;

		var level = context.level();
		var pos = context.origin();
		int rolls = random.nextInt(5) + 1;
		for (int i = 0; i < rolls; i++) {
			if (i == 0) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(level, pos.north(initial).west(offset)))
					generatePlant(level, pos.north(initial).west(offset), random);
			}
			if (i == 1) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(level, pos.south(initial).east(offset)))
					generatePlant(level, pos.south(initial).east(offset), random);
			}
			if (i == 2) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(level, pos.north(initial).east(offset)))
					generatePlant(level, pos.north(initial).east(offset), random);
			} else {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(level, pos.south(initial).west(offset)))
					generatePlant(level, pos.south(initial).west(offset), random);
			}
		}
		return true;
	}

	public static void generatePlant(LevelAccessor world, BlockPos pos, Random random) {
		world.setBlock(pos, ModBlocks.WILD_CROP.get().defaultBlockState(), 2);
	}

}