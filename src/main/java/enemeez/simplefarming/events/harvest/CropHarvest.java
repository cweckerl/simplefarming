package enemeez.simplefarming.events.harvest;

import enemeez.simplefarming.block.growable.DoubleCropBlock;
import enemeez.simplefarming.util.CropHarvestUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.NetherWartBlock;
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

public class CropHarvest
{
    @SubscribeEvent
    public void onCropHarvest(RightClickBlock event) {
        ItemStack heldStack = event.getPlayer().getHeldItemMainhand();
        if (CropHarvestUtil.isItemNotDenyingHarvest(heldStack.getItem())) {
            BlockPos pos = event.getPos();
            BlockState state = event.getWorld().getBlockState(pos);

            if (state.getBlock() instanceof CropsBlock && !(state.getBlock() instanceof DoubleCropBlock)) {
                CropsBlock crop = (CropsBlock) state.getBlock();
                if (crop.isMaxAge(state)) {
                    if (!heldStack.isEmpty()) {
                        event.setCanceled(true); // prevents blocks from being placed
                        event.setCancellationResult(ActionResultType.SUCCESS); //prevents use of item, prevents the player from attempting to eat fast to eat food (dried kelp, cactus fruit, berries)
                    }

                    if (!event.getWorld().isRemote) {
                        int remainingSeeds = CropHarvestUtil.dropLootExceptOneSeed((ServerWorld) event.getWorld(), event.getPlayer(), state, pos, CropHarvestUtil.getCropSeedItem(crop));

                        //set crop to air if no seed item is left for replanting
                        //this guards against the case where the loot was modified and no seed item is present //TODO: add config to always replant crop regardless if seed is present or not?
                        BlockState newState = remainingSeeds > 0 ? crop.getDefaultState() : Blocks.AIR.getDefaultState();

                        event.getPlayer().addExhaustion(0.05F);
                        event.getWorld().playSound(null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
                        event.getWorld().setBlockState(pos, newState, Constants.BlockFlags.BLOCK_UPDATE);
                    }
                    event.getPlayer().swingArm(Hand.MAIN_HAND);
                }
            }

            if (state.getBlock() instanceof NetherWartBlock) {
                NetherWartBlock netherWart = (NetherWartBlock) state.getBlock();
                if (state.get(NetherWartBlock.AGE) == 3) {
                    if (!heldStack.isEmpty()) {
                        event.setCanceled(true);
                        event.setCancellationResult(ActionResultType.SUCCESS); //prevents use of item, prevents the player from attempting to eat fast to eat food (dried kelp, cactus fruit, berries)
                    }
                    if (!event.getWorld().isRemote) {
                        Item wartItem = netherWart.getItem(event.getWorld(), pos, state).getItem();
                        int remainingWart = CropHarvestUtil.dropLootExceptOneSeed((ServerWorld) event.getWorld(), event.getPlayer(), state, pos, wartItem);
                        BlockState newState = remainingWart > 0 ? netherWart.getDefaultState() : Blocks.AIR.getDefaultState(); //set crop to air if no seed item is left for replanting

                        event.getPlayer().addExhaustion(0.05F);
                        event.getWorld().playSound(null, pos, SoundEvents.BLOCK_NETHER_WART_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
                        event.getWorld().setBlockState(pos, newState, Constants.BlockFlags.BLOCK_UPDATE);
                    }
                    event.getPlayer().swingArm(Hand.MAIN_HAND);
                }
            }
        }
    }
}
