package xyz.mysticgemstones;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.mysticgemstones.recipes.GemBagRecipe;
import xyz.mysticgemstones.recipes.GemCraftStationRecipe;
import xyz.mysticgemstones.recipes.GemCraftStationRecipeSerializer;
import xyz.mysticgemstones.screenhandler.GemCraftStationScreenHandler;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.item.MysticGemstonesItem;
import xyz.mysticgemstones.statusEffects.MysticGemstonesStatusEffect;


public class MysticGemstones implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("mysticgemstones");
	public static final ScreenHandlerType<GemCraftStationScreenHandler> GEM_INFUSER_SCREEN_HANDLER;

	static {
		GEM_INFUSER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Constant.MOD_ID, "gem_infuser_screen"), GemCraftStationScreenHandler::new);
	}

	@Override
	public void onInitialize() {
		MysticGemstonesBlock.register();
		MysticGemstonesBlock.registerEntity();
		MysticGemstonesItem.register();
		MysticGemstonesStatusEffect.register();
		Registry.register(Registry.RECIPE_SERIALIZER, "crafting_special_gem_bag", new SpecialRecipeSerializer<>(GemBagRecipe::new));

		Registry.register(Registry.RECIPE_SERIALIZER, GemCraftStationRecipeSerializer.ID, GemCraftStationRecipeSerializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier("mysticgemstones", GemCraftStationRecipe.Type.ID), GemCraftStationRecipe.Type.INSTANCE);
	}
}
