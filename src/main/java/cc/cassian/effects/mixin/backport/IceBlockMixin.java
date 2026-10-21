//? if <26.4 {
package cc.cassian.effects.mixin.backport;

import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.registry.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(IceBlock.class)
public abstract class IceBlockMixin extends HalfTransparentBlock {
	@Unique
	private static final int EMBERS$IDLE_SOUND_CHANCE = 10000;
	@Unique
	private static final int EMBERS$SURROUNDING_BLOCKS_DISTANCE = 8;

	protected IceBlockMixin(final BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public void animateTick(final BlockState state, final Level level, final BlockPos pos, final RandomSource random) {
		if (EmbersAndIcicles.CONFIG.newIceSounds && random.nextInt(EMBERS$IDLE_SOUND_CHANCE) == 0 && embers$shouldPlayAmbientSound(level, pos)) {
			level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), ModSoundEvents.ICE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	@Unique
	private static boolean embers$shouldPlayAmbientSound(final Level level, final BlockPos pos) {
		if (!level.getBlockState(pos.below()).is(Blocks.WATER) || !level.getBlockState(pos.above()).isAir()) {
			return false;
		}

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			for (int distance = 1; distance <= EMBERS$SURROUNDING_BLOCKS_DISTANCE; distance++) {
				if (!level.getBlockState(pos.relative(direction, distance)).is(Blocks.ICE)) {
					return false;
				}
			}
		}

		return true;
	}
}
//?}
