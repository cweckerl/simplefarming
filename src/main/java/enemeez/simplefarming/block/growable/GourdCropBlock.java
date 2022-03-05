package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.util.ModVoxelShapes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class GourdCropBlock extends SimpleCropBlock
{
    public GourdCropBlock(Properties properties, Supplier<Item> itemSupplier, Supplier<Item> seedItemSupplier) {
        super(properties, itemSupplier, seedItemSupplier);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return ModVoxelShapes.GOURD_SHAPES_0_7[state.getValue(getAgeProperty())];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return state.getValue(getAgeProperty()) > 0 ? ModVoxelShapes.GOURD_SHAPES_0_7[state.getValue(getAgeProperty())] : Shapes.empty();
    }
}
