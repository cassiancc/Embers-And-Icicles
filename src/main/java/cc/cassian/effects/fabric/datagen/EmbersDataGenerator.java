//? fabric {
package cc.cassian.effects.fabric.datagen;

import cc.cassian.effects.fabric.datagen.providers.EmbersBlockTagProvider;
import cc.cassian.effects.fabric.datagen.providers.EmbersItemTagProvider;
import cc.cassian.effects.fabric.datagen.providers.EmbersPotionTagProvider;
import cc.cassian.effects.fabric.datagen.providers.EmbersRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EmbersDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(EmbersRecipeProvider::new);
		var blocks = pack.addProvider(EmbersBlockTagProvider::new);
		pack.addProvider((output, registryLookupFuture) -> new EmbersItemTagProvider(output, registryLookupFuture, blocks));
		pack.addProvider(EmbersPotionTagProvider::new);
	}
}
//?}
