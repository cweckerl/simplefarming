package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.blocks.CustomCactus;
import enemeez.simplefarming.config.GenConfig;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class CactusCropFeature extends Feature<NoFeatureConfig> 
{
	public CactusCropFeature(Function<Dynamic<?>,? extends NoFeatureConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos pos, NoFeatureConfig config) 
	{
		if (random.nextInt(GenConfig.cactus_chance.get()) != 0)  
			return false;
	 
			   if(world.getBlockState(pos.down()).getBlock().isIn(BlockTags.SAND) && world.getBlockState(pos).getMaterial().isReplaceable()) 
				   CustomCactus.generateCactus(world, pos, random);

			return true;
		

	}
}