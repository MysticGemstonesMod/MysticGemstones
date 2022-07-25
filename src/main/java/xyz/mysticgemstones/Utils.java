package xyz.mysticgemstones;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import xyz.mysticgemstones.item.MysticGemstonesItem;

import java.util.Set;

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

    public static void onSpawn(ServerWorld world, Entity entity) {
        if (world.isClient()) {
            return;
        }
        if (entity instanceof PlayerEntity player) {
            if (isJoiningWorldForTheFirstTime(player, Constant.MOD_ID)) {
                // Give Gem Book
                player.getInventory().offerOrDrop(new ItemStack(MysticGemstonesItem.GEM_BOOK));
            }
            player.sendMessage(new LiteralText("MysticGemstones mod is in very early ALPHA!").formatted(Formatting.RED), false);
            player.sendMessage(new LiteralText("Version: 0.1-Alpha").formatted(Formatting.RED), false);
            player.sendMessage(new LiteralText("It is not finished and is missing a lot of important features and probably has some bugs. Check for new version or report bugs here: https://github.com/MysticGemstonesMod/MysticGemstones").formatted(Formatting.AQUA), false);
        }
    }

    public static boolean isJoiningWorldForTheFirstTime(PlayerEntity player, String modid) {
        // https://github.com/ricksouth/serilum-mc-mods/blob/master/sources/Collective/src/main/java/com/natamus/collective/functions/PlayerFunctions.java
        String firstjointag = Constant.MOD_ID + ".firstJoin." + modid;

        Set<String> tags = player.getScoreboardTags();
        if (tags.contains(firstjointag)) {
            return false;
        }
        player.addScoreboardTag(firstjointag);
        return true;
//
//        Inventory inv = player.getInventory();
//        boolean isempty = true;
//        for (int i = 0; i < 36; i++) {
//            if (!inv.getItem(i).isEmpty()) {
//                isempty = false;
//                break;
//            }
//        }
//
//        if (!isempty) {
//            return false;
//        }
//
//
//        World world = player.getCommandSenderWorld();
//        ServerLevel ServerLevel = (ServerLevel) world;
//        BlockPos wspos = ServerLevel.getSharedSpawnPos();
//        BlockPos ppos = player.blockPosition();
//        BlockPos cpos = new BlockPos(ppos.getX(), wspos.getY(), ppos.getZ());
//
//        return cpos.closerThan(wspos, 50);
    }
}
