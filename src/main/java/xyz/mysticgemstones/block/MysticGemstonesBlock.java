package xyz.mysticgemstones.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.mysticgemstones.Constant;
import xyz.mysticgemstones.block.entity.GemInfuserEntity;
import xyz.mysticgemstones.block.entity.StarstoneOreEntity;
import xyz.mysticgemstones.block.entity.StarstoneSandEntity;
import xyz.mysticgemstones.item.MysticGemstonesItem;
import xyz.mysticgemstones.item.StarstoneOreBlockItem;
import xyz.mysticgemstones.item.StarstoneSandBlockItem;

import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesBlock {
    public static final Map<Identifier, Block> BLOCKS = new HashMap<>();
    public static final Map<Identifier, BlockItem> BLOCK_ITEMS = new HashMap<>();

    // Add Blocks

    // Ore
    public static final Block STARSTONE_ORE = addBlock(Constant.STARSTONE_ORE, new StarstoneOre(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).luminance(StarstoneOre.getLightLevel())), true);
    public static final Block AQUAMARINE_ORE = addBlock(Constant.AQUAMARINE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), false);
    public static final Block JASPER_ORE = addBlock(Constant.JASPER_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), false);
    public static final Block ALEXANDRITE_ORE = addBlock(Constant.ALEXANDRITE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), false);
    public static final Block TOPAZ_ORE = addBlock(Constant.TOPAZ_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), false);
    public static final Block MALACHITE_ORE = addBlock(Constant.MALACHITE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), false);
    public static final Block WHITE_SAPPHIRE_ORE = addBlock(Constant.WHITE_SAPPHIRE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), false);
    public static final Block SAPPHIRE_ORE = addBlock(Constant.SAPPHIRE_ORE, new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F)), false);

    // Special
    public static final Block GEM_GRINDSTONE = addBlock(Constant.GEM_GRINDSTONE, new GemGrindstone(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F)), false);
    public static final Block ROCK_TUMBLER = addBlock(Constant.ROCK_TUMBLER, new RockTumbler(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F)), false);
    public static final Block GEM_CRAFT_STATION = addBlock(Constant.GEM_CRAFT_STATION, new GemCraftStation(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F)), false);
    public static final Block GEM_INFUSER = addBlock(Constant.GEM_INFUSER, new GemInfuser(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F)), false);

    // Sand
    public static final Block AQUAMARINE_SAND = addBlock(Constant.AQUAMARINE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final Block ALEXANDRITE_SAND = addBlock(Constant.ALEXANDRITE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final Block TOPAZ_SAND = addBlock(Constant.TOPAZ_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final Block JASPER_SAND = addBlock(Constant.JASPER_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final Block MALACHITE_SAND = addBlock(Constant.MALACHITE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final Block SAPPHIRE_SAND = addBlock(Constant.SAPPHIRE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final Block WHITE_SAPPHIRE_SAND = addBlock(Constant.WHITE_SAPPHIRE_SAND, new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)), false);
    public static final Block STARSTONE_SAND = addBlock(Constant.STARSTONE_SAND, new StarstoneSand(FabricBlockSettings.copyOf(Blocks.SAND).luminance(StarstoneSand.getLightLevel())), true);
    public static final Block AQUAMARINE_SAND_STONE = addBlock(Constant.AQUAMARINE_SAND_STONE, new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), false);
    public static final Block ALEXANDRITE_SAND_STONE = addBlock(Constant.ALEXANDRITE_SAND_STONE, new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), false);
    public static final Block TOPAZ_SAND_STONE = addBlock(Constant.TOPAZ_SAND_STONE, new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), false);
    public static final Block JASPER_SAND_STONE = addBlock(Constant.JASPER_SAND_STONE, new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), false);
    public static final Block MALACHITE_SAND_STONE = addBlock(Constant.MALACHITE_SAND_STONE, new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), false);
    public static final Block SAPPHIRE_SAND_STONE = addBlock(Constant.SAPPHIRE_SAND_STONE, new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), false);
    public static final Block WHITE_SAPPHIRE_SAND_STONE = addBlock(Constant.WHITE_SAPPHIRE_SAND_STONE, new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), false);
    public static final Block STARSTONE_SAND_STONE = addBlock(Constant.STARSTONE_SAND_STONE, new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), false);

    // Glass
    public static final Block HARDENED_AQUAMARINE_GLASS = addBlock(Constant.HARDENED_AQUAMARINE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block AQUAMARINE_GLASS = addBlock(Constant.AQUAMARINE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block HARDENED_ALEXANDRITE_GLASS = addBlock(Constant.HARDENED_ALEXANDRITE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block ALEXANDRITE_GLASS = addBlock(Constant.ALEXANDRITE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block HARDENED_TOPAZ_GLASS = addBlock(Constant.HARDENED_TOPAZ_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block TOPAZ_GLASS = addBlock(Constant.TOPAZ_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block HARDENED_JASPER_GLASS = addBlock(Constant.HARDENED_JASPER_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block JASPER_GLASS = addBlock(Constant.JASPER_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block HARDENED_MALACHITE_GLASS = addBlock(Constant.HARDENED_MALACHITE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block MALACHITE_GLASS = addBlock(Constant.MALACHITE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block HARDENED_SAPPHIRE_GLASS = addBlock(Constant.HARDENED_SAPPHIRE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block SAPPHIRE_GLASS = addBlock(Constant.SAPPHIRE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block HARDENED_WHITE_SAPPHIRE_GLASS = addBlock(Constant.HARDENED_WHITE_SAPPHIRE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block WHITE_SAPPHIRE_GLASS = addBlock(Constant.WHITE_SAPPHIRE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block HARDENED_STARSTONE_GLASS = addBlock(Constant.HARDENED_STARSTONE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);
    public static final Block STARSTONE_GLASS = addBlock(Constant.STARSTONE_GLASS, new GemGlass(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), false);


    // Add Blocks and their BlockItem
    public static <T extends Block> T addBlock(String id, T block, boolean blockItemHasCustomClass) {
        Identifier identifier = new Identifier(Constant.MOD_ID, id);
        BLOCKS.put(identifier, block);
        if (!blockItemHasCustomClass) {
            Registry.register(Registry.ITEM, identifier, new BlockItem(block, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
        }
        return block;
    }

    // Add Block Item for Starstone Ore
    public static final StarstoneOreBlockItem STARSTONE_ORE_ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.STARSTONE_ORE), new StarstoneOreBlockItem(STARSTONE_ORE, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final StarstoneSandBlockItem STARSTONE_SAND_ITEM = addBlockItem(new Identifier(Constant.MOD_ID, Constant.STARSTONE_SAND), new StarstoneSandBlockItem(STARSTONE_SAND, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));


    public static <T extends BlockItem> T addBlockItem(Identifier id, T blockitem) {
        BLOCK_ITEMS.put(id, blockitem);
        return blockitem;
    }

    // Register all
    public static void register() {
        BLOCKS.forEach((identifier, block) -> Registry.register(Registry.BLOCK, identifier, block));
        BLOCK_ITEMS.forEach((identifier, blockItem) -> Registry.register(Registry.ITEM, identifier, blockItem));
    }

    // Register Block Entity
    public static BlockEntityType<StarstoneOreEntity> STARSTONE_ORE_ENTITY;
    public static BlockEntityType<StarstoneSandEntity> STARSTONE_SAND_ENTITY;
    public static BlockEntityType<GemInfuserEntity> GEM_INFUSER_ENTITY;

    public static void registerEntity() {
        GEM_INFUSER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, Constant.GEM_INFUSER_ENTITY, FabricBlockEntityTypeBuilder.create(GemInfuserEntity::new, MysticGemstonesBlock.GEM_INFUSER).build(null));
        STARSTONE_ORE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, Constant.STARSTONE_ORE_ENTITY, FabricBlockEntityTypeBuilder.create(StarstoneOreEntity::new, MysticGemstonesBlock.STARSTONE_ORE).build(null));
        STARSTONE_SAND_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, Constant.STARSTONE_SAND_ENTITY, FabricBlockEntityTypeBuilder.create(StarstoneSandEntity::new, MysticGemstonesBlock.STARSTONE_SAND).build(null));
    }
}
