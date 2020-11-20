package enemeez.simplefarming.mixin;

import enemeez.simplefarming.util.FarmingVillagerUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin extends AbstractVillagerEntity
{
    @Shadow public abstract VillagerData getVillagerData();

    public VillagerEntityMixin(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
        super(type, worldIn);
    }

    // can the villager pick up the item
    @Inject(method = "func_230293_i_", at = @At("HEAD"), cancellable = true)
    protected void onFunc_230293_i_(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Item item = stack.getItem();
        // for now we only allow seeds, food crops or grain ears to be picked up by villagers
        // but every villager can pick up eatable crops and bread
        if ((Tags.Items.CROPS.contains(item) && item.isFood()) || FarmingVillagerUtil.SIMPLE_BREAD_INGREDIENT_MAP.containsKey(item)) {
            cir.setReturnValue(true);
        }
        else if (getVillagerData().getProfession() == VillagerProfession.FARMER && (FarmingVillagerUtil.isCropPlantSeed(item, world) || FarmingVillagerUtil.SIMPLE_BREAD_INGREDIENT_MAP.containsValue(item))) { //use unique tag instead?
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "isFarmItemInInventory", at = @At("HEAD"), cancellable = true)
    protected void onIsFarmItemInInventory(CallbackInfoReturnable<Boolean> cir) {
        Inventory inv = getVillagerInventory();
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (Tags.Items.SEEDS.contains(stack.getItem()) && stack.getCount() > 0) {
                cir.setReturnValue(true);
                break;
            }
        }
    }
}
