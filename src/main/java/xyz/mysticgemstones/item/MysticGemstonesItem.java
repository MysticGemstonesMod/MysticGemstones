package xyz.mysticgemstones.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.mysticgemstones.Constant;
import xyz.mysticgemstones.SoundEventMysticGemstones;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.item.charms.*;
import xyz.mysticgemstones.item.discs.MusicDiscAquamarine;
import xyz.mysticgemstones.item.discs.MusicDiscMalachite;
import xyz.mysticgemstones.item.rings.*;

import java.util.HashMap;
import java.util.Map;

public class MysticGemstonesItem {

    public static final Map<Identifier, Item> ITEMS = new HashMap<>();

    // Item group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(Constant.MOD_ID, "items"),
            () -> new ItemStack(MysticGemstonesBlock.AQUAMARINE_ORE));


    // Add items

    // Gems
    public static final Item AQUAMARINE_ITEM = registerItem(Constant.AQUAMARINE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item JASPER_ITEM = registerItem(Constant.JASPER_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item TOPAZ_ITEM = registerItem(Constant.TOPAZ_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item ALEXANDRITE_ITEM = registerItem(Constant.ALEXANDRITE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item WHITE_SAPPHIRE_ITEM = registerItem(Constant.WHITE_SAPPHIRE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item MALACHITE_ITEM = registerItem(Constant.MALACHITE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item SAPPHIRE_ITEM = registerItem(Constant.SAPPHIRE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item STARSTONE_ITEM = registerItem(Constant.STARSTONE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));

    // Gem dust
    public static final Item AQUAMARINE_DUST = registerItem(Constant.AQUAMARINE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item ALEXANDRITE_DUST = registerItem(Constant.ALEXANDRITE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item JASPER_DUST = registerItem(Constant.JASPER_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item TOPAZ_DUST = registerItem(Constant.TOPAZ_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item WHITE_SAPPHIRE_DUST = registerItem(Constant.WHITE_SAPPHIRE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item MALACHITE_DUST = registerItem(Constant.MALACHITE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item SAPPHIRE_DUST = registerItem(Constant.SAPPHIRE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item STARSTONE_DUST = registerItem(Constant.STARSTONE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));

    // Raw gems
    public static final RawGemItem RAW_AQUAMARINE = registerItem(Constant.RAW_AQUAMARINE, new RawGemItem(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP), MysticGemstonesItem.AQUAMARINE_ITEM, MysticGemstonesItem.AQUAMARINE_DUST));
    public static final RawGemItem RAW_JASPER = registerItem(Constant.RAW_JASPER, new RawGemItem(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP), MysticGemstonesItem.JASPER_ITEM, MysticGemstonesItem.JASPER_DUST));
    public static final RawGemItem RAW_ALEXANDRITE = registerItem(Constant.RAW_ALEXANDRITE, new RawGemItem(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP), MysticGemstonesItem.ALEXANDRITE_ITEM, MysticGemstonesItem.ALEXANDRITE_DUST));
    public static final RawGemItem RAW_TOPAZ = registerItem(Constant.RAW_TOPAZ, new RawGemItem(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP), MysticGemstonesItem.TOPAZ_ITEM, MysticGemstonesItem.TOPAZ_DUST));
    public static final RawGemItem RAW_MALACHITE = registerItem(Constant.RAW_MALACHITE, new RawGemItem(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP), MysticGemstonesItem.MALACHITE_ITEM, MysticGemstonesItem.MALACHITE_DUST));
    public static final RawGemItem RAW_WHITE_SAPPHIRE = registerItem(Constant.RAW_WHITE_SAPPHIRE, new RawGemItem(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP), MysticGemstonesItem.WHITE_SAPPHIRE_ITEM, MysticGemstonesItem.WHITE_SAPPHIRE_DUST, 30, 12, 3));
    public static final RawGemItem RAW_SAPPHIRE = registerItem(Constant.RAW_SAPPHIRE, new RawGemItem(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP), MysticGemstonesItem.SAPPHIRE_ITEM, MysticGemstonesItem.SAPPHIRE_DUST, 30, 12, 3));
    public static final RawStarstone RAW_STARSTONE = registerItem(Constant.RAW_STARSTONE, new RawStarstone(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP), MysticGemstonesItem.STARSTONE_ITEM, MysticGemstonesItem.STARSTONE_DUST, 20, 15, 2));

    // Condensed dust
    public static final Item CONDENSED_STARSTONE_DUST = registerItem(Constant.CONDENSED_STARSTONE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));

    // Food
    public static final AlexandriteApple ALEXANDRITE_APPLE = registerItem(Constant.ALEXANDRITE_APPLE, new AlexandriteApple(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.6f).alwaysEdible().build())));

    // Charms
    public static final AquamarineCharm AQUAMARINE_CHARM = registerItem(Constant.AQUAMARINE_CHARM, new AquamarineCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final AlexandriteCharm ALEXANDRITE_CHARM = registerItem(Constant.ALEXANDRITE_CHARM, new AlexandriteCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final JasperCharm JASPER_CHARM = registerItem(Constant.JASPER_CHARM, new JasperCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final TopazCharm TOPAZ_CHARM = registerItem(Constant.TOPAZ_CHARM, new TopazCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final MalachiteCharm MALACHITE_CHARM = registerItem(Constant.MALACHITE_CHARM, new MalachiteCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final SapphireCharm SAPPHIRE_CHARM = registerItem(Constant.SAPPHIRE_CHARM, new SapphireCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final WhiteSapphireCharm WHITE_SAPPHIRE_CHARM = registerItem(Constant.WHITE_SAPPHIRE_CHARM, new WhiteSapphireCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));

    // Music discs
    public static final MusicDiscAquamarine MUSIC_DISC_AQUAMARINE = registerItem(Constant.MUSIC_DISC_AQUAMARINE, new MusicDiscAquamarine(14, SoundEventMysticGemstones.AQUAMARINE_DISC_SOUND_EVENT, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final MusicDiscMalachite MUSIC_DISC_MALACHITE = registerItem(Constant.MUSIC_DISC_MALACHITE, new MusicDiscMalachite(15, SoundEventMysticGemstones.MALACHITE_DISC_SOUND_EVENT, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));

    // Rings
    public static final AlexandriteRing ALEXANDRITE_RING = registerItem(Constant.ALEXANDRITE_RING, new AlexandriteRing(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final AquamarineRing AQUAMARINE_RING = registerItem(Constant.AQUAMARINE_RING, new AquamarineRing(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final JasperRing JASPER_RING = registerItem(Constant.JASPER_RING, new JasperRing(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final MalachiteRing MALACHITE_RING = registerItem(Constant.MALACHITE_RING, new MalachiteRing(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final TopazRing TOPAZ_RING = registerItem(Constant.TOPAZ_RING, new TopazRing(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final SapphireRing SAPPHIRE_RING = registerItem(Constant.SAPPHIRE_RING, new SapphireRing(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final WhiteSapphireRing WHITE_SAPPHIRE_RING = registerItem(Constant.WHITE_SAPPHIRE_RING, new WhiteSapphireRing(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));

    // Random
    public static final GemBag GEM_BAG = registerItem(Constant.GEM_BAG, new GemBag(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final Item DARK_CLOTH = registerItem(Constant.DARK_CLOTH, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item EMPTY_RING = registerItem(Constant.EMPTY_RING, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));


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
