package enemeez.simplefarming.world.gen;

import javax.annotation.Nullable;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.config.EnableConfig;
import enemeez.simplefarming.init.ModWorldGen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class SimpleGeneration {

    private static ConfiguredFeature<?, ?> BERRY_BUSH_FEATURE = ModWorldGen.BERRY_BUSH.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
            .withPlacement(Features.Placements.FLOWER_TALL_GRASS_PLACEMENT.square()).func_242731_b(100);

    private static ConfiguredFeature<?, ?> FRUIT_TREE_FEATURE = ModWorldGen.FRUIT_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
            .withPlacement(Features.Placements.FLOWER_TALL_GRASS_PLACEMENT.square()).func_242731_b(100);

    private static ConfiguredFeature<?, ?> WILD_CROP_FEATURE = ModWorldGen.WILD_CROP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
            .withPlacement(Features.Placements.FLOWER_TALL_GRASS_PLACEMENT.square()).func_242731_b(100);

    private static ConfiguredFeature<?, ?> CACTUS_CROP_FEATURE = ModWorldGen.CACTUS_CROP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
            .withPlacement(Features.Placements.FLOWER_TALL_GRASS_PLACEMENT.square()).func_242731_b(100);

    private static ConfiguredFeature<?, ?> WILD_PLANT_FEATURE = ModWorldGen.WILD_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
            .withPlacement(Features.Placements.FLOWER_TALL_GRASS_PLACEMENT.square()).func_242731_b(100);

    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (isValidBiome(event.getCategory())) {
            BiomeGenerationSettingsBuilder generation = event.getGeneration();

            if (EnableConfig.bush_validate.get()) {
                addFeature(generation, BERRY_BUSH_FEATURE);
            }

            if (EnableConfig.tree_validate.get()) {
                addFeature(generation, FRUIT_TREE_FEATURE);
            }

            if (EnableConfig.wild_crop_validate.get()) {
                addFeature(generation, WILD_CROP_FEATURE);
            }

            if (EnableConfig.cactus_validate.get() && event.getCategory() == Biome.Category.DESERT) {
                addFeature(generation, CACTUS_CROP_FEATURE);
            }

            if (EnableConfig.wild_plant_validate.get()) {
                addFeature(generation, WILD_PLANT_FEATURE);
            }
        }
    }

    private static boolean isValidBiome(Biome.Category category) {
        return category != Biome.Category.THEEND & category != Biome.Category.NETHER;
    }

    private static void addFeature(BiomeGenerationSettingsBuilder generation, @Nullable ConfiguredFeature<?, ?> feature) {
        if (feature != null) {
            generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, feature);
        }
    }
    
    public static void configureFeature() {
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
        Registry.register(registry, new ResourceLocation(SimpleFarming.MOD_ID, "berry_bush"), BERRY_BUSH_FEATURE);
        Registry.register(registry, new ResourceLocation(SimpleFarming.MOD_ID, "fruit_tree"), FRUIT_TREE_FEATURE);
        Registry.register(registry, new ResourceLocation(SimpleFarming.MOD_ID, "wild_crop"), WILD_CROP_FEATURE);
        Registry.register(registry, new ResourceLocation(SimpleFarming.MOD_ID, "wild_plant"), WILD_PLANT_FEATURE);
        Registry.register(registry, new ResourceLocation(SimpleFarming.MOD_ID, "cactus_crop"), CACTUS_CROP_FEATURE);
    }
}