package xyz.mysticgemstones.item.rings;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import xyz.mysticgemstones.Utils;
import xyz.mysticgemstones.item.MysticGemstonesItems;

public class JasperRing extends GemRing {
    public JasperRing(Settings settings) {
        super(settings, 100);
    }

    @Override
    public void doMagic(World world, PlayerEntity player, Hand hand) {
        if (Utils.hasItemInInventory(player, MysticGemstonesItems.JASPER_CHARM)) {
            world.playSoundFromEntity(null, player, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50, 4));
        }
        else {
            world.playSoundFromEntity(null, player, SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.BLOCKS, 1f, 1f);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 25, 4));
        }
        player.getItemCooldownManager().set(player.getStackInHand(hand).getItem(), 500);
    }

    // TODO - tooltip
//    @Override
//    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        tooltip.add(new TranslatableText("item.mysticgemstones.jasper_ring.tooltip_1").formatted(Formatting.GRAY));
//        tooltip.add(new TranslatableText("item.mysticgemstones.jasper_ring.tooltip_2").formatted(Formatting.BLUE));
//        tooltip.add(new TranslatableText("item.mysticgemstones.jasper_ring.tooltip_3").formatted(Formatting.GRAY));
//        tooltip.add(new TranslatableText("item.mysticgemstones.jasper_ring.tooltip_4").formatted(Formatting.BLUE));
//
//    }
}
