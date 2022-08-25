package net.Acb1212.AncWorld.block.entity;

import net.Acb1212.AncWorld.item.ModItems;
import net.Acb1212.AncWorld.screen.FossilExtractorMenu;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static java.lang.System.exit;


public class FossilExtractorBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<ItemStackHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 780;


    public FossilExtractorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.FOSSIL_EXTRACTOR.get(), pos, blockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> FossilExtractorBlockEntity.this.progress;
                    case 1 -> FossilExtractorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> FossilExtractorBlockEntity.this.progress = value;
                    case 1 -> FossilExtractorBlockEntity.this.maxProgress = value;

                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Fossil Extraction Table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new FossilExtractorMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
       if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
           return lazyItemHandler.cast();

       }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i=0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(1,itemHandler.getStackInSlot(1));

        }
        Containers.dropContents(this.level,this.worldPosition, inventory);

    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, FossilExtractorBlockEntity entity) {
        if(level.isClientSide()) {
            return;
        }

        if(hasRecipe(entity)) {
            entity.progress++;
            setChanged(level,blockPos,blockState);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }

            
        }else {
            entity.resetProgress();
            setChanged(level,blockPos,blockState);

        }

    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(FossilExtractorBlockEntity entity) {
        exit(0);
            if(hasRecipe(entity)) {
                entity.itemHandler.extractItem(1,1,false);
                entity.itemHandler.setStackInSlot(2,new ItemStack(ModItems.SANDSTONE_FOSSIL.get(),entity.itemHandler.getStackInSlot(2).getCount()+1));

                entity.resetProgress();
            }

    }


    private static boolean hasRecipe(FossilExtractorBlockEntity entity) {
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int i = 0; i< entity.itemHandler.getSlots(); i++) {
        inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        boolean hasToolInZeroSlot = entity.itemHandler.getStackInSlot(0).getItem() == ModItems.FOSSIL_BRUSH.get();
        boolean hasFossilInFirstSlot = entity.itemHandler.getStackInSlot(1).getItem()==ModItems.SANDSTONE_RAW_FOSSIL.get();


        return hasFossilInFirstSlot && hasToolInZeroSlot && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, new ItemStack(ModItems.SANDSTONE_FOSSIL.get(),1));


    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack itemStack) {
        return inventory.getItem(2).getItem() == itemStack.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
