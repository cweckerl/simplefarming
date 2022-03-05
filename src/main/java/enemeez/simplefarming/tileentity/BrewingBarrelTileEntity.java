package enemeez.simplefarming.tileentity;

import enemeez.simplefarming.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Clearable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class BrewingBarrelTileEntity extends BlockEntity implements Clearable {

	private Item inventory = ItemStack.EMPTY.getItem();
	private int capacity = 0;

	public BrewingBarrelTileEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.BARREL_TILE.get(), pos, state);
	}

	public Item getItem() {
		return this.inventory;
	}

	public void setItem(Item item) {
		this.inventory = item;
		capacity++;
		this.setChanged();
	}

	public void clearContent() {
		this.setItem(ItemStack.EMPTY.getItem());
		capacity = 0;
		this.setChanged();
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
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
	protected void saveAdditional(CompoundTag compound) {
		compound.putInt("capacity", capacity);
		compound.putString("inventory", inventory.getRegistryName().toString());
		super.saveAdditional(compound);
	}

}