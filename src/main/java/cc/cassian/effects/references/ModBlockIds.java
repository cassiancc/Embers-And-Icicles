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
	public static final ResourceKey<Block> BRITTLE_ICE = ModBlockItemIds.BRITTLE_ICE.block();
	public static final ResourceKey<Block> ICE_CRYSTAL = ModBlockItemIds.ICE_CRYSTAL.block();
	public static final ResourceKey<Block> ICICLE = ModBlockItemIds.ICICLE.block();
	public static final ResourceKey<Block> PACKED_ICE_BRICKS = ModBlockItemIds.PACKED_ICE_BRICKS.block();
	public static final ResourceKey<Block> PACKED_ICE_BRICK_SLAB = ModBlockItemIds.PACKED_ICE_BRICK_SLAB.block();
	public static final ResourceKey<Block> PACKED_ICE_BRICK_STAIRS = ModBlockItemIds.PACKED_ICE_BRICK_STAIRS.block();
	public static final ResourceKey<Block> PACKED_ICE_BRICK_WALL = ModBlockItemIds.PACKED_ICE_BRICK_WALL.block();
	public static final ResourceKey<Block> CHISELED_PACKED_ICE = ModBlockItemIds.CHISELED_PACKED_ICE.block();
	public static final ResourceKey<Block> SNOW_BRICKS = ModBlockItemIds.SNOW_BRICKS.block();
	public static final ResourceKey<Block> SNOW_BRICK_SLAB = ModBlockItemIds.SNOW_BRICK_SLAB.block();
	public static final ResourceKey<Block> SNOW_BRICK_STAIRS = ModBlockItemIds.SNOW_BRICK_STAIRS.block();
	public static final ResourceKey<Block> SNOW_BRICK_WALL = ModBlockItemIds.SNOW_BRICK_WALL.block();

	private static ResourceKey<Block> register(String path) {
		//? if >=26.4
		//ModUtil.addAlias(BuiltInRegistries.BLOCK, path);
		return ResourceKey.create(Registries.BLOCK, EmbersAndIcicles.of(path));
	}

	public static void init() {

	}
}
