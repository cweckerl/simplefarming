package enemeez.simplefarming.events;

import enemeez.simplefarming.blocks.BrewingBarrel;
import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BrewingEvent {
	private static final Item[] INGREDIENTS = { Items.WHEAT, ModItems.barley, Items.POTATO, ModItems.rice, Items.APPLE,
			ModItems.cactus_fruit, ModItems.cassava, ModItems.grapes };

	@SubscribeEvent
	public void interactEvent(RightClickBlock event) {
		if (!event.getWorld().isRemote) {
			if (event.getWorld().getBlockState(event.getPos()).getBlock() == ModBlocks.brewing_barrel) {
				World world = event.getWorld();
				BlockPos pos = event.getPos();
				BlockState state = event.getWorld().getBlockState(pos);
				Item item = event.getPlayer().getHeldItemMainhand().getItem();

				if (!event.getPlayer().isSneaking() && isAlcoholIngredient(item)
						&& BrewingBarrel.inventoryCapacity() < 3) {
					BrewingBarrel.addToInventory(item, state, world, pos);
					if (!event.getPlayer().isCreative())
						event.getPlayer().getHeldItemMainhand().shrink(1);
				}

				if (event.getPlayer().isSneaking() && BrewingBarrel.inventoryCapacity() > 0
						&& BrewingBarrel.getProgress(state) < 1) {
					event.getPlayer().addItemStackToInventory(
							new ItemStack(BrewingBarrel.removeFromInventory(state, world, pos)));
				}

				if (BrewingBarrel.getProgress(state) == 3) {
					if (item == Items.GLASS_BOTTLE) {
						world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
								new ItemStack(BrewingBarrel.getProduct(state, world, pos))));
						event.getPlayer().getHeldItemMainhand().shrink(1);
					}

				}

			}
		}
	}

	public static boolean isAlcoholIngredient(Item itemIn) {
		for (int i = 0; i < INGREDIENTS.length; i++) {
			if (itemIn == INGREDIENTS[i])
				return true;
		}
		return false;
	}

}
