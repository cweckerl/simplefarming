package enemeez.simplefarming.events;

import enemeez.simplefarming.item.AlcoholItem;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;

public class IntoxicationTracker {
	private ArrayList<ItemStack> foods = new ArrayList<ItemStack>();

	@SubscribeEvent
	public void intoxicationEffect(LivingEntityUseItemEvent.Finish event) {
		if (!event.getEntityLiving().level.isClientSide()) {
			ItemStack consumed = event.getItem();
			foods.add(consumed);
			if (drunk()) {
				ArrayList<MobEffectInstance> effects = new ArrayList<MobEffectInstance>();
				effects.add(new MobEffectInstance(MobEffects.WEAKNESS, 2000, 0, false, true));
				effects.add(new MobEffectInstance(MobEffects.BLINDNESS, 2000, 0, false, true));
				effects.add(new MobEffectInstance(MobEffects.WITHER, 2000, 0, false, true));
				effects.add(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2000, 0, false, true));
				effects.add(new MobEffectInstance(MobEffects.HUNGER, 2000, 0, false, true));
				effects.add(new MobEffectInstance(MobEffects.POISON, 2000, 0, false, true));
				effects.add(new MobEffectInstance(MobEffects.UNLUCK, 2000, 0, false, true));
				int random = (int) ((Math.random() * effects.size()));
				event.getEntity().sendMessage(new TextComponent("You start to feel tipsy..."), null);
				event.getEntityLiving().addEffect(effects.get(random));
				foods.clear();
			}
		}
	}

	private boolean drunk() {
		boolean drunk = false;
		if (foods.size() >= 3) {
			for (int i = 0; i < foods.size() - 2; i++) {
				if (foods.get(i).getItem() instanceof AlcoholItem && foods.get(i + 1).getItem() instanceof AlcoholItem
						&& foods.get(i + 2).getItem() instanceof AlcoholItem) {
					drunk = true;
					break;
				}
			}
		}
		return drunk;
	}

}
