package enemeez.simplefarming.events.harvest.standard;

import java.util.List;

import enemeez.simplefarming.blocks.growable.FruitLeavesBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FruitLeavesHarvest {

	@SubscribeEvent
	public void onCropHarvest(RightClickBlock event) {
		if (event.getPlayer().getHeldItemMainhand().getItem() != Items.BONE_MEAL) {
			List<ItemStack> drops;
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof FruitLeavesBlock) {
				FruitLeavesBlock leaf = (FruitLeavesBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
				if (leaf.isMaxAge(event.getWorld().getBlockState(event.getPos()))) {
					if (!event.getPlayer().getHeldItemMainhand().isEmpty())
						event.setCanceled(true);
					if (!event.getWorld().isRemote) {
						drops = Block.getDrops(event.getWorld().getBlockState(event.getPos()),
								(ServerWorld) event.getWorld(), event.getPos(),
								event.getWorld().getTileEntity(event.getPos()));
						for (int i = 0; i < drops.size(); i++) {
							if (drops.get(i).getItem() != leaf.getSapling(event.getWorld(), event.getPos(),
									event.getWorld().getBlockState(event.getPos())).getItem())
								event.getWorld()
										.addEntity(new ItemEntity((World) event.getWorld(),
												event.getPlayer().getPosition().getX(), event.getPos().getY(),
												event.getPlayer().getPosition().getZ(), (ItemStack) drops.get(i)));
						}
						event.getPlayer().addExhaustion(.05F);
						event.getWorld().playSound((PlayerEntity) null, event.getPos(),
								SoundEvents.BLOCK_NETHER_WART_BREAK, SoundCategory.BLOCKS, 1.0F,
								0.8F + event.getWorld().rand.nextFloat() * 0.4F);
						event.getWorld().setBlockState(event.getPos(), leaf.getDefaultState(), 2);
					}
					event.getPlayer().swingArm(Hand.MAIN_HAND);
				}
			}
		}
	}
}
