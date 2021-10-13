package mysticgemstones.mysticgemstones.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MysticGemstonesItem {

    public static void AddAndRegisterItem() {

        // Add
        final Item AQUAMARIN_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
        final Item RAW_AQUAMARIN = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

        // Register
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "aquamarin"), AQUAMARIN_ITEM);
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "raw_aquamarin"), RAW_AQUAMARIN);

    }

}
