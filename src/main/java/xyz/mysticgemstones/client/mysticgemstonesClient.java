package xyz.mysticgemstones.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import xyz.mysticgemstones.MysticGemstones;
import xyz.mysticgemstones.block.GemInfuserScreen;
import xyz.mysticgemstones.block.MysticGemstonesBlock;

@Environment(EnvType.CLIENT)
public class mysticgemstonesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(MysticGemstones.GEM_INFUSER_SCREEN_HANDLER, GemInfuserScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(MysticGemstonesBlock.HARDENED_STARSTONE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MysticGemstonesBlock.HARDENED_AQUAMARINE_GLASS, RenderLayer.getTranslucent());
    }
}