package dev.enemeez.simplefarming.client.gui;

import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.block.menu.FermenterMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class FermenterScreen extends AbstractContainerScreen<FermenterMenu> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(SimpleFarming.MOD_ID, "textures/gui/fermenter.png");

    public FermenterScreen(FermenterMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float pPartialTick, int pMouseX, int pMouseY) {
        int progress = this.menu.getScaledProgress();
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, this.leftPos + 79, this.topPos + 34, 176, 14, progress + 1, 16, 256, 256);
    }

    @Override
    public void render(GuiGraphics graphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(graphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(graphics, pMouseX, pMouseY);
    }
}
