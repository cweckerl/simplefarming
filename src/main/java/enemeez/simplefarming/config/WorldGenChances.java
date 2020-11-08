package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class WorldGenChances {
	public static ForgeConfigSpec.IntValue bush_chance;

	public static ForgeConfigSpec.IntValue cactus_chance;

	public static ForgeConfigSpec.IntValue tree_chance;

	public static ForgeConfigSpec.IntValue wild_crop_chance;

	public static ForgeConfigSpec.IntValue wild_plant_chance;

	public static void init(ForgeConfigSpec.Builder config) {

		bush_chance = config.comment("Chance of berry bushes generating in the overworld. Higher numbers indicate a lower probability (Default: 2000)")
				.defineInRange("Probability of berry bushes generating", 2000, 0, Integer.MAX_VALUE);

		cactus_chance = config.comment("Chance of opuntias generating in deserts. Higher numbers indicate a lower probability (Default: 1500)").defineInRange("Probability of opuntias generating", 1500,
			 0, Integer.MAX_VALUE);

		tree_chance = config.comment("Chance of fruit trees generating in the overworld. Higher numbers indicate a lower probability (Default: 10000)")
				.defineInRange("Probability of fruit trees generating", 10000, 0, Integer.MAX_VALUE);

		wild_crop_chance = config.comment("Chance of wild crops generating in the overworld. Higher numbers indicate a lower probability (Default: 3000)")
				.defineInRange("Probability of wild crops generating", 3000, 0, Integer.MAX_VALUE);

		wild_plant_chance = config.comment("Chance of wild plants generating in the overworld. Higher numbers indicate a lower probability (Default: 8000)")
				.defineInRange("Probability of wild plants generating", 8000, 0, Integer.MAX_VALUE);

	}

}