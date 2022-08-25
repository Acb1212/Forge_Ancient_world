package net.Acb1212.AncWorld.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DNAItem extends Item {
    public DNAItem(Properties properties) {
        super(properties);
    }


    private void changeNbtDna(ItemStack pStack, String dinoName, int dinoPer, boolean isIdentified) {
        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("dinoName", dinoName);
        nbtData.putInt("dinoPer", dinoPer);
        nbtData.putBoolean("isIdentified", isIdentified);
        pStack.setTag(nbtData);

    }



    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level plevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        changeNbtDna(pStack,"Triceratops", 2, true);

        if(pStack.getTag().getBoolean("isIdentified")) {
            pTooltipComponents.add(Component.literal(pStack.getTag().getString("dinoName")));
            pTooltipComponents.add(Component.literal(pStack.getTag().getInt("dinoPer") + "%"));
        }
        else {}

    }
}
