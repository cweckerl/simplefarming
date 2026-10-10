package dev.enemeez.simplefarming.client;

import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.item.crafting.FermenterRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;

import java.util.List;

/**
 * Since 1.21.2 the client no longer receives the full recipe list. The server sends the fermenting
 * recipe type explicitly (see CommonEvents#syncRecipes) and this keeps the copy that arrives, for JEI.
 */
@EventBusSubscriber(modid = SimpleFarming.MOD_ID, value = Dist.CLIENT)
public class ClientRecipes {
    private static RecipeMap recipes = RecipeMap.EMPTY;

    @SubscribeEvent
    public static void onRecipesReceived(RecipesReceivedEvent event) {
        recipes = event.getRecipeMap();
    }

    public static List<RecipeHolder<FermenterRecipe>> fermenting() {
        return List.copyOf(recipes.byType(FermenterRecipe.Type.INSTANCE));
    }
}
