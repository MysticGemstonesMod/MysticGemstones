package xyz.domza.mystic_gemstones.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.domza.mystic_gemstones.Constant;

public class MysticGemstonesRecipe {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Constant.MOD_ID, GrindingRecipe.Serializer.ID),
                GrindingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Constant.MOD_ID, GrindingRecipe.Type.ID),
                GrindingRecipe.Type.INSTANCE);

    }
}
