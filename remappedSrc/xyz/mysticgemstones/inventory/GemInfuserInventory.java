package xyz.mysticgemstones.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface GemInfuserInventory extends Inventory {

    DefaultedList<ItemStack> getInventory();

    static GemInfuserInventory of(DefaultedList<ItemStack> items) {
        return () -> items;
    }

    static GemInfuserInventory ofSize(int size) {
        return of(DefaultedList.ofSize(size, ItemStack.EMPTY));
    }

    @Override
    default int size() {
        return getInventory().size();
    }

    @Override
    default boolean isEmpty() {
        for (int i = 0; i < size(); i++) {
            ItemStack stack = getStack(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    default ItemStack getStack(int slot) {
        return getInventory().get(slot);
    }

    @Override
    default ItemStack removeStack(int slot, int count) {
        ItemStack result = Inventories.splitStack(getInventory(), slot, count);
        if (!result.isEmpty()) {
            markDirty();
        }
        return result;
    }

    @Override
    default ItemStack removeStack(int slot) {
        return Inventories.removeStack(getInventory(), slot);
    }

    @Override
    default void setStack(int slot, ItemStack stack) {
        getInventory().set(slot, stack);
        if (stack.getCount() > getMaxCountPerStack()) {
            stack.setCount(getMaxCountPerStack());
        }
    }

    @Override
    default void clear() {
        getInventory().clear();
    }

    @Override
    default void markDirty() {
    }

    @Override
    default boolean canPlayerUse(PlayerEntity player) {
        return true;
    }
}
