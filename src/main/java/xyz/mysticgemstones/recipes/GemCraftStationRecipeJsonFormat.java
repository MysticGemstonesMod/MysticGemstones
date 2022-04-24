package xyz.mysticgemstones.recipes;

import com.google.gson.JsonObject;

public class GemCraftStationRecipeJsonFormat {
    JsonObject frameInput;
    JsonObject gemInput;
    String outputItem;

    public JsonObject getFrameInput() {
        return frameInput;
    }

    public JsonObject getGemInput() {
        return gemInput;
    }

    public String getOutputItem() {
        return outputItem;
    }
}
