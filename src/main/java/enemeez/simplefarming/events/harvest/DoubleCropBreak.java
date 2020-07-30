package enemeez.simplefarming.events.harvest;

import enemeez.simplefarming.block.growable.DoubleCropBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DoubleCropBreak {
	@SubscribeEvent
	public void onDoubleCropBlockBreak(BreakEvent event) {
		BlockState state = event.getWorld().getBlockState(event.getPos());
		if (!event.getWorld().isRemote()) {
			if (state.getBlock() instanceof DoubleCropBlock) {
				DoubleCropBlock crop = (DoubleCropBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
				if (crop.getAge(state) == 7 && crop.getHalf(state) == DoubleBlockHalf.UPPER) {
					event.getWorld().setBlockState(event.getPos().down(), crop.getDefaultState(), 2);
				}
			}
		}
	}

	@SubscribeEvent
	public void onCropRightClicked(RightClickBlock event) {
		if (!event.getWorld().isRemote()) {
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCropBlock) {
				if (event.getPlayer().getHeldItemMainhand().getItem() == Items.BONE_MEAL) {
					DoubleCropBlock crop = (DoubleCropBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
					BlockState state = event.getWorld().getBlockState(event.getPos());

					if (crop.getAge(state) >= 6 && event.getWorld().getBlockState(event.getPos().up()) == Blocks.AIR.getDefaultState()) {
						event.getWorld().setBlockState(event.getPos().up(), crop.getDefaultState().with(DoubleCropBlock.AGE, 7).with(DoubleCropBlock.HALF, DoubleBlockHalf.UPPER), 2);
						if (!event.getPlayer().isCreative())
							event.getPlayer().getHeldItem(Hand.MAIN_HAND).shrink(1);
						event.getPlayer().addExhaustion(.05F);
					}

				}
			}
		}

	}

}
