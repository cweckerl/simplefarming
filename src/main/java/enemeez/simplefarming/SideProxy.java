package enemeez.simplefarming;

import enemeez.simplefarming.config.Config;
import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.config.RightClickConfig;
import enemeez.simplefarming.events.IntoxicationTracker;
import enemeez.simplefarming.events.LootTableHandler;
import enemeez.simplefarming.events.ScarecrowEvent;
import enemeez.simplefarming.events.TemptationTask;
import enemeez.simplefarming.events.harvest.DoubleCropBreak;
import enemeez.simplefarming.events.harvest.smart.SmartBerryBushHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartCactusCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartDoubleCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartFruitLeavesHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartGrapeHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartWildPlantHarvest;
import enemeez.simplefarming.events.harvest.standard.BerryBushHarvest;
import enemeez.simplefarming.events.harvest.standard.CactusCropHarvest;
import enemeez.simplefarming.events.harvest.standard.CropHarvest;
import enemeez.simplefarming.events.harvest.standard.DoubleCropHarvest;
import enemeez.simplefarming.events.harvest.standard.FruitLeavesHarvest;
import enemeez.simplefarming.events.harvest.standard.GrapeHarvest;
import enemeez.simplefarming.events.harvest.standard.WildPlantHarvest;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import enemeez.simplefarming.init.ModWorldGen;
import enemeez.simplefarming.integration.CompostItems;
import enemeez.simplefarming.integration.FlammableBlocks;
import enemeez.simplefarming.world.gen.SimpleGeneration;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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
		SimpleGeneration.registerWorldGen();
		FlammableBlocks.registerFlammable();
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
			Block[] blocks = { ModBlocks.apple_sapling, ModBlocks.apricot_sapling, ModBlocks.banana_sapling,
					ModBlocks.cherry_sapling, ModBlocks.mango_sapling, ModBlocks.olive_sapling,
					ModBlocks.orange_sapling, ModBlocks.plum_sapling, ModBlocks.pear_sapling, ModBlocks.grape_block,
					ModBlocks.wild_crop, ModBlocks.chicory, ModBlocks.cumin, ModBlocks.marshmallow, ModBlocks.quinoa,
					ModBlocks.sunflower, ModBlocks.barley_crop, ModBlocks.broccoli_crop, ModBlocks.cactus_crop,
					ModBlocks.cantaloupe_crop, ModBlocks.carrot_crop, ModBlocks.cassava_crop, ModBlocks.corn_crop,
					ModBlocks.cotton_crop, ModBlocks.cucumber_crop, ModBlocks.eggplant_crop, ModBlocks.honeydew_crop,
					ModBlocks.ginger_crop, ModBlocks.kenaf_crop, ModBlocks.lettuce_crop, ModBlocks.oat_crop,
					ModBlocks.onion_crop, ModBlocks.peanut_crop, ModBlocks.pea_crop, ModBlocks.pepper_crop,
					ModBlocks.potato_crop, ModBlocks.radish_crop, ModBlocks.rice_crop, ModBlocks.rye_crop,
					ModBlocks.sorghum_crop, ModBlocks.soybean_crop, ModBlocks.spinach_crop, ModBlocks.squash_crop,
					ModBlocks.sweet_potato_crop, ModBlocks.tomato_crop, ModBlocks.turnip_crop, ModBlocks.yam_crop,
					ModBlocks.zucchini_crop };
			Block[] leaves = { ModBlocks.blackberry_bush, ModBlocks.blueberry_bush, ModBlocks.raspberry_bush,
					ModBlocks.strawberry_bush, ModBlocks.apple_leaves, ModBlocks.apricot_leaves,
					ModBlocks.banana_leaves, ModBlocks.cherry_leaves, ModBlocks.mango_leaves, ModBlocks.olive_leaves,
					ModBlocks.orange_leaves, ModBlocks.plum_leaves, ModBlocks.pear_leaves, ModBlocks.grape_leaves,
					ModBlocks.grape_leaves_base };
			for (Block block : blocks) {
				RenderTypeLookup.setRenderLayer(block, RenderType.func_228643_e_());
			}

			for (Block block : leaves) {
				RenderTypeLookup.setRenderLayer(block, RenderType.func_228641_d_());
			}
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