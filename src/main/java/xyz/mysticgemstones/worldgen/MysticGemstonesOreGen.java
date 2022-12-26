package xyz.mysticgemstones.worldgen;

public class MysticGemstonesOreGen {

    // ------------------------------------------------------------------------------
    // !!!!! DISCLAIMER !!!!!
    // Worst way to do this, This is just TEMPORARY but MUST be fixed in the future.
    // !!!!! DISCLAIMER !!!!!
    // ------------------------------------------------------------------------------

// TODO
//
//    // Aquamarine
//    private static ConfiguredFeature<?, ?> OVERWORLD_AQUAMARINE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
//            (Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
//                    MysticGemstonesBlock.AQUAMARINE_ORE.getDefaultState(),
//                    Config.TierOneOre.veinSize));
//
//    public static PlacedFeature OVERWORLD_AQUAMARINE_ORE_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(OVERWORLD_AQUAMARINE_ORE_CONFIGURED_FEATURE),
//            Arrays.asList(
//                    CountPlacementModifier.of(Config.TierOneOre.veinsPerChunk),
//                    SquarePlacementModifier.of(), // spreading horizontally
//                    HeightRangePlacementModifier.uniform(Config.TierOneOre.minHeight, Config.TierOneOre.maxHeight)
//            ));
//
//
//    // Jasper
//    private static ConfiguredFeature<?, ?> OVERWORLD_JASPER_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
//            (Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
//                    MysticGemstonesBlock.JASPER_ORE.getDefaultState(),
//                    Config.TierOneOre.veinSize));
//
//    public static PlacedFeature OVERWORLD_JASPER_ORE_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(OVERWORLD_JASPER_ORE_CONFIGURED_FEATURE),
//            Arrays.asList(
//                    CountPlacementModifier.of(Config.TierOneOre.veinsPerChunk),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.uniform(Config.TierOneOre.minHeight, Config.TierOneOre.maxHeight)
//            ));
//
//    // Alexandrite
//    private static ConfiguredFeature<?, ?> OVERWORLD_ALEXANDRITE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
//            (Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
//                    MysticGemstonesBlock.ALEXANDRITE_ORE.getDefaultState(),
//                    Config.TierOneOre.veinSize));
//
//    public static PlacedFeature OVERWORLD_ALEXANDRITE_ORE_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(OVERWORLD_ALEXANDRITE_ORE_CONFIGURED_FEATURE),
//            Arrays.asList(
//                    CountPlacementModifier.of(Config.TierOneOre.veinsPerChunk),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.uniform(Config.TierOneOre.minHeight, Config.TierOneOre.maxHeight)
//            ));
//
//    // Topaz
//    private static ConfiguredFeature<?, ?> OVERWORLD_TOPAZ_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
//            (Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
//                    MysticGemstonesBlock.TOPAZ_ORE.getDefaultState(),
//                    Config.TierTwoOre.veinSize));
//
//    public static PlacedFeature OVERWORLD_TOPAZ_ORE_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(OVERWORLD_TOPAZ_ORE_CONFIGURED_FEATURE),
//            Arrays.asList(
//                    CountPlacementModifier.of(Config.TierTwoOre.veinsPerChunk),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.uniform(Config.TierTwoOre.minHeight, Config.TierTwoOre.maxHeight)
//            ));
//
//    // Sapphire
//    private static ConfiguredFeature<?, ?> OVERWORLD_SAPPHIRE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
//            (Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
//                    MysticGemstonesBlock.SAPPHIRE_ORE.getDefaultState(),
//                    Config.TierTwoOre.veinSize));
//
//    public static PlacedFeature OVERWORLD_SAPPHIRE_ORE_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(OVERWORLD_SAPPHIRE_ORE_CONFIGURED_FEATURE),
//            Arrays.asList(
//                    CountPlacementModifier.of(Config.TierTwoOre.veinsPerChunk),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.uniform(Config.TierTwoOre.minHeight, Config.TierTwoOre.maxHeight)
//            ));
//
//
//    // Starstone
//    private static ConfiguredFeature<?, ?> OVERWORLD_STARSTONE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
//            (Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
//                    MysticGemstonesBlock.STARSTONE_ORE.getStateManager().getDefaultState(),
//                    Config.StarstoneOre.veinSize));
//
//    public static PlacedFeature OVERWORLD_STARSTONE_ORE_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(OVERWORLD_STARSTONE_ORE_CONFIGURED_FEATURE),
//            Arrays.asList(
//                    CountPlacementModifier.of(Config.StarstoneOre.veinsPerChunk),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.uniform(Config.StarstoneOre.minHeight, Config.StarstoneOre.maxHeight)
//            ));
//
//    // Malachite
//    private static ConfiguredFeature<?, ?> NETHER_MALACHITE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
//            (Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.NETHERRACK,
//                    MysticGemstonesBlock.MALACHITE_ORE.getStateManager().getDefaultState(),
//                    Config.NetherOre.veinSize));
//
//    public static PlacedFeature NETHER_MALACHITE_ORE_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(NETHER_MALACHITE_ORE_CONFIGURED_FEATURE),
//            Arrays.asList(
//                    CountPlacementModifier.of(Config.NetherOre.veinsPerChunk),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.uniform(Config.NetherOre.minHeight, Config.NetherOre.maxHeight)
//            ));
//
//    // White Sapphire
//    private static ConfiguredFeature<?, ?> NETHER_WHITE_SAPPHIRE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
//            (Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.NETHERRACK,
//                    MysticGemstonesBlock.WHITE_SAPPHIRE_ORE.getStateManager().getDefaultState(),
//                    Config.NetherOre.veinSize));
//
//    public static PlacedFeature NETHER_WHITE_SAPPHIRE_ORE_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(NETHER_WHITE_SAPPHIRE_ORE_CONFIGURED_FEATURE),
//            Arrays.asList(
//                    CountPlacementModifier.of(Config.NetherOre.veinsPerChunk),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.uniform(Config.NetherOre.minHeight, Config.NetherOre.maxHeight)
//            ));
//
//    public static void register() {
//        // Aquamarine
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_AQUAMARINE_ORE), OVERWORLD_AQUAMARINE_ORE_CONFIGURED_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_AQUAMARINE_ORE),
//                OVERWORLD_AQUAMARINE_ORE_PLACED_FEATURE);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
//                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_AQUAMARINE_ORE)));
//
//        // Jasper
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_JASPER_ORE), OVERWORLD_JASPER_ORE_CONFIGURED_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_JASPER_ORE),
//                OVERWORLD_JASPER_ORE_PLACED_FEATURE);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
//                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_JASPER_ORE)));
//
//        // Alexandrite
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_ALEXANDRITE_ORE), OVERWORLD_ALEXANDRITE_ORE_CONFIGURED_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_ALEXANDRITE_ORE),
//                OVERWORLD_ALEXANDRITE_ORE_PLACED_FEATURE);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
//                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_ALEXANDRITE_ORE)));
//
//        // Sapphire
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_SAPPHIRE_ORE), OVERWORLD_SAPPHIRE_ORE_CONFIGURED_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_SAPPHIRE_ORE),
//                OVERWORLD_SAPPHIRE_ORE_PLACED_FEATURE);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
//                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_SAPPHIRE_ORE)));
//
//        // Topaz
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_TOPAZ_ORE), OVERWORLD_TOPAZ_ORE_CONFIGURED_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_TOPAZ_ORE),
//                OVERWORLD_TOPAZ_ORE_PLACED_FEATURE);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
//                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_TOPAZ_ORE)));
//
//        // Starstone
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//                new Identifier(Constant.MOD_ID, Constant.OVERWORLD_STARSTONE_ORE), OVERWORLD_STARSTONE_ORE_CONFIGURED_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.OVERWORLD_STARSTONE_ORE),
//                OVERWORLD_STARSTONE_ORE_PLACED_FEATURE);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
//                        new Identifier(Constant.MOD_ID, Constant.OVERWORLD_STARSTONE_ORE)));
//
//        // Malachite
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//                new Identifier(Constant.MOD_ID, Constant.NETHER_MALACHITE_ORE), NETHER_MALACHITE_ORE_CONFIGURED_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.NETHER_MALACHITE_ORE),
//                NETHER_MALACHITE_ORE_PLACED_FEATURE);
//        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
//                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
//                        new Identifier(Constant.MOD_ID, Constant.NETHER_MALACHITE_ORE)));
//
//        // White Sapphire
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
//                new Identifier(Constant.MOD_ID, Constant.NETHER_WHITE_SAPPHIRE_ORE), NETHER_WHITE_SAPPHIRE_ORE_CONFIGURED_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constant.MOD_ID, Constant.NETHER_WHITE_SAPPHIRE_ORE),
//                NETHER_WHITE_SAPPHIRE_ORE_PLACED_FEATURE);
//        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
//                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
//                        new Identifier(Constant.MOD_ID, Constant.NETHER_WHITE_SAPPHIRE_ORE)));
//    }
}
