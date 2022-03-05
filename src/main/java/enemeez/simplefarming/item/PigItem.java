package enemeez.simplefarming.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PigItem extends Item {
	public PigItem(Properties properties) {
		super(properties);

	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack itemstack, Player player, LivingEntity entity, InteractionHand hand) {

		ItemStack stack = player.getItemInHand(hand);

		if (!entity.level.isClientSide && !entity.isBaby() && entity instanceof AgeableMob && (int) ((AgeableMob) entity).getAge() == 0) {
			if (entity instanceof Pig) {
				if (((Pig) entity).isInLove()) {
					return InteractionResult.FAIL;
				} else {
					((Pig) entity).setInLove(player);
					if (!player.isCreative())
						stack.shrink(1);
					return InteractionResult.SUCCESS;
				}
			}
		}

		if (entity.isBaby()) {
			if (!player.isCreative())
				stack.shrink(1);
			((AgeableMob) entity).ageUp((int) ((float) (-((AgeableMob) entity).getAge() / 20) * 0.1F), true);
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;

	}

}
