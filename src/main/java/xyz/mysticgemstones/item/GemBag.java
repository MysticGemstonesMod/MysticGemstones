package xyz.mysticgemstones.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GemBag extends Item {
    public GemBag(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.getStackInHand(hand).hasNbt()) {
            int number = user.getStackInHand(hand).getNbt().getInt("amount");
            NbtCompound nbtData = new NbtCompound();

            if (number > 0) {
                BlockPos pos = user.getBlockPos();
                if (user.isSneaking()) {
                    for (int i = 0; i < number; i++) {
                        Block.dropStack(world, pos, new ItemStack(MysticGemstonesItem.RAW_STARSTONE));
                    }
                    number = 0;
                }
                else {
                    number--;
                    Block.dropStack(world, pos, new ItemStack(MysticGemstonesItem.RAW_STARSTONE));
                }
                nbtData.putInt("amount", number);
                user.getStackInHand(hand).setNbt(nbtData);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand), true);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            int nbtData = stack.getNbt().getInt("amount");
            if (nbtData < 1) {
                tooltip.add(new TranslatableText("item.mysticgemstones.gem_bag.tooltip_2").formatted(Formatting.RED));
            }
            else {
                tooltip.add(new LiteralText(nbtData + " - Raw Starstone").formatted(Formatting.DARK_PURPLE));
            }
        }
    }
}
