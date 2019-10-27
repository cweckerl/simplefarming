package enemeez.simplefarming.events.harvest;

import java.lang.reflect.Method;
import java.util.List;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.blocks.DoubleCrop;
import enemeez.simplefarming.config.RightClickConfig;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class CropHarvest {

	private static final Method seedDrops;

	static {
		seedDrops = ObfuscationReflectionHelper.findMethod(CropsBlock.class, "func_199772_f");
	}

	private Item getCropSeed(Block block) {
		try {
			return (Item) seedDrops.invoke(block);
		}

		catch (Exception e) {
			SimpleFarming.LOGGER.error("Error finding seed", e.getLocalizedMessage());
		}

		return null;
	}

	@SubscribeEvent
	public void onCropHarvest(RightClickBlock event) {
		if (event.getPlayer().getHeldItemMainhand().getItem() != Items.BONE_MEAL) {
			List<ItemStack> drops;
			if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof CropsBlock
					&& !(event.getWorld().getBlockState(event.getPos()).getBlock() instanceof DoubleCrop)) {
				if (!event.getPlayer().getHeldItemMainhand().isEmpty())
					event.setCanceled(true); // prevents blocks from being placed
				CropsBlock crop = (CropsBlock) event.getWorld().getBlockState(event.getPos()).getBlock();
				if (crop.isMaxAge(event.getWorld().getBlockState(event.getPos()))) {
					if (!event.getWorld().isRemote) {
						drops = Block.getDrops(event.getWorld().getBlockState(event.getPos()),
								(ServerWorld) event.getWorld(), event.getPos(),
								event.getWorld().getTileEntity(event.getPos()));
						for (int i = 0; i < drops.size(); i++) {
							if (drops.get(i).getItem() != getCropSeed(crop))
								event.getWorld()
										.addEntity(new ItemEntity((World) event.getWorld(), event.getPos().getX(),
												event.getPos().getY(), event.getPos().getZ(),
												(ItemStack) drops.get(i)));
						}
						for (int i = 0; i < drops.size(); i++) {
							if (drops.stream().distinct().limit(2).count() <= 1 || crop == Blocks.POTATOES
									|| crop == Blocks.CARROTS) {
								drops.remove(0);
								event.getWorld()
										.addEntity(new ItemEntity((World) event.getWorld(), event.getPos().getX(),
												event.getPos().getY(), event.getPos().getZ(),
												(ItemStack) drops.get(i)));
							}

						}
						event.getPlayer().addExhaustion(.05F);
						event.getWorld().playSound((PlayerEntity) null, event.getPos(), SoundEvents.BLOCK_CROP_BREAK,
								SoundCategory.BLOCKS, 1.0F, 0.8F + event.getWorld().rand.nextFloat() * 0.4F);
						event.getWorld().setBlockState(event.getPos(), crop.getDefaultState(), 2);

					}
					event.getPlayer().swingArm(Hand.MAIN_HAND);
				}
			}

			if (RightClickConfig.crop_right_click.get())
				if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof NetherWartBlock) {
					if (!event.getPlayer().getHeldItemMainhand().isEmpty())
						event.setCanceled(true);
					NetherWartBlock nether = (NetherWartBlock) event.getWorld().getBlockState(event.getPos())
							.getBlock();

					if (event.getWorld().getBlockState(event.getPos()).get(NetherWartBlock.AGE) == 3) {
						if (!event.getWorld().isRemote) {
							drops = Block.getDrops(event.getWorld().getBlockState(event.getPos()),
									(ServerWorld) event.getWorld(), event.getPos(),
									event.getWorld().getTileEntity(event.getPos()));
							for (int i = 0; i < drops.size(); i++) {
								event.getWorld()
										.addEntity(new ItemEntity((World) event.getWorld(), event.getPos().getX(),
												event.getPos().getY(), event.getPos().getZ(),
												(ItemStack) drops.get(i)));
							}
							event.getPlayer().addExhaustion(.05F);
							event.getWorld().playSound((PlayerEntity) null, event.getPos(),
									SoundEvents.BLOCK_NETHER_WART_BREAK, SoundCategory.BLOCKS, 1.0F,
									0.8F + event.getWorld().rand.nextFloat() * 0.4F);
							event.getWorld().setBlockState(event.getPos(), nether.getDefaultState(), 2);
						}
						event.getPlayer().swingArm(Hand.MAIN_HAND);
					}

				}
		}
	}

}
