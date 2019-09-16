package enemeez.simplefarming.events;

import enemeez.simplefarming.blocks.DoubleCrop;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DoubleCropBreak 
{
	@SubscribeEvent
	public void onDoubleCropBreak(BreakEvent event) 
	{
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCrop)
		{
			DoubleCrop crop = (DoubleCrop) event.getWorld().getBlockState(event.getPos()).getBlock();
			if (crop.getAge(event.getWorld().getBlockState(event.getPos())) == 7)
			{
				event.getWorld().setBlockState(event.getPos().down(), crop.getDefaultState(), 2);
			}
		}
	}

}
