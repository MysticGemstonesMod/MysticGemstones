package xyz.mysticgemstones.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;
import xyz.mysticgemstones.block.MysticGemstonesBlock;

public class MysticGemstonesItemGroups {
    public static ItemGroup ITEM_GROUP_GEMS = FabricItemGroup.builder(new Identifier(Constant.MOD_ID, "gems"))
            .displayName(Text.literal("Gems"))
            .icon(() -> new ItemStack(MysticGemstonesItems.STARSTONE_ITEM))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(MysticGemstonesItems.STARSTONE_ITEM);
            })
            .build();

    public static ItemGroup ITEM_GROUP_ITEMS = FabricItemGroup.builder(new Identifier(Constant.MOD_ID, "items"))
            .displayName(Text.literal("Items"))
            .icon(() -> new ItemStack(MysticGemstonesItems.STARSTONE_RING))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(MysticGemstonesItems.STARSTONE_RING);
            })
            .build();

    public static void hmm() {
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_GEMS).register(entries -> entries.add(MysticGemstonesBlock.STARSTONE_ORE_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_ITEMS).register(entries -> entries.add(MysticGemstonesBlock.GEM_GRINDSTONE_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_ITEMS).register(entries -> entries.add(MysticGemstonesBlock.JEWELRY_WORKBENCH_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_ITEMS).register(entries -> entries.add(MysticGemstonesBlock.ROCK_TUMBLER_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_ITEMS).register(entries -> entries.add(MysticGemstonesBlock.GEM_INFUSER_ITEM));
    }
}
