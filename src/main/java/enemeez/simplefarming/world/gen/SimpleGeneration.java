package enemeez.simplefarming.world.gen;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.config.EnableConfig;
import enemeez.simplefarming.init.ModWorldGen;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import javax.annotation.Nullable;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.worldSurfaceSquaredWithCount;

public class SimpleGeneration {

    private static class Configured {
        // Probably don't need custom features for some of this but they work so I don't want to touch them right now. Maybe in a future PR??
        private static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BERRY_BUSH = FeatureUtils.register(SimpleFarming.MOD_ID + ":berry_bush", ModWorldGen.BERRY_BUSH.get(), new NoneFeatureConfiguration());
        private static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FRUIT_TREE = FeatureUtils.register(SimpleFarming.MOD_ID + ":fruit_tree", ModWorldGen.FRUIT_TREE.get(), new NoneFeatureConfiguration());
        private static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> WILD_CROP = FeatureUtils.register(SimpleFarming.MOD_ID + ":wild_crop", ModWorldGen.WILD_CROP.get(), new NoneFeatureConfiguration());
        private static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CACTUS_CROP = FeatureUtils.register(SimpleFarming.MOD_ID + ":cactus_crop", ModWorldGen.CACTUS_CROP.get(), new NoneFeatureConfiguration());
        private static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> WILD_PLANT = FeatureUtils.register(SimpleFarming.MOD_ID + ":wild_plant", ModWorldGen.WILD_PLANT.get(), new NoneFeatureConfiguration());
    }

    private static class Placements {
        private static final Holder<PlacedFeature> BERRY_BUSH = PlacementUtils.register(SimpleFarming.MOD_ID + ":berry_bush", Configured.BERRY_BUSH, worldSurfaceSquaredWithCount(100));
        private static final Holder<PlacedFeature> FRUIT_TREE = PlacementUtils.register(SimpleFarming.MOD_ID + ":fruit_tree", Configured.FRUIT_TREE, worldSurfaceSquaredWithCount(100));
        private static final Holder<PlacedFeature> WILD_CROP = PlacementUtils.register(SimpleFarming.MOD_ID + ":wild_crop", Configured.WILD_CROP, worldSurfaceSquaredWithCount(100));
        private static final Holder<PlacedFeature> CACTUS_CROP = PlacementUtils.register(SimpleFarming.MOD_ID + ":cactus_crop", Configured.CACTUS_CROP, worldSurfaceSquaredWithCount(100));
        private static final Holder<PlacedFeature> WILD_PLANT = PlacementUtils.register(SimpleFarming.MOD_ID + ":wild_plant", Configured.WILD_PLANT, worldSurfaceSquaredWithCount(100));
    }

    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (isValidBiome(event.getCategory())) {
            BiomeGenerationSettingsBuilder generation = event.getGeneration();

            if (EnableConfig.bush_validate.get()) {
                addFeature(generation, Placements.BERRY_BUSH);
            }

            if (EnableConfig.tree_validate.get()) {
                addFeature(generation, Placements.FRUIT_TREE);
            }

            if (EnableConfig.wild_crop_validate.get()) {
                addFeature(generation, Placements.WILD_CROP);
            }

            if (EnableConfig.cactus_validate.get() && event.getCategory() == Biome.BiomeCategory.DESERT) {
                addFeature(generation, Placements.CACTUS_CROP);
            }

            if (EnableConfig.wild_plant_validate.get()) {
                addFeature(generation, Placements.WILD_PLANT);
            }
        }
    }

    private static boolean isValidBiome(Biome.BiomeCategory category) {
        return category != Biome.BiomeCategory.THEEND & category != Biome.BiomeCategory.NETHER;
    }

    private static void addFeature(BiomeGenerationSettingsBuilder generation, @Nullable Holder<PlacedFeature> feature) {
        if (feature != null) {
            generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
        }
    }
}