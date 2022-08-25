package net.Acb1212.AncWorld.block.custom;

import net.Acb1212.AncWorld.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WarpWheatCropBlock extends CropBlock {
public static final IntegerProperty AGE = IntegerProperty.create("age",0,7);

    public WarpWheatCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId()
    {
        return ModItems.WARP_WHEAT_SEEDS.get();

    }

    @Override
    protected int getAge(BlockState state) {
        return super.getAge(state);
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
