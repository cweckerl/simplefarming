package dev.enemeez.simplefarming.client.integration;

import dev.enemeez.simplefarming.client.ClientRecipes;
import dev.enemeez.simplefarming.client.gui.FermenterScreen;
import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.block.menu.FermenterMenu;
import dev.enemeez.simplefarming.common.item.crafting.FermenterRecipe;
import dev.enemeez.simplefarming.common.registries.ModItems;
import dev.enemeez.simplefarming.common.registries.ModMenus;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;

@JeiPlugin
public class JeiIntegration implements IModPlugin {

    private static final IRecipeHolderType<FermenterRecipe> FERMENTER_RECIPE_TYPE = IRecipeHolderType.create(FermenterRecipe.Type.INSTANCE);

    @Override
    public Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(SimpleFarming.MOD_ID, "jei");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FermenterCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        // Recipes only exist on the server since 1.21.2; the fermenting type is synced to clients (see ClientRecipes)
        registration.addRecipes(FERMENTER_RECIPE_TYPE, ClientRecipes.fermenting());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(FERMENTER_RECIPE_TYPE, ModItems.FERMENTER.get());
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(FermenterMenu.class, ModMenus.FERMENTER_MENU.get(), FERMENTER_RECIPE_TYPE, 36, 2, 0, 36);
    }

    private static class FermenterCategory implements IRecipeCategory<RecipeHolder<FermenterRecipe>> {
        private final IDrawableAnimated arrow;
        private final IDrawable background;
        private final IDrawable icon;

        public FermenterCategory(IGuiHelper guiHelper) {
            arrow = guiHelper.drawableBuilder(FermenterScreen.TEXTURE, 176, 14, 24, 17).buildAnimated(2000, IDrawableAnimated.StartDirection.LEFT, false);
            background = guiHelper.createDrawable(FermenterScreen.TEXTURE, 51, 12, 90, 62);
            icon = guiHelper.createDrawableItemStack(new ItemStack(ModItems.FERMENTER.get()));
        }

        @Override
        public IRecipeHolderType<FermenterRecipe> getRecipeType() {
            return FERMENTER_RECIPE_TYPE;
        }

        @Override
        public Component getTitle() {
            return Component.translatable("container.fermenter");
        }

        @Override
        public int getWidth() {
            return 90;
        }

        @Override
        public int getHeight() {
            return 62;
        }

        @Override
        public IDrawable getIcon() {
            return icon;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<FermenterRecipe> recipe, IFocusGroup focuses) {
            builder.addSlot(RecipeIngredientRole.INPUT, 5, 5).add(recipe.value().getIngredient());
            builder.addSlot(RecipeIngredientRole.INPUT, 5, 41).add(Items.GLASS_BOTTLE);
            builder.addSlot(RecipeIngredientRole.OUTPUT, 65, 23).add(recipe.value().getResult());
        }

        @Override
        public void draw(RecipeHolder<FermenterRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
            background.draw(guiGraphics);
            arrow.draw(guiGraphics, 28, 23);
        }
    }
}
