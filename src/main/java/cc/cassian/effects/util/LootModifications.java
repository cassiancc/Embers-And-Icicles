package cc.cassian.effects.util;

import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.registry.ModItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
//? if >26.1.2 {
import net.minecraft.advancements.predicates.MobEffectsPredicate;
import net.minecraft.advancements.triggers.EffectsChangedTrigger;
//?}
//? if <26.3 && >26 {
/*import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
*///?}
//? if >=26.3 {
import net.minecraft.world.level.storage.loot.predicates.LootPredicates;
import net.minecraft.core.Holder;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
//?} else if >26 {
/*import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.core.component.predicates.DataComponentPredicates;
import net.minecraft.core.component.predicates.EnchantmentsPredicate;
*///?} else {
/*import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
*///?}
//~ if <26.2 'predicates'->'criterion' {
import net.minecraft.advancements.predicates.EnchantmentPredicate;
import net.minecraft.advancements.predicates.MinMaxBounds;
//~}

import java.util.List;

public class LootModifications {

	public static void modify(ResourceKey<LootTable> key,
							  //? fabric
							  LootTable.Builder builder,
							  //? neoforge
							  //LootTable builder,
							  //? <26 {
							  /*HolderLookup.Provider provider
							  *///?} else
							  HolderGetter.Provider provider
							  ) {
		if (EmbersAndIcicles.CONFIG.iceDropsIceBalls && Blocks.ICE.getLootTable()
				//? if >26
				.orElseThrow()
				== key) {
			// Create a new loot pool that will hold the ice cubes.
			var pool = LootPool.lootPool()
					// Add ice cubes...
					//~ if <26.3 'ContextIntProviders'->'UniformGenerator'
					.add(LootItem.lootTableItem(ModItems.ICE_BALL).apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3))))
					// ...only if the block would not be dropped.
					.when(InvertedLootItemCondition.invert(silkTouch(provider)));

			// Add the loot pool to the loot table
			addPool(builder, pool);
		}
		//? if <26.4 {
		else if (key == BuiltInLootTables.IGLOO_CHEST) {
			var pool = (LootPool.lootPool()
					//~ if <26.3 'ContextIntProviders'->'ConstantValue'
					.setRolls(ContextIntProviders.exactly(1))
					.when(LootItemRandomChanceCondition.randomChance(0.3F))
					.add(LootItem.lootTableItem(ModItems.MUSIC_DISC_FLURRY)));
			addPool(builder, pool);
		}
		//?}
	}

	public static void addPool(
			//? fabric
			LootTable.Builder builder,
			//? neoforge
			//LootTable builder,
			LootPool.Builder pool) {
		//? fabric
		builder.withPool(pool);
		//? neoforge
		//builder.addPool(pool.build());
	}

	//~ if >26.2 'LootItemCondition.Builder'->'Holder.Reference<LootItemCondition>'
	public static Holder.Reference<LootItemCondition> silkTouch(
			//? <26 {
			/*HolderLookup.Provider provider
		 	 *///?} else
			HolderGetter.Provider provider

	) {
		return
				//? if >=26.3 {
				provider.lookupOrThrow(Registries.PREDICATE).getOrThrow(LootPredicates.TOOL_CAN_SILK_TOUCH);
				 //?} else if >26 {
		/*MatchTool.toolMatches(
				//~ if =26.1 'predicates'->'criterion' {
				net.minecraft.advancements.predicates.ItemPredicate.Builder.item()
						.withComponents(
								net.minecraft.advancements.predicates.DataComponentMatchers.Builder.components()
				//~}
										.partial(
												DataComponentPredicates.ENCHANTMENTS,
												EnchantmentsPredicate.enchantments(
														List.of(
																new EnchantmentPredicate(provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1))
														)
												)
										)
										.build()
						)
		);
		*///?} else {
				/*MatchTool.toolMatches(
						net.minecraft.advancements.criterion.ItemPredicate.Builder.item()
								.withSubPredicate(
										net.minecraft.advancements.criterion.ItemSubPredicates.ENCHANTMENTS,
										net.minecraft.advancements.criterion.ItemEnchantmentsPredicate.enchantments(List.of(new EnchantmentPredicate(provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1))))
								)
				);
		*///?}
	}
}
