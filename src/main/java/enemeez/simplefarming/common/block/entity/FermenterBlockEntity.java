package enemeez.simplefarming.common.block.entity;

import enemeez.simplefarming.common.block.menu.FermenterMenu;
import enemeez.simplefarming.common.item.crafting.FermenterRecipe;
import enemeez.simplefarming.common.registries.ModBlockEntities;
import enemeez.simplefarming.common.registries.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class FermenterBlockEntity extends BlockEntity implements MenuProvider, WorldlyContainer {
    private static final int SLOT_INPUT = 0;
    private static final int SLOT_BOTTLE = 1;
    private static final int SLOT_RESULT = 2;
    private static final int CONTAINER_SIZE = 3;
    private static final int CONTAINER_DATA_SIZE = 2;
    private static final int[] SLOTS_FOR_UP = new int[]{SLOT_INPUT};
    private static final int[] SLOTS_FOR_DOWN = new int[]{SLOT_BOTTLE, SLOT_RESULT};
    private static final int[] SLOTS_FOR_SIDES = new int[]{SLOT_BOTTLE};
    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    private int progress = 0;
    private int totalTime = 2000;

    private LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    protected final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> progress;
                case 1 -> totalTime;
                default -> 0;
            };
        }

        @Override
        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0 -> progress = pValue;
                case 1 -> totalTime = pValue;
            }
        }

        @Override
        public int getCount() {
            return CONTAINER_DATA_SIZE;
        }
    };

    public FermenterBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FERMENTER.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.fermenter");
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
            if (facing == Direction.UP)
                return handlers[0].cast();
            else if (facing == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        for (LazyOptional<? extends IItemHandler> handler : handlers) {
            handler.invalidate();
        }
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
        this.progress = pTag.getInt("Progress");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items);
        pTag.putInt("Progress", this.progress);
    }

    public void dropContents() {
        if (this.level != null) {
            Containers.dropContents(this.level, this.worldPosition, this.items);
        }
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, FermenterBlockEntity entity) {
        Optional<FermenterRecipe> recipe;
        if (canCraft(entity) && (recipe = level.getRecipeManager().getRecipeFor(FermenterRecipe.Type.INSTANCE, entity, level)).isPresent()) {
            entity.progress++;

            if (entity.progress == entity.totalTime) {
                entity.progress = 0;

                var input = entity.items.get(SLOT_INPUT);
                var bottle = entity.items.get(SLOT_BOTTLE);
                entity.items.set(SLOT_INPUT, input.getCount() > 0 ? new ItemStack(input.getItem(), input.getCount() - 1) : ItemStack.EMPTY);
                entity.items.set(SLOT_BOTTLE, bottle.getCount() > 0 ? new ItemStack(bottle.getItem(), bottle.getCount() - 1) : ItemStack.EMPTY);
                entity.items.set(SLOT_RESULT, new ItemStack(recipe.get().getResultItem(level.m_9598_()).getItem()));
            }

            setChanged(level, blockPos, blockState);
        } else {
            entity.progress = 0;
            setChanged(level, blockPos, blockState);
        }
    }


    private static boolean canCraft(FermenterBlockEntity entity) {
        return entity.items.get(SLOT_BOTTLE).getItem() == Items.GLASS_BOTTLE && entity.items.get(SLOT_RESULT) == ItemStack.EMPTY;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FermenterMenu(pContainerId, pPlayerInventory, this, this.dataAccess);
    }

    @Override
    public int getContainerSize() {
        return CONTAINER_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return this.items.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getItem(int pSlot) {
        return this.items.get(pSlot);
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return ContainerHelper.removeItem(this.items, pSlot, pAmount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return ContainerHelper.takeItem(this.items, pSlot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {
        ItemStack itemstack = this.items.get(pSlot);
        boolean flag = !pStack.isEmpty() && pStack.sameItem(itemstack) && ItemStack.tagMatches(pStack, itemstack);

        this.items.set(pSlot, pStack);
        if (pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }

        if (pSlot == 0 && !flag) {
            this.progress = 0;
            this.setChanged();
        }
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return pPlayer.distanceToSqr(
                (double) this.worldPosition.getX() + 0.5D,
                (double) this.worldPosition.getY() + 0.5D,
                (double) this.worldPosition.getZ() + 0.5D
            ) <= 64.0D;
        }
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return pSide == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        if (pIndex == SLOT_INPUT) {
            return pItemStack.is(ModTags.FERMENTABLE);
        } else if (pIndex == SLOT_BOTTLE) {
            return pItemStack.getItem() == Items.GLASS_BOTTLE;
        } else {
            return false;
        }
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return pIndex == SLOT_RESULT;
    }
}
