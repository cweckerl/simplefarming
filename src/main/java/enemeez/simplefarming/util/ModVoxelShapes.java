package enemeez.simplefarming.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModVoxelShapes {
	public static final VoxelShape CROP_SHAPE_0 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	public static final VoxelShape CROP_SHAPE_2 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
	public static final VoxelShape CROP_SHAPE_4 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
	public static final VoxelShape CROP_SHAPE_6 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

	public static final VoxelShape[] SMALL_CROP_SHAPES_0_7 = new VoxelShape[] { CROP_SHAPE_0,
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), CROP_SHAPE_2,
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), CROP_SHAPE_4,
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), CROP_SHAPE_6,
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D) };

	public static final VoxelShape[] SMALL_CROP_SHAPES_0_3 = new VoxelShape[] { CROP_SHAPE_0, CROP_SHAPE_2,
			CROP_SHAPE_4, CROP_SHAPE_6 };

	public static final VoxelShape GOURD_SHAPE_1 = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 3.0D, 10.0D);
	public static final VoxelShape GOURD_SHAPE_2 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);
	public static final VoxelShape[] GOURD_SHAPES_0_7 = new VoxelShape[] { CROP_SHAPE_0, GOURD_SHAPE_1, GOURD_SHAPE_1,
			GOURD_SHAPE_1, GOURD_SHAPE_2, GOURD_SHAPE_2, GOURD_SHAPE_2,
			Block.box(2.0D, 0.0D, 2.0D, 14.0D, 11.0D, 14.0D) };
}
