package xyz.mysticgemstones.statuseffects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesStatusEffect {
    public static final StatusEffect NO_HUNGER = new NoHungerStatusEffect();

    public static void register() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Constant.MOD_ID, "nohunger"), NO_HUNGER);
    }
}
