package enemeez.simplefarming.init;

import enemeez.simplefarming.block.BrewingBarrelBlock;
import enemeez.simplefarming.tileentity.BrewingBarrelTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTiles {
	@ObjectHolder("simplefarming:brewing_barrel")
	public static BrewingBarrelBlock BARREL;

	@ObjectHolder("simplefarming:brewing_barrel")
	public static TileEntityType<BrewingBarrelTileEntity> BARREL_TILE;

	@SubscribeEvent
	public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().register(TileEntityType.Builder.create(BrewingBarrelTileEntity::new, ModTiles.BARREL)
				.build(null).setRegistryName("brewing_barrel"));
	}
}
