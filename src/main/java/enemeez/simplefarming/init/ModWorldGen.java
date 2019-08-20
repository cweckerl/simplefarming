package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.config.EnableConfig;
import enemeez.simplefarming.world.gen.BerryBushFeature;
import enemeez.simplefarming.world.gen.CactusCropFeature;
import enemeez.simplefarming.world.gen.FruitTreeFeature;
import enemeez.simplefarming.world.gen.WildCropFeature;
import enemeez.simplefarming.world.gen.WildPlantFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModWorldGen 
{
	public static Feature<NoFeatureConfig> fruit_tree;
	public static Feature<NoFeatureConfig> berry_bush;
	public static Feature<NoFeatureConfig> cactus_crop;
	public static Feature<NoFeatureConfig> wild_crop;
	public static Feature<NoFeatureConfig> wild_plant;
	
	
	public static void registerAll(RegistryEvent.Register<Feature<?>> event)
	{
		if (!event.getName().equals(ForgeRegistries.FEATURES.getRegistryName())) return;
		IForgeRegistry<Feature<?>> r = event.getRegistry();
		
		
		if (EnableConfig.tree_validate.get())
		fruit_tree = register(r , new FruitTreeFeature(NoFeatureConfig::deserialize), "fruit_tree");
		if (EnableConfig.bush_validate.get()==true)
		berry_bush = register(r , new BerryBushFeature(NoFeatureConfig::deserialize), "berry_bush");
		if (EnableConfig.cactus_validate.get())
		cactus_crop = register(r , new CactusCropFeature(NoFeatureConfig::deserialize), "cactus_crop");
		if (EnableConfig.wild_crop_validate.get())
		wild_crop = register(r , new WildCropFeature(NoFeatureConfig::deserialize), "wild_crop");
		if (EnableConfig.wild_plant_validate.get())
		wild_plant = register(r , new WildPlantFeature(NoFeatureConfig::deserialize), "wild_plant");
		
	}
	
	
	private static <V extends R, R extends IForgeRegistryEntry<R>> V register(IForgeRegistry<R> registry, V value, String name) 
	  {
		ResourceLocation id = SimpleFarming.getId(name);
	    value.setRegistryName(id);
	    registry.register(value);
	    return value;
	  }
	
	
}
