package enemeez.simplefarming.item;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

public class GrainItem extends Item {
	public GrainItem(Properties properties) {
		super(properties);

	}

	@Override
	public ActionResultType itemInteractionForEntity(ItemStack itemstack, PlayerEntity player, LivingEntity entity, Hand hand) {

		ItemStack stack = player.getHeldItem(hand);

		if (!entity.world.isRemote && !entity.isChild() && entity instanceof AgeableEntity && (int) ((AgeableEntity) entity).getGrowingAge() == 0) {
			if (entity instanceof CowEntity) {
				if (((CowEntity) entity).isInLove()) {
					return ActionResultType.FAIL;
				} else {
					((CowEntity) entity).setInLove(player);
					if (!player.isCreative())
						stack.shrink(1);
					return ActionResultType.SUCCESS;
				}
			}

			if (entity instanceof SheepEntity) {
				if (((SheepEntity) entity).isInLove()) {
					return ActionResultType.FAIL;
				} else {
					((SheepEntity) entity).setInLove(player);
					if (!player.isCreative())
						stack.shrink(1);
					return ActionResultType.SUCCESS;
				}
			}
		}

		if (entity.isChild()) {
			if (!player.isCreative())
				stack.shrink(1);
			((AgeableEntity) entity).ageUp((int) ((float) (-((AgeableEntity) entity).getGrowingAge() / 20) * 0.1F), true);
			return ActionResultType.SUCCESS;
		}

		return ActionResultType.FAIL;

	}
}
