package enemeez.simplefarming.events;

import enemeez.simplefarming.config.EnableConfig;
import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.config.RightClickConfig;
import enemeez.simplefarming.events.harvest.DoubleCropBreak;
import enemeez.simplefarming.events.harvest.smart.SmartBerryBushHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartCactusCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartDoubleCropHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartFruitLeavesHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartGrapeHarvest;
import enemeez.simplefarming.events.harvest.smart.SmartWildPlantHarvest;
import enemeez.simplefarming.events.harvest.standard.BerryBushHarvest;
import enemeez.simplefarming.events.harvest.standard.CactusCropHarvest;
import enemeez.simplefarming.events.harvest.standard.CropHarvest;
import enemeez.simplefarming.events.harvest.standard.DoubleCropHarvest;
import enemeez.simplefarming.events.harvest.standard.FruitLeavesHarvest;
import enemeez.simplefarming.events.harvest.standard.GrapeHarvest;
import enemeez.simplefarming.events.harvest.standard.WildPlantHarvest;
import net.minecraftforge.common.MinecraftForge;

public class EventSetup {

	public static void setupEvents() {
		MinecraftForge.EVENT_BUS.register(new LootTableHandler());
		MinecraftForge.EVENT_BUS.register(new TemptationTask());
		MinecraftForge.EVENT_BUS.register(new DoubleCropBreak());
		MinecraftForge.EVENT_BUS.register(new IntoxicationTracker());
		MinecraftForge.EVENT_BUS.register(new ScarecrowEvent());

		if (EnableConfig.stem_toggle.get())
			MinecraftForge.EVENT_BUS.register(new StemReplaceEvent());

		if (FeatureConfig.mod_harvest.get() && !FeatureConfig.smart_harvest.get()) {
			if (RightClickConfig.bush_right_click.get())
				MinecraftForge.EVENT_BUS.register(new BerryBushHarvest());
			if (RightClickConfig.cactus_right_click.get())
				MinecraftForge.EVENT_BUS.register(new CactusCropHarvest());
			if (RightClickConfig.crop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new CropHarvest());
			if (RightClickConfig.doublecrop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new DoubleCropHarvest());
			if (RightClickConfig.tree_right_click.get())
				MinecraftForge.EVENT_BUS.register(new FruitLeavesHarvest());
			if (RightClickConfig.grape_right_click.get())
				MinecraftForge.EVENT_BUS.register(new GrapeHarvest());
			if (RightClickConfig.plant_right_click.get())
				MinecraftForge.EVENT_BUS.register(new WildPlantHarvest());
		}
		if (FeatureConfig.smart_harvest.get() && !FeatureConfig.mod_harvest.get()) {
			if (RightClickConfig.bush_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartBerryBushHarvest());
			if (RightClickConfig.cactus_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartCactusCropHarvest());
			if (RightClickConfig.crop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartCropHarvest());
			if (RightClickConfig.doublecrop_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartDoubleCropHarvest());
			if (RightClickConfig.tree_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartFruitLeavesHarvest());
			if (RightClickConfig.grape_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartGrapeHarvest());
			if (RightClickConfig.plant_right_click.get())
				MinecraftForge.EVENT_BUS.register(new SmartWildPlantHarvest());
		}
	}

}
