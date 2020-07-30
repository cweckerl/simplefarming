package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class RightClickConfig {
	public static ForgeConfigSpec.BooleanValue crop_right_click;
	public static ForgeConfigSpec.BooleanValue bush_right_click;
	public static ForgeConfigSpec.BooleanValue cactus_right_click;
	public static ForgeConfigSpec.BooleanValue tree_right_click;
	public static ForgeConfigSpec.BooleanValue plant_right_click;
	public static ForgeConfigSpec.BooleanValue grape_right_click;
	public static ForgeConfigSpec.BooleanValue doublecrop_right_click;

	public static void init(ForgeConfigSpec.Builder config) {

		crop_right_click = config.comment("Indicates whether right-click harvesting crops should be enabled").define("Enable right-click harvesting for crops", true);

		bush_right_click = config.comment("Indicates whether right-click harvesting berry bushes should be enabled").define("Enable right-click harvesting for berry bushes", true);

		cactus_right_click = config.comment("Indicates whether right-click harvesting opuntias should be enabled").define("Enable right-click harvesting for opuntias", true);

		tree_right_click = config.comment("Indicates whether right-click harvesting tree leaves should be enabled").define("Enable right-click harvesting for tree leaves", true);

		plant_right_click = config.comment("Indicates whether right-click harvesting wild plants should be enabled").define("Enable right-click harvesting for wild plants", true);

		grape_right_click = config.comment("Indicates whether right-click harvesting grapes should be enabled").define("Enable right-click harvesting for grapes", true);

		doublecrop_right_click = config.comment("Indicates whether right-click harvesting double-high-crops should be enabled").define("Enable right-click harvesting for double-high-crops", true);

	}

}