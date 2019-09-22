package enemeez.simplefarming.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BirthdayCake extends CakeBlock {

	public BirthdayCake(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(BITES, Integer.valueOf(0)));
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		double d0 = (double) ((float) pos.getX() + 0.5F);
		double d1 = (double) ((float) pos.getY() + 0.16D);
		double d2 = (double) ((float) pos.getZ() + 0.5F);
		worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}

}
