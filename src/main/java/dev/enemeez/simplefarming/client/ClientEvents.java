package dev.enemeez.simplefarming.client;

import dev.enemeez.simplefarming.client.gui.FermenterScreen;
import dev.enemeez.simplefarming.common.registries.ModMenus;
import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.registries.ModBlocks;
import dev.enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;
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
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null
                ? BiomeColors.getAverageFoliageColor(pLevel, pPos)
                : FoliageColor.FOLIAGE_DEFAULT,
            ModBlocks.FOLIAGE_COLOR_BLOCKS.stream().map(DeferredHolder::get).toArray(Block[]::new)
        );

        event.getBlockColors().register((pState, pLevel, pPos, pTintIndex) -> {
                int i = pState.getValue(StemBlock.AGE);
                int j = i * 32;
                int k = 255 - i * 8;
                int l = i * 4;
                return j << 16 | k << 8 | l;
            }, ModBlocks.CANTALOUPE_STEM.get(), ModBlocks.HONEYDEW_STEM.get(), ModBlocks.SQUASH_STEM.get()
        );

        event.getBlockColors().register((pState, pLevel, pPos, pTintIndex) -> 14_731_036,
            ModBlocks.ATTACHED_CANTALOUPE_STEM.get(), ModBlocks.ATTACHED_HONEYDEW_STEM.get(), ModBlocks.ATTACHED_SQUASH_STEM.get()
        );
    }
}
