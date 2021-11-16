package mysticgemstones.mysticgemstones;

import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import mysticgemstones.mysticgemstones.block.entity.StarstoneOreEntity;
import mysticgemstones.mysticgemstones.generation.OreGeneration;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.fabricmc.api.ModInitializer;


public class MysticGemstones implements ModInitializer {


    @Override
    public void onInitialize() {

        MysticGemstonesBlock.register();
        MysticGemstonesItem.register();
        OreGeneration.RegisterOreGeneration();
        StarstoneOreEntity.RegisterEntity();
    }
}
