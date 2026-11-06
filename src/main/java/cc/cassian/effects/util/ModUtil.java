package cc.cassian.effects.util;

import cc.cassian.effects.EmbersAndIcicles;
import net.minecraft.core.registries.BuiltInRegistries;
//~ if >=26.2 'cc.cassian.asphodel'->'net.minecraft'
import net.minecraft.references.BlockItemId;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class ModUtil {

	private static final Identifier full = EmbersAndIcicles.of("hud/heart/burning_full");
	private static final Identifier fullBlinking = EmbersAndIcicles.of("hud/heart/burning_full_blinking");
	private static final Identifier half = EmbersAndIcicles.of("hud/heart/burning_half");
	private static final Identifier halfBlinking = EmbersAndIcicles.of("hud/heart/burning_half_blinking");
	private static final Identifier hardcoreFull = EmbersAndIcicles.of("hud/heart/burning_hardcore_full");
	private static final Identifier hardcoreFullBlinking = EmbersAndIcicles.of("hud/heart/burning_hardcore_full_blinking");
	private static final Identifier hardcoreHalf = EmbersAndIcicles.of("hud/heart/burning_hardcore_half");
	private static final Identifier hardcoreHalfBlinking = EmbersAndIcicles.of("hud/heart/burning_hardcore_half_blinking");
	
	public static Identifier getSprite(final boolean isHardcore, final boolean isHalf, final boolean isBlink) {
		if (!isHardcore) {
			if (isHalf) {
				return isBlink ? halfBlinking : half;
			} else {
				return isBlink ? fullBlinking : full;
			}
		} else if (isHalf) {
			return isBlink ? hardcoreHalfBlinking : hardcoreHalf;
		} else {
			return isBlink ? hardcoreFullBlinking : hardcoreFull;
		}
	}

	public static void addAlias(Registry<?> registry, String path) {
		registry.addAlias(EmbersAndIcicles.of(path), Identifier.withDefaultNamespace(path));
	}

	public static BlockItemId create(String path) {
		//? if >=26.4 {
		/*ModUtil.addAlias(BuiltInRegistries.BLOCK, path);
		ModUtil.addAlias(BuiltInRegistries.ITEM, path);
		*///?}
		return new BlockItemId(ResourceKey.create(Registries.BLOCK, EmbersAndIcicles.of(path)), ResourceKey.create(Registries.ITEM, EmbersAndIcicles.of(path)));
	}
}
