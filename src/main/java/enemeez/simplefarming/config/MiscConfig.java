package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MiscConfig {

	public static ForgeConfigSpec.BooleanValue stem_toggle;

	public static ForgeConfigSpec.BooleanValue doubleCropsSlowDownMotion;

	public static void init(ForgeConfigSpec.Builder config) {

		doubleCropsSlowDownMotion = config.comment(
				"Configures if Double Crops (i.e. Corn, Sorghum, Kenaf) slow down living entities (Default: false)")
				.define("Double Crops Slow Down Motion", false);

		stem_toggle = config
				.comment("Indicates whether vanilla pumpkin and melon stems should be replaced by a single block crop")
				.define("Replace stems", false);
	}

}