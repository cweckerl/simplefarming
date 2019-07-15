package enemeez.simplefarming.init;

import java.util.LinkedHashMap;
import java.util.Map;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.items.CustomSeed;
import enemeez.simplefarming.items.FoodTier;
import enemeez.simplefarming.items.GrainItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.SoupItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems 
{ 
	//Fruit
	public static Item apricot;
	public static Item banana;
	public static Item blackberries;
	public static Item blueberries;
	public static Item cactus_fruit;
	public static Item cantaloupe;
	public static Item orange;
	public static Item pear;
	public static Item plum;
	public static Item raspberries;
	public static Item strawberries;
	
	//Harvested Food
	public static Item corn;
	public static Item cucumber;
	public static Item eggplant;
	public static Item habanero;
	public static Item lettuce;
	public static Item oat;
	public static Item onion;
	public static Item pepper;
	public static Item radish;
	public static Item rice;
	public static Item rye;
	public static Item soybean;
	public static Item spinach;
	public static Item squash;
	public static Item tomato;
	public static Item yam;
	
	//Cheese
	public static Item cheese_slice;

	//Non Edible
	public static Item kenaf_fiber;
	public static Item vinegar;
	
	//Seeds
	public static Item cantaloupe_seeds;
	public static Item carrot_seeds;
	public static Item corn_seeds;
	public static Item cucumber_seeds;
	public static Item eggplant_seeds;
	public static Item kenaf_seeds;
	public static Item lettuce_seeds;
	public static Item oat_seeds;
	public static Item onion_seeds;
	public static Item potato_seeds;
	public static Item pepper_seeds;
	public static Item radish_seeds;
	public static Item rice_seeds;
	public static Item rye_seeds;
	public static Item soybean_seeds;
	public static Item spinach_seeds;
	public static Item squash_seeds;
	public static Item tomato_seeds;
	public static Item yam_seeds;
	
	//Prepared Food
	public static Item baked_yam; 
	public static Item banana_bread;
	public static Item cheeseburger;
	public static Item chili;
	public static Item chocolate;
	public static Item cooked_bacon;
	public static Item cooked_chicken_wings; 
	public static Item cooked_egg; 
	public static Item cooked_sausage; 
	public static Item cornbread;
	public static Item corn_salad;
	public static Item cucumber_soup;
	public static Item egg_sandwich;
	public static Item eggplant_parmesan; 
	public static Item fish_fillet; 
	public static Item fish_sandwich;
	public static Item fruit_salad;
	public static Item hamburger;
	public static Item hotdog; 
	public static Item jaffa_cake;
	public static Item lasagna;
	public static Item mac_and_cheese;
	public static Item noodles;
	public static Item oatmeal;
	public static Item oat_bread;
	public static Item onion_soup;
	public static Item pancakes;
	public static Item pasta;
	public static Item pickle; 
	public static Item pickled_beetroot; 
	public static Item pizza;
	public static Item popcorn; 
	public static Item pulled_pork_sandwich;
	public static Item radish_soup;
	public static Item raw_bacon;
	public static Item raw_chicken_wings;
	public static Item raw_sausage;
	public static Item rice_bowl;
	public static Item rice_bread;
	public static Item rye_bread;
	public static Item salad;
	public static Item sandwich;
	public static Item spaghetti;
	public static Item spinach_mushroom_quiche;
	public static Item squash_casserole;
	public static Item sushi;
	public static Item tofu; 
	public static Item tomato_soup;
	public static Item vegetable_medley;
	public static Item veggie_burger;
	
	//Magic
	public static Item golden_habanero;
	
	//Pie
	public static Item apple_pie;
	public static Item apricot_pie;
	public static Item blackberry_pie;
	public static Item blueberry_pie;
	public static Item pear_pie;
	public static Item plum_pie;
	public static Item raspberry_pie;
	public static Item strawberry_pie;
	
	
	static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();

	public static void registerAll(RegistryEvent.Register<Item> event)
	{
		if (!event.getName().equals(ForgeRegistries.ITEMS.getRegistryName())) return;
		BLOCKS_TO_REGISTER.forEach(ModItems::register);
		
		apricot = register("apricot", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT)));
		banana = register("banana", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT)));
		blackberries = register("blackberries", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY)));
		blueberries = register("blueberries", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY)));
		cactus_fruit = register("cactus_fruit", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY)));
		cantaloupe = register("cantaloupe", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.GOURD_SLICE)));
		orange = register("orange", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT)));
		pear = register("pear", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT)));
		plum = register("plum", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT)));
		raspberries = register("raspberries", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY)));
		strawberries = register("strawberries", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY)));	
		
		corn = register("corn", new GrainItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CORN)));
		cucumber = register("cucumber", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CUCUMBER)));
		eggplant = register("eggplant", new Item( (new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.EGGPLANT)));
		habanero = register("habanero", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.PEPPER)));
		lettuce = register("lettuce", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SALAD_GREENS)));
		onion = register("onion", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.ONION)));
		pepper = register("pepper", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.PEPPER)));
		radish = register("radish", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.RADISH)));
		soybean = register("soybean", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SOYBEAN)));
		spinach = register("spinach", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SALAD_GREENS)));
		squash = register("squash", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.GOURD_SLICE)));
		tomato = register("tomato", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.TOMATO)));
		yam = register("yam", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.YAM)));
		
		kenaf_fiber = register("kenaf_fiber", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		vinegar = register("vinegar", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
				
		oat = register("oat", new GrainItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		rye = register("rye", new GrainItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		rice = register("rice", new GrainItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		noodles = register("noodles", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		
		cantaloupe_seeds = register("cantaloupe_seeds", new CustomSeed(ModBlocks.cantaloupe_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		carrot_seeds = register("carrot_seeds", new CustomSeed(ModBlocks.carrot_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		corn_seeds = register("corn_seeds", new CustomSeed(ModBlocks.corn_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		cucumber_seeds = register("cucumber_seeds", new CustomSeed(ModBlocks.cucumber_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		eggplant_seeds = register("eggplant_seeds", new CustomSeed(ModBlocks.eggplant_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		kenaf_seeds = register("kenaf_seeds", new CustomSeed(ModBlocks.kenaf_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		lettuce_seeds = register("lettuce_seeds", new CustomSeed(ModBlocks.lettuce_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		oat_seeds = register("oat_seeds", new CustomSeed(ModBlocks.oat_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		onion_seeds = register("onion_seeds", new CustomSeed(ModBlocks.onion_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		potato_seeds = register("potato_seeds", new CustomSeed(ModBlocks.potato_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		pepper_seeds = register("pepper_seeds", new CustomSeed(ModBlocks.pepper_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		radish_seeds = register("radish_seeds", new CustomSeed(ModBlocks.radish_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		rice_seeds = register("rice_seeds", new CustomSeed(ModBlocks.rice_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		rye_seeds = register("rye_seeds", new CustomSeed(ModBlocks.rye_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		soybean_seeds = register("soybean_seeds", new CustomSeed(ModBlocks.soybean_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		spinach_seeds = register("spinach_seeds", new CustomSeed(ModBlocks.spinach_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		squash_seeds = register("squash_seeds", new CustomSeed(ModBlocks.squash_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		tomato_seeds = register("tomato_seeds", new CustomSeed(ModBlocks.tomato_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
		yam_seeds = register("yam_seeds", new CustomSeed(ModBlocks.yam_crop, (new Item.Properties()).group(SimpleFarming.ITEM_GROUP)));
			
		
		baked_yam = register("baked_yam", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BAKED_YAM)));
		banana_bread = register("banana_bread", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BANANA_BREAD)));
		cheese_slice = register("cheese_slice", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CHEESE_SLICE)));
		cheeseburger = register("cheeseburger", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CHEESE_BURGER)));
		chili = register("chili", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CHILI)));
		chocolate = register("chocolate", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CHOCOLATE)));
		cooked_bacon = register("cooked_bacon", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.COOKED_BACON)));
		cooked_chicken_wings = register("cooked_chicken_wings", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.COOKED_CHICKEN_WINGS)));
		cooked_sausage = register("cooked_sausage", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.COOKED_SAUSAGE)));
		cooked_egg = register("cooked_egg", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.COOKED_EGG)));
		cornbread = register("cornbread", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CORN_BREAD)));
		corn_salad = register("corn_salad", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CORN_SALAD)));
		cucumber_soup = register("cucumber_soup", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.CUCUMBER_SOUP)));
		egg_sandwich = register("egg_sandwich", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.EGG_SANDWICH)));
		eggplant_parmesan = register("eggplant_parmesan", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.EGGPLANT_PARMESAN)));
		fish_fillet = register("fish_fillet", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FISH_FILLET)));
		fish_sandwich = register("fish_sandwich", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FISH_SANDWICH)));
		fruit_salad = register("fruit_salad", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT_SALAD)));
		golden_habanero = register("golden_habanero", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).rarity(Rarity.RARE).food(FoodTier.GOLDEN_HABANERO)));	
		hamburger = register("hamburger", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.HAMBURGER)));
		hotdog = register("hotdog", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.HOTDOG)));
		jaffa_cake = register("jaffa_cake", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.JAFFA_CAKE)));
		lasagna = register("lasagna", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.LASAGNA)));
		mac_and_cheese = register("mac_and_cheese", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.MAC_AND_CHEESE)));
		oatmeal = register("oatmeal", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.OATMEAL)));
		oat_bread = register("oat_bread", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(Foods.BREAD)));
		onion_soup = register("onion_soup", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.ONION_SOUP)));
		pancakes = register("pancakes", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.PANCAKES)));
		pasta = register("pasta", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.PASTA)));
		pickle = register("pickle", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.PICKLE)));
		pickled_beetroot = register("pickled_beetroot", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.PICKLED_BEETROOT)));
		pizza = register("pizza", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.PIZZA)));
		popcorn = register("popcorn", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.POPCORN)));
		pulled_pork_sandwich = register("pulled_pork_sandwich", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.PULLED_PORK_SANDWICH)));
		radish_soup = register("radish_soup", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.RADISH_SOUP)));
		raw_bacon = register("raw_bacon", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.RAW_BACON)));
		raw_chicken_wings = register("raw_chicken_wings", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.RAW_CHICKEN_WINGS)));
		raw_sausage = register("raw_sausage", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.RAW_SAUSAGE)));
		rice_bowl = register("rice_bowl", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.RICE_BOWL)));
		rice_bread = register("rice_bread", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(Foods.BREAD)));
		rye_bread = register("rye_bread", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(Foods.BREAD)));
		salad = register("salad", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SALAD)));
		sandwich = register("sandwich", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SANDWICH)));
		spaghetti = register("spaghetti", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SPAGHETTI)));
		spinach_mushroom_quiche = register("spinach_mushroom_quiche", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SPINACH_MUSHROOM_QUICHE)));
		squash_casserole = register("squash_casserole", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SQUASH_CASSEROLE)));
		sushi = register("sushi", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.SUSHI)));
		tofu = register("tofu", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.TOFU)));
		tomato_soup = register("tomato_soup", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.TOMATO_SOUP)));
		vegetable_medley = register("vegetable_medley", new SoupItem((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.VEGETABLE_MEDLEY))); 
		veggie_burger = register("veggie_burger", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.VEGGIE_BURGER)));
		apple_pie = register("apple_pie", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT_PIE)));
		apricot_pie = register("apricot_pie", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT_PIE)));
		blackberry_pie = register("blackberry_pie", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY_PIE)));
		blueberry_pie = register("blueberry_pie", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY_PIE)));
		pear_pie = register("pear_pie", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT_PIE)));
		plum_pie = register("plum_pie", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.FRUIT_PIE)));
		raspberry_pie = register("raspberry_pie", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY_PIE)));
		strawberry_pie = register("strawberry_pie", new Item((new Item.Properties()).group(SimpleFarming.ITEM_GROUP).food(FoodTier.BERRY_PIE)));	
	}
	
	private static <T extends Item> T register(String name, T item)
	{
		ResourceLocation id = SimpleFarming.getId(name);
		item.setRegistryName(id);
		ForgeRegistries.ITEMS.register(item);
		return item;
	}
	

}
