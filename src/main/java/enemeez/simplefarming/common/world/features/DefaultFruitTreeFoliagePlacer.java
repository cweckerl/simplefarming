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

public class DefaultFruitTreeFoliagePlacer extends FruitTreeFoliagePlacer {
    public static final Codec<FruitTreeFoliagePlacer> CODEC = Codec.unit(DefaultFruitTreeFoliagePlacer::new);

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFeatures.DEFAULT_FRUIT_TREE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(
        LevelSimulatedReader pLevel,
        BiConsumer<BlockPos, BlockState> pBlockSetter,
        RandomSource pRandom,
        TreeConfiguration pConfig,
        int pMaxFreeTreeHeight,
        FoliageAttachment pAttachment,
        int pFoliageHeight,
        int pFoliageRadius,
        int pOffset
    ) {
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -2, pAttachment.doubleTrunk());
        Stream.of(new Vec3i(0, 0, 0), new Vec3i(1, -1, 0), new Vec3i(-1, -1, 0), new Vec3i(0, -1, 1), new Vec3i(0, -1, -1))
            .forEach(v -> tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(v)));
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
