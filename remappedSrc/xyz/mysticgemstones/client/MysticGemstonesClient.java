package xyz.mysticgemstones.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.block.entity.renderer.GemInfuserEntityRenderer;
import xyz.mysticgemstones.particles.MysticGemstonesParticleTypes;
import xyz.mysticgemstones.screen.GemBookScreen;
import xyz.mysticgemstones.screen.GemCraftStationScreen;
import xyz.mysticgemstones.screen.MysticGemstonesScreenType;

@Environment(EnvType.CLIENT)
public class MysticGemstonesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(MysticGemstonesScreenType.GEM_CRAFT_STATION_SCREEN_HANDLER, GemCraftStationScreen::new);
        ScreenRegistry.register(MysticGemstonesScreenType.GEM_BOOK_SCREEN_HANDLER, GemBookScreen::new);
        BlockEntityRendererRegistry.register(MysticGemstonesBlock.GEM_INFUSER_ENTITY, GemInfuserEntityRenderer::new);
        BlockTransparency.register();
        FabricModelPredicateProviders.register();
        MysticGemstonesParticleTypes.registerClient();
    }
}