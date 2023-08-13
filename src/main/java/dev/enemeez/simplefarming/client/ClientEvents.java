package dev.enemeez.simplefarming.client;

import dev.enemeez.simplefarming.client.gui.FermenterScreen;
import dev.enemeez.simplefarming.common.registries.ModMenus;
import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.registries.ModBlocks;
import dev.enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SimpleFarming.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(ModMenus.FERMENTER_MENU.get(), FermenterScreen::new);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null
                ? BiomeColors.getAverageFoliageColor(pLevel, pPos)
                : FoliageColor.getDefaultColor(),
            ModBlocks.FOLIAGE_COLOR_BLOCKS.stream().map(RegistryObject::get).toArray(Block[]::new)
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

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(),
            ModItems.BLACKBERRY_BUSH.get(), ModItems.BLUEBERRY_BUSH.get(), ModItems.RASPBERRY_BUSH.get(), ModItems.STRAWBERRY_BUSH.get()
        );
    }
}
