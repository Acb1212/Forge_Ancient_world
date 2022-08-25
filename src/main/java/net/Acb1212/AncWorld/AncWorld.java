package net.Acb1212.AncWorld;

import com.mojang.logging.LogUtils;
import net.Acb1212.AncWorld.block.ModBlocks;
import net.Acb1212.AncWorld.block.entity.ModBlockEntities;
import net.Acb1212.AncWorld.item.ModCreativeModeTab;
import net.Acb1212.AncWorld.item.ModItems;
import net.Acb1212.AncWorld.screen.FossilExtractorScreen;
import net.Acb1212.AncWorld.screen.ModMenuTypes;
import net.Acb1212.AncWorld.world.feature.ModConfiguredFeatures;
import net.Acb1212.AncWorld.world.feature.ModPlacedFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AncWorld.MOD_ID)
public class AncWorld
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ancworld";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AncWorld()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARP_WHEAT.get(), RenderType.cutout());

            MenuScreens.register(ModMenuTypes.FOSSIL_EXTRACTOR_MENU.get(), FossilExtractorScreen::new);

        }
    }
}
