package dev.enemeez.simplefarming.common.registries;

import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.item.crafting.FermenterRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
        Registries.RECIPE_SERIALIZER, SimpleFarming.MOD_ID
    );
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
        Registries.RECIPE_TYPE, SimpleFarming.MOD_ID
    );

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FermenterRecipe>> FERMENTING_SERIALIZER = RECIPE_SERIALIZERS.register(
        FermenterRecipe.Type.ID, () -> FermenterRecipe.Serializer.INSTANCE
    );
    public static final DeferredHolder<RecipeType<?>, RecipeType<FermenterRecipe>> FERMENTING_TYPE = RECIPE_TYPES.register(
        FermenterRecipe.Type.ID, () -> FermenterRecipe.Type.INSTANCE
    );
}
