package mysticgemstones.mysticgemstones.block;

import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RockTumbler extends Block {

    public RockTumbler(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        // Should probably use method overloading or variables or something like that for these if statments so there is no duplicate code....
        // Once in future hopefully...
        if (!world.isClient && itemStack.isOf(MysticGemstonesItem.RAW_AQUAMARINE)) {
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            Block.dropStack(world, pos, new ItemStack(MysticGemstonesItem.AQUAMARINE_ITEM));
            world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
        }
        if (!world.isClient && itemStack.isOf(MysticGemstonesItem.RAW_ALEXANDRITE)) {
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            Block.dropStack(world, pos, new ItemStack(MysticGemstonesItem.ALEXANDRITE_ITEM));
            world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
        }
        if (!world.isClient && itemStack.isOf(MysticGemstonesItem.RAW_JASPER)) {
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            Block.dropStack(world, pos, new ItemStack(MysticGemstonesItem.JASPER_ITEM));
            world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
        }
        return ActionResult.SUCCESS;
    }
}
