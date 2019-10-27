package enemeez.simplefarming.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class AlcoholItem extends BottleItem {

	private String name;

	public AlcoholItem(Properties builder, String name) {
		super(builder);
		this.name = name;
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if (!worldIn.isRemote)
			entityLiving.curePotionEffects(stack);
		if (entityLiving instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
			serverplayerentity.addStat(Stats.ITEM_USED.get(this));
		}

		if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
			stack.shrink(1);
		}

		if (!worldIn.isRemote) {
			if (name == "beer")
				entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 500, 0, false, true));
			if (name == "cauim")
				entityLiving.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 500, 0, false, true));
			if (name == "cider")
				entityLiving.addPotionEffect(new EffectInstance(Effects.LUCK, 500, 0, false, true));
			if (name == "sake")
				entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, 500, 0, false, true));
			if (name == "tiswin")
				entityLiving.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 500, 0, false, true));
			if (name == "vodka")
				entityLiving.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 500, 0, false, true));
			if (name == "whiskey")
				entityLiving.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 500, 0, false, true));
			if (name == "wine")
				entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 500, 0, false, true));
		}

		if (entityLiving == null || !((PlayerEntity) entityLiving).isCreative()) {
			if (stack.isEmpty()) {
				return new ItemStack(Items.GLASS_BOTTLE);
			}

			if (entityLiving != null) {
				((PlayerEntity) entityLiving).addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
			}
		}

		return stack;
	}

}
