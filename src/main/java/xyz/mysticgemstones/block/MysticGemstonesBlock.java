package xyz.mysticgemstones.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.mysticgemstones.Constant;
import xyz.mysticgemstones.item.MysticGemstonesItem;
import xyz.mysticgemstones.item.StarstoneOreBlockItem;

import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesBlock {

    public static final Map<Identifier, Block> BLOCKS = new HashMap<>();
    public static final Map<Identifier, BlockItem> BLOCK_ITEMS = new HashMap<>();

    // Add Blocks

    // Ore
    public static final StarstoneOre STARSTONE_ORE = addBlock(Constant.STARSTONE_ORE, new StarstoneOre(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).luminance(StarstoneOre.getLightLevel())), true);
    public static final Block AQUAMARINE_ORE = addBlock(Constant.AQUAMARINE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block JASPER_ORE = addBlock(Constant.JASPER_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block ALEXANDRITE_ORE = addBlock(Constant.ALEXANDRITE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block TOPAZ_ORE = addBlock(Constant.TOPAZ_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block MALACHITE_ORE = addBlock(Constant.MALACHITE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block WHITE_SAPPHIRE_ORE = addBlock(Constant.WHITE_SAPPHIRE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);
    public static final Block SAPPHIRE_ORE = addBlock(Constant.SAPPHIRE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()), false);

    // Special
    public static final GemGrindstone GEM_GRINDSTONE = addBlock(Constant.GEM_GRINDSTONE, new GemGrindstone(FabricBlockSettings.of(Material.STONE).strength(3F, 6.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool()), false);
    public static final RockTumbler ROCK_TUMBLER = addBlock(Constant.ROCK_TUMBLER, new RockTumbler(FabricBlockSettings.of(Material.STONE).strength(3F, 6.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool()), false);

    // Sand
    public static final FallingBlock AQUAMARINE_SAND = addBlock(Constant.AQUAMARINE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final FallingBlock ALEXANDRITE_SAND = addBlock(Constant.ALEXANDRITE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final FallingBlock TOPAZ_SAND = addBlock(Constant.TOPAZ_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final FallingBlock JASPER_SAND = addBlock(Constant.JASPER_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final FallingBlock MALACHITE_SAND = addBlock(Constant.MALACHITE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final FallingBlock SAPPHIRE_SAND = addBlock(Constant.SAPPHIRE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final FallingBlock WHITE_SAPPHIRE_SAND = addBlock(Constant.WHITE_SAPPHIRE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);


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
}
