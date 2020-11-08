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

	public enum RightClickHarvestFeature {
		DISABLED, ENABLED_DROP, ENABLED_SMART;

		public boolean isEnabled() {
			return this != DISABLED;
		}

		public boolean isDropHarvest() {
			return this == ENABLED_DROP;
		}

		public boolean isSmartHarvest() {
			return this == ENABLED_SMART;
		}
	}

	public static ForgeConfigSpec.EnumValue<RightClickHarvestFeature> rightClickHarvest;

	public static void init(ForgeConfigSpec.Builder config) {

		rightClickHarvest = config.comment(
				"Configures if right-click harvesting of crops should be enabled. Which crops are affected by right-clicking can be configured in the \"Right-click Harvesting Settings\" section.",
				"\tDISABLED -> disables right-click harvesting feature for all crops completely",
				"\tENABLED_DROP -> loot is dropped on the ground",
				"\tENABLED_SMART -> loot is placed in the player's inventory").defineEnum("Right-Click Harvest",
						RightClickHarvestFeature.ENABLED_DROP, RightClickHarvestFeature.values());

		crop_right_click = config.comment("Indicates whether right-click harvesting crops should be enabled")
				.define("Enable right-click harvesting for crops", true);

		bush_right_click = config.comment("Indicates whether right-click harvesting berry bushes should be enabled")
				.define("Enable right-click harvesting for berry bushes", true);

		cactus_right_click = config.comment("Indicates whether right-click harvesting opuntias should be enabled")
				.define("Enable right-click harvesting for opuntias", true);

		tree_right_click = config.comment("Indicates whether right-click harvesting tree leaves should be enabled")
				.define("Enable right-click harvesting for tree leaves", true);

		plant_right_click = config.comment("Indicates whether right-click harvesting wild plants should be enabled")
				.define("Enable right-click harvesting for wild plants", true);

		grape_right_click = config.comment("Indicates whether right-click harvesting grapes should be enabled")
				.define("Enable right-click harvesting for grapes", true);

		doublecrop_right_click = config
				.comment("Indicates whether right-click harvesting double-high-crops should be enabled")
				.define("Enable right-click harvesting for double-high-crops", true);

	}

}