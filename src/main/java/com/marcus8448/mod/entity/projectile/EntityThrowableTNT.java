package com.marcus8448.mod.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityThrowableTNT extends EntityThrowable
{
    public EntityThrowableTNT(World worldIn)
    {
        super(worldIn);
        this.world.setEntityState(this, (byte)4);
    }

    public EntityThrowableTNT(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        this.world.setEntityState(this, (byte)4);
    }

    public EntityThrowableTNT(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
        this.world.setEntityState(this, (byte)4);
    }

    public static void registerFixesSnowball(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "TNTBall");
    }

/*    @SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 0.2D, 0.2D, 0.2D);
        this.world.spawnParticle(EnumParticleTypes.DRIP_LAVA, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    }
    
    /**
     * Handler for {@link World#setEntityState}
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {

        if (id == 3)
        {
            for (int i = 0; i < 100; ++i) {
                //world.spawnParticle(EnumParticleTypes.MOB_APPEARANCE, this.posX + 0.5F - world.rand.nextFloat(), this.posY + 0.5F - world.rand.nextFloat(), this.posZ + 0.5F - world.rand.nextFloat(), 40, 40, 40);
                world.spawnAlwaysVisibleParticle(11, chunkCoordX, chunkCoordY, chunkCoordZ, 20, 20, 20, 1);
            }
        }   
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
      if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)3);
            this.explode();
            this.setDead();
        }
    }
    private void explode()
    {
        this.world.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 8.0F, true);
    }
}