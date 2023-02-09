package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.item.AlcoholItem;
import enemeez.simplefarming.common.item.GrainCropItem;
import enemeez.simplefarming.common.item.RootCropItem;
import enemeez.simplefarming.common.item.ScytheItem;
import enemeez.simplefarming.common.item.SeedItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimpleFarming.MOD_ID);
    public static final LinkedList<RegistryObject<Item>> ITEM_LIST = new LinkedList<>();
    public static final Map<RegistryObject<Item>, Float> COMPOSTABLES = new HashMap<>();
    public static final LinkedList<RegistryObject<Item>> SEEDS = new LinkedList<>();

    // ******************** Blocks ********************
    // Wild bushes
    public static final RegistryObject<Item> BLACKBERRY_BUSH = registerBlockItem("blackberry_bush", ModBlocks.BLACKBERRY_BUSH, 0.3F);
    public static final RegistryObject<Item> BLUEBERRY_BUSH = registerBlockItem("blueberry_bush", ModBlocks.BLUEBERRY_BUSH, 0.3F);
    public static final RegistryObject<Item> RASPBERRY_BUSH = registerBlockItem("raspberry_bush", ModBlocks.RASPBERRY_BUSH, 0.3F);
    public static final RegistryObject<Item> STRAWBERRY_BUSH = registerBlockItem("strawberry_bush", ModBlocks.STRAWBERRY_BUSH, 0.3F);
    public static final RegistryObject<Item> OPUNTIA = registerBlockItem("opuntia", ModBlocks.OPUNTIA, 0.5F);

    // Hay bales
    public static final RegistryObject<Item> BARLEY_HAY_BLOCK = registerBlockItem("barley_hay_block", ModBlocks.BARLEY_HAY_BLOCK, 0.85F);
    public static final RegistryObject<Item> OAT_HAY_BLOCK = registerBlockItem("oat_hay_block", ModBlocks.OAT_HAY_BLOCK, 0.85F);
    public static final RegistryObject<Item> RICE_HAY_BLOCK = registerBlockItem("rice_hay_block", ModBlocks.RICE_HAY_BLOCK, 0.85F);
    public static final RegistryObject<Item> RYE_HAY_BLOCK = registerBlockItem("rye_hay_block", ModBlocks.RYE_HAY_BLOCK, 0.85F);

    // Fermenter
    public static final RegistryObject<Item> FERMENTER = registerBlockItem("fermenter", ModBlocks.FERMENTER);

    // Gourd-like
    public static final RegistryObject<Item> CANTALOUPE_BLOCK = registerBlockItem("cantaloupe_block", ModBlocks.CANTALOUPE, 1.0F);
    public static final RegistryObject<Item> HONEYDEW_BLOCK = registerBlockItem("honeydew_block", ModBlocks.HONEYDEW, 1.0F);
    public static final RegistryObject<Item> SQUASH_BLOCK = registerBlockItem("squash_block", ModBlocks.SQUASH, 1.0F);

    // Saplings
    public static final RegistryObject<Item> APPLE_SAPLING = registerBlockItem("apple_sapling", ModBlocks.APPLE_SAPLING, 0.3F);
    public static final RegistryObject<Item> APRICOT_SAPLING = registerBlockItem("apricot_sapling", ModBlocks.APRICOT_SAPLING, 0.3F);
    public static final RegistryObject<Item> BANANA_SAPLING = registerBlockItem("banana_sapling", ModBlocks.BANANA_SAPLING, 0.3F);
    public static final RegistryObject<Item> CHERRY_SAPLING = registerBlockItem("cherry_sapling", ModBlocks.CHERRY_SAPLING, 0.3F);
    public static final RegistryObject<Item> MANGO_SAPLING = registerBlockItem("mango_sapling", ModBlocks.MANGO_SAPLING, 0.3F);
    public static final RegistryObject<Item> OLIVE_SAPLING = registerBlockItem("olive_sapling", ModBlocks.OLIVE_SAPLING, 0.3F);
    public static final RegistryObject<Item> ORANGE_SAPLING = registerBlockItem("orange_sapling", ModBlocks.ORANGE_SAPLING, 0.3F);
    public static final RegistryObject<Item> PEAR_SAPLING = registerBlockItem("pear_sapling", ModBlocks.PEAR_SAPLING, 0.3F);
    public static final RegistryObject<Item> PLUM_SAPLING = registerBlockItem("plum_sapling", ModBlocks.PLUM_SAPLING, 0.3F);

    // Scarecrow
    public static final RegistryObject<Item> SCARECROW = registerBlockItem("scarecrow", ModBlocks.SCARECROW);

    // Trellis
    public static final RegistryObject<Item> TRELLIS = registerBlockItem("trellis", ModBlocks.TRELLIS);

    // Cake
    public static final RegistryObject<Item> CHOCOLATE_CAKE = registerCakeLike("chocolate_cake", ModBlocks.CHOCOLATE_CAKE);
    public static final RegistryObject<Item> SPRINKLE_CAKE = registerCakeLike("sprinkle_cake", ModBlocks.SPRINKLE_CAKE);
    public static final RegistryObject<Item> CHEESE_WHEEL = registerCakeLike("cheese_wheel", ModBlocks.CHEESE_WHEEL);
    // ************************************************

    // Scythes
    public static final RegistryObject<Item> WOODEN_SCYTHE = registerScythe("wooden_scythe", Tiers.WOOD);
    public static final RegistryObject<Item> STONE_SCYTHE = registerScythe("stone_scythe", Tiers.STONE);
    public static final RegistryObject<Item> IRON_SCYTHE = registerScythe("iron_scythe", Tiers.IRON);
    public static final RegistryObject<Item> GOLDEN_SCYTHE = registerScythe("golden_scythe", Tiers.GOLD);
    public static final RegistryObject<Item> DIAMOND_SCYTHE = registerScythe("diamond_scythe", Tiers.DIAMOND);
    public static final RegistryObject<Item> NETHERITE_SCYTHE = registerScythe("netherite_scythe", Tiers.NETHERITE);

    // Music disc
    public static final RegistryObject<Item> MUSIC_DISC_NOURISH = registerMusicDisc("music_disc_nourish", 2340);

    // Grapes
    public static final RegistryObject<Item> GRAPES = registerFood("grapes", ModFoods.FRUIT, 0.65F);

    // Fruit tree
    public static final RegistryObject<Item> APRICOT = registerFood("apricot", ModFoods.FRUIT, 0.65F);
    public static final RegistryObject<Item> BANANA = registerFood("banana", ModFoods.FRUIT, 0.65F);
    public static final RegistryObject<Item> CHERRIES = registerFood("cherries", ModFoods.FRUIT, 0.65F);
    public static final RegistryObject<Item> MANGO = registerFood("mango", ModFoods.FRUIT, 0.65F);
    public static final RegistryObject<Item> OLIVES = registerFood("olives", ModFoods.OLIVES, 0.65F);
    public static final RegistryObject<Item> ORANGE = registerFood("orange", ModFoods.FRUIT, 0.65F);
    public static final RegistryObject<Item> PEAR = registerFood("pear", ModFoods.FRUIT, 0.65F);
    public static final RegistryObject<Item> PLUM = registerFood("plum", ModFoods.FRUIT, 0.65F);

    // Gourds
    public static final RegistryObject<Item> CANTALOUPE = registerFood("cantaloupe", ModFoods.GOURD_SLICE, 0.3F);
    public static final RegistryObject<Item> HONEYDEW = registerFood("honeydew", ModFoods.GOURD_SLICE, 0.3F);
    public static final RegistryObject<Item> SQUASH = registerFood("squash", ModFoods.GOURD_SLICE, 0.3F);

    // Berries
    public static final RegistryObject<Item> BLACKBERRIES = registerFood("blackberries", ModFoods.BERRY, 0.3F);
    public static final RegistryObject<Item> BLUEBERRIES = registerFood("blueberries", ModFoods.BERRY, 0.3F);
    public static final RegistryObject<Item> RASPBERRIES = registerFood("raspberries", ModFoods.BERRY, 0.3F);
    public static final RegistryObject<Item> STRAWBERRIES = registerFood("strawberries", ModFoods.BERRY, 0.3F);
    public static final RegistryObject<Item> CACTUS_FRUIT = registerFood("cactus_fruit", ModFoods.BERRY, 0.3F);

    // Vegetables
    public static final RegistryObject<Item> BROCCOLI = registerFood("broccoli", ModFoods.BROCCOLI, 0.65F);
    public static final RegistryObject<Item> CASSAVA = registerFood("cassava", ModFoods.CASSAVA, 0.65F);
    public static final RegistryObject<Item> CORN = registerGrainCropItem("corn", ModFoods.CORN);
    public static final RegistryObject<Item> CUCUMBER = registerFood("cucumber", ModFoods.CUCUMBER, 0.65F);
    public static final RegistryObject<Item> EGGPLANT = registerFood("eggplant", ModFoods.EGGPLANT, 0.65F);
    public static final RegistryObject<Item> HABANERO = registerFood("habanero", ModFoods.PEPPER, 0.65F);
    public static final RegistryObject<Item> GINGER = registerFood("ginger", ModFoods.GINGER, 0.65F);
    public static final RegistryObject<Item> LETTUCE = registerFood("lettuce", ModFoods.SALAD_GREENS, 0.65F);
    public static final RegistryObject<Item> ONION = registerRootCropItem("onion", ModFoods.ONION);
    public static final RegistryObject<Item> PEA_POD = registerFood("pea_pod", ModFoods.PEA_POD, 0.65F);
    public static final RegistryObject<Item> PEANUT = registerFood("peanut", ModFoods.PEANUT, 0.65F);
    public static final RegistryObject<Item> PEPPER = registerFood("pepper", ModFoods.PEPPER, 0.65F);
    public static final RegistryObject<Item> RADISH = registerRootCropItem("radish", ModFoods.RADISH);
    public static final RegistryObject<Item> SORGHUM = registerGrainCropItem("sorghum", ModFoods.SORGHUM);
    public static final RegistryObject<Item> SOYBEAN = registerFood("soybean", ModFoods.SOYBEAN, 0.65F);
    public static final RegistryObject<Item> SPINACH = registerFood("spinach", ModFoods.SALAD_GREENS, 0.65F);
    public static final RegistryObject<Item> SWEET_POTATO = registerRootCropItem("sweet_potato", ModFoods.SWEET_POTATO);
    public static final RegistryObject<Item> TOMATO = registerFood("tomato", ModFoods.TOMATO, 0.65F);
    public static final RegistryObject<Item> TURNIP = registerRootCropItem("turnip", ModFoods.TURNIP);
    public static final RegistryObject<Item> YAM = registerRootCropItem("yam", Foods.POTATO);
    public static final RegistryObject<Item> ZUCCHINI = registerFood("zucchini", ModFoods.ZUCCHINI, 0.65F);

    // Misc. crops
    public static final RegistryObject<Item> COTTON = registerItem("cotton", 0.65F);
    public static final RegistryObject<Item> KENAF_FIBER = registerItem("kenaf_fiber", 0.65F);
    public static final RegistryObject<Item> BARLEY = registerGrainCropItem("barley");
    public static final RegistryObject<Item> OAT = registerGrainCropItem("oat");
    public static final RegistryObject<Item> RYE = registerGrainCropItem("rye");
    public static final RegistryObject<Item> RICE = registerGrainCropItem("rice");

    // Ingredients
    public static final RegistryObject<Item> CHEESE_SLICE = registerFood("cheese_slice", ModFoods.CHEESE_SLICE, 0.3F);
    public static final RegistryObject<Item> CURRY_POWDER = registerItem("curry_powder", 0.85F);
    public static final RegistryObject<Item> JAM = registerItem("jam");
    public static final RegistryObject<Item> OLIVE_OIL = registerItem("olive_oil");
    public static final RegistryObject<Item> VINEGAR = registerItem("vinegar");
    public static final RegistryObject<Item> SPRINKLES = registerItem("sprinkles", 0.3F);
    public static final RegistryObject<Item> NOODLES = registerItem("noodles", 0.85F);

    // Beverages
    public static final RegistryObject<Item> BEER = registerAlcohol("beer", MobEffects.DAMAGE_BOOST);
    public static final RegistryObject<Item> CAUIM = registerAlcohol("cauim", MobEffects.JUMP);
    public static final RegistryObject<Item> CIDER = registerAlcohol("cider", MobEffects.LUCK);
    public static final RegistryObject<Item> MEAD = registerAlcohol("mead", MobEffects.DIG_SPEED);
    public static final RegistryObject<Item> SAKE = registerAlcohol("sake", MobEffects.MOVEMENT_SPEED);
    public static final RegistryObject<Item> TISWIN = registerAlcohol("tiswin", MobEffects.HEALTH_BOOST);
    public static final RegistryObject<Item> VODKA = registerAlcohol("vodka", MobEffects.DAMAGE_RESISTANCE);
    public static final RegistryObject<Item> WHISKEY = registerAlcohol("whiskey", MobEffects.ABSORPTION);
    public static final RegistryObject<Item> WINE = registerAlcohol("wine", MobEffects.REGENERATION);

    // Seeds
    public static final RegistryObject<Item> BARLEY_SEEDS = registerSeed("barley_seeds", ModBlocks.BARLEY);
    public static final RegistryObject<Item> BROCCOLI_SEEDS = registerSeed("broccoli_seeds", ModBlocks.BROCCOLI);
    public static final RegistryObject<Item> CANTALOUPE_SEEDS = registerSeed("cantaloupe_seeds", ModBlocks.CANTALOUPE_STEM);
    public static final RegistryObject<Item> CORN_SEEDS = registerSeed("corn_seeds", ModBlocks.CORN);
    public static final RegistryObject<Item> COTTON_SEEDS = registerSeed("cotton_seeds", ModBlocks.COTTON);
    public static final RegistryObject<Item> CASSAVA_SEEDS = registerSeed("cassava_seeds", ModBlocks.CASSAVA);
    public static final RegistryObject<Item> CUCUMBER_SEEDS = registerSeed("cucumber_seeds", ModBlocks.CUCUMBERS);
    public static final RegistryObject<Item> EGGPLANT_SEEDS = registerSeed("eggplant_seeds", ModBlocks.EGGPLANTS);
    public static final RegistryObject<Item> GINGER_SEEDS = registerSeed("ginger_seeds", ModBlocks.GINGER);
    public static final RegistryObject<Item> GRAPE_SEEDS = registerSeed("grape_seeds", ModBlocks.GRAPE_TRUNK);
    public static final RegistryObject<Item> HONEYDEW_SEEDS = registerSeed("honeydew_seeds", ModBlocks.HONEYDEW_STEM);
    public static final RegistryObject<Item> KENAF_SEEDS = registerSeed("kenaf_seeds", ModBlocks.KENAF);
    public static final RegistryObject<Item> LETTUCE_SEEDS = registerSeed("lettuce_seeds", ModBlocks.LETTUCE);
    public static final RegistryObject<Item> OAT_SEEDS = registerSeed("oat_seeds", ModBlocks.OAT);
    public static final RegistryObject<Item> ONION_SEEDS = registerSeed("onion_seeds", ModBlocks.ONIONS);
    public static final RegistryObject<Item> PEA_SEEDS = registerSeed("pea_seeds", ModBlocks.PEAS);
    public static final RegistryObject<Item> PEANUT_SEEDS = registerSeed("peanut_seeds", ModBlocks.PEANUTS);
    public static final RegistryObject<Item> PEPPER_SEEDS = registerSeed("pepper_seeds", ModBlocks.PEPPERS);
    public static final RegistryObject<Item> RADISH_SEEDS = registerSeed("radish_seeds", ModBlocks.RADISHES);
    public static final RegistryObject<Item> RICE_SEEDS = registerSeed("rice_seeds", ModBlocks.RICE);
    public static final RegistryObject<Item> RYE_SEEDS = registerSeed("rye_seeds", ModBlocks.RYE);
    public static final RegistryObject<Item> SORGHUM_SEEDS = registerSeed("sorghum_seeds", ModBlocks.SORGHUM);
    public static final RegistryObject<Item> SOYBEAN_SEEDS = registerSeed("soybean_seeds", ModBlocks.SOYBEANS);
    public static final RegistryObject<Item> SPINACH_SEEDS = registerSeed("spinach_seeds", ModBlocks.SPINACH);
    public static final RegistryObject<Item> SQUASH_SEEDS = registerSeed("squash_seeds", ModBlocks.SQUASH_STEM);
    public static final RegistryObject<Item> SWEET_POTATO_SEEDS = registerSeed("sweet_potato_seeds", ModBlocks.SWEET_POTATOES);
    public static final RegistryObject<Item> TOMATO_SEEDS = registerSeed("tomato_seeds", ModBlocks.TOMATOES);
    public static final RegistryObject<Item> TURNIP_SEEDS = registerSeed("turnip_seeds", ModBlocks.TURNIPS);
    public static final RegistryObject<Item> YAM_SEEDS = registerSeed("yam_seeds", ModBlocks.YAMS);
    public static final RegistryObject<Item> ZUCCHINI_SEEDS = registerSeed("zucchini_seeds", ModBlocks.ZUCCHINIS);

    // Edible seeds
    public static final RegistryObject<Item> CHICORY_ROOT = registerEdibleSeed("chicory_root", ModBlocks.CHICORY);
    public static final RegistryObject<Item> CUMIN_SEEDS = registerEdibleSeed("cumin_seeds", ModBlocks.CUMIN);
    public static final RegistryObject<Item> MARSHMALLOW_ROOT = registerEdibleSeed("marshmallow_root", ModBlocks.MARSHMALLOW);
    public static final RegistryObject<Item> QUINOA_SEEDS = registerEdibleSeed("quinoa_seeds", ModBlocks.QUINOA);

    // Pies
    public static final RegistryObject<Item> APPLE_PIE = registerFood("apple_pie", ModFoods.FRUIT_PIE, 1.0F);
    public static final RegistryObject<Item> APRICOT_PIE = registerFood("apricot_pie", ModFoods.FRUIT_PIE, 1.0F);
    public static final RegistryObject<Item> BLACKBERRY_PIE = registerFood("blackberry_pie", ModFoods.BERRY_PIE, 1.0F);
    public static final RegistryObject<Item> BLUEBERRY_PIE = registerFood("blueberry_pie", ModFoods.BERRY_PIE, 1.0F);
    public static final RegistryObject<Item> CHERRY_PIE = registerFood("cherry_pie", ModFoods.FRUIT_PIE, 1.0F);
    public static final RegistryObject<Item> PEANUT_BUTTER_PIE = registerFood("peanut_butter_pie", ModFoods.PEANUT_BUTTER_PIE, 1.0F);
    public static final RegistryObject<Item> PEAR_PIE = registerFood("pear_pie", ModFoods.FRUIT_PIE, 1.0F);
    public static final RegistryObject<Item> PLUM_PIE = registerFood("plum_pie", ModFoods.FRUIT_PIE, 1.0F);
    public static final RegistryObject<Item> RASPBERRY_PIE = registerFood("raspberry_pie", ModFoods.BERRY_PIE, 1.0F);
    public static final RegistryObject<Item> STRAWBERRY_PIE = registerFood("strawberry_pie", ModFoods.BERRY_PIE, 1.0F);

    // Bowl foods
    public static final RegistryObject<Item> BORSCHT = registerBowlFood("borscht", ModFoods.BORSCHT);
    public static final RegistryObject<Item> BROCCOLI_CHEESE_SOUP = registerBowlFood("broccoli_cheese_soup", ModFoods.BROCCOLI_CHEESE_SOUP);
    public static final RegistryObject<Item> CAESAR_SALAD = registerBowlFood("caesar_salad", ModFoods.CAESAR_SALAD);
    public static final RegistryObject<Item> CARROT_SOUP = registerBowlFood("carrot_soup", ModFoods.CARROT_SOUP);
    public static final RegistryObject<Item> CHICKEN_NOODLE_SOUP = registerBowlFood("chicken_noodle_soup", ModFoods.CHICKEN_NOODLE_SOUP);
    public static final RegistryObject<Item> CHILI = registerBowlFood("chili", ModFoods.CHILI);
    public static final RegistryObject<Item> CORN_SALAD = registerBowlFood("corn_salad", ModFoods.CORN_SALAD);
    public static final RegistryObject<Item> CUCUMBER_SOUP = registerBowlFood("cucumber_soup", ModFoods.CUCUMBER_SOUP);
    public static final RegistryObject<Item> FRUIT_SALAD = registerBowlFood("fruit_salad", ModFoods.FRUIT_SALAD);
    public static final RegistryObject<Item> OATMEAL = registerBowlFood("oatmeal", ModFoods.OATMEAL);
    public static final RegistryObject<Item> OLIVE_TOMATO_SALAD = registerBowlFood("olive_tomato_salad", ModFoods.OLIVE_TOMATO_SALAD);
    public static final RegistryObject<Item> ONION_SOUP = registerBowlFood("onion_soup", ModFoods.ONION_SOUP);
    public static final RegistryObject<Item> PEA_SOUP = registerBowlFood("pea_soup", ModFoods.PEA_SOUP);
    public static final RegistryObject<Item> PUMPKIN_SOUP = registerBowlFood("pumpkin_soup", ModFoods.PUMPKIN_SOUP);
    public static final RegistryObject<Item> QUINOA_SALAD = registerBowlFood("quinoa_salad", ModFoods.QUINOA_SALAD);
    public static final RegistryObject<Item> RADISH_SOUP = registerBowlFood("radish_soup", ModFoods.RADISH_SOUP);
    public static final RegistryObject<Item> RICE_BOWL = registerBowlFood("rice_bowl", ModFoods.RICE_BOWL);
    public static final RegistryObject<Item> SALAD = registerBowlFood("salad", ModFoods.SALAD);
    public static final RegistryObject<Item> SAUSAGE_BARLEY_SOUP = registerBowlFood("sausage_barley_soup", ModFoods.SAUSAGE_BARLEY);
    public static final RegistryObject<Item> SORGHUM_PORRIDGE = registerBowlFood("sorghum_porridge", ModFoods.SORGHUM_PORRIDGE);
    public static final RegistryObject<Item> SQUASH_SOUP = registerBowlFood("squash_soup", ModFoods.SQUASH_SOUP);
    public static final RegistryObject<Item> TOMATO_SOUP = registerBowlFood("tomato_soup", ModFoods.TOMATO_SOUP);
    public static final RegistryObject<Item> VEGETABLE_MEDLEY = registerBowlFood("vegetable_medley", ModFoods.VEGETABLE_MEDLEY);

    // Bread
    public static final RegistryObject<Item> BANANA_BREAD = registerFood("banana_bread", ModFoods.BANANA_BREAD, 0.85F);
    public static final RegistryObject<Item> BARLEY_BREAD = registerFood("barley_bread", Foods.BREAD, 0.85F);
    public static final RegistryObject<Item> CORNBREAD = registerFood("cornbread", ModFoods.CORN_BREAD, 0.85F);
    public static final RegistryObject<Item> OAT_BREAD = registerFood("oat_bread", Foods.BREAD, 0.85F);
    public static final RegistryObject<Item> RICE_BREAD = registerFood("rice_bread", Foods.BREAD, 0.85F);
    public static final RegistryObject<Item> RYE_BREAD = registerFood("rye_bread", Foods.BREAD, 0.85F);
    public static final RegistryObject<Item> SORGHUM_BREAD = registerFood("sorghum_bread", ModFoods.SORGHUM_BREAD, 0.85F);
    public static final RegistryObject<Item> ZUCCHINI_BREAD = registerFood("zucchini_bread", ModFoods.ZUCCHINI_BREAD, 0.85F);

    // Sandwiches
    public static final RegistryObject<Item> BLT = registerFood("blt", ModFoods.BLT);
    public static final RegistryObject<Item> CHEESEBURGER = registerFood("cheeseburger", ModFoods.CHEESE_BURGER);
    public static final RegistryObject<Item> EGG_SANDWICH = registerFood("egg_sandwich", ModFoods.EGG_SANDWICH);
    public static final RegistryObject<Item> FISH_SANDWICH = registerFood("fish_sandwich", ModFoods.FISH_SANDWICH);
    public static final RegistryObject<Item> HAMBURGER = registerFood("hamburger", ModFoods.HAMBURGER);
    public static final RegistryObject<Item> ITALIAN_BEEF = registerFood("italian_beef", ModFoods.ITALIAN_BEEF);
    public static final RegistryObject<Item> HOTDOG = registerFood("hotdog", ModFoods.HOTDOG);
    public static final RegistryObject<Item> PBJ = registerFood("pbj", ModFoods.PBJ, 1.0F);
    public static final RegistryObject<Item> PULLED_PORK_SANDWICH = registerFood("pulled_pork_sandwich", ModFoods.PULLED_PORK_SANDWICH);
    public static final RegistryObject<Item> SANDWICH = registerFood("sandwich", ModFoods.SANDWICH, 1.0F);
    public static final RegistryObject<Item> VEGGIE_BURGER = registerFood("veggie_burger", ModFoods.VEGGIE_BURGER, 1.0F);

    // Animal-related
    public static final RegistryObject<Item> RAW_BACON = registerFood("raw_bacon", ModFoods.RAW_BACON);
    public static final RegistryObject<Item> RAW_CHICKEN_WINGS = registerFood("raw_chicken_wings", ModFoods.RAW_CHICKEN_WINGS);
    public static final RegistryObject<Item> RAW_SAUSAGE = registerFood("raw_sausage", ModFoods.RAW_SAUSAGE);
    public static final RegistryObject<Item> COOKED_BACON = registerFood("cooked_bacon", ModFoods.COOKED_BACON);
    public static final RegistryObject<Item> COOKED_CHICKEN_WINGS = registerFood("cooked_chicken_wings", ModFoods.COOKED_CHICKEN_WINGS);
    public static final RegistryObject<Item> COOKED_EGG = registerFood("cooked_egg", ModFoods.COOKED_EGG);
    public static final RegistryObject<Item> COOKED_SAUSAGE = registerFood("cooked_sausage", ModFoods.COOKED_SAUSAGE);

    // Curry
    public static final RegistryObject<Item> BEEF_CURRY = registerFood("beef_curry", ModFoods.BEEF_CURRY);
    public static final RegistryObject<Item> CHICKEN_CURRY = registerFood("chicken_curry", ModFoods.CHICKEN_CURRY);
    public static final RegistryObject<Item> MUTTON_CURRY = registerFood("mutton_curry", ModFoods.MUTTON_CURRY);
    public static final RegistryObject<Item> PORK_CURRY = registerFood("pork_curry", ModFoods.PORK_CURRY);
    public static final RegistryObject<Item> VEGETABLE_CURRY = registerFood("vegetable_curry", ModFoods.VEGETABLE_CURRY, 1.0F);

    // Dishes
    public static final RegistryObject<Item> BEEF_AND_BROCCOLI = registerFood("beef_and_broccoli", ModFoods.BEEF_AND_BROCCOLI);
    public static final RegistryObject<Item> CHICORY_GRATIN = registerFood("chicory_gratin", ModFoods.CHICORY_GRATIN, 1.0F);
    public static final RegistryObject<Item> FISH_AND_CHIPS = registerFood("fish_and_chips", ModFoods.FISH_AND_CHIPS);
    public static final RegistryObject<Item> FRIED_RICE = registerFood("fried_rice", ModFoods.FRIED_RICE, 1.0F);
    public static final RegistryObject<Item> MAC_AND_CHEESE = registerFood("mac_and_cheese", ModFoods.MAC_AND_CHEESE, 1.0F);
    public static final RegistryObject<Item> MUSHROOM_BARLEY = registerFood("mushroom_barley", ModFoods.MUSHROOM_BARLEY, 1.0F);
    public static final RegistryObject<Item> PAD_THAI = registerFood("pad_thai", ModFoods.PAD_THAI, 1.0F);
    public static final RegistryObject<Item> PASTA = registerFood("pasta", ModFoods.PASTA, 1.0F);
    public static final RegistryObject<Item> SPAGHETTI = registerFood("spaghetti", ModFoods.SPAGHETTI, 1.0F);
    public static final RegistryObject<Item> SPINACH_MUSHROOM_QUICHE = registerFood("spinach_mushroom_quiche", ModFoods.SPINACH_MUSHROOM_QUICHE, 1.0F);
    public static final RegistryObject<Item> SPINACH_QUINOA_QUICHE = registerFood("spinach_quinoa_quiche", ModFoods.SPINACH_QUINOA_QUICHE, 1.0F);
    public static final RegistryObject<Item> SQUASH_CASSEROLE = registerFood("squash_casserole", ModFoods.SQUASH_CASSEROLE, 1.0F);
    public static final RegistryObject<Item> TOFU_SCRAMBLE = registerFood("tofu_scramble", ModFoods.TOFU_SCRAMBLE, 1.0F);
    public static final RegistryObject<Item> TURNIP_BEETROOT_GRATIN = registerFood("turnip_beetroot_gratin", ModFoods.TURNIP_BEETROOT_GRATIN, 1.0F);

    // Misc.
    public static final RegistryObject<Item> BAKED_SWEET_POTATO = registerFood("baked_sweet_potato", ModFoods.BAKED_SWEET_POTATO, 0.85F);
    public static final RegistryObject<Item> BAKED_YAM = registerFood("baked_yam", Foods.BAKED_POTATO, 0.85f);
    public static final RegistryObject<Item> CHICKEN_PARMESAN = registerFood("chicken_parmesan", ModFoods.CHICKEN_PARMESAN);
    public static final RegistryObject<Item> EGGPLANT_PARMESAN = registerFood("eggplant_parmesan", ModFoods.EGGPLANT_PARMESAN, 1.0F);
    public static final RegistryObject<Item> FISH_FILLET = registerFood("fish_fillet", ModFoods.FISH_FILLET);
    public static final RegistryObject<Item> GOLDEN_HABANERO = registerGoldenHabanero("golden_habanero", ModFoods.GOLDEN_HABANERO);
    public static final RegistryObject<Item> LASAGNA = registerFood("lasagna", ModFoods.LASAGNA);
    public static final RegistryObject<Item> PANCAKES = registerFood("pancakes", ModFoods.PANCAKES, 1.0F);
    public static final RegistryObject<Item> PICKLE = registerFood("pickle", ModFoods.PICKLE, 1.0F);
    public static final RegistryObject<Item> PICKLED_BEETROOT = registerFood("pickled_beetroot", ModFoods.PICKLED_BEETROOT, 1.0F);
    public static final RegistryObject<Item> PIZZA = registerFood("pizza", ModFoods.PIZZA, 1.0F);
    public static final RegistryObject<Item> POPCORN = registerFood("popcorn", ModFoods.POPCORN, 1.0F);
    public static final RegistryObject<Item> POTATO_KNISH = registerFood("potato_knish", ModFoods.POTATO_KNISH, 1.0F);
    public static final RegistryObject<Item> RAISINS = registerFood("raisins", ModFoods.RAISINS, 1.0F);
    public static final RegistryObject<Item> STUFFED_CORN_ZUCCHINI = registerFood("stuffed_corn_zucchini", ModFoods.STUFFED_CORN_ZUCCHINI, 1.0F);
    public static final RegistryObject<Item> SUSHI = registerFood("sushi", ModFoods.SUSHI);
    public static final RegistryObject<Item> SWEET_POTATO_QUINOA_CAKES = registerFood("sweet_potato_quinoa_cakes", ModFoods.SWEET_POTATO_QUINOA_CAKES, 1.0F);
    public static final RegistryObject<Item> TOFU = registerFood("tofu", ModFoods.TOFU, 0.85F);
    public static final RegistryObject<Item> TRAIL_MIX = registerFood("trail_mix", ModFoods.TRAIL_MIX, 1.0F);

    // Desserts
    public static final RegistryObject<Item> CANDY = registerFood("candy", ModFoods.CANDY, 1.0F);
    public static final RegistryObject<Item> CANDY_CANE = registerFood("candy_cane", ModFoods.CANDY_CANE, 1.0F);
    public static final RegistryObject<Item> CASSAVA_CAKE = registerFood("cassava_cake", ModFoods.CASSAVA_CAKE, 1.0F);
    public static final RegistryObject<Item> CHOCOLATE = registerFood("chocolate", ModFoods.CHOCOLATE, 1.0F);
    public static final RegistryObject<Item> ICE_CREAM_SUNDAE = registerFood("ice_cream_sundae", ModFoods.ICE_CREAM_SUNDAE, 1.0F);
    public static final RegistryObject<Item> JAFFA_CAKE = registerFood("jaffa_cake", ModFoods.JAFFA_CAKE, 1.0F);
    public static final RegistryObject<Item> MARSHMALLOW = registerFood("marshmallow", ModFoods.MARSHMALLOW, 1.0F);
    public static final RegistryObject<Item> PEANUT_BUTTER_COOKIE = registerFood("peanut_butter_cookie", ModFoods.PEANUT_BUTTER_COOKIE, 1.0F);


    private static RegistryObject<Item> registerItem(String name) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new Item(new Item.Properties().tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        return ITEM;
    }

    private static RegistryObject<Item> registerItem(String name, float compostChance) {
        final var ITEM = registerItem(name);
        COMPOSTABLES.put(ITEM, compostChance);
        return ITEM;
    }

    private static RegistryObject<Item> registerFood(String name, FoodProperties pFood) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new Item(new Item.Properties().food(pFood).tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        return ITEM;
    }

    private static RegistryObject<Item> registerFood(String name, FoodProperties pFood, float compostChance) {
        final var ITEM = registerFood(name, pFood);
        COMPOSTABLES.put(ITEM, compostChance);
        return ITEM;
    }

    private static RegistryObject<Item> registerGoldenHabanero(String name, FoodProperties pFood) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new Item(new Item.Properties().rarity(Rarity.RARE).food(pFood).tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        return ITEM;
    }

    private static RegistryObject<Item> registerBowlFood(String name, FoodProperties pFood) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new BowlFoodItem(
            new Item.Properties().stacksTo(1).food(pFood).tab(SimpleFarming.TAB)
        ));
        ITEM_LIST.add(ITEM);
        return ITEM;
    }

    private static RegistryObject<Item> registerSeed(String name, Supplier<Block> crop) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new SeedItem(crop.get(), new Item.Properties().tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        COMPOSTABLES.put(ITEM, 0.3F);
        SEEDS.add(ITEM);
        return ITEM;
    }

    private static RegistryObject<Item> registerEdibleSeed(String name, Supplier<Block> flower) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new ItemNameBlockItem(flower.get(), new Item.Properties()
            .food(ModFoods.SEEDS)
            .tab(SimpleFarming.TAB)
        ));
        ITEM_LIST.add(ITEM);
        COMPOSTABLES.put(ITEM, 0.3F);
        return ITEM;
    }

    private static RegistryObject<Item> registerGrainCropItem(String name) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new GrainCropItem(new Item.Properties().tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        COMPOSTABLES.put(ITEM, 0.65F);
        return ITEM;
    }

    private static RegistryObject<Item> registerGrainCropItem(String name, FoodProperties pFood) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new GrainCropItem(new Item.Properties().food(pFood).tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        COMPOSTABLES.put(ITEM, 0.65F);
        return ITEM;
    }

    private static RegistryObject<Item> registerRootCropItem(String name, FoodProperties pFood) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new RootCropItem(new Item.Properties().food(pFood).tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        COMPOSTABLES.put(ITEM, 0.65F);
        return ITEM;
    }

    private static RegistryObject<Item> registerBlockItem(String name, Supplier<Block> block) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        return ITEM;
    }

    private static RegistryObject<Item> registerBlockItem(String name, Supplier<Block> block, float compostChance) {
        final var ITEM = registerBlockItem(name, block);
        COMPOSTABLES.put(ITEM, compostChance);
        return ITEM;
    }

    private static RegistryObject<Item> registerCakeLike(String name, Supplier<Block> block) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(1).tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        COMPOSTABLES.put(ITEM, 1.0F);
        return ITEM;
    }

    private static RegistryObject<Item> registerAlcohol(String name, MobEffect effect) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new AlcoholItem(new Item.Properties().stacksTo(1).tab(SimpleFarming.TAB), effect));
        ITEM_LIST.add(ITEM);
        return ITEM;
    }

    private static RegistryObject<Item> registerScythe(String name, Tier tier) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new ScytheItem(tier, 2, -3.0F, new Item.Properties().tab(SimpleFarming.TAB)));
        ITEM_LIST.add(ITEM);
        return ITEM;
    }

    private static RegistryObject<Item> registerMusicDisc(String name, int tickLength) {
        final RegistryObject<Item> ITEM = ITEMS.register(name, () -> new RecordItem(15, () -> ModSoundEvents.MUSIC_DISC_NOURISH.get(),
            new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(SimpleFarming.TAB), tickLength)
        );
        ITEM_LIST.add(ITEM);
        return ITEM;
    }
}
