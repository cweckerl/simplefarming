package dev.enemeez.simplefarming.common.data;

import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.data.DataGenerator;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.Set;

@EventBusSubscriber(modid = SimpleFarming.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
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
