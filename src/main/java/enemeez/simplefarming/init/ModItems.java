package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.events.SimpleSoundEvents;
import enemeez.simplefarming.integration.FoodTier;
import enemeez.simplefarming.item.BottleItem;
import enemeez.simplefarming.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

// TODO: Use a deferred registry.
public class ModItems {
	// Fruit
	public static Item apricot;
	public static Item banana;
	public static Item blackberries;
	public static Item blueberries;
	public static Item cactus_fruit;
	public static Item cantaloupe;
	public static Item cherries;
	public static Item grapes;
	public static Item honeydew;
	public static Item mango;
	public static Item olives;
	public static Item orange;
	public static Item pear;
	public static Item plum;
	public static Item raspberries;
	public static Item strawberries;

	// Crops
	public static Item barley;
	public static Item broccoli;
	public static Item cassava;
	public static Item corn;
	public static Item cotton;
	public static Item cucumber;
	public static Item eggplant;
	public static Item habanero;
	public static Item ginger;
	public static Item lettuce;
	public static Item oat;
	public static Item onion;
	public static Item pea_pod;
	public static Item peanut;
	public static Item pepper;
	public static Item radish;
	public static Item rice;
	public static Item rye;
	public static Item sorghum;
	public static Item soybean;
	public static Item spinach;
	public static Item squash;
	public static Item sweet_potato;
	public static Item tomato;
	public static Item turnip;
	public static Item yam;
	public static Item zucchini;

	// Cheese
	public static Item cheese_slice;

	// Non Edible
	public static Item curry_powder;
	public static Item jam;
	public static Item sprinkles;
	public static Item kenaf_fiber;
	public static Item olive_oil;
	public static Item vinegar;

	// Plant Seeds
	public static Item chicory_root;
	public static Item cumin_seeds;
	public static Item marshmallow_root;
	public static Item quinoa_seeds;
	public static Item sunflower_seeds;

	// Seeds
	public static Item barley_seeds;
	public static Item broccoli_seeds;
	public static Item cantaloupe_seeds;
	public static Item carrot_seeds;
	public static Item cassava_seeds;
	public static Item corn_seeds;
	public static Item cotton_seeds;
	public static Item cucumber_seeds;
	public static Item eggplant_seeds;
	public static Item honeydew_seeds;
	public static Item ginger_seeds;
	public static Item grape_seeds;
	public static Item kenaf_seeds;
	public static Item lettuce_seeds;
	public static Item oat_seeds;
	public static Item onion_seeds;
	public static Item pea_seeds;
	public static Item peanut_seeds;
	public static Item pepper_seeds;
	public static Item potato_seeds;
	public static Item radish_seeds;
	public static Item rice_seeds;
	public static Item rye_seeds;
	public static Item sorghum_seeds;
	public static Item soybean_seeds;
	public static Item spinach_seeds;
	public static Item squash_seeds;
	public static Item sweet_potato_seeds;
	public static Item tomato_seeds;
	public static Item turnip_seeds;
	public static Item yam_seeds;
	public static Item zucchini_seeds;

