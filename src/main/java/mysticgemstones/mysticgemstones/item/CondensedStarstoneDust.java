package mysticgemstones.mysticgemstones.item;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CondensedStarstoneDust extends Item {

    public CondensedStarstoneDust(Settings settings) {
        super(settings);
    }

    private boolean canShine;

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (world.getTimeOfDay() > 22350 || world.getTimeOfDay() < 21980) {
            FabricModelPredicateProviderRegistry.register(MysticGemstonesItem.CONDENSED_STARSTONE_DUST,
                    new Identifier("shining"), (itemStack, clientWorld, livingEntity, hmmmm) -> 0.0F);
            canShine = false;
        }
        else if (world.getTimeOfDay() > 21980 && world.getTimeOfDay() < 22350) {
            FabricModelPredicateProviderRegistry.register(MysticGemstonesItem.CONDENSED_STARSTONE_DUST,
                    new Identifier("shining"), (itemStack, clientWorld, livingEntity, hmmmm) -> 1.0F);
            canShine = true;
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return canShine;
    }
}