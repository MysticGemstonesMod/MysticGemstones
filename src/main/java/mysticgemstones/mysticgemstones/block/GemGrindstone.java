package mysticgemstones.mysticgemstones.block;

import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.security.SecureRandom;

public class GemGrindstone extends Block {

    public GemGrindstone(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (!world.isClient) {
            ItemStack item = player.getStackInHand(hand);

            if (item.isOf(MysticGemstonesItem.RAW_AQUAMARINE)) {
                polishGem(player, hand, world, pos, MysticGemstonesItem.AQUAMARINE_ITEM);
            }

            if (item.isOf(MysticGemstonesItem.RAW_ALEXANDRITE)) {
                polishGem(player, hand, world, pos, MysticGemstonesItem.ALEXANDRITE_ITEM);
            }

            if (item.isOf(MysticGemstonesItem.RAW_JASPER)) {
                polishGem(player, hand, world, pos, MysticGemstonesItem.JASPER_ITEM);
            }
        }
        return ActionResult.SUCCESS;
    }

    private void polishGem(PlayerEntity player, Hand hand, World world, BlockPos pos, Item item) {
        if (rng() >= 9) {   // 20% chance of item breaking
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1f, 1f);
        }
        else {
        world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
        if (rng() <= 2) {   // 0 = 0%, 1 = 10%, 2 = 20%, 3 = 30% etc...up to 10 = 100% chance to polish item with 1 mouse click
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            Block.dropStack(world, pos, new ItemStack(item));
            }
        }
    }

    private int rng() {
        int max = 11;
        int min = 1;
        int number = new SecureRandom().nextInt(max - min) + min;
        return number;
    }
}
