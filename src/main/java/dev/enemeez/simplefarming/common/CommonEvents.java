package dev.enemeez.simplefarming.common;

import dev.enemeez.simplefarming.common.registries.ModBlocks;
import dev.enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = SimpleFarming.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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

        if (entityType == EntityType.CHICKEN) {
            ((Chicken) entity).goalSelector.addGoal(3, new TemptGoal((Chicken) entity, 1.0D,
                Ingredient.of(ModItems.SEEDS.stream().map(RegistryObject::get).map(ItemStack::new)), false)
            );
        } else if (entityType == EntityType.COW) {
            ((Cow) entity).goalSelector.addGoal(3, new TemptGoal((Cow) entity, 1.25D, GRAINS, false));
        } else if (entityType == EntityType.SHEEP) {
            ((Sheep) entity).goalSelector.addGoal(3, new TemptGoal((Sheep) entity, 1.1D, GRAINS, false));
        } else if (entityType == EntityType.PIG) {
            ((Pig) entity).goalSelector.addGoal(3, new TemptGoal((Pig) entity, 1.2D, ROOTS, false));
        }
    }

    @SubscribeEvent
    public static void addTrade(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Stream.of(
                ModItems.FIBER_SEED_PACKET.get(),
                ModItems.FRUIT_SEED_PACKET.get(),
                ModItems.GOURD_SEED_PACKET.get(),
                ModItems.GRAIN_SEED_PACKET.get(),
                ModItems.LEAFY_SEED_PACKET.get(),
                ModItems.LEGUME_SEED_PACKET.get(),
                ModItems.ROOT_SEED_PACKET.get(),
                ModItems.TUBER_SEED_PACKET.get()
            ).forEach(packet -> event.getTrades().get(1).add((entity, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(packet, 1),
                16,
                2,
                0.05F
            )));
        }
    }
}
