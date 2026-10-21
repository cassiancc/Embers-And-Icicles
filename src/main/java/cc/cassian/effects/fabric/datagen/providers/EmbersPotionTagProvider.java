//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.references.ModPotionIds;
import cc.cassian.effects.registry.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
//~ if <26 'FabricTagsProvider'->'FabricTagProvider'
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
//? if >26 {
import net.minecraft.tags.PotionTags;
//?}
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;

import java.util.concurrent.CompletableFuture;

//~ if <26 'FabricTagsProvider'->'FabricTagProvider'
public class EmbersPotionTagProvider extends FabricTagsProvider<Potion> {
	public EmbersPotionTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, Registries.POTION, registryLookupFuture);
	}

	@SuppressWarnings("all")
	@Override
	protected void addTags(HolderLookup.Provider provider) {
		//? if >26 {
		builder(PotionTags.TRADEABLE)
				.add(ModPotionIds.BURNING, ModPotionIds.LONG_BURNING)
				//? if <26.4
				.add(ModPotionIds.LONG_FREEZING, ModPotionIds.FREEZING)
		;
		//?}

	}

	//? if =1.21.1 {
	/*private FabricTagProvider<Potion>.FabricTagBuilder builder(TagKey<Potion> tag) {
		return getOrCreateTagBuilder(tag);
	}
	*///?}

	private ResourceKey<Potion> key(String path) {
		return ResourceKey.create(Registries.POTION, Identifier.parse(path));
	}
	private TagKey<Potion> tag(String path) {
		ResourceKey<Potion> key = key(path);
		return TagKey.create(key.registryKey(), key.identifier());
	}
}
//~}
//?}
