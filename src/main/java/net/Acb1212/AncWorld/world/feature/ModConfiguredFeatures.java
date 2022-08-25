package net.Acb1212.AncWorld.world.feature;

import com.google.common.base.Suppliers;
import net.Acb1212.AncWorld.AncWorld;
import net.Acb1212.AncWorld.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;


public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, AncWorld.MOD_ID);

    //What can the ore replace?
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_AMBER_ORES = Suppliers.memoize(() -> List.of(
       OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.AMBER_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_FOSSIL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_FOSSIL_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_FOSSIL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_FOSSIL_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SANDSTONE_FOSSIL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.SANDSTONE), ModBlocks.SANDSTONE_FOSSIL_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> GRAVEL_FOSSIL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.GRAVEL), ModBlocks.GRAVEL_FOSSIL_ORE.get().defaultBlockState())));


    public static final Supplier<List<OreConfiguration.TargetBlockState>> GLACIAL_FOSSIL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.PACKED_ICE), ModBlocks.GLACIAL_FOSSIL_ORE.get().defaultBlockState())));



    //Spawn Veins and Size of Veins
    public static final RegistryObject<ConfiguredFeature<?, ?>> AMBER_ORE = CONFIGURED_FEATURES.register("amber_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_AMBER_ORES.get(),1)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ENDSTONE_FOSSIL_ORE = CONFIGURED_FEATURES.register("endstone_fossil_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_FOSSIL_ORES.get(),8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHERRACK_FOSSIL_ORE = CONFIGURED_FEATURES.register("netherrack_fossil_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_FOSSIL_ORES.get(),7)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SANDSTONE_FOSSIL_ORE = CONFIGURED_FEATURES.register("sandstone_fossil_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SANDSTONE_FOSSIL_ORES.get(),14)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GRAVEL_FOSSIL_ORE = CONFIGURED_FEATURES.register("gravel_fossil_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GRAVEL_FOSSIL_ORES.get(),5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GLACIAL_FOSSIL_ORE = CONFIGURED_FEATURES.register("glacial_fossil_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GLACIAL_FOSSIL_ORES.get(),3)));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
