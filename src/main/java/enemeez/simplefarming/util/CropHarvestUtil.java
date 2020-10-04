package enemeez.simplefarming.util;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.block.growable.SimpleCropBlock;
import enemeez.simplefarming.config.FeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.MarkerManager;

import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Elenterius on 15.08.2020
 */
public abstract class CropHarvestUtil
{
    public static final Tag<Item> DENY_RIGHT_CLICK_HARVEST_TAG = new ItemTags.Wrapper(new ResourceLocation(SimpleFarming.MOD_ID, "deny_right_click_harvest"));
    private static final Method GET_SEED_ITEM = ObfuscationReflectionHelper.findMethod(CropsBlock.class, "func_199772_f");

    public static boolean isItemNotDenyingHarvest(Item item) {
        return !CropHarvestUtil.DENY_RIGHT_CLICK_HARVEST_TAG.contains(item);
    }

    @Nullable
    public static Item getCropSeedItem(Block block) {
        if (block instanceof SimpleCropBlock) return ((SimpleCropBlock) block).getSeedsItem().asItem();

        try {
            return (Item) GET_SEED_ITEM.invoke(block);
        }
        catch (Exception e) {
            SimpleFarming.LOGGER.error(MarkerManager.getMarker("CropHarvest"), "couldn't find seed item", e);
        }
        return null;
    }

    public static void dropLoot(ServerWorld world, PlayerEntity player, BlockState state, BlockPos pos) {
        dropLootExceptItem(world, player, state, pos, null, FeatureConfig.rightClickHarvest.get().isSmartHarvest());
    }

    public static void dropLootExceptItem(ServerWorld world, PlayerEntity player, BlockState state, BlockPos pos, @Nullable final Item denyItem) {
        dropLootExceptItem(world, player, state, pos, denyItem, FeatureConfig.rightClickHarvest.get().isSmartHarvest());
    }

    public static void dropLootExceptItem(ServerWorld world, PlayerEntity player, BlockState state, BlockPos pos, @Nullable final Item denyItem, boolean addLootToPlayerInv) {
        List<ItemStack> drops = Block.getDrops(state, world, pos, world.getTileEntity(pos));

//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "deny item: " + denyItem);
//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "in: " + drops);
//        List<ItemStack> out = new ArrayList<>();

        for (ItemStack stack : drops) {
            if (stack.getItem() != denyItem) {
//                out.add(stack.copy());
                if (!addLootToPlayerInv || !player.addItemStackToInventory(stack)) {
                    world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
                }
            }
        }

//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "out: " + out);
    }

    /**
     * Drops all loot while making sure one seed item remains for replanting
     *
     * @return count of remaining seeds:
     * <br>0 = if seed item was not present in loot
     * <br>1 = if seed item was present in loot
     * <br>anything else = something went wrong
     */
    public static int dropLootExceptOneSeed(ServerWorld world, PlayerEntity player, BlockState state, BlockPos pos, @Nullable final Item seedItem) {
        return dropLootExceptOneSeed(world, player, state, pos, seedItem, FeatureConfig.rightClickHarvest.get().isSmartHarvest());
    }

    /**
     * Drops all loot while making sure one seed item remains for replanting
     *
     * @return count of remaining seeds:
     * <br>0 = if seed item was not present in loot
     * <br>1 = if seed item was present in loot
     * <br>anything else = something went wrong
     */
    public static int dropLootExceptOneSeed(ServerWorld world, PlayerEntity player, BlockState state, BlockPos pos, @Nullable final Item seedItem, boolean addLootToPlayerInv) {
        List<ItemStack> drops = Block.getDrops(state, world, pos, world.getTileEntity(pos));
        int seedCount = drops.stream().filter(stack -> stack.getItem() == seedItem).mapToInt(ItemStack::getCount).sum();

//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "seed item: " + seedItem);
//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "in: " + drops);
//        List<ItemStack> out = new ArrayList<>();

        for (ItemStack stack : drops) {
            if (stack.isEmpty()) continue;

            Item itemDrop = stack.getItem();
            if (itemDrop == seedItem) {
                if (seedCount > 0) {
                    if (seedCount - stack.getCount() < 1) { //make sure one seed item remains for replanting
                        stack.shrink(1);
                    }
                    if (!stack.isEmpty()) {
                        seedCount -= stack.getCount();
//                        out.add(stack.copy());
                        if (!addLootToPlayerInv || !player.addItemStackToInventory(stack)) world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
                    }
                }
            }
            else {
//                out.add(stack.copy());
                if (!addLootToPlayerInv || !player.addItemStackToInventory(stack)) world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
            }
        }

//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "out: " + out);
//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "remaining seeds: " + seedCount);

        return seedCount;
    }
}
