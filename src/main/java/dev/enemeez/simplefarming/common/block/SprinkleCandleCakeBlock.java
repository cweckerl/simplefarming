package dev.enemeez.simplefarming.common.block;

import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.LevelReader;
import net.minecraft.util.RandomSource;
import com.mojang.serialization.MapCodec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import dev.enemeez.simplefarming.common.registries.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class SprinkleCandleCakeBlock extends AbstractCandleBlock {
    @Override
    protected MapCodec<? extends SprinkleCandleCakeBlock> codec() {
        return MapCodec.unit(this);
    }

    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    protected static final float AABB_OFFSET = 1.0F;
    protected static final VoxelShape CAKE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    protected static final VoxelShape CANDLE_SHAPE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    protected static final VoxelShape SHAPE = Shapes.or(CAKE_SHAPE, CANDLE_SHAPE);
    private static final Map<Block, SprinkleCandleCakeBlock> BY_CANDLE = Maps.newHashMap();
    private static final Iterable<Vec3> PARTICLE_OFFSETS = ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));

    public SprinkleCandleCakeBlock(Block pCandleBlock, BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)));
        BY_CANDLE.put(pCandleBlock, this);
    }

    protected Iterable<Vec3> getParticleOffsets(BlockState pState) {
        return PARTICLE_OFFSETS;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pStack.is(Items.FLINT_AND_STEEL) || pStack.is(Items.FIRE_CHARGE)) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, pLevel.getRandom().nextFloat() * 0.4F + 0.8F);
            pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.LIT, true), 11);
            pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
            pStack.hurtAndBreak(1, pPlayer, pHand.asEquipmentSlot());
            return InteractionResult.SUCCESS;
        } else if (candleHit(pHit) && pStack.isEmpty() && pState.getValue(LIT)) {
            extinguish(pPlayer, pState, pLevel, pPos);
            return InteractionResult.SUCCESS;
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHit) {
        InteractionResult interactionresult = SprinkleCakeBlock.eat(pLevel, pPos, ModBlocks.SPRINKLE_CAKE.get().defaultBlockState(), pPlayer);
        if (interactionresult.consumesAction()) {
            dropResources(pState, pLevel, pPos);
        }

        return interactionresult;
    }


    private static boolean candleHit(BlockHitResult pHit) {
        return pHit.getLocation().y - (double) pHit.getBlockPos().getY() > 0.5D;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }

    protected ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIncludeData) {
        return new ItemStack(Blocks.CAKE);
    }

    /**
     * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific direction passed in.
     */
    protected BlockState updateShape(BlockState pState, LevelReader pLevel, ScheduledTickAccess pTickAccess, BlockPos pCurrentPos, Direction pDirection, BlockPos pNeighborPos, BlockState pNeighborState, RandomSource pRandom) {
        return pDirection == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pLevel, pTickAccess, pCurrentPos, pDirection, pNeighborPos, pNeighborState, pRandom);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).isSolid();
    }

    /**
     * @deprecated call via {@link
     * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#getAnalogOutputSignal} whenever possible.
     * Implementing/overriding is fine.
     */
    @Override
    protected int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos, Direction pDirection) {
        return CakeBlock.FULL_CAKE_SIGNAL;
    }

    /**
     * @deprecated call via {@link
     * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#hasAnalogOutputSignal} whenever possible.
     * Implementing/overriding is fine.
     */
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    protected boolean isPathfindable(BlockState pState, PathComputationType pType) {
        return false;
    }

    public static BlockState byCandle(Block pCandleBlock) {
        return BY_CANDLE.get(pCandleBlock).defaultBlockState();
    }

    public static boolean canLight(BlockState pState) {
        return pState.is(BlockTags.CANDLE_CAKES, (p_152896_) -> {
            return p_152896_.hasProperty(LIT) && !pState.getValue(LIT);
        });
    }
}
