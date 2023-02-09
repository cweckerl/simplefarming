package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.block.BerryBushBlock;
import enemeez.simplefarming.common.block.CheeseBlock;
import enemeez.simplefarming.common.block.ChocolateCakeBlock;
import enemeez.simplefarming.common.block.ChocolateCandleCakeBlock;
import enemeez.simplefarming.common.block.DoubleCropBlock;
import enemeez.simplefarming.common.block.FermenterBlock;
import enemeez.simplefarming.common.block.FruitLeavesBlock;
import enemeez.simplefarming.common.block.FruitTreeLogBlock;
import enemeez.simplefarming.common.block.GourdAttachedStemBlock;
import enemeez.simplefarming.common.block.GourdStemBlock;
import enemeez.simplefarming.common.block.GrapeTrunkBlock;
import enemeez.simplefarming.common.block.GrapevineBlock;
import enemeez.simplefarming.common.block.GrapevineSourceBlock;
import enemeez.simplefarming.common.block.GrowableFlowerBlock;
import enemeez.simplefarming.common.block.OpuntiaBlock;
import enemeez.simplefarming.common.block.ScarecrowBlock;
import enemeez.simplefarming.common.block.SingleCropBlock;
import enemeez.simplefarming.common.block.SprinkleCakeBlock;
import enemeez.simplefarming.common.block.SprinkleCandleCakeBlock;
import enemeez.simplefarming.common.block.TrellisBlock;
import enemeez.simplefarming.common.world.grower.FruitTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimpleFarming.MOD_ID);
    public static final Set<RegistryObject<Block>> FOLIAGE_COLOR_BLOCKS = new HashSet<>();

    // Crops
    public static final RegistryObject<Block> BARLEY = registerCrop("barley", () -> ModItems.BARLEY_SEEDS.get());
    public static final RegistryObject<Block> BROCCOLI = registerCrop("broccoli", () -> ModItems.BROCCOLI_SEEDS.get());
    public static final RegistryObject<Block> CASSAVA = registerCrop("cassava", () -> ModItems.CASSAVA_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> CORN = registerDoubleCrop("corn", () -> ModItems.CORN_SEEDS.get());
    public static final RegistryObject<Block> COTTON = registerCrop("cotton", () -> ModItems.COTTON_SEEDS.get());
    public static final RegistryObject<Block> CUCUMBERS = registerCrop("cucumbers", () -> ModItems.CUCUMBER_SEEDS.get());
    public static final RegistryObject<Block> EGGPLANTS = registerCrop("eggplants", () -> ModItems.EGGPLANT_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> GINGER = registerCrop("ginger", () -> ModItems.GINGER_SEEDS.get());
    public static final RegistryObject<Block> KENAF = registerDoubleCrop("kenaf", () -> ModItems.KENAF_SEEDS.get());
    public static final RegistryObject<Block> LETTUCE = registerCrop("lettuce", () -> ModItems.LETTUCE_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> OAT = registerCrop("oat", () -> ModItems.OAT_SEEDS.get());
    public static final RegistryObject<Block> ONIONS = registerCrop("onions", () -> ModItems.ONION_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> PEANUTS = registerCrop("peanuts", () -> ModItems.PEANUT_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> PEAS = registerCrop("peas", () -> ModItems.PEA_SEEDS.get());
    public static final RegistryObject<Block> PEPPERS = registerCrop("peppers", () -> ModItems.PEPPER_SEEDS.get());
    public static final RegistryObject<Block> RADISHES = registerCrop("radishes", () -> ModItems.RADISH_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> RICE = registerCrop("rice", () -> ModItems.RICE_SEEDS.get());
    public static final RegistryObject<Block> RYE = registerCrop("rye", () -> ModItems.RYE_SEEDS.get());
    public static final RegistryObject<Block> SORGHUM = registerDoubleCrop("sorghum", () -> ModItems.SORGHUM_SEEDS.get());
    public static final RegistryObject<Block> SOYBEANS = registerCrop("soybeans", () -> ModItems.SOYBEAN_SEEDS.get());
    public static final RegistryObject<Block> SPINACH = registerCrop("spinach", () -> ModItems.SPINACH_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> SWEET_POTATOES = registerCrop("sweet_potatoes", () -> ModItems.SWEET_POTATO_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> TOMATOES = registerCrop("tomatoes", () -> ModItems.TOMATO_SEEDS.get());
    public static final RegistryObject<Block> TURNIPS = registerCrop("turnips", () -> ModItems.TURNIP_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> YAMS = registerCrop("yams", () -> ModItems.YAM_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final RegistryObject<Block> ZUCCHINIS = registerCrop("zucchinis", () -> ModItems.ZUCCHINI_SEEDS.get(), SingleCropBlock.Size.SMALL);

    // Wild bushes
    public static final RegistryObject<Block> BLACKBERRY_BUSH = registerBerryBush("blackberry_bush", () -> ModItems.BLACKBERRIES.get());
    public static final RegistryObject<Block> BLUEBERRY_BUSH = registerBerryBush("blueberry_bush", () -> ModItems.BLUEBERRIES.get());
    public static final RegistryObject<Block> RASPBERRY_BUSH = registerBerryBush("raspberry_bush", () -> ModItems.RASPBERRIES.get());
    public static final RegistryObject<Block> STRAWBERRY_BUSH = registerBerryBush("strawberry_bush", () -> ModItems.STRAWBERRIES.get());
    public static final RegistryObject<Block> OPUNTIA = BLOCKS.register("opuntia", () -> new OpuntiaBlock(
        BlockBehaviour.Properties.of(Material.CACTUS)
            .randomTicks()
            .strength(0.4F)
            .sound(SoundType.WOOL),
        () -> ModItems.CACTUS_FRUIT.get()
    ));

    // Cakes
    public static final RegistryObject<Block> CHOCOLATE_CAKE = registerChocolateCake("chocolate_cake");
    public static final RegistryObject<Block> CHOCOLATE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_candle_cake", Blocks.CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_WHITE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_white_candle_cake", Blocks.WHITE_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_ORANGE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_orange_candle_cake", Blocks.ORANGE_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_MAGENTA_CANDLE_CAKE = registerChocolateCandleCake("chocolate_magenta_candle_cake", Blocks.MAGENTA_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_LIGHT_BLUE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_light_blue_candle_cake", Blocks.LIGHT_BLUE_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_YELLOW_CANDLE_CAKE = registerChocolateCandleCake("chocolate_yellow_candle_cake", Blocks.YELLOW_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_LIME_CANDLE_CAKE = registerChocolateCandleCake("chocolate_lime_candle_cake", Blocks.LIME_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_PINK_CANDLE_CAKE = registerChocolateCandleCake("chocolate_pink_candle_cake", Blocks.PINK_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_GRAY_CANDLE_CAKE = registerChocolateCandleCake("chocolate_gray_candle_cake", Blocks.GRAY_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_LIGHT_GRAY_CANDLE_CAKE = registerChocolateCandleCake("chocolate_light_gray_candle_cake", Blocks.LIGHT_GRAY_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_CYAN_CANDLE_CAKE = registerChocolateCandleCake("chocolate_cyan_candle_cake", Blocks.CYAN_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_PURPLE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_purple_candle_cake", Blocks.PURPLE_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_BLUE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_blue_candle_cake", Blocks.BLUE_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_BROWN_CANDLE_CAKE = registerChocolateCandleCake("chocolate_brown_candle_cake", Blocks.BROWN_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_GREEN_CANDLE_CAKE = registerChocolateCandleCake("chocolate_green_candle_cake", Blocks.GREEN_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_RED_CANDLE_CAKE = registerChocolateCandleCake("chocolate_red_candle_cake", Blocks.RED_CANDLE);
    public static final RegistryObject<Block> CHOCOLATE_BLACK_CANDLE_CAKE = registerChocolateCandleCake("chocolate_black_candle_cake", Blocks.BLACK_CANDLE);

    public static final RegistryObject<Block> SPRINKLE_CAKE = registerSprinkleCake("sprinkle_cake");
    public static final RegistryObject<Block> SPRINKLE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_candle_cake", Blocks.CANDLE);
    public static final RegistryObject<Block> SPRINKLE_WHITE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_white_candle_cake", Blocks.WHITE_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_ORANGE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_orange_candle_cake", Blocks.ORANGE_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_MAGENTA_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_magenta_candle_cake", Blocks.MAGENTA_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_LIGHT_BLUE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_light_blue_candle_cake", Blocks.LIGHT_BLUE_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_YELLOW_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_yellow_candle_cake", Blocks.YELLOW_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_LIME_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_lime_candle_cake", Blocks.LIME_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_PINK_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_pink_candle_cake", Blocks.PINK_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_GRAY_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_gray_candle_cake", Blocks.GRAY_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_LIGHT_GRAY_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_light_gray_candle_cake", Blocks.LIGHT_GRAY_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_CYAN_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_cyan_candle_cake", Blocks.CYAN_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_PURPLE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_purple_candle_cake", Blocks.PURPLE_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_BLUE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_blue_candle_cake", Blocks.BLUE_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_BROWN_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_brown_candle_cake", Blocks.BROWN_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_GREEN_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_green_candle_cake", Blocks.GREEN_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_RED_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_red_candle_cake", Blocks.RED_CANDLE);
    public static final RegistryObject<Block> SPRINKLE_BLACK_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_black_candle_cake", Blocks.BLACK_CANDLE);

    // Cheese
    public static final RegistryObject<Block> CHEESE_WHEEL = BLOCKS.register("cheese_wheel", () -> new CheeseBlock(
        BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)
    ));

    // Hay bales
    public static final RegistryObject<Block> BARLEY_HAY_BLOCK = registerHayBale("barley_hay_block", MaterialColor.COLOR_YELLOW);
    public static final RegistryObject<Block> OAT_HAY_BLOCK = registerHayBale("oat_hay_block", MaterialColor.COLOR_YELLOW);
    public static final RegistryObject<Block> RICE_HAY_BLOCK = registerHayBale("rice_hay_block", MaterialColor.COLOR_LIGHT_GREEN);
    public static final RegistryObject<Block> RYE_HAY_BLOCK = registerHayBale("rye_hay_block", MaterialColor.COLOR_LIGHT_GREEN);

    // Growable flowers
    public static final RegistryObject<Block> CHICORY = registerGrowableFlower("chicory", () -> ModItems.CHICORY_ROOT.get());
    public static final RegistryObject<Block> CUMIN = registerGrowableFlower("cumin", () -> ModItems.CUMIN_SEEDS.get());
    public static final RegistryObject<Block> MARSHMALLOW = registerGrowableFlower("marshmallow", () -> ModItems.MARSHMALLOW_ROOT.get());
    public static final RegistryObject<Block> QUINOA = registerGrowableFlower("quinoa", () -> ModItems.QUINOA_SEEDS.get());

    // Gourd-like
    public static final RegistryObject<Block> CANTALOUPE = registerGourd("cantaloupe", MaterialColor.COLOR_LIGHT_GREEN);
    public static final RegistryObject<Block> HONEYDEW = registerGourd("honeydew", MaterialColor.COLOR_LIGHT_GREEN);
    public static final RegistryObject<Block> SQUASH = registerGourd("squash", MaterialColor.COLOR_YELLOW);

    // Gourd-like crops
    public static final RegistryObject<Block> CANTALOUPE_STEM = registerStem(
        "cantaloupe_stem", () -> ModItems.CANTALOUPE_SEEDS.get(), () -> ModBlocks.CANTALOUPE.get(), () -> ModBlocks.ATTACHED_CANTALOUPE_STEM.get()
    );
    public static final RegistryObject<Block> ATTACHED_CANTALOUPE_STEM = registerAttachedStem(
        "attached_cantaloupe_stem", () -> ModItems.CANTALOUPE_SEEDS.get(), () -> ModBlocks.CANTALOUPE.get(), () -> ModBlocks.CANTALOUPE_STEM.get()
    );
    public static final RegistryObject<Block> HONEYDEW_STEM = registerStem(
        "honeydew_stem", () -> ModItems.HONEYDEW_SEEDS.get(), () -> ModBlocks.HONEYDEW.get(), () -> ModBlocks.ATTACHED_HONEYDEW_STEM.get()
    );
    public static final RegistryObject<Block> ATTACHED_HONEYDEW_STEM = registerAttachedStem(
        "attached_honeydew_stem", () -> ModItems.HONEYDEW_SEEDS.get(), () -> ModBlocks.HONEYDEW.get(), () -> ModBlocks.HONEYDEW_STEM.get()
    );
    public static final RegistryObject<Block> SQUASH_STEM = registerStem(
        "squash_stem", () -> ModItems.SQUASH_SEEDS.get(), () -> ModBlocks.SQUASH.get(), () -> ModBlocks.ATTACHED_SQUASH_STEM.get()
    );
    public static final RegistryObject<Block> ATTACHED_SQUASH_STEM = registerAttachedStem(
        "attached_squash_stem", () -> ModItems.SQUASH_SEEDS.get(), () -> ModBlocks.SQUASH.get(), () -> ModBlocks.SQUASH_STEM.get()
    );

    // Fruit log
    public static final RegistryObject<Block> FRUIT_LOG = BLOCKS.register("fruit_log",
        () -> new FruitTreeLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL)
            .strength(2.0F)
            .sound(SoundType.WOOD)
        )
    );

    // Saplings
    public static final RegistryObject<Block> APPLE_SAPLING = registerSapling("apple_sapling", ModFeatures.APPLE_TREE);
    public static final RegistryObject<Block> APRICOT_SAPLING = registerSapling("apricot_sapling", ModFeatures.APRICOT_TREE);
    public static final RegistryObject<Block> BANANA_SAPLING = registerSapling("banana_sapling", ModFeatures.BANANA_TREE);
    public static final RegistryObject<Block> CHERRY_SAPLING = registerSapling("cherry_sapling", ModFeatures.CHERRY_TREE);
    public static final RegistryObject<Block> MANGO_SAPLING = registerSapling("mango_sapling", ModFeatures.MANGO_TREE);
    public static final RegistryObject<Block> OLIVE_SAPLING = registerSapling("olive_sapling", ModFeatures.OLIVE_TREE);
    public static final RegistryObject<Block> ORANGE_SAPLING = registerSapling("orange_sapling", ModFeatures.ORANGE_TREE);
    public static final RegistryObject<Block> PEAR_SAPLING = registerSapling("pear_sapling", ModFeatures.PEAR_TREE);
    public static final RegistryObject<Block> PLUM_SAPLING = registerSapling("plum_sapling", ModFeatures.PLUM_TREE);

    // Wild crop
    public static final RegistryObject<Block> WILD_CROP = BLOCKS.register("wild_crop", () -> new Block(
        BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
            .noCollission()
            .instabreak()
            .sound(SoundType.GRASS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
    ));

    // Fruit Leaves
    public static final RegistryObject<Block> APPLE_LEAVES = registerFruitLeaves("apple_leaves", () -> Items.APPLE);
    public static final RegistryObject<Block> APRICOT_LEAVES = registerFruitLeaves("apricot_leaves", () -> ModItems.APRICOT.get());
    public static final RegistryObject<Block> BANANA_LEAVES = registerFruitLeaves("banana_leaves", () -> ModItems.BANANA.get());
    public static final RegistryObject<Block> CHERRY_LEAVES = registerFruitLeaves("cherry_leaves", () -> ModItems.CHERRIES.get());
    public static final RegistryObject<Block> MANGO_LEAVES = registerFruitLeaves("mango_leaves", () -> ModItems.MANGO.get());
    public static final RegistryObject<Block> OLIVE_LEAVES = registerFruitLeaves("olive_leaves", () -> ModItems.OLIVES.get());
    public static final RegistryObject<Block> ORANGE_LEAVES = registerFruitLeaves("orange_leaves", () -> ModItems.ORANGE.get());
    public static final RegistryObject<Block> PEAR_LEAVES = registerFruitLeaves("pear_leaves", () -> ModItems.PEAR.get());
    public static final RegistryObject<Block> PLUM_LEAVES = registerFruitLeaves("plum_leaves", () -> ModItems.PLUM.get());

    // Scarecrow
    public static final RegistryObject<Block> SCARECROW = BLOCKS.register("scarecrow", () -> new ScarecrowBlock(
        BlockBehaviour.Properties.of(Material.PLANT)
            .noCollission()
            .strength(2.0F)
            .sound(SoundType.WOOD)
    ));

    // Trellis
    public static final RegistryObject<Block> TRELLIS = registerTrellis("trellis");

    // Grape crop
    public static final RegistryObject<Block> GRAPE_TRUNK = registerGrapeplant("grape_trunk", () -> ModItems.GRAPE_SEEDS.get());
    public static final RegistryObject<Block> GRAPEVINE = BLOCKS.register("grapevine", () -> new GrapevineBlock(
        BlockBehaviour.Properties.of(Material.PLANT)
            .randomTicks()
            .noCollission()
            .instabreak()
            .sound(SoundType.GRASS)
    ));

    public static final RegistryObject<Block> FERMENTER = BLOCKS.register("fermenter", () -> new FermenterBlock(
        BlockBehaviour.Properties.of(Material.STONE)
            .strength(3.5F)
            .noOcclusion()
            .requiresCorrectToolForDrops()
    ));

    private static RegistryObject<Block> registerCrop(final String name, Supplier<Item> seed) {
        return BLOCKS.register(name, () -> new SingleCropBlock(BlockBehaviour.Properties.of(Material.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP),
            seed
        ));
    }

    private static RegistryObject<Block> registerCrop(final String name, Supplier<Item> seed, SingleCropBlock.Size size) {
        return BLOCKS.register(name, () -> new SingleCropBlock(BlockBehaviour.Properties.of(Material.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP),
            seed, size
        ));
    }

    private static RegistryObject<Block> registerDoubleCrop(String name, Supplier<Item> seed) {

        final var TOP_BLOCK = BLOCKS.register(name + "_top", () -> new Block(
            BlockBehaviour.Properties.of(Material.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.CROP)
        ) {

            @Override
            public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
                if (pDirection == Direction.DOWN) {
                    if (!(pNeighborState.getBlock() instanceof DoubleCropBlock) || !pNeighborState.getValue(DoubleCropBlock.RIPE)) {
                        return Blocks.AIR.defaultBlockState();
                    }
                }
                return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
            }
        });

        return BLOCKS.register(name, () -> new DoubleCropBlock(
            BlockBehaviour.Properties.of(Material.PLANT)
                .noCollission()
                .randomTicks()
                .instabreak()
                .sound(SoundType.CROP),
            seed, TOP_BLOCK.get()
        ));
    }

    private static RegistryObject<Block> registerBerryBush(String name, Supplier<Item> berry) {
        final RegistryObject<Block> BLOCK = BLOCKS.register(name, () -> new BerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT)
            .randomTicks()
            .noCollission()
            .strength(0.2F)
            .sound(SoundType.SWEET_BERRY_BUSH),
            berry
        ));
        FOLIAGE_COLOR_BLOCKS.add(BLOCK);
        return BLOCK;
    }

    private static RegistryObject<Block> registerHayBale(String name, MaterialColor color) {
        return BLOCKS.register(name, () -> new HayBlock(BlockBehaviour.Properties.of(Material.GRASS, color)
            .strength(0.5F)
            .sound(SoundType.GRASS)
        ));
    }

    private static RegistryObject<Block> registerChocolateCake(String name) {
        return BLOCKS.register(name, () -> new ChocolateCakeBlock(BlockBehaviour.Properties.of(Material.CAKE)
            .strength(0.5F)
            .sound(SoundType.WOOL)
        ));
    }

    private static RegistryObject<Block> registerChocolateCandleCake(String name, Block candleBlock) {
        return BLOCKS.register(name, () -> new ChocolateCandleCakeBlock(candleBlock, BlockBehaviour.Properties.of(Material.CAKE)
            .strength(0.5F)
            .sound(SoundType.WOOL)
            .noOcclusion()
            .lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 3 : 0)
        ));
    }

    private static RegistryObject<Block> registerSprinkleCake(String name) {
        return BLOCKS.register(name, () -> new SprinkleCakeBlock(BlockBehaviour.Properties.of(Material.CAKE)
            .strength(0.5F)
            .sound(SoundType.WOOL)
        ));
    }

    private static RegistryObject<Block> registerSprinkleCandleCake(String name, Block candleBlock) {
        return BLOCKS.register(name, () -> new SprinkleCandleCakeBlock(candleBlock, BlockBehaviour.Properties.of(Material.CAKE)
            .strength(0.5F)
            .sound(SoundType.WOOL)
            .noOcclusion()
            .lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 3 : 0)
        ));
    }


    private static RegistryObject<Block> registerGrowableFlower(String name, Supplier<Item> seed) {
        return BLOCKS.register(name, () -> new GrowableFlowerBlock(BlockBehaviour.Properties.of(Material.PLANT)
            .randomTicks()
            .noCollission()
            .strength(0.2F)
            .sound(SoundType.GRASS)
            .offsetType(BlockBehaviour.OffsetType.XZ),
            seed
        ));
    }

    private static RegistryObject<Block> registerGourd(String name, MaterialColor color) {
        return BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, color)
            .strength(1.0F)
            .sound(SoundType.WOOD)
        ));
    }

    private static RegistryObject<Block> registerSapling(String name, ResourceKey<ConfiguredFeature<?, ?>> tree) {
        return BLOCKS.register(name, () -> new SaplingBlock(new FruitTreeGrower(tree), BlockBehaviour.Properties.of(Material.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.GRASS)
        ));
    }

    private static RegistryObject<Block> registerFruitLeaves(String name, Supplier<Item> fruit) {
        final RegistryObject<Block> BLOCK = BLOCKS.register(name, () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES)
            .strength(0.2F)
            .randomTicks()
            .sound(SoundType.GRASS)
            .noOcclusion()
            .isSuffocating((p1, p2, p3) -> false)
            .isViewBlocking((p1, p2, p3) -> false),
            fruit
        ));
        FOLIAGE_COLOR_BLOCKS.add(BLOCK);
        return BLOCK;
    }

    private static RegistryObject<Block> registerStem(
        String name, Supplier<Item> seed, Supplier<Block> fruit, Supplier<Block> attachedStem
    ) {
        return BLOCKS.register(name, () -> new GourdStemBlock(BlockBehaviour.Properties.of(Material.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.HARD_CROP),
            seed, fruit, attachedStem
        ));
    }

    private static RegistryObject<Block> registerAttachedStem(
        String name, Supplier<Item> seed, Supplier<Block> fruit, Supplier<Block> stem
    ) {
        return BLOCKS.register(name, () -> new GourdAttachedStemBlock(BlockBehaviour.Properties.of(Material.PLANT)
            .noCollission()
            .instabreak()
            .sound(SoundType.WOOD),
            seed, fruit, stem
        ));
    }

    private static RegistryObject<Block> registerGrapeplant(String name, Supplier<Item> seed) {

        final RegistryObject<Block> TOP_BLOCK = BLOCKS.register(name + "_top", () -> new GrapevineSourceBlock(
            BlockBehaviour.Properties.of(Material.LEAVES)
                .strength(0.2F)
                .randomTicks()
                .sound(SoundType.GRASS)
                .noOcclusion()
                .isSuffocating((p1, p2, p3) -> false)
                .isViewBlocking((p1, p2, p3) -> false)
        ) {
            @Override
            public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
                if (pDirection == Direction.DOWN) {
                    if (!(pNeighborState.getBlock() instanceof DoubleCropBlock) || !pNeighborState.getValue(DoubleCropBlock.RIPE)) {
                        return Blocks.AIR.defaultBlockState();
                    }
                }
                return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
            }
        });

        FOLIAGE_COLOR_BLOCKS.add(TOP_BLOCK);

        return BLOCKS.register(name, () -> new GrapeTrunkBlock(BlockBehaviour.Properties.of(Material.PLANT)
            .randomTicks()
            .strength(2.0F)
            .sound(SoundType.WOOD),
            seed, TOP_BLOCK.get()
        ));
    }

    private static RegistryObject<Block> registerTrellis(String name) {
        final RegistryObject<Block> BLOCK = BLOCKS.register(name, () -> new TrellisBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
                .randomTicks()
                .strength(2.0F, 3.0F)
                .sound(SoundType.WOOD)
        ));

        FOLIAGE_COLOR_BLOCKS.add(BLOCK);
        return BLOCK;
    }
}
