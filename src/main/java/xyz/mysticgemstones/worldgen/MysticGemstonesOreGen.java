package xyz.mysticgemstones.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import xyz.mysticgemstones.Constant;
import xyz.mysticgemstones.block.MysticGemstonesBlock;

import java.util.Arrays;

public class MysticGemstonesOreGen {

    // ------------------------------------------------------------------------------
    // !!!!! DISCLAIMER !!!!!
    // Worst way to do this, This is just TEMPORARY but MUST be fixed in the future.
    // !!!!! DISCLAIMER !!!!!
    // ------------------------------------------------------------------------------


    // Aquamarine
    private static ConfiguredFeature<?, ?> OVERWORLD_AQUAMARINE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    MysticGemstonesBlock.AQUAMARINE_ORE.getDefaultState(),
                    4)); // vein size

    public static PlacedFeature OVERWORLD_AQUAMARINE_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_AQUAMARINE_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(8), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)) // height
            ));


    // Jasper
    private static ConfiguredFeature<?, ?> OVERWORLD_JASPER_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    MysticGemstonesBlock.JASPER_ORE.getDefaultState(),
                    4)); // vein size

    public static PlacedFeature OVERWORLD_JASPER_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_JASPER_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(8), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)) // height
            ));

    // Alexandrite
    private static ConfiguredFeature<?, ?> OVERWORLD_ALEXANDRITE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    MysticGemstonesBlock.ALEXANDRITE_ORE.getDefaultState(),
                    4)); // vein size

    public static PlacedFeature OVERWORLD_ALEXANDRITE_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_ALEXANDRITE_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(8), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)) // height
            ));


    // Starstone
    private static ConfiguredFeature<?, ?> OVERWORLD_STARSTONE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    MysticGemstonesBlock.STARSTONE_ORE.getStateManager().getDefaultState(),
                    3)); // vein size

    public static PlacedFeature OVERWORLD_STARSTONE_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_STARSTONE_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(24), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(70), YOffset.getTop()) // height
            ));

    public static void register() {
        // Aquamarine
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_AQUAMARINE_ORE), OVERWORLD_AQUAMARINE_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_AQUAMARINE_ORE),
                OVERWORLD_AQUAMARINE_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_AQUAMARINE_ORE)));

        // Jasper
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_JASPER_ORE), OVERWORLD_JASPER_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_JASPER_ORE),
                OVERWORLD_JASPER_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_JASPER_ORE)));

        // Alexandrite
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_ALEXANDRITE_ORE), OVERWORLD_ALEXANDRITE_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_ALEXANDRITE_ORE),
                OVERWORLD_ALEXANDRITE_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_ALEXANDRITE_ORE)));

        // Starstone
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_STARSTONE_ORE), OVERWORLD_STARSTONE_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_STARSTONE_ORE),
                OVERWORLD_STARSTONE_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_STARSTONE_ORE)));
    }
}
