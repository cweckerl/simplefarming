package enemeez.simplefarming.common.item.crafting;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FermenterRecipe implements Recipe<Container> {

    public static class Type implements RecipeType<FermenterRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "fermenting";
    }

    public static class Serializer implements RecipeSerializer<FermenterRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public FermenterRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            Ingredient ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient"));
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
            return new FermenterRecipe(pRecipeId, ingredient, result);
        }

        @Override
        public @Nullable FermenterRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            ItemStack result = pBuffer.readItem();
            return new FermenterRecipe(pRecipeId, ingredient, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, FermenterRecipe pRecipe) {
            pRecipe.getIngredients().get(0).toNetwork(pBuffer);
            pBuffer.writeItemStack(pRecipe.getResultItem(), false);
        }
    }

    private final ResourceLocation ID;
    private final Ingredient INGREDIENT;
    private final ItemStack RESULT;

    public FermenterRecipe(ResourceLocation id, Ingredient ingredient, ItemStack result) {
        this.ID = id;
        this.RESULT = result;
        this.INGREDIENT = ingredient;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.INGREDIENT.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return RESULT.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return RESULT;
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
}
