package dev.enemeez.simplefarming.common.registries;

import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.block.BerryBushBlock;
import dev.enemeez.simplefarming.common.block.CheeseBlock;
import dev.enemeez.simplefarming.common.block.ChocolateCakeBlock;
import dev.enemeez.simplefarming.common.block.ChocolateCandleCakeBlock;
import dev.enemeez.simplefarming.common.block.DoubleCropBlock;
import dev.enemeez.simplefarming.common.block.FermenterBlock;
import dev.enemeez.simplefarming.common.block.FruitLeavesBlock;
import dev.enemeez.simplefarming.common.block.FruitTreeLogBlock;
import dev.enemeez.simplefarming.common.block.GourdAttachedStemBlock;
import dev.enemeez.simplefarming.common.block.GourdStemBlock;
import dev.enemeez.simplefarming.common.block.GrapeTrunkBlock;
import dev.enemeez.simplefarming.common.block.GrapevineBlock;
import dev.enemeez.simplefarming.common.block.GrapevineSourceBlock;
import dev.enemeez.simplefarming.common.block.GrowableFlowerBlock;
import dev.enemeez.simplefarming.common.block.OpuntiaBlock;
import dev.enemeez.simplefarming.common.block.ScarecrowBlock;
import dev.enemeez.simplefarming.common.block.SingleCropBlock;
import dev.enemeez.simplefarming.common.block.SprinkleCakeBlock;
import dev.enemeez.simplefarming.common.block.SprinkleCandleCakeBlock;
import dev.enemeez.simplefarming.common.block.TrellisBlock;
import dev.enemeez.simplefarming.common.world.grower.FruitTreeGrower;
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
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, SimpleFarming.MOD_ID);
    public static final Set<DeferredHolder<Block, Block>> FOLIAGE_COLOR_BLOCKS = new HashSet<>();

    // Crops
    public static final DeferredHolder<Block, Block> BARLEY = registerCrop("barley", () -> ModItems.BARLEY_SEEDS.get());
    public static final DeferredHolder<Block, Block> BROCCOLI = registerCrop("broccoli", () -> ModItems.BROCCOLI_SEEDS.get());
    public static final DeferredHolder<Block, Block> CASSAVA = registerCrop("cassava", () -> ModItems.CASSAVA_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> CORN = registerDoubleCrop("corn", () -> ModItems.CORN_SEEDS.get());
    public static final DeferredHolder<Block, Block> COTTON = registerCrop("cotton", () -> ModItems.COTTON_SEEDS.get());
    public static final DeferredHolder<Block, Block> CUCUMBERS = registerCrop("cucumbers", () -> ModItems.CUCUMBER_SEEDS.get());
    public static final DeferredHolder<Block, Block> EGGPLANTS = registerCrop("eggplants", () -> ModItems.EGGPLANT_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> GINGER = registerCrop("ginger", () -> ModItems.GINGER_SEEDS.get());
    public static final DeferredHolder<Block, Block> KENAF = registerDoubleCrop("kenaf", () -> ModItems.KENAF_SEEDS.get());
    public static final DeferredHolder<Block, Block> LETTUCE = registerCrop("lettuce", () -> ModItems.LETTUCE_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> OAT = registerCrop("oat", () -> ModItems.OAT_SEEDS.get());
    public static final DeferredHolder<Block, Block> ONIONS = registerCrop("onions", () -> ModItems.ONION_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> PEANUTS = registerCrop("peanuts", () -> ModItems.PEANUT_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> PEAS = registerCrop("peas", () -> ModItems.PEA_SEEDS.get());
    public static final DeferredHolder<Block, Block> PEPPERS = registerCrop("peppers", () -> ModItems.PEPPER_SEEDS.get());
    public static final DeferredHolder<Block, Block> RADISHES = registerCrop("radishes", () -> ModItems.RADISH_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> RICE = registerCrop("rice", () -> ModItems.RICE_SEEDS.get());
    public static final DeferredHolder<Block, Block> RYE = registerCrop("rye", () -> ModItems.RYE_SEEDS.get());
    public static final DeferredHolder<Block, Block> SORGHUM = registerDoubleCrop("sorghum", () -> ModItems.SORGHUM_SEEDS.get());
    public static final DeferredHolder<Block, Block> SOYBEANS = registerCrop("soybeans", () -> ModItems.SOYBEAN_SEEDS.get());
    public static final DeferredHolder<Block, Block> SPINACH = registerCrop("spinach", () -> ModItems.SPINACH_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> SWEET_POTATOES = registerCrop("sweet_potatoes", () -> ModItems.SWEET_POTATO_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> TOMATOES = registerCrop("tomatoes", () -> ModItems.TOMATO_SEEDS.get());
    public static final DeferredHolder<Block, Block> TURNIPS = registerCrop("turnips", () -> ModItems.TURNIP_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> YAMS = registerCrop("yams", () -> ModItems.YAM_SEEDS.get(), SingleCropBlock.Size.SMALL);
    public static final DeferredHolder<Block, Block> ZUCCHINIS = registerCrop("zucchinis", () -> ModItems.ZUCCHINI_SEEDS.get(), SingleCropBlock.Size.SMALL);

    // Wild bushes
    public static final DeferredHolder<Block, Block> BLACKBERRY_BUSH = registerBerryBush("blackberry_bush", () -> ModItems.BLACKBERRIES.get());
    public static final DeferredHolder<Block, Block> BLUEBERRY_BUSH = registerBerryBush("blueberry_bush", () -> ModItems.BLUEBERRIES.get());
    public static final DeferredHolder<Block, Block> RASPBERRY_BUSH = registerBerryBush("raspberry_bush", () -> ModItems.RASPBERRIES.get());
    public static final DeferredHolder<Block, Block> STRAWBERRY_BUSH = registerBerryBush("strawberry_bush", () -> ModItems.STRAWBERRIES.get());
    public static final DeferredHolder<Block, Block> OPUNTIA = BLOCKS.register("opuntia", () -> new OpuntiaBlock(
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .randomTicks()
            .strength(0.4F)
            .pushReaction(PushReaction.DESTROY)
            .sound(SoundType.WOOL),
        () -> ModItems.CACTUS_FRUIT.get()
    ));

    // Cakes
    public static final DeferredHolder<Block, Block> CHOCOLATE_CAKE = registerChocolateCake("chocolate_cake");
    public static final DeferredHolder<Block, Block> CHOCOLATE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_candle_cake", Blocks.CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_WHITE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_white_candle_cake", Blocks.WHITE_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_ORANGE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_orange_candle_cake", Blocks.ORANGE_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_MAGENTA_CANDLE_CAKE = registerChocolateCandleCake("chocolate_magenta_candle_cake", Blocks.MAGENTA_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_LIGHT_BLUE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_light_blue_candle_cake", Blocks.LIGHT_BLUE_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_YELLOW_CANDLE_CAKE = registerChocolateCandleCake("chocolate_yellow_candle_cake", Blocks.YELLOW_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_LIME_CANDLE_CAKE = registerChocolateCandleCake("chocolate_lime_candle_cake", Blocks.LIME_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_PINK_CANDLE_CAKE = registerChocolateCandleCake("chocolate_pink_candle_cake", Blocks.PINK_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_GRAY_CANDLE_CAKE = registerChocolateCandleCake("chocolate_gray_candle_cake", Blocks.GRAY_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_LIGHT_GRAY_CANDLE_CAKE = registerChocolateCandleCake("chocolate_light_gray_candle_cake", Blocks.LIGHT_GRAY_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_CYAN_CANDLE_CAKE = registerChocolateCandleCake("chocolate_cyan_candle_cake", Blocks.CYAN_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_PURPLE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_purple_candle_cake", Blocks.PURPLE_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_BLUE_CANDLE_CAKE = registerChocolateCandleCake("chocolate_blue_candle_cake", Blocks.BLUE_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_BROWN_CANDLE_CAKE = registerChocolateCandleCake("chocolate_brown_candle_cake", Blocks.BROWN_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_GREEN_CANDLE_CAKE = registerChocolateCandleCake("chocolate_green_candle_cake", Blocks.GREEN_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_RED_CANDLE_CAKE = registerChocolateCandleCake("chocolate_red_candle_cake", Blocks.RED_CANDLE);
    public static final DeferredHolder<Block, Block> CHOCOLATE_BLACK_CANDLE_CAKE = registerChocolateCandleCake("chocolate_black_candle_cake", Blocks.BLACK_CANDLE);

    public static final DeferredHolder<Block, Block> SPRINKLE_CAKE = registerSprinkleCake("sprinkle_cake");
    public static final DeferredHolder<Block, Block> SPRINKLE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_candle_cake", Blocks.CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_WHITE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_white_candle_cake", Blocks.WHITE_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_ORANGE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_orange_candle_cake", Blocks.ORANGE_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_MAGENTA_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_magenta_candle_cake", Blocks.MAGENTA_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_LIGHT_BLUE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_light_blue_candle_cake", Blocks.LIGHT_BLUE_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_YELLOW_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_yellow_candle_cake", Blocks.YELLOW_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_LIME_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_lime_candle_cake", Blocks.LIME_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_PINK_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_pink_candle_cake", Blocks.PINK_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_GRAY_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_gray_candle_cake", Blocks.GRAY_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_LIGHT_GRAY_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_light_gray_candle_cake", Blocks.LIGHT_GRAY_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_CYAN_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_cyan_candle_cake", Blocks.CYAN_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_PURPLE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_purple_candle_cake", Blocks.PURPLE_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_BLUE_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_blue_candle_cake", Blocks.BLUE_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_BROWN_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_brown_candle_cake", Blocks.BROWN_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_GREEN_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_green_candle_cake", Blocks.GREEN_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_RED_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_red_candle_cake", Blocks.RED_CANDLE);
    public static final DeferredHolder<Block, Block> SPRINKLE_BLACK_CANDLE_CAKE = registerSprinkleCandleCake("sprinkle_black_candle_cake", Blocks.BLACK_CANDLE);

    // Cheese
    public static final DeferredHolder<Block, Block> CHEESE_WHEEL = BLOCKS.register("cheese_wheel", () -> new CheeseBlock(
        BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)
    ));

    // Hay bales
    public static final DeferredHolder<Block, Block> BARLEY_HAY_BLOCK = registerHayBale("barley_hay_block", MapColor.COLOR_YELLOW);
    public static final DeferredHolder<Block, Block> OAT_HAY_BLOCK = registerHayBale("oat_hay_block", MapColor.COLOR_YELLOW);
    public static final DeferredHolder<Block, Block> RICE_HAY_BLOCK = registerHayBale("rice_hay_block", MapColor.COLOR_LIGHT_GREEN);
    public static final DeferredHolder<Block, Block> RYE_HAY_BLOCK = registerHayBale("rye_hay_block", MapColor.COLOR_LIGHT_GREEN);

    // Growable flowers
    public static final DeferredHolder<Block, Block> CHICORY = registerGrowableFlower("chicory", () -> ModItems.CHICORY_ROOT.get());
    public static final DeferredHolder<Block, Block> CUMIN = registerGrowableFlower("cumin", () -> ModItems.CUMIN_SEEDS.get());
    public static final DeferredHolder<Block, Block> MARSHMALLOW = registerGrowableFlower("marshmallow", () -> ModItems.MARSHMALLOW_ROOT.get());
    public static final DeferredHolder<Block, Block> QUINOA = registerGrowableFlower("quinoa", () -> ModItems.QUINOA_SEEDS.get());

    // Gourd-like
    public static final DeferredHolder<Block, Block> CANTALOUPE = registerGourd("cantaloupe", MapColor.COLOR_LIGHT_GREEN);
    public static final DeferredHolder<Block, Block> HONEYDEW = registerGourd("honeydew", MapColor.COLOR_LIGHT_GREEN);
    public static final DeferredHolder<Block, Block> SQUASH = registerGourd("squash", MapColor.COLOR_YELLOW);

    // Gourd-like crops
    public static final DeferredHolder<Block, Block> CANTALOUPE_STEM = registerStem(
        "cantaloupe_stem", () -> ModItems.CANTALOUPE_SEEDS.get(), () -> ModBlocks.CANTALOUPE.get(), () -> ModBlocks.ATTACHED_CANTALOUPE_STEM.get()
    );
    public static final DeferredHolder<Block, Block> ATTACHED_CANTALOUPE_STEM = registerAttachedStem(
        "attached_cantaloupe_stem", () -> ModItems.CANTALOUPE_SEEDS.get(), () -> ModBlocks.CANTALOUPE.get(), () -> ModBlocks.CANTALOUPE_STEM.get()
    );
    public static final DeferredHolder<Block, Block> HONEYDEW_STEM = registerStem(
        "honeydew_stem", () -> ModItems.HONEYDEW_SEEDS.get(), () -> ModBlocks.HONEYDEW.get(), () -> ModBlocks.ATTACHED_HONEYDEW_STEM.get()
    );
    public static final DeferredHolder<Block, Block> ATTACHED_HONEYDEW_STEM = registerAttachedStem(
        "attached_honeydew_stem", () -> ModItems.HONEYDEW_SEEDS.get(), () -> ModBlocks.HONEYDEW.get(), () -> ModBlocks.HONEYDEW_STEM.get()
    );
    public static final DeferredHolder<Block, Block> SQUASH_STEM = registerStem(
        "squash_stem", () -> ModItems.SQUASH_SEEDS.get(), () -> ModBlocks.SQUASH.get(), () -> ModBlocks.ATTACHED_SQUASH_STEM.get()
    );
    public static final DeferredHolder<Block, Block> ATTACHED_SQUASH_STEM = registerAttachedStem(
        "attached_squash_stem", () -> ModItems.SQUASH_SEEDS.get(), () -> ModBlocks.SQUASH.get(), () -> ModBlocks.SQUASH_STEM.get()
    );

    // Fruit log
    public static final DeferredHolder<Block, Block> FRUIT_LOG = BLOCKS.register("fruit_log",
        () -> new FruitTreeLogBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .strength(2.0F)
            .sound(SoundType.WOOD)
        )
    );

    // Saplings
    public static final DeferredHolder<Block, Block> APPLE_SAPLING = registerSapling("apple_sapling", ModFeatures.APPLE_TREE);
    public static final DeferredHolder<Block, Block> APRICOT_SAPLING = registerSapling("apricot_sapling", ModFeatures.APRICOT_TREE);
    public static final DeferredHolder<Block, Block> BANANA_SAPLING = registerSapling("banana_sapling", ModFeatures.BANANA_TREE);
    public static final DeferredHolder<Block, Block> CHERRY_SAPLING = registerSapling("cherry_sapling", ModFeatures.CHERRY_TREE);
    public static final DeferredHolder<Block, Block> MANGO_SAPLING = registerSapling("mango_sapling", ModFeatures.MANGO_TREE);
    public static final DeferredHolder<Block, Block> OLIVE_SAPLING = registerSapling("olive_sapling", ModFeatures.OLIVE_TREE);
    public static final DeferredHolder<Block, Block> ORANGE_SAPLING = registerSapling("orange_sapling", ModFeatures.ORANGE_TREE);
    public static final DeferredHolder<Block, Block> PEAR_SAPLING = registerSapling("pear_sapling", ModFeatures.PEAR_TREE);
    public static final DeferredHolder<Block, Block> PLUM_SAPLING = registerSapling("plum_sapling", ModFeatures.PLUM_TREE);

    // Wild crop
    public static final DeferredHolder<Block, Block> WILD_CROP = BLOCKS.register("wild_crop", () -> new Block(
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .instabreak()
            .sound(SoundType.GRASS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    ));

    // Fruit Leaves
    public static final DeferredHolder<Block, Block> APPLE_LEAVES = registerFruitLeaves("apple_leaves", () -> Items.APPLE);
    public static final DeferredHolder<Block, Block> APRICOT_LEAVES = registerFruitLeaves("apricot_leaves", () -> ModItems.APRICOT.get());
    public static final DeferredHolder<Block, Block> BANANA_LEAVES = registerFruitLeaves("banana_leaves", () -> ModItems.BANANA.get());
    public static final DeferredHolder<Block, Block> CHERRY_LEAVES = registerFruitLeaves("cherry_leaves", () -> ModItems.CHERRIES.get());
    public static final DeferredHolder<Block, Block> MANGO_LEAVES = registerFruitLeaves("mango_leaves", () -> ModItems.MANGO.get());
    public static final DeferredHolder<Block, Block> OLIVE_LEAVES = registerFruitLeaves("olive_leaves", () -> ModItems.OLIVES.get());
    public static final DeferredHolder<Block, Block> ORANGE_LEAVES = registerFruitLeaves("orange_leaves", () -> ModItems.ORANGE.get());
    public static final DeferredHolder<Block, Block> PEAR_LEAVES = registerFruitLeaves("pear_leaves", () -> ModItems.PEAR.get());
    public static final DeferredHolder<Block, Block> PLUM_LEAVES = registerFruitLeaves("plum_leaves", () -> ModItems.PLUM.get());

    // Scarecrow
    public static final DeferredHolder<Block, Block> SCARECROW = BLOCKS.register("scarecrow", () -> new ScarecrowBlock(
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .strength(2.0F)
            .sound(SoundType.WOOD)
            .pushReaction(PushReaction.DESTROY)
    ));

    // Trellis
    public static final DeferredHolder<Block, Block> TRELLIS = registerTrellis("trellis");

    // Grape crop
    public static final DeferredHolder<Block, Block> GRAPE_TRUNK = registerGrapeplant("grape_trunk", () -> ModItems.GRAPE_SEEDS.get());
    public static final DeferredHolder<Block, Block> GRAPEVINE = BLOCKS.register("grapevine", () -> new GrapevineBlock(
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .randomTicks()
            .noCollission()
            .instabreak()
            .sound(SoundType.GRASS)
            .pushReaction(PushReaction.DESTROY)
    ));

    public static final DeferredHolder<Block, Block> FERMENTER = BLOCKS.register("fermenter", () -> new FermenterBlock(
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .strength(3.5F)
            .noOcclusion()
            .requiresCorrectToolForDrops()
    ));

    private static DeferredHolder<Block, Block> registerCrop(final String name, Supplier<Item> seed) {
        return BLOCKS.register(name, () -> new SingleCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .pushReaction(PushReaction.DESTROY)
            .sound(SoundType.CROP),
            seed
        ));
    }

    private static DeferredHolder<Block, Block> registerCrop(final String name, Supplier<Item> seed, SingleCropBlock.Size size) {
        return BLOCKS.register(name, () -> new SingleCropBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .pushReaction(PushReaction.DESTROY)
            .sound(SoundType.CROP),
            seed, size
        ));
    }

    private static DeferredHolder<Block, Block> registerDoubleCrop(String name, Supplier<Item> seed) {

        final var TOP_BLOCK = BLOCKS.register(name + "_top", () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.CROP)
                .pushReaction(PushReaction.DESTROY)
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
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .randomTicks()
                .instabreak()
                .pushReaction(PushReaction.DESTROY)
                .sound(SoundType.CROP),
            seed, TOP_BLOCK.get()
        ));
    }

    private static DeferredHolder<Block, Block> registerBerryBush(String name, Supplier<Item> berry) {
        final DeferredHolder<Block, Block> BLOCK = BLOCKS.register(name, () -> new BerryBushBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .randomTicks()
            .noCollission()
            .strength(0.2F)
            .pushReaction(PushReaction.DESTROY)
            .sound(SoundType.SWEET_BERRY_BUSH),
            berry
        ));
        FOLIAGE_COLOR_BLOCKS.add(BLOCK);
        return BLOCK;
    }

    private static DeferredHolder<Block, Block> registerHayBale(String name, MapColor color) {
        return BLOCKS.register(name, () -> new HayBlock(BlockBehaviour.Properties.of()
            .mapColor(color)
            .strength(0.5F)
            .sound(SoundType.GRASS)
            .instrument(NoteBlockInstrument.BANJO)
        ));
    }

    private static DeferredHolder<Block, Block> registerChocolateCake(String name) {
        return BLOCKS.register(name, () -> new ChocolateCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));
    }

    private static DeferredHolder<Block, Block> registerChocolateCandleCake(String name, Block candleBlock) {
        return BLOCKS.register(name, () -> new ChocolateCandleCakeBlock(candleBlock, BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE)));
    }

    private static DeferredHolder<Block, Block> registerSprinkleCake(String name) {
        return BLOCKS.register(name, () -> new SprinkleCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));
    }

    private static DeferredHolder<Block, Block> registerSprinkleCandleCake(String name, Block candleBlock) {
        return BLOCKS.register(name, () -> new SprinkleCandleCakeBlock(candleBlock, BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE)));
    }

    private static DeferredHolder<Block, Block> registerGrowableFlower(String name, Supplier<Item> seed) {
        return BLOCKS.register(name, () -> new GrowableFlowerBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .randomTicks()
            .noCollission()
            .strength(0.2F)
            .sound(SoundType.GRASS)
            .pushReaction(PushReaction.DESTROY)
            .offsetType(BlockBehaviour.OffsetType.XZ),
            seed
        ));
    }

    private static DeferredHolder<Block, Block> registerGourd(String name, MapColor color) {
        return BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(color)
            .strength(1.0F)
            .sound(SoundType.WOOD)
            .pushReaction(PushReaction.DESTROY)
        ));
    }

    private static DeferredHolder<Block, Block> registerSapling(String name, ResourceKey<ConfiguredFeature<?, ?>> tree) {
        return BLOCKS.register(name, () -> new SaplingBlock(FruitTreeGrower.create(name, tree), BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.GRASS)
            .pushReaction(PushReaction.DESTROY)
        ));
    }

    private static DeferredHolder<Block, Block> registerFruitLeaves(String name, Supplier<Item> fruit) {
        final DeferredHolder<Block, Block> BLOCK = BLOCKS.register(name, () -> new FruitLeavesBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .strength(0.2F)
            .randomTicks()
            .sound(SoundType.GRASS)
            .noOcclusion()
            .pushReaction(PushReaction.DESTROY)
            .isSuffocating((p1, p2, p3) -> false)
            .isViewBlocking((p1, p2, p3) -> false),
            fruit
        ));
        FOLIAGE_COLOR_BLOCKS.add(BLOCK);
        return BLOCK;
    }

    private static DeferredHolder<Block, Block> registerStem(
        String name, Supplier<Item> seed, Supplier<Block> fruit, Supplier<Block> attachedStem
    ) {
        return BLOCKS.register(name, () -> new GourdStemBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.HARD_CROP),
            seed, fruit, attachedStem
        ));
    }

    private static DeferredHolder<Block, Block> registerAttachedStem(
        String name, Supplier<Item> seed, Supplier<Block> fruit, Supplier<Block> stem
    ) {
        return BLOCKS.register(name, () -> new GourdAttachedStemBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
            .noCollission()
            .instabreak()
            .pushReaction(PushReaction.DESTROY)
            .sound(SoundType.WOOD),
            seed, fruit, stem
        ));
    }

    private static DeferredHolder<Block, Block> registerGrapeplant(String name, Supplier<Item> seed) {

        final DeferredHolder<Block, Block> TOP_BLOCK = BLOCKS.register(name + "_top", () -> new GrapevineSourceBlock(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .strength(0.2F)
                .randomTicks()
                .sound(SoundType.GRASS)
                .noOcclusion()
                .isSuffocating((p1, p2, p3) -> false)
                .isViewBlocking((p1, p2, p3) -> false)
                .pushReaction(PushReaction.DESTROY)
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

        return BLOCKS.register(name, () -> new GrapeTrunkBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .randomTicks()
            .strength(2.0F)
            .pushReaction(PushReaction.DESTROY)
            .forceSolidOff() // temp solution
            .sound(SoundType.WOOD),
            seed, TOP_BLOCK.get()
        ));
    }

    private static DeferredHolder<Block, Block> registerTrellis(String name) {
        final DeferredHolder<Block, Block> BLOCK = BLOCKS.register(name, () -> new TrellisBlock(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .randomTicks()
                .strength(2.0F, 3.0F)
                .sound(SoundType.WOOD)
        ));

        FOLIAGE_COLOR_BLOCKS.add(BLOCK);
        return BLOCK;
    }
}
