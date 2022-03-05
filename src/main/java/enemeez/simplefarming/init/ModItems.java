package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.events.SimpleSoundEvents;
import enemeez.simplefarming.integration.FoodTier;
import enemeez.simplefarming.item.BottleItem;
import enemeez.simplefarming.item.*;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimpleFarming.MOD_ID);

	// @formatter:off

	// BlockItems
	public static final RegistryObject<Item> CANTALOUPE_BLOCK = register("cantaloupe_block", () -> new BlockItem(ModBlocks.CANTALOUPE_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> HONEYDEW_BLOCK = register("honeydew_block", () -> new BlockItem(ModBlocks.HONEYDEW_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> SQUASH_BLOCK = register("squash_block", () -> new BlockItem(ModBlocks.SQUASH_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static final RegistryObject<Item> BLACKBERRY_BUSH = register("blackberry_bush", () -> new BlockItem(ModBlocks.BLACKBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> BLUEBERRY_BUSH = register("blueberry_bush", () -> new BlockItem(ModBlocks.BLUEBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> RASPBERRY_BUSH = register("raspberry_bush", () -> new BlockItem(ModBlocks.RASPBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> STRAWBERRY_BUSH = register("strawberry_bush", () -> new BlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static final RegistryObject<Item> CACTUS_CROP = register("cactus_crop", () -> new BlockItem(ModBlocks.CACTUS_CROP.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static final RegistryObject<Item> SCARECROW = register("scarecrow", () -> new BlockItem(ModBlocks.SCARECROW.get(), new Item.Properties().stacksTo(16).tab(SimpleFarming.CREATIVE_TAB)));

	public static final RegistryObject<Item> BIRTHDAY_CAKE = register("birthday_cake", () -> new BlockItem(ModBlocks.BIRTHDAY_CAKE.get(), new Item.Properties().stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHOCOLATE_CAKE = register("chocolate_cake", () -> new BlockItem(ModBlocks.CHOCOLATE_CAKE.get(), new Item.Properties().stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHEESE_BLOCK = register("cheese_block", () -> new BlockItem(ModBlocks.CHEESE_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static final RegistryObject<Item> BARLEY_HAY_BLOCK = register("barley_hay_block", () -> new BlockItem(ModBlocks.BARLEY_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> OAT_HAY_BLOCK = register("oat_hay_block", () -> new BlockItem(ModBlocks.OAT_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> RICE_HAY_BLOCK = register("rice_hay_block", () -> new BlockItem(ModBlocks.RICE_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> RYE_HAY_BLOCK = register("rye_hay_block", () -> new BlockItem(ModBlocks.RYE_HAY_BLOCK.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static final RegistryObject<Item> FRUIT_LOG = register("fruit_log", () -> new BlockItem(ModBlocks.FRUIT_LOG.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static final RegistryObject<Item> BREWING_BARREL = register("brewing_barrel", () -> new BlockItem(ModBlocks.BREWING_BARREL.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	public static final RegistryObject<Item> APPLE_SAPLING = register("apple_sapling", () -> new BlockItem(ModBlocks.APPLE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> APRICOT_SAPLING = register("apricot_sapling", () -> new BlockItem(ModBlocks.APRICOT_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> BANANA_SAPLING = register("banana_sapling", () -> new BlockItem(ModBlocks.BANANA_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CHERRY_SAPLING = register("cherry_sapling", () -> new BlockItem(ModBlocks.CHERRY_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> MANGO_SAPLING = register("mango_sapling", () -> new BlockItem(ModBlocks.MANGO_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> OLIVE_SAPLING = register("olive_sapling", () -> new BlockItem(ModBlocks.OLIVE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> ORANGE_SAPLING = register("orange_sapling", () -> new BlockItem(ModBlocks.ORANGE_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEAR_SAPLING = register("pear_sapling", () -> new BlockItem(ModBlocks.PEAR_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> PLUM_SAPLING = register("plum_sapling", () -> new BlockItem(ModBlocks.PLUM_SAPLING.get(), new Item.Properties().tab(SimpleFarming.CREATIVE_TAB)));

	// Fruit
	public static final RegistryObject<Item> APRICOT = register("apricot", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static final RegistryObject<Item> BANANA = register("banana", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static final RegistryObject<Item> BLACKBERRIES = register("blackberries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
	public static final RegistryObject<Item> BLUEBERRIES = register("blueberries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
	public static final RegistryObject<Item> CACTUS_FRUIT = register("cactus_fruit", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
	public static final RegistryObject<Item> CANTALOUPE = register("cantaloupe", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
	public static final RegistryObject<Item> CHERRIES = register("cherries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static final RegistryObject<Item> GRAPES = register("grapes", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static final RegistryObject<Item> HONEYDEW = register("honeydew", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
	public static final RegistryObject<Item> MANGO = register("mango", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static final RegistryObject<Item> OLIVES = register("olives", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.OLIVES)));
	public static final RegistryObject<Item> ORANGE = register("orange", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static final RegistryObject<Item> PEAR = register("pear", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static final RegistryObject<Item> PLUM = register("plum", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT)));
	public static final RegistryObject<Item> RASPBERRIES = register("raspberries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));
	public static final RegistryObject<Item> STRAWBERRIES = register("strawberries", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY)));

	// Crops
	public static final RegistryObject<Item> BARLEY = register("barley", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> BROCCOLI = register("broccoli", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BROCCOLI)));
	public static final RegistryObject<Item> CASSAVA = register("cassava", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CASSAVA)));
	public static final RegistryObject<Item> CORN = register("corn", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CORN)));
	public static final RegistryObject<Item> COTTON = register("cotton", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CUCUMBER = register("cucumber", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CUCUMBER)));
	public static final RegistryObject<Item> EGGPLANT = register("eggplant", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGGPLANT)));
	public static final RegistryObject<Item> HABANERO = register("habanero", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEPPER)));
	public static final RegistryObject<Item> GINGER = register("ginger", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GINGER)));
	public static final RegistryObject<Item> LETTUCE = register("lettuce", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SALAD_GREENS)));
	public static final RegistryObject<Item> OAT = register("oat", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> ONION = register("onion", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ONION)));
	public static final RegistryObject<Item> PEA_POD = register("pea_pod", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEA_POD)));
	public static final RegistryObject<Item> PEANUT = register("peanut", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT)));
	public static final RegistryObject<Item> PEPPER = register("pepper", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEPPER)));
	public static final RegistryObject<Item> RADISH = register("radish", () -> new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RADISH)));
	public static final RegistryObject<Item> RICE = register("rice", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> RYE = register("rye", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> SORGHUM = register("sorghum", () -> new GrainItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SORGHUM)));
	public static final RegistryObject<Item> SOYBEAN = register("soybean", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SOYBEAN)));
	public static final RegistryObject<Item> SPINACH = register("spinach", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SALAD_GREENS)));
	public static final RegistryObject<Item> SQUASH = register("squash", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.GOURD_SLICE)));
	public static final RegistryObject<Item> SWEET_POTATO = register("sweet_potato", () -> new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SWEET_POTATO)));
	public static final RegistryObject<Item> TOMATO = register("tomato", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOMATO)));
	public static final RegistryObject<Item> TURNIP = register("turnip", () -> new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TURNIP)));
	public static final RegistryObject<Item> YAM = register("yam", () -> new PigItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.POTATO)));
	public static final RegistryObject<Item> ZUCCHINI = register("zucchini", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ZUCCHINI)));

	// Cheese
	public static final RegistryObject<Item> CHEESE_SLICE = register("cheese_slice", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHEESE_SLICE)));

	// Non Edible
	public static final RegistryObject<Item> CURRY_POWDER = register("curry_powder", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> JAM = register("jam", () -> new Item((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> SPRINKLES = register("sprinkles", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> KENAF_FIBER = register("kenaf_fiber", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> OLIVE_OIL = register("olive_oil", () -> new BottleItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> VINEGAR = register("vinegar", () -> new DrinkItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB)));

	// Plant Seeds
	public static final RegistryObject<Item> CHICORY_ROOT = register("chicory_root", () -> new ItemNameBlockItem(ModBlocks.CHICORY.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
	public static final RegistryObject<Item> CUMIN_SEEDS = register("cumin_seeds", () -> new SeedItem(ModBlocks.CUMIN.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
	public static final RegistryObject<Item> MARSHMALLOW_ROOT = register("marshmallow_root", () -> new ItemNameBlockItem(ModBlocks.MARSHMALLOW.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
	public static final RegistryObject<Item> QUINOA_SEEDS = register("quinoa_seeds", () -> new SeedItem(ModBlocks.QUINOA.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));
	public static final RegistryObject<Item> SUNFLOWER_SEEDS = register("sunflower_seeds", () -> new SeedItem(ModBlocks.SUNFLOWER.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SEEDS)));

	// Seeds
	public static final RegistryObject<Item> BARLEY_SEEDS = register("barley_seeds", () -> new SeedItem(ModBlocks.BARLEY_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> BROCCOLI_SEEDS = register("broccoli_seeds", () -> new SeedItem(ModBlocks.BROCCOLI_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CANTALOUPE_SEEDS = register("cantaloupe_seeds", () -> new SeedItem(ModBlocks.CANTALOUPE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CARROT_SEEDS = register("carrot_seeds", () -> new SeedItem(ModBlocks.CARROT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CASSAVA_SEEDS = register("cassava_seeds", () -> new SeedItem(ModBlocks.CASSAVA_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CORN_SEEDS = register("corn_seeds", () -> new SeedItem(ModBlocks.CORN_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> COTTON_SEEDS = register("cotton_seeds", () -> new SeedItem(ModBlocks.COTTON_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> CUCUMBER_SEEDS = register("cucumber_seeds", () -> new SeedItem(ModBlocks.CUCUMBER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> EGGPLANT_SEEDS = register("eggplant_seeds", () -> new SeedItem(ModBlocks.EGGPLANT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> HONEYDEW_SEEDS = register("honeydew_seeds", () -> new SeedItem(ModBlocks.HONEYDEW_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> GINGER_SEEDS = register("ginger_seeds", () -> new SeedItem(ModBlocks.GINGER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> GRAPE_SEEDS = register("grape_seeds", () -> new SeedItem(ModBlocks.GRAPE_PLANT.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> KENAF_SEEDS = register("kenaf_seeds", () -> new SeedItem(ModBlocks.KENAF_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> LETTUCE_SEEDS = register("lettuce_seeds", () -> new SeedItem(ModBlocks.LETTUCE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> OAT_SEEDS = register("oat_seeds", () -> new SeedItem(ModBlocks.OAT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> ONION_SEEDS = register("onion_seeds", () -> new SeedItem(ModBlocks.ONION_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEA_SEEDS = register("pea_seeds", () -> new SeedItem(ModBlocks.PEA_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEANUT_SEEDS = register("peanut_seeds", () -> new SeedItem(ModBlocks.PEANUT_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> PEPPER_SEEDS = register("pepper_seeds", () -> new SeedItem(ModBlocks.PEPPER_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> POTATO_SEEDS = register("potato_seeds", () -> new SeedItem(ModBlocks.POTATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> RADISH_SEEDS = register("radish_seeds", () -> new SeedItem(ModBlocks.RADISH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> RICE_SEEDS = register("rice_seeds", () -> new SeedItem(ModBlocks.RICE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> RYE_SEEDS = register("rye_seeds", () -> new SeedItem(ModBlocks.RYE_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> SORGHUM_SEEDS = register("sorghum_seeds", () -> new SeedItem(ModBlocks.SORGHUM_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> SOYBEAN_SEEDS = register("soybean_seeds", () -> new SeedItem(ModBlocks.SOYBEAN_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> SPINACH_SEEDS = register("spinach_seeds", () -> new SeedItem(ModBlocks.SPINACH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> SQUASH_SEEDS = register("squash_seeds", () -> new SeedItem(ModBlocks.SQUASH_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> SWEET_POTATO_SEEDS = register("sweet_potato_seeds", () -> new SeedItem(ModBlocks.SWEET_POTATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> TOMATO_SEEDS = register("tomato_seeds", () -> new SeedItem(ModBlocks.TOMATO_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> TURNIP_SEEDS = register("turnip_seeds", () -> new SeedItem(ModBlocks.TURNIP_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> YAM_SEEDS = register("yam_seeds", () -> new SeedItem(ModBlocks.YAM_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> ZUCCHINI_SEEDS = register("zucchini_seeds", () -> new SeedItem(ModBlocks.ZUCCHINI_CROP.get(), (new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));

	// Prepared Food
	public static final RegistryObject<Item> BAKED_SWEET_POTATO = register("baked_sweet_potato", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BAKED_SWEET_POTATO)));
	public static final RegistryObject<Item> BAKED_YAM = register("baked_yam", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BAKED_POTATO)));
	public static final RegistryObject<Item> BANANA_BREAD = register("banana_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BANANA_BREAD)));
	public static final RegistryObject<Item> BARLEY_BREAD = register("barley_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
	public static final RegistryObject<Item> BEEF_AND_BROCCOLI = register("beef_and_broccoli", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BEEF_AND_BROCCOLI)));
	public static final RegistryObject<Item> BLT = register("blt", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BLT)));
	public static final RegistryObject<Item> BORSCHT = register("borscht", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.BORSCHT)));
	public static final RegistryObject<Item> BROCCOLI_CHEESE_SOUP = register("broccoli_cheese_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.BROCCOLI_CHEESE_SOUP)));
	public static final RegistryObject<Item> CAESAR_SALAD = register("caesar_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CAESAR_SALAD)));
	public static final RegistryObject<Item> CANDY = register("candy", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CANDY)));
	public static final RegistryObject<Item> CANDY_CANE = register("candy_cane", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CANDY_CANE)));
	public static final RegistryObject<Item> CARROT_SOUP = register("carrot_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CARROT_SOUP)));
	public static final RegistryObject<Item> CASSAVA_CAKE = register("cassava_cake", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CASSAVA_CAKE)));
	public static final RegistryObject<Item> CHEESEBURGER = register("cheeseburger", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHEESE_BURGER)));
	public static final RegistryObject<Item> CHICKEN_NOODLE_SOUP = register("chicken_noodle_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CHICKEN_NOODLE_SOUP)));
	public static final RegistryObject<Item> CHICKEN_PARMESAN = register("chicken_parmesan", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICKEN_PARMESAN)));
	public static final RegistryObject<Item> CHICORY_GRATIN = register("chicory_gratin", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICORY_GRATIN)));
	public static final RegistryObject<Item> CHILI = register("chili", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CHILI)));
	public static final RegistryObject<Item> CHOCOLATE = register("chocolate", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHOCOLATE)));
	public static final RegistryObject<Item> COOKED_BACON = register("cooked_bacon", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_BACON)));
	public static final RegistryObject<Item> COOKED_CHICKEN_WINGS = register("cooked_chicken_wings", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_CHICKEN_WINGS)));
	public static final RegistryObject<Item> COOKED_EGG = register("cooked_egg", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_EGG)));
	public static final RegistryObject<Item> COOKED_HORSE_MEAT = register("cooked_horse_meat", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.COOKED_BEEF)));
	public static final RegistryObject<Item> COOKED_SAUSAGE = register("cooked_sausage", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.COOKED_SAUSAGE)));
	public static final RegistryObject<Item> CORNBREAD = register("cornbread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CORN_BREAD)));
	public static final RegistryObject<Item> CORN_SALAD = register("corn_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CORN_SALAD)));
	public static final RegistryObject<Item> CUCUMBER_SOUP = register("cucumber_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.CUCUMBER_SOUP)));
	public static final RegistryObject<Item> EGG_SANDWICH = register("egg_sandwich", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGG_SANDWICH)));
	public static final RegistryObject<Item> EGGPLANT_PARMESAN = register("eggplant_parmesan", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.EGGPLANT_PARMESAN)));
	public static final RegistryObject<Item> FISH_AND_CHIPS = register("fish_and_chips", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_AND_CHIPS)));
	public static final RegistryObject<Item> FISH_FILLET = register("fish_fillet", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_FILLET)));
	public static final RegistryObject<Item> FISH_SANDWICH = register("fish_sandwich", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FISH_SANDWICH)));
	public static final RegistryObject<Item> FRIED_CALAMARI = register("fried_calamari", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRIED_CALAMARI)));
	public static final RegistryObject<Item> FRIED_RICE = register("fried_rice", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRIED_RICE)));
	public static final RegistryObject<Item> FRUIT_SALAD = register("fruit_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.FRUIT_SALAD)));
	public static final RegistryObject<Item> HAMBURGER = register("hamburger", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.HAMBURGER)));
	public static final RegistryObject<Item> HOTDOG = register("hotdog", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.HOTDOG)));
	public static final RegistryObject<Item> ICE_CREAM_SUNDAE = register("ice_cream_sundae", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ICE_CREAM_SUNDAE)));
	public static final RegistryObject<Item> ITALIAN_BEEF = register("italian_beef", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ITALIAN_BEEF)));
	public static final RegistryObject<Item> JAFFA_CAKE = register("jaffa_cake", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.JAFFA_CAKE)));
	public static final RegistryObject<Item> LASAGNA = register("lasagna", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.LASAGNA)));
	public static final RegistryObject<Item> MAC_AND_CHEESE = register("mac_and_cheese", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MAC_AND_CHEESE)));
	public static final RegistryObject<Item> MARSHMALLOW = register("marshmallow", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MARSHMALLOW)));
	public static final RegistryObject<Item> MUSHROOM_BARLEY = register("mushroom_barley", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MUSHROOM_BARLEY)));
	public static final RegistryObject<Item> NOODLES = register("noodles", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB)));
	public static final RegistryObject<Item> OATMEAL = register("oatmeal", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.OATMEAL)));
	public static final RegistryObject<Item> OAT_BREAD = register("oat_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
	public static final RegistryObject<Item> OLIVE_TOMATO_SALAD = register("olive_tomato_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.OLIVE_TOMATO_SALAD)));
	public static final RegistryObject<Item> ONION_SOUP = register("onion_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.ONION_SOUP)));
	public static final RegistryObject<Item> PAD_THAI = register("pad_thai", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PASTA)));
	public static final RegistryObject<Item> PANCAKES = register("pancakes", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PANCAKES)));
	public static final RegistryObject<Item> PASTA = register("pasta", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PASTA)));
	public static final RegistryObject<Item> PBJ = register("pbj", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PBJ)));
	public static final RegistryObject<Item> PEA_SOUP = register("pea_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.PEA_SOUP)));
	public static final RegistryObject<Item> PEANUT_BUTTER_COOKIE = register("peanut_butter_cookie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT_BUTTER_COOKIE)));
	public static final RegistryObject<Item> PICKLE = register("pickle", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PICKLE)));
	public static final RegistryObject<Item> PICKLED_BEETROOT = register("pickled_beetroot", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PICKLED_BEETROOT)));
	public static final RegistryObject<Item> PIZZA = register("pizza", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PIZZA)));
	public static final RegistryObject<Item> POPCORN = register("popcorn", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.POPCORN)));
	public static final RegistryObject<Item> POTATO_KNISH = register("potato_knish", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.POTATO_KNISH)));
	public static final RegistryObject<Item> PULLED_PORK_SANDWICH = register("pulled_pork_sandwich", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PULLED_PORK_SANDWICH)));
	public static final RegistryObject<Item> PUMPKIN_SOUP = register("pumpkin_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.PUMPKIN_SOUP)));
	public static final RegistryObject<Item> QUINOA_SALAD = register("quinoa_salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.QUINOA_SALAD)));
	public static final RegistryObject<Item> RADISH_SOUP = register("radish_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.RADISH_SOUP)));
	public static final RegistryObject<Item> RAISINS = register("raisins", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAISINS)));
	public static final RegistryObject<Item> RAW_BACON = register("raw_bacon", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_BACON)));
	public static final RegistryObject<Item> RAW_CALAMARI = register("raw_calamari", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_CALAMARI)));
	public static final RegistryObject<Item> RAW_CHICKEN_WINGS = register("raw_chicken_wings", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_CHICKEN_WINGS)));
	public static final RegistryObject<Item> RAW_HORSE_MEAT = register("raw_horse_meat", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BEEF)));
	public static final RegistryObject<Item> RAW_SAUSAGE = register("raw_sausage", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.RAW_SAUSAGE)));
	public static final RegistryObject<Item> RICE_BOWL = register("rice_bowl", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.RICE_BOWL)));
	public static final RegistryObject<Item> RICE_BREAD = register("rice_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
	public static final RegistryObject<Item> RYE_BREAD = register("rye_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(Foods.BREAD)));
	public static final RegistryObject<Item> SALAD = register("salad", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SALAD)));
	public static final RegistryObject<Item> SANDWICH = register("sandwich", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SANDWICH)));
	public static final RegistryObject<Item> SAUSAGE_BARLEY_SOUP = register("sausage_barley_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SAUSAGE_BARLEY)));
	public static final RegistryObject<Item> SORGHUM_BREAD = register("sorghum_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SORGHUM_BREAD)));
	public static final RegistryObject<Item> SPAGHETTI = register("spaghetti", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPAGHETTI)));
	public static final RegistryObject<Item> SPINACH_MUSHROOM_QUICHE = register("spinach_mushroom_quiche", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPINACH_MUSHROOM_QUICHE)));
	public static final RegistryObject<Item> SPINACH_QUINOA_QUICHE = register("spinach_quinoa_quiche", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SPINACH_QUINOA_QUICHE)));
	public static final RegistryObject<Item> SORGHUM_PORRIDGE = register("sorghum_porridge", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SORGHUM_PORRIDGE)));
	public static final RegistryObject<Item> SQUASH_CASSEROLE = register("squash_casserole", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SQUASH_CASSEROLE)));
	public static final RegistryObject<Item> SQUASH_SOUP = register("squash_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.SQUASH_SOUP)));
	public static final RegistryObject<Item> SQUID_INK_PASTA = register("squid_ink_pasta", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SQUID_INK_PASTA)));
	public static final RegistryObject<Item> STUFFED_CORN_ZUCCHINI = register("stuffed_corn_zucchini", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.STUFFED_CORN_ZUCCHINI)));
	public static final RegistryObject<Item> SWEET_POTATO_QUINOA_CAKES = register("sweet_potato_quinoa_cakes", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SWEET_POTATO_QUINOA_CAKES)));
	public static final RegistryObject<Item> SUSHI = register("sushi", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.SUSHI)));
	public static final RegistryObject<Item> TOFU = register("tofu", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOFU)));
	public static final RegistryObject<Item> TOFU_SCRAMBLE = register("tofu_scramble", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TOFU_SCRAMBLE)));
	public static final RegistryObject<Item> TOMATO_SOUP = register("tomato_soup", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.TOMATO_SOUP)));
	public static final RegistryObject<Item> TRAIL_MIX = register("trail_mix", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TRAIL_MIX)));
	public static final RegistryObject<Item> TURNIP_BEETROOT_GRATIN = register("turnip_beetroot_gratin", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.TURNIP_BEETROOT_GRATIN)));
	public static final RegistryObject<Item> VEGETABLE_MEDLEY = register("vegetable_medley", () -> new BowlFoodItem((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).stacksTo(1).food(FoodTier.VEGETABLE_MEDLEY)));
	public static final RegistryObject<Item> VEGGIE_BURGER = register("veggie_burger", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.VEGGIE_BURGER)));
	public static final RegistryObject<Item> ZUCCHINI_BREAD = register("zucchini_bread", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.ZUCCHINI_BREAD)));

	// Magic
	public static final RegistryObject<Item> GOLDEN_HABANERO = register("golden_habanero", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).rarity(Rarity.RARE).food(FoodTier.GOLDEN_HABANERO)));

	// Pie
	public static final RegistryObject<Item> APPLE_PIE = register("apple_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static final RegistryObject<Item> APRICOT_PIE = register("apricot_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static final RegistryObject<Item> BLACKBERRY_PIE = register("blackberry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
	public static final RegistryObject<Item> BLUEBERRY_PIE = register("blueberry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
	public static final RegistryObject<Item> CHERRY_PIE = register("cherry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static final RegistryObject<Item> PEANUT_BUTTER_PIE = register("peanut_butter_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PEANUT_BUTTER_PIE)));
	public static final RegistryObject<Item> PEAR_PIE = register("pear_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static final RegistryObject<Item> PLUM_PIE = register("plum_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.FRUIT_PIE)));
	public static final RegistryObject<Item> RASPBERRY_PIE = register("raspberry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));
	public static final RegistryObject<Item> STRAWBERRY_PIE = register("strawberry_pie", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BERRY_PIE)));

	// Curry Dishes
	public static final RegistryObject<Item> BEEF_CURRY = register("beef_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.BEEF_CURRY)));
	public static final RegistryObject<Item> CHICKEN_CURRY = register("chicken_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.CHICKEN_CURRY)));
	public static final RegistryObject<Item> PORK_CURRY = register("pork_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.PORK_CURRY)));
	public static final RegistryObject<Item> MUTTON_CURRY = register("mutton_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.MUTTON_CURRY)));
	public static final RegistryObject<Item> VEGETABLE_CURRY = register("vegetable_curry", () -> new Item((new Item.Properties()).tab(SimpleFarming.CREATIVE_TAB).food(FoodTier.VEGETABLE_CURRY)));

	// Alcohol
	public static final RegistryObject<Item> BEER = register("beer", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "beer"));
	public static final RegistryObject<Item> CAUIM = register("cauim", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "cauim"));
	public static final RegistryObject<Item> CIDER = register("cider", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "cider"));
	public static final RegistryObject<Item> MEAD = register("mead", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "mead"));
	public static final RegistryObject<Item> SAKE = register("sake", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "sake"));
	public static final RegistryObject<Item> TISWIN = register("tiswin", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "tiswin"));
	public static final RegistryObject<Item> VODKA = register("vodka", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "vodka"));
	public static final RegistryObject<Item> WHISKEY = register("whiskey", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "whiskey"));
	public static final RegistryObject<Item> WINE = register("wine", () -> new AlcoholItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB), "wine"));

	// Tools
//	public static final RegistryObject<Item> WOODEN_SCYTHE;
//	public static final RegistryObject<Item> STONE_SCYTHE;
//	public static final RegistryObject<Item> IRON_SCYTHE;
//	public static final RegistryObject<Item> GOLDEN_SCYTHE;
//	public static final RegistryObject<Item> DIAMOND_SCYTHE;
	
	// Special
	public static final RegistryObject<Item> MUSIC_DISC_NOURISH = register("music_disc_nourish", () -> new SimpleMusicDiscItem(1, SimpleSoundEvents.nourish, (new Item.Properties()).stacksTo(1).tab(SimpleFarming.CREATIVE_TAB).rarity(Rarity.RARE)));

	// @formatter:on

	public static final void registerItems() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	private static final <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
		return ITEMS.register(name, item);
	}

}
