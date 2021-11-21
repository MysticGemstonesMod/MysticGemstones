package mysticgemstones.mysticgemstones;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundEventMysticGemstones {

    public static final Identifier AQUAMARINE_DISC_SOUND_ID = new Identifier("mysticgemstones:aquamarine_disc_sound");
    public static SoundEvent AQUAMARINE_DISC_SOUND_EVENT = new SoundEvent(AQUAMARINE_DISC_SOUND_ID);

    public static void registerSoundEvents() {
        Registry.register(Registry.SOUND_EVENT, SoundEventMysticGemstones.AQUAMARINE_DISC_SOUND_ID, AQUAMARINE_DISC_SOUND_EVENT);
    }

}
