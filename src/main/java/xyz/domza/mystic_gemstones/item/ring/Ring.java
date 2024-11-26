package xyz.domza.mystic_gemstones.item.ring;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public abstract class Ring extends Item {
    private final int cooldown;

    public Ring(Settings settings) {
        this(settings, 10, 30);
    }

    public Ring(Settings settings, int maxDamage, int cooldown) {
        super(settings.maxCount(1).maxDamage(maxDamage));
        this.cooldown = cooldown;
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamage() < stack.getMaxDamage();
    }

    // TODO: By default add "On Use:" text for first tooltip, and then anything that extends Ring must implement appendTooltip to add second tooltip which explains what specific Ring does.
    @Override
    public abstract void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type);

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!isUsable(itemStack)) {
            return TypedActionResult.fail(itemStack);
        }
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        user.getItemCooldownManager().set(this, cooldown);
        useRing(world, user, itemStack);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        itemStack.setDamage(itemStack.getDamage() + 1);

        return TypedActionResult.success(itemStack, world.isClient());
    }

    abstract void useRing(World world, PlayerEntity user, ItemStack ring);
}
