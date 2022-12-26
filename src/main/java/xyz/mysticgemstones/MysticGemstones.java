package xyz.mysticgemstones;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.events.MysticGemstonesEvents;
import xyz.mysticgemstones.item.MysticGemstonesItems;
import xyz.mysticgemstones.particles.MysticGemstonesParticleTypes;
import xyz.mysticgemstones.recipes.MysticGemstonesRecipes;
import xyz.mysticgemstones.statuseffects.MysticGemstonesStatusEffect;

public class MysticGemstones implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger(Constant.MOD_ID);

//	public static final RecipeType<InfusingRecipe> INFUSING_RECIPE_TYPE;
//	public static final RecipeSerializer<InfusingRecipe> INFUSING_RECIPE_SERIALIZER;

//	static {
//		INFUSING_RECIPE_TYPE = Registry.register(Registries.RECIPE_TYPE, new Identifier(Constant.MOD_ID, "infusing_recipe"),
//				new RecipeType<InfusingRecipe>() {
//			@Override
//			public String toString() {return "infusing_recipe";}
//		});
//		INFUSING_RECIPE_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Constant.MOD_ID, "infusing_recipe"),
//				new CookingRecipeSerializer<>(InfusingRecipe::new, 200));
//	}

	@Override
	public void onInitialize() {
		MysticGemstonesBlock.register();
		MysticGemstonesBlock.registerEntity();
		MysticGemstonesItems.register();
		MysticGemstonesStatusEffect.register();
		MysticGemstonesRecipes.register();
		MysticGemstonesParticleTypes.register();
//		MysticGemstonesOreGen.register();
		MysticGemstonesEvents.registerEvents();
	}
}
