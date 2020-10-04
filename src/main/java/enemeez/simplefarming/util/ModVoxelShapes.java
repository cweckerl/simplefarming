package enemeez.simplefarming.util;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.VoxelShape;

public class ModVoxelShapes {
	public static final VoxelShape CROP_SHAPE_0 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	public static final VoxelShape CROP_SHAPE_2 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
	public static final VoxelShape CROP_SHAPE_4 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
	public static final VoxelShape CROP_SHAPE_6 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

	public static final VoxelShape[] SMALL_CROP_SHAPES_0_7 = new VoxelShape[] { CROP_SHAPE_0,
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), CROP_SHAPE_2,
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), CROP_SHAPE_4,
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), CROP_SHAPE_6,
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D) };

	public static final VoxelShape[] SMALL_CROP_SHAPES_0_3 = new VoxelShape[] { CROP_SHAPE_0, CROP_SHAPE_2,
			CROP_SHAPE_4, CROP_SHAPE_6 };

	public static final VoxelShape GOURD_SHAPE_1 = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 3.0D, 10.0D);
	public static final VoxelShape GOURD_SHAPE_2 = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);
	public static final VoxelShape[] GOURD_SHAPES_0_7 = new VoxelShape[] { CROP_SHAPE_0, GOURD_SHAPE_1, GOURD_SHAPE_1,
			GOURD_SHAPE_1, GOURD_SHAPE_2, GOURD_SHAPE_2, GOURD_SHAPE_2,
			Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 11.0D, 14.0D) };
}
