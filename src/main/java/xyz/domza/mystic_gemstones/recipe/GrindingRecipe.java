package xyz.domza.mystic_gemstones.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class GrindingRecipe implements Recipe<SimpleInventory> {
    private final ItemStack successOutput;
    private final ItemStack failedOutput;
    private final Ingredient ingredient;
    private final float successChance;

    public GrindingRecipe( Ingredient ingredient, ItemStack successOutput, ItemStack failedOutput, float successChance) {
        this.successOutput = successOutput;
        this.failedOutput = failedOutput;
        this.ingredient = ingredient;
        this.successChance = (float)Math.max(0.01, Math.min(1.0, successChance));
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient) {
            return false;
        }
        return ingredient.test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, RegistryWrapper.WrapperLookup lookup) {
        // 50% Chance that it tries to craft.
        if (Math.random() < 0.5) {
            // Success chance defined in recipe or 100% if not defined
            if (Math.random() < this.successChance) {
                return successOutput;

            } else {
                return failedOutput;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return successOutput;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    private ItemStack getSuccessOutput() {
        return successOutput;
    }

    public ItemStack getFailedOutput() {
        return failedOutput;
    }

    public float getSuccessChance() {
        return successChance;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<GrindingRecipe> {
        public static final Type INSTANCE =  new Type();
        public static final String ID = "grinding_recipe";
    }

    public static class Serializer implements RecipeSerializer<GrindingRecipe> {
        public static final Serializer INSTANCE =  new Serializer();
        public static final String ID = "grinding_recipe";

        private static final MapCodec<GrindingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient")
                        .forGetter(GrindingRecipe::getIngredient),
                ItemStack.VALIDATED_CODEC.fieldOf("successOutput")
                        .forGetter(GrindingRecipe::getSuccessOutput),
                ItemStack.VALIDATED_CODEC.fieldOf("failedOutput").orElse(ItemStack.EMPTY)
                        .forGetter(GrindingRecipe::getFailedOutput),
                PrimitiveCodec.FLOAT.fieldOf("successChance").orElse(1.0f)
                        .forGetter(GrindingRecipe::getSuccessChance)
        ).apply(instance, GrindingRecipe::new));


        // Define the packet codec for efficient network transfer
        public static final PacketCodec<RegistryByteBuf, GrindingRecipe> PACKET_CODEC = PacketCodec.ofStatic(Serializer::write, Serializer::read);

        @Override
        public MapCodec<GrindingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, GrindingRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        // Reads a GrindingRecipe from the RegistryByteBuf
        private static GrindingRecipe read(RegistryByteBuf buf) {
            Ingredient ingredient = (Ingredient) Ingredient.PACKET_CODEC.decode(buf);
            ItemStack successOutput = (ItemStack) ItemStack.PACKET_CODEC.decode(buf);
            ItemStack failedOutput = (ItemStack) ItemStack.PACKET_CODEC.decode(buf);
            float successChance = buf.readFloat();
            return new GrindingRecipe(ingredient, successOutput, failedOutput, successChance);
        }

        // Writes a GrindingRecipe to the RegistryByteBuf
        private static void write(RegistryByteBuf buf, GrindingRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.getIngredient());
            ItemStack.PACKET_CODEC.encode(buf, recipe.getSuccessOutput());
            ItemStack.PACKET_CODEC.encode(buf, recipe.getFailedOutput());
            buf.writeFloat(recipe.getSuccessChance());
        }
    }
}