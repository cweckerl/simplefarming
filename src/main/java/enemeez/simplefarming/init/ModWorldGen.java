package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.world.gen.BerryBushFeature;
import enemeez.simplefarming.world.gen.CactusCropFeature;
import enemeez.simplefarming.world.gen.WildCropFeature;
import enemeez.simplefarming.world.gen.WildPlantFeature;
import enemeez.simplefarming.world.gen.feature.tree.FruitTreeFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModWorldGen {
	private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SimpleFarming.MOD_ID);

	public static final RegistryObject<Feature<NoneFeatureConfiguration>> FRUIT_TREE = FEATURES.register("fruit_tree", () -> new FruitTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> BERRY_BUSH = FEATURES.register("berry_bush", () -> new BerryBushFeature(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> CACTUS_CROP = FEATURES.register("cactus_crop", () -> new CactusCropFeature(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_CROP = FEATURES.register("wild_crop", () -> new WildCropFeature(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_PLANT = FEATURES.register("wild_plant", () -> new WildPlantFeature(NoneFeatureConfiguration.CODEC));

	public static void registerFeatures() {
		FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

}
