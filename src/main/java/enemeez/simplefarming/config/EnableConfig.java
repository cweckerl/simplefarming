package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class EnableConfig {
	public static ForgeConfigSpec.BooleanValue bush_validate;

	public static ForgeConfigSpec.BooleanValue tree_validate;

	public static ForgeConfigSpec.BooleanValue cactus_validate;

	public static ForgeConfigSpec.BooleanValue wild_crop_validate;

	public static ForgeConfigSpec.BooleanValue wild_plant_validate;

	public static ForgeConfigSpec.BooleanValue stem_toggle;

	public static void init(ForgeConfigSpec.Builder config) {
		bush_validate = config.comment("Indicates whether berry bushes should generate").define("Generate berry bushes",
				true);

		cactus_validate = config.comment("Indicates whether opuntias (cactus crops) should generate")
				.define("Generate opuntias", true);

		tree_validate = config.comment("Indicates whether fruit trees should generate").define("Generate fruit trees",
				true);

		wild_crop_validate = config.comment(
				"Enable this feature to avoid conflicts with other mods that add grass drops (And disable grass drops).")
				.define("Generate wild crops", false);

		wild_plant_validate = config.comment("Indicates whether wild plants, such as quinoa and cumin, should generate")
				.define("Generate wild plants", true);

		stem_toggle = config
				.comment("Indicates whether vanilla pumpkin and melon stems should be replaced by a single block crop")
				.define("Replace stems", false);
	}

}