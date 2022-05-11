package xyz.mysticgemstones;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;

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

    public static void sendMessageOnSpawn(ServerWorld world, Entity entity) {
        if (world.isClient()) {
            return;
        }
        if (entity instanceof PlayerEntity player) {
            player.sendMessage(new LiteralText("MysticGemstones mod is in very early ALPHA!").formatted(Formatting.RED), false);
            player.sendMessage(new LiteralText("Version: 0.1-Alpha").formatted(Formatting.RED), false);
            player.sendMessage(new LiteralText("It is not finished and is missing a lot of important features and probably has some bugs. Check for new version or report bugs here: https://github.com/MysticGemstonesMod/MysticGemstones").formatted(Formatting.AQUA), false);
        }
    }
}
