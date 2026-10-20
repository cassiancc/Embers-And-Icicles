package cc.cassian.effects.util;

import cc.cassian.effects.registry.ModItems;
import cc.cassian.effects.registry.ModPotions;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;

import java.util.List;
import java.util.Optional;

public record BrewingMix(Optional<Holder<Potion>> base, Item reagent, Holder<Potion> output) {

	public static List<BrewingMix> addMixes() {
		return List.of(
				//? if <26.4 {
				buildStartMix(
						// Ingredient
						ModItems.ICE_BALL,
						// Output potion.
						ModPotions.FREEZING
				),
		buildMix(
				ModPotions.FREEZING,
				// Ingredient
				Items.REDSTONE,
				// Output potion.
				ModPotions.LONG_FREEZING
		),
		//?}
		buildStartMix(
				// Ingredient
				Items.FIRE_CHARGE,
				// Output potion.
				ModPotions.BURNING
		),
		buildMix(
				ModPotions.BURNING,
				// Ingredient
				Items.REDSTONE,
				// Output potion.
				ModPotions.LONG_BURNING
		)
		);
	}

	private static BrewingMix buildMix(Holder<Potion> base, Item reagent, Holder<Potion> output) {
		return new BrewingMix(Optional.of(base), reagent, output);
	}

	private static BrewingMix buildStartMix(Item iceBall, Holder<Potion> freezing) {
		return new BrewingMix(Optional.empty(), iceBall, freezing);
	}
}
