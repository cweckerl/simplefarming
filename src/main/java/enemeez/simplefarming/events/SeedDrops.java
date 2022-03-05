package enemeez.simplefarming.events;

import com.google.gson.JsonObject;
import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.config.SeedConfig;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = SimpleFarming.MOD_ID, bus = Bus.MOD)
public class SeedDrops {

	/*
	 * Global loot tables because of changes from forge #6765
	 */

	@SubscribeEvent
	public static void registerModifiers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		event.getRegistry().register(new Serializer().setRegistryName(SimpleFarming.MOD_ID, "sf_grass_drops"));
	}

	private static class SeedDropModifier extends LootModifier {
		protected SeedDropModifier(LootItemCondition[] conditionsIn) {
			super(conditionsIn);
		}

		@Nonnull
		@Override
		protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
			List<Item> seeds = new ArrayList<Item>();
			if (SeedConfig.barley.get())
				seeds.add(ModItems.BARLEY_SEEDS.get());
			if (SeedConfig.beetroot.get())
				seeds.add(Items.BEETROOT_SEEDS);
			if (SeedConfig.broccoli.get())
				seeds.add(ModItems.BROCCOLI_SEEDS.get());
			if (SeedConfig.cantaloupe.get())
				seeds.add(ModItems.CANTALOUPE_SEEDS.get());
			if (SeedConfig.carrot.get())
				seeds.add(ModItems.CARROT_SEEDS.get());
			if (SeedConfig.cassava.get())
				seeds.add(ModItems.CASSAVA_SEEDS.get());
			if (SeedConfig.corn.get())
				seeds.add(ModItems.CORN_SEEDS.get());
			if (SeedConfig.cotton.get())
				seeds.add(ModItems.COTTON_SEEDS.get());
			if (SeedConfig.cucumber.get())
				seeds.add(ModItems.CUCUMBER_SEEDS.get());
			if (SeedConfig.eggplant.get())
				seeds.add(ModItems.EGGPLANT_SEEDS.get());
			if (SeedConfig.ginger.get())
				seeds.add(ModItems.BARLEY_SEEDS.get());
			if (SeedConfig.grape.get())
				seeds.add(ModItems.GRAPE_SEEDS.get());
			if (SeedConfig.honeydew.get())
				seeds.add(ModItems.HONEYDEW_SEEDS.get());
			if (SeedConfig.kenaf.get())
				seeds.add(ModItems.KENAF_SEEDS.get());
			if (SeedConfig.lettuce.get())
				seeds.add(ModItems.LETTUCE_SEEDS.get());
			if (SeedConfig.melon.get())
				seeds.add(Items.MELON_SEEDS);
			if (SeedConfig.oat.get())
				seeds.add(ModItems.OAT_SEEDS.get());
			if (SeedConfig.onion.get())
				seeds.add(ModItems.ONION_SEEDS.get());
			if (SeedConfig.pea.get())
				seeds.add(ModItems.PEA_SEEDS.get());
			if (SeedConfig.peanut.get())
				seeds.add(ModItems.PEANUT_SEEDS.get());
			if (SeedConfig.pepper.get())
				seeds.add(ModItems.PEPPER_SEEDS.get());
			if (SeedConfig.potato.get())
				seeds.add(ModItems.POTATO_SEEDS.get());
			if (SeedConfig.pumpkin.get())
				seeds.add(Items.PUMPKIN_SEEDS);
			if (SeedConfig.radish.get())
				seeds.add(ModItems.RADISH_SEEDS.get());
			if (SeedConfig.rice.get())
				seeds.add(ModItems.RICE_SEEDS.get());
			if (SeedConfig.rye.get())
				seeds.add(ModItems.RYE_SEEDS.get());
			if (SeedConfig.sorghum.get())
				seeds.add(ModItems.SORGHUM_SEEDS.get());
			if (SeedConfig.soybean.get())
				seeds.add(ModItems.SOYBEAN_SEEDS.get());
			if (SeedConfig.spinach.get())
				seeds.add(ModItems.SPINACH_SEEDS.get());
			if (SeedConfig.squash.get())
				seeds.add(ModItems.SQUASH_SEEDS.get());
			if (SeedConfig.sweet_potato.get())
				seeds.add(ModItems.SWEET_POTATO_SEEDS.get());
			if (SeedConfig.tomato.get())
				seeds.add(ModItems.TOMATO_SEEDS.get());
			if (SeedConfig.turnip.get())
				seeds.add(ModItems.TURNIP_SEEDS.get());
			if (SeedConfig.yam.get())
				seeds.add(ModItems.YAM_SEEDS.get());
			if (SeedConfig.zucchini.get())
				seeds.add(ModItems.ZUCCHINI_SEEDS.get());
			
			generatedLoot.removeIf(item -> item.getItem() == Items.WHEAT_SEEDS);
			generatedLoot.add(new ItemStack(seeds.get((int)(Math.random() * seeds.size()))));
			return generatedLoot;
		}
	}

	public static class Serializer extends GlobalLootModifierSerializer<SeedDropModifier> {

		@Override
		public SeedDropModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
			return new SeedDropModifier(ailootcondition);
		}

		@Override
		public JsonObject write(SeedDropModifier instance) {
			return new JsonObject();
		}


	}

}
