package enemeez.simplefarming.events;

import enemeez.simplefarming.SimpleFarming;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableHandler {
	private static ResourceLocation horse_drops = new ResourceLocation("minecraft", "entities/horse");
	private static ResourceLocation donkey_drops = new ResourceLocation("minecraft", "entities/donkey");
	private static ResourceLocation mule_drops = new ResourceLocation("minecraft", "entities/mule");
	private static ResourceLocation squid_drops = new ResourceLocation("minecraft", "entities/squid");

	private static ResourceLocation desert = BuiltInLootTables.VILLAGE_DESERT_HOUSE;
	private static ResourceLocation taiga = BuiltInLootTables.VILLAGE_TAIGA_HOUSE;
	private static ResourceLocation plains = BuiltInLootTables.VILLAGE_PLAINS_HOUSE;
	private static ResourceLocation snowy = BuiltInLootTables.VILLAGE_SNOWY_HOUSE;
	private static ResourceLocation savanna = BuiltInLootTables.VILLAGE_SAVANNA_HOUSE;

	@SubscribeEvent
	public void lootTableLoad(LootTableLoadEvent event) {

		if (event.getName().equals(horse_drops) || event.getName().equals(donkey_drops) || event.getName().equals(mule_drops))
			event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(SimpleFarming.MOD_ID, "entities/horse_drops"))).name("sf_horse_drops").build());

		if (event.getName().equals(squid_drops))
			event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(SimpleFarming.MOD_ID, "entities/squid_drops"))).name("sf_squid_drops").build());

		if (event.getName().equals(desert))
			event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/desert"))).name("sf_desert").build());

		if (event.getName().equals(taiga))
			event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/taiga"))).name("sf_taiga").build());

		if (event.getName().equals(plains))
			event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/plains"))).name("sf_plains").build());

		if (event.getName().equals(snowy))
			event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/snowy"))).name("sf_snowy").build());

		if (event.getName().equals(savanna))
			event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(SimpleFarming.MOD_ID, "chests/village/savanna"))).name("sf_savanna").build());

	}

}
