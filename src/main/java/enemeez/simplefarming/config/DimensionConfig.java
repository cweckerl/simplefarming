package enemeez.simplefarming.config;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraftforge.common.ForgeConfigSpec;

public class DimensionConfig {
	public static ForgeConfigSpec.ConfigValue<List<? extends Integer>> whitelist;
	public static ForgeConfigSpec.ConfigValue<List<? extends Integer>> blacklist;

	public static void init(ForgeConfigSpec.Builder config) {

		whitelist = config.comment("Enter a dimension id to whitelist feature generation").defineList("white_dim",
				Arrays.asList(0), new Predicate<Object>() {
					@Override
					public boolean apply(@Nullable Object val) {
						return val instanceof Integer && val != null;
					}
				});

		blacklist = config.comment("Enter a dimension id to blacklist feature generation").defineList("black_dim",
				Arrays.asList(-1, 1), new Predicate<Object>() {
					@Override
					public boolean apply(@Nullable Object val) {
						return val instanceof Integer && val != null;
					}
				});

	}

}