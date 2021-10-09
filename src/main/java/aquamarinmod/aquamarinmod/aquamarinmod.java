package aquamarinmod.aquamarinmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class aquamarinmod implements ModInitializer {

    // Items
    private static final Item AQUAMARIN_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    private static final Item RAW_AQUAMARIN = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    // Blocks
    private static final Block AQUAMARIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F));

    @Override
    public void onInitialize() {
        // Items
        Registry.register(Registry.ITEM, new Identifier("aquamarinmod", "aquamarin"), AQUAMARIN_ITEM);
        Registry.register(Registry.ITEM, new Identifier("aquamarinmod", "raw_aquamarin"), RAW_AQUAMARIN);

        //Blocks
        Registry.register(Registry.BLOCK, new Identifier("aquamarinmod", "aquamarin_ore"), AQUAMARIN_ORE);
        Registry.register(Registry.ITEM, new Identifier("aquamarinmod", "aquamarin_ore"), new BlockItem(AQUAMARIN_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
    }
}
