package xyz.domza.mystic_gemstones.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import xyz.domza.mystic_gemstones.world.MysticGemstonesPlacedFeatures;

public class MysticGemstonesOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, MysticGemstonesPlacedFeatures.AQUAMARINE_ORE_PLACED_KEY);
    }
}
