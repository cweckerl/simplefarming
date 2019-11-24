package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.blocks.brewingbarrel.BrewingBarrelContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModContainers {
	/*
	@ObjectHolder("simplefarming:brewing_barrel")
	public static final ContainerType<BrewingBarrelContainer> BARREL_CONTAINER = null;

	@SubscribeEvent
	public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
			BlockPos pos = data.readBlockPos();
			return new BrewingBarrelContainer(windowId, inv, pos, inv);
		}).setRegistryName(SimpleFarming.MOD_ID, "brewing_barrel"));
	}
	*/
}
