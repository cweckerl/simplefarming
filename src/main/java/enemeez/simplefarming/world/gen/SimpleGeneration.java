package enemeez.simplefarming.world.gen;

import enemeez.simplefarming.config.EnableConfig;
import enemeez.simplefarming.init.ModWorldGen;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

public class SimpleGeneration {

	public static void registerWorldGen() {

		if (EnableConfig.bush_validate.get()) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						ModWorldGen.BERRY_BUSH.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(100))));
			}
			if (EnableConfig.tree_validate.get()) {
				for (Biome biome : ForgeRegistries.BIOMES) {
					biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							ModWorldGen.FRUIT_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
									.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(100))));
				}
			}
			if (EnableConfig.wild_crop_validate.get()) {
				for (Biome biome : ForgeRegistries.BIOMES) {
					biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							ModWorldGen.WILD_CROP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
									.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(100))));
				}
			}
			if (EnableConfig.cactus_validate.get()) {
				BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY).forEach((biome) -> {
					biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							ModWorldGen.CACTUS_CROP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
									.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(100))));
				});

			}
			if (EnableConfig.wild_plant_validate.get()) {
				for (Biome biome : ForgeRegistries.BIOMES) {
					biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							ModWorldGen.WILD_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
									.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(100))));
				}
			}
		}
	}

}
