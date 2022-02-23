package xyz.mysticgemstones.recipes;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class GemCraftStationRecipe implements Recipe<CraftingInventory> {
    private final Ingredient inputA;
    private final Ingredient inputB;
    private final ItemStack result;
    private final Identifier id;

    public GemCraftStationRecipe(Identifier id, ItemStack result, Ingredient inputA, Ingredient inputB) {
        this.id = id;
        this.inputA = inputA;
        this.inputB = inputB;
        this.result = result;
    }

    public Ingredient getInputA() {
        return this.inputA;
    }

    public Ingredient getInputB() {
        return this.inputB;
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        if(inventory.size() < 2) return false;
        boolean inputA = false;
        boolean inputB = false;
        for (int i = 0; i <= inventory.size(); i++) {
            if (this.inputA.test(inventory.getStack(i))) inputA = true;
            if (this.inputB.test(inventory.getStack(i))) inputB = true;
        }
        return inputA && inputB;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        return this.getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return this.result;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return GemCraftStationRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<GemCraftStationRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "gem_craft_station_recipe";
    }
}
