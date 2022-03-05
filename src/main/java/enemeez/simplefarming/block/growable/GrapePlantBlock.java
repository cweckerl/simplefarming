package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class GrapePlantBlock extends GrowableBushBlock
{
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 1.0D, 10.0D),
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D),
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 11.0D, 10.0D),
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D)
    };

    public GrapePlantBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.grapes);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(getAgeProperty())];
    }

    // Tick method
    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);
        if (state.getValue(getAgeProperty()) == getMaxAge() && worldIn.getBlockState(pos.above()).getMaterial().isReplaceable()) {
            worldIn.setBlock(pos.above(), ModBlocks.GRAPE_LEAVES_BASE.get().defaultBlockState(), Block.UPDATE_ALL);
        }
    }

}