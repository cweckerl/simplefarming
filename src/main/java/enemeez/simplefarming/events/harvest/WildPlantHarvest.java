package enemeez.simplefarming.events.harvest;

import enemeez.simplefarming.block.growable.PlantBlock;
import enemeez.simplefarming.util.CropHarvestUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WildPlantHarvest
{
    @SubscribeEvent
    public void onCropHarvest(RightClickBlock event) {
        ItemStack heldStack = event.getPlayer().getHeldItemMainhand();
        if (CropHarvestUtil.isItemNotDenyingHarvest(heldStack.getItem())) {
            BlockPos pos = event.getPos();
            BlockState state = event.getWorld().getBlockState(pos);

            if (state.getBlock() instanceof PlantBlock) {
                PlantBlock plant = (PlantBlock) state.getBlock();
                if (plant.isMaxAge(state)) {
                    if (!heldStack.isEmpty()) {
                        event.setCanceled(true);
                        event.setCancellationResult(ActionResultType.SUCCESS); //prevents use of item, prevents the player from attempting to eat fast to eat food (dried kelp, cactus fruit, berries)
                    }
                    if (!event.getWorld().isRemote) {
                        int remainingSeeds = CropHarvestUtil.dropLootExceptOneSeed((ServerWorld) event.getWorld(), event.getPlayer(), state, pos, plant.getItem(event.getWorld(), pos, state).getItem());
                        BlockState newState = remainingSeeds > 0 ? plant.getDefaultState() : Blocks.AIR.getDefaultState(); //set crop to air if no seed item is left for replanting

                        event.getPlayer().addExhaustion(0.05F);
                        event.getWorld().playSound(null, pos, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
                        event.getWorld().setBlockState(pos, newState, Constants.BlockFlags.BLOCK_UPDATE);
                    }
                    event.getPlayer().swingArm(Hand.MAIN_HAND);
                }
            }
        }
    }
}
