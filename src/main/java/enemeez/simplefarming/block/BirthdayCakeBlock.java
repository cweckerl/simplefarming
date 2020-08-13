package enemeez.simplefarming.block;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BirthdayCakeBlock extends CakeBlock {

	public BirthdayCakeBlock(Properties properties) {
		super(properties);
		setDefaultState(stateContainer.getBaseState().with(BITES, 0));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		double x = pos.getX() + 0.5D;
		double y = pos.getY() + 0.16D;
		double z = pos.getZ() + 0.5D;
		if (stateIn.get(BITES) < 6) worldIn.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
	}
}
