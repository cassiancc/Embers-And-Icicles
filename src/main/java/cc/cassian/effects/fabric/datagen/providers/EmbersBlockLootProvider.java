//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.effects.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
//~ if >26 'FabricBlockLootTableProvider'-> 'FabricBlockLootSubProvider'
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

//~ if >26 'FabricBlockLootTableProvider'-> 'FabricBlockLootSubProvider'
public class EmbersBlockLootProvider extends FabricBlockLootSubProvider {
	public EmbersBlockLootProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(packOutput, registriesFuture);
	}

	@Override
	public void generate() {
		//? if <26.4 {
		this.dropSelf(ModBlocks.SNOW_BRICKS);
		this.add(ModBlocks.SNOW_BRICK_SLAB, this::createSlabItemTable);
		this.dropSelf(ModBlocks.SNOW_BRICK_STAIRS);
		this.dropSelf(ModBlocks.SNOW_BRICK_WALL);
		this.dropSelf(Blocks.CALCITE);
		this.dropSelf(ModBlocks.CALCITE_PILLAR);
		this.add(ModBlocks.CALCITE_SLAB, this::createSlabItemTable);
		this.dropSelf(ModBlocks.CALCITE_STAIRS);
		this.dropSelf(ModBlocks.CALCITE_WALL);
		this.dropSelf(ModBlocks.POLISHED_CALCITE);
		this.add(ModBlocks.POLISHED_CALCITE_SLAB, this::createSlabItemTable);
		this.dropSelf(ModBlocks.POLISHED_CALCITE_STAIRS);
		this.dropSelf(ModBlocks.POLISHED_CALCITE_WALL);
		this.dropSelf(ModBlocks.POLISHED_CALCITE_BRICKS);
		this.add(ModBlocks.POLISHED_CALCITE_BRICK_SLAB, this::createSlabItemTable);
		this.dropSelf(ModBlocks.POLISHED_CALCITE_BRICK_STAIRS);
		this.dropSelf(ModBlocks.POLISHED_CALCITE_BRICK_WALL);
		//?}
	}
}
//~}
//?}