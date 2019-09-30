package enemeez.simplefarming.blocks;

import static enemeez.simplefarming.init.ModTileEntities.brewing_barrel_tile;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class BrewingBarrelBlockTile extends TileEntity implements ITickableTileEntity{

	public BrewingBarrelBlockTile() {
		super(brewing_barrel_tile);
	}

	@Override
	public void tick() {
		if (!world.isRemote)
		{
			System.out.println("yeeee");
		}
		
	}

}
