package xyz.mysticgemstones.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.MysticGemstones;

public class InfusingRecipe extends AbstractCookingRecipe {
    public InfusingRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(MysticGemstones.INFUSING_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MysticGemstones.INFUSING_RECIPE_SERIALIZER;
    }
}
