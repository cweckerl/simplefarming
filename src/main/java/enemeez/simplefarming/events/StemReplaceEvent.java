package enemeez.simplefarming.events;

import enemeez.simplefarming.block.growable.SimpleCropBlock;
import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StemReplaceEvent {
	@SubscribeEvent
	public void replaceEvent(CropGrowEvent event) {
		BlockPos pos = event.getPos();
		Block block = event.getWorld().getBlockState(pos).getBlock();
		if (block == Blocks.PUMPKIN_STEM) {
			event.getWorld().setBlock(pos, ModBlocks.PUMPKIN_CROP.get().defaultBlockState().setValue(SimpleCropBlock.AGE, Integer.valueOf(0)), 2);
		} else if (block == Blocks.MELON_STEM) {
			event.getWorld().setBlock(pos, ModBlocks.MELON_CROP.get().defaultBlockState().setValue(SimpleCropBlock.AGE, Integer.valueOf(0)), 2);
		}
	}
}
