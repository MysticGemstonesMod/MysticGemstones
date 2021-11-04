package mysticgemstones.mysticgemstones.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MysticGemstonesBlock {

    // Add block
    public static final Block AQUAMARIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());
    public static final Block JASPER_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());
    public static final Block ALEXANDRITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());

    public static void AddAndRegisterBlocks() {

        // Register block
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "aquamarin_ore"), AQUAMARIN_ORE);
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "jasper_ore"), JASPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "alexandrite_ore"), ALEXANDRITE_ORE);

        // Register block item
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "aquamarin_ore"), new BlockItem(AQUAMARIN_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "jasper_ore"), new BlockItem(JASPER_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "alexandrite_ore"), new BlockItem(ALEXANDRITE_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    }
}
