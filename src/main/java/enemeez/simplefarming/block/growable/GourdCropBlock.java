package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.util.ModVoxelShapes;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class GourdCropBlock extends SimpleCropBlock
{
    public GourdCropBlock(Properties properties, Supplier<Item> itemSupplier, Supplier<Item> seedItemSupplier) {
        super(properties, itemSupplier, seedItemSupplier);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return ModVoxelShapes.GOURD_SHAPES_0_7[state.get(getAgeProperty())];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.get(getAgeProperty()) > 0 ? ModVoxelShapes.GOURD_SHAPES_0_7[state.get(getAgeProperty())] : VoxelShapes.empty();
    }
}
