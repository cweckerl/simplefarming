package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FeatureConfig
{
	public static ForgeConfigSpec.BooleanValue mod_harvest;

	
	public static void init(ForgeConfigSpec.Builder config)
	{
		
		mod_harvest = config
				.comment("Indicates whether right-click harvesting on blocks should be enabled for Simple Farming crops (i.e. tomato crop)")
				.define("Enable right-click harvesting", true);
		

	}
	

}