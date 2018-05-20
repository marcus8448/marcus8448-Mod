package com.marcus8448.mod.items;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.utils.IHasModel;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-0.0.0_preAlpha2
 *
 */
public class ItemLightningShard extends Item implements IHasModel {
 
    public ItemLightningShard(String name) {
        this.setRegistryName(name);     
        this.setUnlocalizedName(name);
        this.setCreativeTab(Marcus8448Mod.marcus8448TabItems);  
        MMItems.ITEMS.add(this);

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