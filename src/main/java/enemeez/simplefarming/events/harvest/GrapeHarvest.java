package enemeez.simplefarming.events.harvest;

import enemeez.simplefarming.block.GrapeBlock;
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

public class GrapeHarvest
{
    @SubscribeEvent
    public void onCropHarvest(RightClickBlock event) {
        ItemStack heldStack = event.getPlayer().getMainHandItem();
        if (CropHarvestUtil.isItemNotDenyingHarvest(heldStack)) {
            BlockPos pos = event.getPos();
            BlockState state = event.getWorld().getBlockState(pos);

            if (state.getBlock() instanceof GrapeBlock) {
                if (!heldStack.isEmpty()) {
                    event.setCanceled(true);
                    event.setCancellationResult(InteractionResult.SUCCESS); //prevents use of item, prevents the player from attempting to eat fast to eat food (dried kelp, cactus fruit, berries)
                }
                if (!event.getWorld().isClientSide) {
                    CropHarvestUtil.dropLoot((ServerLevel) event.getWorld(), event.getPlayer(), state, pos);

                    event.getPlayer().causeFoodExhaustion(0.05F);
                    event.getWorld().playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + event.getWorld().random.nextFloat() * 0.4F);
                    event.getWorld().setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                }
                event.getPlayer().swing(InteractionHand.MAIN_HAND);
            }
        }
    }
}
