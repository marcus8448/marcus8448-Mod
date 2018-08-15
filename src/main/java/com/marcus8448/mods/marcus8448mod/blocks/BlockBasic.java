package com.marcus8448.mods.marcus8448mod.blocks;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.marcus8448.mods.marcus8448mod.Marcus8448Mod;
import com.marcus8448.mods.marcus8448mod.items.MMItems;
import com.marcus8448.mods.marcus8448mod.utils.IHaveModel;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha1
 *
 */
public class BlockBasic extends Block implements IHaveModel {

    String name = "";

    public BlockBasic(String name, Material material) {
        super(material);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(Marcus8448Mod.marcus8448TabBlocks);
        this.setSoundType(SoundType.WOOD);
        this.setHardness(10.0F);
        MMBlocks.BLOCKS.add(this);
        MMItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    /**
     * Adds the tooltip info
     */
    @Override
    public void addInformation(ItemStack itemStack, World worldIn, List<String> list, ITooltipFlag flag) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            list.add("So... Smooth");
        } else {
            list.add("Press SHIFT for more info");
        }
        super.addInformation(itemStack, worldIn, list, flag);
    }

    @Override
    public void registerModels() {
        Marcus8448Mod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "");
    }
}
