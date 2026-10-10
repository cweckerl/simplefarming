package dev.enemeez.simplefarming.common.registries;

import dev.enemeez.simplefarming.common.SimpleFarming;
import dev.enemeez.simplefarming.common.block.menu.FermenterMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModMenus {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(
        Registries.MENU, SimpleFarming.MOD_ID
    );

    public static DeferredHolder<MenuType<?>, MenuType<FermenterMenu>> FERMENTER_MENU = MENU_TYPES.register("fermenter_menu",
        () -> IMenuTypeExtension.create(FermenterMenu::new)
    );
}
