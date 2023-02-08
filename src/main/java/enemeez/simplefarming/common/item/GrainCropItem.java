package enemeez.simplefarming.common.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import org.jetbrains.annotations.Nullable;

public class GrainCropItem extends AnimalFoodItem {

    public GrainCropItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    protected Animal getValidAnimal(LivingEntity entity) {
        if (entity.getType() == EntityType.COW) {
            return (Cow) entity;
        } else if (entity.getType() == EntityType.SHEEP) {
            return (Sheep) entity;
        }
        return null;
    }
}
