package enemeez.simplefarming.entities.ai;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.crafting.Ingredient;

public class MoreTemptation extends TemptGoal {
	public MoreTemptation(PathfinderMob creatureIn, double speedIn, boolean bool, Ingredient temptItemsIn) {
		super(creatureIn, speedIn, temptItemsIn, bool);
	}

}
