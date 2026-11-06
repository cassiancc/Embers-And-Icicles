package cc.cassian.effects.registry;

//? if <26
//import cc.cassian.effects.EmbersAndIcicles;
//? if <26.4
import cc.cassian.effects.item.IceBallItem;
//~ if >=26.2 'cc.cassian.asphodel'->'net.minecraft'
import net.minecraft.references.BlockItemId;
import cc.cassian.effects.references.ModBlockItemIds;
import cc.cassian.effects.references.ModItemIds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ModItems {
	//? if <26.4 {
	public static final Item CALCITE_PILLAR = registerBlock(ModBlockItemIds.CALCITE_PILLAR, ModBlocks.CALCITE_PILLAR);
	public static final Item CALCITE_SLAB = registerBlock(ModBlockItemIds.CALCITE_SLAB, ModBlocks.CALCITE_SLAB);
	public static final Item CALCITE_STAIRS = registerBlock(ModBlockItemIds.CALCITE_STAIRS, ModBlocks.CALCITE_STAIRS);
	public static final Item CALCITE_WALL = registerBlock(ModBlockItemIds.CALCITE_WALL, ModBlocks.CALCITE_WALL);
	public static final Item POLISHED_CALCITE = registerBlock(ModBlockItemIds.POLISHED_CALCITE, ModBlocks.POLISHED_CALCITE);
	public static final Item POLISHED_CALCITE_SLAB = registerBlock(ModBlockItemIds.POLISHED_CALCITE_SLAB, ModBlocks.POLISHED_CALCITE_SLAB);
	public static final Item POLISHED_CALCITE_STAIRS = registerBlock(ModBlockItemIds.POLISHED_CALCITE_STAIRS, ModBlocks.POLISHED_CALCITE_STAIRS);
	public static final Item POLISHED_CALCITE_WALL = registerBlock(ModBlockItemIds.POLISHED_CALCITE_WALL, ModBlocks.POLISHED_CALCITE_WALL);
	public static final Item POLISHED_CALCITE_BRICKS = registerBlock(ModBlockItemIds.POLISHED_CALCITE_BRICKS, ModBlocks.POLISHED_CALCITE_BRICKS);
	public static final Item POLISHED_CALCITE_BRICK_SLAB = registerBlock(ModBlockItemIds.POLISHED_CALCITE_BRICK_SLAB, ModBlocks.POLISHED_CALCITE_BRICK_SLAB);
	public static final Item POLISHED_CALCITE_BRICK_STAIRS = registerBlock(ModBlockItemIds.POLISHED_CALCITE_BRICK_STAIRS, ModBlocks.POLISHED_CALCITE_BRICK_STAIRS);
	public static final Item POLISHED_CALCITE_BRICK_WALL = registerBlock(ModBlockItemIds.POLISHED_CALCITE_BRICK_WALL, ModBlocks.POLISHED_CALCITE_BRICK_WALL);

	public static final Item ICE_BALL = registerItem(ModItemIds.ICE_BALL, IceBallItem::new, new Item.Properties().stacksTo(16));
	public static final Item BRITTLE_ICE = registerBlock(ModBlockItemIds.BRITTLE_ICE, ModBlocks.BRITTLE_ICE);
	public static final Item ICE_CRYSTAL = registerBlock(ModBlockItemIds.ICE_CRYSTAL, ModBlocks.ICE_CRYSTAL);
	public static final Item ICICLE = registerBlock(ModBlockItemIds.ICICLE, ModBlocks.ICICLE);
	public static final Item PACKED_ICE_BRICKS = registerBlock(ModBlockItemIds.PACKED_ICE_BRICKS, ModBlocks.PACKED_ICE_BRICKS);
	public static final Item PACKED_ICE_BRICK_SLAB = registerBlock(ModBlockItemIds.PACKED_ICE_BRICK_SLAB, ModBlocks.PACKED_ICE_BRICK_SLAB);
	public static final Item PACKED_ICE_BRICK_STAIRS = registerBlock(ModBlockItemIds.PACKED_ICE_BRICK_STAIRS, ModBlocks.PACKED_ICE_BRICK_STAIRS);
	public static final Item PACKED_ICE_BRICK_WALL = registerBlock(ModBlockItemIds.PACKED_ICE_BRICK_WALL, ModBlocks.PACKED_ICE_BRICK_WALL);
	public static final Item CHISELED_PACKED_ICE = registerBlock(ModBlockItemIds.CHISELED_PACKED_ICE, ModBlocks.CHISELED_PACKED_ICE);
	public static final Item SNOW_BRICKS = registerBlock(ModBlockItemIds.SNOW_BRICKS, ModBlocks.SNOW_BRICKS);
	public static final Item SNOW_BRICK_SLAB = registerBlock(ModBlockItemIds.SNOW_BRICK_SLAB, ModBlocks.SNOW_BRICK_SLAB);
	public static final Item SNOW_BRICK_STAIRS = registerBlock(ModBlockItemIds.SNOW_BRICK_STAIRS, ModBlocks.SNOW_BRICK_STAIRS);
	public static final Item SNOW_BRICK_WALL = registerBlock(ModBlockItemIds.SNOW_BRICK_WALL, ModBlocks.SNOW_BRICK_WALL);
	public static final Item MUSIC_DISC_FLURRY = registerItem(
			ModItemIds.MUSIC_DISC_FLURRY, Item::new, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.FLURRY)
	);
	//? if >=26 {
	public static final Item FROSTBITE_SPAWN_EGG = registerItem(ModItemIds.FROSTBITE_SPAWN_EGG, SpawnEggItem::new,
			new Item.Properties().spawnEgg(ModEntityTypes.FROSTBITE));
	//?} else {
	
	/*public static final boolean LEGACY_SPAWN_EGG = EmbersAndIcicles.CONFIG.legacySpawnEgg;
	public static final Item FROSTBITE_SPAWN_EGG = registerItem(ModItemIds.FROSTBITE_SPAWN_EGG,
			properties -> new SpawnEggItem(ModEntityTypes.FROSTBITE, LEGACY_SPAWN_EGG ? 0x5A8A84 : 0xFFFFFF, LEGACY_SPAWN_EGG ? 0xC8E6ED : 0xFFFFFF, properties), new Item.Properties());
	*///?}
	//?} else {
	/*public static final Item ICE_BALL = Items.ICE_BALL;
	public static final Item BRITTLE_ICE = Items.BRITTLE_ICE;
	public static final Item ICE_CRYSTAL = Items.ICE_CRYSTAL;
	public static final Item ICICLE = Items.ICICLE;
	public static final Item FROSTBITE_SPAWN_EGG = Items.FROSTBITE_SPAWN_EGG;
	public static final Item PACKED_ICE_BRICKS = Items.PACKED_ICE_BRICKS;
	public static final Item PACKED_ICE_BRICK_SLAB = Items.PACKED_ICE_BRICK_SLAB;
	public static final Item PACKED_ICE_BRICK_STAIRS = Items.PACKED_ICE_BRICK_STAIRS;
	public static final Item PACKED_ICE_BRICK_WALL = Items.PACKED_ICE_BRICK_WALL;
	public static final Item CHISELED_PACKED_ICE = Items.CHISELED_PACKED_ICE;
	*///?}

	private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
		Item item = itemFactory.apply(properties
				//? if >1.21.2
				.setId(id)
		);
		return Registry.register(BuiltInRegistries.ITEM, id, item);
	}

	private static Item registerBlock(final ResourceKey<Item> id, final Block block) {
		return registerItem(id, properties -> new BlockItem(block, properties), new Item.Properties()
				//? if >1.21.2
				.useBlockDescriptionPrefix()
		);
	}

	private static Item registerBlock(final BlockItemId id, final Block block) {
		return registerBlock(id.item(), block);
	}

	public static void init() {

	}
}
