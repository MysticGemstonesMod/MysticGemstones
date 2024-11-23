package xyz.domza.mystic_gemstones.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.domza.mystic_gemstones.recipe.GrindingRecipe;

import java.util.Optional;

public class GemGrindstone extends Block {
    public GemGrindstone(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ItemActionResult.SUCCESS;
        }

        // Do crafting recipe
        ItemStack itemStack = getResult(world, stack, pos);
        if (!itemStack.isEmpty()) {
            if (!player.isCreative()) {
                stack.decrement(1);
            }
            Block.dropStack(world, pos, itemStack);
        }

        return ItemActionResult.CONSUME;
    }

    private static ItemStack getResult(World world, ItemStack stack, BlockPos pos) {
        ItemStack itemStack = ItemStack.EMPTY;
        SimpleInventory inventory = new SimpleInventory(stack);

        Optional<RecipeEntry<GrindingRecipe>> optional = world.getRecipeManager()
                .getFirstMatch(GrindingRecipe.Type.INSTANCE, inventory, world);

        if (optional.isPresent()) {
            RecipeEntry<GrindingRecipe> recipeEntry = optional.get();
            GrindingRecipe grindingRecipe = recipeEntry.value();
            ItemStack craftResult = grindingRecipe.craft(inventory, world.getRegistryManager());
            if (craftResult.isItemEnabled(world.getEnabledFeatures())) {
                itemStack = craftResult;
                if (false) { // TODO - Check if item ise Gem
                    world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
                }
                else {
                    world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
        }
        return itemStack;
    }
}
