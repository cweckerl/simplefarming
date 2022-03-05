package enemeez.simplefarming.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class DrinkItem extends BottleItem {

	public DrinkItem(Properties builder) {
		super(builder);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		if (!worldIn.isClientSide)
			entityLiving.curePotionEffects(stack);
		if (entityLiving instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
			serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
		}

		if (entityLiving instanceof Player && !((Player) entityLiving).isCreative()) {
			stack.shrink(1);
		}

		if (!worldIn.isClientSide) {
			((Player) entityLiving).getFoodData().eat(1, 0F);
			entityLiving.removeAllEffects();
		}

		if (entityLiving == null || !((Player) entityLiving).isCreative()) {
			if (stack.isEmpty()) {
				return new ItemStack(Items.GLASS_BOTTLE);
			}

			if (entityLiving != null) {
				((Player) entityLiving).addItem(new ItemStack(Items.GLASS_BOTTLE));
			}
		}

		return stack;
	}
}
