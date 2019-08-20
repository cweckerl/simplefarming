package enemeez.simplefarming.world.gen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import enemeez.simplefarming.blocks.WildCrop;
import enemeez.simplefarming.config.GenConfig;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class WildCropFeature extends Feature<NoFeatureConfig> 
{
	public WildCropFeature(Function<Dynamic<?>,? extends NoFeatureConfig> configFactory) 
	{
		super(configFactory);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos pos, NoFeatureConfig config) 
	{
		
		if (random.nextInt(GenConfig.wild_crop_chance.get()) != 0)  
			return false;
		
			      
		   int place0 = (int)((Math.random()*4)+1);
		   int place1 = (int)((Math.random()*4)+1);

		      
		   if(world.getBlockState(pos.north(place0).down()).getBlock().isIn(BlockTags.DIRT_LIKE) && world.getBlockState(pos.north(place0)).getMaterial().isReplaceable()) 
			   WildCrop.generateBush(world, pos.north(place0), random);
		   if(world.getBlockState(pos.south(place1).down()).getBlock().isIn(BlockTags.DIRT_LIKE) && world.getBlockState(pos.south(place1)).getMaterial().isReplaceable()) 
			   WildCrop.generateBush(world, pos.south(place1), random);

		   

			return true;
		

	}
}