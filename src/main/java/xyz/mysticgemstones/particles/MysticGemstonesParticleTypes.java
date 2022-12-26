package xyz.mysticgemstones.particles;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesParticleTypes {
    public static final DefaultParticleType GEM_INFUSER_PARTICLE = FabricParticleTypes.simple();

    public static void register() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Constant.MOD_ID, "gem_infuser_particle"), GEM_INFUSER_PARTICLE);
    }

    public static void registerClient() {
        // TODO
//        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> registry.register(new Identifier(Constant.MOD_ID, "particle/gem_infuser_particle"))));

        ParticleFactoryRegistry.getInstance().register(GEM_INFUSER_PARTICLE, FlameParticle.Factory::new);
    }
}
