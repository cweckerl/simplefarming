package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FeatureConfig {
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
	public static ForgeConfigSpec.BooleanValue doubleCropsSlowDownMotion;

	public static void init(ForgeConfigSpec.Builder config) {
		rightClickHarvest = config.comment(
				"Configures if right-click harvesting of crops should be enabled. Which crops are affected by right-clicking can be configured in the \"Right-click Harvesting Settings\" section.",
				"DISABLED -> disables right-click harvesting feature for all crops completely",
				"ENABLED_DROP -> loot is dropped on the ground",
				"ENABLED_SMART -> loot is placed in the player's inventory").defineEnum("Right-Click Harvest",
						RightClickHarvestFeature.ENABLED_DROP, RightClickHarvestFeature.values());

		doubleCropsSlowDownMotion = config
				.comment("Configures if Double Crops (i.e. Corn, Sorghum, Kenaf) slow down living entities")
				.define("Double Crops Slow Down Motion", true);
	}
}