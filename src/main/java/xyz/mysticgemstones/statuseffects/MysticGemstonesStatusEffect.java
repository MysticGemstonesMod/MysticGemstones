package xyz.mysticgemstones.statuseffects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesStatusEffect {
    public static final StatusEffect NO_HUNGER = new NoHungerStatusEffect();

    public static void register() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Constant.MOD_ID, Constant.NO_HUNGER_STATUS_EFFECT), NO_HUNGER);
    }
}
