package xyz.mysticgemstones.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import xyz.mysticgemstones.screen.GemBookScreenHandler;

public class GemBook extends Item {
    private final Text TITLE = new LiteralText("");
    public GemBook(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.openHandledScreen(createScreenHandlerFactory());
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }

    public NamedScreenHandlerFactory createScreenHandlerFactory() {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new GemBookScreenHandler(syncId, inventory), TITLE);
    }
}
