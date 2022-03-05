package enemeez.simplefarming.world.gen;

import com.mojang.serialization.Codec;
import enemeez.simplefarming.block.growable.OpuntiaBlock;
import enemeez.simplefarming.config.WorldGenChances;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.util.WorldGenHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class CactusCropFeature extends Feature<NoneFeatureConfiguration> {
	public CactusCropFeature(Codec<NoneFeatureConfiguration> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		var random = context.random();
		if (random.nextInt(WorldGenChances.cactus_chance.get()) != 0)
			return false;

		var level = context.level();
		var pos = context.origin();
		if (WorldGenHelper.checkDryConditions(level, pos))
			generateCactus(level, pos, random);
		return true;
	}

	public static void generateCactus(LevelAccessor world, BlockPos pos, Random rand) {
		if (rand.nextFloat() < 0.5)
			world.setBlock(pos, ModBlocks.CACTUS_CROP
                .get().defaultBlockState().setValue(OpuntiaBlock.AGE, Integer.valueOf(3)).setValue(OpuntiaBlock.FACING, Direction.WEST), 2);
		else
			world.setBlock(pos, ModBlocks.CACTUS_CROP
                .get().defaultBlockState().setValue(OpuntiaBlock.AGE, Integer.valueOf(3)).setValue(OpuntiaBlock.FACING, Direction.NORTH), 2);
	}
}