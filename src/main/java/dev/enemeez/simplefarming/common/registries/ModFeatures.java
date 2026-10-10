package dev.enemeez.simplefarming.common.registries;

import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.world.features.DefaultFruitTreeFoliagePlacer;
import dev.enemeez.simplefarming.common.world.features.DwarfFruitTreeFoliagePlacer;
import dev.enemeez.simplefarming.common.world.features.TropicFruitTreeFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModFeatures {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(
        Registries.FOLIAGE_PLACER_TYPE, SimpleFarming.MOD_ID
    );

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> DEFAULT_FRUIT_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register(
        "default_fruit_tree_foliage_placer", () -> new FoliagePlacerType<>(DefaultFruitTreeFoliagePlacer.CODEC)
    );
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> DWARF_FRUIT_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register(
        "dwarf_fruit_tree_foliage_placer", () -> new FoliagePlacerType<>(DwarfFruitTreeFoliagePlacer.CODEC)
    );
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> TROPIC_FRUIT_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register(
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

    // Configured features are data-driven (src/generated/resources/.../worldgen); the 1.20 datagen bootstrap
    // that produced them used worldgen builders that no longer exist in 26.x, so only the keys remain here.


    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(SimpleFarming.MOD_ID, pName));
    }

}
