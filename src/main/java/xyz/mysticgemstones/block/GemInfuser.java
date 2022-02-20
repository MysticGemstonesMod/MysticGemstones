package xyz.mysticgemstones.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xyz.mysticgemstones.block.entity.GemInfuserEntity;

public class GemInfuser extends Block implements BlockEntityProvider {
    public GemInfuser(Settings settings) {
        super(settings);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GemInfuserEntity) {
                ItemScatterer.spawn(world, pos, (GemInfuserEntity)blockEntity);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            Inventory blockEntity = (Inventory) world.getBlockEntity(pos);
            if (!player.getStackInHand(hand).isEmpty() && blockEntity.getStack(0).isEmpty()) {
                if (structureIsValid(world, pos)) {
                    ItemStack itemStack = player.getStackInHand(hand).copy();
                    itemStack.setCount(1);
                    blockEntity.setStack(0, itemStack);
                    player.getStackInHand(hand).decrement(1);
                }
                else {
                    if (!world.isClient) {
                        player.sendMessage(new LiteralText("Failed to identify multi block structure."), false);
                    }
                }
            }
            else {
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
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

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GemInfuserEntity(pos, state);
    }
}
