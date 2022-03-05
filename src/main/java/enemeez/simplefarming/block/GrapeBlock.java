package enemeez.simplefarming.block;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class GrapeBlock extends BushBlock {

	public GrapeBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getBlockState(pos.above()).getBlock() == ModBlocks.GRAPE_LEAVES.get();
	}

	@Override
	public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity) {
			entityIn.makeStuckInBlock(state, new Vec3(0.8D, 0.75D, 0.8D));
		}
	}

	/*
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader reader, BlockPos pos) {
		return false;
	}
	*/

}
