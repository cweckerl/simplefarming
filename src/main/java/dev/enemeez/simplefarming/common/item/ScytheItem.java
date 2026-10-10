package dev.enemeez.simplefarming.common.item;

import dev.enemeez.simplefarming.common.registries.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ScytheItem extends Item {

    public ScytheItem(ToolMaterial pMaterial, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        // DiggerItem is gone since 1.21.5; tools are plain items with a tool component
        super(pProperties.tool(pMaterial, ModTags.MINEABLE_WITH_SCYTHE, pAttackDamageModifier, pAttackSpeedModifier, 0.0F));
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (pLevel.isClientSide()) {
            return false;
        }

        pStack.hurtAndBreak(1, pEntityLiving, EquipmentSlot.MAINHAND);
        final BlockState STATE = pLevel.getBlockState(pPos);
        if (!pStack.isCorrectToolForDrops(STATE)) {
            return false;
        }

        BlockPos.betweenClosedStream(pPos.offset(new Vec3i(-1, 0, -1)), pPos.offset(new Vec3i(1, 0, 1)))
            .filter(tmpPos -> !tmpPos.equals(pPos))
            .forEach(tmpPos -> {
                if (pLevel.getBlockState(tmpPos) == STATE) {
                    Block.dropResources(pLevel.getBlockState(tmpPos), pLevel, tmpPos);
                    pLevel.destroyBlock(tmpPos, false, pEntityLiving);
                    pStack.hurtAndBreak(1, pEntityLiving, EquipmentSlot.MAINHAND);
                }
            });

        return true;
    }
}
