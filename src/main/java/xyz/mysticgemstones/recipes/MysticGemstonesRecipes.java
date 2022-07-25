package xyz.mysticgemstones.recipes;

import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, "crafting_special_gem_bag", new SpecialRecipeSerializer<>(GemBagRecipe::new));
        Registry.register(Registry.RECIPE_SERIALIZER, GemCraftStationRecipeSerializer.ID, GemCraftStationRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Constant.MOD_ID, GemCraftStationRecipe.Type.ID), GemCraftStationRecipe.Type.INSTANCE);
    }
}
