package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.block.FruitTreeLogBlock;
import enemeez.simplefarming.common.block.GrowableBushBlock;
import enemeez.simplefarming.common.world.features.DefaultFruitTreeFoliagePlacer;
import enemeez.simplefarming.common.world.features.DwarfFruitTreeFoliagePlacer;
import enemeez.simplefarming.common.world.features.TropicFruitTreeFoliagePlacer;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(
        ForgeRegistries.FOLIAGE_PLACER_TYPES, SimpleFarming.MOD_ID
    );

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(
        Registry.CONFIGURED_FEATURE_REGISTRY, SimpleFarming.MOD_ID
    );

    public static final RegistryObject<FoliagePlacerType<?>> DEFAULT_FRUIT_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register(
        "default_fruit_tree_foliage_placer", () -> new FoliagePlacerType<>(DefaultFruitTreeFoliagePlacer.CODEC)
    );
    public static final RegistryObject<FoliagePlacerType<?>> DWARF_FRUIT_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register(
        "dwarf_fruit_tree_foliage_placer", () -> new FoliagePlacerType<>(DwarfFruitTreeFoliagePlacer.CODEC)
    );
    public static final RegistryObject<FoliagePlacerType<?>> TROPIC_FRUIT_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register(
        "tropic_fruit_tree_foliage_placer", () -> new FoliagePlacerType<>(TropicFruitTreeFoliagePlacer.CODEC)
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> APPLE_TREE = CONFIGURED_FEATURES.register("apple_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.MEDIUM)),
            new StraightTrunkPlacer(4, 0, 0),
            BlockStateProvider.simple(ModBlocks.APPLE_LEAVES.get()),
            new DefaultFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> APRICOT_TREE = CONFIGURED_FEATURES.register("apricot_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.APRICOT_LEAVES.get()),
            new DwarfFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> BANANA_TREE = CONFIGURED_FEATURES.register("banana_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.LARGE)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.BANANA_LEAVES.get()),
            new TropicFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE = CONFIGURED_FEATURES.register("cherry_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.CHERRY_LEAVES.get()),
            new DwarfFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> MANGO_TREE = CONFIGURED_FEATURES.register("mango_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.MEDIUM)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.MANGO_LEAVES.get()),
            new DefaultFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> OLIVE_TREE = CONFIGURED_FEATURES.register("olive_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.OLIVE_LEAVES.get()),
            new DwarfFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE = CONFIGURED_FEATURES.register("orange_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(4, 0, 0),
            BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get()),
            new DefaultFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> PEAR_TREE = CONFIGURED_FEATURES.register("pear_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.MEDIUM)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.PEAR_LEAVES.get()),
            new DefaultFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> PLUM_TREE = CONFIGURED_FEATURES.register("plum_tree",
        () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.PLUM_LEAVES.get()),
            new DwarfFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build())
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACKBERRY_BUSH = CONFIGURED_FEATURES.register("blackberry_bush",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLACKBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH = CONFIGURED_FEATURES.register("blueberry_bush",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> RASPBERRY_BUSH = CONFIGURED_FEATURES.register("raspberry_bush",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RASPBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH = CONFIGURED_FEATURES.register("strawberry_bush",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STRAWBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> OPUNTIA = CONFIGURED_FEATURES.register("opuntia",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 1, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.OPUNTIA.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHICORY = CONFIGURED_FEATURES.register("chicory",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHICORY.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> CUMIN = CONFIGURED_FEATURES.register("cumin",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CUMIN.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> MARSHMALLOW = CONFIGURED_FEATURES.register("marshmallow",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MARSHMALLOW.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> QUINOA = CONFIGURED_FEATURES.register("quinoa",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.QUINOA.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ))
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> WILD_CROP = CONFIGURED_FEATURES.register("wild_crop",
        () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_CROP.get()
                .defaultBlockState()
            )))
        ))
    );
}
