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
	private static final Ingredient SEEDS = Ingredient.of(ModItems.cantaloupe_seeds.get(), ModItems.carrot_seeds.get(), ModItems.cassava_seeds.get(), ModItems.corn_seeds.get(), ModItems.cucumber_seeds.get(),
			ModItems.eggplant_seeds.get(), ModItems.honeydew_seeds.get(), ModItems.kenaf_seeds.get(), ModItems.lettuce_seeds.get(), ModItems.oat_seeds.get(), ModItems.onion_seeds.get(), ModItems.potato_seeds.get(), ModItems.pepper_seeds.get(),
			ModItems.radish_seeds.get(), ModItems.rice_seeds.get(), ModItems.rye_seeds.get(), ModItems.soybean_seeds.get(), ModItems.spinach_seeds.get(), ModItems.squash_seeds.get(), ModItems.tomato_seeds.get(), ModItems.yam_seeds.get(),
			ModItems.ginger_seeds.get(), ModItems.grape_seeds.get(), ModItems.cumin_seeds.get(), ModItems.quinoa_seeds.get(), ModItems.sorghum_seeds.get(), ModItems.peanut_seeds.get(), ModItems.barley_seeds.get(), ModItems.sunflower_seeds.get(),
			ModItems.pea_seeds.get(), ModItems.cotton_seeds.get(), ModItems.sweet_potato_seeds.get(), ModItems.broccoli_seeds.get(), ModItems.zucchini_seeds.get(), ModItems.turnip_seeds.get()
	);

	private static final Ingredient WHEATS = Ingredient.of(ModItems.barley.get(), ModItems.oat.get(), ModItems.rye.get(), ModItems.rice.get(), ModItems.corn.get(), ModItems.sorghum.get());

	private static final Ingredient PIGS = Ingredient.of(ModItems.sweet_potato.get(), ModItems.radish.get(), ModItems.turnip.get(), ModItems.yam.get());

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
