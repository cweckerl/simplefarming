package enemeez.simplefarming.init;

import java.util.function.Supplier;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.blocks.BrewingBarrelBlockTile;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
	
	public static TileEntityType<BrewingBarrelBlockTile> brewing_barrel_tile;
	
	public static void registerAll(RegistryEvent.Register<TileEntityType<?>> event)
	{
		brewing_barrel_tile = register("brewing_barrel_tile", BrewingBarrelBlockTile::new, ModBlocks.brewing_barrel);
	}
	
	private static <T extends TileEntity> TileEntityType<T> register(String name, Supplier<T> tileFactory, Block... blocks) {
        TileEntityType<T> type = TileEntityType.Builder.create(tileFactory, blocks).build(null);
        return register(name, type);
    }

    private static <T extends TileEntity> TileEntityType<T> register(String name, TileEntityType<T> type) {
        if (type.getRegistryName() == null) {
            type.setRegistryName(SimpleFarming.getId(name));
        }
        ForgeRegistries.TILE_ENTITIES.register(type);
        return type;
    }

}
