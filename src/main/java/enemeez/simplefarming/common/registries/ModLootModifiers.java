package enemeez.simplefarming.common.registries;

import com.mojang.serialization.Codec;
import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.data.GlobalLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(
        ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, SimpleFarming.MOD_ID
    );

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> SEED_DROPS = GLOBAL_LOOT_MODIFIERS.register(
        "seed_drops", GlobalLootModifier.CODEC
    );
}
