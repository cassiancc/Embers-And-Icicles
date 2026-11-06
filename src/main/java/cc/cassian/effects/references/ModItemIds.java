package cc.cassian.effects.references;

import cc.cassian.effects.EmbersAndIcicles;
//? if >=26.4 {
/*import cc.cassian.effects.util.ModUtil;
import net.minecraft.core.registries.BuiltInRegistries;
*///?}
import cc.cassian.effects.registry.ModJukeboxSongs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;

public class ModItemIds {
	//? if <26.4 {
	public static final ResourceKey<Item> ICE_BALL = register("ice_ball");
	public static final ResourceKey<Item> FROSTBITE_SPAWN_EGG = register("frostbite_spawn_egg");
	public static final ResourceKey<Item> MUSIC_DISC_FLURRY = register("music_disc_flurry");

	//?}

	private static ResourceKey<Item> register(String path) {
		//? if >=26.4
		//ModUtil.addAlias(BuiltInRegistries.ITEM, path);
		return ResourceKey.create(Registries.ITEM, EmbersAndIcicles.of(path));
	}
}
