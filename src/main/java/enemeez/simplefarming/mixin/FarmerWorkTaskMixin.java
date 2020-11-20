package enemeez.simplefarming.mixin;

import enemeez.simplefarming.util.FarmingVillagerUtil;
import net.minecraft.entity.ai.brain.task.FarmerWorkTask;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(FarmerWorkTask.class)
public abstract class FarmerWorkTaskMixin
{
    @Inject(method = "bakeBread", at = @At("HEAD"), cancellable = true)
    protected void onBakeBread(VillagerEntity villager, CallbackInfo ci) {
        Inventory inv = villager.getVillagerInventory();

        int anyBeadCount = 0;
        for (int j = 0; j < inv.getSizeInventory(); ++j) {
            ItemStack stack = inv.getStackInSlot(j);
            Item item = stack.getItem();
            if (FarmingVillagerUtil.SIMPLE_BREAD_INGREDIENT_MAP.containsKey(item)) {
                anyBeadCount += stack.getCount();
            }
        }

        if (anyBeadCount <= 36) {
            for (Map.Entry<Item, Item> entry : FarmingVillagerUtil.SIMPLE_BREAD_INGREDIENT_MAP.entrySet()) {
                if (FarmingVillagerUtil.tryToBakeSpecificBread(villager, entry.getKey(), entry.getValue())) {
                    ci.cancel();
                    break;
                }
            }
        }
    }
}
