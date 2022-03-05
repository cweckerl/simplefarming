package enemeez.simplefarming.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GrainItem extends Item {
	public GrainItem(Properties properties) {
		super(properties);

	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack itemstack, Player player, LivingEntity entity, InteractionHand hand) {

		ItemStack stack = player.getItemInHand(hand);

		if (!entity.level.isClientSide && !entity.isBaby() && entity instanceof AgeableMob && (int) ((AgeableMob) entity).getAge() == 0) {
			if (entity instanceof Cow) {
				if (((Cow) entity).isInLove()) {
					return InteractionResult.FAIL;
				} else {
					((Cow) entity).setInLove(player);
					if (!player.isCreative())
						stack.shrink(1);
					return InteractionResult.SUCCESS;
				}
			}

			if (entity instanceof Sheep) {
				if (((Sheep) entity).isInLove()) {
					return InteractionResult.FAIL;
				} else {
					((Sheep) entity).setInLove(player);
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
