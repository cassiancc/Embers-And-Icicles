//? fabric {
//~ if <26 'FabricPackOutput'->'FabricDataOutput' {
package cc.cassian.effects.fabric.datagen.providers;

import cc.cassian.effects.EmbersAndIcicles;
import cc.cassian.effects.references.ModBlockItemIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
//? if >26 {
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
//?} else {
/*import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
*///?}
import net.minecraft.core.registries.BuiltInRegistries;
//~ if >=26.2 'cc.cassian.effects.references.BlockItemId'->'net.minecraft.references.BlockItemId'
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EmbersModelProvider extends FabricModelProvider {


	public EmbersModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
		BuiltInRegistries.ITEM.entrySet().forEach(resourceKeyItemEntry -> {
			Identifier id =  resourceKeyItemEntry.getKey().identifier();
			Item value = resourceKeyItemEntry.getValue();
			if (is(id, ModBlockItemIds.ICE_CRYSTAL) || is(id, ModBlockItemIds.ICICLE)) return;
			if (id.getNamespace().equals(EmbersAndIcicles.MOD_ID)) {
				if (value instanceof BlockItem blockItem) {
					id = id.withPrefix("block/");
					if (id.getPath().contains("wall"))
						id = id.withSuffix("_inventory");
					if (id.getPath().contains("brittle"))
						id = id.withSuffix("_0");
					//~ if >26 'delegateItemModel'->'registerSimpleItemModel'
					blockModelGenerators.registerSimpleItemModel(blockItem.getBlock(), id);
				}
			}
		});
	}

	private boolean is(Identifier id1, BlockItemId id2) {
		return id1.equals(id2.item().identifier());
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerators) {

	}
}
//~}
//?}