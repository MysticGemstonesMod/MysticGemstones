package xyz.mysticgemstones;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import xyz.mysticgemstones.item.MysticGemstonesItem;

public class GemBagRecipe extends SpecialCraftingRecipe {
    private static final Ingredient GEM_BAG;
    private static final Ingredient RAW_STARSTONE;

    private int amountAbleToBeAdded;
    private int rawStarstoneSlot;

    /*
        Yeah.. This works but its really messy code and probably could maybe? be buggy... I have worked 3 whole days on implementing GEM_BAG and im tiered
        of this and just want to finish it and upload it to github so I can continue working on other stuff. Will probably clean up this in the future...
    */

    public GemBagRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory craftingInventory, World world) {
        int foundBag = 0;
        int foundGem = 0;
        for (int i = 0; i < craftingInventory.size(); i++) {
            if (craftingInventory.getStack(i).getItem() == MysticGemstonesItem.GEM_BAG) {
                foundBag++;
            }
            else if (craftingInventory.getStack(i).getItem() == MysticGemstonesItem.RAW_STARSTONE) {
                foundGem++;
            }
        }
        return foundBag == 1 && foundGem == 1;
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(CraftingInventory craftingInventory) {
        craftingInventory.getStack(rawStarstoneSlot).setCount(craftingInventory.getStack(rawStarstoneSlot).getCount() - amountAbleToBeAdded + 1);
        return super.getRemainder(craftingInventory);
    }

    @Override
    public ItemStack craft(CraftingInventory craftingInventory) {
        ItemStack itemStack = new ItemStack(MysticGemstonesItem.GEM_BAG);
        rawStarstoneSlot = -1;

        int amount = 0;
        int numberOfRawGems = 0;

        for (int i = 0; i < craftingInventory.size(); i++) {
            ItemStack itemStack2 = craftingInventory.getStack(i);
            if (!itemStack2.isEmpty()) {
                if (GEM_BAG.test(itemStack2)) {
                    if (itemStack2.hasNbt()) {
                        amount = itemStack2.getNbt().getInt("amount");
                    }
                }
                else if (RAW_STARSTONE.test(itemStack2)) {
                    numberOfRawGems = itemStack2.getCount();
                    rawStarstoneSlot = i;
                }
            }
        }
        NbtCompound nbtCompound = new NbtCompound();
        if (amount >= 16) {
            return null;
        }
        amountAbleToBeAdded = 16 - amount;

        if (amountAbleToBeAdded > numberOfRawGems) {
            amount += numberOfRawGems;
        }
        else {
            amount = 16;
        }

        nbtCompound.putInt("amount", amount);
        itemStack.setNbt(nbtCompound);
        return itemStack;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.SHAPELESS;
    }

    static {
        GEM_BAG = Ingredient.ofItems(MysticGemstonesItem.GEM_BAG);
        RAW_STARSTONE = Ingredient.ofItems(MysticGemstonesItem.RAW_STARSTONE);
    }
}
