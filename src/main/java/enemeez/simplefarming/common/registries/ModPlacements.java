package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacements {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(
        Registry.PLACED_FEATURE_REGISTRY, SimpleFarming.MOD_ID
    );

    public static final RegistryObject<PlacedFeature> APPLE_TREE_CHECKED = PLACED_FEATURES.register("apple_tree_checked",
        () -> new PlacedFeature(ModFeatures.APPLE_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.APPLE_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> APRICOT_TREE_CHECKED = PLACED_FEATURES.register("apricot_tree_checked",
        () -> new PlacedFeature(ModFeatures.APRICOT_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.APRICOT_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> BANANA_TREE_CHECKED = PLACED_FEATURES.register("banana_tree_checked",
        () -> new PlacedFeature(ModFeatures.BANANA_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.BANANA_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> CHERRY_TREE_CHECKED = PLACED_FEATURES.register("cherry_tree_checked",
        () -> new PlacedFeature(ModFeatures.CHERRY_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.CHERRY_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> MANGO_TREE_CHECKED = PLACED_FEATURES.register("mango_tree_checked",
        () -> new PlacedFeature(ModFeatures.MANGO_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.MANGO_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> OLIVE_TREE_CHECKED = PLACED_FEATURES.register("olive_tree_checked",
        () -> new PlacedFeature(ModFeatures.OLIVE_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.OLIVE_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> ORANGE_TREE_CHECKED = PLACED_FEATURES.register("orange_tree_checked",
        () -> new PlacedFeature(ModFeatures.ORANGE_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.ORANGE_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> PEAR_TREE_CHECKED = PLACED_FEATURES.register("pear_tree_checked",
        () -> new PlacedFeature(ModFeatures.PEAR_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.PEAR_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> PLUM_TREE_CHECKED = PLACED_FEATURES.register("plum_tree_checked",
        () -> new PlacedFeature(ModFeatures.PLUM_TREE.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(ModBlocks.PLUM_SAPLING.get()),
            RarityFilter.onAverageOnceEvery(900)
        ))
    );

    public static final RegistryObject<PlacedFeature> BLACKBERRY_BUSH_CHECKED = PLACED_FEATURES.register("blackberry_bush_checked",
        () -> new PlacedFeature(ModFeatures.BLACKBERRY_BUSH.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.BLACKBERRY_BUSH.get()),
            RarityFilter.onAverageOnceEvery(80)
        ))
    );

    public static final RegistryObject<PlacedFeature> BLUEBERRY_BUSH_CHECKED = PLACED_FEATURES.register("blueberry_bush_checked",
        () -> new PlacedFeature(ModFeatures.BLUEBERRY_BUSH.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.BLUEBERRY_BUSH.get()),
            RarityFilter.onAverageOnceEvery(80)
        ))
    );

    public static final RegistryObject<PlacedFeature> RASPBERRY_BUSH_CHECKED = PLACED_FEATURES.register("raspberry_bush_checked",
        () -> new PlacedFeature(ModFeatures.RASPBERRY_BUSH.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.RASPBERRY_BUSH.get()),
            RarityFilter.onAverageOnceEvery(80)
        ))
    );

    public static final RegistryObject<PlacedFeature> STRAWBERRY_BUSH_CHECKED = PLACED_FEATURES.register("strawberry_bush_checked",
        () -> new PlacedFeature(ModFeatures.STRAWBERRY_BUSH.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.STRAWBERRY_BUSH.get()),
            RarityFilter.onAverageOnceEvery(80)
        ))
    );

    public static final RegistryObject<PlacedFeature> OPUNTIA_CHECKED = PLACED_FEATURES.register("opuntia_checked",
        () -> new PlacedFeature(ModFeatures.OPUNTIA.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.OPUNTIA.get()),
            RarityFilter.onAverageOnceEvery(100),
            BiomeFilter.biome()
        ))
    );

    public static final RegistryObject<PlacedFeature> CHICORY_CHECKED = PLACED_FEATURES.register("chicory_checked",
        () -> new PlacedFeature(ModFeatures.CHICORY.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.CHICORY.get()),
            RarityFilter.onAverageOnceEvery(640)
        ))
    );

    public static final RegistryObject<PlacedFeature> CUMIN_CHECKED = PLACED_FEATURES.register("cumin_checked",
        () -> new PlacedFeature(ModFeatures.CUMIN.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.CUMIN.get()),
            RarityFilter.onAverageOnceEvery(640)
        ))
    );

    public static final RegistryObject<PlacedFeature> MARSHMALLOW_CHECKED = PLACED_FEATURES.register("marshmallow_checked",
        () -> new PlacedFeature(ModFeatures.MARSHMALLOW.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.MARSHMALLOW.get()),
            RarityFilter.onAverageOnceEvery(640)
        ))
    );

    public static final RegistryObject<PlacedFeature> QUINOA_CHECKED = PLACED_FEATURES.register("quinoa_checked",
        () -> new PlacedFeature(ModFeatures.QUINOA.getHolder().get(), List.of(
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.QUINOA.get()),
            RarityFilter.onAverageOnceEvery(640)
        ))
    );
}
