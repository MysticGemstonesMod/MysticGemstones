package xyz.mysticgemstones.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;

public class GemBookScreenHandler extends ScreenHandler {
    public GemBookScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(MysticGemstonesScreenType.GEM_BOOK_SCREEN_HANDLER, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
