package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.block.growable.OpuntiaBlock;
import enemeez.simplefarming.config.DimensionConfig;
import enemeez.simplefarming.config.GenConfig;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.util.WorldGenHelper;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class CactusCropFeature extends Feature<NoFeatureConfig> {
	public CactusCropFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random,
			BlockPos pos, NoFeatureConfig config) {
		if (random.nextInt(GenConfig.cactus_chance.get()) != 0
				|| DimensionConfig.blacklist.get().contains(world.getDimension().getType().getId())
				|| !DimensionConfig.whitelist.get().contains(world.getDimension().getType().getId()))
			return false;

		if (WorldGenHelper.checkDryConditions(world, pos))
			generateCactus(world, pos, random);
		return true;
	}

	public static void generateCactus(IWorld world, BlockPos pos, Random rand) {
		if (rand.nextFloat() < 0.5)
			world.setBlockState(pos, ModBlocks.cactus_crop.getDefaultState().with(OpuntiaBlock.AGE, Integer.valueOf(3))
					.with(OpuntiaBlock.FACING, Direction.WEST), 2);
		else
			world.setBlockState(pos, ModBlocks.cactus_crop.getDefaultState().with(OpuntiaBlock.AGE, Integer.valueOf(3))
					.with(OpuntiaBlock.FACING, Direction.NORTH), 2);
	}
}