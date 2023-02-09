package enemeez.simplefarming.common;

import com.mojang.logging.LogUtils;
import enemeez.simplefarming.common.registries.ModBlockEntities;
import enemeez.simplefarming.common.registries.ModBlocks;
import enemeez.simplefarming.common.registries.ModFeatures;
import enemeez.simplefarming.common.registries.ModItems;
import enemeez.simplefarming.common.registries.ModLootModifiers;
import enemeez.simplefarming.common.registries.ModMenus;
import enemeez.simplefarming.common.registries.ModPlacements;
import enemeez.simplefarming.common.registries.ModRecipes;
import enemeez.simplefarming.common.registries.ModSoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SimpleFarming.MOD_ID)
public class SimpleFarming {
    public static final String MOD_ID = "simplefarming";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SimpleFarming() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModFeatures.FOLIAGE_PLACER_TYPES.register(modEventBus);
        ModPlacements.PLACED_FEATURES.register(modEventBus);
        ModSoundEvents.SOUND_EVENTS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModMenus.MENU_TYPES.register(modEventBus);
        ModLootModifiers.GLOBAL_LOOT_MODIFIERS.register(modEventBus);
        ModRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::registerTab);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);

        LOGGER.info("Simple Farming setup complete!");
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        ModItems.COMPOSTABLES.forEach((item, chance) -> ComposterBlock.COMPOSTABLES.put(item.get(), chance));
    }

    private static CreativeModeTab creativeTab;

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == creativeTab) ModItems.ITEM_LIST.forEach(event::accept);
    }

    private void registerTab(CreativeModeTabEvent.Register event) {
        creativeTab = event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "creative_tab"), builder ->
            builder.title(Component.translatable("item_group." + MOD_ID))
                .icon(() -> new ItemStack(ModItems.TOMATO.get()))
        );
    }
}
