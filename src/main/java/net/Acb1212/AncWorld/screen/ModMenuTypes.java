package net.Acb1212.AncWorld.screen;

import net.Acb1212.AncWorld.AncWorld;
import net.minecraft.world.inventory.*;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//NA

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AncWorld.MOD_ID);

    public static final RegistryObject<MenuType<FossilExtractorMenu>> FOSSIL_EXTRACTOR_MENU =
            registerMenuType(FossilExtractorMenu::new, "fossil_extractor_menu");



    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {

        MENUS.register(eventBus);
    }

}