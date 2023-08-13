package dev.enemeez.simplefarming.common.data;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.enemeez.simplefarming.common.registries.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class GlobalLootModifier extends LootModifier {

    public static final Supplier<Codec<GlobalLootModifier>> CODEC = Suppliers.memoize(
        () -> RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst).apply(inst, GlobalLootModifier::new))
    );

    protected GlobalLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        var index = context.getRandom().nextInt(ModItems.SEEDS.size());
        generatedLoot.add(new ItemStack(ModItems.SEEDS.get(index).get()));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
