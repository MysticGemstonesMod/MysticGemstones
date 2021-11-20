package mysticgemstones.mysticgemstones.generation;

import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class OreGeneration {

    /* Very Very bad code this is.... I know....  Now I am to stupid to do it better way
       since I am still learning java but hopefully in future I will fix this.
       By fix I mean add some fancy magic so there is no duplicate code for
       every ore. */

    // AQUAMARINE
    private static ConfiguredFeature<?, ?> ORE_AQUAMARINE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    MysticGemstonesBlock.AQUAMARINE_ORE.getDefaultState(),
                    3)) // Vein size
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(35)))) // Inclusive min and max height

            .spreadHorizontally()
            .repeat(12); // Number of veins per chunk


    // JASPER
    private static ConfiguredFeature<?, ?> ORE_JASPER_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    MysticGemstonesBlock.JASPER_ORE.getDefaultState(),
                    3)) // Vein size
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(35)))) // Inclusive min and max height

            .spreadHorizontally()
            .repeat(12); // Number of veins per chunk


    // AEXANDRITE
    private static ConfiguredFeature<?, ?> ORE_ALEXANDRITE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    MysticGemstonesBlock.ALEXANDRITE_ORE.getDefaultState(),
                    3)) // Vein size
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(35)))) // Inclusive min and max height

            .spreadHorizontally()
            .repeat(12); // Number of veins per chunk

    // TOPAZ
    private static ConfiguredFeature<?, ?> ORE_TOPAZ_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    MysticGemstonesBlock.TOPAZ_ORE.getDefaultState(),
                    3)) // Vein size
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(35)))) // Inclusive min and max height

            .spreadHorizontally()
            .repeat(12); // Number of veins per chunk


    public static void RegisterOreGeneration() {

        // AQUAMARINE
        RegistryKey<ConfiguredFeature<?, ?>> oreAquamarineOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("mysticgemstones", "ore_aquamarine_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreAquamarineOverworld.getValue(), ORE_AQUAMARINE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreAquamarineOverworld);

        // JASPER
        RegistryKey<ConfiguredFeature<?, ?>> oreJasperOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("mysticgemstones", "ore_jasper_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreJasperOverworld.getValue(), ORE_JASPER_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreJasperOverworld);

        // TOPAZ
        RegistryKey<ConfiguredFeature<?, ?>> oreTopazOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("mysticgemstones", "ore_topaz_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreTopazOverworld.getValue(), ORE_TOPAZ_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreTopazOverworld);

        // ALEXANDRITE
        RegistryKey<ConfiguredFeature<?, ?>> oreAlexandriteOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("mysticgemstones", "ore_alexandrite_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreAlexandriteOverworld.getValue(), ORE_ALEXANDRITE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreAlexandriteOverworld);
    }
}
