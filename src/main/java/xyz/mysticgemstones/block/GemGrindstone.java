package xyz.mysticgemstones.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.mysticgemstones.MysticGemstoneTags;
import xyz.mysticgemstones.item.RawGemItem;

public class GemGrindstone extends Block {

    public GemGrindstone(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (player.getStackInHand(hand).isIn(MysticGemstoneTags.RAW_GEMS)) {
                RawGemItem rawGemItem = (RawGemItem) player.getStackInHand(hand).getItem();
                polishGem(player, hand, world, pos, rawGemItem.getPolishedVariant(), rawGemItem.getDust(), rawGemItem.getPowderDropChance(), rawGemItem.getItemBreakChance(), rawGemItem.getItemPolishChance());
            }
            else {
                player.sendMessage(new LiteralText("Not Raw Gem!"), false);
            }
        }
        return ActionResult.SUCCESS;
    }

    private void polishGem(PlayerEntity player, Hand hand, World world, BlockPos pos, Item item_polished, Item item_powder, int powderDropChance, int itemBrakeChance, int polishItemChance) {
        int x = (int) (Math.random() * 100);
        if (x <= powderDropChance) {
            Block.dropStack(world, pos, new ItemStack(item_powder));
        }
        if (x <= itemBrakeChance) {
            player.getStackInHand(hand).decrement(1);
            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1f, 1f);
        } else if (x <= itemBrakeChance + polishItemChance) {
            player.getStackInHand(hand).decrement(1);
            Block.dropStack(world, pos, new ItemStack(item_polished));
            world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
        } else
            world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
    }
}
