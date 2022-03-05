package enemeez.simplefarming.events;

import enemeez.simplefarming.entities.ai.MoreTemptation;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TemptationTask {

	// Theoretically speaking, the get calls on the registry objects should be okay as we don't perform static initialization until these things start being used, which is after registration
	private static final Ingredient SEEDS = Ingredient.of(ModItems.CANTALOUPE_SEEDS.get(), ModItems.CARROT_SEEDS.get(), ModItems.CASSAVA_SEEDS.get(), ModItems.CORN_SEEDS.get(), ModItems.CUCUMBER_SEEDS.get(),
			ModItems.EGGPLANT_SEEDS.get(), ModItems.HONEYDEW_SEEDS.get(), ModItems.KENAF_SEEDS.get(), ModItems.LETTUCE_SEEDS.get(), ModItems.OAT_SEEDS.get(), ModItems.ONION_SEEDS.get(), ModItems.POTATO_SEEDS.get(), ModItems.PEPPER_SEEDS.get(),
			ModItems.RADISH_SEEDS.get(), ModItems.RICE_SEEDS.get(), ModItems.RYE_SEEDS.get(), ModItems.SOYBEAN_SEEDS.get(), ModItems.SPINACH_SEEDS.get(), ModItems.SQUASH_SEEDS.get(), ModItems.TOMATO_SEEDS.get(), ModItems.YAM_SEEDS.get(),
			ModItems.GINGER_SEEDS.get(), ModItems.GRAPE_SEEDS.get(), ModItems.CUMIN_SEEDS.get(), ModItems.QUINOA_SEEDS.get(), ModItems.SORGHUM_SEEDS.get(), ModItems.PEANUT_SEEDS.get(), ModItems.BARLEY_SEEDS.get(), ModItems.SUNFLOWER_SEEDS.get(),
			ModItems.PEA_SEEDS.get(), ModItems.COTTON_SEEDS.get(), ModItems.SWEET_POTATO_SEEDS.get(), ModItems.BROCCOLI_SEEDS.get(), ModItems.ZUCCHINI_SEEDS.get(), ModItems.TURNIP_SEEDS.get()
	);

	private static final Ingredient WHEATS = Ingredient.of(ModItems.BARLEY.get(), ModItems.OAT.get(), ModItems.RYE.get(), ModItems.RICE.get(), ModItems.CORN.get(), ModItems.SORGHUM.get());

	private static final Ingredient PIGS = Ingredient.of(ModItems.SWEET_POTATO.get(), ModItems.RADISH.get(), ModItems.TURNIP.get(), ModItems.YAM.get());

	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();

		if (entity instanceof Chicken) {
			Chicken chicken = (Chicken) entity;
			if ((chicken.getNavigation() instanceof GroundPathNavigation) || (chicken.getNavigation() instanceof FlyingPathNavigation)) {
				chicken.goalSelector.addGoal(3, new MoreTemptation(chicken, 1.0D, false, SEEDS));
			}
		}

		if (entity instanceof Cow) {
			Cow cow = (Cow) entity;
			if ((cow.getNavigation() instanceof GroundPathNavigation) || (cow.getNavigation() instanceof FlyingPathNavigation)) {
				cow.goalSelector.addGoal(3, new MoreTemptation(cow, 1.25D, false, WHEATS));
			}
		}

		if (entity instanceof Sheep) {
			Sheep sheep = (Sheep) entity;
			if ((sheep.getNavigation() instanceof GroundPathNavigation) || (sheep.getNavigation() instanceof FlyingPathNavigation)) {
				sheep.goalSelector.addGoal(3, new MoreTemptation(sheep, 1.0D, false, WHEATS));
			}
		}

		if (entity instanceof Pig) {
			Pig pig = (Pig) entity;
			if ((pig.getNavigation() instanceof GroundPathNavigation) || (pig.getNavigation() instanceof FlyingPathNavigation)) {
				pig.goalSelector.addGoal(4, new MoreTemptation(pig, 1.2D, false, PIGS));
			}
		}

	}
}
