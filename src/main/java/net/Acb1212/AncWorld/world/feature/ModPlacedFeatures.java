package net.Acb1212.AncWorld.world.feature;

import net.Acb1212.AncWorld.AncWorld;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, AncWorld.MOD_ID);

    public static final RegistryObject<PlacedFeature> AMBER_ORE_PLACED = PLACED_FEATURES.register("amber_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.AMBER_ORE.getHolder().get(),
                    commonOrePlacement(1, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(20)))));

    public static final RegistryObject<PlacedFeature> ENDSTONE_FOSSIL_ORE_PLACED = PLACED_FEATURES.register("endstone_fossil_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ENDSTONE_FOSSIL_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHERRACK_FOSSIL_ORE_PLACED = PLACED_FEATURES.register("netherrack_fossil_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHERRACK_FOSSIL_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));


    public static final RegistryObject<PlacedFeature> SANDSTONE_FOSSIL_ORE_PLACED = PLACED_FEATURES.register("sandstone_fossil_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SANDSTONE_FOSSIL_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(150)))));

    public static final RegistryObject<PlacedFeature> GRAVEL_FOSSIL_ORE_PLACED = PLACED_FEATURES.register("gravel_fossil_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GRAVEL_FOSSIL_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(25), VerticalAnchor.absolute(62)))));

    public static final RegistryObject<PlacedFeature> GLACIAL_FOSSIL_ORE_PLACED = PLACED_FEATURES.register("glacial_fossil_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GLACIAL_FOSSIL_ORE.getHolder().get(), commonOrePlacement(3, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(25), VerticalAnchor.absolute(255)))));






    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);

    }
}
