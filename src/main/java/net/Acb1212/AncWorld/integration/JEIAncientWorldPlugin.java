package net.Acb1212.AncWorld.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import net.Acb1212.AncWorld.AncWorld;
import net.Acb1212.AncWorld.recipe.FossilExtractorRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;
@JeiPlugin
public class JEIAncientWorldPlugin implements IModPlugin {
    public static RecipeType<FossilExtractorRecipe> EXTRACTOR_TYPE =
            new RecipeType<>(FossilExtractorRecipeCategory.UID, FossilExtractorRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(AncWorld.MOD_ID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
        FossilExtractorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {


        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<FossilExtractorRecipe> recipesExtracting = rm.getAllRecipesFor(FossilExtractorRecipe.Type.INSTANCE);
        registration.addRecipes(EXTRACTOR_TYPE, recipesExtracting);
    }
}
