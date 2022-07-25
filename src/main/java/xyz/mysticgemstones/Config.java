package xyz.mysticgemstones;

import net.minecraft.world.gen.YOffset;

public interface Config {

    // AQUAMARINE
    class Aquamarine {
        public static int ringWithCharm = 225;
        public static int ringPower = 100;
        public static int ringCooldown = 400;
    }

    // ALEXANDRITE
    class Alexandrite {
        public static int ringWithCharm;
        public static int ringPower;
        public static int ringCooldown;
        public static float charmPower = 2;
        public static int appleDuration = 1600;
    }


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
}
