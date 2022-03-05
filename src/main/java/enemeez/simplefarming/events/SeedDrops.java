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
				seeds.add(ModItems.barley_seeds.get());
			if (SeedConfig.beetroot.get())
				seeds.add(Items.BEETROOT_SEEDS);
			if (SeedConfig.broccoli.get())
				seeds.add(ModItems.broccoli_seeds.get());
			if (SeedConfig.cantaloupe.get())
				seeds.add(ModItems.cantaloupe_seeds.get());
			if (SeedConfig.carrot.get())
				seeds.add(ModItems.carrot_seeds.get());
			if (SeedConfig.cassava.get())
				seeds.add(ModItems.cassava_seeds.get());
			if (SeedConfig.corn.get())
				seeds.add(ModItems.corn_seeds.get());
			if (SeedConfig.cotton.get())
				seeds.add(ModItems.cotton_seeds.get());
			if (SeedConfig.cucumber.get())
				seeds.add(ModItems.cucumber_seeds.get());
			if (SeedConfig.eggplant.get())
				seeds.add(ModItems.eggplant_seeds.get());
			if (SeedConfig.ginger.get())
				seeds.add(ModItems.barley_seeds.get());
			if (SeedConfig.grape.get())
				seeds.add(ModItems.grape_seeds.get());
			if (SeedConfig.honeydew.get())
				seeds.add(ModItems.honeydew_seeds.get());
			if (SeedConfig.kenaf.get())
				seeds.add(ModItems.kenaf_seeds.get());
			if (SeedConfig.lettuce.get())
				seeds.add(ModItems.lettuce_seeds.get());
			if (SeedConfig.melon.get())
				seeds.add(Items.MELON_SEEDS);
			if (SeedConfig.oat.get())
				seeds.add(ModItems.oat_seeds.get());
			if (SeedConfig.onion.get())
				seeds.add(ModItems.onion_seeds.get());
			if (SeedConfig.pea.get())
				seeds.add(ModItems.pea_seeds.get());
			if (SeedConfig.peanut.get())
				seeds.add(ModItems.peanut_seeds.get());
			if (SeedConfig.pepper.get())
				seeds.add(ModItems.pepper_seeds.get());
			if (SeedConfig.potato.get())
				seeds.add(ModItems.potato_seeds.get());
			if (SeedConfig.pumpkin.get())
				seeds.add(Items.PUMPKIN_SEEDS);
			if (SeedConfig.radish.get())
				seeds.add(ModItems.radish_seeds.get());
			if (SeedConfig.rice.get())
				seeds.add(ModItems.rice_seeds.get());
			if (SeedConfig.rye.get())
				seeds.add(ModItems.rye_seeds.get());
			if (SeedConfig.sorghum.get())
				seeds.add(ModItems.sorghum_seeds.get());
			if (SeedConfig.soybean.get())
				seeds.add(ModItems.soybean_seeds.get());
			if (SeedConfig.spinach.get())
				seeds.add(ModItems.spinach_seeds.get());
			if (SeedConfig.squash.get())
				seeds.add(ModItems.squash_seeds.get());
			if (SeedConfig.sweet_potato.get())
				seeds.add(ModItems.sweet_potato_seeds.get());
			if (SeedConfig.tomato.get())
				seeds.add(ModItems.tomato_seeds.get());
			if (SeedConfig.turnip.get())
				seeds.add(ModItems.turnip_seeds.get());
			if (SeedConfig.yam.get())
				seeds.add(ModItems.yam_seeds.get());
			if (SeedConfig.zucchini.get())
				seeds.add(ModItems.zucchini_seeds.get());
			
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
