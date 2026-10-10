package dev.enemeez.simplefarming.common.registries;

import com.mojang.serialization.MapCodec;
import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.data.GlobalLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(
        ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, SimpleFarming.MOD_ID
    );

    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> SEED_DROPS = GLOBAL_LOOT_MODIFIERS.register(
        "seed_drops", GlobalLootModifier.CODEC
    );
}
