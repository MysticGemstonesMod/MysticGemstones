package mysticgemstones.mysticgemstones.block;

import mysticgemstones.mysticgemstones.Constant;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import mysticgemstones.mysticgemstones.item.StarstoneOreBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class MysticGemstonesBlock {

    public static final Map<Identifier, Block> BLOCKS = new HashMap<>();
    public static final Map<Identifier, BlockItem> BLOCK_ITEMS = new HashMap<>();

    // Add Block
    public static final StarstoneOre STARSTONE_ORE = addBlock(Constant.STARSTONE_ORE, new StarstoneOre(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).luminance(lightLevel(10))), true);
    public static final GemGrindstone GEM_GRINDSTONE = addBlock(Constant.GEM_GRINDSTONE, new GemGrindstone(FabricBlockSettings.of(Material.STONE).strength(3F, 6.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool()));
    public static final RockTumbler ROCK_TUMBLER = addBlock(Constant.ROCK_TUMBLER, new RockTumbler(FabricBlockSettings.of(Material.STONE).strength(3F, 6.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool()));
    public static final Block AQUAMARINE_ORE = addBlock(Constant.AQUAMARINE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()));
    public static final Block JASPER_ORE = addBlock(Constant.JASPER_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()));
    public static final Block ALEXANDRITE_ORE = addBlock(Constant.ALEXANDRITE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()));

    // Add Block Item with custom class
    public static final StarstoneOreBlockItem STARSTONE_ORE__ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.STARSTONE_ORE), new StarstoneOreBlockItem(STARSTONE_ORE, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));

    // Add Blocks and their BlockItem
    public static <T extends Block> T addBlock(String id, T block) {
        Identifier identifier = new Identifier(Constant.MOD_ID, id);
        BLOCKS.put(identifier, block);
        Registry.register(Registry.ITEM, identifier, new BlockItem(block, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
        return block;
    }

    // Add Blocks without BlockItem
    public static <T extends Block> T addBlock(String id, T block, boolean yes) {
        Identifier identifier = new Identifier(Constant.MOD_ID, id);
        BLOCKS.put(identifier, block);
        return block;
    }

    // Add BlockItems with custom class
    public static <T extends BlockItem> T addBlockItem(Identifier id, T blockitem) {
        BLOCK_ITEMS.put(id, blockitem);
        return blockitem;
    }


    // Register all
    public static void register() {
        BLOCKS.forEach((identifier, block) -> Registry.register(Registry.BLOCK, identifier, block));
        BLOCK_ITEMS.forEach((identifier, blockItem) -> Registry.register(Registry.ITEM, identifier, blockItem));
    }

    // Change Starstone Ore light level based on blockstate... Should probably move to Starstone Ore class
    private static ToIntFunction<BlockState> lightLevel(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(StarstoneOre.SHINING) ? litLevel : 0;
        };
    }
}
