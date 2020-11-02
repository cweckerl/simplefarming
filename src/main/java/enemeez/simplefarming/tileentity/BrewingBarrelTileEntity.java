package enemeez.simplefarming.tileentity;

import static enemeez.simplefarming.init.ModTiles.BARREL_TILE;

import net.minecraft.block.BlockState;
import net.minecraft.inventory.IClearable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class BrewingBarrelTileEntity extends TileEntity implements IClearable {

	private Item inventory = ItemStack.EMPTY.getItem();
	private int capacity = 0;

	public BrewingBarrelTileEntity() {
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
		this.markDirty();
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public void read(BlockState state, CompoundNBT compound) {
		super.read(state, compound);
		if (compound.contains("capacity")) {
			capacity = compound.getInt("capacity");
		}
		if (compound.contains("inventory")) {
			inventory = ForgeRegistries.ITEMS.getValue(new ResourceLocation(compound.getString("inventory")));
		}
		if (inventory == null) {
			inventory = ItemStack.EMPTY.getItem();
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putInt("capacity", capacity);
		compound.putString("inventory", inventory.getRegistryName().toString());
		return super.write(compound);
	}

}