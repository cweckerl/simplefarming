package enemeez.simplefarming;

import enemeez.simplefarming.config.Config;
import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.events.TemptationTask;
import enemeez.simplefarming.events.VanillaHarvest;
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

public class SideProxy 
{
		SideProxy()
		{
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
		
		private static void commonSetup(FMLCommonSetupEvent event)
			{
				SimpleFarming.LOGGER.debug("common setup");
				
				 MinecraftForge.EVENT_BUS.register(new TemptationTask());
				 if (FeatureConfig.right_click_harvest.get())
				 MinecraftForge.EVENT_BUS.register(new VanillaHarvest());
				if (ModWorldGen.fruit_tree != null) 
				{
					for (Biome biome : ForgeRegistries.BIOMES)
					{
						biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModWorldGen.fruit_tree, IFeatureConfig.NO_FEATURE_CONFIG, Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));
						
					}
				}
				
				if (ModWorldGen.berry_bush != null) 
				{
					for (Biome biome : ForgeRegistries.BIOMES)
					{
						biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModWorldGen.berry_bush, IFeatureConfig.NO_FEATURE_CONFIG, Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));
						
					}
				}
				
				if (ModWorldGen.wild_crop != null) 
				{
					for (Biome biome : ForgeRegistries.BIOMES)
					{
						biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModWorldGen.wild_crop, IFeatureConfig.NO_FEATURE_CONFIG, Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));

					}
				}
			
				if (ModWorldGen.cactus_crop != null) 
				{
					BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY).forEach((biome) ->
					{
						biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModWorldGen.cactus_crop, IFeatureConfig.NO_FEATURE_CONFIG, Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));
					});
				
				}
				
				if (ModWorldGen.wild_plant != null) 
				{
					for (Biome biome : ForgeRegistries.BIOMES)
					{
						biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModWorldGen.wild_plant, IFeatureConfig.NO_FEATURE_CONFIG, Placement.DARK_OAK_TREE, IPlacementConfig.NO_PLACEMENT_CONFIG));

					}
				}
				
				CompostItems.register();

			}
		
		private static void enqueueIMC(final InterModEnqueueEvent event){
		    }
		
		private static void processIMC(final InterModProcessEvent event){
		    }
		   
		private static void serverStarting(FMLServerStartingEvent event) {
			}
	

	
		static class Client extends SideProxy
		{		
			Client()
			{
				FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
			}
			
			private static void clientSetup(FMLClientSetupEvent event)
			{
				
			}
		}
		
		static class Server extends SideProxy
		{
			Server()
			{
				FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);
	
			}
			private static void serverSetup(FMLDedicatedServerSetupEvent event)
			{
				
			}
		}
		
	}




