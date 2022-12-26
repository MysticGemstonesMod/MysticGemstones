package xyz.mysticgemstones.item;

import net.minecraft.item.Item;

public class GemBook extends Item {
    // TODO
//    private final Text TITLE = new LiteralText("");
    public GemBook(Settings settings) {
        super(settings);
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        user.openHandledScreen(createScreenHandlerFactory());
//        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
//    }

//    public NamedScreenHandlerFactory createScreenHandlerFactory() {
//        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new GemBookScreenHandler(syncId, inventory), TITLE);
//    }
}
