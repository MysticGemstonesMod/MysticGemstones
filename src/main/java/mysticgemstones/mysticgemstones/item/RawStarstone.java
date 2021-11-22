package mysticgemstones.mysticgemstones.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RawStarstone extends Item {

    public RawStarstone(Settings settings) {
        super(settings);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (world.getTimeOfDay() > 22350 || world.getTimeOfDay() < 21980) {
            stack.setCount(stack.getCount() - 1);
            BlockPos pos = entity.getBlockPos();
            Block.dropStack(world, pos, new ItemStack(MysticGemstonesItem.STARSTONE_POWDER));
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
