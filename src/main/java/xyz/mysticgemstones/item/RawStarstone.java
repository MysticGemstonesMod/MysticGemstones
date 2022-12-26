package xyz.mysticgemstones.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RawStarstone extends RawGemItem {
    public RawStarstone(Settings settings, Item polishedVariant, Item dust, int powderDropChance, int itemBreakChance,  int itemPolishChance) {
        super(settings, polishedVariant, dust, powderDropChance, itemBreakChance, itemPolishChance);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.getTimeOfDay() > 22350 || world.getTimeOfDay() < 21980) {
            stack.decrement(1);
            BlockPos pos = entity.getBlockPos();
            Block.dropStack(world, pos, new ItemStack(MysticGemstonesItems.STARSTONE_DUST));
        }
    }
}
