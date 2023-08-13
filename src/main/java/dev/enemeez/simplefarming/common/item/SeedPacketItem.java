package dev.enemeez.simplefarming.common.item;

import dev.enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.Set;
import java.util.function.Supplier;

public class SeedPacketItem extends Item {
    public enum Type {
        FIBER,
        FRUIT,
        GOURD,
        GRAIN,
        LEAFY,
        LEGUME,
        ROOT,
        TUBER
    }
    private static final Set<Supplier<Item>> FIBER_SEEDS = Set.of(ModItems.COTTON_SEEDS, ModItems.KENAF_SEEDS);
    private static final Set<Supplier<Item>> FRUIT_SEEDS = Set.of(
        ModItems.GRAPE_SEEDS,
        ModItems.TOMATO_SEEDS,
        ModItems.CUCUMBER_SEEDS,
        ModItems.EGGPLANT_SEEDS,
        ModItems.ZUCCHINI_SEEDS,
        ModItems.PEPPER_SEEDS
    );
    private static final Set<Supplier<Item>> GOURD_SEEDS = Set.of(
        () -> Items.MELON_SEEDS,
        () -> Items.PUMPKIN_SEEDS,
        ModItems.CANTALOUPE_SEEDS,
        ModItems.HONEYDEW_SEEDS,
        ModItems.SQUASH_SEEDS
    );
    private static final Set<Supplier<Item>> GRAIN_SEEDS = Set.of(
        () -> Items.WHEAT_SEEDS,
        ModItems.BARLEY_SEEDS,
        ModItems.OAT_SEEDS,
        ModItems.RYE_SEEDS,
        ModItems.RICE_SEEDS,
        ModItems.CORN_SEEDS,
        ModItems.SORGHUM_SEEDS
    );
    private static final Set<Supplier<Item>> LEAFY_SEEDS = Set.of(
        ModItems.BROCCOLI_SEEDS,
        ModItems.LETTUCE_SEEDS,
        ModItems.SPINACH_SEEDS
    );
    private static final Set<Supplier<Item>> LEGUME_SEEDS = Set.of(
        ModItems.SOYBEAN_SEEDS,
        ModItems.PEA_SEEDS,
        ModItems.PEANUT_SEEDS
    );
    private static final Set<Supplier<Item>> ROOT_SEEDS = Set.of(
        () -> Items.BEETROOT_SEEDS,
        ModItems.RADISH_SEEDS,
        ModItems.TURNIP_SEEDS,
        ModItems.ONION_SEEDS,
        ModItems.GINGER_SEEDS
    );
    private static final Set<Supplier<Item>> TUBER_SEEDS = Set.of(
        ModItems.YAM_SEEDS,
        ModItems.SWEET_POTATO_SEEDS,
        ModItems.CASSAVA_SEEDS
    );
    private final Type TYPE;

    public SeedPacketItem(Properties pProperties, Type type) {
        super(pProperties);
        this.TYPE = type;
    }

    private Item getRandomSeed(RandomSource rand, Set<Supplier<Item>> seeds) {
        return seeds.stream().skip(rand.nextInt(seeds.size())).findFirst().get().get();
    }

    private Set<Supplier<Item>> getContents() {
        return switch (this.TYPE) {
            case FIBER -> FIBER_SEEDS;
            case FRUIT -> FRUIT_SEEDS;
            case GOURD -> GOURD_SEEDS;
            case GRAIN -> GRAIN_SEEDS;
            case LEAFY -> LEAFY_SEEDS;
            case LEGUME -> LEGUME_SEEDS;
            case ROOT -> ROOT_SEEDS;
            case TUBER -> TUBER_SEEDS;
        };
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if (!pLevel.isClientSide) {
            final var packet = getContents();
            final var amount = pLevel.random.nextInt(2,4);
            for (int i = 0; i < amount; i++) {
                final ItemStack seed = new ItemStack(getRandomSeed(pLevel.random, packet));
                if (!pPlayer.getInventory().add(seed)) {
                    pPlayer.drop(seed, false);
                }
            }
        }

        if (!pPlayer.getAbilities().instabuild) {
            pPlayer.getItemInHand(pHand).shrink(1);
        }

        pLevel.playSound(
            null,
            pPlayer.getX(),
            pPlayer.getY(),
            pPlayer.getZ(),
            SoundEvents.CHICKEN_EGG,
            SoundSource.NEUTRAL,
            0.5F,
            0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F)
        );
        return super.use(pLevel, pPlayer, pHand);
    }
}
