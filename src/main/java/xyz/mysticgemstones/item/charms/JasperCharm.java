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
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JasperCharm extends Item {
    public JasperCharm(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.hasStatusEffect(StatusEffects.ABSORPTION)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 0));
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.mysticgemstones.jasper_charm.tooltip_1"));
        tooltip.add(new TranslatableText("item.mysticgemstones.jasper_charm.tooltip_2"));
    }
}
