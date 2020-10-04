package enemeez.simplefarming.events;

import enemeez.simplefarming.entities.ai.MoreTemptation;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TemptationTask {

	private static final Ingredient SEEDS = Ingredient.fromItems(ModItems.cantaloupe_seeds, ModItems.carrot_seeds, ModItems.cassava_seeds, ModItems.corn_seeds, ModItems.cucumber_seeds,
			ModItems.eggplant_seeds, ModItems.honeydew_seeds, ModItems.kenaf_seeds, ModItems.lettuce_seeds, ModItems.oat_seeds, ModItems.onion_seeds, ModItems.potato_seeds, ModItems.pepper_seeds,
			ModItems.radish_seeds, ModItems.rice_seeds, ModItems.rye_seeds, ModItems.soybean_seeds, ModItems.spinach_seeds, ModItems.squash_seeds, ModItems.tomato_seeds, ModItems.yam_seeds,
			ModItems.ginger_seeds, ModItems.grape_seeds, ModItems.cumin_seeds, ModItems.quinoa_seeds, ModItems.sorghum_seeds, ModItems.peanut_seeds, ModItems.barley_seeds, ModItems.sunflower_seeds,
			ModItems.pea_seeds, ModItems.cotton_seeds, ModItems.sweet_potato_seeds, ModItems.broccoli_seeds, ModItems.zucchini_seeds, ModItems.turnip_seeds
	);

	private static final Ingredient WHEATS = Ingredient.fromItems(ModItems.barley, ModItems.oat, ModItems.rye, ModItems.rice, ModItems.corn, ModItems.sorghum);

	private static final Ingredient PIGS = Ingredient.fromItems(ModItems.sweet_potato, ModItems.radish, ModItems.turnip, ModItems.yam);

	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();

		if (entity instanceof ChickenEntity) {
			ChickenEntity chicken = (ChickenEntity) entity;
			chicken.goalSelector.addGoal(3, new MoreTemptation(chicken, 1.0D, false, SEEDS));
		}

		if (entity instanceof CowEntity) {
			CowEntity cow = (CowEntity) entity;
			cow.goalSelector.addGoal(3, new MoreTemptation(cow, 1.25D, false, WHEATS));
		}

		if (entity instanceof SheepEntity) {
			SheepEntity sheep = (SheepEntity) entity;
			sheep.goalSelector.addGoal(3, new MoreTemptation(sheep, 1.0D, false, WHEATS));
		}

		if (entity instanceof PigEntity) {
			PigEntity pig = (PigEntity) entity;
			pig.goalSelector.addGoal(4, new MoreTemptation(pig, 1.2D, false, PIGS));
		}

	}
}
