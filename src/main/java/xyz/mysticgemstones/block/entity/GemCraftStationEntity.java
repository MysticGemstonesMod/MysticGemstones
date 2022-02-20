package xyz.mysticgemstones.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import xyz.mysticgemstones.block.inventory.GemCraftStationInventory;
import xyz.mysticgemstones.screenhandler.GemCraftStationScreenHandler;
import xyz.mysticgemstones.block.MysticGemstonesBlock;

public class GemCraftStationEntity extends BlockEntity implements NamedScreenHandlerFactory, GemCraftStationInventory {

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public GemCraftStationEntity(BlockPos pos, BlockState state) {
        super(MysticGemstonesBlock.GEM_CRAFT_STATION_ENTITY, pos, state);
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GemCraftStationScreenHandler(syncId, playerInventory, this);
    }
    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.items);
    }
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.items);
    }
}
