package com.marcus8448.mod.items;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.entity.projectile.EntityThrowableTNT;
import com.marcus8448.mod.utils.IHaveModel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemThrowableTNT extends Item implements IHaveModel  
{
    public ItemThrowableTNT(String name)
    {
    	MMItems.ITEMS.add(this);
        this.maxStackSize = 16;
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setFull3D();
        this.setCreativeTab(Marcus8448Mod.marcus8448TabItems);
    }

    @Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
    	double x = target.posX;
    	double y = target.posY;
    	double z = target.posZ;
    	target.world.createExplosion(target, x, y, z, 2.0F, true);
    	stack.shrink(1);
		return false;
    	
    }
    
    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            EntityThrowableTNT entityThrowableTNT = new EntityThrowableTNT(worldIn, playerIn);
            entityThrowableTNT.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3.5F, 1.0F);
            worldIn.spawnEntity(entityThrowableTNT);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
	@Override
	public void registerModels() {
		Marcus8448Mod.proxy.registerItemRenderer(this, 0, "");
	}
}