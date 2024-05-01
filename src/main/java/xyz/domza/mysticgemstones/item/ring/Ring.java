package xyz.domza.mysticgemstones.item.ring;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Ring extends Item {
    protected Ring(Settings settings) {
        super(applyRingSettings(settings));
    }

    private static Settings applyRingSettings(Settings settings) {
        return settings.maxCount(1);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.sendMessage(Text.literal("Not implemented!"), true);
        return super.use(world, user, hand);
    }
}
