package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

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
import net.minecraftforge.common.util.Constants;

public class BerryBushFeature extends Feature<NoFeatureConfig>
{
	private final BlockState[] bushLookup = new BlockState[] {ModBlocks.blackberry_bush.withMaxAge(), ModBlocks.blueberry_bush.withMaxAge(), ModBlocks.raspberry_bush.withMaxAge(), ModBlocks.strawberry_bush.withMaxAge()};

	public BerryBushFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactory) {
		super(configFactory);
	}

	private BlockState getBush(int type) {
		return bushLookup[type - 1];
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos pos, NoFeatureConfig config) {
		if (random.nextInt(GenConfig.bush_chance.get()) != 0 || DimensionConfig.blacklist.get().contains(world.getDimension().getType().getId())
				|| !DimensionConfig.whitelist.get().contains(world.getDimension().getType().getId()))
			return false;

		int type = random.nextInt(bushLookup.length) + 1;
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
		world.setBlockState(pos, getBush(type), Constants.BlockFlags.BLOCK_UPDATE);
	}

}