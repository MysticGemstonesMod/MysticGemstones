package xyz.mysticgemstones;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.mysticgemstones.statusEffects.MysticGemstonesStatusEffect;

public class AlexandriteApple extends Item {
    public AlexandriteApple(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity player = (PlayerEntity) user;
        player.addStatusEffect(new StatusEffectInstance(MysticGemstonesStatusEffect.NO_HUNGER, 1600));
        return super.finishUsing(stack, world, user);
    }
}
