package mysticgemstones.mysticgemstones.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MysticGemstonesBlock {



    public static void AddAndRegisterBlocks() {

        // Add block
        final Block AQUAMARIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F));

        // Register block
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "aquamarin_ore"), AQUAMARIN_ORE);

        // Register block item
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "aquamarin_ore"), new BlockItem(AQUAMARIN_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));


    }

}
