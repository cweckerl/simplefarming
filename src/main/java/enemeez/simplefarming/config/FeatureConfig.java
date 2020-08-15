package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FeatureConfig {
	//TODO: replace both config values with one unambiguous enum config value, with the following states: DISABLED, ENABLED_DROP, ENABLED_SMART
	public static ForgeConfigSpec.BooleanValue smart_harvest;
	public static ForgeConfigSpec.BooleanValue mod_harvest;

	public static void init(ForgeConfigSpec.Builder config) {

		mod_harvest = config.comment("Indicates whether right-click harvesting crops should be enabled. Respective parts of the right-clicking function can be enabled/disabled below.")
				.define("Enable right-click harvesting for crops", true);

		smart_harvest = config.comment(
				"Smart harvesting allows right-click harvested items to be placed directly in the player's inventory. Enabling this option will automatically disable normal right-click harvesting. Indicates whether smart-harvesting on crops should be enabled")
				.define("Enable smart harvest for crops", false);

	}

}