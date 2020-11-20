package enemeez.simplefarming;

import com.google.common.collect.ImmutableMap;
import enemeez.simplefarming.client.ClientRenderer;
import enemeez.simplefarming.config.Config;
import enemeez.simplefarming.events.EventSetup;
import enemeez.simplefarming.events.SeedDrops;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import enemeez.simplefarming.init.ModWorldGen;
import enemeez.simplefarming.integration.CompostItems;
import enemeez.simplefarming.integration.FlammableBlocks;
import enemeez.simplefarming.mixin.VillagerEntityAccessor;
import enemeez.simplefarming.mixin.VillagerEntityMixin;
import enemeez.simplefarming.util.FarmingVillagerUtil;
import enemeez.simplefarming.world.gen.SimpleGeneration;
import net.minecraft.block.Block;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.TagsUpdatedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoader;
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

import java.util.HashMap;
import java.util.Map;

public class SideProxy {
	SideProxy() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.CONFIG, "simplefarming.toml");
		Config.loadConfig(Config.CONFIG, FMLPaths.CONFIGDIR.get().resolve("simplefarming.toml").toString());

		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(SideProxy::commonSetup);
		eventBus.addListener(SideProxy::enqueueIMC);
		eventBus.addListener(SideProxy::processIMC);

		eventBus.addGenericListener(Block.class, ModBlocks::registerAll);
		eventBus.addGenericListener(Item.class, ModItems::registerAll);
		eventBus.addGenericListener(Feature.class, ModWorldGen::registerAll);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, SimpleGeneration::onBiomeLoad);
		eventBus.addGenericListener(GlobalLootModifierSerializer.class, SeedDrops::registerModifiers);


		MinecraftForge.EVENT_BUS.addListener(SideProxy::serverStarting);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.LOWEST, SideProxy::onTagsUpdated);
	}

	private static void commonSetup(FMLCommonSetupEvent event) {
		SimpleFarming.LOGGER.debug("common setup");
		EventSetup.setupEvents();
		FlammableBlocks.registerFlammable();
		CompostItems.register();

		FarmingVillagerUtil.onCommonSetup();
	}

	private static void onTagsUpdated(final TagsUpdatedEvent.CustomTagTypes event) {
		FarmingVillagerUtil.rebuildFoodValueMap();
		FarmingVillagerUtil.rebuildCompostableList();
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
			ClientRenderer.registerBlocks();
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
