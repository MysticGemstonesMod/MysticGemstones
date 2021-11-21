package mysticgemstones.mysticgemstones.item.charms;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.world.World;

public class AlexandriteCharm extends Item {
    public AlexandriteCharm(Settings settings) {
        super(settings);
    }

    private int isSet = 0;
    int staticFoodLevel;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        PlayerEntity player = (PlayerEntity)entity;

        if (isSet == 2 || staticFoodLevel < player.getHungerManager().getFoodLevel()) {
            staticFoodLevel = player.getHungerManager().getFoodLevel();
            isSet = 0;
        }
        if (staticFoodLevel - 1 > player.getHungerManager().getFoodLevel()) {
            player.getHungerManager().add(1, 0F);
            // Should probably remove player message at some point.
            if (isSet == 1) {
                player.sendMessage(new LiteralText("+ 0.5 free chicken MC nugget"), false);
            }
            isSet++;
        }
    }
}
