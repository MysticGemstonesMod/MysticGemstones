package mysticgemstones.mysticgemstones.block;

import mysticgemstones.mysticgemstones.Constant;
import mysticgemstones.mysticgemstones.block.sand.AlexandriteSand;
import mysticgemstones.mysticgemstones.block.sand.AquamarineSand;
import mysticgemstones.mysticgemstones.block.sand.JasperSand;
import mysticgemstones.mysticgemstones.block.sand.TopazSand;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import mysticgemstones.mysticgemstones.item.StarstoneOreBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
    public static final GemGrindstone GEM_GRINDSTONE = addBlock(Constant.GEM_GRINDSTONE, new GemGrindstone(FabricBlockSettings.of(Material.STONE).strength(3F, 6.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool()), false);
    public static final RockTumbler ROCK_TUMBLER = addBlock(Constant.ROCK_TUMBLER, new RockTumbler(FabricBlockSettings.of(Material.STONE).strength(3F, 6.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool()), false);
    public static final AquamarineSand AQUAMARINE_SAND = addBlock(Constant.AQUAMARINE_SAND, new AquamarineSand(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final AlexandriteSand ALEXANDRITE_SAND = addBlock(Constant.ALEXANDRITE_SAND, new AlexandriteSand(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final TopazSand TOPAZ_SAND = addBlock(Constant.TOPAZ_SAND, new TopazSand(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final JasperSand JASPER_SAND = addBlock(Constant.JASPER_SAND, new JasperSand(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final Block AQUAMARINE_ORE = addBlock(Constant.AQUAMARINE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block JASPER_ORE = addBlock(Constant.JASPER_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block ALEXANDRITE_ORE = addBlock(Constant.ALEXANDRITE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block TOPAZ_ORE = addBlock(Constant.TOPAZ_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);

    // Add Blocks and their BlockItem
    public static <T extends Block> T addBlock(String id, T block, boolean itemHasCustomClass) {
        Identifier identifier = new Identifier(Constant.MOD_ID, id);
        BLOCKS.put(identifier, block);
        if (!itemHasCustomClass) {
            Registry.register(Registry.ITEM, identifier, new BlockItem(block, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
        }
        return block;
    }

    // Add Block Item with custom class
    public static final StarstoneOreBlockItem STARSTONE_ORE__ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.STARSTONE_ORE), new StarstoneOreBlockItem(STARSTONE_ORE, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));

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
