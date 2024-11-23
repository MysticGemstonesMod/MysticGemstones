package xyz.domza.mystic_gemstones.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.domza.mystic_gemstones.Constant;

public class MysticGemstonesItemGroup {
    public static final RegistryKey<ItemGroup> MYSTIC_ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Constant.MOD_ID, "mystic_group"));

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, MYSTIC_ITEM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable(String.format("%s.mystic_group", Constant.MOD_ID)))
                .icon(() -> new ItemStack(MysticGemstonesItem.POLISHED_AQUAMARINE))
                .build()
        );
    }
}
