package enemeez.simplefarming.common.block.menu;

import enemeez.simplefarming.common.block.entity.FermenterBlockEntity;
import enemeez.simplefarming.common.item.crafting.FermenterRecipe;
import enemeez.simplefarming.common.registries.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class FermenterMenu extends AbstractContainerMenu {
    private final ContainerData DATA;
    private final Container CONTAINER;
    private final Level LEVEL;

    public FermenterMenu(int id, Inventory inventory, FriendlyByteBuf buffer) {
        this(
            id,
            inventory,
            (FermenterBlockEntity) inventory.player.level.getBlockEntity(buffer.readBlockPos()),
            new SimpleContainerData(2)
        );
    }

    public FermenterMenu(int pContainerId, Inventory inventory, Container container, ContainerData containerData) {
        super(ModMenus.FERMENTER_MENU.get(), pContainerId);
        checkContainerSize(container, 3);
        checkContainerDataCount(containerData, 2);
        this.CONTAINER = container;
        this.DATA = containerData;
        this.LEVEL = inventory.player.level;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 142));
        }

        this.addSlot(new Slot(container, 0, 56, 17));
        this.addSlot(new Slot(container, 1, 56, 53) {
            @Override
            public boolean mayPlace(ItemStack pStack) {
                return pStack.getItem() == Items.GLASS_BOTTLE;
            }
        });
        this.addSlot(new Slot(container, 2, 116, 35) {
            @Override
            public boolean mayPlace(ItemStack pStack) {
                return false;
            }
        });

        addDataSlots(DATA);
    }

    public int getScaledProgress() {
        int i = this.DATA.get(0);
        int j = this.DATA.get(1);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        // Modifier furnace menu
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);

        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (pIndex != 36 && pIndex != 37 && pIndex != 38) {
                if (this.canFerment(itemstack)) {
                    if ((!this.moveItemStackTo(itemstack1, 36, 37, false))) {
                        return ItemStack.EMPTY;
                    }
                } else if (itemstack1.getItem() == Items.GLASS_BOTTLE) {
                    if (!this.moveItemStackTo(itemstack1, 37, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex > 26 && pIndex < 36) {
                    if (!this.moveItemStackTo(itemstack1, 0, 26, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    if (!this.moveItemStackTo(itemstack1, 26, 36, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else {
                if (!this.moveItemStackTo(itemstack1, 0, 35, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
        }

        return itemstack;
    }

    private boolean canFerment(ItemStack pStack) {
        return this.LEVEL.getRecipeManager().getRecipeFor(FermenterRecipe.Type.INSTANCE, new SimpleContainer(pStack), this.LEVEL).isPresent();
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.CONTAINER.stillValid(pPlayer);
    }
}
