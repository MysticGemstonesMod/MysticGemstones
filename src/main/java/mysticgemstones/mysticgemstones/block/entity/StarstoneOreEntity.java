package mysticgemstones.mysticgemstones.block.entity;

import mysticgemstones.mysticgemstones.MysticGemstones;
import mysticgemstones.mysticgemstones.block.StarstoneOre;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class StarstoneOreEntity extends BlockEntity {
    public StarstoneOreEntity(BlockPos pos, BlockState state) {
        super(MysticGemstones.STARSTONE_ORE_ENTITY, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, StarstoneOreEntity be) {
        if ((boolean)state.get(StarstoneOre.SHINING) && (world.getTimeOfDay() > 22350 || world.getTimeOfDay() < 21980)) {
            world.setBlockState(pos, state.with(StarstoneOre.SHINING, false));
        }
        else if (world.getTimeOfDay() > 21980 && world.getTimeOfDay() < 22350) {
            world.setBlockState(pos, state.with(StarstoneOre.SHINING, true));
        }
    }
}
