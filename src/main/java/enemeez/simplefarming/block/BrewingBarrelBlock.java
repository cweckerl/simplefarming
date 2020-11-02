package enemeez.simplefarming.block;

import java.util.Random;

import enemeez.simplefarming.init.ModRecipes;
import enemeez.simplefarming.tileentity.BrewingBarrelTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;

public class BrewingBarrelBlock extends ContainerBlock {
	public static final IntegerProperty PROGRESS = IntegerProperty.create("progress", 0, 3);
	public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 0, 1);
	protected static final VoxelShape BOTTOM = Block.makeCuboidShape(16.0D, 1.0D, 16.0D, 0.0D, 0.0D, 0.0D);
	protected static final VoxelShape SIDE1 = Block.makeCuboidShape(16.0D, 16.0D, 1.0D, 0.0D, 0.0D, 0.0D);
	protected static final VoxelShape SIDE2 = Block.makeCuboidShape(1.0D, 16.0D, 16.0D, 0.0D, 0.0D, 0.0D);
	protected static final VoxelShape SIDE3 = Block.makeCuboidShape(16.0D, 16.0D, 15.0D, 0.0D, 0.0D, 16.0D);
	protected static final VoxelShape SIDE4 = Block.makeCuboidShape(15.0D, 16.0D, 16.0D, 16.0D, 0.0D, 0.0D);
	private static final VoxelShape SHAPE = VoxelShapes.or(BOTTOM, SIDE1, SIDE2, SIDE3, SIDE4);
	protected static final VoxelShape CLOSED = Block.makeCuboidShape(16.0D, 16.0D, 16.0D, 0.0D, 0.0D, 0.0D);

	public BrewingBarrelBlock(Properties properties) {
		super(properties);
		setDefaultState(stateContainer.getBaseState().with(LAYERS, 0).with(PROGRESS, 0));
	}

	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return getProgress(state) > 0 ? CLOSED : SHAPE;
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new BrewingBarrelTileEntity();
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LAYERS, PROGRESS);
	}

	public int getProgress(BlockState state) {
		return state.get(PROGRESS);
	}

	public int getLayers(BlockState state) {
		return state.get(LAYERS);
	}

	private boolean readyToFerment(BlockState state) {
		return getLayers(state) == 1;
	}

	public void reset(BlockState state, World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, this.getDefaultState().with(LAYERS, 0).with(PROGRESS, 0));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof BrewingBarrelTileEntity) {
			if (player.isSneaking()) {
				if (getLayers(state) == 1 && getProgress(state) == 0) {
					dropItem(worldIn, pos);
					state = state.with(LAYERS, 0);
					worldIn.setBlockState(pos, state);
					return ActionResultType.SUCCESS;
				}
			}
			if (isAlcoholIngredient(worldIn, player.getHeldItemMainhand()) && ((BrewingBarrelTileEntity) tileentity).getCapacity() == 0) {
				this.insertItem(worldIn, pos, state, player.getHeldItemMainhand().getItem());
				player.getHeldItemMainhand().shrink(1);
				state = state.with(LAYERS, 1);
				worldIn.setBlockState(pos, state);
				return ActionResultType.SUCCESS;
			}
			if (player.getHeldItemMainhand().getItem() == Items.GLASS_BOTTLE && this.getProgress(state) == 3) {
				player.addItemStackToInventory(getProduct(worldIn, ((BrewingBarrelTileEntity) tileentity).getItem()));
				((BrewingBarrelTileEntity) tileentity).clear();
				worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
				player.getHeldItemMainhand().shrink(1);
				this.reset(state, worldIn, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.PASS;

	}

	public void insertItem(IWorld worldIn, BlockPos pos, BlockState state, Item item) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof BrewingBarrelTileEntity) {
			if (((BrewingBarrelTileEntity) tileentity).getCapacity() == 0) {
				((BrewingBarrelTileEntity) tileentity).setItem(item);
				worldIn.setBlockState(pos, state.with(LAYERS, 1), 2);
			}
		}
	}

	private void dropItem(World worldIn, BlockPos pos) {
		if (!worldIn.isRemote) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof BrewingBarrelTileEntity) {
				BrewingBarrelTileEntity tile = (BrewingBarrelTileEntity) tileentity;
				Item item = tile.getItem();
				if (tile.getCapacity() > 0) {
					worldIn.playEvent(Constants.WorldEvents.PLAY_RECORD_SOUND, pos, 0);
					tile.clear();
					double d0 = worldIn.rand.nextFloat() * 0.7F + 0.15F;
					double d1 = worldIn.rand.nextFloat() * 0.7F + 0.060000002F + 0.6D;
					double d2 = worldIn.rand.nextFloat() * 0.7F + 0.15F;
					ItemStack stack = new ItemStack(item);
					ItemEntity itementity = new ItemEntity(worldIn, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2, stack);
					itementity.setDefaultPickupDelay();
					worldIn.addEntity(itementity);
				}
			}
		}
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			dropItem(worldIn, pos);
			// super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (this.readyToFerment(state)) {
			// super.tick(state, worldIn, pos, random);
			int i = state.get(PROGRESS);
			if (i < 3 && random.nextInt(5) == 0) {
				worldIn.setBlockState(pos, getDefaultState().with(LAYERS, 1).with(PROGRESS, i + 1), Constants.BlockFlags.BLOCK_UPDATE);
			}
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (this.getProgress(stateIn) < 3 && this.getProgress(stateIn) > 0) {
			double d0 = (float) pos.getX() + Math.random();
			double d1 = (float) pos.getY() + Math.random();
			double d2 = (float) pos.getZ() + Math.random();
			worldIn.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, d0, d1 + 1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	public ItemStack getProduct(World worldIn, Item itemIn) {
		return worldIn.getRecipeManager().getRecipe(ModRecipes.BREWING_BARREL_RECIPE_TYPE, new Inventory(new ItemStack(itemIn)), worldIn).map(recipe -> recipe.getCraftingResult(null)).orElse(ItemStack.EMPTY);
	}

	public boolean isAlcoholIngredient(World worldIn, ItemStack itemstackIn) {
		return worldIn.getRecipeManager().getRecipe(ModRecipes.BREWING_BARREL_RECIPE_TYPE, new Inventory(itemstackIn), worldIn).isPresent();
	}

}