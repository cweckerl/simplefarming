package enemeez.simplefarming.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class SingleCropBlock extends CropBlock {

    public enum Size {
        SMALL,
        LARGE
    }

    private static final VoxelShape[] SMALL_SHAPE_BY_AGE = new VoxelShape[]{
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)
    };

    private static final VoxelShape[] LARGE_SHAPE_BY_AGE = new VoxelShape[]{
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    private final Supplier<Item> SEED;
    private final Size SIZE;

    public SingleCropBlock(Properties pProperties, Supplier<Item> seed, Size size) {
        super(pProperties);
        this.SEED = seed;
        this.SIZE = size;
    }

    public SingleCropBlock(Properties pProperties, Supplier<Item> seed) {
        super(pProperties);
        this.SEED = seed;
        this.SIZE = Size.LARGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return SEED.get();
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return pState.getBlock() instanceof FarmBlock;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SIZE == Size.SMALL
            ? SMALL_SHAPE_BY_AGE[pState.getValue(this.getAgeProperty())]
            : LARGE_SHAPE_BY_AGE[pState.getValue(this.getAgeProperty())];
    }
}
