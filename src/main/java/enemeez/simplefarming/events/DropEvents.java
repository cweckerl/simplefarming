package enemeez.simplefarming.events;

import java.util.ArrayList;

import enemeez.simplefarming.config.FeatureConfig;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DropEvents
{
	private static ArrayList<ItemStack> stacks;

	@SubscribeEvent
	public void onGrassBroken(BreakEvent event) 
	{
		if (event.getPlayer().getHeldItemMainhand().getItem() != Items.SHEARS && !event.getPlayer().isCreative())
		{
			stacks = new ArrayList<ItemStack>();
			
			if (event.getState().getBlock() == Blocks.GRASS || event.getState().getBlock() == Blocks.TALL_GRASS)
			{
				stacks.add(new ItemStack(ModItems.cantaloupe_seeds));
				stacks.add(new ItemStack(ModItems.cassava_seeds));
				stacks.add(new ItemStack(ModItems.corn_seeds));
				stacks.add(new ItemStack(ModItems.cucumber_seeds));
				stacks.add(new ItemStack(ModItems.eggplant_seeds));
				stacks.add(new ItemStack(ModItems.honeydew_seeds));
				stacks.add(new ItemStack(ModItems.kenaf_seeds));
				stacks.add(new ItemStack(ModItems.lettuce_seeds));
				stacks.add(new ItemStack(ModItems.oat_seeds));
				stacks.add(new ItemStack(ModItems.onion_seeds));
				stacks.add(new ItemStack(ModItems.pepper_seeds));
				stacks.add(new ItemStack(ModItems.radish_seeds));
				stacks.add(new ItemStack(ModItems.rice_seeds));
				stacks.add(new ItemStack(ModItems.rye_seeds));
				stacks.add(new ItemStack(ModItems.soybean_seeds));
				stacks.add(new ItemStack(ModItems.spinach_seeds));
				stacks.add(new ItemStack(ModItems.squash_seeds));
				stacks.add(new ItemStack(ModItems.tomato_seeds));
				stacks.add(new ItemStack(ModItems.yam_seeds));
				stacks.add(new ItemStack(ModItems.ginger_seeds));
				stacks.add(new ItemStack(ModItems.grape_seeds));
				stacks.add(new ItemStack(ModItems.sorghum_seeds));
				stacks.add(new ItemStack(ModItems.peanut_seeds));
				stacks.add(new ItemStack(ModItems.barley_seeds));
				stacks.add(new ItemStack(ModItems.pea_seeds));
				stacks.add(new ItemStack(ModItems.cotton_seeds));
				stacks.add(new ItemStack(ModItems.sweet_potato_seeds));
				stacks.add(new ItemStack(ModItems.broccoli_seeds));
				stacks.add(new ItemStack(ModItems.zucchini_seeds));
				
				stacks.add(new ItemStack(Items.MELON_SEEDS));
				stacks.add(new ItemStack(Items.PUMPKIN_SEEDS));
				stacks.add(new ItemStack(Items.BEETROOT_SEEDS));
				stacks.add(new ItemStack(ModItems.carrot_seeds));
				stacks.add(new ItemStack(ModItems.potato_seeds));
				
				if (Math.random() <= FeatureConfig.seed_drop.get()/100)
				{
						event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState(), 2);
						int random = (int)((Math.random()*(stacks.size()))+1);
						event.getWorld().addEntity(new ItemEntity((World) event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), stacks.get(random)));	
							
					
				}
				
			}
		}  
	}
	
	@SubscribeEvent
	public static void onMobKilled(LivingDropsEvent event) 
	{
		
		if ((event.getEntityLiving() instanceof SquidEntity))
			if (event.getEntityLiving().isBurning())
				event.getEntityLiving().entityDropItem(new ItemStack(ModItems.fried_calamari, (int)((Math.random()*3)+1)));
			else
				event.getEntityLiving().entityDropItem(new ItemStack(ModItems.raw_calamari, (int)((Math.random()*3)+1)));
		
		if ((event.getEntityLiving() instanceof HorseEntity))
			if (event.getEntityLiving().isBurning())
				event.getEntityLiving().entityDropItem(new ItemStack(ModItems.cooked_horse_meat, (int)((Math.random()*3)+1)));
			else
				event.getEntityLiving().entityDropItem(new ItemStack(ModItems.raw_horse_meat, (int)((Math.random()*3)+1)));
	
	}

	
	
}