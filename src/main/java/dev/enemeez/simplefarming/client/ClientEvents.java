package dev.enemeez.simplefarming.client;

import java.util.List;
import dev.enemeez.simplefarming.client.gui.FermenterScreen;
import dev.enemeez.simplefarming.common.registries.ModMenus;
import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.registries.ModBlocks;
import dev.enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SimpleFarming.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.register(ModMenus.FERMENTER_MENU.get(), FermenterScreen::new));
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        // 26.x tints blocks through BlockTintSources; these are the same sources vanilla uses for leaves and melon stems
        event.register(List.of(BlockTintSources.foliage()),
            ModBlocks.FOLIAGE_COLOR_BLOCKS.stream().map(RegistryObject::get).toArray(Block[]::new)
        );
        event.register(List.of(BlockTintSources.stem()),
            ModBlocks.CANTALOUPE_STEM.get(), ModBlocks.HONEYDEW_STEM.get(), ModBlocks.SQUASH_STEM.get()
        );
        event.register(List.of(BlockTintSources.constant(0xFFE0C71C)),
            ModBlocks.ATTACHED_CANTALOUPE_STEM.get(), ModBlocks.ATTACHED_HONEYDEW_STEM.get(), ModBlocks.ATTACHED_SQUASH_STEM.get()
        );
    }

}
