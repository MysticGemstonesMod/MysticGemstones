package mysticgemstones.mysticgemstones.block;

import mysticgemstones.mysticgemstones.MysticGemstoneTags;
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

        // Polish Item chance numbers are reversed, so example. 95 = 5%, 30 = 60% and so on...  Basicaly 100 - number = drop chance.

        if (!world.isClient) {
            if (player.getStackInHand(hand).isIn(MysticGemstoneTags.RAW_GEMS)) {
                ItemStack item = player.getStackInHand(hand);

                if (item.isOf(MysticGemstonesItem.RAW_AQUAMARINE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.AQUAMARINE_ITEM, MysticGemstonesItem.AQUAMARINE_DUST);
                }

                if (item.isOf(MysticGemstonesItem.RAW_ALEXANDRITE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.ALEXANDRITE_ITEM, MysticGemstonesItem.ALEXANDRITE_DUST);
                }

                if (item.isOf(MysticGemstonesItem.RAW_SAPPHIRE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.SAPPHIRE_ITEM, MysticGemstonesItem.SAPPHIRE_DUST);
                }

                if (item.isOf(MysticGemstonesItem.RAW_WHITE_SAPPHIRE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.WHITE_SAPPHIRE_ITEM, MysticGemstonesItem.WHITE_SAPPHIRE_DUST);
                }

                if (item.isOf(MysticGemstonesItem.RAW_TOPAZ)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.TOPAZ_ITEM, MysticGemstonesItem.TOPAZ_DUST);
                }

                if (item.isOf(MysticGemstonesItem.RAW_MALACHITE)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.MALACHITE_ITEM, MysticGemstonesItem.MALACHITE_DUST);
                }

                if (item.isOf(MysticGemstonesItem.RAW_JASPER)) {
                    polishGem(player, hand, world, pos, MysticGemstonesItem.JASPER_ITEM, MysticGemstonesItem.JASPER_DUST);
                }
                return ActionResult.SUCCESS;
            }
            return ActionResult.FAIL;
        }
        return ActionResult.FAIL;
    }

    private void polishGem(PlayerEntity player, Hand hand, World world, BlockPos pos, Item item_polished, Item item_dust) {
        if (rng() <= 40) { // = 40% chance
            Block.dropStack(world, pos, new ItemStack(item_dust));
        }

        if (rng() <= 10) {  // 10% chance of item breaking
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1f, 1f);
        } else if (rng() >= 96) { // 4% chance of getting polished item
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            Block.dropStack(world, pos, new ItemStack(item_polished));
            world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
        } else
        world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
    }

    private void polishGem(PlayerEntity player, Hand hand, World world, BlockPos pos, Item item_polished, Item item_dust,
                           int dustDropChance, int itemBrakeChance, int polishItemChance) {
        // Polish Item chance numbers are reversed, so example. 95 = 5%, 30 = 60% and so on...  Basicaly 100 - number = drop chance.
        if (rng() <= dustDropChance) {
            Block.dropStack(world, pos, new ItemStack(item_dust));
        }

        if (rng() <= itemBrakeChance) {
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1f, 1f);
        } else if (rng() >= polishItemChance) {
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
            Block.dropStack(world, pos, new ItemStack(item_polished));
            world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
        } else
            world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
    }

    private int rng() {
        int max = 101;
        int min = 0;
        int number = new SecureRandom().nextInt(max - min) + min;
        return number;
    }
}
