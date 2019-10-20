package enemeez.simplefarming.events;

import enemeez.simplefarming.blocks.DoubleCrop;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DoubleCropBreak {
	@SubscribeEvent
	public void onDoubleCropBreak(BreakEvent event) {
		if (!event.getWorld().isRemote()) {
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCrop) {
				DoubleCrop crop = (DoubleCrop) event.getWorld().getBlockState(event.getPos()).getBlock();
				if (crop.getAge(event.getWorld().getBlockState(event.getPos())) == 7) {
					event.getWorld().setBlockState(event.getPos().down(), crop.getDefaultState(), 2);
				}
			}
		}
	}

	
	@SubscribeEvent
	public void onCropRightClicked(RightClickBlock event) {
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCrop) {
			if (event.getPlayer().getHeldItemMainhand().getItem() == Items.BONE_MEAL) {
				DoubleCrop crop = (DoubleCrop) event.getWorld().getBlockState(event.getPos()).getBlock();

				if (crop.getAge(event.getWorld().getBlockState(event.getPos())) == 6
						&& event.getWorld().getBlockState(event.getPos().up()) == Blocks.AIR.getDefaultState()) {
					if (event.getWorld().isRemote) {
						event.getWorld().setBlockState(event.getPos().up(),
								crop.getDefaultState().with(DoubleCrop.AGE, 7), 3);
						if (!event.getPlayer().isCreative())
							event.getPlayer().getHeldItem(Hand.MAIN_HAND).shrink(1);
						event.getPlayer().addExhaustion(.05F);
					}
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					double d0 = (double) ((float) event.getPos().getX());
					double d1 = (double) ((float) event.getPos().getY());
					double d2 = (double) ((float) event.getPos().getZ());
					event.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, d0 + 0.5F, d1 + 0.5F, d2, 0.0D, 0.0D,
							0.0D);
				}
			}
		}

	}
	

}
