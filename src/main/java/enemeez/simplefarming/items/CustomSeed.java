package enemeez.simplefarming.items;

import net.minecraft.block.Block;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemStack;

public class CustomSeed extends BlockNamedItem {

	public CustomSeed(Block blockIn, Properties properties) {
		super(blockIn, properties);
	}

	public boolean itemInteractionForEntity(ItemStack itemstack, PlayerEntity player,
			net.minecraft.entity.LivingEntity entity, net.minecraft.util.Hand hand) {

		ItemStack stack = player.getHeldItem(hand);

		if (!entity.world.isRemote && !entity.isChild() && (int) ((AgeableEntity) entity).getGrowingAge() == 0) {
			if (entity instanceof ChickenEntity) {
				if (((ChickenEntity) entity).isInLove()) {
					return false;
				} else {
					((ChickenEntity) entity).setInLove(player);
					if (!player.isCreative())
						stack.shrink(1);
					return true;
				}

			}

			if (entity instanceof ParrotEntity)
				if (!entity.world.isRemote) {
					if (!((ParrotEntity) entity).isTamed())
						if (Math.random() <= 0.33) {
							((ParrotEntity) entity).setTamedBy(player);
							((ParrotEntity) entity).setInLove(player);
						}
					if (!player.isCreative())
						stack.shrink(1);
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
