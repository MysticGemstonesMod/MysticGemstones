package mysticgemstones.mysticgemstones;

import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import mysticgemstones.mysticgemstones.block.entity.StarstoneOreEntity;
import mysticgemstones.mysticgemstones.generation.OreGeneration;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;


public class MysticGemstones implements ModInitializer {

    public static BlockEntityType<StarstoneOreEntity> STARSTONE_ORE_ENTITY;

    @Override
    public void onInitialize() {

        STARSTONE_ORE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "mysticgemstones:starstone_ore_entity", FabricBlockEntityTypeBuilder.create(StarstoneOreEntity::new, MysticGemstonesBlock.STARSTONE_ORE).build(null));

        MysticGemstonesBlock.AddAndRegisterBlocks();
        MysticGemstonesItem.AddAndRegisterItem();
        OreGeneration.RegisterOreGeneration();
    }
}
