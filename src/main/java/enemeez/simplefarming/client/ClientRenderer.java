package enemeez.simplefarming.client;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class ClientRenderer {

	public static void registerBlocks() {
		Block[] blocks = { ModBlocks.apple_sapling, ModBlocks.apricot_sapling, ModBlocks.banana_sapling,
				ModBlocks.cherry_sapling, ModBlocks.mango_sapling, ModBlocks.olive_sapling, ModBlocks.orange_sapling,
				ModBlocks.plum_sapling, ModBlocks.pear_sapling, ModBlocks.grape_block, ModBlocks.wild_crop,
				ModBlocks.chicory, ModBlocks.cumin, ModBlocks.marshmallow, ModBlocks.quinoa, ModBlocks.sunflower,
				ModBlocks.barley_crop, ModBlocks.broccoli_crop, ModBlocks.cactus_crop, ModBlocks.cantaloupe_crop,
				ModBlocks.carrot_crop, ModBlocks.cassava_crop, ModBlocks.corn_crop, ModBlocks.cotton_crop,
				ModBlocks.cucumber_crop, ModBlocks.eggplant_crop, ModBlocks.honeydew_crop, ModBlocks.ginger_crop,
				ModBlocks.kenaf_crop, ModBlocks.lettuce_crop, ModBlocks.oat_crop, ModBlocks.onion_crop,
				ModBlocks.peanut_crop, ModBlocks.pea_crop, ModBlocks.pepper_crop, ModBlocks.potato_crop,
				ModBlocks.radish_crop, ModBlocks.rice_crop, ModBlocks.rye_crop, ModBlocks.sorghum_crop,
				ModBlocks.soybean_crop, ModBlocks.spinach_crop, ModBlocks.squash_crop, ModBlocks.sweet_potato_crop,
				ModBlocks.tomato_crop, ModBlocks.turnip_crop, ModBlocks.yam_crop, ModBlocks.zucchini_crop };
		Block[] leaves = { ModBlocks.blackberry_bush, ModBlocks.blueberry_bush, ModBlocks.raspberry_bush,
				ModBlocks.strawberry_bush, ModBlocks.apple_leaves, ModBlocks.apricot_leaves, ModBlocks.banana_leaves,
				ModBlocks.cherry_leaves, ModBlocks.mango_leaves, ModBlocks.olive_leaves, ModBlocks.orange_leaves,
				ModBlocks.plum_leaves, ModBlocks.pear_leaves, ModBlocks.grape_leaves, ModBlocks.grape_leaves_base };
		for (Block block : blocks) {
			RenderTypeLookup.setRenderLayer(block, RenderType.func_228643_e_());
		}

		for (Block block : leaves) {
			RenderTypeLookup.setRenderLayer(block, RenderType.func_228641_d_());
		}
	}

}
