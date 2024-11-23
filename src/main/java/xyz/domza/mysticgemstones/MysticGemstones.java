package xyz.domza.mysticgemstones;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.domza.mysticgemstones.item.MysticGemstonesItem;
import xyz.domza.mysticgemstones.item.MysticGemstonesItemGroup;
import xyz.domza.mysticgemstones.block.MysticGemstonesBlock;
import xyz.domza.mysticgemstones.recipe.MysticGemstonesRecipe;

public class MysticGemstones implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(Constant.MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Mystic Gemstones loading...");
		MysticGemstonesItemGroup.registerItemGroups();
		MysticGemstonesItem.registerItems();
		MysticGemstonesRecipe.registerRecipes();
		MysticGemstonesBlock.registerBlocks();
	}
}