package enemeez.simplefarming.block.growable;

import java.util.Random;

import enemeez.simplefarming.init.ModBlocks;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FruitLeavesBlock extends BushBlock implements IGrowable {
	private String name;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;

	public FruitLeavesBlock(Block.Properties p_i49971_1_, String name) {
		super(p_i49971_1_);
		this.name = name;
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		switch (name) {
		case "apple":
			return new ItemStack(Items.APPLE);
		case "apricot":
			return new ItemStack(ModItems.apricot);
		case "banana":
			return new ItemStack(ModItems.banana);
		case "cherries":
			return new ItemStack(ModItems.cherries);
		case "orange":
			return new ItemStack(ModItems.orange);
		case "mango":
			return new ItemStack(ModItems.mango);
		case "pear":
			return new ItemStack(ModItems.pear);
		case "plum":
			return new ItemStack(ModItems.plum);
		default:
			return new ItemStack(ModItems.olives);
		}
	}

	public ItemStack getSapling(IBlockReader worldIn, BlockPos pos, BlockState state) {
		switch (name) {
		case "apple":
			return new ItemStack(ModItems.apple_sapling);
		case "apricot":
			return new ItemStack(ModItems.apricot_sapling);
		case "banana":
			return new ItemStack(ModItems.banana_sapling);
		case "cherries":
			return new ItemStack(ModItems.cherry_sapling);
		case "orange":
			return new ItemStack(ModItems.orange_sapling);
		case "mango":
			return new ItemStack(ModItems.mango_sapling);
		case "pear":
			return new ItemStack(ModItems.pear_sapling);
		case "plum":
			return new ItemStack(ModItems.plum_sapling);
		default:
			return new ItemStack(ModItems.olive_sapling);
		}
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void func_225534_a_(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		super.func_225534_a_(state, worldIn, pos, random);
		int i = state.get(AGE);
		if (i < 7 && random.nextInt(5) == 0 && worldIn.func_226659_b_(pos.up(), 0) >= 9) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
		}
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(AGE) < 7;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void func_225535_a_(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(7, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (worldIn.isRainingAt(pos.up())) {
			if (rand.nextInt(15) == 1) {
				BlockPos blockpos = pos.down();
				BlockState blockstate = worldIn.getBlockState(blockpos);
				if (!blockstate.isSolid() || !Block.hasSolidSide(blockstate, worldIn, blockpos, Direction.UP)) {
					double d0 = (double) ((float) pos.getX() + rand.nextFloat());
					double d1 = (double) pos.getY() - 0.05D;
					double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
					worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	@Override
	public boolean func_229869_c_(BlockState p_229869_1_, IBlockReader p_229869_2_, BlockPos p_229869_3_) {
		return false;
	}

	public boolean isMaxAge(BlockState state) {
		return state.get(AGE) == 7;
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX) {
			entityIn.setMotionMultiplier(state, new Vec3d((double) 0.8F, 0.75D, (double) 0.8F));
		}
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		BlockPos down = pos.down();
		BlockPos up = pos.up();
		BlockPos north = pos.north();
		BlockPos south = pos.south();
		BlockPos east = pos.east();
		BlockPos west = pos.west();

		BlockPos southeast = pos.south().east();
		BlockPos southwest = pos.south().west();

		BlockPos northeast = pos.north().east();
		BlockPos northwest = pos.north().west();
		if (world.getBlockState(down).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(up).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(north).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(south).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(east).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(west).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(southeast).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(southwest).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(northeast).equals(ModBlocks.fruit_log.getDefaultState())
				|| world.getBlockState(northwest).equals(ModBlocks.fruit_log.getDefaultState()))
			return true;
		return false;
	}
}