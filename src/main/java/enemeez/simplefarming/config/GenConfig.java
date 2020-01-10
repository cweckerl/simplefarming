package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GenConfig {
	public static ForgeConfigSpec.IntValue bush_chance;

	public static ForgeConfigSpec.IntValue cactus_chance;

	public static ForgeConfigSpec.IntValue tree_chance;

	public static ForgeConfigSpec.IntValue wild_crop_chance;

	public static ForgeConfigSpec.IntValue wild_plant_chance;

	public static void init(ForgeConfigSpec.Builder config) {

		bush_chance = config.comment(
				"Chance of berry bushes generating in the overworld. Higher numbers indicate a lower probability (Default: 300)")
				.defineInRange("Probability of berry bushes generating", 2000, 1, 1000000000);

		cactus_chance = config.comment(
				"Chance of opuntias generating in deserts. Higher numbers indicate a lower probability (Default: 150)")
				.defineInRange("Probability of opuntias generating", 1500, 1, 1000000000);

		tree_chance = config.comment(
				"Chance of fruit trees generating in the overworld. Higher numbers indicate a lower probability (Default: 1500)")
				.defineInRange("Probability of fruit trees generating", 10000, 1, 1000000000);

		wild_crop_chance = config.comment(
				"Chance of wild crops generating in the overworld. Higher numbers indicate a lower probability (Default: 100)")
				.defineInRange("Probability of wild crops generating", 3000, 1, 1000000000);

		wild_plant_chance = config.comment(
				"Chance of wild plants generating in the overworld. Higher numbers indicate a lower probability (Default: 800)")
				.defineInRange("Probability of wild plants generating", 8000, 1, 1000000000);

	}

}