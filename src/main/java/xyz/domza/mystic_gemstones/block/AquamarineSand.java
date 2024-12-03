package xyz.domza.mystic_gemstones.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.FallingBlock;

public class AquamarineSand extends FallingBlock {
    public AquamarineSand(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {

        return null;
    }
}
