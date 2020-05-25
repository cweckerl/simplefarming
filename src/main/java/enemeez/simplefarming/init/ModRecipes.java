package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.item.crafting.BrewingBarrelRecipe;
import enemeez.simplefarming.item.crafting.BrewingBarrelRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRecipes {

	@ObjectHolder("simplefarming:brewing")
	public static BrewingBarrelRecipeSerializer BREWING_BARREL_RECIPE_SERIALIZER;

	public static IRecipeType<BrewingBarrelRecipe> BREWING_BARREL_RECIPE_TYPE;

	@SubscribeEvent
	public static void onRecipeSerializerRegistry(RegistryEvent.Register<IRecipeSerializer<?>> event) {
		event.getRegistry().register(new BrewingBarrelRecipeSerializer().setRegistryName(SimpleFarming.getId("brewing")));

		BREWING_BARREL_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, SimpleFarming.getId("brewing"), new IRecipeType<BrewingBarrelRecipe>() {
			@Override
	        public String toString() {
	            return SimpleFarming.getId("brewing").toString();
	        }
		});
	}
}