package enemeez.simplefarming.events;

import enemeez.simplefarming.SimpleFarming;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class SimpleSoundEvents {

	public static SoundEvent music_disc_nourish = register("music_disc.nourish");

	private static SoundEvent register(String key) {
		ResourceLocation id = SimpleFarming.getId(key);
		SoundEvent event = new SoundEvent(id);
    	event.setRegistryName(id);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
