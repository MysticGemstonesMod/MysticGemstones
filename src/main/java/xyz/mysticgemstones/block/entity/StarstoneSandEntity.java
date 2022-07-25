package xyz.mysticgemstones.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.block.StarstoneOre;


public class StarstoneSandEntity extends BlockEntity {
    public StarstoneSandEntity(BlockPos pos, BlockState state) {
        super(MysticGemstonesBlock.STARSTONE_SAND_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state) {
        if (world.getTimeOfDay() > 22350 || world.getTimeOfDay() < 21980) {
            world.setBlockState(pos, state.with(StarstoneOre.SHINING, false));
        } else {
            world.setBlockState(pos, state.with(StarstoneOre.SHINING, true));
        }
    }
}
