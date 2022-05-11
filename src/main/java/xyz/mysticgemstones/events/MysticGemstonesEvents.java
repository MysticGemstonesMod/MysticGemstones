package xyz.mysticgemstones.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import xyz.mysticgemstones.Utils;

public class MysticGemstonesEvents {
    public static void registerEvents() {
        ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerWorld world) -> {
            Utils.sendMessageOnSpawn(world, entity);
        });
    }
}
