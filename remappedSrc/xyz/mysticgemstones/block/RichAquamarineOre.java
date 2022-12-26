package xyz.mysticgemstones.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public class RichAquamarineOre extends Block {

    public static final IntProperty STATE = IntProperty.of("state", 1, 5);
    public RichAquamarineOre(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(STATE, 5));
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        int i = state.get(STATE) - 1;
        if (i <= 0) {
            return;
        }
        world.setBlockState(pos, state.with(STATE, i), 1);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STATE);
    }
}
