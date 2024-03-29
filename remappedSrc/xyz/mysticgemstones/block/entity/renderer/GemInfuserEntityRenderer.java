package xyz.mysticgemstones.block.entity.renderer;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class GemInfuserEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {

    public GemInfuserEntityRenderer(BlockEntityRendererFactory.Context ctx) {}


    // TODO - Display number of items in inventory above displayed item
    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = null;
        if (!((Inventory) entity).getStack(1).isEmpty()) {
            stack = ((Inventory) entity).getStack(1);
        } else if (!((Inventory) entity).getStack(0).isEmpty()) {
            stack = ((Inventory) entity).getStack(0);
        }
        if (stack != null) {
            matrices.push();
            // Move the item
            matrices.translate(0.5, 1.0, 0.5);
            matrices.scale(0.7F, 0.7F, 0.7F);
            // Rotate the item
            // TODO
//            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((entity.getWorld().getTime() + tickDelta) * 4));
            // Calculate light
            int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
            MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            // Mandatory call after GL calls
            matrices.pop();
        }
    }
}
