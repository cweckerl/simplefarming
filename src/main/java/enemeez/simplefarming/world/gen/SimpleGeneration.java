package enemeez.simplefarming.world.gen;

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

		if (ModWorldGen.berry_bush != null) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						ModWorldGen.berry_bush.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG)
								.func_227228_a_(Placement.COUNT_HEIGHTMAP.func_227446_a_(new FrequencyConfig(100))));
			}
			if (ModWorldGen.fruit_tree != null) {
				for (Biome biome : ForgeRegistries.BIOMES) {
					biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							ModWorldGen.fruit_tree.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG).func_227228_a_(
									Placement.COUNT_HEIGHTMAP.func_227446_a_(new FrequencyConfig(100))));
				}
			}
			if (ModWorldGen.wild_crop != null) {
				for (Biome biome : ForgeRegistries.BIOMES) {
					biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							ModWorldGen.wild_crop.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG).func_227228_a_(
									Placement.COUNT_HEIGHTMAP.func_227446_a_(new FrequencyConfig(100))));
				}
			}
			if (ModWorldGen.cactus_crop != null) {
				BiomeDictionary.getBiomes(BiomeDictionary.Type.DRY).forEach((biome) -> {
					biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							ModWorldGen.cactus_crop.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG).func_227228_a_(
									Placement.COUNT_HEIGHTMAP.func_227446_a_(new FrequencyConfig(100))));
				});

			}
			if (ModWorldGen.wild_plant != null) {
				for (Biome biome : ForgeRegistries.BIOMES) {
					biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							ModWorldGen.wild_plant.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG).func_227228_a_(
									Placement.COUNT_HEIGHTMAP.func_227446_a_(new FrequencyConfig(100))));
				}
			}
		}
	}

}
