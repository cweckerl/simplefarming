package enemeez.simplefarming.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class GrowableFlowerBlock extends GrowableBushBlock {
    private final VoxelShape SMALL_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public GrowableFlowerBlock(Properties pProperties, Supplier<Item> output) {
        super(pProperties, output);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Vec3 v = pState.getOffset(pLevel, pPos);
        return pState.getValue(AGE) < MAX_AGE ? SMALL_SHAPE.move(v.x, v.y, v.z) : SHAPE.move(v.x, v.y, v.z);
    }
}
