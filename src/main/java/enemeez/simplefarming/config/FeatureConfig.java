package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FeatureConfig {
	public static ForgeConfigSpec.BooleanValue mod_harvest;
	public static ForgeConfigSpec.BooleanValue smart_harvest;
	public static ForgeConfigSpec.DoubleValue seed_drop;

	public static void init(ForgeConfigSpec.Builder config) {

		mod_harvest = config.comment("Indicates whether right-click harvesting crops should be enabled")
				.define("Enable right-click harvesting for crops", true);

		smart_harvest = config.comment(
				"Smart harvesting allows right-click harvested items to be placed directly in the player's inventory. Enabling this option will automatically disable normal right-click harvesting. Indicates whether smart-harvesting on crops should be enabled")
				.define("Enable smart harvest for crops", false);

		seed_drop = config.comment("Chance of seeds dropping from breaking grass (Default: 6.25 (6.25%))")
				.defineInRange("Percent chance of seeds dropping", 6.25, 0, 100);

	}

}