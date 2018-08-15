package com.marcus8448.mod.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.utils.IHaveModel;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha1
 *
 */
public class ItemBlueSlimeball extends Item implements IHaveModel {

    public ItemBlueSlimeball(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(Marcus8448Mod.marcus8448TabItems);
        MMItems.ITEMS.add(this);
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
