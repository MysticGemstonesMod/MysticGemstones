package xyz.mysticgemstones;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.item.MysticGemstonesItem;
import xyz.mysticgemstones.recipes.MysticGemstonesRecipes;
import xyz.mysticgemstones.statusEffects.MysticGemstonesStatusEffect;


public class MysticGemstones implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("mysticgemstones");

	@Override
	public void onInitialize() {
		MysticGemstonesBlock.register();
		MysticGemstonesBlock.registerEntity();
		MysticGemstonesItem.register();
		MysticGemstonesStatusEffect.register();
		MysticGemstonesRecipes.register();
	}
}
