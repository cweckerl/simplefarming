package enemeez.simplefarming.events.harvest;

import enemeez.simplefarming.block.growable.DoubleCropBlock;
import net.minecraft.block.Block;
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
		if (!event.getWorld().isRemote()) {
			BlockState state = event.getWorld().getBlockState(event.getPos());
			Block below = event.getWorld().getBlockState(event.getPos().down()).getBlock();
			if (state.getBlock() instanceof DoubleCropBlock && below instanceof DoubleCropBlock) { //make sure the block below is also a double crop block
				DoubleCropBlock crop = (DoubleCropBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
				if (crop.getAge(state) == 7 && crop.getHalf(state) == DoubleBlockHalf.UPPER) {
					event.getWorld().setBlockState(event.getPos().down(), crop.getDefaultState(), 2);
				}
			}
		}
	}
}
