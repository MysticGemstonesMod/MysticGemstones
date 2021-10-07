package aquamarinmod.aquamarinmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class aquamarinmod implements ModInitializer {

    private static final Item AQUAMARIN_ITEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(322));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("aquamarinmod", "aquamarin"), AQUAMARIN_ITEM);
    }
}
