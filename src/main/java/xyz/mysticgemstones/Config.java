package xyz.mysticgemstones;

import net.minecraft.world.gen.YOffset;

public interface Config {

    // AQUAMARINE
    // Amount of air added on Aquamarine Ring use
    int aquamarineRingWithCharm = 300;
    int aquamarineRing = 100;
    int aquamarineRingCooldown = 400;

    // ALEXANDRITE

    // JASPER

    // ORE GENERATION
    class TierOneOre {
        public static YOffset maxHeight = YOffset.fixed(64);
        public static YOffset minHeight = YOffset.getBottom();
        public static int veinsPerChunk = 6;
        public static int veinSize = 4;
    }
    class TierTwoOre {
        public static YOffset maxHeight = YOffset.fixed(64);
        public static YOffset minHeight = YOffset.getBottom();
        public static int veinsPerChunk = 8;
        public static int veinSize = 4;
    }
    class StarstoneOre {
        public static YOffset maxHeight = YOffset.getTop();
        public static YOffset minHeight = YOffset.fixed(70);
        public static int veinsPerChunk = 24;
        public static int veinSize = 3;
    }
    class NetherOre {
        public static YOffset maxHeight = YOffset.getTop();
        public static YOffset minHeight = YOffset.getBottom();
        public static int veinsPerChunk = 28;
        public static int veinSize = 4;
    }

    // Add everything else
}
