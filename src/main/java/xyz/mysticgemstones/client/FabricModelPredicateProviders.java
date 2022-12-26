package xyz.mysticgemstones.client;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import xyz.mysticgemstones.item.MysticGemstonesItems;

public class FabricModelPredicateProviders {

    public static void register() {
        // Gem bag
        FabricModelPredicateProviderRegistry.register(MysticGemstonesItems.GEM_BAG,
                new Identifier("open_closed_state"), (itemStack, clientWorld, livingEntity, a) -> isEmpty(itemStack) ? 1.0F : 0.0F);
        // Starstone Dust
        FabricModelPredicateProviderRegistry.register(MysticGemstonesItems.STARSTONE_DUST, new Identifier("shining"), (itemStack, clientWorld, livingEntity, a) -> {
            if (clientWorld != null) {
                long timeOfDay = clientWorld.getTimeOfDay();
                return timeOfDay > 22350 || timeOfDay < 21980 ? 0.0F : 1.0F;
            }
            else if (livingEntity != null) {
                long timeOfDay = livingEntity.getWorld().getTimeOfDay();
                return timeOfDay > 22350 || timeOfDay < 21980 ? 0.0F : 1.0F;
            }
            return 1.0F;
        });
        // Condensed Starstone Dust
        FabricModelPredicateProviderRegistry.register(MysticGemstonesItems.CONDENSED_STARSTONE_DUST, new Identifier("shining"), (itemStack, clientWorld, livingEntity, a) -> {
            if (clientWorld != null) {
                long timeOfDay = clientWorld.getTimeOfDay();
                return timeOfDay > 22350 || timeOfDay < 21980 ? 0.0F : 1.0F;
            }
            else if (livingEntity != null) {
                long timeOfDay = livingEntity.getWorld().getTimeOfDay();
                return timeOfDay > 22350 || timeOfDay < 21980 ? 0.0F : 1.0F;
            }
            return 1.0F;
        });
    }

    private static boolean isEmpty(ItemStack itemstack) {
        if (itemstack.hasNbt()) {
            assert itemstack.getNbt() != null;
            return itemstack.getNbt().getInt("amount") == 0;
        }
        return true;
    }
}

