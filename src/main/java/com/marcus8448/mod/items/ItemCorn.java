package com.marcus8448.mod.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.utils.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-0.0.0_preAlpha2
 *
 */
public class ItemCorn extends ItemFood implements IHasModel {

	public ItemCorn(String name, int amount, Float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Marcus8448Mod.marcus8448TabItems);
		MMItems.ITEMS.add(this);
		this.isFull3D();
		this.setAlwaysEdible();
		
		
	}
	
	@Override
	public void addInformation(ItemStack itemStack, World worldIn, List<String> list, ITooltipFlag flag) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add("Sweet fresh.. Tasty");
		} else {
			list.add("Press SHIFT for more info");
		}
		super.addInformation(itemStack, worldIn, list, flag);
	}
	
	@Override
	public void registerModels() {
		Marcus8448Mod.proxy.registerItemRenderer(this, 0, "");
	}
	
}
