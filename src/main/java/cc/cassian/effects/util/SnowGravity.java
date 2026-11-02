package cc.cassian.effects.util;

import cc.cassian.effects.EmbersAndIcicles;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
//~ if >26 'LevelAccessor'->'ScheduledTickAccess'
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SnowGravity {
	public static boolean apply(BlockState state) {
		return state.is(Blocks.SNOW) && EmbersAndIcicles.CONFIG.snowGravity;
	}

	public static int getDelayAfterPlace() {
		return 2;
	}

	public static boolean isFree(BlockState state) {
		if (state.getBlock() instanceof SnowLayerBlock) return false;
		return state.isAir() || state.is(BlockTags.FIRE) || state.liquid() || state.canBeReplaced();
	}

	//~ if >26 'LevelAccessor'->'ScheduledTickAccess'
	public static void scheduleTick(BlockState state, ScheduledTickAccess ticks, BlockPos pos, BlockBehaviour block) {
		if (SnowGravity.apply(state) && block instanceof SnowLayerBlock snowLayerBlock) {
			ticks.scheduleTick(pos, snowLayerBlock, SnowGravity.getDelayAfterPlace());
		}
	}
}
