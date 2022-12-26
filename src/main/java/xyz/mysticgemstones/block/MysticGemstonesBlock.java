package xyz.mysticgemstones.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;
import xyz.mysticgemstones.block.entity.GemInfuserEntity;
import xyz.mysticgemstones.block.entity.StarstoneOreEntity;
import xyz.mysticgemstones.block.entity.StarstoneSandEntity;
import xyz.mysticgemstones.item.MysticGemstonesItemGroups;
import xyz.mysticgemstones.item.StarstoneOreBlockItem;

import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesBlock {
    public static final Map<Identifier, Block> BLOCKS = new HashMap<>();
    public static final Map<Identifier, BlockItem> BLOCK_ITEMS = new HashMap<>();

    // Add Blocks

    // Ore
    public static final Block STARSTONE_ORE = addBlock(Constant.STARSTONE_ORE, new StarstoneOre(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).luminance(StarstoneOre.getLightLevel())), false);
    public static final Block AQUAMARINE_ORE = addBlock(Constant.AQUAMARINE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), true);
    public static final Block RICH_AQUAMARINE_ORE = addBlock(Constant.RICH_AQUAMARINE_ORE, new RichAquamarineOre(FabricBlockSettings.of(Material.STONE).strength(1.0F, 2.0F)), true);
    public static final Block JASPER_ORE = addBlock(Constant.JASPER_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), true);
    public static final Block ALEXANDRITE_ORE = addBlock(Constant.ALEXANDRITE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), true);
    public static final Block TOPAZ_ORE = addBlock(Constant.TOPAZ_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), true);
    public static final Block MALACHITE_ORE = addBlock(Constant.MALACHITE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), true);
    public static final Block WHITE_SAPPHIRE_ORE = addBlock(Constant.WHITE_SAPPHIRE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), true);
    public static final Block SAPPHIRE_ORE = addBlock(Constant.SAPPHIRE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), true);

    // Special
    public static final Block GEM_GRINDSTONE = addBlock(Constant.GEM_GRINDSTONE, new GemGrindstone(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F)), false);
    public static final Block ROCK_TUMBLER = addBlock(Constant.ROCK_TUMBLER, new RockTumbler(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F)), false);
    public static final Block JEWELRY_WORKBENCH = addBlock(Constant.JEWELRY_WORKBENCH, new JewelryWorkbench(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F)), false);
    public static final Block GEM_INFUSER = addBlock(Constant.GEM_INFUSER, new GemInfuser(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F)), false);

    // Add Blocks and their BlockItem
    public static <T extends Block> T addBlock(String id, T block, boolean addBlockItem) {
        Identifier identifier = new Identifier(Constant.MOD_ID, id);
        BLOCKS.put(identifier, block);
        if (addBlockItem) {
            Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
            ItemGroupEvents.modifyEntriesEvent(MysticGemstonesItemGroups.ITEM_GROUP_GEMS).register(entries -> entries.add(block.asItem()));
        }
        return block;
    }

    public static <T extends BlockItem> T addBlockItem(Identifier id, T blockItem) {
        BLOCK_ITEMS.put(id, blockItem);
        return blockItem;
    }

    // Register all
    public static void register() {
        BLOCKS.forEach((identifier, block) -> Registry.register(Registries.BLOCK, identifier, block));
        BLOCK_ITEMS.forEach((identifier, blockItem) -> Registry.register(Registries.ITEM, identifier, blockItem));
    }

    // Add block items for special blocks
    public static final StarstoneOreBlockItem STARSTONE_ORE_ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.STARSTONE_ORE), new StarstoneOreBlockItem(STARSTONE_ORE, new FabricItemSettings()));
    public static final BlockItem GEM_GRINDSTONE_ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.GEM_GRINDSTONE), new BlockItem(GEM_GRINDSTONE, new FabricItemSettings()));
    public static final BlockItem JEWELRY_WORKBENCH_ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.JEWELRY_WORKBENCH), new BlockItem(JEWELRY_WORKBENCH, new FabricItemSettings()));
    public static final BlockItem ROCK_TUMBLER_ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.ROCK_TUMBLER), new BlockItem(ROCK_TUMBLER, new FabricItemSettings()));
    public static final BlockItem GEM_INFUSER_ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.GEM_INFUSER), new BlockItem(GEM_INFUSER, new FabricItemSettings()));



    // Register Block Entity
    public static BlockEntityType<StarstoneOreEntity> STARSTONE_ORE_ENTITY;
    public static BlockEntityType<StarstoneSandEntity> STARSTONE_SAND_ENTITY;
    public static BlockEntityType<GemInfuserEntity> GEM_INFUSER_ENTITY;

    public static void registerEntity() {
        GEM_INFUSER_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Constant.GEM_INFUSER_ENTITY, FabricBlockEntityTypeBuilder.create(GemInfuserEntity::new, MysticGemstonesBlock.GEM_INFUSER).build(null));
        STARSTONE_ORE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Constant.STARSTONE_ORE_ENTITY, FabricBlockEntityTypeBuilder.create(StarstoneOreEntity::new, MysticGemstonesBlock.STARSTONE_ORE).build(null));
    }
}
