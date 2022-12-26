package xyz.mysticgemstones.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MysticGemstonesSoundEvents {
    public static final Identifier AQUAMARINE_DISC_SOUND_ID = new Identifier("mysticgemstones:aquamarine_disc_sound");
    public static SoundEvent AQUAMARINE_DISC_SOUND_EVENT = new SoundEvent(AQUAMARINE_DISC_SOUND_ID);
    public static final Identifier MALACHITE_DISC_SOUND_ID = new Identifier("mysticgemstones:malachite_disc_sound");
    public static SoundEvent MALACHITE_DISC_SOUND_EVENT = new SoundEvent(MALACHITE_DISC_SOUND_ID);

    public static void registerSoundEvents() {
        Registry.register(Registry.SOUND_EVENT, MysticGemstonesSoundEvents.AQUAMARINE_DISC_SOUND_ID, AQUAMARINE_DISC_SOUND_EVENT);
        Registry.register(Registry.SOUND_EVENT, MysticGemstonesSoundEvents.MALACHITE_DISC_SOUND_ID, MALACHITE_DISC_SOUND_EVENT);
    }
}
