package mysticgemstones.mysticgemstones.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StarstoneItem extends Item {
    public StarstoneItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
