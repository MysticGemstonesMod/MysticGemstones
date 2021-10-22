package mysticgemstones.mysticgemstones.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StarstoneOre extends Block {

    public static final BooleanProperty SHINING = BooleanProperty.of("shining");

    public StarstoneOre(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(SHINING, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(SHINING);
    }


    // Should replace onUse with something that auto updates it
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if ((boolean)state.get(SHINING) && (world.getTimeOfDay() > 22300 || world.getTimeOfDay() < 22100)) {
            world.setBlockState(pos, state.with(SHINING, false));
        }
        else if (world.getTimeOfDay() > 22100 && world.getTimeOfDay() < 22300) {
            world.setBlockState(pos, state.with(SHINING, true));
        }
        return ActionResult.SUCCESS;
    }
}
