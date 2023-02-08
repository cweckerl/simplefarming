package enemeez.simplefarming.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public abstract class AnimalFoodItem extends Item {

    public AnimalFoodItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    protected abstract Animal getValidAnimal(LivingEntity entity);

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        Animal entity = getValidAnimal(pInteractionTarget);

        if (entity != null) {
            ItemUtil.mobInteract(pStack, pPlayer, entity);
        }

        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }
}
