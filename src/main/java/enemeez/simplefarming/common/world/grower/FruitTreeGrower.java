package enemeez.simplefarming.common.world.grower;

import enemeez.simplefarming.common.registries.ModFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class FruitTreeGrower extends AbstractTreeGrower {
    private final Holder<? extends ConfiguredFeature<?, ?>> HOLDER;

    public FruitTreeGrower(Holder<? extends ConfiguredFeature<?, ?>> holder) {
        this.HOLDER = holder;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive) {
        return HOLDER;
    }
}


