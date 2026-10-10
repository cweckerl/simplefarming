package dev.enemeez.simplefarming.common.world.grower;

import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public class FruitTreeGrower {
    private FruitTreeGrower() {}

    public static TreeGrower create(String name, ResourceKey<ConfiguredFeature<?, ?>> key) {
        return new TreeGrower(SimpleFarming.MOD_ID + ":" + name, Optional.empty(), Optional.of(key), Optional.empty());
    }
}
