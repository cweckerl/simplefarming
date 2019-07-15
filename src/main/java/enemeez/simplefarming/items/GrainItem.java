package enemeez.simplefarming.items;

import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.MooshroomEntity;
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
	        if (entity.world.isRemote)
	        {
	            return false;
	        }
	        if (entity instanceof CowEntity)
	        {		
	        		((CowEntity) entity).setInLove(player);
	        		stack.shrink(1);
	        		return true;
	        } 
	        if (entity instanceof MooshroomEntity)
	        {		
	        		((MooshroomEntity) entity).setInLove(player);
	        		stack.shrink(1);
	        		return true;
	        } 
	        if (entity instanceof SheepEntity)
	        {	
	        		((SheepEntity) entity).setInLove(player);
	        		stack.shrink(1);
	        		return true;
	        } 
	        return false;
	    }

}
