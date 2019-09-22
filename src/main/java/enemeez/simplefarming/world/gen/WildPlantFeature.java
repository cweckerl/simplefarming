package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.blocks.WildPlant;
import enemeez.simplefarming.config.GenConfig;
import enemeez.simplefarming.init.ModBlocks;
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

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random,
			BlockPos pos, NoFeatureConfig config) {

		if (random.nextInt(GenConfig.wild_plant_chance.get()) != 0)
			return false;

		int type = (int) ((Math.random() * 2) + 1);

		int place0 = (int) ((Math.random() * 4) + 1);
		int place1 = (int) ((Math.random() * 4) + 1);
		int place2 = (int) ((Math.random() * 4) + 1);

		if (world.getBlockState(pos.north(place0).down()).getBlock().isIn(BlockTags.DIRT_LIKE)
				&& world.getBlockState(pos.north(place0)).getMaterial().isReplaceable())
			generatePlant(world, pos.north(place0), random, type);
		if (world.getBlockState(pos.south(place1).down()).getBlock().isIn(BlockTags.DIRT_LIKE)
				&& world.getBlockState(pos.south(place1)).getMaterial().isReplaceable())
			generatePlant(world, pos.south(place1), random, type);
		if (world.getBlockState(pos.east(place2).down()).getBlock().isIn(BlockTags.DIRT_LIKE)
				&& world.getBlockState(pos.east(place2)).getMaterial().isReplaceable())
			generatePlant(world, pos.east(place2), random, type);

		return true;

	}
	
	public static void generatePlant(IWorld world, BlockPos pos, Random random, int type) {
		if (type == 1)
			world.setBlockState(pos, ModBlocks.cumin.getDefaultState().with(WildPlant.AGE, Integer.valueOf(3)), 3);
		if (type == 2)
			world.setBlockState(pos, ModBlocks.quinoa.getDefaultState().with(WildPlant.AGE, Integer.valueOf(3)), 3);
	}
}