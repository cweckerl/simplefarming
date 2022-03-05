package enemeez.simplefarming.world.gen;

import com.mojang.serialization.Codec;
import enemeez.simplefarming.config.WorldGenChances;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.util.WorldGenHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class BerryBushFeature extends Feature<NoneFeatureConfiguration> {
	private final BlockState[] bushLookup = new BlockState[] { ModBlocks.BLACKBERRY_BUSH.get().withMaxAge(),
			ModBlocks.BLUEBERRY_BUSH.get().withMaxAge(), ModBlocks.RASPBERRY_BUSH.get().withMaxAge(),
			ModBlocks.STRAWBERRY_BUSH.get().withMaxAge() };

	public BerryBushFeature(Codec<NoneFeatureConfiguration> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		var random = context.random();
		var level = context.level();
		var pos = context.origin();

		if (random.nextInt(WorldGenChances.bush_chance.get()) != 0)
			return false;
		int type = random.nextInt(4) + 1;
		for (int i = 0; i < type; i++) {
			if (i == 0) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(level, pos.north(initial).west(offset)))
					generateBush(level, pos.north(initial).west(offset), random, type);
			}
			if (i == 1) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(level, pos.south(initial).east(offset)))
					generateBush(level, pos.south(initial).east(offset), random, type);
			}
			if (i == 2) {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(level, pos.north(initial).east(offset)))
					generateBush(level, pos.north(initial).east(offset), random, type);
			} else {
				int initial = random.nextInt(2) + 1;
				int offset = random.nextInt(2) + 1;
				if (WorldGenHelper.checkConditions(level, pos.south(initial).west(offset)))
					generateBush(level, pos.south(initial).west(offset), random, type);
			}
		}
		return true;
	}

	private BlockState getBush(int type) {
		return bushLookup[type - 1];
	}

	public void generateBush(LevelAccessor world, BlockPos pos, Random random, int type) {
		world.setBlock(pos, getBush(type), 2);
	}

}