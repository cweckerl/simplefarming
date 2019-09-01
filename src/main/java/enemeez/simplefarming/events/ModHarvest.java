package enemeez.simplefarming.events;

import java.util.ArrayList;

import enemeez.simplefarming.blocks.CustomBush;
import enemeez.simplefarming.blocks.CustomCactus;
import enemeez.simplefarming.blocks.DoubleCrop;
import enemeez.simplefarming.blocks.FruitLeaves;
import enemeez.simplefarming.blocks.GrapeBlock;
import enemeez.simplefarming.blocks.WildPlant;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModHarvest 
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
						drops = spawn(crop);
						for (int i=0; i<drops.size(); i++)
						{
							event.getWorld().addEntity(new ItemEntity(
									(World) event.getWorld(),
									event.getPos().getX(), 
									event.getPos().getY(), 
									event.getPos().getZ(), 
									(ItemStack) drops.get(i)));
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
						drops = spawn(bush);
						for (int i=0; i<drops.size(); i++)
						{
						event.getWorld().addEntity(new ItemEntity(
								(World) event.getWorld(),
								event.getPos().getX(), 
								event.getPos().getY(), 
								event.getPos().getZ(), 
								(ItemStack) drops.get(i)));
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
						drops = spawn(cactus);
						for (int i=0; i<drops.size(); i++)
						{
						event.getWorld().addEntity(new ItemEntity(
								(World) event.getWorld(),
								event.getPos().getX(), 
								event.getPos().getY(), 
								event.getPos().getZ(), 
								(ItemStack) drops.get(i)));
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
						drops = spawn(leaf);
						for (int i=0; i<drops.size(); i++)
						{
						event.getWorld().addEntity(new ItemEntity(
								(World) event.getWorld(),
								event.getPos().getX(), 
								event.getPos().getY(), 
								event.getPos().getZ(), 
								(ItemStack) drops.get(i)));
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
				drops = spawn(grape);
				for (int i=0; i<drops.size(); i++)
				{
				event.getWorld().addEntity(new ItemEntity(
						(World) event.getWorld(),
						event.getPos().getX(), 
						event.getPos().getY(), 
						event.getPos().getZ(), 
						(ItemStack) drops.get(i)));
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
						drops = spawn(plant);
						for (int i=0; i<drops.size(); i++)
						{
						event.getWorld().addEntity(new ItemEntity(
								(World) event.getWorld(),
								event.getPos().getX(), 
								event.getPos().getY(), 
								event.getPos().getZ(), 
								(ItemStack) drops.get(i)));
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
						drops = spawn(nether);
						for (int i=0; i<drops.size(); i++)
						{
						event.getWorld().addEntity(new ItemEntity(
								(World) event.getWorld(),
								event.getPos().getX(), 
								event.getPos().getY(), 
								event.getPos().getZ(), 
								(ItemStack) drops.get(i)));
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
		
				
				if (crop.getAge(event.getWorld().getBlockState(event.getPos()))==5 
						&& event.getPlayer().getHeldItemMainhand().getItem() == Items.BONE_MEAL)
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
					drops = spawn(crop);
					for (int i=0; i<drops.size(); i++)
					{
					event.getWorld().addEntity(new ItemEntity(
							(World) event.getWorld(),
							event.getPos().getX(), 
							event.getPos().getY(), 
							event.getPos().getZ(), 
							(ItemStack) drops.get(i)));
					}
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
		        	event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState());
		        	event.getWorld().setBlockState(event.getPos().down(), crop.getDefaultState());
				}
			}
		}
		
	}

	private ArrayList<ItemStack> spawn(Block blockIn)
	{
		ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();;

        int random = (int)((Math.random()*4)+1);

        
    	if (blockIn == Blocks.WHEAT)
			stacks.add(new ItemStack(Items.WHEAT));
		if (blockIn == Blocks.CARROTS || blockIn == ModBlocks.carrot_crop)
			stacks.add(new ItemStack(Items.CARROT, random));
		if (blockIn == Blocks.POTATOES || blockIn == ModBlocks.potato_crop)
		{
			if (Math.random()<=0.02)
			stacks.add(new ItemStack(Items.POISONOUS_POTATO));
			stacks.add(new ItemStack(Items.POTATO, random));
		}
		if (blockIn == Blocks.BEETROOTS)
			stacks.add(new ItemStack(Items.BEETROOT));
		if (blockIn == Blocks.NETHER_WART)
			stacks.add(new ItemStack(Items.NETHER_WART, (int)((Math.random()*3)+2)));
		
		if (blockIn == ModBlocks.cucumber_crop)
			stacks.add(new ItemStack(ModItems.cucumber, random));
		if (blockIn == ModBlocks.eggplant_crop)
			stacks.add(new ItemStack(ModItems.eggplant, random));
		if (blockIn == ModBlocks.lettuce_crop)
			stacks.add(new ItemStack(ModItems.lettuce, random));
		if (blockIn == ModBlocks.oat_crop)
			stacks.add(new ItemStack(ModItems.oat));
		if (blockIn == ModBlocks.onion_crop)
			stacks.add(new ItemStack(ModItems.onion, random));
		if (blockIn == ModBlocks.pepper_crop)
		{
			if (Math.random()<=0.1)
			stacks.add(new ItemStack(ModItems.habanero));
			stacks.add(new ItemStack(ModItems.pepper, random));
		}
		if (blockIn == ModBlocks.radish_crop)
			stacks.add(new ItemStack(ModItems.radish, random));
		if (blockIn == ModBlocks.rice_crop)
			stacks.add(new ItemStack(ModItems.rice));
		if (blockIn == ModBlocks.rye_crop)
			stacks.add(new ItemStack(ModItems.rye));
		if (blockIn == ModBlocks.soybean_crop)
			stacks.add(new ItemStack(ModItems.soybean, random));
		if (blockIn == ModBlocks.spinach_crop)
			stacks.add(new ItemStack(ModItems.spinach, random));
		if (blockIn == ModBlocks.tomato_crop)
			stacks.add(new ItemStack(ModItems.tomato, random));
		if (blockIn == ModBlocks.yam_crop)
			stacks.add(new ItemStack(ModItems.yam, random));
		if (blockIn == ModBlocks.squash_crop)
			stacks.add(new ItemStack(ModItems.squash_block));
		if (blockIn == ModBlocks.cantaloupe_crop)
			stacks.add(new ItemStack(ModItems.cantaloupe_block));
		if (blockIn == ModBlocks.cassava_crop)
			stacks.add(new ItemStack(ModItems.cassava, random));
		if (blockIn == ModBlocks.honeydew_crop)
			stacks.add(new ItemStack(ModItems.honeydew_block));
		if (blockIn == ModBlocks.ginger_crop)
			stacks.add(new ItemStack(ModItems.ginger, random));
		if (blockIn == ModBlocks.peanut_crop)
			stacks.add(new ItemStack(ModItems.peanut, random));
		if (blockIn == ModBlocks.blackberry_bush)
			stacks.add(new ItemStack(ModItems.blackberries, random));
		if (blockIn == ModBlocks.blueberry_bush)
			stacks.add(new ItemStack(ModItems.blueberries, random));
		if (blockIn == ModBlocks.raspberry_bush)
			stacks.add(new ItemStack(ModItems.raspberries, random));
		if (blockIn == ModBlocks.strawberry_bush)
			stacks.add(new ItemStack(ModItems.strawberries, random));
		if (blockIn == ModBlocks.cactus_crop)
			stacks.add(new ItemStack(ModItems.cactus_fruit, random));
		if (blockIn == ModBlocks.apple_leaves)
			stacks.add(new ItemStack(Items.APPLE));
		if (blockIn == ModBlocks.apricot_leaves)
			stacks.add(new ItemStack(ModItems.apricot));
		if (blockIn == ModBlocks.banana_leaves)
			stacks.add(new ItemStack(ModItems.banana));
		if (blockIn == ModBlocks.cherry_leaves)
			stacks.add(new ItemStack(ModItems.cherries));
		if (blockIn == ModBlocks.orange_leaves)
			stacks.add(new ItemStack(ModItems.orange));
		if (blockIn == ModBlocks.mango_leaves)
			stacks.add(new ItemStack(ModItems.mango));
		if (blockIn == ModBlocks.pear_leaves)
			stacks.add(new ItemStack(ModItems.pear));
		if (blockIn == ModBlocks.plum_leaves)
			stacks.add(new ItemStack(ModItems.plum));
		if (blockIn == ModBlocks.grape_block)
			stacks.add(new ItemStack(ModItems.grapes));
		if (blockIn == ModBlocks.quinoa)
			stacks.add(new ItemStack(ModItems.quinoa_seeds, random));
		if (blockIn == ModBlocks.cumin)
			stacks.add(new ItemStack(ModItems.cumin_seeds, random));
		if (blockIn == ModBlocks.corn_crop)
			stacks.add(new ItemStack(ModItems.corn, random));
		if (blockIn == ModBlocks.kenaf_crop)
			stacks.add(new ItemStack(ModItems.kenaf_fiber, random));
		if (blockIn == ModBlocks.sorghum_crop)
			stacks.add(new ItemStack(ModItems.sorghum, random));
		if (blockIn == ModBlocks.barley_crop)
			stacks.add(new ItemStack(ModItems.barley));
		if (blockIn == ModBlocks.pea_crop)
			stacks.add(new ItemStack(ModItems.pea_pod, random));
		if (blockIn == ModBlocks.sweet_potato_crop)
			stacks.add(new ItemStack(ModItems.sweet_potato, random));
		if (blockIn == ModBlocks.sunflower)
			stacks.add(new ItemStack(ModItems.sunflower_seeds, random));
		if (blockIn == ModBlocks.cotton_crop)
			stacks.add(new ItemStack(ModItems.cotton, random));

		else 
			stacks.add(new ItemStack(Items.AIR));

		return stacks;
			
		
			
	}

}
