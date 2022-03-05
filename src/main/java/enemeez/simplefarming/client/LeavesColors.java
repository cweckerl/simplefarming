package enemeez.simplefarming.client;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SimpleFarming.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class LeavesColors {

	@SubscribeEvent
	public static void leavesColors(ColorHandlerEvent.Block event) {
		event.getBlockColors().register(
				(state, world, pos, index) -> {
					if(index == 0) return world == null || pos == null ? FoliageColor.getDefaultColor() : BiomeColors.getAverageFoliageColor(world, pos);
					return -1;
				},
				ModBlocks.GRAPE_LEAVES.get(), ModBlocks.GRAPE_LEAVES_BASE.get(), ModBlocks.BLACKBERRY_BUSH.get(), ModBlocks.BLUEBERRY_BUSH.get(), ModBlocks.RASPBERRY_BUSH.get(), ModBlocks.STRAWBERRY_BUSH.get(),
				ModBlocks.APPLE_LEAVES.get(),	ModBlocks.APRICOT_LEAVES.get(), ModBlocks.BANANA_LEAVES.get(), ModBlocks.CHERRY_LEAVES.get(), ModBlocks.MANGO_LEAVES.get(), ModBlocks.OLIVE_LEAVES.get(),
				ModBlocks.ORANGE_LEAVES.get(), ModBlocks.PLUM_LEAVES.get(),	ModBlocks.PEAR_LEAVES.get()
		);
	}

	@SubscribeEvent
	public static void itemColors(ColorHandlerEvent.Item event) {
		event.getItemColors().register(
				(stack, tintIndex) -> FoliageColor.getDefaultColor(),
				ModBlocks.BLACKBERRY_BUSH.get(), ModBlocks.BLUEBERRY_BUSH.get(), ModBlocks.RASPBERRY_BUSH.get(), ModBlocks.STRAWBERRY_BUSH.get()
		);
	}
}
