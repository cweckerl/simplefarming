package enemeez.simplefarming.items;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrainItem extends Item
{
	   public GrainItem(Properties properties) 
	   {
		   super(properties);
		   
	   }
	   

	public boolean itemInteractionForEntity(ItemStack itemstack, PlayerEntity player, net.minecraft.entity.LivingEntity entity, net.minecraft.util.Hand hand)
	    {
			
	    	ItemStack stack = player.getHeldItem(hand);

	        if (!entity.world.isRemote && !entity.isChild() && (int)((AgeableEntity) entity).getGrowingAge() == 0)
	        {
		        if (entity instanceof CowEntity)
		        {		
		        	if (((CowEntity) entity).isInLove())
		        	{
		        		return false;
		        	}
		        	else
		        	{
		        		((CowEntity) entity).setInLove(player);
		        		if (!player.isCreative())
		        			stack.shrink(1);
		        		return true;
		        	}

		        } 
		       	
		        	if (entity instanceof SheepEntity)
			        {		
			        	if (((SheepEntity) entity).isInLove())
			        	{
			        		return false;
			        	}
			        	else
			        	{
			        		((SheepEntity) entity).setInLove(player);
			        		if (!player.isCreative())
			        			stack.shrink(1);
			        		return true;
			        	}
			        }
		        	
	        }
		        
	        if (entity.isChild()) 
	        {
	        	if (!player.isCreative())
	            stack.shrink(1);
	            ((AgeableEntity) entity).ageUp((int)((float)(-((AgeableEntity) entity).getGrowingAge() / 20) * 0.1F), true);
	            return true;
	         }
		        
	        return false;

	    }
}
