package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.blocks.CustomSapling;
import enemeez.simplefarming.config.GenConfig;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FruitTreeFeature extends Feature<NoFeatureConfig> 
{
	public FruitTreeFeature(Function<Dynamic<?>,? extends NoFeatureConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos pos, NoFeatureConfig config) 
	{
		if (random.nextInt(GenConfig.tree_chance.get()) != 0) {
			return false;
		}
		if(world.getBlockState(pos.down()).getBlock().isIn(BlockTags.DIRT_LIKE) && world.getBlockState(pos).isAir(world, pos)) 
		{
			int type = (int)((Math.random()*6)+1);
			CustomSapling.generateTree(world, pos, random, type);
			return true;
		}
		return false;
	}
}