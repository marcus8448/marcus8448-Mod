package com.marcus8448.mods.marcus8448mod.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);

    }

}