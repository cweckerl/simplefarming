package enemeez.simplefarming.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class BirthdayCakeBlock extends CakeBlock {

	public BirthdayCakeBlock(Properties properties) {
		super(properties);
		registerDefaultState(stateDefinition.any().setValue(BITES, 0));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
		double x = pos.getX() + 0.5D;
		double y = pos.getY() + 0.16D;
		double z = pos.getZ() + 0.5D;
		if (stateIn.getValue(BITES) < 6) worldIn.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
	}
}
