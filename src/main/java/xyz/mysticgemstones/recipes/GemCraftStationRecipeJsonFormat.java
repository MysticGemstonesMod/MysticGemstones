package xyz.mysticgemstones.recipes;

import com.google.gson.JsonObject;

public class GemCraftStationRecipeJsonFormat {
    JsonObject inputA;
    JsonObject inputB;
    String outputItem;
    int outputAmount;

    public JsonObject getInputA() {
        return inputA;
    }

    public JsonObject getInputB() {
        return inputB;
    }

    public String getOutputItem() {
        return outputItem;
    }

    public int getOutputAmount() {
        return outputAmount;
    }
}
