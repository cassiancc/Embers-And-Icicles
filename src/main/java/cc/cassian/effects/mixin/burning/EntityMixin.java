package cc.cassian.effects.mixin.burning;

import cc.cassian.effects.registry.ModEffects;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@Shadow
	public abstract boolean isOnFire();

	@Inject(at = @At(value = "RETURN"), method = "isOnFire")
	private void addBurningEffect(CallbackInfoReturnable<Boolean> cir) {
		if (((Entity) (Object) this) instanceof LivingEntity livingEntity) {
			if (cir.getReturnValue()) {
				livingEntity.addEffect(new MobEffectInstance(ModEffects.BURNING, livingEntity.getRemainingFireTicks(), 0, true, true));
			} else {
				livingEntity.removeEffect(ModEffects.BURNING);
			}
		}
	}

	@ModifyReturnValue(at = @At(value = "RETURN"), method = "canFreeze")
	private boolean noFreezingAndBurning(boolean original) {
		if (isOnFire()) return false;
		return original;
	}
}