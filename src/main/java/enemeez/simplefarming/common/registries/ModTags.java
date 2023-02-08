package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final TagKey<Block> MINEABLE_WITH_SCYTHE = BlockTags.create(new ResourceLocation(
        SimpleFarming.MOD_ID, "mineable/scythe"
    ));
    public static final TagKey<Block> TRELLIS_BLACKLIST = BlockTags.create(new ResourceLocation(
        SimpleFarming.MOD_ID, "trellis_blacklist"
    ));
    public static final TagKey<Item> FERMENTABLE = ItemTags.create(new ResourceLocation(
        SimpleFarming.MOD_ID, "fermentable"
    ));
}
