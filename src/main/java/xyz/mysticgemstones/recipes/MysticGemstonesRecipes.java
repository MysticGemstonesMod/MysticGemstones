package xyz.mysticgemstones.recipes;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesRecipes {
    public static void register() {
        // TODO
//        Registry.register(Registries.RECIPE_SERIALIZER, "crafting_special_gem_bag", new SpecialRecipeSerializer<>(GemBagRecipe::new));
        Registry.register(Registries.RECIPE_SERIALIZER, GemCraftStationRecipeSerializer.ID, GemCraftStationRecipeSerializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Constant.MOD_ID, GemCraftStationRecipe.Type.ID), GemCraftStationRecipe.Type.INSTANCE);
    }
}
