package cc.cassian.effects.mixin.snow_gravity;

import cc.cassian.effects.EmbersAndIcicles;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SnowLayerBlock.class)
public class SnowLayerBlockMixin extends Block implements Fallable {
    public SnowLayerBlockMixin(Properties properties) {
        super(properties);
    }

    @ModifyReturnValue(method = "canSurvive", at = @At("RETURN"))
    protected boolean embers$canSurvive(boolean original, final BlockState state, final LevelReader level, final BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.below());
        if (EmbersAndIcicles.CONFIG.snowGravity && belowState.isAir()) {
            return true;
        }
        return original;
    }
}
