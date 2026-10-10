package dev.enemeez.simplefarming.common;

import com.mojang.logging.LogUtils;
import dev.enemeez.simplefarming.common.registries.ModBlockEntities;
import dev.enemeez.simplefarming.common.registries.ModCreativeTabs;
import dev.enemeez.simplefarming.common.registries.ModMenus;
import dev.enemeez.simplefarming.common.registries.ModPlacements;
import dev.enemeez.simplefarming.common.registries.ModRecipes;
import dev.enemeez.simplefarming.common.registries.ModSoundEvents;
import dev.enemeez.simplefarming.common.registries.ModBlocks;
import dev.enemeez.simplefarming.common.registries.ModFeatures;
import dev.enemeez.simplefarming.common.registries.ModItems;
import dev.enemeez.simplefarming.common.registries.ModLootModifiers;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.bus.api.IEventBus;
import dev.enemeez.simplefarming.common.data.Config;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import org.slf4j.Logger;

@Mod(SimpleFarming.MOD_ID)
public class SimpleFarming {
    public static final String MOD_ID = "simplefarming";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SimpleFarming(IEventBus modEventBus, ModContainer modContainer) {
        // Food values are read while items register, so the config must be loaded first (STARTUP configs load immediately)
        modContainer.registerConfig(ModConfig.Type.STARTUP, Config.CONFIG_SPEC, MOD_ID + ".toml");

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModFeatures.FOLIAGE_PLACER_TYPES.register(modEventBus);
        ModPlacements.PLACED_FEATURES.register(modEventBus);
        ModSoundEvents.SOUND_EVENTS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModMenus.MENU_TYPES.register(modEventBus);
        ModLootModifiers.GLOBAL_LOOT_MODIFIERS.register(modEventBus);
        ModRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        ModRecipes.RECIPE_TYPES.register(modEventBus);
        ModCreativeTabs.CREATIVE_TABS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerCapabilities);

        LOGGER.info("Simple Farming setup complete!");
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        ModItems.COMPOSTABLES.forEach((item, chance) -> ComposterBlock.COMPOSTABLES.put(item.get(), chance));
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModBlockEntities.FERMENTER.get(),
            (fermenter, side) -> side == null ? null : new SidedInvWrapper(fermenter, side)
        );
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeTabs.TAB.get()) ModItems.ITEM_LIST.forEach(item -> event.accept(item.get()));
    }
}
