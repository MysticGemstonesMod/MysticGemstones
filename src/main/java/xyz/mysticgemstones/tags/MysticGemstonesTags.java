package xyz.mysticgemstones.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesTags {
    public static final TagKey<Item> RAW_GEMS = TagKey.of(RegistryKeys.ITEM, new Identifier(Constant.MOD_ID, Constant.RAW_GEMS));
    public static final TagKey<Item> GEM_RINGS = TagKey.of(RegistryKeys.ITEM, new Identifier(Constant.MOD_ID, Constant.GEM_RINGS));
}
