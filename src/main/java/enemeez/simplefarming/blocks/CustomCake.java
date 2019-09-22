package enemeez.simplefarming.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.CakeBlock;

public class CustomCake extends CakeBlock {

	public CustomCake(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(BITES, Integer.valueOf(0)));
	}

}