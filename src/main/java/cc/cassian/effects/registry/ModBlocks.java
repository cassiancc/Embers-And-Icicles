package cc.cassian.effects.registry;

//~ if >=26.2 'cc.cassian.asphodel'->'net.minecraft'
import net.minecraft.references.BlockItemId;
import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.references.ModBlockItemIds;
import net.minecraft.world.level.block.*;
//? if <26.4 {
import cc.cassian.effects.block.BrittleIceBlock;
import cc.cassian.effects.block.IceCrystalBlock;
import cc.cassian.effects.block.IcicleBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
//~ if >=26.2 'EntityType;'->'EntityTypes;'
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;

import java.util.function.Function;
//?} else {
/*import cc.cassian.effects.util.ModUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
*///?}

public class ModBlocks {
	//? if <26.4 {
	public static final Block BRITTLE_ICE = register(ModBlockItemIds.BRITTLE_ICE, BrittleIceBlock::new, BlockBehaviour.Properties.of()
			.mapColor(MapColor.ICE)
			.friction(0.98F)
			.strength(0.5F)
			.sound(ModSoundEvents.BRITTLE_ICE)
			.noOcclusion()
			.instrument(NoteBlockInstrument.CHIME)
			//~ if >=26.2 'EntityType.'->'EntityTypes.'
			.isValidSpawn((state, level, pos, type) -> type == EntityTypes.POLAR_BEAR)
			.isRedstoneConductor((state, level, pos) -> false)
			//~ if >=26.3 'DESTROY'->'POPPED'
			.pushReaction(PushReaction.POPPED)
	);
	public static final Block ICE_CRYSTAL = register(ModBlockItemIds.ICE_CRYSTAL, IceCrystalBlock::new, BlockBehaviour.Properties.of()
			.mapColor(MapColor.ICE)
			.sound(ModSoundEvents.ICE_CRYSTAL)
			.instrument(NoteBlockInstrument.CHIME)
			.strength(1.5F, 1.5F)
			.lightLevel(state -> 4)
			//~ if >=26.3 'DESTROY'->'POPPED'
			.pushReaction(PushReaction.POPPED)
			.isRedstoneConductor((state, level, pos) -> false)
			.noOcclusion()
	);
	public static final Block ICICLE = register(ModBlockItemIds.ICICLE, IcicleBlock::new, BlockBehaviour.Properties.of()
			.mapColor(MapColor.COLOR_LIGHT_BLUE)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.CHIME)
			.noOcclusion()
			.sound(ModSoundEvents.ICICLE)
			.randomTicks()
			.strength(0.5F, 0.5F)
			.dynamicShape()
			//~ if >=26.3 'DESTROY'->'POPPED'
			.pushReaction(PushReaction.POPPED)
			.isRedstoneConductor((state, level, pos) -> false)
	);

	public static final Block PACKED_ICE_BRICKS = register(
			ModBlockItemIds.PACKED_ICE_BRICKS,
			Block::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.ICE)
					.instrument(NoteBlockInstrument.CHIME)
					.friction(0.6F).strength(0.5F)
					.requiresCorrectToolForDrops()
					.sound(ModSoundEvents.PACKED_ICE)
	);
	public static final Block PACKED_ICE_BRICK_SLAB = registerSlab(ModBlockItemIds.PACKED_ICE_BRICK_SLAB, PACKED_ICE_BRICKS);
	public static final Block PACKED_ICE_BRICK_STAIRS = register(ModBlockItemIds.PACKED_ICE_BRICK_STAIRS, (p)-> new StairBlock(PACKED_ICE_BRICKS.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS));
	public static final Block PACKED_ICE_BRICK_WALL = register(ModBlockItemIds.PACKED_ICE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS).forceSolidOn());
	public static final Block CHISELED_PACKED_ICE = register(ModBlockItemIds.CHISELED_PACKED_ICE, Block::new, BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS));
	public static final Block SNOW_BRICKS = register(
			ModBlockItemIds.SNOW_BRICKS, Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).friction(0.6F).requiresCorrectToolForDrops().strength(0.6F).sound(SoundType.SNOW)
	);
	public static final Block SNOW_BRICK_SLAB = registerSlab(ModBlockItemIds.SNOW_BRICK_SLAB, SNOW_BRICKS);
	public static final Block SNOW_BRICK_STAIRS = registerStair(ModBlockItemIds.SNOW_BRICK_STAIRS, SNOW_BRICKS);
	public static final Block SNOW_BRICK_WALL = registerWall(ModBlockItemIds.SNOW_BRICK_WALL, SNOW_BRICKS);
	public static final Block CALCITE_PILLAR = register(ModBlockItemIds.CALCITE_PILLAR, RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));
	public static final Block CALCITE_SLAB = registerSlab(ModBlockItemIds.CALCITE_SLAB, Blocks.CALCITE);
	public static final Block CALCITE_STAIRS = registerStair(ModBlockItemIds.CALCITE_STAIRS, Blocks.CALCITE);
	public static final Block CALCITE_WALL = registerWall(ModBlockItemIds.CALCITE_WALL, Blocks.CALCITE);
	public static final Block POLISHED_CALCITE = register(ModBlockItemIds.POLISHED_CALCITE, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));
	public static final Block POLISHED_CALCITE_SLAB = registerSlab(ModBlockItemIds.POLISHED_CALCITE_SLAB, POLISHED_CALCITE);
	public static final Block POLISHED_CALCITE_STAIRS = registerStair(ModBlockItemIds.POLISHED_CALCITE_STAIRS, POLISHED_CALCITE);
	public static final Block POLISHED_CALCITE_WALL = registerWall(ModBlockItemIds.POLISHED_CALCITE_WALL, POLISHED_CALCITE);
	public static final Block POLISHED_CALCITE_BRICKS = register(ModBlockItemIds.POLISHED_CALCITE_BRICKS, BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE));
	public static final Block POLISHED_CALCITE_BRICK_SLAB = registerSlab(ModBlockItemIds.POLISHED_CALCITE_BRICK_SLAB, POLISHED_CALCITE_BRICKS);
	public static final Block POLISHED_CALCITE_BRICK_STAIRS = registerStair(ModBlockItemIds.POLISHED_CALCITE_BRICK_STAIRS, POLISHED_CALCITE_BRICKS);
	public static final Block POLISHED_CALCITE_BRICK_WALL = registerWall(ModBlockItemIds.POLISHED_CALCITE_BRICK_WALL, POLISHED_CALCITE_BRICKS);

	private static Block registerStair(final BlockItemId id, final Block base) {
		return EmbersAndIcicles.REGISTRY.registerStair(id, base);
	}

	private static Block registerSlab(final BlockItemId id, final Block base) {
		return EmbersAndIcicles.REGISTRY.registerSlab(id, base);
	}

	private static Block registerWall(final BlockItemId id, final Block base) {
		return EmbersAndIcicles.REGISTRY.registerWall(id, base);
	}

	private static Block register(final BlockItemId id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
		return EmbersAndIcicles.REGISTRY.registerBlock(id, factory, properties);
	}

	private static Block register(final BlockItemId id, final BlockBehaviour.Properties properties) {
		return EmbersAndIcicles.REGISTRY.registerBlock(id, properties);
	}
	//?} else {
	/*public static final Block BRITTLE_ICE = Blocks.BRITTLE_ICE;
	public static final Block ICE_CRYSTAL = Blocks.ICE_CRYSTAL;
	public static final Block ICICLE = Blocks.ICICLE;
	public static final Block PACKED_ICE_BRICKS = Blocks.PACKED_ICE_BRICKS;
	public static final Block PACKED_ICE_BRICK_SLAB = Blocks.PACKED_ICE_BRICK_SLAB;
	public static final Block PACKED_ICE_BRICK_STAIRS = Blocks.PACKED_ICE_BRICK_STAIRS;
	public static final Block PACKED_ICE_BRICK_WALL = Blocks.PACKED_ICE_BRICK_WALL;
	public static final Block CHISELED_PACKED_ICE = Blocks.CHISELED_PACKED_ICE;
	*///?}

	public static void init() {

	}
}
