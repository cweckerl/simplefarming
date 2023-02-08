package enemeez.simplefarming.common.data;

import enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = SimpleFarming.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        gen.addProvider(event.includeServer(), new ModWorldGenProvider(
            gen.getPackOutput(),
            event.getLookupProvider(),
            Set.of(SimpleFarming.MOD_ID)
        ));
    }
}
