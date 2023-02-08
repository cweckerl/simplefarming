package enemeez.simplefarming.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class GrapeTrunkBlock extends DoubleCropBlock {
    private final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
        Block.box(6.0D, 0.0D, 6.0D, 10.0D, 2.0D, 10.0D),
        Block.box(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D),
        Block.box(6.0D, 0.0D, 6.0D, 10.0D, 6.0D, 10.0D),
        Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D),
        Block.box(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D),
        Block.box(6.0D, 0.0D, 6.0D, 10.0D, 12.0D, 10.0D),
        Block.box(6.0D, 0.0D, 6.0D, 10.0D, 14.0D, 10.0D),
        Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D),
    };

    public GrapeTrunkBlock(Properties pProperties, Supplier<Item> seed, Block topBlock) {
        super(pProperties, seed, topBlock);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[getAge(pState)];
    }
}
