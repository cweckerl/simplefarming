package enemeez.simplefarming.events;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

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

		private final Item[] SEEDS = { ModItems.cantaloupe_seeds, ModItems.carrot_seeds, ModItems.cassava_seeds, ModItems.corn_seeds, ModItems.cucumber_seeds, ModItems.eggplant_seeds,
				ModItems.honeydew_seeds, ModItems.kenaf_seeds, ModItems.lettuce_seeds, ModItems.oat_seeds, ModItems.onion_seeds, ModItems.potato_seeds, ModItems.pepper_seeds, ModItems.radish_seeds,
				ModItems.rice_seeds, ModItems.rye_seeds, ModItems.soybean_seeds, ModItems.spinach_seeds, ModItems.squash_seeds, ModItems.tomato_seeds, ModItems.yam_seeds, ModItems.ginger_seeds,
				ModItems.grape_seeds, ModItems.sorghum_seeds, ModItems.peanut_seeds, ModItems.barley_seeds, ModItems.pea_seeds, ModItems.cotton_seeds, ModItems.sweet_potato_seeds,
				ModItems.broccoli_seeds, ModItems.zucchini_seeds, ModItems.turnip_seeds, Items.PUMPKIN_SEEDS, Items.MELON_SEEDS, Items.BEETROOT_SEEDS };

		protected SeedDropModifier(ILootCondition[] conditionsIn) {
			super(conditionsIn);
		}

		@Nonnull
		@Override
		protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
			generatedLoot.removeIf(item -> item.getItem() == Items.WHEAT_SEEDS);
			generatedLoot.add(new ItemStack(SEEDS[(int) (Math.random() * SEEDS.length)]));
			return generatedLoot;
		}
	}

	public static class Serializer extends GlobalLootModifierSerializer<SeedDropModifier> {

		@Override
		public SeedDropModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
			return new SeedDropModifier(ailootcondition);
		}

		@Override
		public JsonObject write(SeedDropModifier instance) {
			// TODO Auto-generated method stub
			return null;
		}


	}

}
