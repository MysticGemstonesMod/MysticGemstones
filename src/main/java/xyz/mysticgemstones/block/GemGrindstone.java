package xyz.mysticgemstones.block;

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
import xyz.mysticgemstones.MysticGemstoneTags;
import xyz.mysticgemstones.item.MysticGemstonesItem;

public class GemGrindstone extends Block {

    public GemGrindstone(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (player.getStackInHand(hand).isIn(MysticGemstoneTags.RAW_GEMS)) {

                ItemStack item = player.getStackInHand(hand);

                if (item.isOf(MysticGemstonesItem.RAW_AQUAMARINE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.AQUAMARINE_ITEM, MysticGemstonesItem.AQUAMARINE_DUST, 40, 10, 4);
                }
                if (item.isOf(MysticGemstonesItem.RAW_ALEXANDRITE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.ALEXANDRITE_ITEM, MysticGemstonesItem.ALEXANDRITE_DUST, 40, 10, 4);
                }
                if (item.isOf(MysticGemstonesItem.RAW_JASPER)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.JASPER_ITEM, MysticGemstonesItem.JASPER_DUST, 40, 10, 4);
                }
                if (item.isOf(MysticGemstonesItem.RAW_TOPAZ)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.TOPAZ_ITEM, MysticGemstonesItem.TOPAZ_DUST, 35, 10, 3);
                }
                if (item.isOf(MysticGemstonesItem.RAW_MALACHITE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.MALACHITE_ITEM, MysticGemstonesItem.MALACHITE_DUST, 35, 10, 3);
                }
                if (item.isOf(MysticGemstonesItem.RAW_WHITE_SAPPHIRE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.WHITE_SAPPHIRE_ITEM, MysticGemstonesItem.WHITE_SAPPHIRE_DUST, 25, 14, 3);
                }
                if (item.isOf(MysticGemstonesItem.RAW_SAPPHIRE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.SAPPHIRE_ITEM, MysticGemstonesItem.SAPPHIRE_DUST, 25, 14, 3);
                }
                return ActionResult.SUCCESS;
            }
            return ActionResult.FAIL;
        }
        return ActionResult.FAIL;
    }

    private void polishGem(PlayerEntity player, Hand hand, World world, BlockPos pos, Item item_polished, Item item_powder, int powderDropChance, int itemBrakeChance, int polishItemChance) {
        int x = (int) (Math.random() * 100);
        if (x <= powderDropChance) {
            Block.dropStack(world, pos, new ItemStack(item_powder));
        }
        if (x <= itemBrakeChance) {
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1f, 1f);
        } else if (x <= itemBrakeChance + polishItemChance) {
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            Block.dropStack(world, pos, new ItemStack(item_polished));
            world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
        } else
            world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
    }
}
