//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.registry.ModEntityTypes;
import cc.cassian.effects.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
//~ if <26.2 'predicates'->'criterion' {
import net.minecraft.advancements.predicates.DamageSourcePredicate;
import net.minecraft.advancements.predicates.TagPredicate;
//~}
//? if >26.1 {
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.triggers.KilledTrigger;
//?} else {
/*import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.KilledTrigger;
*///?}

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.DamageTypeTags;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class EmbersAdvancementProvider extends FabricAdvancementProvider {
	public EmbersAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(output, registryLookup);
	}

	@SuppressWarnings("all")
	@Override
	public void generateAdvancement(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
		var entityTypes = provider.lookup(Registries.ENTITY_TYPE).get();

		//? if <26.4 {
		net.minecraft.advancements.Advancement.Builder.advancement()
				.parent(Identifier.parse("adventure/kill_a_mob"))
				.display(
						ModItems.ICE_BALL,
						Component.translatable("advancements.adventure.what_goes_around_comes_around.title"),
						Component.translatable("advancements.adventure.what_goes_around_comes_around.description"),
						//? if <26.3
						//null,
						AdvancementType.TASK,
						true,
						true,
						false
				)
				.addCriterion(
						"kill_frostbite_with_ice_ball",
						KilledTrigger.TriggerInstance.playerKilledEntity(
								EntityPredicate.Builder.entity().of(
										//? if >26
										entityTypes,
										ModEntityTypes.FROSTBITE),
								this.isProjectile(provider).direct(EntityPredicate.Builder.entity().of(
										//? if >26
										entityTypes,
										ModEntityTypes.ICE_BALL))
						)
				)
				.save(consumer, EmbersAndIcicles.of("adventure/what_goes_around_comes_around")
						//? if <26
						//.toString()
				);
		//?}
	}

	protected DamageSourcePredicate.Builder isProjectile(HolderLookup.Provider provider) {
		return DamageSourcePredicate.Builder.damageType().tag(TagPredicate.is(
				//? if >26.2
				provider.lookup(Registries.DAMAGE_TYPE).get(),
				DamageTypeTags.IS_PROJECTILE));
	}
}
//~}
//?}
