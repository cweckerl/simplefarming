package enemeez.simplefarming.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class BerryBushBlock extends GrowableBushBlock {
    private final VoxelShape SHAPE = Shapes.or(
        Block.box(1.0D, 2.0D, 1.0D, 15.0D, 16.0D, 15.0D),
        Block.box(5.0D, 0.D, 5.0D, 11.0D, 2.0D, 11.0D)
    );

    public BerryBushBlock(Properties pProperties, Supplier<Item> output) {
        super(pProperties, output);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity && pEntity.getType() != EntityType.FOX && pEntity.getType() != EntityType.BEE) {
            pEntity.makeStuckInBlock(pState, new Vec3(0.8F, 0.75D, 0.8F));
        }
    }
}
