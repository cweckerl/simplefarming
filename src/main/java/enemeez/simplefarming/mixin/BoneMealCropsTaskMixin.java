package enemeez.simplefarming.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.ai.brain.task.BoneMealCropsTask;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoneMealCropsTask.class)
public abstract class BoneMealCropsTaskMixin
{
    @Inject(method = "isGrowable", at = @At("TAIL"), cancellable = true)
    protected void onIsGrowable(BlockPos pos, ServerWorld world, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        if (block instanceof IPlantable && block instanceof IGrowable && ((IPlantable) block).getPlantType(world, pos) == PlantType.CROP && ((IGrowable) block).canGrow(world, pos, state, world.isRemote) && ((IGrowable) block).canUseBonemeal(world, world.rand, pos, state)) {
            cir.setReturnValue(true);
        }
    }
}
