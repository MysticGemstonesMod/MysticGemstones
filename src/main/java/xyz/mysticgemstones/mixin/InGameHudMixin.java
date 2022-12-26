package xyz.mysticgemstones.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
@Environment(EnvType.CLIENT)
public abstract class InGameHudMixin {

    @Shadow protected abstract PlayerEntity getCameraPlayer();

    @Shadow protected abstract void renderVignetteOverlay(Entity entity);

    @Inject(method = "renderStatusEffectOverlay", at = @At("HEAD"))
    public void renderStatusEffectOverlay(MatrixStack matrices, CallbackInfo ci) {
//        if (this.getCameraPlayer().hasSlowHungerEffect) { // TODO - Add Slow hunger bool var, getter and setter to Player Entity
//            renderAlexandriteCharmEffect();
//        }
    }

    private void renderAlexandriteCharmEffect() {
        this.renderVignetteOverlay(this.getCameraPlayer()); // Replace with some fancy UI overlay that indicades slow hunger loss
    }
}