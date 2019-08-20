package enemeez.simplefarming.events;

import enemeez.simplefarming.blocks.DoubleCrop;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
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
			CropsBlock bingo = (CropsBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
	
			if (bingo.isMaxAge(event.getWorld().getBlockState(event.getPos())))
				{
					event.getPlayer().swingArm(Hand.MAIN_HAND);
					event.getWorld().addEntity(new ItemEntity(
							(World) event.getWorld(),
							event.getPos().getX(), 
							event.getPos().getY(), 
							event.getPos().getZ(), 
							spawn(bingo)));
		        	event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
					event.getWorld().setBlockState(event.getPos(), bingo.getDefaultState());
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
		else 
			return new ItemStack(Items.AIR);
		
			
	}
}
