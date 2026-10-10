package dev.enemeez.simplefarming.common.registries;

import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.neoforge.registries.DeferredRegister;


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

    // Placed features are data-driven (src/generated/resources/.../worldgen); see ModFeatures.


    public static ResourceKey<PlacedFeature> createKey(String pName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(SimpleFarming.MOD_ID, pName));
    }

}
