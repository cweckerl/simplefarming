package dev.enemeez.simplefarming.common.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import org.jetbrains.annotations.Nullable;

public class RootCropItem extends AnimalFoodItem {
    public RootCropItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    protected Animal getValidAnimal(LivingEntity entity) {
        return entity.getType() == EntityType.PIG ? (Pig) entity : null;
    }
}
