package enemeez.simplefarming.events.harvest;

import enemeez.simplefarming.block.growable.PlantBlock;
import enemeez.simplefarming.util.CropHarvestUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WildPlantHarvest
{
    @SubscribeEvent
    public void onCropHarvest(RightClickBlock event) {
        ItemStack heldStack = event.getPlayer().getMainHandItem();
        if (CropHarvestUtil.isItemNotDenyingHarvest(heldStack)) {
            BlockPos pos = event.getPos();
            BlockState state = event.getWorld().getBlockState(pos);

            if (state.getBlock() instanceof PlantBlock) {
                PlantBlock plant = (PlantBlock) state.getBlock();
                if (plant.isMaxAge(state)) {
                    if (!heldStack.isEmpty()) {
                        event.setCanceled(true);
                        event.setCancellationResult(InteractionResult.SUCCESS); //prevents use of item, prevents the player from attempting to eat fast to eat food (dried kelp, cactus fruit, berries)
                    }
                    if (!event.getWorld().isClientSide) {
                        int remainingSeeds = CropHarvestUtil.dropLootExceptOneSeed((ServerLevel) event.getWorld(), event.getPlayer(), state, pos, plant.getCloneItemStack(event.getWorld(), pos, state).getItem());
                        BlockState newState = remainingSeeds > 0 ? plant.defaultBlockState() : Blocks.AIR.defaultBlockState(); //set crop to air if no seed item is left for replanting

                        event.getPlayer().causeFoodExhaustion(0.05F);
                        event.getWorld().playSound(null, pos, SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F + event.getWorld().random.nextFloat() * 0.4F);
                        event.getWorld().setBlock(pos, newState, Block.UPDATE_ALL);
                    }
                    event.getPlayer().swing(InteractionHand.MAIN_HAND);
                }
            }
        }
    }
}
