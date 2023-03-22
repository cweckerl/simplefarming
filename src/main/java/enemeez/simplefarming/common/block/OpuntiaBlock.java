package enemeez.simplefarming.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class OpuntiaBlock extends GrowableBushBlock implements IPlantable {
    private static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    // X axis
    private final VoxelShape TOP_MIDDLE_X = Block.box(4.0D, 10.0D, 7.0D, 12.0D, 12.0D, 9.0D);
    private final VoxelShape MIDDLE_X = Block.box(2.0D, 4.0D, 7.0D, 14.0D, 10.0D, 9.0D);
    private final VoxelShape BOT_MIDDLE_X = Block.box(4.0D, 2.0D, 7.0D, 12.0D, 4.0D, 9.0D);
    private final VoxelShape BOT_X = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D);
    private final VoxelShape FRUIT_1_X = Block.box(12.0D, 10.0D, 7.0D, 14.0D, 12.0D, 9.0D);
    private final VoxelShape FRUIT_2_X = Block.box(10.0D, 12.0D, 7.0D, 12.0D, 14.0D, 9.0D);
    private final VoxelShape FRUIT_3_X = Block.box(7.0D, 12.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    private final VoxelShape FRUIT_4_X = Block.box(4.0D, 12.0D, 7.0D, 6.0D, 14.0D, 9.0D);
    private final VoxelShape FRUIT_5_X = Block.box(2.0D, 10.0D, 7.0D, 4.0D, 12.0D, 9.0D);
    private final VoxelShape UNRIPE_X = Shapes.or(TOP_MIDDLE_X, BOT_MIDDLE_X, MIDDLE_X, BOT_X);
    private final VoxelShape RIPE_X = Shapes.or(
        TOP_MIDDLE_X, BOT_MIDDLE_X, MIDDLE_X, BOT_X, FRUIT_1_X, FRUIT_2_X, FRUIT_3_X, FRUIT_4_X, FRUIT_5_X
    );

    // Z axis
    private final VoxelShape TOP_MIDDLE_Z = Block.box(7.0D, 10.0D, 4.0D, 9.0D, 12.0D, 12.0D);
    private final VoxelShape MIDDLE_Z = Block.box(7.0D, 4.0D, 2.0D, 9.0D, 10.0D, 14.0D);
    private final VoxelShape BOT_MIDDLE_Z = Block.box(7.0D, 2.0D, 4.0D, 9.0D, 4.0D, 12.0D);
    private final VoxelShape BOT_Z = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D);
    private final VoxelShape FRUIT_1_Z = Block.box(7.0D, 10.0D, 12.0D, 9.0D, 12.0D, 14.0D);
    private final VoxelShape FRUIT_2_Z = Block.box(7.0D, 12.0D, 10.0D, 9.0D, 14.0D, 12.0D);
    private final VoxelShape FRUIT_3_Z = Block.box(7.0D, 12.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    private final VoxelShape FRUIT_4_Z = Block.box(7.0D, 12.0D, 4.0D, 9.0D, 14.0D, 6.0D);
    private final VoxelShape FRUIT_5_Z = Block.box(7.0D, 10.0D, 2.0D, 9.0D, 12.0D, 4.0D);
    private final VoxelShape UNRIPE_Z = Shapes.or(TOP_MIDDLE_Z, BOT_MIDDLE_Z, MIDDLE_Z, BOT_Z);
    private final VoxelShape RIPE_Z = Shapes.or(
        TOP_MIDDLE_Z, BOT_MIDDLE_Z, MIDDLE_Z, BOT_Z, FRUIT_1_Z, FRUIT_2_Z, FRUIT_3_Z, FRUIT_4_Z, FRUIT_5_Z
    );

    public OpuntiaBlock(Properties pProperties, Supplier<Item> output) {
        super(pProperties, output);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        boolean maxAge = pState.getValue(AGE) == MAX_AGE;
        return pState.getValue(FACING).getAxis() == Direction.Axis.X
            ? maxAge ? RIPE_X : UNRIPE_X
            : maxAge ? RIPE_Z : UNRIPE_Z;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getClockWise());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE, FACING);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).is(BlockTags.SAND);
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.DESERT;
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return defaultBlockState();
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pState.getValue(AGE) == MAX_AGE) {
            // pEntity.hurt(DamageSource.CACTUS, 1.0F);
            pEntity.hurt(pLevel.m_269111_().m_269325_(), 1.0F);
        }
    }
}
