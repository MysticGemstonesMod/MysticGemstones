package xyz.mysticgemstones.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.mysticgemstones.block.entity.StarstoneOreEntity;

import java.util.function.ToIntFunction;

public class StarstoneOre extends BlockWithEntity {
    public static final BooleanProperty SHINING = BooleanProperty.of("shining");

    public StarstoneOre(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(SHINING, false));
    }

    public static ToIntFunction<BlockState> getLightLevel() {
        return (state) -> (Boolean)state.get(StarstoneOre.SHINING) ? 10 : 0;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StarstoneOreEntity(pos, state);
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
        return checkType(type, MysticGemstonesBlock.STARSTONE_ORE_ENTITY, (world1, pos, state1, f) -> StarstoneOreEntity.tick(world1, pos, state1));
    }
}
