package enemeez.simplefarming.events;

import java.util.ArrayList;

import enemeez.simplefarming.item.AlcoholItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class IntoxicationTracker {
	private ArrayList<ItemStack> foods = new ArrayList<ItemStack>();

	@SubscribeEvent
	public void intoxicationEffect(LivingEntityUseItemEvent.Finish event) {
		if (!event.getEntityLiving().world.isRemote()) {
			ItemStack consumed = event.getItem();
			foods.add(consumed);
			if (drunk()) {
				ArrayList<EffectInstance> effects = new ArrayList<EffectInstance>();
				effects.add(new EffectInstance(Effects.WEAKNESS, 2000, 0, false, true));
				effects.add(new EffectInstance(Effects.BLINDNESS, 2000, 0, false, true));
				effects.add(new EffectInstance(Effects.WITHER, 2000, 0, false, true));
				effects.add(new EffectInstance(Effects.MINING_FATIGUE, 2000, 0, false, true));
				effects.add(new EffectInstance(Effects.HUNGER, 2000, 0, false, true));
				effects.add(new EffectInstance(Effects.POISON, 2000, 0, false, true));
				effects.add(new EffectInstance(Effects.NAUSEA, 2000, 0, false, true));
				effects.add(new EffectInstance(Effects.UNLUCK, 2000, 0, false, true));
				int random = (int) ((Math.random() * effects.size()));
				event.getEntity().sendMessage(new StringTextComponent("You start to feel tipsy..."));
				event.getEntityLiving().addPotionEffect(effects.get(random));
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
