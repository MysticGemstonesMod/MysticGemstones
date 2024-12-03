package xyz.domza.mystic_gemstones;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import xyz.domza.mystic_gemstones.datagen.MysticGemstonesWorldGenerator;
import xyz.domza.mystic_gemstones.world.MysticGemstonesConfiguredFeatures;
import xyz.domza.mystic_gemstones.world.MysticGemstonesPlacedFeatures;

public class MysticGemstonesDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MysticGemstonesWorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, MysticGemstonesConfiguredFeatures::boostrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, MysticGemstonesPlacedFeatures::boostrap);
    }
}
