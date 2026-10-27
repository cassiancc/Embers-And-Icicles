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
		dropSelf(ModBlocks.SNOW_BRICKS);
		add(ModBlocks.SNOW_BRICK_SLAB, this::createSlabItemTable);
		dropSelf(ModBlocks.SNOW_BRICK_STAIRS);
		dropSelf(ModBlocks.SNOW_BRICK_WALL);
		//?}
	}
}
//~}
//?}