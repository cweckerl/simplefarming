package dev.enemeez.simplefarming.common.registries;

import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, SimpleFarming.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_NOURISH = SOUND_EVENTS.register("music_disc.nourish",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SimpleFarming.MOD_ID, "music_disc.nourish"))
    );

    public static final ResourceKey<JukeboxSong> NOURISH_SONG = ResourceKey.create(
        Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(SimpleFarming.MOD_ID, "nourish")
    );
}
