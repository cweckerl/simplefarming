package dev.enemeez.simplefarming.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Set;
import java.util.function.Supplier;

public class GourdStemBlock extends BushBlock implements BonemealableBlock {
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    protected static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
        Block.box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D),
        Block.box(7.0D, 0.0D, 7.0D, 9.0D, 4.0D, 9.0D),
        Block.box(7.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D),
        Block.box(7.0D, 0.0D, 7.0D, 9.0D, 8.0D, 9.0D),
        Block.box(7.0D, 0.0D, 7.0D, 9.0D, 10.0D, 9.0D),
        Block.box(7.0D, 0.0D, 7.0D, 9.0D, 12.0D, 9.0D),
        Block.box(7.0D, 0.0D, 7.0D, 9.0D, 14.0D, 9.0D),
        Block.box(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D)
    };
    private final Supplier<Item> SEED;
    private final Supplier<Block> FRUIT;
    private final Supplier<Block> ATTACHED_STEM;
    private final Set<Block> GRASS_LIKE = Set.of(Blocks.FARMLAND, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.GRASS_BLOCK);

    public GourdStemBlock(
        BlockBehaviour.Properties pProperties, Supplier<Item> pSeedSupplier, Supplier<Block> fruit, Supplier<Block> attachedStem
    ) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        this.SEED = pSeedSupplier;
        this.FRUIT = fruit;
        this.ATTACHED_STEM = attachedStem;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[pState.getValue(AGE)];
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(Blocks.FARMLAND);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pLevel.isAreaLoaded(pPos, 1)) return;
        if (pLevel.getRawBrightness(pPos, 0) >= 9) {
            float f = getGrowthSpeed(this, pLevel, pPos);
            if (ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt((int) (25.0F / f) + 1) == 0)) {
                final int CURR_AGE = pState.getValue(AGE);
                if (CURR_AGE < MAX_AGE) {
                    pLevel.setBlock(pPos, pState.setValue(AGE, CURR_AGE + 1), 2);
                } else {
                    Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandom);
                    BlockPos blockpos = pPos.relative(direction);
                    BlockState blockstate = pLevel.getBlockState(blockpos.below());
                    Block block = blockstate.getBlock();
                    if (pLevel.isEmptyBlock(blockpos) && (blockstate.canSustainPlant(pLevel, blockpos.below(), Direction.UP, this)
                        || GRASS_LIKE.contains(block))
                    ) {
                        pLevel.setBlockAndUpdate(blockpos, getFruit().defaultBlockState());
                        pLevel.setBlockAndUpdate(pPos, getAttachedStem().defaultBlockState().setValue(
                            HorizontalDirectionalBlock.FACING, direction)
                        );
                    }
                }
                ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
            }

        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(this.SEED.get());
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pState.getValue(AGE) != MAX_AGE;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        int i = Math.min(MAX_AGE, pState.getValue(AGE) + Mth.nextInt(pLevel.random, 2, 5));
        BlockState blockstate = pState.setValue(AGE, i);
        pLevel.setBlock(pPos, blockstate, 2);
        if (i == MAX_AGE) {
            blockstate.randomTick(pLevel, pPos, pLevel.random);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.CROP;
    }

    /**
     * Copied from {@link net.minecraft.world.level.block.CropBlock}
     */
    private float getGrowthSpeed(Block pBlock, BlockGetter pLevel, BlockPos pPos) {
        float f = 1.0F;
        BlockPos blockpos = pPos.below();

        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = pLevel.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(pLevel, blockpos.offset(i, 0, j), Direction.UP, (IPlantable) pBlock)) {
                    f1 = 1.0F;
                    if (blockstate.isFertile(pLevel, pPos.offset(i, 0, j))) {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pPos.north();
        BlockPos blockpos2 = pPos.south();
        BlockPos blockpos3 = pPos.west();
        BlockPos blockpos4 = pPos.east();
        boolean flag = pLevel.getBlockState(blockpos3).is(pBlock) || pLevel.getBlockState(blockpos4).is(pBlock);
        boolean flag1 = pLevel.getBlockState(blockpos1).is(pBlock) || pLevel.getBlockState(blockpos2).is(pBlock);
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = pLevel.getBlockState(blockpos3.north()).is(pBlock)
                || pLevel.getBlockState(blockpos4.north()).is(pBlock)
                || pLevel.getBlockState(blockpos4.south()).is(pBlock)
                || pLevel.getBlockState(blockpos3.south()).is(pBlock);
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }

    private Block getFruit() {
        return FRUIT.get();
    }

    private GourdAttachedStemBlock getAttachedStem() {
        return (GourdAttachedStemBlock) ATTACHED_STEM.get();
    }
}
