package mysticgemstones.mysticgemstones.item;

import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
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
    public static final Item RAW_STARSTONE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item STARSTONE_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));


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

    }

    // This gives raw starstone ore shining or not shining texture depending on time of day.
    public static void setShiningNotShining() {
        FabricModelPredicateProviderRegistry.register(MysticGemstonesItem.RAW_STARSTONE, new Identifier("shining"), (itemStack, clientWorld, livingEntity, hmmmm) -> {
            if (0 == 0 ) {     // This should test world time (like starstone ore) and depending on it set raw starstone texture.
                // Use shiny texture
                return 1.0F;
            }
            // Use not shiny texture
            return 0.0F;
        });
    }
}
