package cc.cassian.effects.mixin.snow_gravity;

import cc.cassian.effects.util.SnowGravity;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
//~ if >26 'Level'->'ScheduledTickAccess'
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {

	@Inject(method = "onPlace", at = @At("HEAD"))
	private void embers$place(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston, CallbackInfo ci) {
		SnowGravity.scheduleTick(state, level, pos, (BlockBehaviour) (Object) this);
	}

	@Inject(method = "updateShape", at = @At("HEAD"))
	//? if >26 {
	private void embers$updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random, CallbackInfoReturnable<BlockState> cir) {
	//?} else {
	/*private void embers$updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor ticks, BlockPos pos, BlockPos neighborPos, CallbackInfoReturnable<BlockState> cir) {
	*///?}
		SnowGravity.scheduleTick(state, ticks, pos, (BlockBehaviour) (Object) this);
	}

	@Inject(method = "tick", at = @At("HEAD"))
	private void embers$tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
		//~ if >26 'level.getMinBuildHeight' -> 'level.getMinY'
		if (SnowGravity.apply(state) && SnowGravity.isFree(level.getBlockState(pos.below())) && pos.getY() >= level.getMinY()) {
			FallingBlockEntity.fall(level, pos, state);
		}
	}


}
