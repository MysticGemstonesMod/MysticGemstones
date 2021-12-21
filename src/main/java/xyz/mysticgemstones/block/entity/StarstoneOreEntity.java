package xyz.mysticgemstones.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import xyz.mysticgemstones.block.MysticGemstonesBlock;
import xyz.mysticgemstones.block.StarstoneOre;


public class StarstoneOreEntity extends BlockEntity {

    public static BlockEntityType<StarstoneOreEntity> STARSTONE_ORE_ENTITY;

    public static void RegisterEntity(){
        STARSTONE_ORE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "mysticgemstones:starstone_ore_entity", FabricBlockEntityTypeBuilder.create(StarstoneOreEntity::new, MysticGemstonesBlock.STARSTONE_ORE).build(null));
    }

    public StarstoneOreEntity(BlockPos pos, BlockState state) {
        super(STARSTONE_ORE_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state) {
        if (world.getTimeOfDay() > 22350 || world.getTimeOfDay() < 21980) {
            world.setBlockState(pos, state.with(StarstoneOre.SHINING, false));
        } else {
            world.setBlockState(pos, state.with(StarstoneOre.SHINING, true));
        }
    }
}
