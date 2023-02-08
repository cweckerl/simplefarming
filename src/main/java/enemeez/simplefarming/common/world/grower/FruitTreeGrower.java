package enemeez.simplefarming.common.world.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class FruitTreeGrower extends AbstractTreeGrower {
    private final ResourceKey<ConfiguredFeature<?, ?>> KEY;

    public FruitTreeGrower(ResourceKey<ConfiguredFeature<?, ?>> key) {
        this.KEY = key;
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return KEY;
    }
}


