package enemeez.simplefarming.item.crafting;

import enemeez.simplefarming.init.ModRecipes;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BrewingBarrelRecipe implements IRecipe<IInventory> {

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
	public boolean matches(IInventory inv, World worldIn) {
		return ingredient.test(inv.getStackInSlot(0));
	}

	@Override
	public ItemStack getCraftingResult(@Nullable IInventory inv) {
		return result.copy();
	}

	@Override
	public boolean canFit(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	// Disable RecipeBook for this recipe
	@Override
	public boolean isDynamic() {
		return true;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return ModRecipes.BREWING_BARREL_RECIPE_SERIALIZER;
	}

	@Override
	public IRecipeType<?> getType() {
		return ModRecipes.BREWING_BARREL_RECIPE_TYPE;
	}

}