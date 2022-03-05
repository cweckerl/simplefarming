package enemeez.simplefarming.item.crafting;

import com.google.gson.JsonObject;
import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.init.ModRecipes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class BrewingBarrelRecipe implements Recipe<Container> {

	public static final Serializer SERIALIZER = new Serializer();

	private final ResourceLocation id;
	private final ItemStack result;
	private final Ingredient ingredient;

	public BrewingBarrelRecipe(ResourceLocation id, Ingredient ingredient, ItemStack result) {
		this.id = id;
		this.ingredient = ingredient;
		this.result = result;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	@Override
	public boolean matches(Container inv, Level worldIn) {
		return ingredient.test(inv.getItem(0));
	}

	@Override
	public ItemStack assemble(@Nullable Container inv) {
		return result.copy();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return ItemStack.EMPTY;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	// Disable RecipeBook for this recipe
	@Override
	public boolean isSpecial() {
		return true;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return SERIALIZER;
	}

	@Override
	public RecipeType<?> getType() {
		return ModRecipes.BREWING_BARREL_RECIPE_TYPE;
	}

	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<BrewingBarrelRecipe> {

		public Serializer() {
			setRegistryName(SimpleFarming.getId("brewing"));
		}

		@Override
		public BrewingBarrelRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			JsonObject ingredientJson = GsonHelper.getAsJsonObject(json, "ingredient");
			Ingredient ingredient = Ingredient.fromJson(ingredientJson);
			ItemStack result = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "result"), false);
			return new BrewingBarrelRecipe(recipeId, ingredient, result);
		}

		@Override
		public BrewingBarrelRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
			Ingredient ingredient = Ingredient.fromNetwork(buffer);
			ItemStack result = buffer.readItem();
			return new BrewingBarrelRecipe(recipeId, ingredient, result);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, BrewingBarrelRecipe recipe) {
			recipe.getIngredient().toNetwork(buffer);
			buffer.writeItem(recipe.assemble(null));
		}

	}

}