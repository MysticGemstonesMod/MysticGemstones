package xyz.domza.mystic_gemstones.item.ring;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import xyz.domza.mystic_gemstones.Constant;

import java.util.List;

public class AquamarineRing extends Ring {
    public AquamarineRing(Settings settings) {
        super(settings, 12, 100);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(String.format("item.%s.aquamarine_ring.tooltip", Constant.MOD_ID).formatted(Formatting.BLUE)));
    }

    @Override
    void useRing(World world, PlayerEntity user, ItemStack ring) {
        int currentAir = user.getAir();
        int newAir = Math.min(user.getMaxAir(), currentAir + 65);
        user.setAir(newAir);
     }
}
