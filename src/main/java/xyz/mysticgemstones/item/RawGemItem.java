package xyz.mysticgemstones.item;

import net.minecraft.item.Item;

public class RawGemItem extends Item {
    public RawGemItem(Settings settings, Item polishedVariant, Item dust) {
        this(settings, polishedVariant, dust, 40, 10, 4);
    }
    public RawGemItem(Settings settings, Item polishedVariant, Item dust, int powderDropChance, int itemBreakChance,  int itemPolishChance) {
        super(settings);
        this.polishedVariant = polishedVariant;
        this.dust = dust;
        this.powderDropChance = powderDropChance;
        this.itemPolishChance = itemPolishChance;
        this.itemBreakChance = itemBreakChance;
    }

    private final Item polishedVariant;
    private final Item dust;
    private final int powderDropChance;
    private final int itemPolishChance;
    private final int itemBreakChance;

    public Item getDust() {
        return dust;
    }
    public Item getPolishedVariant() {
        return polishedVariant;
    }
    public int getPowderDropChance() {
        return powderDropChance;
    }
    public int getItemPolishChance() {
        return itemPolishChance;
    }
    public int getItemBreakChance() {
        return itemBreakChance;
    }
}
