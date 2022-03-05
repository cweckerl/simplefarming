package enemeez.simplefarming.events.harvest;

import enemeez.simplefarming.block.growable.DoubleCropBlock;
import enemeez.simplefarming.util.CropHarvestUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CropHarvest
{
    @SubscribeEvent
    public void onCropHarvest(RightClickBlock event) {
        ItemStack heldStack = event.getPlayer().getMainHandItem();
        if (CropHarvestUtil.isItemNotDenyingHarvest(heldStack)) {
            BlockPos pos = event.getPos();
            BlockState state = event.getWorld().getBlockState(pos);

            if (state.getBlock() instanceof CropBlock && !(state.getBlock() instanceof DoubleCropBlock)) {
                CropBlock crop = (CropBlock) state.getBlock();
                if (crop.isMaxAge(state)) {
                    if (!heldStack.isEmpty()) {
                        event.setCanceled(true); // prevents blocks from being placed
                        event.setCancellationResult(InteractionResult.SUCCESS); //prevents use of item, prevents the player from attempting to eat fast to eat food (dried kelp, cactus fruit, berries)
                    }

                    if (!event.getWorld().isClientSide) {
                        int remainingSeeds = CropHarvestUtil.dropLootExceptOneSeed((ServerLevel) event.getWorld(), event.getPlayer(), state, pos, CropHarvestUtil.getCropSeedItem(crop));

                        //set crop to air if no seed item is left for replanting
                        //this guards against the case where the loot was modified and no seed item is present // TODO: add config to always replant crop regardless if seed is present or not?
                        BlockState newState = remainingSeeds > 0 ? crop.defaultBlockState() : Blocks.AIR.defaultBlockState();

                        event.getPlayer().causeFoodExhaustion(0.05F);
                        event.getWorld().playSound(null, pos, SoundEvents.CROP_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F + event.getWorld().random.nextFloat() * 0.4F);
                        event.getWorld().setBlock(pos, newState, Block.UPDATE_ALL);
                    }
                    event.getPlayer().swing(InteractionHand.MAIN_HAND);
                }
            }

            if (state.getBlock() instanceof NetherWartBlock) {
                NetherWartBlock netherWart = (NetherWartBlock) state.getBlock();
                if (state.getValue(NetherWartBlock.AGE) == 3) {
                    if (!heldStack.isEmpty()) {
                        event.setCanceled(true);
                        event.setCancellationResult(InteractionResult.SUCCESS); //prevents use of item, prevents the player from attempting to eat fast to eat food (dried kelp, cactus fruit, berries)
                    }
                    if (!event.getWorld().isClientSide) {
                        Item wartItem = netherWart.getCloneItemStack(event.getWorld(), pos, state).getItem();
                        int remainingWart = CropHarvestUtil.dropLootExceptOneSeed((ServerLevel) event.getWorld(), event.getPlayer(), state, pos, wartItem);
                        BlockState newState = remainingWart > 0 ? netherWart.defaultBlockState() : Blocks.AIR.defaultBlockState(); //set crop to air if no seed item is left for replanting

                        event.getPlayer().causeFoodExhaustion(0.05F);
                        event.getWorld().playSound(null, pos, SoundEvents.NETHER_WART_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F + event.getWorld().random.nextFloat() * 0.4F);
                        event.getWorld().setBlock(pos, newState, Block.UPDATE_ALL);
                    }
                    event.getPlayer().swing(InteractionHand.MAIN_HAND);
                }
            }
        }
    }
}
