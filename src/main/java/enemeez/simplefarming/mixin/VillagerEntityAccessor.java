package enemeez.simplefarming.mixin;

import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(VillagerEntity.class)
public interface VillagerEntityAccessor
{
    @Accessor("FOOD_VALUES")
    static void setFoodValues(Map<Item, Integer> foodValues) {}
}
