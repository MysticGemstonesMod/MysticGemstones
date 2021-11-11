package mysticgemstones.mysticgemstones.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MysticGemstonesItem {

    // Add
    public static final Item AQUAMARIN_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item RAW_AQUAMARIN = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item JASPER_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item RAW_JASPER = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item ALEXANDRITE_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item RAW_ALEXANDRITE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final RawStarstone RAW_STARSTONE = new RawStarstone(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item STARSTONE_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final StarstoneOreItem STARSTONE_ORE_ITEM = new StarstoneOreItem(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final StarstoneDust STARSTONE_DUST = new StarstoneDust(new FabricItemSettings().group(ItemGroup.MATERIALS));


    public static void AddAndRegisterItem() {

        // Register
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "aquamarin"), AQUAMARIN_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_aquamarin"), RAW_AQUAMARIN);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "jasper"), JASPER_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_jasper"), RAW_JASPER);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "alexandrite"), ALEXANDRITE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_alexandrite"), RAW_ALEXANDRITE);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_starstone"), RAW_STARSTONE);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "starstone_item"), STARSTONE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "starstone_ore_item"), STARSTONE_ORE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "starstone_dust"), STARSTONE_DUST);

    }
}
