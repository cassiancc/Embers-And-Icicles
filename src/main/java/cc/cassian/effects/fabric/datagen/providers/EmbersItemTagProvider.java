//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.references.ModBlockIds;
import cc.cassian.effects.references.ModItemIds;
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
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.concurrent.CompletableFuture;

//~ if <26 'FabricTagsProvider.ItemTagsProvider'->'FabricTagProvider.ItemTagProvider'
public class EmbersItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
	public EmbersItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, EmbersBlockTagProvider blocks) {
		super(output, registryLookupFuture, blocks);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void addTags(HolderLookup.Provider provider) {
		//? if <26.4 {
		builder(tag("ice"))
				.add(key("ice"))
				.add(key("packed_ice"))
				.add(key("blue_ice"))
				.add(ModItemIds.BRITTLE_ICE);
		builder(ModTags.FROSTBITE_PREFERRED_WEAPONS).add(ModItemIds.ICE_BALL);
		builder(ModTags.KNOCKS_BACK_PLAYERS_EVEN_WITH_ZERO_DAMAGE).add(key("snowball"));
		copy(BlockTags.SLABS, BlockTags.STAIRS, BlockTags.WALLS);
		//?}

	}

	//? if =1.21.1 {
	/*private FabricTagProvider<Item>.FabricTagBuilder builder(TagKey<Item> tag) {
		return getOrCreateTagBuilder(tag);
	}
	*///?}


	@SafeVarargs
	private void copy(TagKey<Block>... tags) {
		for (TagKey<Block> tag : tags) {
			copy(tag, TagKey.create(Registries.ITEM, tag.location()));
		}
	}

	private ResourceKey<Item> key(String path) {
		return ResourceKey.create(Registries.ITEM, Identifier.parse(path));
	}

	private TagKey<Item> tag(String path) {
		ResourceKey<Item> key = key(path);
		return TagKey.create(key.registryKey(), key.identifier());
	}
}
//~}
//?}
