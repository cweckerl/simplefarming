package dev.enemeez.simplefarming.common.item.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class FermenterRecipe implements Recipe<SingleRecipeInput> {

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
        private static final MapCodec<FermenterRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(recipe -> recipe.INGREDIENT),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.RESULT)
        ).apply(inst, FermenterRecipe::new));
        private static final StreamCodec<RegistryFriendlyByteBuf, FermenterRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.INGREDIENT,
            ItemStack.STREAM_CODEC, recipe -> recipe.RESULT,
            FermenterRecipe::new
        );

        @Override
        public MapCodec<FermenterRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FermenterRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

    private final Ingredient INGREDIENT;
    private final ItemStack RESULT;

    public FermenterRecipe(Ingredient ingredient, ItemStack result) {
        this.RESULT = result;
        this.INGREDIENT = ingredient;
    }

    @Override
    public boolean matches(SingleRecipeInput pInput, Level pLevel) {
        return this.INGREDIENT.test(pInput.item());
    }

    @Override
    public ItemStack assemble(SingleRecipeInput pInput, HolderLookup.Provider registries) {
        return RESULT.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
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
