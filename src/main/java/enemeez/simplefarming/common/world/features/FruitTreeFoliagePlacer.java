package enemeez.simplefarming.common.world.features;

import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;

public abstract class FruitTreeFoliagePlacer extends FoliagePlacer {

    public FruitTreeFoliagePlacer() {
        super(ConstantInt.of(2), ConstantInt.of(0));
    }
}
