package dev.enemeez.simplefarming.common.item.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

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
            Ingredient.CODEC.fieldOf("ingredient").forGetter(FermenterRecipe::getIngredient),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(FermenterRecipe::getResult)
        ).apply(inst, FermenterRecipe::new));
        private static final StreamCodec<RegistryFriendlyByteBuf, FermenterRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, FermenterRecipe::getIngredient,
            ItemStack.STREAM_CODEC, FermenterRecipe::getResult,
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
    private @Nullable PlacementInfo placementInfo;

    public FermenterRecipe(Ingredient ingredient, ItemStack result) {
        this.RESULT = result;
        this.INGREDIENT = ingredient;
    }

    public Ingredient getIngredient() {
        return INGREDIENT;
    }

    public ItemStack getResult() {
        return RESULT;
    }

    @Override
    public boolean matches(SingleRecipeInput pInput, Level pLevel) {
        return this.INGREDIENT.test(pInput.item());
    }

    @Override
    public ItemStack assemble(SingleRecipeInput pInput, HolderLookup.Provider registries) {
        return RESULT.copy();
    }

    // Fermenting isn't shown in the vanilla recipe book
    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public PlacementInfo placementInfo() {
        if (this.placementInfo == null) {
            this.placementInfo = PlacementInfo.create(this.INGREDIENT);
        }
        return this.placementInfo;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    public RecipeSerializer<FermenterRecipe> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<FermenterRecipe> getType() {
        return Type.INSTANCE;
    }
}
