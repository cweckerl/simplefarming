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
	
	public static void init(ForgeConfigSpec.Builder config)
	{
		config.comment("Simple Farming World Generation");
		
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
				.comment("Indicates whether wild crops should generate. This feature is temporary and will eventually be replaced with Vanilla grass")
				.define("Generate wild crops", true);
		
		
		wild_crop_chance = config
				.comment("Chance of wild crops generating in the overworld. Higher numbers indicate a lower probability (Default: 180)")
				.defineInRange("Probability of wild crops generating", 100, 1, 1000000000);
		
		bush_chance = config
				.comment("Chance of berry bushes generating in the overworld. Higher numbers indicate a lower probability (Default: 180)")
				.defineInRange("Probability of berry bushes generating", 180, 1, 1000000000);

		tree_chance = config
				.comment("Chance of fruit trees generating in the overworld. Higher numbers indicate a lower probability (Default: 500)")
				.defineInRange("Probability of fruit trees generating", 500, 1, 1000000000);
		
		cactus_chance = config
				.comment("Chance of opuntias generating in deserts. Higher numbers indicate a lower probability (Default: 150)")
				.defineInRange("Probability of opuntias generating", 150, 1, 1000000000);
		
	}

}
