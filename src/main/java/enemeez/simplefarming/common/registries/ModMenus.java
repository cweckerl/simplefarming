package enemeez.simplefarming.common.registries;

import enemeez.simplefarming.common.SimpleFarming;
import enemeez.simplefarming.common.block.menu.FermenterMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(
        ForgeRegistries.MENU_TYPES, SimpleFarming.MOD_ID
    );

    public static RegistryObject<MenuType<FermenterMenu>> FERMENTER_MENU = MENU_TYPES.register("fermenter_menu",
        () -> IForgeMenuType.create(FermenterMenu::new)
    );
}
