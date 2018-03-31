package com.marcus8448.mod.items;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.utils.IHasModel;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGlassSword extends ItemSword implements IHasModel {
 
    public ItemGlassSword(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);     
        this.setUnlocalizedName(name);
        this.setCreativeTab(Marcus8448Mod.marcus8448Tab);  
        Items.ITEMS.add(this);
        this.isDamageable();
        this.setMaxStackSize(1);
        this.setMaxDamage(0);
    }
    
 
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return false;
    }
 
    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {
        itemStack.damageItem(1, attacker);
        return true;
    }
    @Override
    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return blockIn.getBlock() == Blocks.WEB;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    @Override
    public void registerModels() {
        Marcus8448Mod.proxy.registerItemRenderer(this, 0, "");    
    }
    
 
}