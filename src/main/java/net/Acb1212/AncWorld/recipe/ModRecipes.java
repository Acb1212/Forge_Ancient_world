package net.Acb1212.AncWorld.recipe;

import net.Acb1212.AncWorld.AncWorld;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AncWorld.MOD_ID);


    public static final RegistryObject<RecipeSerializer<FossilExtractorRecipe>> FOSSIL_EXTRACTOR_SERIALIZER = SERIALIZERS.register("fossil_extracting",() -> FossilExtractorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);

    }
}
