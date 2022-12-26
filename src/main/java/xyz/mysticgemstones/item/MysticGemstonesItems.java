package xyz.mysticgemstones.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;
import xyz.mysticgemstones.item.charms.*;
import xyz.mysticgemstones.item.rings.*;

import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesItems {

    public static final Map<Identifier, Item> ITEMS = new HashMap<>();

    // Add items

    // Gems
    public static final Item AQUAMARINE_ITEM = registerItem(Constant.AQUAMARINE_ITEM, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item JASPER_ITEM = registerItem(Constant.JASPER_ITEM, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item TOPAZ_ITEM = registerItem(Constant.TOPAZ_ITEM, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item ALEXANDRITE_ITEM = registerItem(Constant.ALEXANDRITE_ITEM, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item WHITE_SAPPHIRE_ITEM = registerItem(Constant.WHITE_SAPPHIRE_ITEM, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item MALACHITE_ITEM = registerItem(Constant.MALACHITE_ITEM, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item SAPPHIRE_ITEM = registerItem(Constant.SAPPHIRE_ITEM, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item STARSTONE_ITEM = registerItem(Constant.STARSTONE_ITEM, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);

    // Gem dust
    public static final Item AQUAMARINE_DUST = registerItem(Constant.AQUAMARINE_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item ALEXANDRITE_DUST = registerItem(Constant.ALEXANDRITE_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item JASPER_DUST = registerItem(Constant.JASPER_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item TOPAZ_DUST = registerItem(Constant.TOPAZ_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item WHITE_SAPPHIRE_DUST = registerItem(Constant.WHITE_SAPPHIRE_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item MALACHITE_DUST = registerItem(Constant.MALACHITE_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item SAPPHIRE_DUST = registerItem(Constant.SAPPHIRE_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final Item STARSTONE_DUST = registerItem(Constant.STARSTONE_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);

    // Raw gems
    public static final RawGemItem RAW_AQUAMARINE = registerItem(Constant.RAW_AQUAMARINE, new RawGemItem(new FabricItemSettings(), MysticGemstonesItems.AQUAMARINE_ITEM, MysticGemstonesItems.AQUAMARINE_DUST), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final RawGemItem RAW_JASPER = registerItem(Constant.RAW_JASPER, new RawGemItem(new FabricItemSettings(), MysticGemstonesItems.JASPER_ITEM, MysticGemstonesItems.JASPER_DUST), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final RawGemItem RAW_ALEXANDRITE = registerItem(Constant.RAW_ALEXANDRITE, new RawGemItem(new FabricItemSettings(), MysticGemstonesItems.ALEXANDRITE_ITEM, MysticGemstonesItems.ALEXANDRITE_DUST), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final RawGemItem RAW_TOPAZ = registerItem(Constant.RAW_TOPAZ, new RawGemItem(new FabricItemSettings(), MysticGemstonesItems.TOPAZ_ITEM, MysticGemstonesItems.TOPAZ_DUST), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final RawGemItem RAW_MALACHITE = registerItem(Constant.RAW_MALACHITE, new RawGemItem(new FabricItemSettings(), MysticGemstonesItems.MALACHITE_ITEM, MysticGemstonesItems.MALACHITE_DUST), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final RawGemItem RAW_WHITE_SAPPHIRE = registerItem(Constant.RAW_WHITE_SAPPHIRE, new RawGemItem(new FabricItemSettings(), MysticGemstonesItems.WHITE_SAPPHIRE_ITEM, MysticGemstonesItems.WHITE_SAPPHIRE_DUST, 30, 12, 3), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final RawGemItem RAW_SAPPHIRE = registerItem(Constant.RAW_SAPPHIRE, new RawGemItem(new FabricItemSettings(), MysticGemstonesItems.SAPPHIRE_ITEM, MysticGemstonesItems.SAPPHIRE_DUST, 30, 12, 3), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);
    public static final RawStarstone RAW_STARSTONE = registerItem(Constant.RAW_STARSTONE, new RawStarstone(new FabricItemSettings(), MysticGemstonesItems.STARSTONE_ITEM, MysticGemstonesItems.STARSTONE_DUST, 20, 15, 2), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);

    // Condensed dust
    public static final Item CONDENSED_STARSTONE_DUST = registerItem(Constant.CONDENSED_STARSTONE_DUST, new Item(new FabricItemSettings()), MysticGemstonesItemGroups.ITEM_GROUP_GEMS);

    // Food
    public static final AlexandriteApple ALEXANDRITE_APPLE = registerItem(Constant.ALEXANDRITE_APPLE, new AlexandriteApple(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1.6f).alwaysEdible().build())));

    // Charms
    public static final Item EMPTY_CHARM = registerItem(Constant.EMPTY_CHARM, new Item(new FabricItemSettings()));
    public static final AquamarineCharm AQUAMARINE_CHARM = registerItem(Constant.AQUAMARINE_CHARM, new AquamarineCharm(new FabricItemSettings().maxCount(1)));
    public static final AlexandriteCharm ALEXANDRITE_CHARM = registerItem(Constant.ALEXANDRITE_CHARM, new AlexandriteCharm(new FabricItemSettings().maxCount(1)));
    public static final JasperCharm JASPER_CHARM = registerItem(Constant.JASPER_CHARM, new JasperCharm(new FabricItemSettings().maxCount(1)));
    public static final TopazCharm TOPAZ_CHARM = registerItem(Constant.TOPAZ_CHARM, new TopazCharm(new FabricItemSettings().maxCount(1)));
    public static final MalachiteCharm MALACHITE_CHARM = registerItem(Constant.MALACHITE_CHARM, new MalachiteCharm(new FabricItemSettings().maxCount(1)));
    public static final SapphireCharm SAPPHIRE_CHARM = registerItem(Constant.SAPPHIRE_CHARM, new SapphireCharm(new FabricItemSettings().maxCount(1)));
    public static final WhiteSapphireCharm WHITE_SAPPHIRE_CHARM = registerItem(Constant.WHITE_SAPPHIRE_CHARM, new WhiteSapphireCharm(new FabricItemSettings().maxCount(1)));
    public static final StarstoneCharm STARSTONE_CHARM = registerItem(Constant.STARSTONE_CHARM, new StarstoneCharm(new FabricItemSettings().maxCount(1)));

    // Music discs // TODO
//    public static final MusicDiscAquamarine MUSIC_DISC_AQUAMARINE = registerItem(Constant.MUSIC_DISC_AQUAMARINE, new MusicDiscAquamarine(14, MysticGemstonesSoundEvents.AQUAMARINE_DISC_SOUND_EVENT, new FabricItemSettings().maxCount(1)));
//    public static final MusicDiscMalachite MUSIC_DISC_MALACHITE = registerItem(Constant.MUSIC_DISC_MALACHITE, new MusicDiscMalachite(15, MysticGemstonesSoundEvents.MALACHITE_DISC_SOUND_EVENT, new FabricItemSettings().maxCount(1)));

    // Rings
    public static final Item EMPTY_RING = registerItem(Constant.EMPTY_RING, new Item(new FabricItemSettings()));
    public static final AlexandriteRing ALEXANDRITE_RING = registerItem(Constant.ALEXANDRITE_RING, new AlexandriteRing(new FabricItemSettings().maxDamage(6)));
    public static final AquamarineRing AQUAMARINE_RING = registerItem(Constant.AQUAMARINE_RING, new AquamarineRing(new FabricItemSettings().maxDamage(6)));
    public static final JasperRing JASPER_RING = registerItem(Constant.JASPER_RING, new JasperRing(new FabricItemSettings().maxDamage(6)));
    public static final MalachiteRing MALACHITE_RING = registerItem(Constant.MALACHITE_RING, new MalachiteRing(new FabricItemSettings().maxDamage(10)));
    public static final TopazRing TOPAZ_RING = registerItem(Constant.TOPAZ_RING, new TopazRing(new FabricItemSettings().maxDamage(10)));
    public static final SapphireRing SAPPHIRE_RING = registerItem(Constant.SAPPHIRE_RING, new SapphireRing(new FabricItemSettings().maxDamage(10)));
    public static final WhiteSapphireRing WHITE_SAPPHIRE_RING = registerItem(Constant.WHITE_SAPPHIRE_RING, new WhiteSapphireRing(new FabricItemSettings().maxDamage(10)));
    public static final StarstoneRing STARSTONE_RING = registerItem(Constant.STARSTONE_RING, new StarstoneRing(new FabricItemSettings().maxDamage(16)));

    // Random
    public static final Item GEM_BAG = registerItem(Constant.GEM_BAG, new GemBag(new FabricItemSettings().maxCount(1)));
    public static final Item DARK_CLOTH = registerItem(Constant.DARK_CLOTH, new Item(new FabricItemSettings()));
    public static final Item GEM_BOOK = registerItem(Constant.GEM_BOOK, new GemBook(new FabricItemSettings()));



    // Puts info about item to ITEMS variable.
    public static <T extends Item> T registerItem(String id, T item) {
        return registerItem(id, item, MysticGemstonesItemGroups.ITEM_GROUP_ITEMS);
    }

    public static <T extends Item> T registerItem(String id, T item, ItemGroup itemGroup) {
        ITEMS.put(new Identifier(Constant.MOD_ID, id), item);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
        return item;
    }

    // Registers everything using information from ITEMS variable.
    public static void register() {
        ITEMS.forEach((identifier, item) -> Registry.register(Registries.ITEM, identifier, item));
    }
}
