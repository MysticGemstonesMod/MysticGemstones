package xyz.mysticgemstones.item.charms;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TopazCharm extends Item {
    public TopazCharm(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.hasStatusEffect(StatusEffects.RESISTANCE)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 300, 1));
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.mysticgemstones.topaz_charm.tooltip_1").formatted(Formatting.GRAY));
        tooltip.add(new TranslatableText("item.mysticgemstones.topaz_charm.tooltip_2").formatted(Formatting.GRAY));
    }
}
