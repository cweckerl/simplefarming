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
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimpleFarming.MOD_ID);

	// @formatter:off

	// BlockItems
	public static RegistryObject<Item> cantaloupe_block = register("cantaloupe_block", () -> new BlockItem(ModBlocks.CANTALOUPE_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> honeydew_block = register("honeydew_block", () -> new BlockItem(ModBlocks.HONEYDEW_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> squash_block = register("squash_block", () -> new BlockItem(ModBlocks.SQUASH_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static RegistryObject<Item> blackberry_bush = register("blackberry_bush", () -> new BlockItem(ModBlocks.BLACKBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> blueberry_bush = register("blueberry_bush", () -> new BlockItem(ModBlocks.BLUEBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> raspberry_bush = register("raspberry_bush", () -> new BlockItem(ModBlocks.RASPBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> strawberry_bush = register("strawberry_bush", () -> new BlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static RegistryObject<Item> cactus_crop = register("cactus_crop", () -> new BlockItem(ModBlocks.CACTUS_CROP.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static RegistryObject<Item> scarecrow = register("scarecrow", () -> new BlockItem(ModBlocks.SCARECROW.get(), new Item.Properties().stacksTo(16).tab(SimpleFarming.CREATIVE_TAB)));

	public static RegistryObject<Item> birthday_cake = register("birthday_cake", () -> new BlockItem(ModBlocks.BIRTHDAY_CAKE.get(), new Item.Properties().stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> chocolate_cake = register("chocolate_cake", () -> new BlockItem(ModBlocks.CHOCOLATE_CAKE.get(), new Item.Properties().stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> cheese_block = register("cheese_block", () -> new BlockItem(ModBlocks.CHEESE_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static RegistryObject<Item> barley_hay_block = register("barley_hay_block", () -> new BlockItem(ModBlocks.BARLEY_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> oat_hay_block = register("oat_hay_block", () -> new BlockItem(ModBlocks.OAT_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> rice_hay_block = register("rice_hay_block", () -> new BlockItem(ModBlocks.RICE_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> rye_hay_block = register("rye_hay_block", () -> new BlockItem(ModBlocks.RYE_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static RegistryObject<Item> fruit_log = register("fruit_log", () -> new BlockItem(ModBlocks.FRUIT_LOG.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static RegistryObject<Item> brewing_barrel = register("brewing_barrel", () -> new BlockItem(ModBlocks.BREWING_BARREL.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static RegistryObject<Item> apple_sapling = register("apple_sapling", () -> new BlockItem(ModBlocks.APPLE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> apricot_sapling = register("apricot_sapling", () -> new BlockItem(ModBlocks.APRICOT_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> banana_sapling = register("banana_sapling", () -> new BlockItem(ModBlocks.BANANA_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> cherry_sapling = register("cherry_sapling", () -> new BlockItem(ModBlocks.CHERRY_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> mango_sapling = register("mango_sapling", () -> new BlockItem(ModBlocks.MANGO_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> olive_sapling = register("olive_sapling", () -> new BlockItem(ModBlocks.OLIVE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> orange_sapling = register("orange_sapling", () -> new BlockItem(ModBlocks.ORANGE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> pear_sapling = register("pear_sapling", () -> new BlockItem(ModBlocks.PEAR_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> plum_sapling = register("plum_sapling", () -> new BlockItem(ModBlocks.PLUM_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	// Fruit
	public static RegistryObject<Item> apricot = register("apricot", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static RegistryObject<Item> banana = register("banana", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static RegistryObject<Item> blackberries = register("blackberries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
	public static RegistryObject<Item> blueberries = register("blueberries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
	public static RegistryObject<Item> cactus_fruit = register("cactus_fruit", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
	public static RegistryObject<Item> cantaloupe = register("cantaloupe", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
	public static RegistryObject<Item> cherries = register("cherries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static RegistryObject<Item> grapes = register("grapes", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static RegistryObject<Item> honeydew = register("honeydew", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
	public static RegistryObject<Item> mango = register("mango", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static RegistryObject<Item> olives = register("olives", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.OLIVES)));
	public static RegistryObject<Item> orange = register("orange", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static RegistryObject<Item> pear = register("pear", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static RegistryObject<Item> plum = register("plum", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static RegistryObject<Item> raspberries = register("raspberries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
	public static RegistryObject<Item> strawberries = register("strawberries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));

	// Crops
	public static RegistryObject<Item> barley = register("barley", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> broccoli = register("broccoli", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BROCCOLI)));
	public static RegistryObject<Item> cassava = register("cassava", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CASSAVA)));
	public static RegistryObject<Item> corn = register("corn", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CORN)));
	public static RegistryObject<Item> cotton = register("cotton", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> cucumber = register("cucumber", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CUCUMBER)));
	public static RegistryObject<Item> eggplant = register("eggplant", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGGPLANT)));
	public static RegistryObject<Item> habanero = register("habanero", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEPPER)));
	public static RegistryObject<Item> ginger = register("ginger", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GINGER)));
	public static RegistryObject<Item> lettuce = register("lettuce", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SALAD_GREENS)));
	public static RegistryObject<Item> oat = register("oat", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> onion = register("onion", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ONION)));
	public static RegistryObject<Item> pea_pod = register("pea_pod", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEA_POD)));
	public static RegistryObject<Item> peanut = register("peanut", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT)));
	public static RegistryObject<Item> pepper = register("pepper", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEPPER)));
	public static RegistryObject<Item> radish = register("radish", () -> new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RADISH)));
	public static RegistryObject<Item> rice = register("rice", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> rye = register("rye", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> sorghum = register("sorghum", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SORGHUM)));
	public static RegistryObject<Item> soybean = register("soybean", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SOYBEAN)));
	public static RegistryObject<Item> spinach = register("spinach", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SALAD_GREENS)));
	public static RegistryObject<Item> squash = register("squash", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
	public static RegistryObject<Item> sweet_potato = register("sweet_potato", () -> new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SWEET_POTATO)));
	public static RegistryObject<Item> tomato = register("tomato", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOMATO)));
	public static RegistryObject<Item> turnip = register("turnip", () -> new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TURNIP)));
	public static RegistryObject<Item> yam = register("yam", () -> new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.POTATO)));
	public static RegistryObject<Item> zucchini = register("zucchini", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ZUCCHINI)));

	// Cheese
	public static RegistryObject<Item> cheese_slice = register("cheese_slice", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHEESE_SLICE)));

	// Non Edible
	public static RegistryObject<Item> curry_powder = register("curry_powder", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> jam = register("jam", () -> new Item((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> sprinkles = register("sprinkles", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> kenaf_fiber = register("kenaf_fiber", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> olive_oil = register("olive_oil", () -> new BottleItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> vinegar = register("vinegar", () -> new DrinkItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));

	// Plant Seeds
	public static RegistryObject<Item> chicory_root = register("chicory_root", () -> new ItemNameBlockItem(ModBlocks.CHICORY.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
	public static RegistryObject<Item> cumin_seeds = register("cumin_seeds", () -> new SeedItem(ModBlocks.CUMIN.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
	public static RegistryObject<Item> marshmallow_root = register("marshmallow_root", () -> new ItemNameBlockItem(ModBlocks.MARSHMALLOW.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
	public static RegistryObject<Item> quinoa_seeds = register("quinoa_seeds", () -> new SeedItem(ModBlocks.QUINOA.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
	public static RegistryObject<Item> sunflower_seeds = register("sunflower_seeds", () -> new SeedItem(ModBlocks.SUNFLOWER.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));

	// Seeds
	public static RegistryObject<Item> barley_seeds = register("barley_seeds", () -> new SeedItem(ModBlocks.BARLEY_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> broccoli_seeds = register("broccoli_seeds", () -> new SeedItem(ModBlocks.BROCCOLI_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> cantaloupe_seeds = register("cantaloupe_seeds", () -> new SeedItem(ModBlocks.CANTALOUPE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> carrot_seeds = register("carrot_seeds", () -> new SeedItem(ModBlocks.CARROT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> cassava_seeds = register("cassava_seeds", () -> new SeedItem(ModBlocks.CASSAVA_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> corn_seeds = register("corn_seeds", () -> new SeedItem(ModBlocks.CORN_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> cotton_seeds = register("cotton_seeds", () -> new SeedItem(ModBlocks.COTTON_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> cucumber_seeds = register("cucumber_seeds", () -> new SeedItem(ModBlocks.CUCUMBER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> eggplant_seeds = register("eggplant_seeds", () -> new SeedItem(ModBlocks.EGGPLANT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> honeydew_seeds = register("honeydew_seeds", () -> new SeedItem(ModBlocks.HONEYDEW_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> ginger_seeds = register("ginger_seeds", () -> new SeedItem(ModBlocks.GINGER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> grape_seeds = register("grape_seeds", () -> new SeedItem(ModBlocks.GRAPE_PLANT.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> kenaf_seeds = register("kenaf_seeds", () -> new SeedItem(ModBlocks.KENAF_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> lettuce_seeds = register("lettuce_seeds", () -> new SeedItem(ModBlocks.LETTUCE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> oat_seeds = register("oat_seeds", () -> new SeedItem(ModBlocks.OAT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> onion_seeds = register("onion_seeds", () -> new SeedItem(ModBlocks.ONION_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> pea_seeds = register("pea_seeds", () -> new SeedItem(ModBlocks.PEA_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> peanut_seeds = register("peanut_seeds", () -> new SeedItem(ModBlocks.PEANUT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> pepper_seeds = register("pepper_seeds", () -> new SeedItem(ModBlocks.PEPPER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> potato_seeds = register("potato_seeds", () -> new SeedItem(ModBlocks.POTATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> radish_seeds = register("radish_seeds", () -> new SeedItem(ModBlocks.RADISH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> rice_seeds = register("rice_seeds", () -> new SeedItem(ModBlocks.RICE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> rye_seeds = register("rye_seeds", () -> new SeedItem(ModBlocks.RYE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> sorghum_seeds = register("sorghum_seeds", () -> new SeedItem(ModBlocks.SORGHUM_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> soybean_seeds = register("soybean_seeds", () -> new SeedItem(ModBlocks.SOYBEAN_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> spinach_seeds = register("spinach_seeds", () -> new SeedItem(ModBlocks.SPINACH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> squash_seeds = register("squash_seeds", () -> new SeedItem(ModBlocks.SQUASH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> sweet_potato_seeds = register("sweet_potato_seeds", () -> new SeedItem(ModBlocks.SWEET_POTATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> tomato_seeds = register("tomato_seeds", () -> new SeedItem(ModBlocks.TOMATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> turnip_seeds = register("turnip_seeds", () -> new SeedItem(ModBlocks.TURNIP_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> yam_seeds = register("yam_seeds", () -> new SeedItem(ModBlocks.YAM_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> zucchini_seeds = register("zucchini_seeds", () -> new SeedItem(ModBlocks.ZUCCHINI_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));

	// Prepared Food
	public static RegistryObject<Item> baked_sweet_potato = register("baked_sweet_potato", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BAKED_SWEET_POTATO)));
	public static RegistryObject<Item> baked_yam = register("baked_yam", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BAKED_POTATO)));
	public static RegistryObject<Item> banana_bread = register("banana_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BANANA_BREAD)));
	public static RegistryObject<Item> barley_bread = register("barley_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
	public static RegistryObject<Item> beef_and_broccoli = register("beef_and_broccoli", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BEEF_AND_BROCCOLI)));
	public static RegistryObject<Item> blt = register("blt", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BLT)));
	public static RegistryObject<Item> borscht = register("borscht", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.BORSCHT)));
	public static RegistryObject<Item> broccoli_cheese_soup = register("broccoli_cheese_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.BROCCOLI_CHEESE_SOUP)));
	public static RegistryObject<Item> caesar_salad = register("caesar_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CAESAR_SALAD)));
	public static RegistryObject<Item> candy = register("candy", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CANDY)));
	public static RegistryObject<Item> candy_cane = register("candy_cane", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CANDY_CANE)));
	public static RegistryObject<Item> carrot_soup = register("carrot_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CARROT_SOUP)));
	public static RegistryObject<Item> cassava_cake = register("cassava_cake", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CASSAVA_CAKE)));
	public static RegistryObject<Item> cheeseburger = register("cheeseburger", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHEESE_BURGER)));
	public static RegistryObject<Item> chicken_noodle_soup = register("chicken_noodle_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CHICKEN_NOODLE_SOUP)));
	public static RegistryObject<Item> chicken_parmesan = register("chicken_parmesan", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICKEN_PARMESAN)));
	public static RegistryObject<Item> chicory_gratin = register("chicory_gratin", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICORY_GRATIN)));
	public static RegistryObject<Item> chili = register("chili", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CHILI)));
	public static RegistryObject<Item> chocolate = register("chocolate", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHOCOLATE)));
	public static RegistryObject<Item> cooked_bacon = register("cooked_bacon", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_BACON)));
	public static RegistryObject<Item> cooked_chicken_wings = register("cooked_chicken_wings", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_CHICKEN_WINGS)));
	public static RegistryObject<Item> cooked_egg = register("cooked_egg", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_EGG)));
	public static RegistryObject<Item> cooked_horse_meat = register("cooked_horse_meat", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.COOKED_BEEF)));
	public static RegistryObject<Item> cooked_sausage = register("cooked_sausage", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_SAUSAGE)));
	public static RegistryObject<Item> cornbread = register("cornbread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CORN_BREAD)));
	public static RegistryObject<Item> corn_salad = register("corn_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CORN_SALAD)));
	public static RegistryObject<Item> cucumber_soup = register("cucumber_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CUCUMBER_SOUP)));
	public static RegistryObject<Item> egg_sandwich = register("egg_sandwich", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGG_SANDWICH)));
	public static RegistryObject<Item> eggplant_parmesan = register("eggplant_parmesan", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGGPLANT_PARMESAN)));
	public static RegistryObject<Item> fish_and_chips = register("fish_and_chips", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_AND_CHIPS)));
	public static RegistryObject<Item> fish_fillet = register("fish_fillet", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_FILLET)));
	public static RegistryObject<Item> fish_sandwich = register("fish_sandwich", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_SANDWICH)));
	public static RegistryObject<Item> fried_calamari = register("fried_calamari", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRIED_CALAMARI)));
	public static RegistryObject<Item> fried_rice = register("fried_rice", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRIED_RICE)));
	public static RegistryObject<Item> fruit_salad = register("fruit_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.FRUIT_SALAD)));
	public static RegistryObject<Item> hamburger = register("hamburger", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.HAMBURGER)));
	public static RegistryObject<Item> hotdog = register("hotdog", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.HOTDOG)));
	public static RegistryObject<Item> ice_cream_sundae = register("ice_cream_sundae", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ICE_CREAM_SUNDAE)));
	public static RegistryObject<Item> italian_beef = register("italian_beef", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ITALIAN_BEEF)));
	public static RegistryObject<Item> jaffa_cake = register("jaffa_cake", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.JAFFA_CAKE)));
	public static RegistryObject<Item> lasagna = register("lasagna", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.LASAGNA)));
	public static RegistryObject<Item> mac_and_cheese = register("mac_and_cheese", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MAC_AND_CHEESE)));
	public static RegistryObject<Item> marshmallow = register("marshmallow", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MARSHMALLOW)));
	public static RegistryObject<Item> mushroom_barley = register("mushroom_barley", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MUSHROOM_BARLEY)));
	public static RegistryObject<Item> noodles = register("noodles", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static RegistryObject<Item> oatmeal = register("oatmeal", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.OATMEAL)));
	public static RegistryObject<Item> oat_bread = register("oat_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
	public static RegistryObject<Item> olive_tomato_salad = register("olive_tomato_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.OLIVE_TOMATO_SALAD)));
	public static RegistryObject<Item> onion_soup = register("onion_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.ONION_SOUP)));
	public static RegistryObject<Item> pad_thai = register("pad_thai", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PASTA)));
	public static RegistryObject<Item> pancakes = register("pancakes", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PANCAKES)));
	public static RegistryObject<Item> pasta = register("pasta", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PASTA)));
	public static RegistryObject<Item> pbj = register("pbj", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PBJ)));
	public static RegistryObject<Item> pea_soup = register("pea_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.PEA_SOUP)));
	public static RegistryObject<Item> peanut_butter_cookie = register("peanut_butter_cookie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT_BUTTER_COOKIE)));
	public static RegistryObject<Item> pickle = register("pickle", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PICKLE)));
	public static RegistryObject<Item> pickled_beetroot = register("pickled_beetroot", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PICKLED_BEETROOT)));
	public static RegistryObject<Item> pizza = register("pizza", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PIZZA)));
	public static RegistryObject<Item> popcorn = register("popcorn", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.POPCORN)));
	public static RegistryObject<Item> potato_knish = register("potato_knish", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.POTATO_KNISH)));
	public static RegistryObject<Item> pulled_pork_sandwich = register("pulled_pork_sandwich", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PULLED_PORK_SANDWICH)));
	public static RegistryObject<Item> pumpkin_soup = register("pumpkin_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.PUMPKIN_SOUP)));
	public static RegistryObject<Item> quinoa_salad = register("quinoa_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.QUINOA_SALAD)));
	public static RegistryObject<Item> radish_soup = register("radish_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.RADISH_SOUP)));
	public static RegistryObject<Item> raisins = register("raisins", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAISINS)));
	public static RegistryObject<Item> raw_bacon = register("raw_bacon", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_BACON)));
	public static RegistryObject<Item> raw_calamari = register("raw_calamari", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_CALAMARI)));
	public static RegistryObject<Item> raw_chicken_wings = register("raw_chicken_wings", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_CHICKEN_WINGS)));
	public static RegistryObject<Item> raw_horse_meat = register("raw_horse_meat", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BEEF)));
	public static RegistryObject<Item> raw_sausage = register("raw_sausage", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_SAUSAGE)));
	public static RegistryObject<Item> rice_bowl = register("rice_bowl", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.RICE_BOWL)));
	public static RegistryObject<Item> rice_bread = register("rice_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
	public static RegistryObject<Item> rye_bread = register("rye_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
	public static RegistryObject<Item> salad = register("salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SALAD)));
	public static RegistryObject<Item> sandwich = register("sandwich", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SANDWICH)));
	public static RegistryObject<Item> sausage_barley_soup = register("sausage_barley_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SAUSAGE_BARLEY)));
	public static RegistryObject<Item> sorghum_bread = register("sorghum_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SORGHUM_BREAD)));
	public static RegistryObject<Item> spaghetti = register("spaghetti", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPAGHETTI)));
	public static RegistryObject<Item> spinach_mushroom_quiche = register("spinach_mushroom_quiche", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPINACH_MUSHROOM_QUICHE)));
	public static RegistryObject<Item> spinach_quinoa_quiche = register("spinach_quinoa_quiche", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPINACH_QUINOA_QUICHE)));
	public static RegistryObject<Item> sorghum_porridge = register("sorghum_porridge", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SORGHUM_PORRIDGE)));
	public static RegistryObject<Item> squash_casserole = register("squash_casserole", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SQUASH_CASSEROLE)));
	public static RegistryObject<Item> squash_soup = register("squash_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SQUASH_SOUP)));
	public static RegistryObject<Item> squid_ink_pasta = register("squid_ink_pasta", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SQUID_INK_PASTA)));
	public static RegistryObject<Item> stuffed_corn_zucchini = register("stuffed_corn_zucchini", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.STUFFED_CORN_ZUCCHINI)));
	public static RegistryObject<Item> sweet_potato_quinoa_cakes = register("sweet_potato_quinoa_cakes", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SWEET_POTATO_QUINOA_CAKES)));
	public static RegistryObject<Item> sushi = register("sushi", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SUSHI)));
	public static RegistryObject<Item> tofu = register("tofu", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOFU)));
	public static RegistryObject<Item> tofu_scramble = register("tofu_scramble", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOFU_SCRAMBLE)));
	public static RegistryObject<Item> tomato_soup = register("tomato_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.TOMATO_SOUP)));
	public static RegistryObject<Item> trail_mix = register("trail_mix", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TRAIL_MIX)));
	public static RegistryObject<Item> turnip_beetroot_gratin = register("turnip_beetroot_gratin", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TURNIP_BEETROOT_GRATIN)));
	public static RegistryObject<Item> vegetable_medley = register("vegetable_medley", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.VEGETABLE_MEDLEY)));
	public static RegistryObject<Item> veggie_burger = register("veggie_burger", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.VEGGIE_BURGER)));
	public static RegistryObject<Item> zucchini_bread = register("zucchini_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ZUCCHINI_BREAD)));

	// Magic
	public static RegistryObject<Item> golden_habanero = register("golden_habanero", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).rarity(Rarity.RARE).food(FoodTier.GOLDEN_HABANERO)));

	// Pie
	public static RegistryObject<Item> apple_pie = register("apple_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static RegistryObject<Item> apricot_pie = register("apricot_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static RegistryObject<Item> blackberry_pie = register("blackberry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
	public static RegistryObject<Item> blueberry_pie = register("blueberry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
	public static RegistryObject<Item> cherry_pie = register("cherry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static RegistryObject<Item> peanut_butter_pie = register("peanut_butter_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT_BUTTER_PIE)));
	public static RegistryObject<Item> pear_pie = register("pear_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static RegistryObject<Item> plum_pie = register("plum_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static RegistryObject<Item> raspberry_pie = register("raspberry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
	public static RegistryObject<Item> strawberry_pie = register("strawberry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));

	// Curry Dishes
	public static RegistryObject<Item> beef_curry = register("beef_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BEEF_CURRY)));
	public static RegistryObject<Item> chicken_curry = register("chicken_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICKEN_CURRY)));
	public static RegistryObject<Item> pork_curry = register("pork_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PORK_CURRY)));
	public static RegistryObject<Item> mutton_curry = register("mutton_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MUTTON_CURRY)));
	public static RegistryObject<Item> vegetable_curry = register("vegetable_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.VEGETABLE_CURRY)));

	// Alcohol
	public static RegistryObject<Item> beer = register("beer", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "beer"));
	public static RegistryObject<Item> cauim = register("cauim", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "cauim"));
	public static RegistryObject<Item> cider = register("cider", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "cider"));
	public static RegistryObject<Item> mead = register("mead", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "mead"));
	public static RegistryObject<Item> sake = register("sake", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "sake"));
	public static RegistryObject<Item> tiswin = register("tiswin", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "tiswin"));
	public static RegistryObject<Item> vodka = register("vodka", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "vodka"));
	public static RegistryObject<Item> whiskey = register("whiskey", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "whiskey"));
	public static RegistryObject<Item> wine = register("wine", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "wine"));

	// Tools
	public static RegistryObject<Item> wooden_scythe;
	public static RegistryObject<Item> stone_scythe;
	public static RegistryObject<Item> iron_scythe;
	public static RegistryObject<Item> golden_scythe;
	public static RegistryObject<Item> diamond_scythe;
	
	// Special
	public static RegistryObject<Item> music_disc_nourish = register("music_disc_nourish", () -> new SimpleMusicDiscItem(1, SimpleSoundEvents.nourish, (new Item.Properties()).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB).rarity(Rarity.RARE)));

	// @formatter:on

	public static void registerItems() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
		return ITEMS.register(name, item);
	}

}
