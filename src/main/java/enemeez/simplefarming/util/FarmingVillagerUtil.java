package enemeez.simplefarming.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.init.ModItems;
import enemeez.simplefarming.mixin.FarmerWorkTaskAccessor;
import enemeez.simplefarming.mixin.VillagerEntityAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FarmingVillagerUtil
{
    private static Map<Item, Integer> ORIGINAL_VILLAGER_FOOD_VALUES = ImmutableMap.of();
    private static List<Item> ORIGINAL_COMPOSTABLE_ITEMS = ImmutableList.of();

    /**
     * Map of simple breads that only need one type of grain to be crafted.
     */
    public static Map<Item, Item> SIMPLE_BREAD_INGREDIENT_MAP;

    public static void onCommonSetup() {
        ORIGINAL_VILLAGER_FOOD_VALUES = VillagerEntity.FOOD_VALUES;

        SIMPLE_BREAD_INGREDIENT_MAP = new ImmutableMap.Builder<Item, Item>()
                .put(ModItems.barley_bread, ModItems.barley)
                .put(ModItems.oat_bread, ModItems.oat)
                .put(ModItems.rye_bread, ModItems.rye)
                .put(ModItems.rice_bread, ModItems.rice)
                .build();

        ORIGINAL_COMPOSTABLE_ITEMS = FarmerWorkTaskAccessor.getCompostableItems();
    }

    public static boolean isCropPlantSeed(Item item, World world) {
        if (Tags.Items.SEEDS.contains(item) && item instanceof BlockNamedItem) {
            Block block = ((BlockNamedItem) item).getBlock();
            return block instanceof CropsBlock || (block instanceof IPlantable && ((IPlantable) block).getPlantType(world, BlockPos.ZERO) == PlantType.CROP);
        }
        return false;
    }

    public static void rebuildCompostableList() {
        // allow more items to be composted by the farming villager

        SimpleFarming.LOGGER.info("rebuilding compostable item list of FarmerWorkTask...");
        List<Item> compostableItems = new ArrayList<>(ORIGINAL_COMPOSTABLE_ITEMS); //make shallow copy of immutable map
        int oldListSize = compostableItems.size();
        try {
            for (Item item : Tags.Items.SEEDS.getAllElements()) {
                if (!compostableItems.contains(item) && ComposterBlock.CHANCES.containsKey(item)) compostableItems.add(item);
            }
        }
        catch (Exception e) {
            SimpleFarming.LOGGER.error("failed to add items", e);
        }
        compostableItems.addAll(SIMPLE_BREAD_INGREDIENT_MAP.values());
        FarmerWorkTaskAccessor.setCompostableItems(ImmutableList.copyOf(compostableItems));
        SimpleFarming.LOGGER.debug(String.format("added %d items", FarmerWorkTaskAccessor.getCompostableItems().size() - oldListSize));
    }

    public static void rebuildFoodValueMap() {
        // this enables villagers to eat/share any crop that is marked as food

        SimpleFarming.LOGGER.info("rebuilding FOOD_VALUES map of Villager Entity...");
        Map<Item, Integer> foodValues = new HashMap<>(ORIGINAL_VILLAGER_FOOD_VALUES); //make shallow copy of immutable map
        int oldMapSize = foodValues.size();
        try {
            for (Item item : Tags.Items.CROPS.getAllElements()) {
                if (item.isFood() && !foodValues.containsKey(item) || SIMPLE_BREAD_INGREDIENT_MAP.containsValue(item)) {
                    if (item.getFood() != null) {
                        int foodValue = item.getFood().getHealing() > 4 ? 4 : 1; //arbitrary guess based on bread food value for villagers, TODO: re-balance this?
                        foodValues.put(item, foodValue);
                    }
                }
            }
        }
        catch (Exception e) {
            SimpleFarming.LOGGER.error("failed to insert values", e);
        }

        VillagerEntityAccessor.setFoodValues(ImmutableMap.copyOf(foodValues));
        SimpleFarming.LOGGER.debug(String.format("added %d food value pairs", VillagerEntity.FOOD_VALUES.size() - oldMapSize));
    }

    public static boolean tryToPlantCrop(ServerWorld world, BlockPos pos, Item item) {
        if (item instanceof BlockNamedItem && ((BlockNamedItem) item).getBlock() instanceof IPlantable) {
            IPlantable iPlantable = (IPlantable) ((BlockNamedItem) item).getBlock();
            if (iPlantable.getPlantType(world, pos) == PlantType.CROP) {
                world.setBlockState(pos, iPlantable.getPlant(world, pos), Constants.BlockFlags.DEFAULT);
                world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                return true;
            }
        }
        else if (item instanceof IPlantable) { // in case some mod relies on this outdated forge patch
            IPlantable iPlantable = (IPlantable) item;
            if (iPlantable.getPlantType(world, pos) == PlantType.CROP) {
                world.setBlockState(pos, iPlantable.getPlant(world, pos), Constants.BlockFlags.DEFAULT);
                world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                return true;
            }
        }
        return false;
    }

    public static boolean tryToBakeSpecificBread(VillagerEntity villager, Item breadToBake, Item craftingIngredient) {
        Inventory inv = villager.getVillagerInventory();
        int wheatCount = inv.count(craftingIngredient);
        int craftingCost = 3;
        int amountCrafted = Math.min(3, wheatCount / craftingCost);
        if (amountCrafted != 0) {
            inv.func_223374_a(craftingIngredient, amountCrafted * craftingCost); // remove amount of used ingredient
            ItemStack stack = inv.addItem(new ItemStack(breadToBake, amountCrafted));
            if (!stack.isEmpty()) {
                villager.entityDropItem(stack, 0.5F); // drop surplus
            }
            return true;
        }
        return false;
    }
}
