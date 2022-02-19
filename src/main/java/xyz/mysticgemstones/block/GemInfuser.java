package xyz.mysticgemstones.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.mysticgemstones.MysticGemstoneTags;

public class GemInfuser extends Block {
    public GemInfuser(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (structureIsValid(world, pos)) {
            if (player.getStackInHand(hand).isIn(MysticGemstoneTags.RAW_GEMS)) {
                player.getStackInHand(hand).decrement(1);
                // Put it inside of block entity inventory and so on....
            }
        }
        else {
            if (!world.isClient) {
                player.sendMessage(new LiteralText("Failed to identify multi block structure."), false);
            }
        }
        return ActionResult.success(true);
    }

    private boolean structureIsValid(World world, BlockPos pos) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (world.getBlockState(pos.down(1).north(i).west(j)).getBlock() != MysticGemstonesBlock.WHITE_SAPPHIRE_SAND) {
                    return false;
                }
            }
        }
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if ((i > 1 || i < -1) && (j > 1 || j < -1))
                if (world.getBlockState(pos.down(1).north(i).west(j)).getBlock() != MysticGemstonesBlock.WHITE_SAPPHIRE_SAND_STONE) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            Block block = MysticGemstonesBlock.ALEXANDRITE_SAND_STONE;
            if (i == 2) block = MysticGemstonesBlock.HARDENED_STARSTONE_GLASS;
            if (world.getBlockState(pos.north(2).west(2).up(i)).getBlock() != block) return false;
            if (world.getBlockState(pos.north(-2).west(-2).up(i)).getBlock() != block) return false;
            if (world.getBlockState(pos.north(-2).west(2).up(i)).getBlock() != block) return false;
            if (world.getBlockState(pos.north(2).west(-2).up(i)).getBlock() != block) return false;
        }
        return true;
    }
}
