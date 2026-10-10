package dev.enemeez.simplefarming.common.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.animal.sheep.Sheep;
import org.jetbrains.annotations.Nullable;

public class GrainCropItem extends AnimalFoodItem {

    public GrainCropItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    protected Animal getValidAnimal(LivingEntity entity) {
        if (entity.getType() == EntityTypes.COW) {
            return (Cow) entity;
        } else if (entity.getType() == EntityTypes.SHEEP) {
            return (Sheep) entity;
        }
        return null;
    }
}
