package xyz.mysticgemstones.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.PageTurnWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GemBookScreen extends HandledScreen<ScreenHandler> {
    // Probably should extend just Screen or BookScreen

    private static final Identifier TEXTURE = new Identifier("mysticgemstones", "textures/gui/mysticgemstones_book_fp.png");
    private PageTurnWidget nextPageButton;
    private PageTurnWidget previousPageButton;
    private boolean pageTurnSound;

    public GemBookScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - 200) / 2;
        int y = (height - 200) / 2;
        drawTexture(matrices, x, y, 0, 0, 200, 200); // Hardcoded width and height "200" NOT GOOD its temporary...
        addButtons();
    }

    private void addButtons() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, 300, 200, 20, ScreenTexts.DONE, button -> this.client.setScreen(null)));

        int i = (this.width - 192) / 2;
        this.nextPageButton = this.addDrawableChild(new PageTurnWidget(i + 16-0, 270, true, button -> this.goToNextPage(), this.pageTurnSound));
        this.previousPageButton = this.addDrawableChild(new PageTurnWidget(i + 10, 270, false, button -> this.goToPreviousPage(), this.pageTurnSound));
        this.updatePageButtons();
    }

    private void goToPreviousPage() {
    }

    private void goToNextPage() {
    }

    private void updatePageButtons() {
    }
}
