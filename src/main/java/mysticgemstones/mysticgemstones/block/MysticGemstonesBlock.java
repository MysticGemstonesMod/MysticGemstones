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

import java.util.function.ToIntFunction;

public class MysticGemstonesBlock {

    private static ToIntFunction<BlockState> lightLevel(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(StarstoneOre.SHINING) ? litLevel : 0;
        };
    }

    // Add block
    public static final StarstoneOre STARSTONE_ORE = new StarstoneOre(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).luminance(lightLevel(10)));
    public static final GemGrindstone GEM_GRINDSTONE = new GemGrindstone(FabricBlockSettings.of(Material.STONE).strength(3F, 6.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final RockTumbler ROCK_TUMBLER = new RockTumbler(FabricBlockSettings.of(Material.STONE).strength(3F, 6.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block AQUAMARINE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());
    public static final Block JASPER_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());
    public static final Block ALEXANDRITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F, 6.0F).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool());


    public static void AddAndRegisterBlocks() {

        // Register block
        Registry.register(Registry.BLOCK, new Identifier(Constant.MOD_ID, "aquamarine_ore"), AQUAMARINE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Constant.MOD_ID, "jasper_ore"), JASPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Constant.MOD_ID, "alexandrite_ore"), ALEXANDRITE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Constant.MOD_ID, "starstone_ore"), STARSTONE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Constant.MOD_ID, "rock_tumbler"), ROCK_TUMBLER);
        Registry.register(Registry.BLOCK, new Identifier(Constant.MOD_ID, "gem_grindstone"), GEM_GRINDSTONE);

        // Register block item
        Registry.register(Registry.ITEM, new Identifier(Constant.MOD_ID, "aquamarine_ore"), new BlockItem(AQUAMARINE_ORE, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Constant.MOD_ID, "jasper_ore"), new BlockItem(JASPER_ORE, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Constant.MOD_ID, "alexandrite_ore"), new BlockItem(ALEXANDRITE_ORE, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Constant.MOD_ID, "starstone_ore"), new StarstoneOreBlockItem(STARSTONE_ORE, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Constant.MOD_ID, "rock_tumbler"), new BlockItem(ROCK_TUMBLER, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Constant.MOD_ID, "gem_grindstone"), new BlockItem(GEM_GRINDSTONE, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    }
}
