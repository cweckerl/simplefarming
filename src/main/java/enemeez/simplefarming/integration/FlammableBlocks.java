package enemeez.simplefarming.integration;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;

public class FlammableBlocks {
	public static void registerFlammable() {
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.fruit_log, 5, 5);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.blackberry_bush, 60, 100);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.blueberry_bush, 60, 100);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.raspberry_bush, 60, 100);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.strawberry_bush, 60, 100);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.blueberry_bush, 60, 100);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.barley_hay_block, 60, 20);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.rice_hay_block, 60, 20);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.rye_hay_block, 60, 20);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.oat_hay_block, 60, 20);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.apple_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.apricot_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.banana_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.cherry_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.olive_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.plum_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.mango_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.pear_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.orange_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.grape_leaves_base, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.grape_leaves, 30, 60);
		((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.grape_plant, 5, 5);
	}
}
