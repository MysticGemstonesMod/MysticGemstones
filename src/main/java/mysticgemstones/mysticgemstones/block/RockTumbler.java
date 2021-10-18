package mysticgemstones.mysticgemstones.block;

import mysticgemstones.mysticgemstones.item.MysticGemstonesItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RockTumbler extends Block {

    public RockTumbler(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!world.isClient && itemStack.isOf(MysticGemstonesItem.RAW_AQUAMARIN)) {
            player.sendMessage(new LiteralText("Should drop Aquamarin and remove Raw Aquamarin from player inventory now.... Not yet implemented though :("), false);
            player.damage(DamageSource.FALL, 1);
        }

        return ActionResult.SUCCESS;
    }

}
