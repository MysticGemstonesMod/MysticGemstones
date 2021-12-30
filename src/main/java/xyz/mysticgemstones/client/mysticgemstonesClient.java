package xyz.mysticgemstones.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import xyz.mysticgemstones.MysticGemstones;
import xyz.mysticgemstones.block.GemInfuserScreen;

@Environment(EnvType.CLIENT)
public class mysticgemstonesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(MysticGemstones.GEM_INFUSER_SCREEN_HANDLER, GemInfuserScreen::new);
    }
}