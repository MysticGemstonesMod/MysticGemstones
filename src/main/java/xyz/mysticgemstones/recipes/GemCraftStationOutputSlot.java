package xyz.mysticgemstones.recipes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.util.collection.DefaultedList;

public class GemCraftStationOutputSlot extends CraftingResultSlot {
    private final CraftingInventory input;
    private final PlayerEntity player;

    public GemCraftStationOutputSlot(PlayerEntity player, CraftingInventory input, Inventory inventory, int index, int x, int y) {
        super(player, input, inventory, index, x, y);
        this.input = input;
        this.player = player;
    }

    @Override
    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        this.onCrafted(stack);
        DefaultedList<ItemStack> defaultedList = player.world.getRecipeManager().getRemainingStacks(GemCraftStationRecipe.Type.INSTANCE, this.input, player.world);
        for (int i = 0; i < defaultedList.size(); ++i) {
            ItemStack itemStack = this.input.getStack(i);
            ItemStack itemStack2 = defaultedList.get(i);
            if (!itemStack.isEmpty()) {
                this.input.removeStack(i, 1);
                itemStack = this.input.getStack(i);
            }
            if (itemStack2.isEmpty()) continue;
            if (itemStack.isEmpty()) {
                this.input.setStack(i, itemStack2);
                continue;
            }
            if (ItemStack.areItemsEqualIgnoreDamage(itemStack, itemStack2) && ItemStack.areNbtEqual(itemStack, itemStack2)) {
                itemStack2.increment(itemStack.getCount());
                this.input.setStack(i, itemStack2);
                continue;
            }
            if (this.player.getInventory().insertStack(itemStack2)) continue;
            this.player.dropItem(itemStack2, false);
        }
    }
}
