package mysticgemstones.mysticgemstones.item;

import mysticgemstones.mysticgemstones.Constant;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesItem {

    public static final Map<Identifier, Item> ITEMS = new HashMap<>();

    // Adds info about Items
    public static final Item AQUAMARINE_ITEM = registerItem(Constant.AQUAMARINE_ITEM, new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item RAW_AQUAMARINE = registerItem(Constant.RAW_AQUAMARINE, new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item JASPER_ITEM = registerItem(Constant.JASPER_ITEM, new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item RAW_JASPER = registerItem(Constant.RAW_JASPER, new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item ALEXANDRITE_ITEM = registerItem(Constant.ALEXANDRITE_ITEM, new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item RAW_ALEXANDRITE = registerItem(Constant.RAW_ALEXANDRITE, new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item STARSTONE_ITEM = registerItem(Constant.STARSTONE_ITEM, new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item JASPER_POWDER = registerItem(Constant.JASPER_POWDER, new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final RawStarstone RAW_STARSTONE = registerItem(Constant.RAW_STARSTONE, new RawStarstone(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final StarstoneDust STARSTONE_DUST = registerItem(Constant.STARSTONE_DUST, new StarstoneDust(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final CondensedStarstoneDust CONDENSED_STARSTONE_DUST = registerItem(Constant.CONDENSED_STARSTONE_DUST, new CondensedStarstoneDust(new FabricItemSettings().group(ItemGroup.MATERIALS)));

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
