package enemeez.simplefarming.init;

import javax.annotation.Nullable;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.blocks.CheeseBlock;
import enemeez.simplefarming.blocks.CustomBush;
import enemeez.simplefarming.blocks.CustomCactus;
import enemeez.simplefarming.blocks.CustomCrop;
import enemeez.simplefarming.blocks.CustomSapling;
import enemeez.simplefarming.blocks.DoubleCrop;
import enemeez.simplefarming.blocks.FruitLeaves;
import enemeez.simplefarming.blocks.FruitLog;
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks 
{
	//Bush
	public static BushBlock blackberry_bush;
	public static BushBlock blueberry_bush;
	public static BushBlock raspberry_bush;
	public static BushBlock strawberry_bush;
	
	//Gourds
	public static Block cantaloupe_block;
	public static Block squash_block;
	
	//Cheese
	public static Block cheese_block;
	
	//Tree
	public static Block fruit_log;
	
	public static Block apple_sapling;
	public static Block apricot_sapling;
	public static Block banana_sapling;
	public static Block orange_sapling;
	public static Block plum_sapling;
	public static Block pear_sapling;
	
	//Leaves
	public static Block apple_leaves;
	public static Block apricot_leaves;
	public static Block banana_leaves;
	public static Block orange_leaves;
	public static Block plum_leaves;
	public static Block pear_leaves;
	
	//Crops
	public static Block cactus_crop;
	public static Block cantaloupe_crop;
	public static Block carrot_crop;
	public static Block corn_crop;
	public static Block cucumber_crop;
	public static Block eggplant_crop;
	public static Block kenaf_crop;
	public static Block lettuce_crop;
	public static Block oat_crop;
	public static Block onion_crop;
	public static Block pepper_crop;
	public static Block potato_crop;
	public static Block radish_crop;
	public static Block rice_crop;
	public static Block rye_crop;
	public static Block soybean_crop;
	public static Block spinach_crop;
	public static Block squash_crop;
	public static Block tomato_crop;
	public static Block yam_crop;


	public static void registerAll(RegistryEvent.Register<Block> event)
	{ 
	  if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;

		cantaloupe_block = register("cantaloupe_block", new Block(
				Block.Properties.create(Material.GOURD)
				.sound(SoundType.WOOD)
				.hardnessAndResistance(1.0f)));
		squash_block = register("squash_block", new Block(
				Block.Properties.create(Material.GOURD)
				.sound(SoundType.WOOD)
				.hardnessAndResistance(1.0f)));
		
		apple_sapling = register("apple_sapling", new CustomSapling(
				Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0f)
				.sound(SoundType.PLANT), 1));
		apricot_sapling = register("apricot_sapling", new CustomSapling(
				Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0f)
				.sound(SoundType.PLANT), 2));
		banana_sapling = register("banana_sapling", new CustomSapling(
				Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0f)
				.sound(SoundType.PLANT), 3));
		orange_sapling = register("orange_sapling", new CustomSapling(
				Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0f)
				.sound(SoundType.PLANT), 5));
		pear_sapling = register("pear_sapling", new CustomSapling(
				Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0f)
				.sound(SoundType.PLANT), 6));
		plum_sapling = register("plum_sapling", new CustomSapling(
				Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0f)
				.sound(SoundType.PLANT), 4));
		
		apple_leaves = registerCrop("apple_leaves", new FruitLeaves(
				Block.Properties.create(Material.LEAVES)
				.hardnessAndResistance(0.2F)
				.tickRandomly()
				.sound(SoundType.PLANT), 1 ));
		
		apricot_leaves = registerCrop("apricot_leaves", new FruitLeaves(
				Block.Properties.create(Material.LEAVES)
				.hardnessAndResistance(0.2F)
				.tickRandomly()
				.sound(SoundType.PLANT), 2 ));
		
		banana_leaves = registerCrop("banana_leaves", new FruitLeaves(
				Block.Properties.create(Material.LEAVES)
				.hardnessAndResistance(0.2F)
				.tickRandomly()
				.sound(SoundType.PLANT), 3 ));
		orange_leaves = registerCrop("orange_leaves", new FruitLeaves(
				Block.Properties.create(Material.LEAVES)
				.hardnessAndResistance(0.2F)
				.tickRandomly()
				.sound(SoundType.PLANT), 5 ));
		pear_leaves = registerCrop("pear_leaves", new FruitLeaves(
				Block.Properties.create(Material.LEAVES)
				.hardnessAndResistance(0.2F)
				.tickRandomly()
				.sound(SoundType.PLANT), 6 ));
		plum_leaves = registerCrop("plum_leaves", new FruitLeaves(
				Block.Properties.create(Material.LEAVES)
				.hardnessAndResistance(0.2F)
				.tickRandomly()
				.sound(SoundType.PLANT), 4 ));
				
		fruit_log = register("fruit_log", new FruitLog(
				Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN)
				.hardnessAndResistance(2.0F)
				.sound(SoundType.WOOD)));
	
		cheese_block = register("cheese_block", new CheeseBlock(
				Block.Properties.create(Material.CAKE)
				.hardnessAndResistance(0.5F)
				.sound(SoundType.CLOTH)));
		
		squash_crop = registerCrop("squash_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.STEM), ModItems.squash_seeds, 18));
		
		cactus_crop = register("cactus_crop", new CustomCactus(
				(Block.Properties.create(Material.PLANTS)
				.tickRandomly()
				.hardnessAndResistance(0.2f)
				.sound(SoundType.CLOTH))));
		
		cantaloupe_crop = registerCrop("cantaloupe_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.STEM), ModItems.cantaloupe_seeds, 19));

		blackberry_bush = register("blackberry_bush", new CustomBush(
				(Block.Properties.create(Material.PLANTS)
				.tickRandomly()
				.doesNotBlockMovement()
				.hardnessAndResistance(0.2f)
				.sound(SoundType.SWEET_BERRY_BUSH)),1));
		blueberry_bush = register("blueberry_bush", new CustomBush(
				(Block.Properties.create(Material.PLANTS)
				.tickRandomly()
				.doesNotBlockMovement()
				.hardnessAndResistance(0.2f)
				.sound(SoundType.SWEET_BERRY_BUSH)),2));
		raspberry_bush = register("raspberry_bush", new CustomBush(
				(Block.Properties.create(Material.PLANTS)
				.tickRandomly()
				.doesNotBlockMovement()
				.hardnessAndResistance(0.2f)
				.sound(SoundType.SWEET_BERRY_BUSH)),3));
		strawberry_bush = register("strawberry_bush", new CustomBush(
				(Block.Properties.create(Material.PLANTS)
				.tickRandomly()
				.doesNotBlockMovement()
				.hardnessAndResistance(0.2f)
				.sound(SoundType.SWEET_BERRY_BUSH)),4));
		
		carrot_crop = registerCrop("carrot_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.carrot_seeds, 14));
		
		corn_crop = registerCrop("corn_crop", new DoubleCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP)));
				

		cucumber_crop = registerCrop("cucumber_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.cucumber_seeds, 1));
		
		eggplant_crop = registerCrop("eggplant_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.eggplant_seeds, 2));
		
		kenaf_crop = registerCrop("kenaf_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.kenaf_seeds, 17));
		
		lettuce_crop = registerCrop("lettuce_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.lettuce_seeds, 3));
		
		oat_crop = registerCrop("oat_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.oat_seeds, 4));
		
		onion_crop = registerCrop("onion_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.onion_seeds, 5));
		
		pepper_crop = registerCrop("pepper_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.pepper_seeds, 6));
		
		potato_crop = registerCrop("potato_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.potato_seeds, 15));
		
		radish_crop = registerCrop("radish_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.radish_seeds, 7));
		
		rice_crop = registerCrop("rice_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.rice_seeds, 8));
		
		rye_crop = registerCrop("rye_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.rye_seeds, 9));
		
		soybean_crop = registerCrop("soybean_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.soybean_seeds, 10));
		
		spinach_crop = registerCrop("spinach_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.spinach_seeds, 11));
		
		tomato_crop = registerCrop("tomato_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.tomato_seeds, 12));
		
		yam_crop = registerCrop("yam_crop", new CustomCrop
				(Block.Properties.create(Material.PLANTS)
				.doesNotBlockMovement()
				.tickRandomly()
				.hardnessAndResistance(0)
				.sound(SoundType.CROP), ModItems.yam_seeds, 13));
	
	}
	
	   private static <T extends Block> T register(String name, T block) 
	   	{
	        BlockItem item = new BlockItem(block, new Item.Properties().group(SimpleFarming.ITEM_GROUP));
	        return register(name, block, item);
	    }
	
		private static <T extends Block> T register(String name, T block, @Nullable BlockItem item)
		{
			ResourceLocation id = SimpleFarming.getId(name);
			block.setRegistryName(id);
			ForgeRegistries.BLOCKS.register(block);
			if (item != null) 
			{
	           ModItems.BLOCKS_TO_REGISTER.put(name, item);
	            
	        }
			return block;
		}
	
	
		
	  private static <T extends Block> T registerCrop(String name, T block) 
	   	{
	        BlockItem item = new BlockItem(block, new Item.Properties().group(SimpleFarming.ITEM_GROUP));
	        return registerCrop(name, block, item);
	    }
	  
	  private static <T extends Block> T registerCrop(String name, T block, @Nullable BlockItem item)
		{
			ResourceLocation id = SimpleFarming.getId(name);
			block.setRegistryName(id);
			ForgeRegistries.BLOCKS.register(block);
			return block;
		}
		

}
