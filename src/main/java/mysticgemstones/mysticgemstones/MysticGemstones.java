package mysticgemstones.mysticgemstones;

import mysticgemstones.mysticgemstones.block.MysticGemstonesBlock;
import mysticgemstones.mysticgemstones.generation.OreGeneration;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.fabricmc.api.ModInitializer;
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

public class MysticGemstones implements ModInitializer {


    @Override
    public void onInitialize() {

        MysticGemstonesBlock.AddAndRegisterBlocks();
        MysticGemstonesItem.AddAndRegisterItem();
        OreGeneration.RegisterOreGeneration();

    }
}
