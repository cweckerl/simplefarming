package enemeez.simplefarming;

import enemeez.simplefarming.client.ClientRenderer;
import enemeez.simplefarming.config.Config;
import enemeez.simplefarming.events.EventSetup;
import enemeez.simplefarming.events.SeedDrops;
import enemeez.simplefarming.init.ModBlockEntities;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import enemeez.simplefarming.init.ModWorldGen;
import enemeez.simplefarming.integration.CompostItems;
import enemeez.simplefarming.integration.FlammableBlocks;
import enemeez.simplefarming.world.gen.SimpleGeneration;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

public class SideProxy {
    SideProxy() {
        // Load configs
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.CONFIG, "simplefarming.toml");
        Config.loadConfig(Config.CONFIG, FMLPaths.CONFIGDIR.get().resolve("simplefarming.toml").toString());

        // Common setup event
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(SideProxy::commonSetup);

        // Registration
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
        ModWorldGen.registerFeatures();

        // World gen and loot modifiers
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, SimpleGeneration::onBiomeLoad);
        eventBus.addGenericListener(GlobalLootModifierSerializer.class, SeedDrops::registerModifiers);
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
        SimpleFarming.LOGGER.debug("common setup");
        EventSetup.setupEvents();
        FlammableBlocks.registerFlammable();
        CompostItems.register();
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
