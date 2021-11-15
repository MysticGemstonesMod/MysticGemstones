package mysticgemstones.mysticgemstones.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MysticGemstonesItem {

    // Add
    public static final Item AQUAMARINE_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item RAW_AQUAMARINE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item JASPER_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item RAW_JASPER = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item ALEXANDRITE_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item RAW_ALEXANDRITE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item STARSTONE_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final RawStarstone RAW_STARSTONE = new RawStarstone(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item JASPER_POWDER = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final StarstoneDust STARSTONE_DUST = new StarstoneDust(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final CondensedStarstoneDust CONDENSED_STARSTONE_DUST = new CondensedStarstoneDust(new FabricItemSettings().group(ItemGroup.MATERIALS));


    public static void AddAndRegisterItem() {

        // Register
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "aquamarine"), AQUAMARINE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_aquamarine"), RAW_AQUAMARINE);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "jasper"), JASPER_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_jasper"), RAW_JASPER);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "jasper_powder"), JASPER_POWDER);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "alexandrite"), ALEXANDRITE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_alexandrite"), RAW_ALEXANDRITE);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "starstone_item"), STARSTONE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_starstone"), RAW_STARSTONE);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "starstone_dust"), STARSTONE_DUST);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "condensed_starstone_dust"), CONDENSED_STARSTONE_DUST);
    }
}
