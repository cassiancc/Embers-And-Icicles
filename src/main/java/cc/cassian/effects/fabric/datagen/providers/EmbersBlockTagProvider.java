//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.references.ModBlockIds;
import cc.cassian.effects.registry.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
//~ if <26 'FabricTagsProvider'->'FabricTagProvider'
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
//? if >26
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

//~ if <26 'FabricTagsProvider.BlockTagsProvider'->'FabricTagProvider.BlockTagProvider'
public class EmbersBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
	public EmbersBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, registryLookupFuture);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void addTags(HolderLookup.Provider provider) {
		//? if <26.4 {
		builder(BlockTags.SLABS).add(ModBlockIds.PACKED_ICE_BRICK_SLAB);
		builder(BlockTags.STAIRS).add(ModBlockIds.PACKED_ICE_BRICK_STAIRS);
		builder(BlockTags.WALLS).add(ModBlockIds.PACKED_ICE_BRICK_WALL);
		builder(tag("ice")).addOptionalTag(BlockTags.ICE);
		builder(tag("ice")).add(ModBlockIds.PACKED_ICE_BRICKS, ModBlockIds.CHISELED_PACKED_ICE, ModBlockIds.BRITTLE_ICE);
		//? if =26.3 {
		builder(ModTags.ICE_CREVASSE_REPLACEABLES)
				.addOptionalTag(BlockTags.STONE_ORE_REPLACEABLES)
				.addOptionalTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
				.addOptionalTag(BlockTags.HEIGHT_SPECIFIC_ORE_REPLACEABLES)
				.addOptionalTag(ModTags.ICE_CAVE_ORE_REPLACEABLES);
		//?}
		//? if <26.3 {
		/*builder(tag("ice_cave_base_stone"))
				.addOptionalTag(BlockTags.BASE_STONE_OVERWORLD)
				.addOptionalTag(ModTags.ICE_CAVE_ORE_REPLACEABLES);
		builder(ModTags.ICE_CREVASSE_REPLACEABLES)
				.addOptionalTag(BlockTags.STONE_ORE_REPLACEABLES)
				.addOptionalTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
				.add(Blocks.TUFF.builtInRegistryHolder().key())
				.addOptionalTag(ModTags.ICE_CAVE_ORE_REPLACEABLES);
		*///?}
		builder(ModTags.SPELEOTHEMS)
				.add(ModBlockIds.ICICLE)
				.addOptional(key("sulfur_spike"))
				.add(Blocks.POINTED_DRIPSTONE.builtInRegistryHolder().key());
		//?}

	}

	//? if =1.21.1 {
	/*private FabricTagProvider<Block>.FabricTagBuilder builder(TagKey<Block> tag) {
		return getOrCreateTagBuilder(tag);
	}
	*///?}

	private ResourceKey<Block> key(String path) {
		return ResourceKey.create(Registries.BLOCK, Identifier.parse(path));
	}

	private TagKey<Block> tag(String path) {
		ResourceKey<Block> key = key(path);
		return TagKey.create(key.registryKey(), key.identifier());
	}
}
//~}
//?}
