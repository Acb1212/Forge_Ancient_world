package net.Acb1212.AncWorld.item;

import net.Acb1212.AncWorld.AncWorld;
import net.Acb1212.AncWorld.block.ModBlocks;
import net.Acb1212.AncWorld.item.custom.DNAItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AncWorld.MOD_ID);


    //Fossil Items
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> SANDSTONE_RAW_FOSSIL = ITEMS.register("sandstone_raw_fossil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> SANDSTONE_FOSSIL = ITEMS.register("sandstone_fossil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> ENDSTONE_RAW_FOSSIL = ITEMS.register("endstone_raw_fossil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> ENDSTONE_FOSSIL = ITEMS.register("endstone_fossil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> NETHERRACK_RAW_FOSSIL = ITEMS.register("netherrack_raw_fossil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> NETHERRACK_FOSSIL = ITEMS.register("netherrack_fossil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> GLACIAL_RAW_FOSSIL = ITEMS.register("glacial_raw_fossil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> GLACIAL_FOSSIL = ITEMS.register("glacial_fossil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOSSIL_TAB)));
    public static final RegistryObject<Item> FOSSIL_BRUSH = ITEMS.register("fossil_brush", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MISC_TAB).durability(255).stacksTo(1)));



    //Misc Items
    public static final RegistryObject<Item> NUTRIENT_SOUP = ITEMS.register("nutrient_soup", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MISC_TAB)));


    //DNA ITEMS
    public static final RegistryObject<Item> DNA_MODERN = ITEMS.register("dna_modern", () -> new DNAItem(new Item.Properties().tab(ModCreativeModeTab.DNA_TAB)));
    public static final RegistryObject<Item> DNA_ICEAGE = ITEMS.register("dna_iceage", () -> new DNAItem(new Item.Properties().tab(ModCreativeModeTab.DNA_TAB)));
    public static final RegistryObject<Item> DNA_JURASSIC = ITEMS.register("dna_jurassic", () -> new DNAItem(new Item.Properties().tab(ModCreativeModeTab.DNA_TAB)));
    public static final RegistryObject<Item> DNA_CRETACEOUS = ITEMS.register("dna_cretaceous", () -> new DNAItem(new Item.Properties().tab(ModCreativeModeTab.DNA_TAB)));
    public static final RegistryObject<Item> DNA_TRIASSIC = ITEMS.register("dna_triassic", () -> new DNAItem(new Item.Properties().tab(ModCreativeModeTab.DNA_TAB)));
    public static final RegistryObject<Item> DNA_PALEOLITHIC = ITEMS.register("dna_paleolithic", () -> new DNAItem(new Item.Properties().tab(ModCreativeModeTab.DNA_TAB)));
    public static final RegistryObject<Item> DNA_NETHER = ITEMS.register("dna_nether", () -> new DNAItem(new Item.Properties().tab(ModCreativeModeTab.DNA_TAB)));
    public static final RegistryObject<Item> DNA_ENDER = ITEMS.register("dna_ender", () -> new DNAItem(new Item.Properties().tab(ModCreativeModeTab.DNA_TAB)));

    //Farming Items
    public static final RegistryObject<Item> WARP_WHEAT_SEEDS = ITEMS.register("warp_wheat_seeds", () -> new ItemNameBlockItem(ModBlocks.WARP_WHEAT.get(), new Item.Properties().tab(ModCreativeModeTab.MISC_TAB)));
    public static final RegistryObject<Item> WARP_WHEAT = ITEMS.register("warp_wheat", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MISC_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
