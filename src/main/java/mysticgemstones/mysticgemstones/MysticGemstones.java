package mysticgemstones.mysticgemstones;

import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import mysticgemstones.mysticgemstones.block.entity.StarstoneOreEntity;
import mysticgemstones.mysticgemstones.generation.OreGeneration;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;


public class MysticGemstones implements ModInitializer {


    @Override
    public void onInitialize() {

        MysticGemstonesBlock.AddAndRegisterBlocks();
        MysticGemstonesItem.AddAndRegisterItem();
        OreGeneration.RegisterOreGeneration();
        StarstoneOreEntity.RegisterEntity();


        // Move this to MysticGemstonesItem class
        FabricModelPredicateProviderRegistry.register(MysticGemstonesItem.RAW_STARSTONE, new Identifier("shining"), (itemStack, clientWorld, livingEntity, hmmmm) -> {
            if (/*If day time is between 21980 and 22350 return true else return false also delete this random clientWorld != clientWorld*/clientWorld != clientWorld) {
                // Use shiny texture
                return 1.0F;
            }
            // Use not shiny texture
            return 0.0F;
        });

    }
}
