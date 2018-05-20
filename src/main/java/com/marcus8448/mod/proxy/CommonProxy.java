package com.marcus8448.mod.proxy;

import com.marcus8448.mod.handlers.RegistryHandler;

import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@SuppressWarnings("deprecation")
public class CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id)
	{
		
		
	}
	
	public String localize(String unlocalized, Object... args) {
		return I18n.translateToLocalFormatted(unlocalized, args);
		
	}
	
	public void preInit(FMLPreInitializationEvent e) {

        RegistryHandler.registerEntity();

	}

}