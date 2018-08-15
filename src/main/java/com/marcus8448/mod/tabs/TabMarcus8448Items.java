package com.marcus8448.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.marcus8448.mod.items.MMItems;

/**
 * 
 * @since 1.12.2-1.0.0_preAlpha3
 * @author marcus8448 The class for the items tab
 *
 */
public class TabMarcus8448Items extends CreativeTabs {
    public TabMarcus8448Items() {
        super("tab_marcus8448_items");
        this.setBackgroundImageName("marcus8448_no_scroll.png");
        this.setNoScrollbar();
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(MMItems.BLUE_BOOK);
    }

}
