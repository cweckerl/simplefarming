package dev.enemeez.simplefarming.client.integration;

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
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

@JeiPlugin
public class JeiIntegration implements IModPlugin {

    private static final RecipeType<FermenterRecipe> FERMENTER_RECIPE_TYPE = RecipeType.create(SimpleFarming.MOD_ID, FermenterRecipe.Type.ID, FermenterRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(SimpleFarming.MOD_ID, "jei");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(new FermenterCategory(guiHelper));
    }

    @SuppressWarnings("resource")
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<FermenterRecipe> fermenterRecipies = Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(FermenterRecipe.Type.INSTANCE);
        registration.addRecipes(FERMENTER_RECIPE_TYPE, fermenterRecipies);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModItems.FERMENTER.get()), FERMENTER_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(FermenterMenu.class, ModMenus.FERMENTER_MENU.get(), FERMENTER_RECIPE_TYPE, 36, 2, 0, 36);
    }

    private static class FermenterCategory implements IRecipeCategory<FermenterRecipe> {

        private final IDrawableAnimated arrow;
        private final IDrawable background;
        private final IDrawable icon;

        public FermenterCategory(IGuiHelper guiHelper) {
            arrow = guiHelper.drawableBuilder(FermenterScreen.TEXTURE, 176, 14, 24, 17).buildAnimated(2000, IDrawableAnimated.StartDirection.LEFT, false);
            background = guiHelper.createDrawable(FermenterScreen.TEXTURE, 51, 12, 90, 62);
            icon = guiHelper.createDrawableItemStack(new ItemStack(ModItems.FERMENTER.get()));
        }

        @Override
        public RecipeType<FermenterRecipe> getRecipeType() {
            return FERMENTER_RECIPE_TYPE;
        }

        @Override
        public Component getTitle() {
            return Component.translatable("container.fermenter");
        }

        @Override
        public IDrawable getBackground() {
            return background;
        }

        @Override
        public IDrawable getIcon() {
            return icon;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder builder, FermenterRecipe recipe, IFocusGroup focuses) {
            NonNullList<Ingredient> ingredients = recipe.getIngredients();
            builder.addSlot(RecipeIngredientRole.INPUT, 5, 5).addIngredients(ingredients.get(0));
            builder.addSlot(RecipeIngredientRole.INPUT, 5, 41).addIngredients(ingredients.get(1));
            builder.addSlot(RecipeIngredientRole.OUTPUT, 65, 23).addItemStack(recipe.getResultItem(null));
        }

        @Override
        public void draw(FermenterRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
            arrow.draw(guiGraphics, 28, 23);
        }

    }
}
