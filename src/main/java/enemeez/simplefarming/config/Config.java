package enemeez.simplefarming.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import enemeez.simplefarming.SimpleFarming;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config 
{
	public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec config;
	
	static
	{
		GenConfig.init(builder);
		config = builder.build();
	}

	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		SimpleFarming.LOGGER.info("Config: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		SimpleFarming.LOGGER.info("Config built: " + path);
		file.load();
		SimpleFarming.LOGGER.info("Loaded Config: " + path);
		config.setConfig(file);
	}
}
