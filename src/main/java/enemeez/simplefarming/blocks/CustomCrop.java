package enemeez.simplefarming.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomCrop extends CropsBlock
{ 
	private Item seeds;
	private Item item;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	
	public CustomCrop(Block.Properties builder, Item seeds, Item item) 
	{
	   super(builder);
	   this.seeds = seeds;
	   this.item=item;
	   this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      return state.getBlock() instanceof FarmlandBlock;
	   }
	
	
	@OnlyIn(Dist.CLIENT)
	   protected IItemProvider getSeedsItem() 
	   {
			return seeds;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) 
	   {
		   return new ItemStack(item);
	   }
	


}