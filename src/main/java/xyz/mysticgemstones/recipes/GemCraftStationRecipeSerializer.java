package xyz.mysticgemstones.recipes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;


public class GemCraftStationRecipeSerializer implements RecipeSerializer<GemCraftStationRecipe> {
    private GemCraftStationRecipeSerializer() {}

    public static final GemCraftStationRecipeSerializer INSTANCE = new GemCraftStationRecipeSerializer();

    public static final Identifier ID = new Identifier("mysticgemstones:gem_craft_station_recipe");

    @Override
    // Turns json into Recipe
    public GemCraftStationRecipe read(Identifier id, JsonObject json) {
        GemCraftStationRecipeJsonFormat recipeJson = new Gson().fromJson(json, GemCraftStationRecipeJsonFormat.class);

        if (recipeJson.frameInput == null || recipeJson.gemInput == null || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
        }

        Ingredient frameInput = Ingredient.fromJson(recipeJson.frameInput);
        Ingredient gemInput = Ingredient.fromJson(recipeJson.gemInput);
        Item outputItem = Registries.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                // Validate the inputted item actually exists
                .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, 1);

        return new GemCraftStationRecipe(id, output, frameInput, gemInput);
    }

    @Override
    // Turns Recipe into PacketByteBuf
    public void write(PacketByteBuf packetData, GemCraftStationRecipe recipe) {
        recipe.getFrameInput().write(packetData);
        recipe.getGemInput().write(packetData);
        packetData.writeItemStack(recipe.getOutput());
    }

    @Override
    // Turns PacketByteBuf into Recipe
    public GemCraftStationRecipe read(Identifier id, PacketByteBuf packetData) {
        Ingredient frameInput = Ingredient.fromPacket(packetData);
        Ingredient gemInput = Ingredient.fromPacket(packetData);
        ItemStack output = packetData.readItemStack();
        return new GemCraftStationRecipe(id, output, frameInput, gemInput);
    }
}
