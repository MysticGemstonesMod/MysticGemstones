package xyz.mysticgemstones.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.mysticgemstones.item.MysticGemstonesItems;

@Mixin(InventoryScreen.class)
@Environment(EnvType.CLIENT)
public abstract class PlayerInventoryScreenMixin extends AbstractInventoryScreen<PlayerScreenHandler> {

    public PlayerInventoryScreenMixin(PlayerScreenHandler screenHandler, PlayerInventory playerInventory, Text textComponent) {
        super(screenHandler, playerInventory, textComponent);
    }

    @Inject(method = "drawBackground", at = @At("TAIL"))
    public void drawBackground(MatrixStack matrices, float v, int i, int i1, CallbackInfo callbackInfo) {
        // TODO
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, new Identifier("mysticgemstones", "textures/gui/player_inventory_switch_tabs.png"));
        this.drawTexture(matrices, this.x, this.y - 28, 0, 0, 57, 32);
    }

    @Inject(method = "render", at = @At("TAIL"))
    public void render(MatrixStack matrices, int mouseX, int mouseY, float v, CallbackInfo callbackInfo) {
        DiffuseLighting.enableGuiDepthLighting();
        this.itemRenderer.renderInGuiWithOverrides(Items.CRAFTING_TABLE.getDefaultStack(), this.x + 6, this.y - 20);
        this.itemRenderer.renderInGuiWithOverrides(MysticGemstonesItems.AQUAMARINE_RING.getDefaultStack(), this.x + 35, this.y - 20);
        DiffuseLighting.disableGuiDepthLighting();
    }
}