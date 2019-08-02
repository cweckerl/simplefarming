package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GenConfig 
{
	public static ForgeConfigSpec.BooleanValue bush_validate;
	public static ForgeConfigSpec.IntValue bush_chance;
	
	public static ForgeConfigSpec.BooleanValue tree_validate;
	public static ForgeConfigSpec.IntValue tree_chance;
	
	public static ForgeConfigSpec.BooleanValue cactus_validate;
	public static ForgeConfigSpec.IntValue cactus_chance;
	
	public static ForgeConfigSpec.BooleanValue wild_crop_validate;
	public static ForgeConfigSpec.IntValue wild_crop_chance;
	
	public static ForgeConfigSpec.BooleanValue grass_drops;
	
	public static ForgeConfigSpec.BooleanValue squid_drops;
	
	public static ForgeConfigSpec.BooleanValue wild_plant_validate;
	public static ForgeConfigSpec.IntValue wild_plant_chance;
	
	
	
	public static void init(ForgeConfigSpec.Builder config)
	{
		config.comment("Simple Farming World Generation");
		
		grass_drops = config
				.comment("Indicates whether seeds should drop from grass blocks")
				.define("Drop seeds from grass", true);
		
		squid_drops = config
				.comment("Indicates whether calamari should drop from squids")
				.define("Drop calamari from squids", true);
		
		bush_validate = config
				.comment("Indicates whether berry bushes should generate")
				.define("Generate berry bushes", true);
		
		tree_validate = config
				.comment("Indicates whether fruit trees should generate")
				.define("Generate fruit trees", true);
		
		cactus_validate = config
				.comment("Indicates whether opuntias (cactus crops) should generate")
				.define("Generate opuntias", true);
		
		wild_crop_validate = config
				.comment("Enable this feature to avoid conflicts with other mods that addgrass drops (And disable grass drops).")
				.define("Generate wild crops", false);
		
		wild_plant_validate = config
				.comment("Indicates whether wild plants, such as quinoa and cumin, should generate")
				.define("Generate wild plants", true);
		
		
		
		wild_crop_chance = config
				.comment("Chance of wild crops generating in the overworld. Higher numbers indicate a lower probability (Default: 100)")
				.defineInRange("Probability of wild crops generating", 100, 1, 1000000000);
		
		wild_plant_chance = config
				.comment("Chance of wild plants generating in the overworld. Higher numbers indicate a lower probability (Default: 800)")
				.defineInRange("Probability of wild plants generating", 800, 1, 1000000000);
		
		bush_chance = config
				.comment("Chance of berry bushes generating in the overworld. Higher numbers indicate a lower probability (Default: 180)")
				.defineInRange("Probability of berry bushes generating", 180, 1, 1000000000);

		tree_chance = config
				.comment("Chance of fruit trees generating in the overworld. Higher numbers indicate a lower probability (Default: 600)")
				.defineInRange("Probability of fruit trees generating", 600, 1, 1000000000);
		
		cactus_chance = config
				.comment("Chance of opuntias generating in deserts. Higher numbers indicate a lower probability (Default: 150)")
				.defineInRange("Probability of opuntias generating", 150, 1, 1000000000);
		
	}

}
