package dev.enemeez.simplefarming.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.function.Consumer;

public class AlcoholItem extends Item {
    private final Holder<MobEffect> EFFECT;

    public AlcoholItem(Properties pProperties, Holder<MobEffect> effect) {
        // Drinking (2 s, drink animation/sound), the 30 s effect and returning the bottle are all data components now
        super(pProperties
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .component(DataComponents.CONSUMABLE, Consumables.defaultDrink()
                .consumeSeconds(2.0F)
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(effect, 600)))
                .build())
        );
        this.EFFECT = effect;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, TooltipDisplay pDisplay, Consumer<Component> pTooltipAdder, TooltipFlag pIsAdvanced) {
        pTooltipAdder.accept(Component.translatable(EFFECT.value().getDescriptionId()).withStyle(ChatFormatting.GREEN));
    }
}
