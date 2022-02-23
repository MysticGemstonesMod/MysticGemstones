package xyz.mysticgemstones.recipes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class GemCraftStationRecipeSerializer implements RecipeSerializer<GemCraftStationRecipe> {

    // Define ExampleRecipeSerializer as a singleton by making its constructor private and exposing an instance.
    private GemCraftStationRecipeSerializer() {
    }

    public static final GemCraftStationRecipeSerializer INSTANCE = new GemCraftStationRecipeSerializer();

    // This will be the "type" field in the json
    public static final Identifier ID = new Identifier("mysticgemstones:gem_craft_station_recipe"); // Could be wrong and cause errors!!! Identifier string that is..

    @Override
    // Turns json into Recipe
    public GemCraftStationRecipe read(Identifier id, JsonObject json) {
        GemCraftStationRecipeJsonFormat recipeJson = new Gson().fromJson(json, GemCraftStationRecipeJsonFormat.class); // Gson has 2 imports if some errors happen maybe I imported the wrong class

        // Validate all fields are there
        if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("A required attribute is missing!"); // 2 import if error try another import
        }
        // We'll allow to not specify the output, and default it to 1.
        if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

        // Ingredient easily turns JsonObjects of the correct format into Ingredients
        Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
        Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
        // The json will specify the item ID. We can get the Item instance based off of that from the Item registry.
        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                // Validate the inputted item actually exists
                .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);

        return new GemCraftStationRecipe(id, output, inputA, inputB);
    }

    @Override
    // Turns Recipe into PacketByteBuf
    public void write(PacketByteBuf packetData, GemCraftStationRecipe recipe) {
        recipe.getInputA().write(packetData);
        recipe.getInputB().write(packetData);
        packetData.writeItemStack(recipe.getOutput());
    }

    @Override
    // Turns PacketByteBuf into Recipe
    public GemCraftStationRecipe read(Identifier id, PacketByteBuf packetData) {
        Ingredient inputA = Ingredient.fromPacket(packetData);
        Ingredient inputB = Ingredient.fromPacket(packetData);
        ItemStack output = packetData.readItemStack();
        return new GemCraftStationRecipe(id, output, inputA, inputB);
    }
}
