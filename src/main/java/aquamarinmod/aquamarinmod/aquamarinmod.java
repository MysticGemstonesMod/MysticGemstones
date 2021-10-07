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
    private static final Item AQUAMARIN_ITEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(322));
    // Blocks
    private static final Block AQUAMIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F).luminance(4));

    @Override
    public void onInitialize() {
        // Items
        Registry.register(Registry.ITEM, new Identifier("aquamarinmod", "aquamarin"), AQUAMARIN_ITEM);
        //Blocks
        Registry.register(Registry.BLOCK, new Identifier("aquamarinmod", "aquamarin_ore"), AQUAMIN_ORE);
        Registry.register(Registry.ITEM, new Identifier("aquamarinmod", "aquamarin_ore"), new BlockItem(AQUAMIN_ORE, new FabricItemSettings().group(ItemGroup.MATERIALS)));
    }
}
