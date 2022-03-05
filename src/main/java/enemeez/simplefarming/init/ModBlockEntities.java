package enemeez.simplefarming.init;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.tileentity.BrewingBarrelTileEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, SimpleFarming.MOD_ID);

    public static RegistryObject<BlockEntityType<BrewingBarrelTileEntity>> BARREL_TILE = BLOCK_ENTITIES.register("brewing_barrel",
        () -> BlockEntityType.Builder.of(BrewingBarrelTileEntity::new, ModBlocks.BREWING_BARREL.get()).build(null));

    public static void registerBlockEntities() {
        BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}