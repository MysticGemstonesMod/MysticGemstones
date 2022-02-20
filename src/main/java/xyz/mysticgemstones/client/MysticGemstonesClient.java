package xyz.mysticgemstones.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import xyz.mysticgemstones.MysticGemstones;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.block.entity.renderer.GemInfuserEntityRenderer;
import xyz.mysticgemstones.screenhandler.GemCraftStationScreen;

@Environment(EnvType.CLIENT)
public class MysticGemstonesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(MysticGemstones.GEM_INFUSER_SCREEN_HANDLER, GemCraftStationScreen::new);
        BlockEntityRendererRegistry.register(MysticGemstonesBlock.GEM_INFUSER_ENTITY, GemInfuserEntityRenderer::new);
        BlockTransparency.register();
        FabricModelPredicateProviders.register();
    }
}