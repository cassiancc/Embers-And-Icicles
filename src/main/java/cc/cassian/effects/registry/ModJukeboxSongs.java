package cc.cassian.effects.registry;

import cc.cassian.effects.EmbersAndIcicles;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public interface ModJukeboxSongs {
	ResourceKey<JukeboxSong> FLURRY = create("flurry");

	private static ResourceKey<JukeboxSong> create(final String id) {
		return ResourceKey.create(Registries.JUKEBOX_SONG, EmbersAndIcicles.of(id));
	}

}
