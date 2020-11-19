package enemeez.simplefarming.mixin;

import net.minecraft.entity.ai.brain.task.FarmerWorkTask;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Collections;
import java.util.List;

@Mixin(FarmerWorkTask.class)
public interface FarmerWorkTaskAccessor
{
    @Accessor("field_234014_b_")
    static void setCompostableItems(List<Item> compostableItems) {}

    @Accessor("field_234014_b_")
    static List<Item> getCompostableItems() {
        return Collections.emptyList(); // method body is ignored, this is only here to prevent warnings
    }
}
