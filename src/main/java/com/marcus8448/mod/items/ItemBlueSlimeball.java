package com.marcus8448.mod.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.utils.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlueSlimeball extends Item implements IHasModel {

	public ItemBlueSlimeball(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Marcus8448Mod.marcus8448Tab);
		Items.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, World worldIn, List<String> list, ITooltipFlag flagIn) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add("Blue slimey and fun!");
		} else {
			list.add("Press SHIFT for more info");
		}
		super.addInformation(itemStack, worldIn, list, flagIn);
	}
	
	@Override
	public void registerModels() {
		Marcus8448Mod.proxy.registerItemRenderer(this, 0, "");
	}
	
}
