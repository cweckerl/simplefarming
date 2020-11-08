package enemeez.simplefarming.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SeedConfig {
	public static ForgeConfigSpec.BooleanValue cantaloupe;
	public static ForgeConfigSpec.BooleanValue carrot;
	public static ForgeConfigSpec.BooleanValue cassava;
	public static ForgeConfigSpec.BooleanValue corn;
	public static ForgeConfigSpec.BooleanValue cucumber;
	public static ForgeConfigSpec.BooleanValue eggplant;
	public static ForgeConfigSpec.BooleanValue honeydew;
	public static ForgeConfigSpec.BooleanValue kenaf;
	public static ForgeConfigSpec.BooleanValue lettuce;
	public static ForgeConfigSpec.BooleanValue oat;
	public static ForgeConfigSpec.BooleanValue onion;
	public static ForgeConfigSpec.BooleanValue potato;
	public static ForgeConfigSpec.BooleanValue pepper;
	public static ForgeConfigSpec.BooleanValue radish;
	public static ForgeConfigSpec.BooleanValue rice;
	public static ForgeConfigSpec.BooleanValue rye;
	public static ForgeConfigSpec.BooleanValue soybean;
	public static ForgeConfigSpec.BooleanValue spinach;
	public static ForgeConfigSpec.BooleanValue squash;
	public static ForgeConfigSpec.BooleanValue tomato;
	public static ForgeConfigSpec.BooleanValue yam;
	public static ForgeConfigSpec.BooleanValue ginger;
	public static ForgeConfigSpec.BooleanValue grape;
	public static ForgeConfigSpec.BooleanValue sorghum;
	public static ForgeConfigSpec.BooleanValue peanut;
	public static ForgeConfigSpec.BooleanValue barley;
	public static ForgeConfigSpec.BooleanValue pea;
	public static ForgeConfigSpec.BooleanValue cotton;
	public static ForgeConfigSpec.BooleanValue sweet_potato;
	public static ForgeConfigSpec.BooleanValue broccoli;
	public static ForgeConfigSpec.BooleanValue zucchini;
	public static ForgeConfigSpec.BooleanValue turnip;
	public static ForgeConfigSpec.BooleanValue pumpkin;
	public static ForgeConfigSpec.BooleanValue melon;
	public static ForgeConfigSpec.BooleanValue beetroot;

	public static void init(ForgeConfigSpec.Builder config) {

		cantaloupe = config.define("cantaloupe", true);
		carrot = config.define("carrot", true);
		cassava = config.define("cassava", true);
		corn = config.define("corn", true);
		cucumber = config.define("cucumber", true);
		eggplant = config.define("eggplant", true);
		honeydew = config.define("honeydew", true);
		kenaf = config.define("kenaf", true);
		lettuce = config.define("lettuce", true);
		oat = config.define("oat", true);
		onion = config.define("onion", true);
		potato = config.define("potato", true);
		pepper = config.define("pepper", true);
		radish = config.define("radish", true);
		rice = config.define("rice", true);
		rye = config.define("rye", true);
		soybean = config.define("soybean", true);
		spinach = config.define("spinach", true);
		squash = config.define("squash", true);
		tomato = config.define("tomato", true);
		yam = config.define("yam", true);
		ginger = config.define("ginger", true);
		grape = config.define("grape", true);
		sorghum = config.define("sorghum", true);
		peanut = config.define("peanut", true);
		barley = config.define("barley", true);
		pea = config.define("pea", true);
		cotton = config.define("cotton", true);
		sweet_potato = config.define("sweet_potato", true);
		broccoli = config.define("broccoli", true);
		zucchini = config.define("zucchini", true);
		turnip = config.define("turnip", true);
		pumpkin = config.define("pumpkin", true);
		melon = config.define("melon", true);
		beetroot = config.define("beetroot", true);
	}

}
