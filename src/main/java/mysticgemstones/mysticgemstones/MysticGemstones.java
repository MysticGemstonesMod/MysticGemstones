package mysticgemstones.mysticgemstones;

import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.fabricmc.api.ModInitializer;

public class MysticGemstones implements ModInitializer {


    @Override
    public void onInitialize() {

        MysticGemstonesBlock.AddAndRegisterBlocks();
        MysticGemstonesItem.AddAndRegisterItem();

    }
}
