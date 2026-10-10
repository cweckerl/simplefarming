package dev.enemeez.simplefarming.common.item.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
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

    public static class Serializer {
        private static final MapCodec<FermenterRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(FermenterRecipe::getIngredient),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(recipe -> recipe.RESULT)
        ).apply(inst, FermenterRecipe::new));
        private static final StreamCodec<RegistryFriendlyByteBuf, FermenterRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, FermenterRecipe::getIngredient,
            ItemStackTemplate.STREAM_CODEC, recipe -> recipe.RESULT,
            FermenterRecipe::new
        );

        public static final RecipeSerializer<FermenterRecipe> INSTANCE = new RecipeSerializer<>(CODEC, STREAM_CODEC);
    }

    private final Ingredient INGREDIENT;
    // 26.x recipes keep results as templates (item stacks can only be built once item components are bound)
    private final ItemStackTemplate RESULT;
    private @Nullable PlacementInfo placementInfo;

    public FermenterRecipe(Ingredient ingredient, ItemStackTemplate result) {
        this.RESULT = result;
        this.INGREDIENT = ingredient;
    }

    public Ingredient getIngredient() {
        return INGREDIENT;
    }

    public ItemStack getResult() {
        return RESULT.create();
    }

    @Override
    public boolean matches(SingleRecipeInput pInput, Level pLevel) {
        return this.INGREDIENT.test(pInput.item());
    }

    @Override
    public ItemStack assemble(SingleRecipeInput pInput) {
        return RESULT.create();
    }

    // Fermenting isn't shown in the vanilla recipe book
    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "";
    }

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
