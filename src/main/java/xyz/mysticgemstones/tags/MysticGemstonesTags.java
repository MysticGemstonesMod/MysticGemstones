package xyz.mysticgemstones.tags;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesTags {
    public static final TagKey<Item> RAW_GEMS = TagKey.of(Registry.ITEM_KEY, new Identifier(Constant.MOD_ID, Constant.RAW_GEMS));
}
