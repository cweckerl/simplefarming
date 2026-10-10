package dev.enemeez.simplefarming.common.registries;

import dev.enemeez.simplefarming.common.block.entity.FermenterBlockEntity;
import dev.enemeez.simplefarming.common.SimpleFarming;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(
        Registries.BLOCK_ENTITY_TYPE, SimpleFarming.MOD_ID
    );

    public static final RegistryObject<BlockEntityType<FermenterBlockEntity>> FERMENTER = BLOCK_ENTITY_TYPES.register("fermenter",
        () -> new BlockEntityType<>(FermenterBlockEntity::new, Set.of(ModBlocks.FERMENTER.get()))
    );
}
