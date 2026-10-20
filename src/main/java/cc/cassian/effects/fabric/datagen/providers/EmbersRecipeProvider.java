//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.effects.registry.ModItems;
import cc.cassian.effects.registry.ModPotions;
import cc.cassian.effects.util.BrewingMix;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("all")
public class EmbersRecipeProvider extends FabricRecipeProvider {


	public EmbersRecipeProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(packOutput, registriesFuture);
	}

	//? if >26.2 {
	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> bootstrapContext, BootstrapContext<Advancement> bootstrapContext1) {
		return new RecipeProvider(bootstrapContext, bootstrapContext1) {
		@Override
			public void buildRecipes() {
			//?} else if >26 {

			/*@Override
			protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
				return new RecipeProvider(registries, output) {
				@Override
			public void buildRecipes() {
			*///?} else {
			/*@Override
			public void buildRecipes(RecipeOutput output) {
		*///?}

			//? if >=26.3 {
			new  net.fabricmc.fabric.api.datagen.v1.provider.FabricBrewingProvider(output) {
				@Override
				protected void buildMixes() {
					for (BrewingMix addMix : BrewingMix.addMixes()) {
						if (addMix.base().isEmpty()) {
							buildStartMix(addMix.reagent(), addMix.output());
						} else {
							buildMix(addMix.base().get(), addMix.reagent(), addMix.output());
						}
					}
				}
			}.buildRecipes();
			//?}

				twoByTwoPacker(
						//? if <26
						//output,
						RecipeCategory.MISC, Items.ICE, ModItems.ICE_BALL);

				//? if <26.4 {
				twoByTwoPacker(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.PACKED_ICE_BRICKS, Items.PACKED_ICE);
				slab(
					//? if <26
					//output,
					RecipeCategory.MISC, ModItems.PACKED_ICE_BRICK_SLAB, ModItems.PACKED_ICE_BRICKS);
				stairBuilder(ModItems.PACKED_ICE_BRICK_STAIRS, Ingredient.of(ModItems.PACKED_ICE_BRICKS)).unlockedBy(getHasName(ModItems.PACKED_ICE_BRICKS), has(ModItems.PACKED_ICE_BRICKS)).save(output);
				chiseled(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.CHISELED_PACKED_ICE, ModItems.PACKED_ICE_BRICK_SLAB);
				stonecutterResultFromBase(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.PACKED_ICE_BRICKS, Items.PACKED_ICE);
				stonecutterResultFromBase(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.PACKED_ICE_BRICK_SLAB, ModItems.PACKED_ICE_BRICKS, 2);
				stonecutterResultFromBase(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.PACKED_ICE_BRICK_SLAB, Items.PACKED_ICE, 2);
				stonecutterResultFromBase(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.PACKED_ICE_BRICK_STAIRS, ModItems.PACKED_ICE_BRICKS);
				stonecutterResultFromBase(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.PACKED_ICE_BRICK_STAIRS, Items.PACKED_ICE);
				stonecutterResultFromBase(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.CHISELED_PACKED_ICE, ModItems.PACKED_ICE_BRICKS);
				stonecutterResultFromBase(
						//? if <26
						//output,
						RecipeCategory.MISC, ModItems.CHISELED_PACKED_ICE, Items.PACKED_ICE);
			//?}
				//? if >26 {
			}
		};
//?}
	}

	@Override
	public String getName() {
		return "Recipes";
	}
}
//~}
//?}
