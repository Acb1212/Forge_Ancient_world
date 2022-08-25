package net.Acb1212.AncWorld.block;

import net.Acb1212.AncWorld.AncWorld;
import net.Acb1212.AncWorld.block.custom.DNACultivatorBlock;
import net.Acb1212.AncWorld.block.custom.FossilExtractorBlock;
import net.Acb1212.AncWorld.block.custom.TarBlock;
import net.Acb1212.AncWorld.block.custom.WarpWheatCropBlock;
import net.Acb1212.AncWorld.item.ModCreativeModeTab;
import net.Acb1212.AncWorld.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AncWorld.MOD_ID);
    //Fossil Ores
    public static final RegistryObject<Block> SANDSTONE_FOSSIL_ORE = registerBlock("sandstone_fossil_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(0.8f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.FOSSIL_TAB);
    public static final RegistryObject<Block> AMBER_ORE = registerBlock("amber_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5f), UniformInt.of(3,7)), ModCreativeModeTab.FOSSIL_TAB);
    public static final RegistryObject<Block> ENDSTONE_FOSSIL_ORE = registerBlock("endstone_fossil_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).strength(1.5f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.FOSSIL_TAB);
    public static final RegistryObject<Block> NETHERRACK_FOSSIL_ORE = registerBlock("netherrack_fossil_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(1.5f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.FOSSIL_TAB);
    public static final RegistryObject<Block> GRAVEL_FOSSIL_ORE = registerBlock("gravel_fossil_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).strength(1.5f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.FOSSIL_TAB);
    public static final RegistryObject<Block> GLACIAL_FOSSIL_ORE = registerBlock("glacial_fossil_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).strength(1.5f).requiresCorrectToolForDrops(),UniformInt.of(3,7)), ModCreativeModeTab.FOSSIL_TAB);


    //Misc Blocks
    public static final RegistryObject<Block> AMBER_BLOCK = registerBlock("amber_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops()), ModCreativeModeTab.MISC_TAB);
    public static final RegistryObject<Block> TAR_BLOCK = registerBlock("tar_block", () -> new TarBlock(BlockBehaviour.Properties.copy(Blocks.MUD).requiresCorrectToolForDrops()), ModCreativeModeTab.MISC_TAB);

    //Decoration
    public static final RegistryObject<Block> POLISHED_DIORITE_BRICKS = registerBlock("polished_diorite_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5f)), ModCreativeModeTab.MISC_TAB);

    //Crafting Stations
    public static final RegistryObject<Block> FOSSIL_EXTRACTOR = registerBlock("fossil_extractor", () -> new FossilExtractorBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1.5f)),ModCreativeModeTab.MISC_TAB);
    public static final RegistryObject<Block> DNA_CULTIVATOR = registerBlock("dna_cultivator", () -> new DNACultivatorBlock(BlockBehaviour.Properties.of(Material.GLASS).requiresCorrectToolForDrops().strength(1.5f)),ModCreativeModeTab.MISC_TAB);

    //Plants
    public static final RegistryObject<Block> WARP_WHEAT = BLOCKS.register("warp_wheat", () -> new WarpWheatCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).strength(0f).requiresCorrectToolForDrops()));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
