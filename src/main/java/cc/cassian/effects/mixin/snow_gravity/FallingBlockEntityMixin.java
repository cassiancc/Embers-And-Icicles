package cc.cassian.effects.mixin.snow_gravity;

import cc.cassian.effects.EmbersAndIcicles;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FallingBlockEntity.class)
public abstract class FallingBlockEntityMixin extends Entity {
	public FallingBlockEntityMixin(EntityType<?> type, Level level) {
		super(type, level);
	}

	@Shadow
	public abstract BlockState getBlockState();

	@Shadow
	private boolean cancelDrop;

	@Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;"))
	private void embers$place(CallbackInfo ci) {
		BlockState levelState = level().getBlockState(blockPosition());
		if (EmbersAndIcicles.CONFIG.snowGravity && levelState.is(Blocks.SNOW) && getBlockState().is(Blocks.SNOW)) {
			this.cancelDrop = true;
		}
	}
}
