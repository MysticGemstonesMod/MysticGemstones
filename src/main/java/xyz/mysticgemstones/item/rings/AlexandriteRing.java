package xyz.mysticgemstones.item.rings;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import xyz.mysticgemstones.Utils;
import xyz.mysticgemstones.item.MysticGemstonesItems;

public class AlexandriteRing extends GemRing {
    public AlexandriteRing(Settings settings) {
        super(settings, 1200);
    }

    @Override
    public void doMagic(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            if (Utils.hasItemInInventory(player, MysticGemstonesItems.ALEXANDRITE_CHARM)) {
                world.playSoundFromEntity(null, player, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
                player.getHungerManager().add(10, 0.6f);
            }
            else {
                world.playSoundFromEntity(null, player, SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.BLOCKS, 1f, 1f);
                player.getHungerManager().add(6, 0);
            }
        }
    }

    // TODO
//    @Override
//    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        tooltip.add(new TranslatableText("item.mysticgemstones.alexandrite_ring.tooltip_1").formatted(Formatting.GRAY));
//        tooltip.add(new TranslatableText("item.mysticgemstones.alexandrite_ring.tooltip_2").formatted(Formatting.BLUE));
//        tooltip.add(new TranslatableText("item.mysticgemstones.alexandrite_ring.tooltip_3").formatted(Formatting.GRAY));
//        tooltip.add(new TranslatableText("item.mysticgemstones.alexandrite_ring.tooltip_4").formatted(Formatting.BLUE));
//    }
}
