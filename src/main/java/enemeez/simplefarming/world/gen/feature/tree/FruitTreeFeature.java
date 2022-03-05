package enemeez.simplefarming.world.gen.feature.tree;

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

public class FruitTreeFeature extends Feature<NoneFeatureConfiguration> {
	private final static BlockState[] leavesLookup = new BlockState[] {ModBlocks.APPLE_LEAVES.get().defaultBlockState(),
			ModBlocks.APRICOT_LEAVES.get().defaultBlockState(), ModBlocks.BANANA_LEAVES.get().defaultBlockState(),
			ModBlocks.PLUM_LEAVES.get().defaultBlockState(), ModBlocks.ORANGE_LEAVES.get().defaultBlockState(),
			ModBlocks.PEAR_LEAVES.get().defaultBlockState(), ModBlocks.CHERRY_LEAVES.get().defaultBlockState(),
			ModBlocks.MANGO_LEAVES.get().defaultBlockState(), ModBlocks.OLIVE_LEAVES.get().defaultBlockState()};
	
	public FruitTreeFeature(Codec<NoneFeatureConfiguration> configFactory) {
		super(configFactory);
	}

	private static BlockState getLeaves(int type) {
		return leavesLookup[type - 1];
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		var random = context.random();
		if (random.nextInt(WorldGenChances.tree_chance.get()) != 0)
			return false;

		var level = context.level();
		var pos = context.origin();
		if (WorldGenHelper.isValidGround(level.getBlockState(pos.below()), level, pos) && level.getBlockState(pos).getMaterial().isReplaceable()) {
			int type = random.nextInt(9) + 1;
			generateTree(level, pos, random, type);
			return true;
		}
		return false;
	}

	public static void generateTree(LevelAccessor world, BlockPos pos, Random random, int verify) {
		BlockState trunk = ModBlocks.FRUIT_LOG.get().defaultBlockState();
		BlockState leaves = getLeaves(verify);

		for (int y = 0; y < 4; y++) {
			if (world.getBlockState(pos.above(y)).getMaterial().isReplaceable() || y == 0)
				world.setBlock(pos.above(y), trunk, 3);
		}

		for (int x = -1; x < 2; x++) {
			for (int z = -1; z < 2; z++) {
				if (world.getBlockState(pos.above(3).offset(x, 0, z)).getMaterial().isReplaceable())
					world.setBlock(pos.above(3).offset(x, 0, z), leaves, 3);
			}
		}

		for (int x = -1; x < 2; x++) {
			if (x != 0) {
				if (world.getBlockState(pos.above(2).offset(x, 0, 0)).getMaterial().isReplaceable())
					world.setBlock(pos.above(2).offset(x, 0, 0), leaves, 3);
			} else {
				if (world.getBlockState(pos.above(2).offset(x, 0, 1)).getMaterial().isReplaceable())
					world.setBlock(pos.above(2).offset(x, 0, 1), leaves, 3);
				if (world.getBlockState(pos.above(2).offset(x, 0, -1)).getMaterial().isReplaceable())
					world.setBlock(pos.above(2).offset(x, 0, -1), leaves, 3);
			}
		}

		if (world.getBlockState(pos.above(4)).getMaterial().isReplaceable())
			world.setBlock(pos.above(4), leaves, 3);
	}

}