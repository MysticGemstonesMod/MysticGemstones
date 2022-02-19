package xyz.mysticgemstones;

import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.block.entity.StarstoneOreEntity;
import xyz.mysticgemstones.item.MysticGemstonesItem;
import xyz.mysticgemstones.statusEffects.MysticGemstonesStatusEffect;

public class MysticGemstones implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("mysticgemstones");

//	public static final RecipeType<GemBagRecipe> TEST_RECIPE_TYPE;
//
//	public static final RecipeSerializer<GemBagRecipe> TEST_RECIPE_SERIALIZER;
//
//	TEST_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(Constant.MOD_ID, "test_furnace"), new RecipeType<TestRecipe>() {
//		@Override
//		public String toString() {
//			return "test_furnace";
//		}
//	});
//
//	TEST_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, "test_furnace"), new CookingRecipeSerializer(TestRecipe::new, 200));


	@Override
	public void onInitialize() {
		MysticGemstonesBlock.register();
		MysticGemstonesItem.register();
		StarstoneOreEntity.RegisterEntity();
		MysticGemstonesStatusEffect.register();

		Registry.register(Registry.RECIPE_SERIALIZER, "crafting_special_gem_bag", new SpecialRecipeSerializer<>(GemBagRecipe::new));
	}
}
