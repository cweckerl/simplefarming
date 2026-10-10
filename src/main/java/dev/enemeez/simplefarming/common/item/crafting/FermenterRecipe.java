package dev.enemeez.simplefarming.common.item.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class FermenterRecipe implements Recipe<Container> {

    public static class Type implements RecipeType<FermenterRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "fermenting";

        @Override
        public String toString() {
            return SimpleFarming.MOD_ID + ":" + ID;
        }
    }

    public static class Serializer implements RecipeSerializer<FermenterRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        private static final Codec<FermenterRecipe> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(recipe -> recipe.INGREDIENT),
            ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result").forGetter(recipe -> recipe.RESULT)
        ).apply(inst, FermenterRecipe::new));

        @Override
        public Codec<FermenterRecipe> codec() {
            return CODEC;
        }

        @Override
        public FermenterRecipe fromNetwork(FriendlyByteBuf pBuffer) {
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            ItemStack result = pBuffer.readItem();
            return new FermenterRecipe(ingredient, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, FermenterRecipe pRecipe) {
            pRecipe.INGREDIENT.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.RESULT);
        }
    }

    private final Ingredient INGREDIENT;
    private final ItemStack RESULT;

    public FermenterRecipe(Ingredient ingredient, ItemStack result) {
        this.RESULT = result;
        this.INGREDIENT = ingredient;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.INGREDIENT.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess access) {
        return RESULT.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return RESULT;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.EMPTY, INGREDIENT, Ingredient.of(Items.GLASS_BOTTLE));
    }
}
