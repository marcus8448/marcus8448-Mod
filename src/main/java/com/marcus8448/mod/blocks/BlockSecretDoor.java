package com.marcus8448.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.items.Items;
import com.marcus8448.mod.utils.IHasModel;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSecretDoor extends Block implements IHasModel {
    
    public BlockSecretDoor(String name, Material material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(Marcus8448Mod.marcus8448Tab);
        this.setSoundType(SoundType.METAL);
        this.setHardness(100F);
        this.setResistance(100F); //BLAST PROOF
        
        Blocks.BLOCKS.add(this);
        Items.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    
     public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
        {
            ItemStack itemstack = playerIn.getHeldItem(hand);

            if (!itemstack.isEmpty() && (itemstack.getItem() == Items.KEY ) || (itemstack.getItem() == Items.LOCK_PICK ) && !itemstack.isEmpty())
            {
                worldIn.setBlockToAir(pos);
                     }
            return true;
        }
     
     public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, ITooltipFlag flag) {
         if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                list.add("Hehe, no one will see me behind here!");
                list.add("§c§lWARNING:§c One-time use!");
            } else {
                list.add("Press SHIFT for more info");
            }
        this.addInformation(stack, player, list, flag);
     }
     
     
    @Override
    public void registerModels() {
        Marcus8448Mod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "");
        
    }
             
}
