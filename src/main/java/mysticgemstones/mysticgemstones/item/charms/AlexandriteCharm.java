package mysticgemstones.mysticgemstones.item.charms;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.mysticgemstones.alexandrite_charm.tooltip").formatted(Formatting.GRAY));
    }
}
