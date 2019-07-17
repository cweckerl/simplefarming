package enemeez.simplefarming.events;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SquidEvent 
{
	
	@SubscribeEvent
    public void onMobDrop(LivingDropsEvent event) 
	{

            if ((event.getEntityLiving() instanceof SquidEntity)) 
            
            	event.getEntityLiving().entityDropItem(ModItems.raw_calamari, 1);
	}
                
            
}


