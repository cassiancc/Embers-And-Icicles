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
			Identifier key =  resourceKeyItemEntry.getKey().identifier();
			Item value = resourceKeyItemEntry.getValue();
			if (key.equals(ModBlockItemIds.ICE_CRYSTAL.item().identifier())) return;
			if (key.getNamespace().equals(EmbersAndIcicles.MOD_ID)) {
				if (value instanceof BlockItem blockItem) {
					key = key.withPrefix("block/");
					if (key.getPath().contains("wall"))
						key = key.withSuffix("_inventory");
					//~ if >26 'delegateItemModel'->'registerSimpleItemModel'
					blockModelGenerators.registerSimpleItemModel(blockItem.getBlock(), key);
				}
			}
		});
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerators) {

	}
}
//~}
//?}