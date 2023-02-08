package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.block.entity.FermenterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(
        ForgeRegistries.BLOCK_ENTITY_TYPES, SimpleFarming.MOD_ID
    );

    public static final RegistryObject<BlockEntityType<FermenterBlockEntity>> FERMENTER = BLOCK_ENTITY_TYPES.register("fermenter",
        () -> BlockEntityType.Builder.of(FermenterBlockEntity::new, ModBlocks.FERMENTER.get()).build(null)
    );
}
