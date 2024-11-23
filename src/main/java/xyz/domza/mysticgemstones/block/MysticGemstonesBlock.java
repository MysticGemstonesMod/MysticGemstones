package xyz.domza.mysticgemstones.block;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import xyz.domza.mysticgemstones.Constant;
import xyz.domza.mysticgemstones.item.MysticGemstonesItemGroup;
import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesBlock {
    public static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    public static final Block AQUAMARINE_ORE =
            register(Constant.AQUAMARINE_ORE, new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.STONE_GRAY)
                            .instrument(Instrument.BASEDRUM)
                            .requiresTool()
                            .strength(3.0f, 3.0f)));

    public static final Block GEM_GRINDSTONE = register(Constant.GEM_GRINDSTONE, new GemGrindstone(AbstractBlock.Settings.create()));
    public static final Block GEM_COMPRESSOR = register(Constant.GEM_COMPRESSOR, new Block(AbstractBlock.Settings.create()));

    private static <T extends Block> T register(String id, T block) {
        BLOCKS.put(new Identifier(Constant.MOD_ID, id), block);
        return block;
    }

    public static void registerBlocks() {
        BLOCKS.forEach((identifier, block) -> {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());

            Registry.register(Registries.BLOCK, identifier, block);
            Registry.register(Registries.ITEM, identifier, blockItem);

            ItemGroupEvents.modifyEntriesEvent(MysticGemstonesItemGroup.MYSTIC_ITEM_GROUP).register(entries -> entries.add(blockItem));
        });
     }
}
