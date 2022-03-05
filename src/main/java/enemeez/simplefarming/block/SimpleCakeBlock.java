package enemeez.simplefarming.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;

public class SimpleCakeBlock extends CakeBlock {

	public SimpleCakeBlock(Block.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
	}
}
