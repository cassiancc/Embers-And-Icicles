package cc.cassian.effects.mixin.snow_gravity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Fallable.class)
public interface FallableMixin {

	@Inject(method = "onBrokenAfterFall", at = @At("HEAD"))
	private void embers$onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity entity, CallbackInfo ci) {
		BlockState state = level.getBlockState(pos);
		int layers = state.getValue(SnowLayerBlock.LAYERS);
		if (state.is(Blocks.SNOW) && layers < 8) {
			level.setBlockAndUpdate(pos, state.setValue(SnowLayerBlock.LAYERS, layers + 1));
		}
	}
}
