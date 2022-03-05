package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.block.*;
import enemeez.simplefarming.block.growable.*;
import enemeez.simplefarming.util.ModVoxelShapes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimpleFarming.MOD_ID);

    // @formatter:off

	// Bush
	public static final RegistryObject<BerryBushBlock> BLACKBERRY_BUSH = register("blackberry_bush", () -> new BerryBushBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)), ModItems.BLACKBERRY_BUSH));
	public static final RegistryObject<BerryBushBlock> BLUEBERRY_BUSH = register("blueberry_bush", () -> new BerryBushBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)), ModItems.BLUEBERRY_BUSH));
	public static final RegistryObject<BerryBushBlock> RASPBERRY_BUSH = register("raspberry_bush", () -> new BerryBushBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)), ModItems.RASPBERRY_BUSH));
	public static final RegistryObject<BerryBushBlock> STRAWBERRY_BUSH = register("strawberry_bush", () -> new BerryBushBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)), ModItems.STRAWBERRY_BUSH));

	// Gourds
	public static final RegistryObject<Block> CANTALOUPE_BLOCK = register("cantaloupe_block", () -> new Block(Block.Properties.of(Material.PLANT).sound(SoundType.WOOD).strength(1.0F)));
	public static final RegistryObject<Block> HONEYDEW_BLOCK = register("honeydew_block", () -> new Block(Block.Properties.of(Material.PLANT).sound(SoundType.WOOD).strength(1.0F)));
	public static final RegistryObject<Block> SQUASH_BLOCK = register("squash_block", () -> new Block(Block.Properties.of(Material.PLANT).sound(SoundType.WOOD).strength(1.0F)));

	// Cake-like blocks
	public static final RegistryObject<BirthdayCakeBlock> BIRTHDAY_CAKE = register("birthday_cake", () -> new BirthdayCakeBlock(Block.Properties.of(Material.CAKE).strength(0.5F).lightLevel((state) -> 14).sound(SoundType.WOOL)));
	public static final RegistryObject<CheeseBlock> CHEESE_BLOCK = register("cheese_block", () -> new CheeseBlock(Block.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<SimpleCakeBlock> CHOCOLATE_CAKE = register("chocolate_cake", () -> new SimpleCakeBlock(Block.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));

	// Tree
	public static final RegistryObject<ThinBlock> FRUIT_LOG = register("fruit_log", () -> new ThinBlock(MaterialColor.PODZOL, Block.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<SimpleSaplingBlock> APPLE_SAPLING = register("apple_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 1));
	public static final RegistryObject<SimpleSaplingBlock> APRICOT_SAPLING = register("apricot_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 2));
	public static final RegistryObject<SimpleSaplingBlock> BANANA_SAPLING = register("banana_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 3));
	public static final RegistryObject<SimpleSaplingBlock> CHERRY_SAPLING = register("cherry_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 7));
	public static final RegistryObject<SimpleSaplingBlock> MANGO_SAPLING = register("mango_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 8));
	public static final RegistryObject<SimpleSaplingBlock> OLIVE_SAPLING = register("olive_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 9));
	public static final RegistryObject<SimpleSaplingBlock> ORANGE_SAPLING = register("orange_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 5));
	public static final RegistryObject<SimpleSaplingBlock> PLUM_SAPLING = register("plum_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 4));
	public static final RegistryObject<SimpleSaplingBlock> PEAR_SAPLING = register("pear_sapling", () -> new SimpleSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0f).sound(SoundType.GRASS), 6));

	public static final RegistryObject<GrapePlantBlock> GRAPE_PLANT = register("grape_plant", () -> new GrapePlantBlock((Block.Properties.of(Material.PLANT).randomTicks().strength(2.0F).sound(SoundType.WOOD))));
	public static final RegistryObject<GrapeLeavesBlock> GRAPE_LEAVES = register("grape_leaves", () -> new GrapeLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS)));
	public static final RegistryObject<GrapeLeavesBlock> GRAPE_LEAVES_BASE = register("grape_leaves_base", () -> new GrapeLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS)));
	public static final RegistryObject<GrapeBlock> GRAPE_BLOCK = register("grape_block", () -> new GrapeBlock(Block.Properties.of(Material.GRASS).strength(0.2F).noCollission()));

	// Leaves
	public static final RegistryObject<FruitLeavesBlock> APPLE_LEAVES = register("apple_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), () -> Items.APPLE, ModItems.APPLE_SAPLING));
	public static final RegistryObject<FruitLeavesBlock> APRICOT_LEAVES = register("apricot_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), ModItems.APRICOT, ModItems.APRICOT_SAPLING));
	public static final RegistryObject<FruitLeavesBlock> BANANA_LEAVES = register("banana_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), ModItems.BANANA, ModItems.BANANA_SAPLING));
	public static final RegistryObject<FruitLeavesBlock> CHERRY_LEAVES = register("cherry_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), ModItems.CHERRIES, ModItems.CHERRY_SAPLING));
	public static final RegistryObject<FruitLeavesBlock> MANGO_LEAVES = register("mango_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), ModItems.MANGO, ModItems.MANGO_SAPLING));
	public static final RegistryObject<FruitLeavesBlock> OLIVE_LEAVES = register("olive_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), ModItems.OLIVES, ModItems.OLIVE_SAPLING));
	public static final RegistryObject<FruitLeavesBlock> ORANGE_LEAVES = register("orange_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), ModItems.ORANGE, ModItems.ORANGE_SAPLING));
	public static final RegistryObject<FruitLeavesBlock> PLUM_LEAVES = register("plum_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), ModItems.PLUM, ModItems.PLUM_SAPLING));
	public static final RegistryObject<FruitLeavesBlock> PEAR_LEAVES = register("pear_leaves", () -> new FruitLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().randomTicks().sound(SoundType.GRASS), ModItems.PEAR, ModItems.PEAR_SAPLING));

	// Crops
	public static final RegistryObject<SimpleCropBlock> BARLEY_CROP = register("barley_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.BARLEY, ModItems.BARLEY_SEEDS));
	public static final RegistryObject<SimpleCropBlock> BROCCOLI_CROP = register("broccoli_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.BROCCOLI, ModItems.BROCCOLI_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<OpuntiaBlock> CACTUS_CROP = register("cactus_crop", () -> new OpuntiaBlock((Block.Properties.of(Material.PLANT).randomTicks().strength(0.2f).sound(SoundType.WOOL))));
	public static final RegistryObject<GourdCropBlock> CANTALOUPE_CROP = register("cantaloupe_crop", () -> new GourdCropBlock(Block.Properties.of(Material.PLANT).randomTicks().strength(0.2f).sound(SoundType.HARD_CROP), ModItems.CANTALOUPE_BLOCK, ModItems.CANTALOUPE_SEEDS));
	public static final RegistryObject<SimpleCropBlock> CARROT_CROP = register("carrot_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), () -> Items.CARROT, ModItems.CARROT_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> CASSAVA_CROP = register("cassava_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.CASSAVA, ModItems.CASSAVA_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<DoubleCropBlock> CORN_CROP = register("corn_crop", () -> new DoubleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.CORN, ModItems.CORN_SEEDS));
	public static final RegistryObject<SimpleCropBlock> COTTON_CROP = register("cotton_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.COTTON, ModItems.COTTON_SEEDS));
	public static final RegistryObject<SimpleCropBlock> CUCUMBER_CROP = register("cucumber_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.CUCUMBER, ModItems.CUCUMBER_SEEDS));
	public static final RegistryObject<SimpleCropBlock> EGGPLANT_CROP = register("eggplant_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.EGGPLANT, ModItems.EGGPLANT_SEEDS));
	public static final RegistryObject<GourdCropBlock> HONEYDEW_CROP = register("honeydew_crop", () -> new GourdCropBlock(Block.Properties.of(Material.PLANT).randomTicks().strength(0.2f).sound(SoundType.CROP), ModItems.HONEYDEW_BLOCK, ModItems.HONEYDEW_SEEDS));
	public static final RegistryObject<SimpleCropBlock> GINGER_CROP = register("ginger_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.GINGER, ModItems.GINGER_SEEDS));
	public static final RegistryObject<DoubleCropBlock> KENAF_CROP = register("kenaf_crop", () -> new DoubleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.KENAF_FIBER, ModItems.KENAF_SEEDS));
	public static final RegistryObject<SimpleCropBlock> LETTUCE_CROP = register("lettuce_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.LETTUCE, ModItems.LETTUCE_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> OAT_CROP = register("oat_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.OAT, ModItems.OAT_SEEDS));
	public static final RegistryObject<SimpleCropBlock> ONION_CROP = register("onion_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.ONION, ModItems.ONION_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> PEANUT_CROP = register("peanut_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.PEANUT, ModItems.PEANUT_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> PEA_CROP = register("pea_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.PEA_POD, ModItems.PEA_SEEDS));
	public static final RegistryObject<SimpleCropBlock> PEPPER_CROP = register("pepper_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.PEPPER, ModItems.PEPPER_SEEDS));
	public static final RegistryObject<SimpleCropBlock> POTATO_CROP = register("potato_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), () -> Items.POTATO, ModItems.POTATO_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> RADISH_CROP = register("radish_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.RADISH, ModItems.RADISH_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> RICE_CROP = register("rice_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.RICE, ModItems.RICE_SEEDS));
	public static final RegistryObject<SimpleCropBlock> RYE_CROP = register("rye_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.RYE, ModItems.RYE_SEEDS));
	public static final RegistryObject<DoubleCropBlock> SORGHUM_CROP = register("sorghum_crop", () -> new DoubleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.SORGHUM, ModItems.SORGHUM_SEEDS));
	public static final RegistryObject<SimpleCropBlock> SOYBEAN_CROP = register("soybean_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.SOYBEAN, ModItems.SOYBEAN_SEEDS));
	public static final RegistryObject<SimpleCropBlock> SPINACH_CROP = register("spinach_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.SPINACH, ModItems.SPINACH_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<GourdCropBlock> SQUASH_CROP = register("squash_crop", () -> new GourdCropBlock(Block.Properties.of(Material.PLANT).randomTicks().strength(0.2f).sound(SoundType.HARD_CROP), ModItems.SQUASH_BLOCK, ModItems.SQUASH_SEEDS));
	public static final RegistryObject<SimpleCropBlock> SWEET_POTATO_CROP = register("sweet_potato_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.SWEET_POTATO, ModItems.SWEET_POTATO_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> TOMATO_CROP = register("tomato_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.TOMATO, ModItems.TOMATO_SEEDS));
	public static final RegistryObject<SimpleCropBlock> TURNIP_CROP = register("turnip_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.TURNIP, ModItems.TURNIP_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> YAM_CROP = register("yam_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.YAM, ModItems.YAM_SEEDS, ModVoxelShapes.SMALL_CROP_SHAPES_0_7));
	public static final RegistryObject<SimpleCropBlock> ZUCCHINI_CROP = register("zucchini_crop", () -> new SimpleCropBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP), ModItems.ZUCCHINI, ModItems.ZUCCHINI_SEEDS));

	// Alternate crops
	public static final RegistryObject<GourdCropBlock> MELON_CROP = register("melon_crop", () -> new GourdCropBlock(Block.Properties.of(Material.PLANT).randomTicks().strength(0.2f).sound(SoundType.HARD_CROP), () -> Items.MELON, () -> Items.MELON_SEEDS));
	public static final RegistryObject<GourdCropBlock> PUMPKIN_CROP = register("pumpkin_crop", () -> new GourdCropBlock(Block.Properties.of(Material.PLANT).randomTicks().strength(0.2f).sound(SoundType.HARD_CROP), () -> Items.PUMPKIN, () -> Items.PUMPKIN_SEEDS));

	// Hay Bales
	public static final RegistryObject<HayBlock> BARLEY_HAY_BLOCK = register("barley_hay_block", () -> new HayBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_GREEN).strength(0.5F).sound(SoundType.GRASS)));
	public static final RegistryObject<HayBlock> OAT_HAY_BLOCK = register("oat_hay_block", () -> new HayBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_YELLOW).strength(0.5F).sound(SoundType.GRASS)));
	public static final RegistryObject<HayBlock> RICE_HAY_BLOCK = register("rice_hay_block", () -> new HayBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_GREEN).strength(0.5F).sound(SoundType.GRASS)));
	public static final RegistryObject<HayBlock> RYE_HAY_BLOCK = register("rye_hay_block", () -> new HayBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_GREEN).strength(0.5F).sound(SoundType.GRASS)));

	// Flowers
	public static final RegistryObject<PlantBlock> CHICORY = register("chicory", () -> new PlantBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).sound(SoundType.GRASS)), ModItems.CHICORY_ROOT));
	public static final RegistryObject<PlantBlock> CUMIN = register("cumin", () -> new PlantBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).sound(SoundType.GRASS)), ModItems.CUMIN_SEEDS));
	public static final RegistryObject<PlantBlock> MARSHMALLOW = register("marshmallow", () -> new PlantBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).sound(SoundType.GRASS)), ModItems.MARSHMALLOW_ROOT));
	public static final RegistryObject<PlantBlock> QUINOA = register("quinoa", () -> new PlantBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).sound(SoundType.GRASS)), ModItems.QUINOA_SEEDS));
	public static final RegistryObject<PlantBlock> SUNFLOWER = register("sunflower",	() -> new PlantBlock((Block.Properties.of(Material.PLANT).randomTicks().noCollission().strength(0.2f).sound(SoundType.GRASS)), ModItems.SUNFLOWER_SEEDS));

	// Miscellaneous
	public static final RegistryObject<WildCropBlock> WILD_CROP = register("wild_crop", () -> new WildCropBlock(Block.Properties.of(Material.REPLACEABLE_PLANT).noCollission().strength(0).sound(SoundType.GRASS)));
	public static final RegistryObject<ScarecrowBlock> SCARECROW = register("scarecrow", () -> new ScarecrowBlock(Block.Properties.of(Material.PLANT).noCollission().strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<BrewingBarrelBlock> BREWING_BARREL = register("brewing_barrel", () -> new BrewingBarrelBlock(Block.Properties.of(Material.WOOD).randomTicks().strength(2.5F).sound(SoundType.WOOD)));

	// @formatter:on

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void registerBlocks() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}