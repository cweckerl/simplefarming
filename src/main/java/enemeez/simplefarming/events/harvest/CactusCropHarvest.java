package enemeez.simplefarming.events.harvest;

import enemeez.simplefarming.block.growable.OpuntiaBlock;
import enemeez.simplefarming.util.CropHarvestUtil;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
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

public class CactusCropHarvest
{
    @SubscribeEvent
    public void onCropHarvest(RightClickBlock event) {
        ItemStack heldStack = event.getPlayer().getHeldItemMainhand();
        if (CropHarvestUtil.isItemNotDenyingHarvest(heldStack.getItem())) {
            BlockPos pos = event.getPos();
            BlockState state = event.getWorld().getBlockState(pos);

            if (state.getBlock() instanceof OpuntiaBlock) {
                OpuntiaBlock cactus = (OpuntiaBlock) state.getBlock();
                if (cactus.isMaxAge(state)) {
                    if (!heldStack.isEmpty()) {
                        event.setCanceled(true);
                        event.setCancellationResult(ActionResultType.SUCCESS); //prevents use of item, prevents the player from attempting to eat fast to eat food (dried kelp, cactus fruit, berries)
                    }
                    if (!event.getWorld().isRemote) {
                        Item cactusItem = cactus.getItem(event.getWorld(), pos, state).getItem();
                        CropHarvestUtil.dropLootExceptItem((ServerWorld) event.getWorld(), event.getPlayer(), state, pos, cactusItem);

                        event.getPlayer().addExhaustion(0.05F);
                        event.getWorld().playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
                        event.getWorld().setBlockState(pos, state.with(OpuntiaBlock.AGE, 0), Constants.BlockFlags.BLOCK_UPDATE);
                    }
                    event.getPlayer().swingArm(Hand.MAIN_HAND);
                }
            }
        }
    }
}
