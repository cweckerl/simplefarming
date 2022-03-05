package enemeez.simplefarming.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class AlcoholItem extends BottleItem {

	private String name;

	public AlcoholItem(Properties builder, String name) {
		super(builder);
		this.name = name;
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
			entityLiving.addEffect(getEffect(name));
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

	private MobEffectInstance getEffect(String name) {
		switch (name) {
		case "beer":
			return new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 0, false, true);
		case "cauim":
			return new MobEffectInstance(MobEffects.JUMP, 500, 0, false, true);
		case "cider":
			return new MobEffectInstance(MobEffects.LUCK, 500, 0, false, true);
		case "sake":
			return new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0, false, true);
		case "tiswin":
			return new MobEffectInstance(MobEffects.HEALTH_BOOST, 500, 0, false, true);
		case "vodka":
			return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0, false, true);
		case "whiskey":
			return new MobEffectInstance(MobEffects.ABSORPTION, 500, 0, false, true);
		case "mead":
			return new MobEffectInstance(MobEffects.DIG_SPEED, 500, 0, false, true);
		default:
			return new MobEffectInstance(MobEffects.REGENERATION, 500, 0, false, true);
		}
	}

}
