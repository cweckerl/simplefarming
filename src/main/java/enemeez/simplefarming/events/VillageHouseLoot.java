package enemeez.simplefarming.events;

import java.util.Set;
import com.google.common.collect.Sets;

import enemeez.simplefarming.SimpleFarming;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SimpleFarming.MOD_ID)
public class VillageHouseLoot 
{
	private static Set<ResourceLocation> desert = Sets.newHashSet(LootTables.CHESTS_VILLAGE_VILLAGE_DESERT_HOUSE);
	private static Set<ResourceLocation> plains = Sets.newHashSet(LootTables.CHESTS_VILLAGE_VILLAGE_PLAINS_HOUSE);
	private static Set<ResourceLocation> savanna = Sets.newHashSet(LootTables.CHESTS_VILLAGE_VILLAGE_SAVANNA_HOUSE);
	private static Set<ResourceLocation> snowy = Sets.newHashSet(LootTables.CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE);
	private static Set<ResourceLocation> taiga = Sets.newHashSet(LootTables.CHESTS_VILLAGE_VILLAGE_TAIGA_HOUSE);

	@SubscribeEvent
	public static void onLootLoad(LootTableLoadEvent event) 
	{
		if (desert.contains(event.getName())) 
			{
				LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/desert")).weight(1).quality(0)).build();
				event.getTable().addPool(pool);
			}
		if (plains.contains(event.getName())) 
			{
				LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/plains")).weight(1).quality(0)).build();
				event.getTable().addPool(pool);
			}
		if (savanna.contains(event.getName())) 
			{
				LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/savanna")).weight(1).quality(0)).build();
				event.getTable().addPool(pool);
			}
		if (snowy.contains(event.getName())) 
			{
				LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/snowy")).weight(1).quality(0)).build();
				event.getTable().addPool(pool);
			}
		if (taiga.contains(event.getName())) 
			{
				LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/taiga")).weight(1).quality(0)).build();
				event.getTable().addPool(pool);
			}
		
	}
		
	
}