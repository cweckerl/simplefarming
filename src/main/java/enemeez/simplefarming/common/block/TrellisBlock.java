package enemeez.simplefarming.common.block;

import enemeez.simplefarming.common.registries.ModBlocks;
import enemeez.simplefarming.common.registries.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TrellisBlock extends Block {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty CAN_GROW = BooleanProperty.create("can_grow");
    public static final BooleanProperty CAN_SPREAD = BooleanProperty.create("can_spread");
    public static final int MIN_DISTANCE = 1;
    public static final int MAX_DISTANCE = 4;
    public static final IntegerProperty DISTANCE_FROM_SOURCE = IntegerProperty.create("distance_from_source", MIN_DISTANCE, MAX_DISTANCE);

    private final Map<Direction, BooleanProperty> DIRECTION_TO_PROPERTY = Map.of(
        Direction.NORTH, NORTH,
        Direction.SOUTH, SOUTH,
        Direction.EAST, EAST,
        Direction.WEST, WEST,
        Direction.UP, UP,
        Direction.DOWN, DOWN
    );

    private final VoxelShape NODE = Block.box(6, 6, 6, 10, 10, 10);
    private final VoxelShape CONNECTION_NORTH = Block.box(6, 6, 0, 10, 10, 6);
    private final VoxelShape CONNECTION_SOUTH = Block.box(6, 6, 10, 10, 10, 16);
    private final VoxelShape CONNECTION_EAST = Block.box(10, 6, 6, 16, 10, 10);
    private final VoxelShape CONNECTION_WEST = Block.box(0, 6, 6, 6, 10, 10);
    private final VoxelShape CONNECTION_UP = Block.box(6, 10, 6, 10, 16, 10);
    private final VoxelShape CONNECTION_DOWN = Block.box(6, 0, 6, 10, 6, 10);

    private final VoxelShape LEAVES_NODE = Block.box(4, 4, 4, 12, 12, 12);
    private final VoxelShape LEAVES_CONNECTION_NORTH = Block.box(4, 4, 0, 12, 12, 4);
    private final VoxelShape LEAVES_CONNECTION_SOUTH = Block.box(4, 4, 12, 12, 12, 16);
    private final VoxelShape LEAVES_CONNECTION_EAST = Block.box(12, 4, 4, 16, 12, 12);
    private final VoxelShape LEAVES_CONNECTION_WEST = Block.box(0, 4, 4, 4, 12, 12);
    private final VoxelShape LEAVES_CONNECTION_UP = Block.box(4, 12, 4, 12, 16, 12);
    private final VoxelShape LEAVES_CONNECTION_DOWN = Block.box(4, 0, 4, 12, 4, 12);

    public TrellisBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(NORTH, false)
            .setValue(SOUTH, false)
            .setValue(EAST, false)
            .setValue(WEST, false)
            .setValue(UP, false)
            .setValue(DOWN, false)
            .setValue(CAN_GROW, false)
            .setValue(CAN_SPREAD, false)
            .setValue(DISTANCE_FROM_SOURCE, MAX_DISTANCE)
        );
    }

    private BlockState updateConnections(BlockState pState, final Map<Direction, Boolean> map) {
        return pState
            .setValue(NORTH, map.getOrDefault(Direction.NORTH, false))
            .setValue(SOUTH, map.getOrDefault(Direction.SOUTH, false))
            .setValue(EAST, map.getOrDefault(Direction.EAST, false))
            .setValue(WEST, map.getOrDefault(Direction.WEST, false))
            .setValue(UP, map.getOrDefault(Direction.UP, false))
            .setValue(DOWN, map.getOrDefault(Direction.DOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(NORTH, SOUTH, EAST, WEST, UP, DOWN, CAN_GROW, CAN_SPREAD, DISTANCE_FROM_SOURCE);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return !pState.getValue(CAN_GROW) ? Shapes.or(
            NODE,
            pState.getValue(NORTH) ? CONNECTION_NORTH : Shapes.empty(),
            pState.getValue(SOUTH) ? CONNECTION_SOUTH : Shapes.empty(),
            pState.getValue(EAST) ? CONNECTION_EAST : Shapes.empty(),
            pState.getValue(WEST) ? CONNECTION_WEST : Shapes.empty(),
            pState.getValue(UP) ? CONNECTION_UP : Shapes.empty(),
            pState.getValue(DOWN) ? CONNECTION_DOWN : Shapes.empty()
        ) : Shapes.or(
            LEAVES_NODE,
            pState.getValue(NORTH) ? LEAVES_CONNECTION_NORTH : Shapes.empty(),
            pState.getValue(SOUTH) ? LEAVES_CONNECTION_SOUTH : Shapes.empty(),
            pState.getValue(EAST) ? LEAVES_CONNECTION_EAST : Shapes.empty(),
            pState.getValue(WEST) ? LEAVES_CONNECTION_WEST : Shapes.empty(),
            pState.getValue(UP) ? LEAVES_CONNECTION_UP : Shapes.empty(),
            pState.getValue(DOWN) ? LEAVES_CONNECTION_DOWN : Shapes.empty()
        );
    }

    private Boolean canConnect(BlockState state) {
        var block = state.getBlock();
        return block instanceof TrellisBlock || block instanceof GrapevineSourceBlock
            || !isExceptionForConnection(state) && state.getMaterial().isSolid() && !state.is(ModTags.TRELLIS_BLACKLIST);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        var level = pContext.getLevel();
        var pos = pContext.getClickedPos();
        final Map<Direction, Boolean> connections = new HashMap<>();

        Stream.of(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.UP, Direction.DOWN)
            .forEach(dir -> connections.put(dir, canConnect(level.getBlockState(pos.relative(dir)))));

        return updateConnections(this.defaultBlockState(), connections);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        return pState.setValue(DIRECTION_TO_PROPERTY.get(pDirection), canConnect(pNeighborState));
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(CAN_SPREAD) || pState.getValue(CAN_GROW);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(CAN_GROW)) {
            if (pLevel.getBlockState(pPos.below()) == Blocks.AIR.defaultBlockState()) {
                pLevel.setBlock(pPos.below(), ModBlocks.GRAPEVINE.get().defaultBlockState(), 2);
            }
        }

        if (pState.getValue(CAN_SPREAD)) {
            Stream.of(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.UP, Direction.DOWN)
                .forEach(dir -> {
                    var neighborPos = pPos.relative(dir);
                    var neighborState = pLevel.getBlockState(neighborPos);
                    if (neighborState.getBlock() instanceof TrellisBlock && !neighborState.getValue(CAN_GROW)) {
                        final int dist = pState.getValue(DISTANCE_FROM_SOURCE);

                        pLevel.setBlock(neighborPos, neighborState
                            .setValue(CAN_GROW, true)
                            .setValue(CAN_SPREAD, dist + 1 < MAX_DISTANCE)
                            .setValue(DISTANCE_FROM_SOURCE, dist + 1), 2
                        );

                        pLevel.setBlock(pPos, pState.setValue(CAN_SPREAD, false), 2);
                    }
                });
        }
    }
}
