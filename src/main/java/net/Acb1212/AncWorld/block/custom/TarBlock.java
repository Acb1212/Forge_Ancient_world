package net.Acb1212.AncWorld.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

public class TarBlock extends Block {
    public TarBlock(Properties properties) {
        super(Properties.of(Material.WEB).noCollission().strength(10f));
    }

    public void entityInside(BlockState p_58180_, Level p_58181_, BlockPos p_58182_, Entity entity) {
        entity.hurt(DamageSource.IN_WALL, 1f);
        entity.makeStuckInBlock(p_58180_, new Vec3(0.5D, 0.5F, 0.5D));
    }


}
