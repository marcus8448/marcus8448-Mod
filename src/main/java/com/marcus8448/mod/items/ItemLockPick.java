package com.marcus8448.mod.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.utils.IHaveModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha2
 *
 */
public class ItemLockPick extends Item implements IHaveModel {

	public ItemLockPick(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Marcus8448Mod.marcus8448TabItems);
		MMItems.ITEMS.add(this);
		this.isDamageable();
		this.setMaxDamage(0);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, World worldIn, List<String> list, ITooltipFlag flagIn) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add("*Chink* I'm in!");
		} else {
			list.add("Press SHIFT for more info");
		}
		super.addInformation(itemStack, worldIn, list, flagIn);
	}
	
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		itemstack.damageItem(100, playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public void registerModels() {
		Marcus8448Mod.proxy.registerItemRenderer(this, 0, "");
	}
	
}
