package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

public class ModPlacements {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(
        Registries.PLACED_FEATURE, SimpleFarming.MOD_ID
    );

    public static final ResourceKey<PlacedFeature> APPLE_TREE_CHECKED = createKey("apple_tree_checked");
    public static final ResourceKey<PlacedFeature> APRICOT_TREE_CHECKED = createKey("apricot_tree_checked");
    public static final ResourceKey<PlacedFeature> BANANA_TREE_CHECKED = createKey("banana_tree_checked");
    public static final ResourceKey<PlacedFeature> CHERRY_TREE_CHECKED = createKey("cherry_tree_checked");
    public static final ResourceKey<PlacedFeature> MANGO_TREE_CHECKED = createKey("mango_tree_checked");
    public static final ResourceKey<PlacedFeature> OLIVE_TREE_CHECKED = createKey("olive_tree_checked");
    public static final ResourceKey<PlacedFeature> ORANGE_TREE_CHECKED = createKey("orange_tree_checked");
    public static final ResourceKey<PlacedFeature> PEAR_TREE_CHECKED = createKey("pear_tree_checked");
    public static final ResourceKey<PlacedFeature> PLUM_TREE_CHECKED = createKey("plum_tree_checked");

    public static final ResourceKey<PlacedFeature> BLACKBERRY_BUSH_CHECKED = createKey("blackberry_bush_checked");
    public static final ResourceKey<PlacedFeature> BLUEBERRY_BUSH_CHECKED = createKey("blueberry_bush_checked");
    public static final ResourceKey<PlacedFeature> RASPBERRY_BUSH_CHECKED = createKey("raspberry_bush_checked");
    public static final ResourceKey<PlacedFeature> STRAWBERRY_BUSH_CHECKED = createKey("strawberry_bush_checked");
    public static final ResourceKey<PlacedFeature> OPUNTIA_CHECKED = createKey("opuntia_checked");
    public static final ResourceKey<PlacedFeature> CHICORY_CHECKED = createKey("chicory_checked");
    public static final ResourceKey<PlacedFeature> CUMIN_CHECKED = createKey("cumin_checked");
    public static final ResourceKey<PlacedFeature> MARSHMALLOW_CHECKED = createKey("marshmallow_checked");
    public static final ResourceKey<PlacedFeature> QUINOA_CHECKED = createKey("quinoa_checked");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> APPLE_TREE = getter.getOrThrow(ModFeatures.APPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> APRICOT_TREE = getter.getOrThrow(ModFeatures.APRICOT_TREE);
        Holder<ConfiguredFeature<?, ?>> BANANA_TREE = getter.getOrThrow(ModFeatures.BANANA_TREE);
        Holder<ConfiguredFeature<?, ?>> CHERRY_TREE = getter.getOrThrow(ModFeatures.CHERRY_TREE);
        Holder<ConfiguredFeature<?, ?>> MANGO_TREE = getter.getOrThrow(ModFeatures.MANGO_TREE);
        Holder<ConfiguredFeature<?, ?>> OLIVE_TREE = getter.getOrThrow(ModFeatures.OLIVE_TREE);
        Holder<ConfiguredFeature<?, ?>> ORANGE_TREE = getter.getOrThrow(ModFeatures.ORANGE_TREE);
        Holder<ConfiguredFeature<?, ?>> PEAR_TREE = getter.getOrThrow(ModFeatures.PEAR_TREE);
        Holder<ConfiguredFeature<?, ?>> PLUM_TREE = getter.getOrThrow(ModFeatures.PLUM_TREE);

        Holder<ConfiguredFeature<?, ?>> BLACKBERRY_BUSH = getter.getOrThrow(ModFeatures.BLACKBERRY_BUSH);
        Holder<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH = getter.getOrThrow(ModFeatures.BLUEBERRY_BUSH);
        Holder<ConfiguredFeature<?, ?>> RASPBERRY_BUSH = getter.getOrThrow(ModFeatures.RASPBERRY_BUSH);
        Holder<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH = getter.getOrThrow(ModFeatures.STRAWBERRY_BUSH);
        Holder<ConfiguredFeature<?, ?>> OPUNTIA = getter.getOrThrow(ModFeatures.OPUNTIA);
        Holder<ConfiguredFeature<?, ?>> CHICORY = getter.getOrThrow(ModFeatures.CHICORY);
        Holder<ConfiguredFeature<?, ?>> CUMIN = getter.getOrThrow(ModFeatures.CUMIN);
        Holder<ConfiguredFeature<?, ?>> MARHSMALLOW = getter.getOrThrow(ModFeatures.MARSHMALLOW);
        Holder<ConfiguredFeature<?, ?>> QUINOA = getter.getOrThrow(ModFeatures.QUINOA);


        register(context, APPLE_TREE_CHECKED, APPLE_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.APPLE_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, APRICOT_TREE_CHECKED, APRICOT_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.APRICOT_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, BANANA_TREE_CHECKED, BANANA_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.BANANA_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, CHERRY_TREE_CHECKED, CHERRY_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.CHERRY_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, MANGO_TREE_CHECKED, MANGO_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.MANGO_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, OLIVE_TREE_CHECKED, OLIVE_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.OLIVE_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, ORANGE_TREE_CHECKED, ORANGE_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.ORANGE_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, PEAR_TREE_CHECKED, PEAR_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.PEAR_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, PLUM_TREE_CHECKED, PLUM_TREE, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.PLUM_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ));

        register(context, BLACKBERRY_BUSH_CHECKED, BLACKBERRY_BUSH, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.BLACKBERRY_BUSH.get()),
            RarityFilter.onAverageOnceEvery(80)
        ));

        register(context, BLUEBERRY_BUSH_CHECKED, BLUEBERRY_BUSH, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.BLUEBERRY_BUSH.get()),
            RarityFilter.onAverageOnceEvery(80)
        ));

        register(context, RASPBERRY_BUSH_CHECKED, RASPBERRY_BUSH, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.RASPBERRY_BUSH.get()),
            RarityFilter.onAverageOnceEvery(80)
        ));

        register(context, STRAWBERRY_BUSH_CHECKED, STRAWBERRY_BUSH, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.STRAWBERRY_BUSH.get()),
            RarityFilter.onAverageOnceEvery(80)
        ));

        register(context, OPUNTIA_CHECKED, OPUNTIA, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.OPUNTIA.get()),
            RarityFilter.onAverageOnceEvery(100),
            BiomeFilter.biome()
        ));

        register(context, CHICORY_CHECKED, CHICORY, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.CHICORY.get()),
            RarityFilter.onAverageOnceEvery(640)
        ));

        register(context, CUMIN_CHECKED, CUMIN, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.CUMIN.get()),
            RarityFilter.onAverageOnceEvery(640)
        ));

        register(context, MARSHMALLOW_CHECKED, MARHSMALLOW, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.MARSHMALLOW.get()),
            RarityFilter.onAverageOnceEvery(640)
        ));

        register(context, QUINOA_CHECKED, QUINOA, List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.QUINOA.get()),
            RarityFilter.onAverageOnceEvery(640)
        ));
    }

    public static ResourceKey<PlacedFeature> createKey(String pName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SimpleFarming.MOD_ID, pName));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(feature, modifiers));
    }
}
