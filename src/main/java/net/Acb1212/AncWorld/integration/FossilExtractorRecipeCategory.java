package net.Acb1212.AncWorld.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.Acb1212.AncWorld.AncWorld;
import net.Acb1212.AncWorld.block.ModBlocks;
import net.Acb1212.AncWorld.item.ModItems;
import net.Acb1212.AncWorld.recipe.FossilExtractorRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

public class FossilExtractorRecipeCategory implements IRecipeCategory<FossilExtractorRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(AncWorld.MOD_ID,"fossil_extracting");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(AncWorld.MOD_ID, "textures/gui/fossil_extractor_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public FossilExtractorRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FOSSIL_EXTRACTOR.get()));
    }



    @Override
    public RecipeType<FossilExtractorRecipe> getRecipeType() {
        return JEIAncientWorldPlugin.EXTRACTOR_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Fossil Extractor");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FossilExtractorRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 49, 34).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 19, 21).addItemStack(new ItemStack(ModItems.FOSSIL_BRUSH.get()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 109, 34).addItemStack(recipe.getResultItem());
    }
}
