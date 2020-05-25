package enemeez.simplefarming.events;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.config.EnableConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableHandler {
	private static ResourceLocation grass_drops = new ResourceLocation("minecraft", "blocks/grass");
	private static ResourceLocation fern_drops = new ResourceLocation("minecraft", "blocks/fern");
	private static ResourceLocation tall_grass_drops = new ResourceLocation("minecraft", "blocks/tall_grass");
	
	private static ResourceLocation horse_drops = new ResourceLocation("minecraft", "entities/horse");
	private static ResourceLocation donkey_drops = new ResourceLocation("minecraft", "entities/donkey");
	private static ResourceLocation mule_drops = new ResourceLocation("minecraft", "entities/mule");
	private static ResourceLocation squid_drops = new ResourceLocation("minecraft", "entities/squid");

	private static ResourceLocation desert = LootTables.CHESTS_VILLAGE_VILLAGE_DESERT_HOUSE;
	private static ResourceLocation taiga = LootTables.CHESTS_VILLAGE_VILLAGE_TAIGA_HOUSE;
	private static ResourceLocation plains = LootTables.CHESTS_VILLAGE_VILLAGE_PLAINS_HOUSE;
	private static ResourceLocation snowy = LootTables.CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE;
	private static ResourceLocation savanna = LootTables.CHESTS_VILLAGE_VILLAGE_SAVANNA_HOUSE;

	@SubscribeEvent
	public void lootTableLoad(LootTableLoadEvent event) {
		if (EnableConfig.wild_crop_validate.get() && event.getName().equals(grass_drops) || event.getName().equals(fern_drops) || event.getName().equals(tall_grass_drops))
			event.getTable().addPool(LootPool.builder()
					.addEntry(TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "blocks/grass_drops")))
					.name("sf_grass_drops").build());

		if (event.getName().equals(horse_drops) || event.getName().equals(donkey_drops)
				|| event.getName().equals(mule_drops))
			event.getTable().addPool(LootPool.builder()
					.addEntry(
							TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "entities/horse_drops")))
					.name("sf_horse_drops").build());

		if (event.getName().equals(squid_drops))
			event.getTable().addPool(LootPool.builder()
					.addEntry(
							TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "entities/squid_drops")))
					.name("sf_squid_drops").build());

		if (event.getName().equals(desert))
			event.getTable().addPool(LootPool.builder()
					.addEntry(
							TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/desert")))
					.name("sf_desert").build());

		if (event.getName().equals(taiga))
			event.getTable().addPool(LootPool.builder()
					.addEntry(
							TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/taiga")))
					.name("sf_taiga").build());

		if (event.getName().equals(plains))
			event.getTable().addPool(LootPool.builder()
					.addEntry(
							TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/plains")))
					.name("sf_plains").build());

		if (event.getName().equals(snowy))
			event.getTable().addPool(LootPool.builder()
					.addEntry(
							TableLootEntry.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/snowy")))
					.name("sf_snowy").build());

		if (event.getName().equals(savanna))
			event.getTable()
					.addPool(LootPool.builder()
							.addEntry(TableLootEntry
									.builder(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/savanna")))
							.name("sf_savanna").build());

	}

}
