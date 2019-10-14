package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.blocks.CustomCactus;
import enemeez.simplefarming.config.DimensionConfig;
import enemeez.simplefarming.config.GenConfig;
import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
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

	public boolean check(IWorld world, BlockPos pos) {
		if (world.getBlockState(pos.down()).getBlock().isIn(BlockTags.SAND)
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
		if (random.nextInt(GenConfig.cactus_chance.get()) != 0
				|| DimensionConfig.blacklist.get().contains(world.getDimension().getType().getId())
				|| !DimensionConfig.whitelist.get().contains(world.getDimension().getType().getId()))
			return false;
		if (check(world, pos))
			generateCactus(world, pos, random);
		return true;
	}

	public static void generateCactus(IWorld world, BlockPos pos, Random random) {
		if (Math.random() < 0.5)
			world.setBlockState(pos, ModBlocks.cactus_crop.getDefaultState().with(CustomCactus.FACING, Direction.NORTH)
					.with(CustomCactus.AGE, Integer.valueOf(3)), 3);
		else
			world.setBlockState(pos, ModBlocks.cactus_crop.getDefaultState().with(CustomCactus.FACING, Direction.SOUTH)
					.with(CustomCactus.AGE, Integer.valueOf(3)), 3);
			
	}
}