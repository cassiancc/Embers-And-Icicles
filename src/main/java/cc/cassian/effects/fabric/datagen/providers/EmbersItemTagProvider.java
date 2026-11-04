//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.asphodel.fabric.datagen.MultiversionedItemTagsProvider;
import cc.cassian.asphodel.tags.CommonBlockItemTags;
import cc.cassian.effects.references.ModBlockItemIds;
import cc.cassian.effects.references.ModItemIds;
import cc.cassian.effects.registry.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class EmbersItemTagProvider extends MultiversionedItemTagsProvider {
	public EmbersItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, EmbersBlockTagProvider blocks) {
		super(output, registryLookupFuture, blocks);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		//? if <26.4 {
		tagBuilder(CommonBlockItemTags.ICE)
				.add(Items.ICE)
				.add(Items.PACKED_ICE)
				.add(Items.BLUE_ICE)
				.add(ModBlockItemIds.BRITTLE_ICE.item());
		tagBuilder(ModTags.FROSTBITE_PREFERRED_WEAPONS).add(ModItemIds.ICE_BALL);
		tagBuilder(ModTags.KNOCKS_BACK_PLAYERS_EVEN_WITH_ZERO_DAMAGE).add(Items.SNOWBALL);
		copy(BlockTags.SLABS, BlockTags.STAIRS, BlockTags.WALLS);
		//?}

	}

	@SafeVarargs
	private void copy(TagKey<Block>... tags) {
		for (TagKey<Block> tag : tags) {
			copy(tag, TagKey.create(Registries.ITEM, tag.location()));
		}
	}
}
//~}
//?}
