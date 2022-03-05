package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.item.crafting.BrewingBarrelRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRecipes {
	public static RecipeType<BrewingBarrelRecipe> BREWING_BARREL_RECIPE_TYPE;

	@SubscribeEvent
	public static void onRecipeSerializerRegistry(RegistryEvent.Register<RecipeSerializer<?>> event) {
		event.getRegistry().register(BrewingBarrelRecipe.SERIALIZER);

		BREWING_BARREL_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, SimpleFarming.getId("brewing"), new RecipeType<BrewingBarrelRecipe>() {
			@Override
			public String toString() {
				return SimpleFarming.getId("brewing").toString();
			}
		});
	}
}