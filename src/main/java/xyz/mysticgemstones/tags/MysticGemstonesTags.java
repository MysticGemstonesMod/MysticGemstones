package xyz.mysticgemstones.tags;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesTags {
    public static final Tag<Item> RAW_GEMS = TagFactory.ITEM.create(new Identifier(Constant.MOD_ID, Constant.RAW_GEMS));
}
