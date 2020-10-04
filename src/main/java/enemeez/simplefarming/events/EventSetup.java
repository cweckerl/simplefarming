package enemeez.simplefarming.events;

import enemeez.simplefarming.config.EnableConfig;
import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.config.RightClickConfig;
import enemeez.simplefarming.events.harvest.BerryBushHarvest;
import enemeez.simplefarming.events.harvest.CactusCropHarvest;
import enemeez.simplefarming.events.harvest.CropHarvest;
import enemeez.simplefarming.events.harvest.DoubleCropHarvest;
import enemeez.simplefarming.events.harvest.FruitLeavesHarvest;
import enemeez.simplefarming.events.harvest.GrapeHarvest;
import enemeez.simplefarming.events.harvest.WildPlantHarvest;
import net.minecraftforge.common.MinecraftForge;

public class EventSetup
{

    public static void setupEvents() {
        MinecraftForge.EVENT_BUS.register(new LootTableHandler());
        MinecraftForge.EVENT_BUS.register(new TemptationTask());
        MinecraftForge.EVENT_BUS.register(new IntoxicationTracker());
        MinecraftForge.EVENT_BUS.register(new ScarecrowEvent());

        if (EnableConfig.stem_toggle.get()) {
            MinecraftForge.EVENT_BUS.register(new StemReplaceEvent());
        }

        if (FeatureConfig.rightClickHarvest.get().isEnabled()) {
            if (RightClickConfig.crop_right_click.get()) MinecraftForge.EVENT_BUS.register(new CropHarvest());
            if (RightClickConfig.bush_right_click.get()) MinecraftForge.EVENT_BUS.register(new BerryBushHarvest());
            if (RightClickConfig.cactus_right_click.get()) MinecraftForge.EVENT_BUS.register(new CactusCropHarvest());
            if (RightClickConfig.doublecrop_right_click.get()) MinecraftForge.EVENT_BUS.register(new DoubleCropHarvest());
            if (RightClickConfig.tree_right_click.get()) MinecraftForge.EVENT_BUS.register(new FruitLeavesHarvest());
            if (RightClickConfig.grape_right_click.get()) MinecraftForge.EVENT_BUS.register(new GrapeHarvest());
            if (RightClickConfig.plant_right_click.get()) MinecraftForge.EVENT_BUS.register(new WildPlantHarvest());
        }
    }

}
