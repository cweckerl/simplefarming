package enemeez.simplefarming.tileentity;

import static enemeez.simplefarming.init.ModTiles.BARREL_TILE;

import net.minecraft.inventory.IClearable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class SingleItemTileEntity extends TileEntity implements IClearable {

	private Item inventory = ItemStack.EMPTY.getItem();
	private int capacity = 0;

	public SingleItemTileEntity() {
		super(BARREL_TILE);
	}

	public Item getItem() {
		return this.inventory;
	}

	public void setItem(Item item) {
		this.inventory = item;
		capacity++;
		this.markDirty();
	}

	public void clear() {
		this.setItem(ItemStack.EMPTY.getItem());
		capacity = 0;
	}

	public int getCapacity() {
		return capacity;
	}
}
