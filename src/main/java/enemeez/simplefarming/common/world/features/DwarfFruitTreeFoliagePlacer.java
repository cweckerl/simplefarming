package enemeez.simplefarming.common.world.features;

import com.mojang.serialization.Codec;
import enemeez.simplefarming.common.registries.ModFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.BiConsumer;

public class DwarfFruitTreeFoliagePlacer extends FruitTreeFoliagePlacer {
    public static final Codec<FruitTreeFoliagePlacer> CODEC = Codec.unit(DwarfFruitTreeFoliagePlacer::new);

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFeatures.DWARF_FRUIT_TREE_FOLIAGE_PLACER.get();
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
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -1, pAttachment.doubleTrunk());
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
