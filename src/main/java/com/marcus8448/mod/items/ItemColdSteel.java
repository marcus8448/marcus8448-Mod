package com.marcus8448.mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.marcus8448.mod.Marcus8448Mod;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha3
 *
 */
public class ItemColdSteel extends Item {

    public static String name;

    public ItemColdSteel(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        maxStackSize = 1;
        this.isDamageable();
        this.setMaxDamage(32);
        this.setCreativeTab(Marcus8448Mod.marcus8448TabItems);
        // MMItems.ITEMS.add(this); //TODO Textures + model
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos,
            EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        pos = pos.offset(facing);

        if (!playerIn.canPlayerEdit(pos, facing, stack)) {
            return EnumActionResult.FAIL;
        } else {
            if (worldIn.isAirBlock(pos)) {
                worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1.0F,
                        itemRand.nextFloat() * 0.4F + 1.8F);
                worldIn.setBlockState(pos, Blocks.ICE.getDefaultState(), 11);
            }
            stack.damageItem(1, playerIn);
            return EnumActionResult.SUCCESS;
        }
    }
}