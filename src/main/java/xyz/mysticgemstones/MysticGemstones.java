package xyz.mysticgemstones;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.mysticgemstones.block.GemInfuserScreenHandler;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.item.MysticGemstonesItem;
import xyz.mysticgemstones.statusEffects.MysticGemstonesStatusEffect;


public class MysticGemstones implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("mysticgemstones");
	public static final ScreenHandlerType<GemInfuserScreenHandler> GEM_INFUSER_SCREEN_HANDLER;

	static {
		GEM_INFUSER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Constant.MOD_ID, "gem_infuser_screen"), GemInfuserScreenHandler::new);
	}

	@Override
	public void onInitialize() {
		MysticGemstonesBlock.register();
		MysticGemstonesBlock.registerEntity();
		MysticGemstonesItem.register();
		MysticGemstonesStatusEffect.register();
	}
}
