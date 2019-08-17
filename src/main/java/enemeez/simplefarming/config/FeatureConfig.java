package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FeatureConfig
{
	public static ForgeConfigSpec.BooleanValue right_click_harvest;
	
	public static ForgeConfigSpec.BooleanValue vanilla_seed_drops;
	
	
	
	
	public static void init(ForgeConfigSpec.Builder config)
	{
		right_click_harvest = config
				.comment("Indicates whether right-click harvesting on blocks should be enabled")
				.define("Enable right-click harvesting", true);

		vanilla_seed_drops = config
				.comment("Indicates whether vanilla seeds (beetroot, melon, & pumpkin) should drop from grass")
				.define("Drop vanilla seeds", true);

	}
	

}
