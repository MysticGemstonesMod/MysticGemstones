//package xyz.mysticgemstones.screen;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.minecraft.client.gui.screen.ingame.HandledScreen;
//import net.minecraft.client.gui.widget.PageTurnWidget;
//import net.minecraft.client.render.GameRenderer;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.screen.ScreenHandler;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//
//public class GemBookScreenOLD extends HandledScreen<ScreenHandler> {
//
//    // Probably should extend just Screen or BookScreen
//    private static final Identifier TEXTURE = new Identifier("mysticgemstones", "textures/gui/mysticgemstones_book_fp.png");
//    private PageTurnWidget nextPageButton;
//    private PageTurnWidget previousPageButton;
//    private final boolean pageTurnSound = true;
//
//    public GemBookScreenOLD(ScreenHandler handler, PlayerInventory inventory, Text title) {
//        super(handler, inventory, title);
//    }
//
//    @Override
//    protected void init() {
//        this.addPageButtons();
//    }
//
//    @Override
//    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, TEXTURE);
//        int x = (width - backgroundWidth) / 2;
//        int y = (height - backgroundHeight) / 2;
//        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
//    }
//
//    protected void addPageButtons() {
//        int i = (this.width - 192) / 2;
//        int j = 2;
//        this.nextPageButton = this.addDrawableChild(new PageTurnWidget(i + 116, 159, true, button -> this.goToNextPage(), this.pageTurnSound));
//        this.previousPageButton = this.addDrawableChild(new PageTurnWidget(i + 43, 159, false, button -> this.goToPreviousPage(), this.pageTurnSound));
//        this.updatePageButtons();
//    }
//
//    private void updatePageButtons() {
//        this.nextPageButton.visible = this.pageIndex < this.getPageCount() - 1;
//        this.previousPageButton.visible = this.pageIndex > 0;
//    }
//}
