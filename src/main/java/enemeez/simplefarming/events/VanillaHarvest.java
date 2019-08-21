package enemeez.simplefarming.events;

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

public class VanillaHarvest 
{
	@SubscribeEvent
	public void onCropHarvest(RightClickBlock event)
	{

		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof CropsBlock && !(event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCrop))
		{
			if (event.getWorld().isRemote) event.setCanceled(true);
			CropsBlock crop = (CropsBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
	
			if (crop.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getWorld().addEntity(new ItemEntity(
							(World) event.getWorld(),
							event.getPos().getX(), 
							event.getPos().getY(), 
							event.getPos().getZ(), 
							spawn(crop)));
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
					event.getWorld().setBlockState(event.getPos(), crop.getDefaultState());
					
				}
		}
		
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof CustomBush)
		{
			if (event.getWorld().isRemote) event.setCanceled(true);
			CustomBush bush = (CustomBush) event.getWorld().getBlockState(event.getPos()).getBlock();
	
			if (bush.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getWorld().addEntity(new ItemEntity(
							(World) event.getWorld(),
							event.getPos().getX(), 
							event.getPos().getY(), 
							event.getPos().getZ(), 
							spawn(bush)));
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
					event.getWorld().setBlockState(event.getPos(), bush.getDefaultState());
				}
		}
		
		
		
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof CustomCactus)
		{
			if (event.getWorld().isRemote) event.setCanceled(true);
			CustomCactus cactus = (CustomCactus) event.getWorld().getBlockState(event.getPos()).getBlock();
	
			if (cactus.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getWorld().addEntity(new ItemEntity(
							(World) event.getWorld(),
							event.getPos().getX(), 
							event.getPos().getY(), 
							event.getPos().getZ(), 
							spawn(cactus)));
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
					event.getWorld().setBlockState(event.getPos(), cactus.getDefaultState());
				}
		}
		
		
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof FruitLeaves)
		{
			if (event.getWorld().isRemote) event.setCanceled(true);
			FruitLeaves leaf = (FruitLeaves) event.getWorld().getBlockState(event.getPos()).getBlock();
	
			if (leaf.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getWorld().addEntity(new ItemEntity(
							(World) event.getWorld(),
							event.getPos().getX(), 
							event.getPos().getY(), 
							event.getPos().getZ(), 
							spawn(leaf)));
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_NETHER_WART_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
					event.getWorld().setBlockState(event.getPos(), leaf.getDefaultState());
				}
		}
		
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof GrapeBlock)
		{
			if (event.getWorld().isRemote) event.setCanceled(true);
			GrapeBlock grape = (GrapeBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
			event.getPlayer().swingArm(Hand.MAIN_HAND);
			event.getWorld().addEntity(new ItemEntity(
					(World) event.getWorld(),
					event.getPos().getX(), 
					event.getPos().getY(), 
					event.getPos().getZ(), 
					spawn(grape)));
        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
			event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState());
				
		}
		
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof WildPlant)
		{
			if (event.getWorld().isRemote) event.setCanceled(true);
			WildPlant plant = (WildPlant) event.getWorld().getBlockState(event.getPos()).getBlock();
	
			if (plant.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getWorld().addEntity(new ItemEntity(
							(World) event.getWorld(),
							event.getPos().getX(), 
							event.getPos().getY(), 
							event.getPos().getZ(), 
							spawn(plant)));
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
					event.getWorld().setBlockState(event.getPos(), plant.getDefaultState());
				}
				
		}
		
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof NetherWartBlock)
		{
			if (event.getWorld().isRemote) event.setCanceled(true);
			NetherWartBlock nether = (NetherWartBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
	
			if (event.getWorld().getBlockState(event.getPos()).get(NetherWartBlock.AGE) == 3)
				{
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getWorld().addEntity(new ItemEntity(
							(World) event.getWorld(),
							event.getPos().getX(), 
							event.getPos().getY(), 
							event.getPos().getZ(), 
							spawn(nether)));
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_NETHER_WART_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
					event.getWorld().setBlockState(event.getPos(), nether.getDefaultState());
				}
				
		}
		

		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCrop)
		{
			if (event.getWorld().isRemote) event.setCanceled(true);
			DoubleCrop crop = (DoubleCrop) event.getWorld().getBlockState(event.getPos()).getBlock();
	
			
			if (crop.getAge(event.getWorld().getBlockState(event.getPos()))==5 
					&& event.getPlayer().getHeldItemMainhand().getItem() == Items.BONE_MEAL)
			{
				event.getPlayer().swingArm(Hand.MAIN_HAND);
				event.getWorld().setBlockState(event.getPos(), crop.getDefaultState().with(DoubleCrop.AGE, 6));
				event.getWorld().setBlockState(event.getPos().up(), crop.getDefaultState().with(DoubleCrop.AGE, 7));
				if (!event.getPlayer().isCreative())
	        		event.getPlayer().getHeldItem(Hand.MAIN_HAND).shrink(1); 
			}
			
				
			if (crop.getAge(event.getWorld().getBlockState(event.getPos()))==7) 
			{
				event.getPlayer().swingArm(Hand.MAIN_HAND);
				event.getWorld().addEntity(new ItemEntity(
						(World) event.getWorld(),
						event.getPos().getX(), 
						event.getPos().getY(), 
						event.getPos().getZ(), 
						spawn(crop)));
	        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
	        	event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState());
	        	event.getWorld().setBlockState(event.getPos().down(), crop.getDefaultState());
			}
		}
	
}
	
	
	private ItemStack spawn(Block blockIn)
	{
        int random = (int)((Math.random()*4)+1);

		if (blockIn == Blocks.WHEAT)
			return new ItemStack(Items.WHEAT);
		if (blockIn == Blocks.CARROTS || blockIn == ModBlocks.carrot_crop)
			return new ItemStack(Items.CARROT, random);
		if (blockIn == Blocks.POTATOES || blockIn == ModBlocks.potato_crop)
		{
			if (Math.random()<=0.02)
			return new ItemStack(Items.POISONOUS_POTATO);
			else return new ItemStack(Items.POTATO, random);
		}
		if (blockIn == Blocks.BEETROOTS)
			return new ItemStack(Items.BEETROOT);
		
		if (blockIn == ModBlocks.cucumber_crop)
			return new ItemStack(ModItems.cucumber, random);
		if (blockIn == ModBlocks.eggplant_crop)
			return new ItemStack(ModItems.eggplant, random);
		if (blockIn == ModBlocks.lettuce_crop)
			return new ItemStack(ModItems.lettuce, random);
		if (blockIn == ModBlocks.oat_crop)
			return new ItemStack(ModItems.oat);
		if (blockIn == ModBlocks.onion_crop)
			return new ItemStack(ModItems.onion, random);
		if (blockIn == ModBlocks.pepper_crop)
		{
			if (Math.random()<=0.05)
			return new ItemStack(ModItems.habanero);
			else return new ItemStack(ModItems.pepper, random);
		}
		if (blockIn == ModBlocks.radish_crop)
			return new ItemStack(ModItems.radish);
		if (blockIn == ModBlocks.rice_crop)
			return new ItemStack(ModItems.rice);
		if (blockIn == ModBlocks.rye_crop)
			return new ItemStack(ModItems.rye);
		if (blockIn == ModBlocks.soybean_crop)
			return new ItemStack(ModItems.soybean, random);
		if (blockIn == ModBlocks.spinach_crop)
			return new ItemStack(ModItems.spinach, random);
		if (blockIn == ModBlocks.tomato_crop)
			return new ItemStack(ModItems.tomato, random);
		if (blockIn == ModBlocks.yam_crop)
			return new ItemStack(ModItems.yam, random);
		if (blockIn == ModBlocks.squash_crop)
			return new ItemStack(ModItems.squash_block);
		if (blockIn == ModBlocks.cantaloupe_crop)
			return new ItemStack(ModItems.cantaloupe_block);
		if (blockIn == ModBlocks.cassava_crop)
			return new ItemStack(ModItems.cassava, random);
		if (blockIn == ModBlocks.honeydew_crop)
			return new ItemStack(ModItems.honeydew_block);
		if (blockIn == ModBlocks.ginger_crop)
			return new ItemStack(ModItems.ginger, random);
		if (blockIn == ModBlocks.peanut_crop)
			return new ItemStack(ModItems.peanut, random);
		if (blockIn == ModBlocks.blackberry_bush)
			return new ItemStack(ModItems.blackberries, random);
		if (blockIn == ModBlocks.blueberry_bush)
			return new ItemStack(ModItems.blueberries, random);
		if (blockIn == ModBlocks.raspberry_bush)
			return new ItemStack(ModItems.raspberries, random);
		if (blockIn == ModBlocks.strawberry_bush)
			return new ItemStack(ModItems.strawberries, random);
		if (blockIn == ModBlocks.cactus_crop)
			return new ItemStack(ModItems.cactus_fruit, random);
		if (blockIn == ModBlocks.apple_leaves)
			return new ItemStack(Items.APPLE);
		if (blockIn == ModBlocks.apricot_leaves)
			return new ItemStack(ModItems.apricot);
		if (blockIn == ModBlocks.banana_leaves)
			return new ItemStack(ModItems.banana);
		if (blockIn == ModBlocks.cherry_leaves)
			return new ItemStack(ModItems.cherries);
		if (blockIn == ModBlocks.orange_leaves)
			return new ItemStack(ModItems.orange);
		if (blockIn == ModBlocks.mango_leaves)
			return new ItemStack(ModItems.mango);
		if (blockIn == ModBlocks.pear_leaves)
			return new ItemStack(ModItems.pear);
		if (blockIn == ModBlocks.plum_leaves)
			return new ItemStack(ModItems.plum);
		if (blockIn == ModBlocks.grape_block)
			return new ItemStack(ModItems.grapes);
		if (blockIn == ModBlocks.quinoa)
			return new ItemStack(ModItems.quinoa_seeds, random);
		if (blockIn == ModBlocks.cumin)
			return new ItemStack(ModItems.cumin_seeds, random);
		if (blockIn == ModBlocks.corn_crop)
			return new ItemStack(ModItems.corn, random);
		if (blockIn == ModBlocks.kenaf_crop)
			return new ItemStack(ModItems.kenaf_fiber, random);
		if (blockIn == ModBlocks.sorghum_crop)
			return new ItemStack(ModItems.sorghum, random);
		if (blockIn == Blocks.NETHER_WART)
			return new ItemStack(Items.NETHER_WART, (int)((Math.random()*3)+2));

		else 
			return new ItemStack(Items.AIR);
		
			
	}
}
