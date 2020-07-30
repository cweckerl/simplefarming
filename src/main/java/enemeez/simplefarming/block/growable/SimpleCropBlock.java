package enemeez.simplefarming.block.growable;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SimpleCropBlock extends CropsBlock {
	private String name;

	public SimpleCropBlock(Block.Properties properties, String name) {
		super(properties);
		this.name = name;
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}

	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmlandBlock;
	}

	/*
	 * Crops are given textures/models based on name No individual inheritance of
	 * SimpleCropBlock method
	 */

	protected IItemProvider getSeedsItem() {
		switch (name) {
		case "barley":
			return ModItems.barley_seeds;
		case "broccoli":
			return ModItems.broccoli_seeds;
		case "carrot":
			return ModItems.carrot_seeds;
		case "potato":
			return ModItems.potato_seeds;
		case "cucumber":
			return ModItems.cucumber_seeds;
		case "eggplant":
			return ModItems.eggplant_seeds;
		case "lettuce":
			return ModItems.lettuce_seeds;
		case "oat":
			return ModItems.oat_seeds;
		case "onion":
			return ModItems.onion_seeds;
		case "pea":
			return ModItems.pea_seeds;
		case "pepper":
			return ModItems.pepper_seeds;
		case "radish":
			return ModItems.radish_seeds;
		case "rice":
			return ModItems.rice_seeds;
		case "rye":
			return ModItems.rye_seeds;
		case "soybean":
			return ModItems.soybean_seeds;
		case "spinach":
			return ModItems.spinach_seeds;
		case "tomato":
			return ModItems.tomato_seeds;
		case "yam":
			return ModItems.yam_seeds;
		case "squash":
			return ModItems.squash_seeds;
		case "cantaloupe":
			return ModItems.cantaloupe_seeds;
		case "cassava":
			return ModItems.cassava_seeds;
		case "honeydew":
			return ModItems.honeydew_seeds;
		case "ginger":
			return ModItems.ginger_seeds;
		case "cotton":
			return ModItems.cotton_seeds;
		case "sweet_potato":
			return ModItems.sweet_potato_seeds;
		case "zucchini":
			return ModItems.zucchini_seeds;
		case "turnip":
			return ModItems.turnip_seeds;
		case "melon":
			return Items.MELON_SEEDS;
		case "pumpkin":
			return Items.PUMPKIN_SEEDS;
		default:
			return ModItems.peanut_seeds;
		}
	}

	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		switch (name) {
		case "barley":
			return new ItemStack(ModItems.barley);
		case "broccoli":
			return new ItemStack(ModItems.broccoli);
		case "carrot":
			return new ItemStack(Items.CARROT);
		case "potato":
			return new ItemStack(Items.POTATO);
		case "cucumber":
			return new ItemStack(ModItems.cucumber);
		case "eggplant":
			return new ItemStack(ModItems.eggplant);
		case "lettuce":
			return new ItemStack(ModItems.lettuce);
		case "oat":
			return new ItemStack(ModItems.oat);
		case "onion":
			return new ItemStack(ModItems.onion);
		case "pea":
			return new ItemStack(ModItems.pea_pod);
		case "pepper":
			return new ItemStack(ModItems.pepper);
		case "radish":
			return new ItemStack(ModItems.radish);
		case "rice":
			return new ItemStack(ModItems.rice);
		case "rye":
			return new ItemStack(ModItems.rye);
		case "soybean":
			return new ItemStack(ModItems.soybean);
		case "spinach":
			return new ItemStack(ModItems.spinach);
		case "tomato":
			return new ItemStack(ModItems.tomato);
		case "yam":
			return new ItemStack(ModItems.yam);
		case "squash":
			return new ItemStack(ModItems.squash_block);
		case "cantaloupe":
			return new ItemStack(ModItems.cantaloupe_block);
		case "cassava":
			return new ItemStack(ModItems.cassava);
		case "honeydew":
			return new ItemStack(ModItems.honeydew_block);
		case "ginger":
			return new ItemStack(ModItems.ginger);
		case "cotton":
			return new ItemStack(ModItems.cotton);
		case "sweet_potato":
			return new ItemStack(ModItems.sweet_potato);
		case "zucchini":
			return new ItemStack(ModItems.zucchini);
		case "turnip":
			return new ItemStack(ModItems.turnip);
		case "melon":
			return new ItemStack(Items.MELON);
		case "pumpkin":
			return new ItemStack(Items.PUMPKIN);
		default:
			return new ItemStack(ModItems.peanut);
		}
	}

}