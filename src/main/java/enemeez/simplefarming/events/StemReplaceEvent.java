package enemeez.simplefarming.events;

import enemeez.simplefarming.block.growable.SimpleCropBlock;
import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StemReplaceEvent {
	@SubscribeEvent
	public void replaceEvent(CropGrowEvent event) {
		BlockPos pos = event.getPos();
		Block block = event.getWorld().getBlockState(pos).getBlock();
		if (block == Blocks.PUMPKIN_STEM) {
			event.getWorld().setBlockState(pos,
					ModBlocks.pumpkin_crop.getDefaultState().with(SimpleCropBlock.AGE, Integer.valueOf(0)), 2);
		} else if (block == Blocks.MELON_STEM) {
			event.getWorld().setBlockState(pos,
					ModBlocks.melon_crop.getDefaultState().with(SimpleCropBlock.AGE, Integer.valueOf(0)), 2);
		}
	}
}
