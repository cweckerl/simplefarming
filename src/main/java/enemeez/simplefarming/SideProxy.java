package enemeez.simplefarming;

import enemeez.simplefarming.config.Config;
import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.config.RightClickConfig;
import enemeez.simplefarming.events.DoubleCropBreak;
import enemeez.simplefarming.events.IntoxicationTracker;
import enemeez.simplefarming.events.LootTableHandler;
import enemeez.simplefarming.events.ScarecrowEvent;
import enemeez.simplefarming.events.TemptationTask;
import enemeez.simplefarming.events.harvest.BerryBushHarvest;
import enemeez.simplefarming.events.harvest.CactusCropHarvest;
import enemeez.simplefarming.events.harvest.CropHarvest;
import enemeez.simplefarming.events.harvest.DoubleCropHarvest;
import enemeez.simplefarming.events.harvest.FruitLeavesHarvest;
import enemeez.simplefarming.events.harvest.GrapeHarvest;
import enemeez.simplefarming.events.harvest.WildPlantHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartBerryBushHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartCactusCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartDoubleCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartFruitLeavesHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartGrapeHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartWildPlantHarvest;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import enemeez.simplefarming.init.ModWorldGen;
import enemeez.simplefarming.items.CompostItems;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;

public class SideProxy {
	SideProxy() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.CONFIG, "simplefarming.toml");
		FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::processIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ModBlocks::registerAll);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ModItems::registerAll);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ModWorldGen::registerAll);

		Config.loadConfig(Config.CONFIG, FMLPaths.CONFIGDIR.get().resolve("simplefarming.toml").toString());

		MinecraftForge.EVENT_BUS.addListener(SideProxy::serverStarting);
	}

	private static void commonSetup(FMLCommonSetupEvent event) {
		SimpleFarming.LOGGER.debug("common setup");
		MinecraftForge.EVENT_BUS.register(new LootTableHandler());
		MinecraftForge.EVENT_BUS.register(new TemptationTask());
		MinecraftForge.EVENT_BUS.register(new DoubleCropBreak());
		MinecraftForge.EVENT_BUS.register(new IntoxicationTracker());
		MinecraftForge.EVENT_BUS.register(new ScarecrowEvent());

		if (FeatureConfig.mod_harvest.get() && !FeatureConfig.smart_harvest.get()) {
			if (RightClickConfig.bush_right_click.get())
				MinecraftForge.EVENT_BUS.register(new BerryBushHarvest());
			if (RightClickConfig.cactus_right_click.get())
				MinecraftForge.EVENT_BUS.register(new CactusCropHarvest());
			if (RightClickConfig.crop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new CropHarvest());
			if (RightClickConfig.doublecrop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new DoubleCropHarvest());
			if (RightClickConfig.tree_right_click.get())
				MinecraftForge.EVENT_BUS.register(new FruitLeavesHarvest());
			if (RightClickConfig.grape_right_click.get())
				MinecraftForge.EVENT_BUS.register(new GrapeHarvest());
			if (RightClickConfig.plant_right_click.get())
				MinecraftForge.EVENT_BUS.register(new WildPlantHarvest());
		}
		if (FeatureConfig.smart_harvest.get() && !FeatureConfig.mod_harvest.get()) {
			if (RightClickConfig.bush_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartBerryBushHarvest());
			if (RightClickConfig.cactus_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartCactusCropHarvest());
			if (RightClickConfig.crop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartCropHarvest());
			if (RightClickConfig.doublecrop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartDoubleCropHarvest());
			if (RightClickConfig.tree_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartFruitLeavesHarvest());
			if (RightClickConfig.grape_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartGrapeHarvest());
			if (RightClickConfig.plant_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartWildPlantHarvest());
		}

		if (ModWorldGen.fruit_tree != null) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Biome.createDecoratedFeature(ModWorldGen.fruit_tree, IFeatureConfig.NO_FEATURE_CONFIG,
								Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			}
		}

		if (ModWorldGen.berry_bush != null) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Biome.createDecoratedFeature(ModWorldGen.berry_bush, IFeatureConfig.NO_FEATURE_CONFIG,
								Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			}
		}

		if (ModWorldGen.wild_crop != null) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Biome.createDecoratedFeature(ModWorldGen.wild_crop, IFeatureConfig.NO_FEATURE_CONFIG,
								Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			}
		}
		if (ModWorldGen.cactus_crop != null) {
			BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY).forEach((biome) -> {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Biome.createDecoratedFeature(ModWorldGen.cactus_crop, IFeatureConfig.NO_FEATURE_CONFIG,
								Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			});

		}

		if (ModWorldGen.wild_plant != null) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Biome.createDecoratedFeature(ModWorldGen.wild_plant, IFeatureConfig.NO_FEATURE_CONFIG,
								Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			}
		}
		
		CompostItems.register();

	}

	private static void enqueueIMC(final InterModEnqueueEvent event) {
	}

	private static void processIMC(final InterModProcessEvent event) {
	}

	private static void serverStarting(FMLServerStartingEvent event) {
	}

	static class Client extends SideProxy {
		Client() {
			FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
		}

		private static void clientSetup(FMLClientSetupEvent event) {

		}
	}

	static class Server extends SideProxy {
		Server() {
			FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);

		}

		private static void serverSetup(FMLDedicatedServerSetupEvent event) {

		}
	}

}