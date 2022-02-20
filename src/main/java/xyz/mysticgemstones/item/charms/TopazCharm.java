package xyz.mysticgemstones.item.charms;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.world.World;
import xyz.mysticgemstones.item.MysticGemstonesItem;

public class TopazCharm extends Item {
    public TopazCharm(Settings settings) {
        super(settings);
    }
    // Don't think this is the best solution, but for now it will do what it needs to do.
    // Hopefully I'll rewrite this in future to make it better
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        PlayerEntity player = (PlayerEntity) entity;
        if (!world.isClient) {
            boolean cooldown = player.getItemCooldownManager().isCoolingDown(MysticGemstonesItem.TOPAZ_CHARM);
            float cooldownProgres = player.getItemCooldownManager().getCooldownProgress(MysticGemstonesItem.TOPAZ_CHARM, 4f);
            if (!cooldown) {
                if (player.getDamageTracker().hasDamage()) {
                    player.getItemCooldownManager().set(MysticGemstonesItem.TOPAZ_CHARM, 500);
                }
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 2));
            } else if (cooldownProgres < 0.2f && cooldownProgres > 0.1f) {
                player.sendMessage(new LiteralText("Topaz Charm Charging... 3 seconds left... Don't take damage"), true);
            } else if (cooldownProgres < 0.01f && player.getDamageTracker().hasDamage()) {
                player.sendMessage(new LiteralText("Unsuccessfull recharge. Coldown has ben reseted"), true);
            }
        }
    }
}
