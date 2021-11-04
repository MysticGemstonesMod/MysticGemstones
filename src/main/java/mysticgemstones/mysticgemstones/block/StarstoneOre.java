package mysticgemstones.mysticgemstones.block;

import mysticgemstones.mysticgemstones.block.entity.StarstoneOreEntity;
import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StarstoneOre extends BlockWithEntity {

    public static final BooleanProperty SHINING = BooleanProperty.of("shining");

    public StarstoneOre(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(SHINING, false));
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
        return checkType(type, StarstoneOreEntity.STARSTONE_ORE_ENTITY, (world1, pos, state1, be) -> StarstoneOreEntity.tick(world1, pos, state1, be));
    }

    // This gives raw starstone ore shining or not shining texture depending on time of day.
    public static void setShiningNotShining() {
        FabricModelPredicateProviderRegistry.register(MysticGemstonesItem.RAW_STARSTONE, new Identifier("shining"), (itemStack, clientWorld, livingEntity, hmmmm) -> {
            if (0 == 1 ) {     // This should test world time (like starstone ore) and depending on it set raw starstone texture.
                // Use shiny texture
                return 1.0F;
            }
            // Use not shiny texture
            return 0.0F;
        });
    }
}
