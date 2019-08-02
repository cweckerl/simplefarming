package enemeez.simplefarming.events;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.config.GenConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SimpleFarming.MOD_ID)
public class GrassHarvestEvent 
{
	private static ResourceLocation grass = new ResourceLocation("minecraft", "blocks/grass");

	@SubscribeEvent
	public static void onLootLoad(LootTableLoadEvent event) 
	{

		if (event.getName().equals(grass)) 
		{
			if (GenConfig.grass_drops.get() == true)
			event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "blocks/grass"))).build());
		}
	}
}