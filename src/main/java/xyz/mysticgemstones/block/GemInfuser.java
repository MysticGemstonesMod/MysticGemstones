package xyz.mysticgemstones.block;

import net.minecraft.block.*;
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
import xyz.mysticgemstones.particles.MysticGemstonesParticleTypes;

import java.util.Random;

public class GemInfuser extends Block implements BlockEntityProvider {
    public GemInfuser(Settings settings) {
        super(settings);
    }

    // ToDo
    // Fix recipe crafting n stuff

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GemInfuserEntity) {
                ItemScatterer.spawn(world, pos, (GemInfuserEntity) blockEntity);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) player.sendMessage(new LiteralText("Not yet in game!"), true);
        Inventory inventory = (Inventory) world.getBlockEntity(pos);
        if (!player.getStackInHand(hand).isEmpty() && inventory.getStack(0).isEmpty()) {
            if (structureIsValid(world, pos)) {
                ItemStack itemStack = player.getStackInHand(hand).copy();
                itemStack.setCount(1);
                inventory.setStack(0, itemStack);
                player.getStackInHand(hand).decrement(1);
            } else {
                if (!world.isClient) {
                    player.sendMessage(new LiteralText("Failed to identify multi block structure."), false);
                }
            }
        } else {
            player.getInventory().offerOrDrop(inventory.getStack(0));
            inventory.removeStack(0);
        }
        return ActionResult.success(true);
    }

    private boolean structureIsValid(World world, BlockPos pos) {
        for (int i = -2; i <= 2; i++) {
            for (int j = -1; j <= 1; j++) {
                if (world.getBlockState(pos.down(1).north(i).west(j)).getBlock() != Blocks.CALCITE) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            Block block = Blocks.BASALT;
            if (i == 2) block = Blocks.GLASS;
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

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Inventory inventory = (Inventory) world.getBlockEntity(pos);
        if (!inventory.isEmpty() && structureIsValid(world, pos)) {
            world.addParticle(MysticGemstonesParticleTypes.GEM_INFUSER_PARTICLE, pos.getX() + 2.5, pos.getY() + 2.5, pos.getZ() + 2.5, -0.2, -0.2, -0.2);
            world.addParticle(MysticGemstonesParticleTypes.GEM_INFUSER_PARTICLE, pos.getX() - 1.5, pos.getY() + 2.5, pos.getZ() - 1.5, 0.2, -0.2, 0.2);
            world.addParticle(MysticGemstonesParticleTypes.GEM_INFUSER_PARTICLE, pos.getX() + 2.5, pos.getY() + 2.5, pos.getZ() - 1.5, -0.2, -0.2, 0.2);
            world.addParticle(MysticGemstonesParticleTypes.GEM_INFUSER_PARTICLE, pos.getX() - 1.5, pos.getY() + 2.5, pos.getZ() + 2.5, 0.2, -0.2, -0.2);
        }
    }
}
