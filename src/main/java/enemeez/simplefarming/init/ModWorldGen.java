package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.world.gen.BerryBushFeature;
import enemeez.simplefarming.world.gen.CactusCropFeature;
import enemeez.simplefarming.world.gen.WildCropFeature;
import enemeez.simplefarming.world.gen.WildPlantFeature;
import enemeez.simplefarming.world.gen.feature.tree.FruitTreeFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldGen {
	public static final Feature<NoFeatureConfig> FRUIT_TREE = new FruitTreeFeature(NoFeatureConfig::deserialize);
	public static final Feature<NoFeatureConfig> BERRY_BUSH = new BerryBushFeature(NoFeatureConfig::deserialize);
	public static final Feature<NoFeatureConfig> CACTUS_CROP = new CactusCropFeature(NoFeatureConfig::deserialize);
	public static final Feature<NoFeatureConfig> WILD_CROP = new WildCropFeature(NoFeatureConfig::deserialize);
	public static final Feature<NoFeatureConfig> WILD_PLANT = new WildPlantFeature(NoFeatureConfig::deserialize);

	@SubscribeEvent
	public static void registerAll(RegistryEvent.Register<Feature<?>> event) {
		if (!event.getName().equals(ForgeRegistries.FEATURES.getRegistryName()))
			return;
		registerGen(FRUIT_TREE, "fruit_tree");
		registerGen(BERRY_BUSH, "berry_bush");
		registerGen(CACTUS_CROP, "cactus_crop");
		registerGen(WILD_CROP, "wild_crop");
		registerGen(WILD_PLANT, "wild_plant");
	}
	/* unused
    public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
    	
    }
    */

	public static Feature<?> registerGen(Feature<?> feature, String name) {
		feature.setRegistryName(new ResourceLocation(SimpleFarming.MOD_ID, name));
		ForgeRegistries.FEATURES.register(feature);

		return feature;
	}

}
