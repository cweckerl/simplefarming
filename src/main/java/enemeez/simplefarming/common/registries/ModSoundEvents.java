package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SimpleFarming.MOD_ID);

    public static final RegistryObject<SoundEvent> MUSIC_DISC_NOURISH = SOUND_EVENTS.register("music_disc.nourish",
        () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SimpleFarming.MOD_ID, "music_disc.nourish")
        ));

}
