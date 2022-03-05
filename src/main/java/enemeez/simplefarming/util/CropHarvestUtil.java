package enemeez.simplefarming.util;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.block.growable.SimpleCropBlock;
import enemeez.simplefarming.config.RightClickConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.apache.logging.log4j.MarkerManager;

import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Elenterius on 15.08.2020
 */
public abstract class CropHarvestUtil
{
    public static final TagKey<Item> DENY_RIGHT_CLICK_HARVEST_TAG = ItemTags.create(new ResourceLocation(SimpleFarming.MOD_ID, "deny_right_click_harvest"));

    public static boolean isItemNotDenyingHarvest(ItemStack item) {
        return !item.is(CropHarvestUtil.DENY_RIGHT_CLICK_HARVEST_TAG);
    }

    @Nullable
    public static Item getCropSeedItem(Block block) {
        if (block instanceof CropBlock)
            return ((CropBlock) block).getBaseSeedId().asItem();
        return null;
    }

    public static void dropLoot(ServerLevel world, Player player, BlockState state, BlockPos pos) {
        dropLootExceptItem(world, player, state, pos, null, RightClickConfig.rightClickHarvest.get().isSmartHarvest());
    }

    public static void dropLootExceptItem(ServerLevel world, Player player, BlockState state, BlockPos pos, @Nullable final Item denyItem) {
        dropLootExceptItem(world, player, state, pos, denyItem, RightClickConfig.rightClickHarvest.get().isSmartHarvest());
    }

    public static void dropLootExceptItem(ServerLevel world, Player player, BlockState state, BlockPos pos, @Nullable final Item denyItem, boolean addLootToPlayerInv) {
        List<ItemStack> drops = Block.getDrops(state, world, pos, world.getBlockEntity(pos));

//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "deny item: " + denyItem);
//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "in: " + drops);
//        List<ItemStack> out = new ArrayList<>();

        for (ItemStack stack : drops) {
            if (stack.getItem() != denyItem) {
//                out.add(stack.copy());
                if (!addLootToPlayerInv || !player.addItem(stack)) {
                    world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
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
    public static int dropLootExceptOneSeed(ServerLevel world, Player player, BlockState state, BlockPos pos, @Nullable final Item seedItem) {
        return dropLootExceptOneSeed(world, player, state, pos, seedItem, RightClickConfig.rightClickHarvest.get().isSmartHarvest());
    }

    /**
     * Drops all loot while making sure one seed item remains for replanting
     *
     * @return count of remaining seeds:
     * <br>0 = if seed item was not present in loot
     * <br>1 = if seed item was present in loot
     * <br>anything else = something went wrong
     */
    public static int dropLootExceptOneSeed(ServerLevel world, Player player, BlockState state, BlockPos pos, @Nullable final Item seedItem, boolean addLootToPlayerInv) {
        List<ItemStack> drops = Block.getDrops(state, world, pos, world.getBlockEntity(pos));
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
                        if (!addLootToPlayerInv || !player.addItem(stack)) world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
                    }
                }
            }
            else {
//                out.add(stack.copy());
                if (!addLootToPlayerInv || !player.addItem(stack)) world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
            }
        }

//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "out: " + out);
//        SimpleFarming.LOGGER.debug(MarkerManager.getMarker("CropHarvest"), "remaining seeds: " + seedCount);

        return seedCount;
    }
}
