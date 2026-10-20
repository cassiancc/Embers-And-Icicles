package cc.cassian.effects.references;

import cc.cassian.effects.EmbersAndIcicles;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class ModBlockIds {
	//? if <26.4 {
	public static final ResourceKey<Block> BRITTLE_ICE = register("brittle_ice");
	public static final ResourceKey<Block> ICE_CRYSTAL = register("ice_crystal");
	public static final ResourceKey<Block> ICICLE = register("icicle");
	public static final ResourceKey<Block> PACKED_ICE_BRICKS = register("packed_ice_bricks");
	public static final ResourceKey<Block> PACKED_ICE_BRICK_SLAB = register("packed_ice_brick_slab");
	public static final ResourceKey<Block> PACKED_ICE_BRICK_STAIRS = register("packed_ice_brick_stairs");
	public static final ResourceKey<Block> PACKED_ICE_BRICK_WALL = register("packed_ice_brick_wall");
	public static final ResourceKey<Block> CHISELED_PACKED_ICE = register("chiseled_packed_ice");
	//?}

	private static ResourceKey<Block> register(String path) {
		return ResourceKey.create(Registries.BLOCK, EmbersAndIcicles.of(path));
	}
}
