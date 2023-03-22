package enemeez.simplefarming.common.world.features;

import com.mojang.serialization.Codec;
import enemeez.simplefarming.common.registries.ModFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class TropicFruitTreeFoliagePlacer extends FruitTreeFoliagePlacer {
    public static final Codec<FruitTreeFoliagePlacer> CODEC = Codec.unit(TropicFruitTreeFoliagePlacer::new);

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFeatures.TROPIC_FRUIT_TREE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(
        LevelSimulatedReader pLevel,
        FoliageSetter pBlockSetter,
        RandomSource pRandom,
        TreeConfiguration pConfig,
        int pMaxFreeTreeHeight,
        FoliageAttachment pAttachment,
        int pFoliageHeight,
        int pFoliageRadius,
        int pOffset
    ) {
        m_272253_(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos());
        final int north_offset = pRandom.nextIntBetweenInclusive(-1, 1);
        final int south_offset = pRandom.nextIntBetweenInclusive(-1, 1);
        final int east_offset = pRandom.nextIntBetweenInclusive(-1, 1);
        final int west_offset = pRandom.nextIntBetweenInclusive(-1, 1);

        Stream.of(
            new Vec3i(0, north_offset, -1),
            new Vec3i(0, north_offset, -2),
            new Vec3i(0, north_offset - 1, -1),

            new Vec3i(0, south_offset, 1),
            new Vec3i(0, south_offset, 2),
            new Vec3i(0, south_offset - 1, 1),

            new Vec3i(1, east_offset, 0),
            new Vec3i(2, east_offset, 0),
            new Vec3i(1, east_offset - 1, 0),

            new Vec3i(-1, west_offset, 0),
            new Vec3i(-2, west_offset, 0),
            new Vec3i(-1, west_offset - 1, 0)
        ).forEach(v -> m_272253_(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(v)));
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
