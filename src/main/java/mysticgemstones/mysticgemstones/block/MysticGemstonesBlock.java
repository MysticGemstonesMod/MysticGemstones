package mysticgemstones.mysticgemstones.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.ToIntFunction;

public class MysticGemstonesBlock {

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(StarstoneOre.SHINING) ? litLevel : 0;
        };
    }

    // Add block
    public static final Block AQUAMARIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F));
    public static final Block JASPER_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F));
    public static final Block ALEXANDRITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F));
    public static final StarstoneOre STARSTONE_ORE = new StarstoneOre(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).luminance(createLightLevelFromLitBlockState(15)));


    public static void AddAndRegisterBlocks() {

        // Register block
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "aquamarin_ore"), AQUAMARIN_ORE);
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "jasper_ore"), JASPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "alexandrite_ore"), ALEXANDRITE_ORE);
        Registry.register(Registry.BLOCK, new Identifier("mysticgemstones", "starstone_ore"), STARSTONE_ORE);

        // Register block item
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "aquamarin_ore"), new BlockItem(AQUAMARIN_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "jasper_ore"), new BlockItem(JASPER_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "alexandrite_ore"), new BlockItem(ALEXANDRITE_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("mysticgemstones", "starstone_ore"), new BlockItem(STARSTONE_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    }
}
