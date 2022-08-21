package xyz.mysticgemstones;

import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.events.MysticGemstonesEvents;
import xyz.mysticgemstones.item.MysticGemstonesItem;
import xyz.mysticgemstones.particles.MysticGemstonesParticleTypes;
import xyz.mysticgemstones.recipes.InfusingRecipe;
import xyz.mysticgemstones.recipes.MysticGemstonesRecipes;
import xyz.mysticgemstones.statuseffects.MysticGemstonesStatusEffect;
import xyz.mysticgemstones.worldgen.MysticGemstonesOreGen;

public class MysticGemstones implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger(Constant.MOD_ID);

	public static final RecipeType<InfusingRecipe> INFUSING_RECIPE_TYPE;
	public static final RecipeSerializer<InfusingRecipe> INFUSING_RECIPE_SERIALIZER;

	static {
		INFUSING_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(Constant.MOD_ID, "infusing_recipe"),
				new RecipeType<InfusingRecipe>() {
			@Override
			public String toString() {return "infusing_recipe";}
		});
		INFUSING_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Constant.MOD_ID, "infusing_recipe"),
				new CookingRecipeSerializer<>(InfusingRecipe::new, 200));
	}

	@Override
	public void onInitialize() {
		MysticGemstonesBlock.register();
		MysticGemstonesBlock.registerEntity();
		MysticGemstonesItem.register();
		MysticGemstonesStatusEffect.register();
		MysticGemstonesRecipes.register();
		MysticGemstonesParticleTypes.register();
		MysticGemstonesOreGen.register();
		MysticGemstonesEvents.registerEvents();
	}
}
