package xyz.mysticgemstones.item.rings;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import xyz.mysticgemstones.Utils;
import xyz.mysticgemstones.item.MysticGemstonesItem;

public class TopazRing extends GemRing {
    public TopazRing(Settings settings) {
        super(settings, 1000);
    }


    @Override
    public void doMagic(World world, PlayerEntity player, Hand hand) {
        if (Utils.hasItemInInventory(player, MysticGemstonesItem.TOPAZ_CHARM)) {
            world.playSoundFromEntity(null, player, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 5));
        }
        else {
            world.playSoundFromEntity(null, player, SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.BLOCKS, 1f, 1f);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 3));
        }
        player.getItemCooldownManager().set(player.getStackInHand(hand).getItem(), 500);
    }
}
