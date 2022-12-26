package xyz.mysticgemstones.item.charms;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.mysticgemstones.Config;

public class AlexandriteCharm extends Item {
    public AlexandriteCharm(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        PlayerEntity player = (PlayerEntity)entity;

        if (!world.isClient()) {
            int foodLevel = player.getHungerManager().getFoodLevel();
            int prevFoodLevel = player.getHungerManager().getPrevFoodLevel();
            if (prevFoodLevel > foodLevel && foodLevel != 20 && prevFoodLevel !=20) {
                player.getHungerManager().setSaturationLevel(player.getHungerManager().getSaturationLevel() + Config.Alexandrite.charmPower);
            }
        }
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        super.onItemEntityDestroyed(entity);
    }
    // TODO
//    @Override
//    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        tooltip.add(new TranslatableText("item.mysticgemstones.alexandrite_charm.tooltip_1").formatted(Formatting.GRAY));
//        tooltip.add(new TranslatableText("item.mysticgemstones.alexandrite_charm.tooltip_2").formatted(Formatting.BLUE));
//    }
}
