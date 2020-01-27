package enemeez.simplefarming.item;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class PigItem extends Item {
	public PigItem(Properties properties) {
		super(properties);

	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, PlayerEntity player,
			LivingEntity entity, Hand hand) {

		ItemStack stack = player.getHeldItem(hand);

		if (!entity.world.isRemote && !entity.isChild() && entity instanceof AgeableEntity && (int) ((AgeableEntity) entity).getGrowingAge() == 0) {
			if (entity instanceof PigEntity) {
				if (((PigEntity) entity).isInLove()) {
					return false;
				} else {
					((PigEntity) entity).setInLove(player);
					if (!player.isCreative())
						stack.shrink(1);
					return true;
				}

			}

		}

		if (entity.isChild()) {
			if (!player.isCreative())
				stack.shrink(1);
			((AgeableEntity) entity).ageUp((int) ((float) (-((AgeableEntity) entity).getGrowingAge() / 20) * 0.1F),
					true);
			return true;
		}

		return false;

	}

}
