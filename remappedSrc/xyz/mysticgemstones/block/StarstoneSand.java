
package xyz.mysticgemstones.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.mysticgemstones.block.entity.StarstoneSandEntity;

import java.util.function.ToIntFunction;

public class StarstoneSand extends BlockWithEntity {
    public static final BooleanProperty SHINING = BooleanProperty.of("shining");

    public StarstoneSand(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(SHINING, false));
    }

    public static ToIntFunction<BlockState> getLightLevel() {
        return (state) -> (Boolean)state.get(StarstoneSand.SHINING) ? 10 : 0;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StarstoneSandEntity(pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(SHINING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, MysticGemstonesBlock.STARSTONE_SAND_ENTITY, (world1, pos, state1, f) -> StarstoneSandEntity.tick(world1, pos, state1));
    }
}