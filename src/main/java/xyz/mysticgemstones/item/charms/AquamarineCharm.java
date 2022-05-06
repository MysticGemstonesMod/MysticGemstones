package xyz.mysticgemstones.item.charms;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AquamarineCharm extends Item {
    private long time = 0;
    public AquamarineCharm(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // In future maybe override using mixin or something to slow down oxygen consumption
        if (entity.isSubmergedInWater()) {
            if (world.getTime() > time + 4) {
                time = world.getTime();
                PlayerEntity player = (PlayerEntity) entity;
                int air = player.getAir();
                if (air < 300) {
                    if ((air + 2) < 300) {
                        air += 2;
                    } else {
                        air = 300;
                    }
                    player.setAir(air);
                }
            }
        }
    }
}
