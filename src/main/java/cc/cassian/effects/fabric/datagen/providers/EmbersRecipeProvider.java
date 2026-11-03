//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.effects.registry.ModBlocks;
import cc.cassian.effects.registry.ModItems;
import cc.cassian.effects.registry.ModPotions;
import cc.cassian.effects.util.BrewingMix;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.BlockFamilies.familyBuilder;
import static net.minecraft.data.recipes.ShapedRecipeBuilder.shaped;

@SuppressWarnings("all")
public class EmbersRecipeProvider extends FabricRecipeProvider {

	//? if <26.4 {
	public static final BlockFamily CALCITE = familyBuilder(Blocks.CALCITE)
			.slab(ModBlocks.CALCITE_SLAB)
			.stairs(ModBlocks.CALCITE_STAIRS)
			.wall(ModBlocks.CALCITE_WALL)
			.polished(ModBlocks.POLISHED_CALCITE)
			//? if >26.1
			.pillar(ModBlocks.CALCITE_PILLAR)
			//? if >26
			.generateStonecutterRecipe()
			.getFamily();
	public static final BlockFamily POLISHED_CALCITE = familyBuilder(ModBlocks.POLISHED_CALCITE)
			.stairs(ModBlocks.POLISHED_CALCITE_STAIRS)
			.wall(ModBlocks.POLISHED_CALCITE_WALL)
			//? if >26 {
			.bricks(ModBlocks.POLISHED_CALCITE_BRICKS)
			.generateStonecutterRecipe()
			//?}
			.getFamily();
	public static final BlockFamily POLISHED_CALCITE_BRICKS = familyBuilder(ModBlocks.POLISHED_CALCITE_BRICKS)
			.slab(ModBlocks.POLISHED_CALCITE_BRICK_SLAB)
			.stairs(ModBlocks.POLISHED_CALCITE_BRICK_STAIRS)
			.wall(ModBlocks.POLISHED_CALCITE_BRICK_WALL)
			//? if >26
			.generateStonecutterRecipe()
			.getFamily();
	//?}


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
				//~ if <26 '(RecipeCategory'->'(output, RecipeCategory' {
				polished(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICKS, Items.PACKED_ICE);
				slab(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICK_SLAB, ModItems.PACKED_ICE_BRICKS);
				stairBuilder(ModItems.PACKED_ICE_BRICK_STAIRS, Ingredient.of(ModItems.PACKED_ICE_BRICKS))
						.unlockedBy(getHasName(ModItems.PACKED_ICE_BRICKS), has(ModItems.PACKED_ICE_BRICKS))
						.save(output);
				wall(RecipeCategory.DECORATIONS, ModItems.PACKED_ICE_BRICK_WALL, ModItems.PACKED_ICE_BRICKS);
				chiseled(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_PACKED_ICE, ModItems.PACKED_ICE_BRICK_SLAB);

				polished(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_BRICKS, Items.SNOW_BLOCK);
				slab(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_BRICK_SLAB, ModItems.SNOW_BRICKS);
				stairBuilder(ModItems.SNOW_BRICK_STAIRS, Ingredient.of(ModItems.SNOW_BRICKS))
						.unlockedBy(getHasName(ModItems.SNOW_BRICKS), has(ModItems.SNOW_BRICKS))
						.save(output);
				wall(RecipeCategory.DECORATIONS, ModItems.SNOW_BRICK_WALL, ModItems.SNOW_BRICKS);

				slab(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE_SLAB, ModItems.POLISHED_CALCITE);

				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE_SLAB, Blocks.CALCITE, 2);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE_SLAB, ModItems.POLISHED_CALCITE, 2);

				for (BlockFamily blockFamily : List.of(CALCITE, POLISHED_CALCITE, POLISHED_CALCITE_BRICKS)) {
					generateRecipes(
							//? if <26
							//output,
							blockFamily, FeatureFlags.VANILLA_SET);
					//? if <26 {
					/*blockFamily.getVariants().forEach((variant, block) -> {
						int count = variant.equals(BlockFamily.Variant.SLAB) ? 2 : 1;
						stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, block, blockFamily.getBaseBlock(), count);
						if (!blockFamily.getBaseBlock().equals(Blocks.CALCITE))
							stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, block, Blocks.CALCITE, count);
					});
					*///?}
				}

				//? if <=26.1 {
				/*shaped(
						RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_PILLAR)
						.define('#', ModBlocks.CALCITE_SLAB)
						.pattern("#")
						.pattern("#")
						.unlockedBy("has_calcite_block", this.has(Blocks.CALCITE))
						.save(output);
				for (ItemLike base : List.of(Items.CALCITE)) {
					stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_PILLAR, base);
				}
				*///?}
				//? if <26 {
				/*shaped(
						RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS, 4)
						.define('#', ModBlocks.POLISHED_CALCITE)
						.pattern("##")
						.pattern("##")
						.unlockedBy("has_calcite_block", this.has(Blocks.CALCITE))
						.save(output);
				for (ItemLike base : List.of(Items.CALCITE, ModItems.POLISHED_CALCITE)) {
					stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE_BRICKS, base);
				}
				*///?}

				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICKS, Items.PACKED_ICE);
				for (ItemLike base : List.of(Items.PACKED_ICE, ModItems.PACKED_ICE_BRICKS)) {
					stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICK_SLAB, base, 2);
					stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICK_STAIRS, base);
					stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PACKED_ICE_BRICK_WALL, base);
					stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_PACKED_ICE, base);
				}
				//~}
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
