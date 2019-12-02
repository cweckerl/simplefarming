package enemeez.simplefarming.blocks;

import java.util.ArrayList;
import java.util.Random;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BrewingBarrel extends Block {
	private static final IntegerProperty PROGRESS = IntegerProperty.create("progress", 0, 3);
	private static final IntegerProperty LAYERS = IntegerProperty.create("layers", 0, 3);
	private static ArrayList<Item> inventory = new ArrayList<Item>();

	public BrewingBarrel(Properties properties) {
		super(properties);
		this.setDefaultState(
				this.stateContainer.getBaseState().with(LAYERS, Integer.valueOf(0)).with(PROGRESS, Integer.valueOf(0)));
	}

	public static void addToInventory(Item itemIn, BlockState state, World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, state.with(LAYERS, Integer.valueOf(inventoryCapacity() + 1)));
		inventory.add(itemIn);
	}

	public static Item removeFromInventory(BlockState state, World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, state.with(LAYERS, Integer.valueOf(inventoryCapacity() - 1)));
		return inventory.remove(inventoryCapacity() - 1);
	}

	public static int inventoryCapacity() {
		return inventory.size();
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LAYERS, PROGRESS);
	}

	private static boolean readyToFerment() {
		if (inventoryCapacity() == 3) {
			for (int i = 0; i < inventory.size() - 2; i++) {
				if (inventory.get(i) == inventory.get(i + 1) && inventory.get(i + 1) == inventory.get(i + 2)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		if (readyToFerment()) {
			super.tick(state, worldIn, pos, random);
			int i = state.get(PROGRESS);
			if (i < 3 && random.nextInt(5) == 0) {
				worldIn.setBlockState(pos, state.with(PROGRESS, Integer.valueOf(i + 1)), 2);
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (getProgress(stateIn) > 0) {
			double d0 = (double) ((float) pos.getX() + (Double)Math.random());
			double d1 = (double) ((float) pos.getY() + (Double)Math.random());
			double d2 = (double) ((float) pos.getZ() + (Double)Math.random());
			worldIn.addParticle(ParticleTypes.SPIT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	public static int getProgress(BlockState state) {
		return state.get(PROGRESS);
	}

	public static Item getProduct(BlockState state, World worldIn, BlockPos pos) {
		if (readyToFerment()) {
			Item raw = removeFromInventory(state, worldIn, pos);
			if (raw == Items.WHEAT)
				return ModItems.whiskey;
			if (raw == Items.POTATO)
				return ModItems.vodka;
			if (raw == Items.APPLE)
				return ModItems.cider;
			if (raw == ModItems.barley)
				return ModItems.beer;
			if (raw == ModItems.grapes)
				return ModItems.wine;
			if (raw == ModItems.cassava)
				return ModItems.cauim;
			if (raw == ModItems.rice)
				return ModItems.sake;
			else
				return ModItems.tiswin;
		}
		return Items.AIR;

	}

}
