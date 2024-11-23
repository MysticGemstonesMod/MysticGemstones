package xyz.domza.mystic_gemstones.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.domza.mystic_gemstones.Constant;
import xyz.domza.mystic_gemstones.item.ring.AquamarineRing;
import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesItem {
    public static final Map<Identifier, Item> ITEMS = new HashMap<>();

    public static final Item AQUAMARINE = register(Constant.AQUAMARINE, new Item(new Item.Settings()));
    public static final Item AQUAMARINE_RING = register(Constant.AQUAMARINE_RING, new AquamarineRing(new Item.Settings()));
    public static final Item AQUAMARINE_DUST = register(Constant.AQUAMARINE_DUST, new Item(new Item.Settings()));
    public static final Item POLISHED_AQUAMARINE = register(Constant.POLISHED_AQUAMARINE, new Item(new Item.Settings()));
    public static final Item RING = register(Constant.RING, new Item(new Item.Settings()));

    private static <T extends Item> T register(String id, T item) {
        ITEMS.put(new Identifier(Constant.MOD_ID, id), item);
        ItemGroupEvents.modifyEntriesEvent(MysticGemstonesItemGroup.MYSTIC_ITEM_GROUP).register(entries -> entries.add(item));
        return item;
    }

    public static void registerItems() {
        ITEMS.forEach((identifier, item) -> {
            Registry.register(Registries.ITEM, identifier, item);
        });
    }
}
