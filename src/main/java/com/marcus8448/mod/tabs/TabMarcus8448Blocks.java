package com.marcus8448.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha3
 * The class for the blocks tab
 * 
 */
public class TabMarcus8448Blocks extends CreativeTabs {
    public TabMarcus8448Blocks() {
        super("tab_marcus8448_blocks");
        this.setBackgroundImageName("marcus8448_no_scroll.png");
        this.setNoScrollbar();
    }
    
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Blocks.BLUE_SHULKER_BOX);
    }


}
