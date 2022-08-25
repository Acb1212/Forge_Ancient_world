package net.Acb1212.AncWorld.block.entity;

import net.Acb1212.AncWorld.AncWorld;
import net.Acb1212.AncWorld.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AncWorld.MOD_ID);


    public static final RegistryObject<BlockEntityType<FossilExtractorBlockEntity>> FOSSIL_EXTRACTOR = BLOCK_ENTITIES.register("fossil_extractor", () -> BlockEntityType.Builder.of(FossilExtractorBlockEntity::new, ModBlocks.FOSSIL_EXTRACTOR.get()).build(null));




    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
