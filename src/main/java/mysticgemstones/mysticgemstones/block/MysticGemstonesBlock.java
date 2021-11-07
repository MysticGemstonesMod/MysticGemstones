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
    public static final RockTumbler ROCK_TUMBLER = new RockTumbler(FabricBlockSettings.of(Material.STONE));
    public static final Block AQUAMARINE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());
    public static final Block JASPER_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());
    public static final Block ALEXANDRITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());

    public static void AddAndRegisterBlocks() {

        // Register block
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "aquamarine_ore"), AQUAMARINE_ORE);
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "jasper_ore"), JASPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "alexandrite_ore"), ALEXANDRITE_ORE);
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "rock_tumbler"), ROCK_TUMBLER);

        // Register block item
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "aquamarine_ore"), new BlockItem(AQUAMARINE_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "jasper_ore"), new BlockItem(JASPER_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "alexandrite_ore"), new BlockItem(ALEXANDRITE_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "rock_tumbler"), new BlockItem(ROCK_TUMBLER, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    }
}
