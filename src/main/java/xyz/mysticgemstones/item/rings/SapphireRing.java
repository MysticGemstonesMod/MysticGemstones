package xyz.mysticgemstones.item.rings;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SapphireRing extends GemRing {
    public SapphireRing(Settings settings) {
        super(settings, 100);
    }

    @Override
    public void doMagic(World world, PlayerEntity player, Hand hand) {

    }
}
