package cc.cassian.effects.references;

import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.util.ModUtil;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class ModBlockIds {
	public static final ResourceKey<Block> BRITTLE_ICE = register("brittle_ice");
	public static final ResourceKey<Block> ICE_CRYSTAL = register("ice_crystal");
	public static final ResourceKey<Block> ICICLE = register("icicle");
	public static final ResourceKey<Block> PACKED_ICE_BRICKS = register("packed_ice_bricks");
	public static final ResourceKey<Block> PACKED_ICE_BRICK_SLAB = register("packed_ice_brick_slab");
	public static final ResourceKey<Block> PACKED_ICE_BRICK_STAIRS = register("packed_ice_brick_stairs");
	public static final ResourceKey<Block> PACKED_ICE_BRICK_WALL = register("packed_ice_brick_wall");
	public static final ResourceKey<Block> CHISELED_PACKED_ICE = register("chiseled_packed_ice");
	public static final ResourceKey<Block> SNOW_BRICKS = register("snow_bricks");
	public static final ResourceKey<Block> SNOW_BRICK_SLAB = register("snow_brick_slab");
	public static final ResourceKey<Block> SNOW_BRICK_STAIRS = register("snow_brick_stairs");
	public static final ResourceKey<Block> SNOW_BRICK_WALL = register("snow_brick_wall");

	private static ResourceKey<Block> register(String path) {
		//? if >=26.4
		//ModUtil.addAlias(BuiltInRegistries.BLOCK, path);
		return ResourceKey.create(Registries.BLOCK, EmbersAndIcicles.of(path));
	}

	public static void init() {

	}
}
