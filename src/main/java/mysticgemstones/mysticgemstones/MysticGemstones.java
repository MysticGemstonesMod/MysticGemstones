package mysticgemstones.mysticgemstones;

import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import mysticgemstones.mysticgemstones.block.StarstoneOre;
import mysticgemstones.mysticgemstones.block.entity.StarstoneOreEntity;
import mysticgemstones.mysticgemstones.generation.OreGeneration;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.fabricmc.api.ModInitializer;


public class MysticGemstones implements ModInitializer {


    @Override
    public void onInitialize() {

        MysticGemstonesBlock.AddAndRegisterBlocks();
        MysticGemstonesItem.AddAndRegisterItem();
        OreGeneration.RegisterOreGeneration();
        StarstoneOreEntity.RegisterEntity();
        StarstoneOre.setShiningNotShining();

    }
}
