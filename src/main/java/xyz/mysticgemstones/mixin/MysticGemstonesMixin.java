package xyz.mysticgemstones.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.mysticgemstones.MysticGemstones;

@Mixin(TitleScreen.class)
public class MysticGemstonesMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		MysticGemstones.LOGGER.info("This line is printed by an hmmmmmm mod mixin!");
	}
}
