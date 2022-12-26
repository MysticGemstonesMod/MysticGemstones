package xyz.mysticgemstones.item.rings;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import xyz.mysticgemstones.tags.MysticGemstonesTags;

public abstract class GemRing extends Item {
    private final int cooldown;

    public GemRing(Settings settings, int cooldown) {
        super(settings);
        this.cooldown = cooldown;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            if (canUse(user)) {
                doMagic(world, user, hand);
                user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(), cooldown);
                ItemStack stack = user.getStackInHand(hand);
                stack.damage(1, user, (e) -> {
                    e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
                });
            } else {
                // TODO
//                user.sendMessage(new TranslatableText("Another ring is cooling down... Please wait"), true);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand), true);
    }

    public boolean canUse(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.isIn(MysticGemstonesTags.GEM_RINGS)) {
                if (player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                    return false;
                }
            }
        }
        return true;
    }

    public abstract void doMagic(World world, PlayerEntity player, Hand hand);

    // TODO
//    @Override
//    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        tooltip.add(new TranslatableText("item.mysticgemstones.not_implemented.tooltip_1").formatted(Formatting.RED));
//    }
}
