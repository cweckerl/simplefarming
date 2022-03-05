package enemeez.simplefarming.client;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class ClientRenderer {

	public static void registerBlocks() {
		Block[] cutOut = { ModBlocks.APPLE_SAPLING.get(), ModBlocks.APRICOT_SAPLING.get(), ModBlocks.BANANA_SAPLING.get(), ModBlocks.CHERRY_SAPLING.get(), ModBlocks.MANGO_SAPLING.get(), ModBlocks.OLIVE_SAPLING.get(),
				ModBlocks.ORANGE_SAPLING.get(), ModBlocks.PLUM_SAPLING.get(), ModBlocks.PEAR_SAPLING.get(), ModBlocks.GRAPE_BLOCK.get(), ModBlocks.WILD_CROP.get(), ModBlocks.CHICORY.get(), ModBlocks.CUMIN.get(), ModBlocks.MARSHMALLOW.get(),
				ModBlocks.QUINOA.get(), ModBlocks.SUNFLOWER.get(), ModBlocks.BARLEY_CROP.get(), ModBlocks.BROCCOLI_CROP.get(), ModBlocks.CACTUS_CROP.get(), ModBlocks.CANTALOUPE_CROP.get(), ModBlocks.CARROT_CROP.get(), ModBlocks.CASSAVA_CROP.get(),
				ModBlocks.CORN_CROP.get(), ModBlocks.COTTON_CROP.get(), ModBlocks.CUCUMBER_CROP.get(), ModBlocks.EGGPLANT_CROP.get(), ModBlocks.HONEYDEW_CROP.get(), ModBlocks.GINGER_CROP.get(), ModBlocks.KENAF_CROP.get(),
				ModBlocks.LETTUCE_CROP.get(), ModBlocks.OAT_CROP.get(), ModBlocks.ONION_CROP.get(), ModBlocks.PEANUT_CROP.get(), ModBlocks.PEA_CROP.get(), ModBlocks.PEPPER_CROP.get(), ModBlocks.POTATO_CROP.get(), ModBlocks.RADISH_CROP.get(),
				ModBlocks.RICE_CROP.get(), ModBlocks.RYE_CROP.get(), ModBlocks.SORGHUM_CROP.get(), ModBlocks.SOYBEAN_CROP.get(), ModBlocks.SPINACH_CROP.get(), ModBlocks.SQUASH_CROP.get(), ModBlocks.SWEET_POTATO_CROP.get(),
				ModBlocks.TOMATO_CROP.get(), ModBlocks.TURNIP_CROP.get(), ModBlocks.YAM_CROP.get(), ModBlocks.ZUCCHINI_CROP.get(), ModBlocks.PUMPKIN_CROP.get(), ModBlocks.MELON_CROP.get() };
		Block[] leaves = { ModBlocks.BLACKBERRY_BUSH.get(), ModBlocks.BLUEBERRY_BUSH.get(), ModBlocks.RASPBERRY_BUSH.get(), ModBlocks.STRAWBERRY_BUSH.get(), ModBlocks.APPLE_LEAVES.get(), ModBlocks.APRICOT_LEAVES.get(),
				ModBlocks.BANANA_LEAVES.get(), ModBlocks.CHERRY_LEAVES.get(), ModBlocks.MANGO_LEAVES.get(), ModBlocks.OLIVE_LEAVES.get(), ModBlocks.ORANGE_LEAVES.get(), ModBlocks.PLUM_LEAVES.get(), ModBlocks.PEAR_LEAVES.get(),
				ModBlocks.GRAPE_LEAVES.get(), ModBlocks.GRAPE_LEAVES_BASE.get() };
		for (Block block : cutOut) {
			ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout());
		}

		for (Block block : leaves) {
			ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutoutMipped());
		}
	}
}
