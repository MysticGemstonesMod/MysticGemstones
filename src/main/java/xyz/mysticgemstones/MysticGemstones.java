package xyz.mysticgemstones;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MysticGemstones implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("mysticgemstones");

	@Override
	public void onInitialize() {
		xyz.mysticgemstones.block.MysticGemstonesBlock.register();
		xyz.mysticgemstones.item.MysticGemstonesItem.register();
		xyz.mysticgemstones.block.entity.StarstoneOreEntity.RegisterEntity();
		LOGGER.info("Hello Fabric world!");
	}
}
