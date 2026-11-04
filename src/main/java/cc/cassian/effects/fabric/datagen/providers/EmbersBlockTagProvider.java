//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.asphodel.fabric.datagen.MultiversionedBlockTagsProvider;
import cc.cassian.effects.references.ModBlockItemIds;
import cc.cassian.effects.registry.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static cc.cassian.effects.references.ModBlockItemIds.*;

public class EmbersBlockTagProvider extends MultiversionedBlockTagsProvider {
	public EmbersBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, registryLookupFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		//? if <26.4 {
		tagBuilder(BlockTags.SLABS).add(
				PACKED_ICE_BRICK_SLAB,
				SNOW_BRICK_SLAB,
				ModBlockItemIds.CALCITE_SLAB, ModBlockItemIds.POLISHED_CALCITE_SLAB, ModBlockItemIds.POLISHED_CALCITE_BRICK_SLAB
		);
		tagBuilder(BlockTags.STAIRS).add(PACKED_ICE_BRICK_STAIRS, SNOW_BRICK_STAIRS,
				ModBlockItemIds.CALCITE_STAIRS, ModBlockItemIds.POLISHED_CALCITE_STAIRS, ModBlockItemIds.POLISHED_CALCITE_BRICK_STAIRS
		);
		tagBuilder(BlockTags.WALLS).add(PACKED_ICE_BRICK_WALL, SNOW_BRICK_WALL,
				ModBlockItemIds.CALCITE_WALL, ModBlockItemIds.POLISHED_CALCITE_WALL, ModBlockItemIds.POLISHED_CALCITE_BRICK_WALL
		);
		tagBuilder(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "ice"))).addOptionalTag(BlockTags.ICE);
		tagBuilder(BlockTags.ICE).add(PACKED_ICE_BRICKS, CHISELED_PACKED_ICE, BRITTLE_ICE);
//		tagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(PACKED_ICE_BRICKS, PACKED_ICE_BRICK_STAIRS, PACKED_ICE_BRICK_SLAB, BRITTLE_ICE, ICE_CRYSTAL, CHISELED_PACKED_ICE).remove(SNOW_BRICK_WALL);
		tagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(SNOW_BRICKS, SNOW_BRICK_SLAB, SNOW_BRICK_STAIRS, SNOW_BRICK_WALL);
		//? if =26.3 {
		tagBuilder(ModTags.ICE_CREVASSE_REPLACEABLES)
				.addOptionalTag(BlockTags.STONE_ORE_REPLACEABLES)
				.addOptionalTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
				.addOptionalTag(BlockTags.HEIGHT_SPECIFIC_ORE_REPLACEABLES)
				.addOptionalTag(ModTags.ICE_CAVE_ORE_REPLACEABLES);
		//?}
		//? if <26.3 {
		/*tagBuilder(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("minecraft", "ice_cave_base_stone")))
				.addOptionalTag(BlockTags.BASE_STONE_OVERWORLD)
				.addOptionalTag(ModTags.ICE_CAVE_ORE_REPLACEABLES);
		tagBuilder(ModTags.ICE_CREVASSE_REPLACEABLES)
				.addOptionalTag(BlockTags.STONE_ORE_REPLACEABLES)
				.addOptionalTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
				.add(Blocks.TUFF)
				.addOptionalTag(ModTags.ICE_CAVE_ORE_REPLACEABLES);
		*///?}
		tagBuilder(ModTags.SPELEOTHEMS)
				.add(ModBlockItemIds.ICICLE)
				.addOptional(key("sulfur_spike"))
				.add(Blocks.POINTED_DRIPSTONE);
		//?}

	}

	private Identifier key(String path) {
		return Identifier.parse(path);
	}
}
//~}
//?}
