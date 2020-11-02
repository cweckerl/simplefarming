package enemeez.simplefarming.world.gen;

import java.util.Random;

import com.mojang.serialization.Codec;

import enemeez.simplefarming.block.growable.PlantBlock;
import enemeez.simplefarming.config.GenConfig;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.util.WorldGenHelper;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class WildPlantFeature extends Feature<NoFeatureConfig> {
	public WildPlantFeature(Codec<NoFeatureConfig> configFactory) {
		super(configFactory);
	}

	private final BlockState[] plantLookup = new BlockState[] {
			ModBlocks.cumin.getDefaultState().with(PlantBlock.AGE, Integer.valueOf(3)),
			ModBlocks.quinoa.getDefaultState().with(PlantBlock.AGE, Integer.valueOf(3)),
			ModBlocks.marshmallow.getDefaultState().with(PlantBlock.AGE, Integer.valueOf(3)),
			ModBlocks.chicory.getDefaultState().with(PlantBlock.AGE, Integer.valueOf(3)) };

	public BlockState getPlant(int type) {
		return plantLookup[type - 1];
	}

	@Override
	public boolean generate(ISeedReader world, ChunkGenerator p_241855_2_, Random random, BlockPos pos,
			NoFeatureConfig config) {
		if (random.nextInt(GenConfig.wild_plant_chance.get()) != 0)
			return false;

		int type = random.nextInt(4) + 1;
		int rolls = random.nextInt(3) + 1;
		for (int i = 0; i < rolls; i++) {
			if (i == 0) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (WorldGenHelper.checkConditions(world, pos.north(initial).west(offset)))
					generatePlant(world, pos.north(initial).west(offset), random, type);
			}
			if (i == 1) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (WorldGenHelper.checkConditions(world, pos.south(initial).east(offset)))
					generatePlant(world, pos.south(initial).east(offset), random, type);
			}
			if (i == 2) {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (WorldGenHelper.checkConditions(world, pos.north(initial).east(offset)))
					generatePlant(world, pos.north(initial).east(offset), random, type);
			} else {
				int initial = (int) ((Math.random() * 2) + 1);
				int offset = (int) ((Math.random() * 2) + 1);
				if (WorldGenHelper.checkConditions(world, pos.south(initial).west(offset)))
					generatePlant(world, pos.south(initial).west(offset), random, type);
			}
		}
		return true;
	}

	public void generatePlant(IWorld world, BlockPos pos, Random random, int type) {
		world.setBlockState(pos, getPlant(type), 2);
	}
}