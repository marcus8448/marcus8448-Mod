package com.marcus8448.mod.entity.projectile;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class BehaviorProjectileDispense extends BehaviorDefaultDispenseItem implements IBehaviorDispenseItem {
    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    @Override
    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        IPosition iposition = BlockDispenser.getDispensePosition(source);
        EnumFacing enumfacing = source.getBlockState().getValue(BlockDispenser.FACING);
        IProjectile iprojectile = this.getProjectileEntity(world, iposition, stack);
        iprojectile.shoot(enumfacing.getFrontOffsetX(), enumfacing.getFrontOffsetY() + 0.1F,
                enumfacing.getFrontOffsetZ(), this.getProjectileVelocity(), this.getProjectileInaccuracy());
        world.spawnEntity((Entity) iprojectile);
        stack.shrink(1);
        return stack;
    }

    /**
     * Play the dispense sound from the specified block.
     */
    @Override
    protected void playDispenseSound(IBlockSource source) {
        source.getWorld().playEvent(1002, source.getBlockPos(), 0);
    }

    /**
     * Return the projectile entity spawned by this dispense behavior.
     */
    protected abstract IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn);

    protected float getProjectileInaccuracy() {
        return 6.0F;
    }

    protected float getProjectileVelocity() {
        return 1.1F;
    }
}