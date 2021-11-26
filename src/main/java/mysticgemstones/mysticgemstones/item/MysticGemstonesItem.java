package mysticgemstones.mysticgemstones.item;

import mysticgemstones.mysticgemstones.Constant;
import mysticgemstones.mysticgemstones.SoundEventMysticGemstones;
import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import mysticgemstones.mysticgemstones.item.charms.*;
import mysticgemstones.mysticgemstones.item.discs.MusicDiscAquamarine;
import mysticgemstones.mysticgemstones.item.discs.MusicDiscMalachite;
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
    public static final Item TOPAZ_ITEM = registerItem(Constant.TOPAZ_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item AQUAMARINE_DUST = registerItem(Constant.AQUAMARINE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item ALEXANDRITE_DUST = registerItem(Constant.ALEXANDRITE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item JASPER_DUST = registerItem(Constant.JASPER_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item TOPAZ_DUST = registerItem(Constant.TOPAZ_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_JASPER = registerItem(Constant.RAW_JASPER, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_TOPAZ = registerItem(Constant.RAW_TOPAZ, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item ALEXANDRITE_ITEM = registerItem(Constant.ALEXANDRITE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_ALEXANDRITE = registerItem(Constant.RAW_ALEXANDRITE, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final StarstoneItem STARSTONE_ITEM = registerItem(Constant.STARSTONE_ITEM, new StarstoneItem(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final RawStarstone RAW_STARSTONE = registerItem(Constant.RAW_STARSTONE, new RawStarstone(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final StarstoneDust STARSTONE_DUST = registerItem(Constant.STARSTONE_DUST, new StarstoneDust(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final CondensedStarstoneDust CONDENSED_STARSTONE_DUST = registerItem(Constant.CONDENSED_STARSTONE_DUST, new CondensedStarstoneDust(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final AquamarineCharm AQUAMARINE_CHARM = registerItem(Constant.AQUAMARINE_CHARM, new AquamarineCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final AlexandriteCharm ALEXANDRITE_CHARM = registerItem(Constant.ALEXANDRITE_CHARM, new AlexandriteCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final JasperCharm JASPER_CHARM = registerItem(Constant.JASPER_CHARM, new JasperCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final TopazCharm TOPAZ_CHARM = registerItem(Constant.TOPAZ_CHARM, new TopazCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final MusicDiscAquamarine MUSIC_DISC_AQUAMARINE = registerItem(Constant.MUSIC_DISC_AQUAMARINE, new MusicDiscAquamarine(14, SoundEventMysticGemstones.AQUAMARINE_DISC_SOUND_EVENT, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final MusicDiscMalachite MUSIC_DISC_MALACHITE = registerItem(Constant.MUSIC_DISC_MALACHITE, new MusicDiscMalachite(15, SoundEventMysticGemstones.MALACHITE_DISC_SOUND_EVENT, new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final Item MALACHITE_ITEM = registerItem(Constant.MALACHITE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_MALACHITE = registerItem(Constant.RAW_MALACHITE, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item MALACHITE_DUST = registerItem(Constant.MALACHITE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final MalachiteCharm MALACHITE_CHARM = registerItem(Constant.MALACHITE_CHARM, new MalachiteCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final Item SAPPHIRE_ITEM = registerItem(Constant.SAPPHIRE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_SAPPHIRE = registerItem(Constant.RAW_SAPPHIRE, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item SAPPHIRE_DUST = registerItem(Constant.SAPPHIRE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final SapphireCharm SAPPHIRE_CHARM = registerItem(Constant.SAPPHIRE_CHARM, new SapphireCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));
    public static final Item WHITE_SAPPHIRE_ITEM = registerItem(Constant.WHITE_SAPPHIRE_ITEM, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item RAW_WHITE_SAPPHIRE = registerItem(Constant.RAW_WHITE_SAPPHIRE, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final Item WHITE_SAPPHIRE_DUST = registerItem(Constant.WHITE_SAPPHIRE_DUST, new Item(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP)));
    public static final WhiteSapphireCharm WHITE_SAPPHIRE_CHARM = registerItem(Constant.WHITE_SAPPHIRE_CHARM, new WhiteSapphireCharm(new FabricItemSettings().group(MysticGemstonesItem.ITEM_GROUP).maxCount(1)));

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
