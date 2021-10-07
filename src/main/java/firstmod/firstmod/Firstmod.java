package firstmod.firstmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Firstmod implements ModInitializer {

    private static final Item RANDOM_ITEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(32));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("firstmod", "random_item"), RANDOM_ITEM);
    }
}
