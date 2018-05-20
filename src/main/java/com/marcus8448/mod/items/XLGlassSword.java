package com.marcus8448.mod.items;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.utils.IExtraReach;
import com.marcus8448.mod.utils.IHasModel;

import net.minecraft.item.ItemSword;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_Alpha
 *
 */
public class XLGlassSword extends ItemSword implements IHasModel, IExtraReach
{


    public XLGlassSword(String name, ToolMaterial mat)
    {
        super(mat);
        this.setCreativeTab(Marcus8448Mod.marcus8448TabItems);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        MMItems.ITEMS.add(this);
    }
    @Override
    public float getReach()
    {
        return 40.0F;
    }
	@Override
	public void registerModels() {
		Marcus8448Mod.proxy.registerItemRenderer(this, 0, "");
		
	}
}
