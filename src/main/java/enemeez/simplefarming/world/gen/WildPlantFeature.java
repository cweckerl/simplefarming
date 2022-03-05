package enemeez.simplefarming.world.gen;

import com.mojang.serialization.Codec;
import enemeez.simplefarming.block.growable.PlantBlock;
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

public class WildPlantFeature extends Feature<NoneFeatureConfiguration> {
	public WildPlantFeature(Codec<NoneFeatureConfiguration> configFactory) {
		super(configFactory);
	}

	private final BlockState[] plantLookup = new BlockState[] {
			ModBlocks.CUMIN.get().defaultBlockState().setValue(PlantBlock.AGE, Integer.valueOf(3)),
			ModBlocks.QUINOA.get().defaultBlockState().setValue(PlantBlock.AGE, Integer.valueOf(3)),
			ModBlocks.MARSHMALLOW.get().defaultBlockState().setValue(PlantBlock.AGE, Integer.valueOf(3)),
			ModBlocks.CHICORY.get().defaultBlockState().setValue(PlantBlock.AGE, Integer.valueOf(3)) };

	public BlockState getPlant(int type) {
		return plantLookup[type - 1];
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		var random = context.random();
		if (random.nextInt(WorldGenChances.wild_plant_chance.get()) != 0)
			return false;

		var level = context.level();
		var pos = context.origin();

		int type = random.nextInt(4) + 1;
		int rolls = random.nextInt(3) + 1;
		for (int i = 0; i < rolls; i++) {
			if (i == 0) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (WorldGenHelper.checkConditions(level, pos.north(initial).west(offset)))
					generatePlant(level, pos.north(initial).west(offset), random, type);
			}
			if (i == 1) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (WorldGenHelper.checkConditions(level, pos.south(initial).east(offset)))
					generatePlant(level, pos.south(initial).east(offset), random, type);
			}
			if (i == 2) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (WorldGenHelper.checkConditions(level, pos.north(initial).east(offset)))
					generatePlant(level, pos.north(initial).east(offset), random, type);
			} else {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (WorldGenHelper.checkConditions(level, pos.south(initial).west(offset)))
					generatePlant(level, pos.south(initial).west(offset), random, type);
			}
		}
		return true;
	}

	public void generatePlant(LevelAccessor world, BlockPos pos, Random random, int type) {
		world.setBlock(pos, getPlant(type), 2);
	}
}