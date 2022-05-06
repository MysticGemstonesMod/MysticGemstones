package xyz.mysticgemstones.item.rings;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import xyz.mysticgemstones.Utils;
import xyz.mysticgemstones.item.MysticGemstonesItem;

public class AquamarineRing extends GemRing {
    public AquamarineRing(Settings settings) {
        super(settings);
    }

    @Override
    public void doMagic(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            if (Utils.hasItemInInventory(player, MysticGemstonesItem.AQUAMARINE_CHARM)) {
                world.playSoundFromEntity(null, player, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
                player.setAir(300);
            }
            else {
                world.playSoundFromEntity(null, player, SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.BLOCKS, 1f, 1f);
                player.setAir(player.getAir() + 100);
                if (player.getAir() > 300) player.setAir(300);
            }
        }
    }

}
