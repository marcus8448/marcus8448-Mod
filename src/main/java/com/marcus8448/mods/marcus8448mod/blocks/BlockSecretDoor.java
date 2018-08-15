package com.marcus8448.mods.marcus8448mod.blocks;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.marcus8448.mods.marcus8448mod.Marcus8448Mod;
import com.marcus8448.mods.marcus8448mod.items.MMItems;
import com.marcus8448.mods.marcus8448mod.utils.IHaveModel;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha3
 *
 */
public class BlockSecretDoor extends Block implements IHaveModel {

    public static int ticks = 0;

    public BlockSecretDoor(String name, Material material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(Marcus8448Mod.marcus8448TabBlocks);
        this.setSoundType(SoundType.METAL);
        this.setHardness(100F);
        this.setResistance(100F); // BLAST PROOF **BOOOOM** heh heh
        MMBlocks.BLOCKS.add(this);
        MMItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
            EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (!itemstack.isEmpty() && (itemstack.getItem() == MMItems.KEY)
                || (itemstack.getItem() == MMItems.LOCK_PICK) && !itemstack.isEmpty()) {
            if (playerIn != null) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                /*
                 * while (BlockSecretDoor.ticks < 1000) { ticks++; } BlockSecretDoor.ticks = 0;
                 * 
                 * //worldIn.setBlockState(pos, getDefaultState());
                 */
            }
        }
        return false;
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
