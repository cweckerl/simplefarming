package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.item.crafting.FermenterRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
        ForgeRegistries.RECIPE_SERIALIZERS, SimpleFarming.MOD_ID
    );

    public static final RegistryObject<RecipeSerializer<FermenterRecipe>> FERMENTING_SERIALIZER = RECIPE_SERIALIZERS.register(
        FermenterRecipe.Type.ID, () -> FermenterRecipe.Serializer.INSTANCE
    );
}
