package xyz.mysticgemstones.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.mysticgemstones.recipes.GemCraftStationRecipe;
import xyz.mysticgemstones.screenhandler.GemCraftStationScreenHandler;

import java.util.Optional;

public class GemGlass extends TransparentBlock {
    protected GemGlass(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // Something that gives the player items should always go through the server.
        // If you need to notify the client in some way, check in the server and then send a packet to the client.
        if (!world.isClient()) {
            // For the sake of simplicity we draw the items off of the player's hands and create an inventory from that.
            // Usually you use an inventory of yours instead.
            CraftingInventory inventory = new CraftingInventory(new GemCraftStationScreenHandler(1 , player.getInventory()), 2, 2); // SyncId 1 is just random int so could implement bugs

            // Or use .getAllMatches if you want all of the matches
            Optional<GemCraftStationRecipe> match = world.getRecipeManager().getFirstMatch(GemCraftStationRecipe.Type.INSTANCE, inventory, world);

            if (match.isPresent()) {
                // Give the player the item and remove from what he has. Make sure to copy the ItemStack to not ruin it!
                player.getInventory().offerOrDrop(match.get().getOutput().copy());
                player.getMainHandStack().decrement(1);
                player.getOffHandStack().decrement(1);
                player.sendMessage(new LiteralText("Ah jeste"), false);
            } else {
                // If it doesn't match we tell the player
                player.sendMessage(new LiteralText("No match!"), false);
            }
        }
        return ActionResult.SUCCESS;
    }
}