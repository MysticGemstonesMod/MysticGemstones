package xyz.mysticgemstones.screenhandler;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesScreen {
    public static final ScreenHandlerType<GemCraftStationScreenHandler> GEM_CRAFT_STATION_SCREEN_HANDLER;

    static {
        GEM_CRAFT_STATION_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Constant.MOD_ID, "gem_craft_station_screen"), GemCraftStationScreenHandler::new);
    }
}
