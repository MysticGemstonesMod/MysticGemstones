package xyz.domza.mystic_gemstones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.domza.mystic_gemstones.item.MysticGemstonesItem;
import xyz.domza.mystic_gemstones.item.MysticGemstonesItemGroup;
import xyz.domza.mystic_gemstones.block.MysticGemstonesBlock;
import xyz.domza.mystic_gemstones.recipe.MysticGemstonesRecipe;

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