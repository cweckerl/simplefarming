package enemeez.simplefarming.common.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

class ItemUtil {

    protected static int convertRGBToInt(short r, short g, short b) {
        return 0x10000 * r + 0x100 * g + b;
    }

    protected static void usePlayerItem(Player pPlayer, ItemStack pStack) {
        if (!pPlayer.getAbilities().instabuild) {
            pStack.shrink(1);
        }
    }

    protected static InteractionResult mobInteract(ItemStack pStack, Player pPlayer, Animal animal) {
        final int AGE = animal.getAge();
        if (!pPlayer.level().isClientSide && AGE == 0 && animal.canFallInLove()) {
            usePlayerItem(pPlayer, pStack);
            animal.setInLove(pPlayer);
            return InteractionResult.SUCCESS;
        } else if (animal.isBaby()) {
            usePlayerItem(pPlayer, pStack);
            animal.ageUp(AgeableMob.getSpeedUpSecondsWhenFeeding(-AGE), true);
            return InteractionResult.sidedSuccess(pPlayer.level().isClientSide);
        }

        if (pPlayer.level().isClientSide) {
            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }
}
