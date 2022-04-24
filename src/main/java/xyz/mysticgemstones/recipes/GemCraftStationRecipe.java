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
    private final Ingredient frameInput;
    private final Ingredient gemInput;
    private final ItemStack result;
    private final Identifier id;

    public GemCraftStationRecipe(Identifier id, ItemStack result, Ingredient frameInput, Ingredient gemInput) {
        this.id = id;
        this.frameInput = frameInput;
        this.gemInput = gemInput;
        this.result = result;
    }

    public Ingredient getFrameInput() {
        return this.frameInput;
    }

    public Ingredient getGemInput() {
        return this.gemInput;
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        boolean frameInput = false;
        boolean gemInput = false;
        if (this.frameInput.test(inventory.getStack(1))) frameInput = true;
        if (this.gemInput.test(inventory.getStack(2))) gemInput = true;
        return frameInput && gemInput;
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
