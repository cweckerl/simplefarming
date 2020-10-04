package enemeez.simplefarming.client;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
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
					if(index == 0) return world == null || pos == null ? FoliageColors.getDefault() : BiomeColors.getFoliageColor(world, pos);
					return -1;
				},
				ModBlocks.grape_leaves, ModBlocks.grape_leaves_base, ModBlocks.blackberry_bush, ModBlocks.blueberry_bush, ModBlocks.raspberry_bush, ModBlocks.strawberry_bush,
				ModBlocks.apple_leaves,	ModBlocks.apricot_leaves, ModBlocks.banana_leaves, ModBlocks.cherry_leaves, ModBlocks.mango_leaves, ModBlocks.olive_leaves,
				ModBlocks.orange_leaves, ModBlocks.plum_leaves,	ModBlocks.pear_leaves
		);
	}

	@SubscribeEvent
	public static void itemColors(ColorHandlerEvent.Item event) {
		event.getItemColors().register(
				(stack, tintIndex) -> FoliageColors.getDefault(),
				ModBlocks.blackberry_bush, ModBlocks.blueberry_bush, ModBlocks.raspberry_bush, ModBlocks.strawberry_bush
		);
	}
}
