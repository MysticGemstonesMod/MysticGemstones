package xyz.mysticgemstones.item;

import mysticgemstones.mysticgemstones.Constant;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.item.charms.AlexandriteCharm;
import xyz.mysticgemstones.item.charms.AquamarineCharm;
import xyz.mysticgemstones.item.charms.JasperCharm;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesItem {

    public static final Map<Identifier, Item> ITEMS = new HashMap<>();

    // Item group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(Constant.MOD_ID, "items"),
            () -> new ItemStack(MysticGemstonesBlock.AQUAMARINE_ORE));

    // Adds info about Items
    public static final Item AQUAMARINE_ITEM = registerItem(Constant.AQUAMARINE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_AQUAMARINE = registerItem(Constant.RAW_AQUAMARINE, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item JASPER_ITEM = registerItem(Constant.JASPER_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item AQUAMARINE_POWDER = registerItem(Constant.AQUAMARINE_POWDER, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item ALEXANDRITE_POWDER = registerItem(Constant.ALEXANDRITE_POWDER, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item JASPER_POWDER = registerItem(Constant.JASPER_POWDER, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_JASPER = registerItem(Constant.RAW_JASPER, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item ALEXANDRITE_ITEM = registerItem(Constant.ALEXANDRITE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_ALEXANDRITE = registerItem(Constant.RAW_ALEXANDRITE, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item STARSTONE_ITEM = registerItem(Constant.STARSTONE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final RawStarstone RAW_STARSTONE = registerItem(Constant.RAW_STARSTONE, new RawStarstone(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final StarstonePowder STARSTONE_POWDER = registerItem(Constant.STARSTONE_POWDER, new StarstonePowder(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final CondensedStarstonePowder CONDENSED_STARSTONE_POWDER = registerItem(Constant.CONDENSED_STARSTONE_POWDER, new CondensedStarstonePowder(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final AquamarineCharm AQUAMARINE_CHARM = registerItem(Constant.AQUAMARINE_CHARM, new AquamarineCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final AlexandriteCharm ALEXANDRITE_CHARM = registerItem(Constant.ALEXANDRITE_CHARM, new AlexandriteCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final JasperCharm JASPER_CHARM = registerItem(Constant.JASPER_CHARM, new JasperCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));

    // Puts info about item to ITEMS variable.
    public static <T extends Item> T registerItem(String id, T item) {
        ITEMS.put(new Identifier(Constant.MOD_ID, id), item);
        return item;
    }

    // Registers everything using information from ITEMS variable.
    public static void register() {
        ITEMS.forEach((identifier, item) -> Registry.register(Registry.ITEM, identifier, item));
    }
}
