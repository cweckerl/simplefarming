package enemeez.simplefarming.block;

import enemeez.simplefarming.init.ModRecipes;
import enemeez.simplefarming.tileentity.BrewingBarrelTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BrewingBarrelBlock extends BaseEntityBlock {
	public static final IntegerProperty PROGRESS = IntegerProperty.create("progress", 0, 3);
	public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 0, 1);
	protected static final VoxelShape BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	protected static final VoxelShape SIDE1 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	protected static final VoxelShape SIDE2 = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	protected static final VoxelShape SIDE3 = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SIDE4 = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape SHAPE = Shapes.or(BOTTOM, SIDE1, SIDE2, SIDE3, SIDE4);
	protected static final VoxelShape CLOSED = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public BrewingBarrelBlock(Properties properties) {
		super(properties);
		registerDefaultState(stateDefinition.any().setValue(LAYERS, 0).setValue(PROGRESS, 0));
	}

	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return getProgress(state) > 0 ? CLOSED : SHAPE;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new BrewingBarrelTileEntity(pos, state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LAYERS, PROGRESS);
	}

	public int getProgress(BlockState state) {
		return state.getValue(PROGRESS);
	}

	public int getLayers(BlockState state) {
		return state.getValue(LAYERS);
	}

	private boolean readyToFerment(BlockState state) {
		return getLayers(state) == 1;
	}

	public void reset(BlockState state, Level worldIn, BlockPos pos) {
		worldIn.setBlockAndUpdate(pos, this.defaultBlockState().setValue(LAYERS, 0).setValue(PROGRESS, 0));
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		BlockEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof BrewingBarrelTileEntity) {
			if (player.isShiftKeyDown()) {
				if (getLayers(state) == 1 && getProgress(state) == 0) {
					dropItem(worldIn, pos);
					state = state.setValue(LAYERS, 0);
					worldIn.setBlockAndUpdate(pos, state);
					return InteractionResult.SUCCESS;
				}
			}
			if (isAlcoholIngredient(worldIn, player.getMainHandItem()) && ((BrewingBarrelTileEntity) tileentity).getCapacity() == 0) {
				this.insertItem(worldIn, pos, state, player.getMainHandItem().getItem());
				player.getMainHandItem().shrink(1);
				state = state.setValue(LAYERS, 1);
				worldIn.setBlockAndUpdate(pos, state);
				return InteractionResult.SUCCESS;
			}
			if (player.getMainHandItem().getItem() == Items.GLASS_BOTTLE && this.getProgress(state) == 3) {
				player.addItem(getProduct(worldIn, ((BrewingBarrelTileEntity) tileentity).getItem()));
				((BrewingBarrelTileEntity) tileentity).clearContent();
				worldIn.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
				player.getMainHandItem().shrink(1);
				this.reset(state, worldIn, pos);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;

	}

	public void insertItem(LevelAccessor worldIn, BlockPos pos, BlockState state, Item item) {
		BlockEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof BrewingBarrelTileEntity) {
			if (((BrewingBarrelTileEntity) tileentity).getCapacity() == 0) {
				((BrewingBarrelTileEntity) tileentity).setItem(item);
				worldIn.setBlock(pos, state.setValue(LAYERS, 1), 2);
			}
		}
	}

	private void dropItem(Level worldIn, BlockPos pos) {
		if (!worldIn.isClientSide) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof BrewingBarrelTileEntity) {
				BrewingBarrelTileEntity tile = (BrewingBarrelTileEntity) tileentity;
				Item item = tile.getItem();
				if (tile.getCapacity() > 0) {
					worldIn.levelEvent(LevelEvent.SOUND_PLAY_RECORDING, pos, 0);
					tile.clearContent();
					double d0 = worldIn.random.nextFloat() * 0.7F + 0.15F;
					double d1 = worldIn.random.nextFloat() * 0.7F + 0.060000002F + 0.6D;
					double d2 = worldIn.random.nextFloat() * 0.7F + 0.15F;
					ItemStack stack = new ItemStack(item);
					ItemEntity itementity = new ItemEntity(worldIn, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2, stack);
					itementity.setDefaultPickUpDelay();
					worldIn.addFreshEntity(itementity);
				}
			}
		}
	}

	@Override
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			dropItem(worldIn, pos);
			// super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}

	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
		if (this.readyToFerment(state)) {
			// super.tick(state, worldIn, pos, random);
			int i = state.getValue(PROGRESS);
			if (i < 3 && random.nextInt(5) == 0) {
				worldIn.setBlock(pos, defaultBlockState().setValue(LAYERS, 1).setValue(PROGRESS, i + 1), Block.UPDATE_ALL);
			}
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
		if (this.getProgress(stateIn) < 3 && this.getProgress(stateIn) > 0) {
			double d0 = (float) pos.getX() + Math.random();
			double d1 = (float) pos.getY() + Math.random();
			double d2 = (float) pos.getZ() + Math.random();
			worldIn.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, d0, d1 + 1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	public ItemStack getProduct(Level worldIn, Item itemIn) {
		return worldIn.getRecipeManager().getRecipeFor(ModRecipes.BREWING_BARREL_RECIPE_TYPE, new SimpleContainer(new ItemStack(itemIn)), worldIn).map(recipe -> recipe.assemble(null)).orElse(ItemStack.EMPTY);
	}

	public boolean isAlcoholIngredient(Level worldIn, ItemStack itemstackIn) {
		return worldIn.getRecipeManager().getRecipeFor(ModRecipes.BREWING_BARREL_RECIPE_TYPE, new SimpleContainer(itemstackIn), worldIn).isPresent();
	}

}