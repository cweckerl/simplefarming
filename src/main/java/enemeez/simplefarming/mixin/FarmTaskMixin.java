package enemeez.simplefarming.mixin;

import enemeez.simplefarming.block.growable.GrowableBushBlock;
import enemeez.simplefarming.util.FarmingVillagerUtil;
import net.minecraft.block.*;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.memory.WalkTarget;
import net.minecraft.entity.ai.brain.task.FarmTask;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPosWrapper;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(FarmTask.class)
public abstract class FarmTaskMixin
{
    @Shadow
    @Nullable
    private BlockPos field_220422_a;

    @Shadow
    @Final
    private List<BlockPos> farmableBlocks;

    @Shadow
    @Nullable
    protected abstract BlockPos getNextPosForFarming(ServerWorld serverWorldIn);

    @Shadow
    private long taskCooldown;

    @Shadow
    private int idleTime;

    @Inject(method = "isValidPosForFarming", at = @At("TAIL"), cancellable = true)
    protected void onIsValidPosForFarming(BlockPos pos, ServerWorld serverWorldIn, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = serverWorldIn.getBlockState(pos);
        Block block = state.getBlock();
        if (block instanceof GrowableBushBlock && ((GrowableBushBlock) block).getPlantType(serverWorldIn, pos) == PlantType.CROP && ((GrowableBushBlock) block).isMaxAge(state)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "updateTask", at = @At("HEAD"), cancellable = true)
    protected void onUpdateTask(ServerWorld world, VillagerEntity owner, long gameTime, CallbackInfo ci) {
        ci.cancel(); //prevent execution of the vanilla method logic

        if (field_220422_a == null || field_220422_a.withinDistance(owner.getPositionVec(), 1.0D)) {
            if (field_220422_a != null && gameTime > taskCooldown) {
                Block soilBlock = world.getBlockState(field_220422_a.down()).getBlock();
                BlockState topState = world.getBlockState(field_220422_a);
                Block topBlock = topState.getBlock();
                if (topBlock instanceof CropsBlock && ((CropsBlock) topBlock).isMaxAge(topState)) {
                    world.destroyBlock(field_220422_a, true, owner);
                }
                else if (topBlock instanceof GrowableBushBlock && ((GrowableBushBlock) topBlock).getPlantType(world, field_220422_a) == PlantType.CROP && ((GrowableBushBlock) topBlock).isMaxAge(topState)) {
                    world.destroyBlock(field_220422_a, true, owner);
                }

                if (topState == Blocks.AIR.getDefaultState() && soilBlock instanceof FarmlandBlock && owner.isFarmItemInInventory()) {
                    Inventory inv = owner.getVillagerInventory();
                    ItemStack stack;
                    for (int idx = 0; idx < inv.getSizeInventory(); idx++) {
                        stack = inv.getStackInSlot(idx);
                        if (!stack.isEmpty()) {
                            if (FarmingVillagerUtil.tryToPlantCrop(world, field_220422_a, stack.getItem())) {
                                stack.shrink(1);
                                if (stack.isEmpty()) inv.setInventorySlotContents(idx, ItemStack.EMPTY);
                                break;
                            }
                        }
                    }
                }

                if ((topBlock instanceof CropsBlock && !((CropsBlock) topBlock).isMaxAge(topState)) || (topBlock instanceof GrowableBushBlock && ((GrowableBushBlock) topBlock).getPlantType(world, field_220422_a) == PlantType.CROP && !((GrowableBushBlock) topBlock).isMaxAge(topState))) {
                    farmableBlocks.remove(field_220422_a);
                    field_220422_a = getNextPosForFarming(world);
                    if (field_220422_a != null) {
                        taskCooldown = gameTime + 20L;
                        owner.getBrain().setMemory(MemoryModuleType.WALK_TARGET, new WalkTarget(new BlockPosWrapper(field_220422_a), 0.5F, 1));
                        owner.getBrain().setMemory(MemoryModuleType.LOOK_TARGET, new BlockPosWrapper(field_220422_a));
                    }
                }
            }

            ++idleTime;
        }
    }
}
