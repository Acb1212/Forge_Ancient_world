package net.Acb1212.AncWorld.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FOSSIL_TAB = new CreativeModeTab("fossils_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SANDSTONE_FOSSIL.get());
        }
    };

    public static final CreativeModeTab DNA_TAB = new CreativeModeTab("dna_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DNA_MODERN.get());
        }
    };

    public static final CreativeModeTab MISC_TAB = new CreativeModeTab("misc_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.NUTRIENT_SOUP.get());
        }
    };


}
