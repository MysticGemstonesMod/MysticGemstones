package xyz.mysticgemstones;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Utils {

    public static boolean hasItemInInventory(PlayerEntity player, Item item) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.isItemEqual(new ItemStack(item))) {
                return true;
            }
        }
        return false;
    }
}
