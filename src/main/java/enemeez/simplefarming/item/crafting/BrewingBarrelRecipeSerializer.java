package enemeez.simplefarming.item.crafting;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class BrewingBarrelRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<BrewingBarrelRecipe> {

	@Override
	public BrewingBarrelRecipe read(ResourceLocation recipeId, JsonObject json) {
		JsonObject ingredientJson = JSONUtils.getJsonObject(json, "ingredient");
		Ingredient ingredient = Ingredient.deserialize(ingredientJson);
		ItemStack result = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "result"), false);
		return new BrewingBarrelRecipe(recipeId, ingredient, result);
	}

	@Override
	public BrewingBarrelRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
		Ingredient ingredient = Ingredient.read(buffer);
		ItemStack result = buffer.readItemStack();
		return new BrewingBarrelRecipe(recipeId, ingredient, result);
	}

	@Override
	public void write(PacketBuffer buffer, BrewingBarrelRecipe recipe) {
		recipe.getIngredient().write(buffer);
		buffer.writeItemStack(recipe.getCraftingResult(null));
	}

}