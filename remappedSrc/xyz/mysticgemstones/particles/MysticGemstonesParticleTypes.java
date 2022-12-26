package xyz.mysticgemstones.particles;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.mysticgemstones.Constant;

public class MysticGemstonesParticleTypes {
    public static final DefaultParticleType GEM_INFUSER_PARTICLE = FabricParticleTypes.simple();

    public static void register() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(Constant.MOD_ID, "gem_infuser_particle"), GEM_INFUSER_PARTICLE);
    }

    public static void registerClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> registry.register(new Identifier(Constant.MOD_ID, "particle/gem_infuser_particle"))));

        ParticleFactoryRegistry.getInstance().register(GEM_INFUSER_PARTICLE, FlameParticle.Factory::new);
    }
}