	// Prepared Food
	public static Item baked_sweet_potato;
	public static Item baked_yam;
	public static Item banana_bread;
	public static Item barley_bread;
	public static Item beef_and_broccoli;
	public static Item blt;
	public static Item borscht;
	public static Item broccoli_cheese_soup;
	public static Item caesar_salad;
	public static Item candy;
	public static Item candy_cane;
	public static Item carrot_soup;
	public static Item cassava_cake;
	public static Item cheeseburger;
	public static Item chicken_noodle_soup;
	public static Item chicken_parmesan;
	public static Item chicory_gratin;
	public static Item chili;
	public static Item chocolate;
	public static Item cooked_bacon;
	public static Item cooked_chicken_wings;
	public static Item cooked_egg;
	public static Item cooked_horse_meat;
	public static Item cooked_sausage;
	public static Item cornbread;
	public static Item corn_salad;
	public static Item cucumber_soup;
	public static Item egg_sandwich;
	public static Item eggplant_parmesan;
	public static Item fish_and_chips;
	public static Item fish_fillet;
	public static Item fish_sandwich;
	public static Item fried_calamari;
	public static Item fried_rice;
	public static Item fruit_salad;
	public static Item hamburger;
	public static Item hotdog;
	public static Item ice_cream_sundae;
	public static Item italian_beef;
	public static Item jaffa_cake;
	public static Item lasagna;
	public static Item mac_and_cheese;
	public static Item marshmallow;
	public static Item mushroom_barley;
	public static Item noodles;
	public static Item oatmeal;
	public static Item oat_bread;
	public static Item olive_tomato_salad;
	public static Item onion_soup;
	public static Item pad_thai;
	public static Item pancakes;
	public static Item pasta;
	public static Item pbj;
	public static Item pea_soup;
	public static Item peanut_butter_cookie;
	public static Item pickle;
	public static Item pickled_beetroot;
	public static Item pizza;
	public static Item popcorn;
	public static Item potato_knish;
	public static Item pulled_pork_sandwich;
	public static Item pumpkin_soup;
	public static Item quinoa_salad;
	public static Item radish_soup;
	public static Item raisins;
	public static Item raw_bacon;
	public static Item raw_calamari;
	public static Item raw_chicken_wings;
	public static Item raw_horse_meat;
	public static Item raw_sausage;
	public static Item rice_bowl;
	public static Item rice_bread;
	public static Item rye_bread;
	public static Item salad;
	public static Item sandwich;
	public static Item sausage_barley_soup;
	public static Item sorghum_bread;
	public static Item spaghetti;
	public static Item spinach_mushroom_quiche;
	public static Item spinach_quinoa_quiche;
	public static Item sorghum_porridge;
	public static Item squash_casserole;
	public static Item squash_soup;
	public static Item squid_ink_pasta;
	public static Item stuffed_corn_zucchini;
	public static Item sweet_potato_quinoa_cakes;
	public static Item sushi;
	public static Item tofu;
	public static Item tofu_scramble;
	public static Item tomato_soup;
	public static Item trail_mix;
	public static Item turnip_beetroot_gratin;
	public static Item vegetable_medley;
	public static Item veggie_burger;
	public static Item zucchini_bread;

	// Magic
	public static Item golden_habanero;

	// Pie
	public static Item apple_pie;
	public static Item apricot_pie;
	public static Item blackberry_pie;
	public static Item blueberry_pie;
	public static Item cherry_pie;
	public static Item peanut_butter_pie;
	public static Item pear_pie;
	public static Item plum_pie;
	public static Item raspberry_pie;
	public static Item strawberry_pie;

	// Curry Dishes
	public static Item beef_curry;
	public static Item chicken_curry;
	public static Item pork_curry;
	public static Item mutton_curry;
	public static Item vegetable_curry;

	// Alcohol
	public static Item beer;
	public static Item cauim;
	public static Item cider;
	public static Item mead;
	public static Item sake;
	public static Item tiswin;
	public static Item vodka;
	public static Item whiskey;
	public static Item wine;

	// Tools
	public static Item wooden_scythe;
	public static Item stone_scythe;
	public static Item iron_scythe;
	public static Item golden_scythe;
	public static Item diamond_scythe;

	// BlockItems
	public static Item cantaloupe_block;
	public static Item honeydew_block;
	public static Item squash_block;

	public static Item apple_sapling;
	public static Item apricot_sapling;
	public static Item banana_sapling;
	public static Item cherry_sapling;
	public static Item mango_sapling;
	public static Item olive_sapling;
	public static Item orange_sapling;
	public static Item pear_sapling;
	public static Item plum_sapling;

	public static Item blackberry_bush;
	public static Item blueberry_bush;
	public static Item raspberry_bush;
	public static Item strawberry_bush;

	public static Item birthday_cake;
	public static Item chocolate_cake;
	public static Item cheese_block;

	public static Item barley_hay_block;
	public static Item oat_hay_block;
	public static Item rice_hay_block;
	public static Item rye_hay_block;

	public static Item cactus_crop;

	public static Item fruit_log;
	public static Item scarecrow;
	public static Item brewing_barrel;
	
	// Special
	public static Item music_disc_nourish;

