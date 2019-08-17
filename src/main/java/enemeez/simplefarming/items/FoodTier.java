package enemeez.simplefarming.items;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodTier 
{
	public static final Food BERRY = (new Food.Builder()).hunger(2).saturation(0.1F).fastToEat().build();
	public static final Food FRUIT = (new Food.Builder()).hunger(4).saturation(0.3F).build();
	public static final Food GOURD_SLICE = (new Food.Builder()).hunger(2).saturation(0.3F).build();
	public static final Food CASSAVA = (new Food.Builder()).hunger(3).saturation(0.6F).build();
	public static final Food CORN = (new Food.Builder()).hunger(4).saturation(0.6F).build();
	public static final Food CUCUMBER = (new Food.Builder()).hunger(3).saturation(0.6F).build();
	public static final Food EGGPLANT = (new Food.Builder()).hunger(3).saturation(0.6F).build();
	public static final Food GINGER = (new Food.Builder()).hunger(2).saturation(0.3F).build();
	public static final Food ONION = (new Food.Builder()).hunger(3).saturation(0.3F).build();
	public static final Food PEANUT = (new Food.Builder()).hunger(1).saturation(0.3F).build();
	public static final Food PEPPER = (new Food.Builder()).hunger(2).saturation(0.3F).build();
	public static final Food RADISH = (new Food.Builder()).hunger(1).saturation(0.6F).build();
	public static final Food SOYBEAN = (new Food.Builder()).hunger(2).saturation(0.3F).build();
	public static final Food SORGHUM = (new Food.Builder()).hunger(4).saturation(0.6F).build();
	public static final Food SALAD_GREENS = (new Food.Builder()).hunger(2).saturation(0.6F).build();
	public static final Food TOMATO = (new Food.Builder()).hunger(3).saturation(0.6F).build();
	public static final Food YAM = (new Food.Builder()).hunger(1).saturation(0.3F).build();
	
	public static final Food BAKED_YAM = (new Food.Builder()).hunger(5).saturation(0.6F).build();
	public static final Food GOLDEN_HABANERO = (new Food.Builder()).hunger(2).saturation(1.2F).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 1), 1.0F).setAlwaysEdible().build();
	public static final Food BERRY_PIE = (new Food.Builder()).hunger(4).saturation(0.1F).build();
	public static final Food FRUIT_PIE = (new Food.Builder()).hunger(6).saturation(0.3F).build();
	
	public static final Food BANANA_BREAD = (new Food.Builder()).hunger(7).saturation(0.3F).build();
	public static final Food BLT = (new Food.Builder()).hunger(14).saturation(0.8F).build();
	public static final Food CAESAR_SALAD = (new Food.Builder()).hunger(11).saturation(0.6F).build();
	public static final Food CASSAVA_CAKE = (new Food.Builder()).hunger(5).saturation(0.6F).build();
	public static final Food CHEESE_SLICE = (new Food.Builder()).hunger(3).saturation(0.3F).build(); 
	public static final Food CHEESE_BURGER = (new Food.Builder()).hunger(21).saturation(0.8F).build();
	public static final Food CHICKEN_PARMESAN = (new Food.Builder()).hunger(15).saturation(0.6F).build();
	public static final Food CHILI = (new Food.Builder()).hunger(13).saturation(0.8F).build(); 
	public static final Food CHOCOLATE = (new Food.Builder()).hunger(3).saturation(0.2F).build(); 
	public static final Food COOKED_BACON = (new Food.Builder()).hunger(4).saturation(0.8F).fastToEat().meat().build();
	public static final Food COOKED_CHICKEN_WINGS = (new Food.Builder()).hunger(3).saturation(0.6F).fastToEat().meat().build();
	public static final Food COOKED_EGG = (new Food.Builder()).hunger(5).saturation(0.6F).build(); 
	public static final Food COOKED_SAUSAGE = (new Food.Builder()).hunger(4).saturation(0.8F).fastToEat().meat().build();
	public static final Food CORN_SALAD = (new Food.Builder()).hunger(9).saturation(0.6F).build();
	public static final Food CORN_BREAD = (new Food.Builder()).hunger(7).saturation(0.6F).build(); 
	public static final Food CUCUMBER_SOUP = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food EGG_SANDWICH = (new Food.Builder()).hunger(14).saturation(0.8F).build();
	public static final Food EGGPLANT_PARMESAN = (new Food.Builder()).hunger(16).saturation(0.6F).build(); 
	public static final Food FISH_FILLET = (new Food.Builder()).hunger(8).saturation(0.8F).build(); 
	public static final Food FISH_SANDWICH = (new Food.Builder()).hunger(15).saturation(0.8F).build(); 
	public static final Food FRIED_CALAMARI = (new Food.Builder()).hunger(5).saturation(0.6F).build();
	public static final Food FRUIT_SALAD = (new Food.Builder()).hunger(8).saturation(0.3F).build();
	public static final Food HAMBURGER = (new Food.Builder()).hunger(18).saturation(0.8F).build(); 
	public static final Food HOTDOG = (new Food.Builder()).hunger(9).saturation(0.8F).build(); 
	public static final Food JAFFA_CAKE = (new Food.Builder()).hunger(8).saturation(0.3F).build(); 
	public static final Food LASAGNA = (new Food.Builder()).hunger(24).saturation(0.8F).build();
	public static final Food MAC_AND_CHEESE = (new Food.Builder()).hunger(10).saturation(0.6F).build();
	public static final Food OATMEAL = (new Food.Builder()).hunger(3).saturation(0.6F).build();
	public static final Food ONION_SOUP = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food PANCAKES = (new Food.Builder()).hunger(4).saturation(0.6F).build();
	public static final Food PASTA = (new Food.Builder()).hunger(10).saturation(0.6F).build();
	public static final Food PICKLE = (new Food.Builder()).hunger(5).saturation(0.6F).build();  
	public static final Food PICKLED_BEETROOT = (new Food.Builder()).hunger(3).saturation(0.6F).build();
	public static final Food PIZZA = (new Food.Builder()).hunger(10).saturation(0.6F).build();
	public static final Food POPCORN = (new Food.Builder()).hunger(1).saturation(0.1F).fastToEat().build();
	public static final Food PULLED_PORK_SANDWICH = (new Food.Builder()).hunger(18).saturation(0.8F).build();
	public static final Food RADISH_SOUP = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food RAW_BACON = (new Food.Builder()).hunger(2).saturation(0.3F).fastToEat().meat().build();
	public static final Food RAW_CALAMARI = (new Food.Builder()).hunger(2).saturation(0.1F).build();
	public static final Food RAW_CHICKEN_WINGS = (new Food.Builder()).hunger(1).saturation(0.3F).effect(new EffectInstance(Effects.HUNGER, 300, 0), 0.3F).fastToEat().meat().build();
	public static final Food RAW_SAUSAGE = (new Food.Builder()).hunger(2).saturation(0.3F).fastToEat().meat().build();
	public static final Food RICE_BOWL = (new Food.Builder()).hunger(3).saturation(0.6F).build();
	public static final Food SALAD = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food SANDWICH = (new Food.Builder()).hunger(16).saturation(0.6F).build();
	public static final Food SPAGHETTI = (new Food.Builder()).hunger(10).saturation(0.6F).build();
	public static final Food SPINACH_MUSHROOM_QUICHE = (new Food.Builder()).hunger(10).saturation(0.6F).build();
	public static final Food SQUASH_CASSEROLE = (new Food.Builder()).hunger(9).saturation(0.6F).build();
	public static final Food SUSHI = (new Food.Builder()).hunger(8).saturation(0.6F).build(); 
	public static final Food TOFU = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food TOMATO_SOUP = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food VEGETABLE_MEDLEY = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food VEGGIE_BURGER = (new Food.Builder()).hunger(16).saturation(0.6F).build();
	
	public static final Food TOFU_SCRAMBLE = (new Food.Builder()).hunger(12).saturation(0.6F).build();
	public static final Food RAISINS = (new Food.Builder()).hunger(8).saturation(0.6F).build();
	public static final Food CHICKEN_NOODLE_SOUP = (new Food.Builder()).hunger(13).saturation(0.6F).build();
	public static final Food QUINOA_SALAD = (new Food.Builder()).hunger(5).saturation(0.6F).build();
	public static final Food SQUASH_SOUP = (new Food.Builder()).hunger(12).saturation(0.6F).build();
	public static final Food SPINACH_QUINOA_QUICHE = (new Food.Builder()).hunger(10).saturation(0.6F).build();
	public static final Food BEEF_CURRY = (new Food.Builder()).hunger(18).saturation(0.8F).build();
	public static final Food CHICKEN_CURRY = (new Food.Builder()).hunger(16).saturation(0.6F).build();
	public static final Food MUTTON_CURRY = (new Food.Builder()).hunger(16).saturation(0.8F).build();
	public static final Food PORK_CURRY = (new Food.Builder()).hunger(18).saturation(0.8F).build();
	public static final Food VEGETABLE_CURRY = (new Food.Builder()).hunger(12).saturation(0.6F).build();

	public static final Food PEANUT_BUTTER_PIE = (new Food.Builder()).hunger(3).saturation(0.3F).build();
	public static final Food SORGHUM_BREAD = (new Food.Builder()).hunger(7).saturation(0.6F).build();
	public static final Food SORGHUM_PORRIDGE = (new Food.Builder()).hunger(8).saturation(0.6F).build();
	public static final Food ITALIAN_BEEF = (new Food.Builder()).hunger(18).saturation(0.8F).build();
	public static final Food PEANUT_BUTTER_COOKIE = (new Food.Builder()).hunger(4).saturation(0.6F).build();
	public static final Food PBJ = (new Food.Builder()).hunger(8).saturation(0.6F).build();




}
