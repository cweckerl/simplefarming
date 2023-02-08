package enemeez.simplefarming.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.block.menu.FermenterMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class FermenterScreen extends AbstractContainerScreen<FermenterMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SimpleFarming.MOD_ID, "textures/gui/fermenter.png");

    public FermenterScreen(FermenterMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int leftPos = this.leftPos;
        int topPos = this.topPos;
        int progress = this.menu.getScaledProgress();
        this.blit(pPoseStack, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight);
        this.blit(pPoseStack, leftPos + 79, topPos + 34, 176, 14, progress + 1, 16);
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }
}
