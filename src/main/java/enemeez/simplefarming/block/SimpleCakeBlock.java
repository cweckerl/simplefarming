package enemeez.simplefarming.block;

import net.minecraft.block.Block;
import net.minecraft.block.CakeBlock;

public class SimpleCakeBlock extends CakeBlock {

	public SimpleCakeBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(BITES, 0));
	}
}
