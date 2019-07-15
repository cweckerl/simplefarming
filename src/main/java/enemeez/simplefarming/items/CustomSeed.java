package enemeez.simplefarming.items;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class CustomSeed extends BlockItem 
{
		   public CustomSeed(Block p_i50041_1_, Item.Properties p_i50041_2_) 
		   {
		      super(p_i50041_1_, p_i50041_2_);
		   }

		   /**
		    * Returns the unlocalized name of this item.
		    */
		   public String getTranslationKey() {
		      return this.getDefaultTranslationKey();
		   }
		
	
	
	public boolean itemInteractionForEntity(ItemStack itemstack, PlayerEntity player, net.minecraft.entity.LivingEntity entity, net.minecraft.util.Hand hand)
    {
    	ItemStack stack = player.getHeldItem(hand);
        if (entity.world.isRemote)
        {
            return false;
        }
        if (entity instanceof ChickenEntity)
        {		
        		((ChickenEntity) entity).setInLove(player);
        		stack.shrink(1);
        		return true;
        } 
        return false;
    }
}


