package enemeez.simplefarming.tiles;

import static enemeez.simplefarming.init.ModTiles.BARREL_TILE;

import net.minecraft.inventory.IClearable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class BrewingBarrelTile extends TileEntity implements IClearable {

	private Item inventory = ItemStack.EMPTY.getItem();
	private int capacity = 0;

	public BrewingBarrelTile() {
		super(BARREL_TILE);
	}

	public Item getItem() {
		return this.inventory;
	}

	public void setItem(Item p_195535_1_) {
		this.inventory = p_195535_1_;
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