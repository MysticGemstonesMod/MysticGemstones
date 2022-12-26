package xyz.mysticgemstones.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.mysticgemstones.Config;
import xyz.mysticgemstones.statuseffects.MysticGemstonesStatusEffect;

public class AlexandriteApple extends Item {
    public AlexandriteApple(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity player = (PlayerEntity) user;
        player.addStatusEffect(new StatusEffectInstance(MysticGemstonesStatusEffect.NO_HUNGER, Config.Alexandrite.appleDuration));
        return super.finishUsing(stack, world, user);
    }

    // TODO
//    @Override
//    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        tooltip.add(new TranslatableText("item.mysticgemstones.alexandrite_apple.tooltip_1").formatted(Formatting.GRAY));
//    }
}
