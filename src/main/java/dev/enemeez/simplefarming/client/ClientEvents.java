package dev.enemeez.simplefarming.client;

import java.util.List;
import dev.enemeez.simplefarming.client.gui.FermenterScreen;
import dev.enemeez.simplefarming.common.registries.ModMenus;
import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.registries.ModBlocks;
import dev.enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(modid = SimpleFarming.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenus.FERMENTER_MENU.get(), FermenterScreen::new);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.BlockTintSources event) {
        // 26.x tints blocks through BlockTintSources; these are the same sources vanilla uses for leaves and melon stems
        event.register(List.of(BlockTintSources.foliage()),
            ModBlocks.FOLIAGE_COLOR_BLOCKS.stream().map(DeferredHolder::get).toArray(Block[]::new)
        );
        event.register(List.of(BlockTintSources.stem()),
            ModBlocks.CANTALOUPE_STEM.get(), ModBlocks.HONEYDEW_STEM.get(), ModBlocks.SQUASH_STEM.get()
        );
        event.register(List.of(BlockTintSources.constant(0xFFE0C71C)),
            ModBlocks.ATTACHED_CANTALOUPE_STEM.get(), ModBlocks.ATTACHED_HONEYDEW_STEM.get(), ModBlocks.ATTACHED_SQUASH_STEM.get()
        );
    }

}
