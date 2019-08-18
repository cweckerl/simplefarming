package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FeatureConfig
{
	//public static ForgeConfigSpec.BooleanValue right_click_harvest;
	
	public static ForgeConfigSpec.BooleanValue vanilla_seed_drops;
	
	//public static ForgeConfigSpec.BooleanValue smart_harvesting;
	
	
	
	
	public static void init(ForgeConfigSpec.Builder config)
	{
		/*
		right_click_harvest = config
				.comment("Indicates whether right-click harvesting on blocks should be enabled")
				.define("Enable right-click harvesting", false);
				*/

		vanilla_seed_drops = config
				.comment("Indicates whether vanilla seeds (beetroot, melon, & pumpkin) should drop from grass")
				.define("Drop vanilla seeds", true);
		/*
		smart_harvesting = config
				.comment("Indicates whether smart harvesting should be used when right-click harvesting")
				.comment("Smart harvesting puts the item directly in the player's inventory instead of dropping the product")
				.define("Use smart harvesting", true);
				*/

	}
	

}