	public static void registerAll(RegistryEvent.Register<Item> event) {
		if (!event.getName().equals(ForgeRegistries.ITEMS.getRegistryName()))
			return;

		cantaloupe_block = register("cantaloupe_block", new BlockItem(ModBlocks.CANTALOUPE_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		honeydew_block = register("honeydew_block", new BlockItem(ModBlocks.HONEYDEW_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		squash_block = register("squash_block", new BlockItem(ModBlocks.SQUASH_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

		blackberry_bush = register("blackberry_bush", new BlockItem(ModBlocks.BLACKBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		blueberry_bush = register("blueberry_bush", new BlockItem(ModBlocks.BLUEBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		raspberry_bush = register("raspberry_bush", new BlockItem(ModBlocks.RASPBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		strawberry_bush = register("strawberry_bush", new BlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

		cactus_crop = register("cactus_crop", new BlockItem(ModBlocks.CACTUS_CROP.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

		scarecrow = register("scarecrow", new BlockItem(ModBlocks.SCARECROW.get(), new Item.Properties().stacksTo(16).tab(SimpleFarming.CREATIVE_TAB)));

		barley_hay_block = register("barley_hay_block", new BlockItem(ModBlocks.BARLEY_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		oat_hay_block = register("oat_hay_block", new BlockItem(ModBlocks.OAT_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		rice_hay_block = register("rice_hay_block", new BlockItem(ModBlocks.RICE_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		rye_hay_block = register("rye_hay_block", new BlockItem(ModBlocks.RYE_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

		fruit_log = register("fruit_log", new BlockItem(ModBlocks.FRUIT_LOG.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		brewing_barrel = register("brewing_barrel", new BlockItem(ModBlocks.BREWING_BARREL.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

		apple_sapling = register("apple_sapling", new BlockItem(ModBlocks.APPLE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		apricot_sapling = register("apricot_sapling", new BlockItem(ModBlocks.APRICOT_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		banana_sapling = register("banana_sapling", new BlockItem(ModBlocks.BANANA_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		cherry_sapling = register("cherry_sapling", new BlockItem(ModBlocks.CHERRY_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		mango_sapling = register("mango_sapling", new BlockItem(ModBlocks.MANGO_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		olive_sapling = register("olive_sapling", new BlockItem(ModBlocks.OLIVE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		orange_sapling = register("orange_sapling", new BlockItem(ModBlocks.ORANGE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		pear_sapling = register("pear_sapling", new BlockItem(ModBlocks.PEAR_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
		plum_sapling = register("plum_sapling", new BlockItem(ModBlocks.PLUM_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

		birthday_cake = register("birthday_cake", new BlockItem(ModBlocks.BIRTHDAY_CAKE.get(), new Item.Properties().stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
		chocolate_cake = register("chocolate_cake", new BlockItem(ModBlocks.CHOCOLATE_CAKE.get(), new Item.Properties().stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
		cheese_block = register("cheese_block", new BlockItem(ModBlocks.CHEESE_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

		music_disc_nourish = register("music_disc_nourish", new SimpleMusicDiscItem(1, SimpleSoundEvents.nourish, (new Item.Properties()).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB).rarity(Rarity.RARE)));

		apricot = register("apricot", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
		banana = register("banana", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
		blackberries = register("blackberries", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
		blueberries = register("blueberries", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
		cactus_fruit = register("cactus_fruit", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
		cantaloupe = register("cantaloupe", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
		cherries = register("cherries", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
		grapes = register("grapes", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
		honeydew = register("honeydew", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
		mango = register("mango", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
		olives = register("olives", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.OLIVES)));
		orange = register("orange", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
		pear = register("pear", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
		plum = register("plum", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
		raspberries = register("raspberries", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
		strawberries = register("strawberries", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));

		broccoli = register("broccoli", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BROCCOLI)));
		cassava = register("cassava", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CASSAVA)));
		corn = register("corn", new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CORN)));
		cucumber = register("cucumber", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CUCUMBER)));
		eggplant = register("eggplant", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGGPLANT)));
		habanero = register("habanero", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEPPER)));
		ginger = register("ginger", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GINGER)));
		lettuce = register("lettuce", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SALAD_GREENS)));
		onion = register("onion", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ONION)));
		pea_pod = register("pea_pod", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEA_POD)));
		peanut = register("peanut", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT)));
		pepper = register("pepper", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEPPER)));
		radish = register("radish", new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RADISH)));
		sorghum = register("sorghum", new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SORGHUM)));
		soybean = register("soybean", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SOYBEAN)));
		spinach = register("spinach", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SALAD_GREENS)));
		squash = register("squash", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
		sweet_potato = register("sweet_potato", new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SWEET_POTATO)));
		tomato = register("tomato", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOMATO)));
		turnip = register("turnip", new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TURNIP)));
		yam = register("yam", new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.POTATO)));
		zucchini = register("zucchini", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ZUCCHINI)));

		cotton = register("cotton", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		kenaf_fiber = register("kenaf_fiber", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		barley = register("barley", new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		oat = register("oat", new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		rye = register("rye", new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		rice = register("rice", new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));

		curry_powder = register("curry_powder", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		jam = register("jam", new Item((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
		sprinkles = register("sprinkles", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		olive_oil = register("olive_oil", new BottleItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
		vinegar = register("vinegar", new DrinkItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));

		noodles = register("noodles", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));

		beer = register("beer", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "beer"));
		cauim = register("cauim", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "cauim"));
		cider = register("cider", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "cider"));
		mead = register("mead", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "mead"));
		sake = register("sake", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "sake"));
		tiswin = register("tiswin", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "tiswin"));
		vodka = register("vodka", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "vodka"));
		whiskey = register("whiskey", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "whiskey"));
		wine = register("wine", new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "wine"));

		chicory_root = register("chicory_root", new ItemNameBlockItem(ModBlocks.CHICORY.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
		cumin_seeds = register("cumin_seeds", new SeedItem(ModBlocks.CUMIN.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
		marshmallow_root = register("marshmallow_root", new ItemNameBlockItem(ModBlocks.MARSHMALLOW.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
		quinoa_seeds = register("quinoa_seeds", new SeedItem(ModBlocks.QUINOA.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
		sunflower_seeds = register("sunflower_seeds", new SeedItem(ModBlocks.SUNFLOWER.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));

		barley_seeds = register("barley_seeds", new SeedItem(ModBlocks.BARLEY_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		broccoli_seeds = register("broccoli_seeds", new SeedItem(ModBlocks.BROCCOLI_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		cantaloupe_seeds = register("cantaloupe_seeds", new SeedItem(ModBlocks.CANTALOUPE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		carrot_seeds = register("carrot_seeds", new SeedItem(ModBlocks.CARROT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		cassava_seeds = register("cassava_seeds", new SeedItem(ModBlocks.CASSAVA_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		corn_seeds = register("corn_seeds", new SeedItem(ModBlocks.CORN_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		cotton_seeds = register("cotton_seeds", new SeedItem(ModBlocks.COTTON_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		cucumber_seeds = register("cucumber_seeds", new SeedItem(ModBlocks.CUCUMBER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		eggplant_seeds = register("eggplant_seeds", new SeedItem(ModBlocks.EGGPLANT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		honeydew_seeds = register("honeydew_seeds", new SeedItem(ModBlocks.HONEYDEW_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		ginger_seeds = register("ginger_seeds", new SeedItem(ModBlocks.GINGER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		grape_seeds = register("grape_seeds", new SeedItem(ModBlocks.GRAPE_PLANT.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		kenaf_seeds = register("kenaf_seeds", new SeedItem(ModBlocks.KENAF_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		lettuce_seeds = register("lettuce_seeds", new SeedItem(ModBlocks.LETTUCE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		oat_seeds = register("oat_seeds", new SeedItem(ModBlocks.OAT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		onion_seeds = register("onion_seeds", new SeedItem(ModBlocks.ONION_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		pea_seeds = register("pea_seeds", new SeedItem(ModBlocks.PEA_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		peanut_seeds = register("peanut_seeds", new SeedItem(ModBlocks.PEANUT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		pepper_seeds = register("pepper_seeds", new SeedItem(ModBlocks.PEPPER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		potato_seeds = register("potato_seeds", new SeedItem(ModBlocks.POTATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		radish_seeds = register("radish_seeds", new SeedItem(ModBlocks.RADISH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		rice_seeds = register("rice_seeds", new SeedItem(ModBlocks.RICE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		rye_seeds = register("rye_seeds", new SeedItem(ModBlocks.RYE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		sorghum_seeds = register("sorghum_seeds", new SeedItem(ModBlocks.SORGHUM_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		soybean_seeds = register("soybean_seeds", new SeedItem(ModBlocks.SOYBEAN_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		spinach_seeds = register("spinach_seeds", new SeedItem(ModBlocks.SPINACH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		squash_seeds = register("squash_seeds", new SeedItem(ModBlocks.SQUASH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		sweet_potato_seeds = register("sweet_potato_seeds", new SeedItem(ModBlocks.SWEET_POTATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		tomato_seeds = register("tomato_seeds", new SeedItem(ModBlocks.TOMATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		turnip_seeds = register("turnip_seeds", new SeedItem(ModBlocks.TURNIP_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		yam_seeds = register("yam_seeds", new SeedItem(ModBlocks.YAM_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
		zucchini_seeds = register("zucchini_seeds", new SeedItem(ModBlocks.ZUCCHINI_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));

		apple_pie = register("apple_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
		apricot_pie = register("apricot_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
		baked_sweet_potato = register("baked_sweet_potato", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BAKED_SWEET_POTATO)));
		baked_yam = register("baked_yam", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BAKED_POTATO)));
		banana_bread = register("banana_bread", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BANANA_BREAD)));
		barley_bread = register("barley_bread", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
		beef_and_broccoli = register("beef_and_broccoli", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BEEF_AND_BROCCOLI)));
		beef_curry = register("beef_curry", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BEEF_CURRY)));
		blackberry_pie = register("blackberry_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
		blt = register("blt", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BLT)));
		borscht = register("borscht", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.BORSCHT)));
		blueberry_pie = register("blueberry_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
		broccoli_cheese_soup = register("broccoli_cheese_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.BROCCOLI_CHEESE_SOUP)));
		caesar_salad = register("caesar_salad", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CAESAR_SALAD)));
		candy = register("candy", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CANDY)));
		candy_cane = register("candy_cane", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CANDY_CANE)));
		carrot_soup = register("carrot_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CARROT_SOUP)));
		cassava_cake = register("cassava_cake", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CASSAVA_CAKE)));
		cheese_slice = register("cheese_slice", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHEESE_SLICE)));
		cheeseburger = register("cheeseburger", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHEESE_BURGER)));
		cherry_pie = register("cherry_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
		chicken_curry = register("chicken_curry", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICKEN_CURRY)));
		chicken_noodle_soup = register("chicken_noodle_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CHICKEN_NOODLE_SOUP)));
		chicken_parmesan = register("chicken_parmesan", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICKEN_PARMESAN)));
		chicory_gratin = register("chicory_gratin", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICORY_GRATIN)));
		chili = register("chili", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CHILI)));
		chocolate = register("chocolate", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHOCOLATE)));
		cooked_bacon = register("cooked_bacon", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_BACON)));
		cooked_chicken_wings = register("cooked_chicken_wings", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_CHICKEN_WINGS)));
		cooked_egg = register("cooked_egg", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_EGG)));
		cooked_horse_meat = register("cooked_horse_meat", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.COOKED_BEEF)));
		cooked_sausage = register("cooked_sausage", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_SAUSAGE)));
		cornbread = register("cornbread", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CORN_BREAD)));
		corn_salad = register("corn_salad", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CORN_SALAD)));
		cucumber_soup = register("cucumber_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CUCUMBER_SOUP)));
		egg_sandwich = register("egg_sandwich", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGG_SANDWICH)));
		eggplant_parmesan = register("eggplant_parmesan", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGGPLANT_PARMESAN)));
		fish_and_chips = register("fish_and_chips", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_AND_CHIPS)));
		fish_fillet = register("fish_fillet", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_FILLET)));
		fish_sandwich = register("fish_sandwich", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_SANDWICH)));
		fried_calamari = register("fried_calamari", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRIED_CALAMARI)));
		fried_rice = register("fried_rice", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRIED_RICE)));
		fruit_salad = register("fruit_salad", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.FRUIT_SALAD)));
		golden_habanero = register("golden_habanero", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).rarity(Rarity.RARE).food(FoodTier.GOLDEN_HABANERO)));
		hamburger = register("hamburger", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.HAMBURGER)));
		hotdog = register("hotdog", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.HOTDOG)));
		ice_cream_sundae = register("ice_cream_sundae", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ICE_CREAM_SUNDAE)));
		italian_beef = register("italian_beef", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ITALIAN_BEEF)));
		jaffa_cake = register("jaffa_cake", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.JAFFA_CAKE)));
		lasagna = register("lasagna", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.LASAGNA)));
		mac_and_cheese = register("mac_and_cheese", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MAC_AND_CHEESE)));
		marshmallow = register("marshmallow", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MARSHMALLOW)));
		mushroom_barley = register("mushroom_barley", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MUSHROOM_BARLEY)));
		mutton_curry = register("mutton_curry", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MUTTON_CURRY)));
		oatmeal = register("oatmeal", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.OATMEAL)));
		oat_bread = register("oat_bread", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
		olive_tomato_salad = register("olive_tomato_salad", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.OLIVE_TOMATO_SALAD)));
		onion_soup = register("onion_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.ONION_SOUP)));
		pad_thai = register("pad_thai", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PASTA)));
		pancakes = register("pancakes", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PANCAKES)));
		pasta = register("pasta", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PASTA)));
		pbj = register("pbj", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PBJ)));
		pea_soup = register("pea_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.PEA_SOUP)));
		peanut_butter_cookie = register("peanut_butter_cookie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT_BUTTER_COOKIE)));
		peanut_butter_pie = register("peanut_butter_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT_BUTTER_PIE)));
		pear_pie = register("pear_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
		pickle = register("pickle", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PICKLE)));
		pickled_beetroot = register("pickled_beetroot", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PICKLED_BEETROOT)));
		pizza = register("pizza", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PIZZA)));
		plum_pie = register("plum_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
		popcorn = register("popcorn", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.POPCORN)));
		pork_curry = register("pork_curry", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PORK_CURRY)));
		potato_knish = register("potato_knish", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.POTATO_KNISH)));
		pulled_pork_sandwich = register("pulled_pork_sandwich", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PULLED_PORK_SANDWICH)));
		pumpkin_soup = register("pumpkin_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.PUMPKIN_SOUP)));
		quinoa_salad = register("quinoa_salad", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.QUINOA_SALAD)));
		radish_soup = register("radish_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.RADISH_SOUP)));
		raisins = register("raisins", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAISINS)));
		raspberry_pie = register("raspberry_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
		raw_bacon = register("raw_bacon", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_BACON)));
		raw_chicken_wings = register("raw_chicken_wings", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_CHICKEN_WINGS)));
		raw_calamari = register("raw_calamari", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_CALAMARI)));
		raw_horse_meat = register("raw_horse_meat", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BEEF)));
		raw_sausage = register("raw_sausage", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_SAUSAGE)));
		rice_bowl = register("rice_bowl", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.RICE_BOWL)));
		rice_bread = register("rice_bread", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
		rye_bread = register("rye_bread", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
		salad = register("salad", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SALAD)));
		sandwich = register("sandwich", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SANDWICH)));
		sausage_barley_soup = register("sausage_barley_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SAUSAGE_BARLEY)));
		sorghum_bread = register("sorghum_bread", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SORGHUM_BREAD)));
		sorghum_porridge = register("sorghum_porridge", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SORGHUM_PORRIDGE)));
		spaghetti = register("spaghetti", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPAGHETTI)));
		spinach_mushroom_quiche = register("spinach_mushroom_quiche", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPINACH_MUSHROOM_QUICHE)));
		spinach_quinoa_quiche = register("spinach_quinoa_quiche", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPINACH_QUINOA_QUICHE)));
		squash_casserole = register("squash_casserole", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SQUASH_CASSEROLE)));
		squash_soup = register("squash_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SQUASH_SOUP)));
		squid_ink_pasta = register("squid_ink_pasta", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SQUID_INK_PASTA)));
		strawberry_pie = register("strawberry_pie", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
		stuffed_corn_zucchini = register("stuffed_corn_zucchini", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.STUFFED_CORN_ZUCCHINI)));
		sushi = register("sushi", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SUSHI)));
		sweet_potato_quinoa_cakes = register("sweet_potato_quinoa_cakes", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SWEET_POTATO_QUINOA_CAKES)));
		tofu = register("tofu", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOFU)));
		tofu_scramble = register("tofu_scramble", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOFU_SCRAMBLE)));
		trail_mix = register("trail_mix", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TRAIL_MIX)));
		tomato_soup = register("tomato_soup", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.TOMATO_SOUP)));
		turnip_beetroot_gratin = register("turnip_beetroot_gratin", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TURNIP_BEETROOT_GRATIN)));
		vegetable_curry = register("vegetable_curry", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.VEGETABLE_CURRY)));
		vegetable_medley = register("vegetable_medley", new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.VEGETABLE_MEDLEY)));
		veggie_burger = register("veggie_burger", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.VEGGIE_BURGER)));
		zucchini_bread = register("zucchini_bread", new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ZUCCHINI_BREAD)));
	}

	private static <T extends Item> T register(String name, T item) {
		ResourceLocation id = SimpleFarming.getId(name);
		item.setRegistryName(id);
		ForgeRegistries.ITEMS.register(item);
		return item;
	}

}
