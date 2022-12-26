package xyz.mysticgemstones.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesScreenType {
    public static final ScreenHandlerType<GemCraftStationScreenHandler> GEM_CRAFT_STATION_SCREEN_HANDLER;
    public static final ScreenHandlerType<GemBookScreenHandler> GEM_BOOK_SCREEN_HANDLER;

    static {
        GEM_CRAFT_STATION_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Constant.MOD_ID, "gem_craft_station_screen"), GemCraftStationScreenHandler::new);
        GEM_BOOK_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Constant.MOD_ID, "gem_book_screen"), GemBookScreenHandler::new);
    }
}
