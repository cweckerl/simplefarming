package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.block.FruitTreeLogBlock;
import enemeez.simplefarming.common.block.GrowableBushBlock;
import enemeez.simplefarming.common.world.features.DefaultFruitTreeFoliagePlacer;
import enemeez.simplefarming.common.world.features.DwarfFruitTreeFoliagePlacer;
import enemeez.simplefarming.common.world.features.TropicFruitTreeFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(
        Registries.FOLIAGE_PLACER_TYPE, SimpleFarming.MOD_ID
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_TREE = createKey("apple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APRICOT_TREE = createKey("apricot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA_TREE = createKey("banana_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_TREE = createKey("cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_TREE = createKey("mango_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE_TREE = createKey("olive_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_TREE = createKey("orange_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_TREE = createKey("pear_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM_TREE = createKey("plum_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKBERRY_BUSH = createKey("blackberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH = createKey("blueberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RASPBERRY_BUSH = createKey("raspberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH = createKey("strawberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OPUNTIA = createKey("opuntia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHICORY = createKey("chicory");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CUMIN = createKey("cumin");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MARSHMALLOW = createKey("marshmallow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUINOA = createKey("quinoa");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_CROP = createKey("wild_crop");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, APPLE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.MEDIUM)),
            new StraightTrunkPlacer(4, 0, 0),
            BlockStateProvider.simple(ModBlocks.APPLE_LEAVES.get()),
            new DefaultFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, APRICOT_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.APRICOT_LEAVES.get()),
            new DwarfFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, BANANA_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.LARGE)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.BANANA_LEAVES.get()),
            new TropicFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, CHERRY_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.CHERRY_LEAVES.get()),
            new DwarfFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, MANGO_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.MEDIUM)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.MANGO_LEAVES.get()),
            new DefaultFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, OLIVE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.OLIVE_LEAVES.get()),
            new DwarfFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, ORANGE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(4, 0, 0),
            BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get()),
            new DefaultFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, PEAR_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.MEDIUM)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.PEAR_LEAVES.get()),
            new DefaultFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, PLUM_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.FRUIT_LOG.get().defaultBlockState().setValue(FruitTreeLogBlock.SIZE, FruitTreeLogBlock.Size.SMALL)),
            new StraightTrunkPlacer(3, 0, 0),
            BlockStateProvider.simple(ModBlocks.PLUM_LEAVES.get()),
            new DwarfFruitTreeFoliagePlacer(),
            new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, BLACKBERRY_BUSH, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLACKBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, BLUEBERRY_BUSH, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, RASPBERRY_BUSH, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RASPBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, STRAWBERRY_BUSH, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RASPBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, OPUNTIA, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 1, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.OPUNTIA.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, CHICORY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHICORY.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, CUMIN, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CUMIN.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, MARSHMALLOW, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MARSHMALLOW.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, QUINOA, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.QUINOA.get()
                .defaultBlockState()
                .setValue(GrowableBushBlock.AGE, GrowableBushBlock.MAX_AGE)
            )))
        ));

        register(context, WILD_CROP, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 2, 1,
            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_CROP.get()
                .defaultBlockState()
            )))
        ));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SimpleFarming.MOD_ID, pName));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
        BootstapContext<ConfiguredFeature<?, ?>> pContext, ResourceKey<ConfiguredFeature<?, ?>> pKey, F pFeature, FC pConfig
    ) {
        pContext.register(pKey, new ConfiguredFeature<>(pFeature, pConfig));
    }
}
