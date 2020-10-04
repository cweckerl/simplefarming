package enemeez.simplefarming;

import enemeez.simplefarming.client.ClientRenderer;
import enemeez.simplefarming.config.Config;
import enemeez.simplefarming.events.EventSetup;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import enemeez.simplefarming.init.ModWorldGen;
import enemeez.simplefarming.integration.CompostItems;
import enemeez.simplefarming.integration.FlammableBlocks;
import enemeez.simplefarming.world.gen.SimpleGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
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
		Config.loadConfig(Config.CONFIG, FMLPaths.CONFIGDIR.get().resolve("simplefarming.toml").toString());

		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(SideProxy::commonSetup);
		eventBus.addListener(SideProxy::enqueueIMC);
		eventBus.addListener(SideProxy::processIMC);
		eventBus.addListener(ModBlocks::registerAll);
		eventBus.addListener(ModItems::registerAll);
		eventBus.addListener(ModWorldGen::registerAll);

		MinecraftForge.EVENT_BUS.addListener(SideProxy::serverStarting);
	}

	private static void commonSetup(FMLCommonSetupEvent event) {
		SimpleFarming.LOGGER.debug("common setup");
		EventSetup.setupEvents();
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
