package enemeez.simplefarming.events;

import java.util.ArrayList;

import enemeez.simplefarming.blocks.CustomBush;
import enemeez.simplefarming.blocks.CustomCactus;
import enemeez.simplefarming.blocks.DoubleCrop;
import enemeez.simplefarming.blocks.FruitLeaves;
import enemeez.simplefarming.blocks.GrapeBlock;
import enemeez.simplefarming.blocks.WildPlant;
import enemeez.simplefarming.items.HarvestDrops;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SmartHarvest
{
	@SubscribeEvent
	public void onCropHarvest(RightClickBlock event)
	{
		if (event.getPlayer().getHeldItemMainhand().getItem() != Items.BONE_MEAL)
		{
			ArrayList<ItemStack> drops;
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof CropsBlock && !(event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCrop))
			{
				if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
				if (event.getWorld().isRemote) event.setCanceled(true);
				CropsBlock crop = (CropsBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
				if (crop.isMaxAge(event.getWorld().getBlockState(event.getPos())))
					{
						event.getPlayer().swingArm(Hand.MAIN_HAND);
						event.getPlayer().addExhaustion(.05F);
						drops = HarvestDrops.spawn(crop);
						for (int i=0; i<drops.size(); i++)
						{
							event.getPlayer().addItemStackToInventory((ItemStack) drops.get(i));
						}
			        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
						event.getWorld().setBlockState(event.getPos(), crop.getDefaultState());
						
					}
			}
			
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof CustomBush)
			{
				if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
				if (event.getWorld().isRemote) event.setCanceled(true);
				CustomBush bush = (CustomBush) event.getWorld().getBlockState(event.getPos()).getBlock();
		
				if (bush.isMaxAge(event.getWorld().getBlockState(event.getPos())))
					{
						event.getPlayer().swingArm(Hand.MAIN_HAND);
						event.getPlayer().addExhaustion(.05F);
						drops = HarvestDrops.spawn(bush);
						for (int i=0; i<drops.size(); i++)
						{
							event.getPlayer().addItemStackToInventory((ItemStack) drops.get(i));
						}
			        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
						event.getWorld().setBlockState(event.getPos(), bush.getDefaultState());
					}
			}
			
			
			
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof CustomCactus)
			{
				if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
				if (event.getWorld().isRemote) event.setCanceled(true);
				CustomCactus cactus = (CustomCactus) event.getWorld().getBlockState(event.getPos()).getBlock();
		
				if (cactus.isMaxAge(event.getWorld().getBlockState(event.getPos())))
					{
						event.getPlayer().swingArm(Hand.MAIN_HAND);
						event.getPlayer().addExhaustion(.05F);
						drops = HarvestDrops.spawn(cactus);
						for (int i=0; i<drops.size(); i++)
						{
							event.getPlayer().addItemStackToInventory((ItemStack) drops.get(i));
						}
			        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
						event.getWorld().setBlockState(event.getPos(), cactus.getDefaultState());
					}
			}
			
			
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof FruitLeaves)
			{
				if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
				if (event.getWorld().isRemote) event.setCanceled(true);
				FruitLeaves leaf = (FruitLeaves) event.getWorld().getBlockState(event.getPos()).getBlock();
		
				if (leaf.isMaxAge(event.getWorld().getBlockState(event.getPos())))
					{
						event.getPlayer().swingArm(Hand.MAIN_HAND);
						event.getPlayer().addExhaustion(.05F);
						drops = HarvestDrops.spawn(leaf);
						for (int i=0; i<drops.size(); i++)
						{
							event.getPlayer().addItemStackToInventory((ItemStack) drops.get(i));
						}
			        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_NETHER_WART_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
						event.getWorld().setBlockState(event.getPos(), leaf.getDefaultState());
					}
			}
			
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof GrapeBlock)
			{
				if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
				if (event.getWorld().isRemote) event.setCanceled(true);
				GrapeBlock grape = (GrapeBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
				event.getPlayer().swingArm(Hand.MAIN_HAND);
				event.getPlayer().addExhaustion(.05F);
				drops = HarvestDrops.spawn(grape);
				for (int i=0; i<drops.size(); i++)
				{
					event.getPlayer().addItemStackToInventory((ItemStack) drops.get(i));
				}
	        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
				event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState());
					
			}
			
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof WildPlant)
			{
				if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
				if (event.getWorld().isRemote) event.setCanceled(true);
				WildPlant plant = (WildPlant) event.getWorld().getBlockState(event.getPos()).getBlock();
		
				if (plant.isMaxAge(event.getWorld().getBlockState(event.getPos())))
					{
						event.getPlayer().swingArm(Hand.MAIN_HAND);
						event.getPlayer().addExhaustion(.05F);
						drops = HarvestDrops.spawn(plant);
						for (int i=0; i<drops.size(); i++)
						{
							event.getPlayer().addItemStackToInventory((ItemStack) drops.get(i));
						}
			        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
						event.getWorld().setBlockState(event.getPos(), plant.getDefaultState());
					}
					
			}
			
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof NetherWartBlock)
			{
				if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
				if (event.getWorld().isRemote) event.setCanceled(true);
				NetherWartBlock nether = (NetherWartBlock) event.getWorld().getBlockState(event.getPos()).getBlock();		
				if (event.getWorld().getBlockState(event.getPos()).get(NetherWartBlock.AGE) == 3)
					{
						event.getPlayer().swingArm(Hand.MAIN_HAND);
						event.getPlayer().addExhaustion(.05F);
						drops = HarvestDrops.spawn(nether);
						for (int i=0; i<drops.size(); i++)
						{
							event.getPlayer().addItemStackToInventory((ItemStack) drops.get(i));
						}
			        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_NETHER_WART_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
						event.getWorld().setBlockState(event.getPos(), nether.getDefaultState());
					}
					
			}
			
	
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCrop)
			{
				if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
				if (event.getWorld().isRemote) event.setCanceled(true);
				DoubleCrop crop = (DoubleCrop) event.getWorld().getBlockState(event.getPos()).getBlock();
		
				
				if (crop.getAge(event.getWorld().getBlockState(event.getPos()))==5)
				{
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getPlayer().addExhaustion(.05F);
					event.getWorld().setBlockState(event.getPos(), crop.getDefaultState().with(DoubleCrop.AGE, 6));
					event.getWorld().setBlockState(event.getPos().up(), crop.getDefaultState().with(DoubleCrop.AGE, 7));
					if (!event.getPlayer().isCreative())
		        		event.getPlayer().getHeldItem(Hand.MAIN_HAND).shrink(1); 
				}
				
					
				if (crop.getAge(event.getWorld().getBlockState(event.getPos()))==7) 
				{
					if(!event.getPlayer().getHeldItemMainhand().isEmpty()) event.setCanceled(true); //prevents blocks from being placed
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getPlayer().addExhaustion(.05F);
					drops = HarvestDrops.spawn(crop);
					for (int i=0; i<drops.size(); i++)
					{
						event.getPlayer().addItemStackToInventory((ItemStack) drops.get(i));
					}
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
		        	event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState());
		        	event.getWorld().setBlockState(event.getPos().down(), crop.getDefaultState());
				}
			}
		}
		
	}

}