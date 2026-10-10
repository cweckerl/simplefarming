package dev.enemeez.simplefarming.common;

import dev.enemeez.simplefarming.common.registries.ModBlocks;
import dev.enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import dev.enemeez.simplefarming.common.item.crafting.FermenterRecipe;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.stream.Stream;

@EventBusSubscriber(modid = SimpleFarming.MOD_ID)
public class CommonEvents {
    @SubscribeEvent
    public static void cancelTrample(BlockEvent.FarmlandTrampleEvent event) {
        final var pos = event.getPos();
        event.setCanceled(
            BlockPos.betweenClosedStream(pos.offset(new Vec3i(-5, 1, -5)), pos.offset(new Vec3i(5, 1, 5)))
                .anyMatch(tmpPos -> event.getLevel().getBlockState(tmpPos).getBlock() == ModBlocks.SCARECROW.get())
        );
    }

    @SubscribeEvent
    public static void addEntityGoal(EntityJoinLevelEvent event) {
        final Ingredient GRAINS = Ingredient.of(
            ModItems.BARLEY.get(),
            ModItems.OAT.get(),
            ModItems.RYE.get(),
            ModItems.RICE.get(),
            ModItems.CORN.get(),
            ModItems.SORGHUM.get()
        );
        final Ingredient ROOTS = Ingredient.of(
            ModItems.ONION.get(),
            ModItems.SWEET_POTATO.get(),
            ModItems.RADISH.get(),
            ModItems.TURNIP.get(),
            ModItems.YAM.get()
        );

        var entity = event.getEntity();
        var entityType = entity.getType();

        if (entityType == EntityTypes.CHICKEN) {
            ((Chicken) entity).goalSelector.addGoal(3, new TemptGoal((Chicken) entity, 1.0D,
                Ingredient.of(ModItems.SEEDS.stream().map(DeferredHolder::get)), false)
            );
        } else if (entityType == EntityTypes.COW) {
            ((Cow) entity).goalSelector.addGoal(3, new TemptGoal((Cow) entity, 1.25D, GRAINS, false));
        } else if (entityType == EntityTypes.SHEEP) {
            ((Sheep) entity).goalSelector.addGoal(3, new TemptGoal((Sheep) entity, 1.1D, GRAINS, false));
        } else if (entityType == EntityTypes.PIG) {
            ((Pig) entity).goalSelector.addGoal(3, new TemptGoal((Pig) entity, 1.2D, ROOTS, false));
        }
    }

    @SubscribeEvent
    public static void syncRecipes(OnDatapackSyncEvent event) {
        // Clients only get the recipe types the server sends them since 1.21.2 (used by JEI)
        event.sendRecipes(FermenterRecipe.Type.INSTANCE);
    }

}
