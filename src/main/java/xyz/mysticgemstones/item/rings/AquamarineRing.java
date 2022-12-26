package xyz.mysticgemstones.item.rings;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import xyz.mysticgemstones.Config;
import xyz.mysticgemstones.Utils;
import xyz.mysticgemstones.item.MysticGemstonesItems;

public class AquamarineRing extends GemRing {
    public AquamarineRing(Settings settings) {
        super(settings, Config.Aquamarine.ringCooldown);
    }

    @Override
    public void doMagic(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            if (Utils.hasItemInInventory(player, MysticGemstonesItems.AQUAMARINE_CHARM)) {
                world.playSoundFromEntity(null, player, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
                player.setAir(player.getAir() + Config.Aquamarine.ringWithCharm);
            }
            else {
                world.playSoundFromEntity(null, player, SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.BLOCKS, 1f, 1f);
                player.setAir(player.getAir() + Config.Aquamarine.ringPower);
            }
            if (player.getAir() > 300) player.setAir(300);
        }
    }

    // TODO
//    @Override
//    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        tooltip.add(new TranslatableText("item.mysticgemstones.aquamarine_ring.tooltip_1").formatted(Formatting.GRAY));
//        tooltip.add(new TranslatableText("item.mysticgemstones.aquamarine_ring.tooltip_2").formatted(Formatting.BLUE));
//        tooltip.add(new TranslatableText("item.mysticgemstones.aquamarine_ring.tooltip_3").formatted(Formatting.GRAY));
//        tooltip.add(new TranslatableText("item.mysticgemstones.aquamarine_ring.tooltip_4").formatted(Formatting.BLUE));
//    }
}
